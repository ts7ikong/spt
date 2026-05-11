package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.job;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatClosedManagementCache;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatClosedManagementCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.ClosedManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * 封闭化管理统计缓存刷新定时任务
 *
 * 启动后 30 秒执行首次刷新（消除冷启动问题），之后每 10 分钟刷新一次。
 * 对全部园区的 today / week / month 三个时间维度并行预计算，
 * 结果写入 stat_closed_management_cache 表。
 */
@Slf4j
@Component
@ConditionalOnBean(RedissonLockClient.class)
public class ClosedManagementCacheJob {

    @Autowired
    private ClosedManagementMapper closedMapper;

    @Autowired
    private StatClosedManagementCacheMapper cacheMapper;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    @Autowired
    private RedissonLockClient redissonLock;

    private static final String LOCK_KEY    = "cache:job:closedManagement";
    private static final int    LOCK_EXPIRE = 9 * 60; // 9分钟，小于 fixedRate

    @Scheduled(initialDelay = 30_000, fixedRate = 10 * 60_000)
    public void refresh() {
        if (!redissonLock.tryLock(LOCK_KEY, -1, LOCK_EXPIRE)) {
            log.debug("[ClosedManagementCacheJob] 未获取到锁，跳过本次刷新");
            return;
        }
        try {
            doRefresh();
        } finally {
            redissonLock.unlock(LOCK_KEY);
        }
    }

    // 把 List<Map> 转成 parkCode -> count 的映射
    private Map<String, Long> toCountMap(List<Map<String, Object>> list) {
        if (list == null) return Collections.emptyMap();
        Map<String, Long> result = new HashMap<>();
        for (Map<String, Object> row : list) {
            String code = (String) row.get("park_code");
            Long cnt = ((Number) row.get("cnt")).longValue();
            result.put(code, cnt);
        }
        return result;
    }

    private void doRefresh() {
        List<String> allParkCodes = acceptCompanyService.getYqCodesByCountyCode(null);
        if (allParkCodes == null || allParkCodes.isEmpty()) {
            log.warn("[ClosedManagementCacheJob] 无园区数据，跳过刷新");
            return;
        }
        log.info("[ClosedManagementCacheJob] 开始刷新，园区数量: {}", allParkCodes.size());
        long start = System.currentTimeMillis();

        for (String tr : new String[]{"today", "week", "month"}) {
            try {
                refreshTimeRange(allParkCodes, tr);
            } catch (Exception e) {
                log.error("[ClosedManagementCacheJob] 刷新 timeRange={} 失败", tr, e);
            }
        }
        log.info("[ClosedManagementCacheJob] 刷新完成，耗时 {}ms", System.currentTimeMillis() - start);
    }

    private void refreshTimeRange(List<String> parkCodes, String timeRange) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime, endTime;
        switch (timeRange) {
            case "today":
                startTime = now.toLocalDate().atStartOfDay();
                endTime = startTime.plusDays(1);
                break;
            case "week":
                startTime = now.toLocalDate().minusDays(6).atStartOfDay();
                endTime = now.toLocalDate().plusDays(1).atStartOfDay();
                break;
            default: // month
                startTime = now.toLocalDate().minusDays(29).atStartOfDay();
                endTime = now.toLocalDate().plusDays(1).atStartOfDay();
        }

        final LocalDateTime st = startTime, et = endTime;

        // 4 个查询并行跑，与现有 ServiceImpl 逻辑一致
        CompletableFuture<Map<String, Long>> kkmjF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.kkmjxx", parkCodes)));
        CompletableFuture<Map<String, Long>> fkxxF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.fkxx", parkCodes)));
        CompletableFuture<Map<String, Long>> whpclF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.whpclxx", parkCodes)));
        CompletableFuture<Map<String, Long>> qtclF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.qtclxx", parkCodes)));
        CompletableFuture<Map<String, Long>> tccF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.whpyscltccxx", parkCodes)));
        CompletableFuture<Map<String, Long>> ryssdwF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.ryssdw", parkCodes)));
        CompletableFuture<Map<String, Long>> whpclssdwF = CompletableFuture.supplyAsync(
                () -> toCountMap(closedMapper.countGroupByPark("shipingtaishujuzhongxin.whpclssdw", parkCodes)));

