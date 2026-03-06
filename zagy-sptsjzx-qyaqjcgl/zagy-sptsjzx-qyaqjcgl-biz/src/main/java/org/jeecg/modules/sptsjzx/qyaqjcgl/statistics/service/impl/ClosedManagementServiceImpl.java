package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatClosedManagementCache;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatClosedManagementCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.ClosedManagementMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IClosedManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ClosedManagementServiceImpl implements IClosedManagementService {

    @Autowired
    private ClosedManagementMapper mapper;

    @Autowired
    private StatClosedManagementCacheMapper cacheMapper;

    @Override
    public ClosedManagementStatisticsDTO getClosedManagementStatistics(
            List<String> yqCodes,
            String timeRange) {

        String tr = Optional.ofNullable(timeRange).orElse("today");

        // 1. 优先读预聚合缓存表（毫秒级）
        List<StatClosedManagementCache> cacheRows = cacheMapper.queryByFilter(yqCodes, tr);
        if (cacheRows != null && !cacheRows.isEmpty()) {
            return aggregateFromCache(cacheRows);
        }

        // 2. 缓存未命中（首次部署、表未建等），降级为实时并行查询
        log.warn("[ClosedManagement] 缓存未命中，降级为实时查询 yqCodes.size={}, timeRange={}", yqCodes.size(), tr);
        return computeRealtime(yqCodes, tr);
    }

    // -------------------------------------------------------------------------
    // 从缓存行聚合 DTO（每行是一个园区的预计算结果，只需做加法）
    // -------------------------------------------------------------------------
    private ClosedManagementStatisticsDTO aggregateFromCache(List<StatClosedManagementCache> rows) {
        int fullAccessCount = 0, partialAccessCount = 0, notAccessCount = 0;
        long gateCount = 0, hazardousVehicleCount = 0, otherVehicleCount = 0, visitorCount = 0;
        long generalCargo = 0, hazardousTransport = 0, smallVehicle = 0, emergencyVehicle = 0;
        long registeredPersonnel = 0, visitorPersonnel = 0;
        long alarmIntrusion = 0, alarmSpeed = 0, alarmHelp = 0, alarmStay = 0, alarmOther = 0;

        for (StatClosedManagementCache r : rows) {
            int moduleCount = val(r.getStaticModuleCount())
                    + val(r.getHasClsstx())
                    + val(r.getHasRysstx())
                    + val(r.getHasSbbjsj());

            if (moduleCount == 10) fullAccessCount++;
            else if (moduleCount > 0) partialAccessCount++;
            else notAccessCount++;

            gateCount              += val(r.getGateCount());
            hazardousVehicleCount  += val(r.getHazardousVehicleCount());
            otherVehicleCount      += val(r.getOtherVehicleCount());
            visitorCount           += val(r.getVisitorCount());
            generalCargo           += val(r.getGeneralCargoCount());
            hazardousTransport     += val(r.getHazardousTransportCount());
            smallVehicle           += val(r.getSmallVehicleCount());
            emergencyVehicle       += val(r.getEmergencyVehicleCount());
            registeredPersonnel    += val(r.getRegisteredPersonnelCount());
            visitorPersonnel       += val(r.getVisitorPersonnelCount());
            alarmIntrusion         += val(r.getAlarmIntrusion());
            alarmSpeed             += val(r.getAlarmSpeed());
            alarmHelp              += val(r.getAlarmHelp());
            alarmStay              += val(r.getAlarmStay());
            alarmOther             += val(r.getAlarmOther());
        }

        return buildDto(fullAccessCount, partialAccessCount, notAccessCount,
                gateCount, hazardousVehicleCount, otherVehicleCount, visitorCount,
                generalCargo, hazardousTransport, smallVehicle, emergencyVehicle,
                registeredPersonnel, visitorPersonnel,
                alarmIntrusion, alarmSpeed, alarmHelp, alarmStay, alarmOther);
    }

    // -------------------------------------------------------------------------
    // 实时并行查询（降级路径，与原有逻辑一致）
    // -------------------------------------------------------------------------
    private ClosedManagementStatisticsDTO computeRealtime(List<String> yqCodes, String timeRange) {
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
            case "month":
                startTime = now.toLocalDate().minusDays(29).atStartOfDay();
                endTime = now.toLocalDate().plusDays(1).atStartOfDay();
                break;
            default:
                throw new IllegalArgumentException("不支持的时间范围: " + timeRange);
        }

        final LocalDateTime st = startTime, et = endTime;

        CompletableFuture<List<Map<String, Object>>> f1 = CompletableFuture.supplyAsync(
                () -> mapper.getStaticInfoByPark(yqCodes));
        CompletableFuture<List<Map<String, Object>>> f2 = CompletableFuture.supplyAsync(
                () -> mapper.getVehicleTrafficByPark(yqCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f3 = CompletableFuture.supplyAsync(
                () -> mapper.getPersonnelTrafficByPark(yqCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f4 = CompletableFuture.supplyAsync(
                () -> mapper.getAlarmStatsByPark(yqCodes));
        CompletableFuture.allOf(f1, f2, f3, f4).join();

        Map<String, Map<String, Object>> vehicleMap   = toMapByPark(f2.join());
        Map<String, Map<String, Object>> personnelMap = toMapByPark(f3.join());
        Map<String, Map<String, Object>> alarmMap     = toMapByPark(f4.join());

        int fullAccessCount = 0, partialAccessCount = 0, notAccessCount = 0;
        long gateCount = 0, hazardousVehicleCount = 0, otherVehicleCount = 0, visitorCount = 0;
        long generalCargo = 0, hazardousTransport = 0, smallVehicle = 0, emergencyVehicle = 0;
        long registeredPersonnel = 0, visitorPersonnel = 0;
        long alarmIntrusion = 0, alarmSpeed = 0, alarmHelp = 0, alarmStay = 0, alarmOther = 0;

        List<Map<String, Object>> staticList = f1.join();
        if (staticList != null) {
            for (Map<String, Object> row : staticList) {
                String parkCode = (String) row.get("park_code");
                Map<String, Object> v = vehicleMap.getOrDefault(parkCode, Collections.emptyMap());
                Map<String, Object> p = personnelMap.getOrDefault(parkCode, Collections.emptyMap());
                Map<String, Object> a = alarmMap.getOrDefault(parkCode, Collections.emptyMap());

                int moduleCount = getIntValue(row.get("staticModuleCount"))
                        + getIntValue(v.get("has_clsstx"))
                        + getIntValue(p.get("has_rysstx"))
                        + getIntValue(a.get("has_sbbjsj"));

                if (moduleCount == 10) fullAccessCount++;
                else if (moduleCount > 0) partialAccessCount++;
                else notAccessCount++;

                gateCount             += getIntValue(row.get("gateCount"));
                hazardousVehicleCount += getIntValue(row.get("hazardousVehicleCount"));
                otherVehicleCount     += getIntValue(row.get("otherVehicleCount"));
                visitorCount          += getIntValue(row.get("visitorCount"));
                generalCargo          += getIntValue(v.get("generalCargoCount"));
                hazardousTransport    += getIntValue(v.get("hazardousTransportCount"));
                smallVehicle          += getIntValue(v.get("smallVehicleCount"));
                emergencyVehicle      += getIntValue(v.get("emergencyVehicleCount"));
                registeredPersonnel   += getIntValue(p.get("registeredPersonnelCount"));
                visitorPersonnel      += getIntValue(p.get("visitorPersonnelCount"));
                alarmIntrusion        += getIntValue(a.get("alarm_intrusion"));
                alarmSpeed            += getIntValue(a.get("alarm_speed"));
                alarmHelp             += getIntValue(a.get("alarm_help"));
                alarmStay             += getIntValue(a.get("alarm_stay"));
                alarmOther            += getIntValue(a.get("alarm_other"));
            }
        }

        return buildDto(fullAccessCount, partialAccessCount, notAccessCount,
                gateCount, hazardousVehicleCount, otherVehicleCount, visitorCount,
                generalCargo, hazardousTransport, smallVehicle, emergencyVehicle,
                registeredPersonnel, visitorPersonnel,
                alarmIntrusion, alarmSpeed, alarmHelp, alarmStay, alarmOther);
    }

    // -------------------------------------------------------------------------
    // 共用组装 DTO
    // -------------------------------------------------------------------------
    private ClosedManagementStatisticsDTO buildDto(
            int fullAccess, int partialAccess, int notAccess,
            long gateCount, long hazardousVehicleCount, long otherVehicleCount, long visitorCount,
            long generalCargo, long hazardousTransport, long smallVehicle, long emergencyVehicle,
            long registeredPersonnel, long visitorPersonnel,
            long alarmIntrusion, long alarmSpeed, long alarmHelp, long alarmStay, long alarmOther) {

        ClosedManagementStatisticsDTO dto = new ClosedManagementStatisticsDTO();

        List<Map<String, Object>> accessStatusStats = new ArrayList<>();
        accessStatusStats.add(createItem("全部已接入", fullAccess));
        accessStatusStats.add(createItem("部分已接入", partialAccess));
        accessStatusStats.add(createItem("未接入", notAccess));
        dto.setAccessStatusStats(accessStatusStats);

        List<Map<String, Object>> alarmTypeStats = new ArrayList<>();
        addIfPositive(alarmTypeStats, "入侵报警", alarmIntrusion);
        addIfPositive(alarmTypeStats, "超速报警", alarmSpeed);
        addIfPositive(alarmTypeStats, "求救报警", alarmHelp);
        addIfPositive(alarmTypeStats, "滞留报警", alarmStay);
        addIfPositive(alarmTypeStats, "其他",     alarmOther);
        dto.setAlarmTypeStats(alarmTypeStats);

        ClosedManagementStatisticsDTO.BasicInfoStats basic = new ClosedManagementStatisticsDTO.BasicInfoStats();
        basic.setGateCount((int) gateCount);
        basic.setHazardousVehicleCount((int) hazardousVehicleCount);
        basic.setOtherVehicleCount((int) otherVehicleCount);
        basic.setVisitorCount((int) visitorCount);
        dto.setBasicInfoStats(basic);

        ClosedManagementStatisticsDTO.TrafficStats traffic = new ClosedManagementStatisticsDTO.TrafficStats();
        traffic.setGeneralCargoCount((int) generalCargo);
        traffic.setHazardousTransportCount((int) hazardousTransport);
        traffic.setSmallVehicleCount((int) smallVehicle);
        traffic.setEmergencyVehicleCount((int) emergencyVehicle);
        traffic.setRegisteredPersonnelCount((int) registeredPersonnel);
        traffic.setVisitorPersonnelCount((int) visitorPersonnel);
        dto.setTrafficStats(traffic);

        return dto;
    }

    // -------------------------------------------------------------------------
    // 工具方法
    // -------------------------------------------------------------------------
    private int val(Integer v) {
        return v == null ? 0 : v;
    }

    private Map<String, Map<String, Object>> toMapByPark(List<Map<String, Object>> list) {
        if (list == null) return Collections.emptyMap();
        Map<String, Map<String, Object>> result = new HashMap<>(list.size() * 2);
        for (Map<String, Object> row : list) {
            Object key = row.get("park_code");
            if (key != null) result.put(key.toString(), row);
        }
        return result;
    }

    private int getIntValue(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void addIfPositive(List<Map<String, Object>> list, String name, long value) {
        if (value > 0) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name);
            item.put("value", (int) value);
            list.add(item);
        }
    }

    private Map<String, Object> createItem(String name, int value) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("value", value);
        return map;
    }
}