        CompletableFuture<List<Map<String, Object>>> f2 = CompletableFuture.supplyAsync(
                () -> closedMapper.getVehicleTrafficByPark(parkCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f3 = CompletableFuture.supplyAsync(
                () -> closedMapper.getPersonnelTrafficByPark(parkCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f4 = CompletableFuture.supplyAsync(
                () -> closedMapper.getAlarmStatsByPark(parkCodes));

        CompletableFuture.allOf(kkmjF, fkxxF, whpclF, qtclF, tccF, ryssdwF, whpclssdwF, f2, f3, f4).join();

        Map<String, Long> kkmjMap      = kkmjF.join();
        Map<String, Long> fkxxMap      = fkxxF.join();
        Map<String, Long> whpclMap     = whpclF.join();
        Map<String, Long> qtclMap      = qtclF.join();
        Map<String, Long> tccMap       = tccF.join();
        Map<String, Long> ryssdwMap    = ryssdwF.join();
        Map<String, Long> whpclssdwMap = whpclssdwF.join();
        Map<String, Map<String, Object>> vehicleMap   = toMap(f2.join());
        Map<String, Map<String, Object>> personnelMap = toMap(f3.join());
        Map<String, Map<String, Object>> alarmMap     = toMap(f4.join());

        if (parkCodes == null || parkCodes.isEmpty()) return;

        List<StatClosedManagementCache> rows = new ArrayList<>(parkCodes.size());
        for (String parkCode : parkCodes) {
            long kkmjCnt      = kkmjMap.getOrDefault(parkCode, 0L);
            long fkxxCnt      = fkxxMap.getOrDefault(parkCode, 0L);
            long whpclCnt     = whpclMap.getOrDefault(parkCode, 0L);
            long qtclCnt      = qtclMap.getOrDefault(parkCode, 0L);
            long tccCnt       = tccMap.getOrDefault(parkCode, 0L);
            long ryssdwCnt    = ryssdwMap.getOrDefault(parkCode, 0L);
            long whpclssdwCnt = whpclssdwMap.getOrDefault(parkCode, 0L);

            Map<String, Object> v = vehicleMap.getOrDefault(parkCode, Collections.emptyMap());
            Map<String, Object> p = personnelMap.getOrDefault(parkCode, Collections.emptyMap());
            Map<String, Object> a = alarmMap.getOrDefault(parkCode, Collections.emptyMap());

            StatClosedManagementCache cache = new StatClosedManagementCache();
            cache.setParkCode(parkCode);
            cache.setTimeRange(timeRange);
            // 7项各自有数据则+1
            int moduleCount = (kkmjCnt > 0 ? 1 : 0) + (fkxxCnt > 0 ? 1 : 0)
                    + (whpclCnt > 0 ? 1 : 0) + (qtclCnt > 0 ? 1 : 0)
                    + (tccCnt > 0 ? 1 : 0) + (ryssdwCnt > 0 ? 1 : 0)
                    + (whpclssdwCnt > 0 ? 1 : 0);
            cache.setStaticModuleCount(moduleCount);
            cache.setGateCount((int) kkmjCnt);
            cache.setHazardousVehicleCount((int) whpclCnt);
            cache.setOtherVehicleCount((int) qtclCnt);
            cache.setVisitorCount((int) fkxxCnt);
            // v / p / a 的字段赋值保持不变
            cache.setHasClsstx(num(v.get("has_clsstx")));
            cache.setGeneralCargoCount(num(v.get("generalCargoCount")));
            cache.setHazardousTransportCount(num(v.get("hazardousTransportCount")));
            cache.setSmallVehicleCount(num(v.get("smallVehicleCount")));
            cache.setEmergencyVehicleCount(num(v.get("emergencyVehicleCount")));
            cache.setHasRysstx(num(p.get("has_rysstx")));
            cache.setRegisteredPersonnelCount(num(p.get("registeredPersonnelCount")));
            cache.setVisitorPersonnelCount(num(p.get("visitorPersonnelCount")));
            cache.setHasSbbjsj(num(a.get("has_sbbjsj")));
            cache.setAlarmIntrusion(num(a.get("alarm_intrusion")));
            cache.setAlarmSpeed(num(a.get("alarm_speed")));
            cache.setAlarmHelp(num(a.get("alarm_help")));
            cache.setAlarmStay(num(a.get("alarm_stay")));
            cache.setAlarmOther(num(a.get("alarm_other")));
            rows.add(cache);
        }

        cacheMapper.batchUpsert(rows);
        log.debug("[ClosedManagementCacheJob] timeRange={} 刷新完成，写入 {} 行", timeRange, rows.size());
    }

    private Map<String, Map<String, Object>> toMap(List<Map<String, Object>> list) {
        if (list == null) return Collections.emptyMap();
        Map<String, Map<String, Object>> result = new HashMap<>(list.size() * 2);
        for (Map<String, Object> row : list) {
            Object key = row.get("park_code");
            if (key != null) result.put(key.toString(), row);
        }
        return result;
    }

    private int num(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
