package org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date: 2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("accept_company")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "accept_company对象", description = "企业基本信息")
public class AcceptCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 公司名称
     */
    @Excel(name = "公司名称", width = 15)
    @ApiModelProperty(value = "公司名称")
    private String name;
    /**
     * 企业编码
     */
    @Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private String code;
    /**
     * 区县名称
     */
    @Excel(name = "区县名称", width = 15, dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @Dict(dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @ApiModelProperty(value = "区县名称")
    private String countryname;
    /**
     * 所属园区
     */
    @Excel(name = "所属园区", width = 15, dicCode = "ssyq")
    @Dict(dicCode = "ssyq")
    @ApiModelProperty(value = "所属园区")
    private Integer yqType;
    /**
     * 是否生产企业
     */
    @Excel(name = "是否生产企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否生产企业")
    private Integer isScqy;
    /**
     * 是否重大危险源企业
     */
    @Excel(name = "是否重大危险源企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否重大危险源企业")
    private Integer isZdwxy;
    /**
     * 是否统建双控企业
     */
    @Excel(name = "是否统建双控企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否统建双控企业")
    private Integer isTjsk;
    /**
     * 是否统建作业票企业
     */
    @Excel(name = "是否统建作业票企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否统建作业票企业")
    private Integer isTjzyp;
    /**
     * 企业类型
     */
    @Excel(name = "企业类型", width = 15, dicCode = "qiyelx")
    @Dict(dicCode = "qiyelx")
    @ApiModelProperty(value = "企业类型")
    private String companyTypeName;
    /**
     * 企业作业票接入状态
     */
    @Excel(name = "企业作业票接入状态", width = 15, dicCode = "sfjr")
    @Dict(dicCode = "sfjr")
    @ApiModelProperty(value = "企业作业票接入状态")
    private Integer isCompanyTicket;
    /**
     * 企业人员定位接入状态
     */
    @Excel(name = "企业人员定位接入状态", width = 15, dicCode = "sfjr")
    @Dict(dicCode = "sfjr")
    @ApiModelProperty(value = "企业人员定位接入状态")
    private Integer isCompanyAlarm;
    /**
     * 双控是否接入
     */
    @Excel(name = "双控是否接入", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "双控是否接入")
    private Integer isbuild;
    /**
     * 所属园区
     */
    @Excel(name = "所属园区", width = 15)
    @ApiModelProperty(value = "所属园区")
    private String parkname;
    /**
     * 化学品登记系统编码
     */
    @Excel(name = "化学品登记系统编码", width = 15)
    @ApiModelProperty(value = "化学品登记系统编码")
    private String nrccCode;
    /**
     * 父级企业名称
     */
    @Excel(name = "父级企业名称", width = 15)
    @ApiModelProperty(value = "父级企业名称")
    private String parentname;
    /**
     * 父级企业编码
     */
    @Excel(name = "父级企业编码", width = 15)
    @ApiModelProperty(value = "父级企业编码")
    private String parent;
    /**
     * 所属区县省编码
     */
    @Excel(name = "所属区县省编码", width = 15)
    @ApiModelProperty(value = "所属区县省编码")
    private String provincecode;
    /**
     * 省名称
     */
    @Excel(name = "省名称", width = 15)
    @ApiModelProperty(value = "省名称")
    private String provincename;
    /**
     * 所属区县城市编码
     */
    @Excel(name = "所属区县城市编码", width = 15)
    @ApiModelProperty(value = "所属区县城市编码")
    private String citycode;
    /**
     * 城市名称
     */
    @Excel(name = "城市名称", width = 15)
    @ApiModelProperty(value = "城市名称")
    private String cityname;
    /**
     * 所属区县区县编码
     */
    @Excel(name = "所属区县区县编码", width = 15)
    @ApiModelProperty(value = "所属区县区县编码")
    private String countycode;
    /**
     * 所属区县镇编码
     */
    @Excel(name = "所属区县镇编码", width = 15)
    @ApiModelProperty(value = "所属区县镇编码")
    private String towncode;
    /**
     * 镇名称
     */
    @Excel(name = "镇名称", width = 15)
    @ApiModelProperty(value = "镇名称")
    private String townname;
    /**
     * 详细地址
     */
    @Excel(name = "详细地址", width = 15)
    @ApiModelProperty(value = "详细地址")
    private String detail;
    /**
     * 经度
     */
    @Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;
    /**
     * 纬度
     */
    @Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;
    /**
     * 行业
     */
    @Excel(name = "行业", width = 15, dicCode = "hy")
    @Dict(dicCode = "hy")
    @ApiModelProperty(value = "行业")
    private String industry;
    /**
     * 行业id
     */
    @Excel(name = "行业id", width = 15)
    @ApiModelProperty(value = "行业id")
    private Integer industryid;
    /**
     * 统一社会信用编码
     */
    @Excel(name = "统一社会信用编码", width = 15)
    @ApiModelProperty(value = "统一社会信用编码")
    private String creditcode;
    /**
     * 法定代表人
     */
    @Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private String legal;
    /**
     * 注册地址
     */
    @Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private String address;
    /**
     * 经营范围
     */
    @Excel(name = "经营范围", width = 15)
    @ApiModelProperty(value = "经营范围")
    private String scope;
    /**
     * 联系人
     */
    @Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private String linkman;
    /**
     * 联系电话
     */
    @Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private String linkphone;
    /**
     * 行政区域
     */
    @Excel(name = "行政区域", width = 15)
    @ApiModelProperty(value = "行政区域")
    private String subjectionname;
    /**
     * 备注
     */
    @Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String mark;
    /**
     * 缩放级别
     */
    @Excel(name = "缩放级别", width = 15)
    @ApiModelProperty(value = "缩放级别")
    private Double zoom;
    /**
     * app滚动地址
     */
    @Excel(name = "app滚动地址", width = 15)
    @ApiModelProperty(value = "app滚动地址")
    private String indexpic;
    /**
     * 级别
     */
    @Excel(name = "级别", width = 15, dicCode = "jb")
    @Dict(dicCode = "jb")
    @ApiModelProperty(value = "级别")
    private Integer level;
    /**
     * 所属园区编码
     */
    @Excel(name = "所属园区编码", width = 15)
    @ApiModelProperty(value = "所属园区编码")
    private String parkcode;
    /**
     * 是否为两江新区
     */
    @Excel(name = "是否为两江新区", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否为两江新区")
    private Integer isljxq;
    /**
     * 唯一所属监管行业id
     */
    @Excel(name = "唯一所属监管行业id", width = 15)
    @ApiModelProperty(value = "唯一所属监管行业id")
    private Integer beenindustryid;
    /**
     * 企业边界坐标
     */
    @Excel(name = "企业边界坐标", width = 15)
    @ApiModelProperty(value = "企业边界坐标")
    private String boundaries;
    /**
     * 中心点
     */
    @Excel(name = "中心点", width = 15)
    @ApiModelProperty(value = "中心点")
    private String mapcenter;
    /**
     * 边界缩放级别
     */
    @Excel(name = "边界缩放级别", width = 15)
    @ApiModelProperty(value = "边界缩放级别")
    private Double mapzoom;
    /**
     * 企业秘钥
     */
    @Excel(name = "企业秘钥", width = 15)
    @ApiModelProperty(value = "企业秘钥")
    private String secretKey;
    /**
     * token应急部
     */
    @Excel(name = "token应急部", width = 15)
    @ApiModelProperty(value = "token应急部")
    private String token;
    /**
     * 回执url
     */
    @Excel(name = "回执url", width = 15)
    @ApiModelProperty(value = "回执url")
    private String receiptUrl;
    /**
     * 得分
     */
    @Excel(name = "得分", width = 15)
    @ApiModelProperty(value = "得分")
    private BigDecimal score;
    /**
     * 运行等级
     */
    @Excel(name = "运行等级", width = 15, dicCode = "yxdj")
    @Dict(dicCode = "yxdj")
    @ApiModelProperty(value = "运行等级")
    private String runLevel;
    /**
     * 规则一
     */
    @Excel(name = "规则一", width = 15)
    @ApiModelProperty(value = "规则一")
    private String ruleOne;
    /**
     * 规则二
     */
    @Excel(name = "规则二", width = 15)
    @ApiModelProperty(value = "规则二")
    private String ruleTwo;
    /**
     * 规则三
     */
    @Excel(name = "规则三", width = 15)
    @ApiModelProperty(value = "规则三")
    private String ruleThree;
    /**
     * 上周隐患排查任务完成率
     */
    @Excel(name = "上周隐患排查任务完成率", width = 15)
    @ApiModelProperty(value = "上周隐患排查任务完成率")
    private String rateCheck;
    /**
     * 上周隐患整改率
     */
    @Excel(name = "上周隐患整改率", width = 15)
    @ApiModelProperty(value = "上周隐患整改率")
    private String rateDanger;
    /**
     * 排查任务得分
     */
    @Excel(name = "排查任务得分", width = 15)
    @ApiModelProperty(value = "排查任务得分")
    private BigDecimal screeTaskScore;
    /**
     * 包保责任制扣分
     */
    @Excel(name = "包保责任制扣分", width = 15)
    @ApiModelProperty(value = "包保责任制扣分")
    private BigDecimal coverageScore;
    /**
     * 隐患治理扣分
     */
    @Excel(name = "隐患治理扣分", width = 15)
    @ApiModelProperty(value = "隐患治理扣分")
    private BigDecimal hiddenGovernScore;
    /**
     * 隐患过少扣分
     */
    @Excel(name = "隐患过少扣分", width = 15)
    @ApiModelProperty(value = "隐患过少扣分")
    private BigDecimal hiddenFewScore;
    /**
     * 是否否决
     */
    @Excel(name = "是否否决", width = 15, dicCode = "sffj")
    @Dict(dicCode = "sffj")
    @ApiModelProperty(value = "是否否决")
    private Integer vetoItem;
    /**
     * 成立日期
     */
    @Excel(name = "成立日期", width = 15)
    @ApiModelProperty(value = "成立日期")
    private String setupday;
    /**
     * 主要负责人
     */
    @Excel(name = "主要负责人", width = 15)
    @ApiModelProperty(value = "主要负责人")
    private String safemainprincipal;
    /**
     * 主要负责人联系电话
     */
    @Excel(name = "主要负责人联系电话", width = 15)
    @ApiModelProperty(value = "主要负责人联系电话")
    private String safemainprincipalphone;
    /**
     * 安全负责人
     */
    @Excel(name = "安全负责人", width = 15)
    @ApiModelProperty(value = "安全负责人")
    private String safebranchedprincipal;
    /**
     * 安全负责人联系电话
     */
    @Excel(name = "安全负责人联系电话", width = 15)
    @ApiModelProperty(value = "安全负责人联系电话")
    private String safebranchedprincipalphone;
    /**
     * 企业规模
     */
    @Excel(name = "企业规模", width = 15, dicCode = "qygm")
    @Dict(dicCode = "qygm")
    @ApiModelProperty(value = "企业规模")
    private Integer scale;
    /**
     * 上年末从业人数
     */
    @Excel(name = "上年末从业人数", width = 15)
    @ApiModelProperty(value = "上年末从业人数")
    private Integer personnum;
    /**
     * 企业状态
     */
    @Excel(name = "企业状态", width = 15, dicCode = "qyzt")
    @Dict(dicCode = "qyzt")
    @ApiModelProperty(value = "企业状态")
    private Integer companyState;
    /**
     * 是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业
     */
    @Excel(name = "是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业", width = 15, dicCode = "sfsj")
    @Dict(dicCode = "sfsj")
    @ApiModelProperty(value = "是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业")
    private Integer involveState;
    /**
     * 企业性质
     */
    @Excel(name = "企业性质", width = 15)
    @ApiModelProperty(value = "企业性质")
    private Integer companyNature;
    /**
     * 企业推送全链条状态
     */
    @Excel(name = "企业推送全链条状态", width = 15, dicCode = "tszt")
    @Dict(dicCode = "tszt")
    @ApiModelProperty(value = "企业推送全链条状态")
    private Integer companyPushState;
    /**
     * 行业类型
     */
    @Excel(name = "行业类型", width = 15, dicCode = "hylx")
    @Dict(dicCode = "hylx")
    @ApiModelProperty(value = "行业类型")
    private Integer industryType;
    /**
     * 发证企业
     */
    @Excel(name = "发证企业", width = 15, dicCode = "fzqy")
    @Dict(dicCode = "fzqy")
    @ApiModelProperty(value = "发证企业")
    private Integer isFzqy;
    /**
     * 企业注册所在地地址
     */
    @Excel(name = "企业注册所在地地址", width = 15)
    @ApiModelProperty(value = "企业注册所在地地址")
    private String addressRegistry;
    /**
     * 企业负责人
     */
    @Excel(name = "企业负责人", width = 15)
    @ApiModelProperty(value = "企业负责人")
    private String responsiblePerson;
    /**
     * 安全负责人电话
     */
    @Excel(name = "安全负责人电话", width = 15)
    @ApiModelProperty(value = "安全负责人电话")
    private String safetyResponsiblePhone;
    /**
     * 安全值班室电话
     */
    @Excel(name = "安全值班室电话", width = 15)
    @ApiModelProperty(value = "安全值班室电话")
    private String dutyPhone;
    /**
     * 邮政编码
     */
    @Excel(name = "邮政编码", width = 15)
    @ApiModelProperty(value = "邮政编码")
    private String postCode;
    /**
     * 企业网址
     */
    @Excel(name = "企业网址", width = 15)
    @ApiModelProperty(value = "企业网址")
    private String webSite;
    /**
     * 企业类型
     */
    @Excel(name = "企业类型", width = 15, dicCode = "qiyelx")
    @Dict(dicCode = "qiyelx")
    @ApiModelProperty(value = "企业类型")
    private String companyType;
    /**
     * 经营二级分类
     */
    @Excel(name = "经营二级分类", width = 15, dicCode = "jyejfl")
    @Dict(dicCode = "jyejfl")
    @ApiModelProperty(value = "经营二级分类")
    private String businessType;
    /**
     * 进口二级分类
     */
    @Excel(name = "进口二级分类", width = 15, dicCode = "jkejfl")
    @Dict(dicCode = "jkejfl")
    @ApiModelProperty(value = "进口二级分类")
    private String importType;
    /**
     * 涉及进口
     */
    @Excel(name = "涉及进口", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "涉及进口")
    private String isImport;
    /**
     * 经济类型
     */
    @Excel(name = "经济类型", width = 15)
    @ApiModelProperty(value = "经济类型")
    private String economicType;
    /**
     * 所属行业门类
     */
    @Excel(name = "所属行业门类", width = 15)
    @ApiModelProperty(value = "所属行业门类")
    private String industryCategory;
    /**
     * 所属行业大类
     */
    @Excel(name = "所属行业大类", width = 15)
    @ApiModelProperty(value = "所属行业大类")
    private String industryClass;
    /**
     * 营业执照经营范围
     */
    @Excel(name = "营业执照经营范围", width = 15)
    @ApiModelProperty(value = "营业执照经营范围")
    private String businessScope;
    /**
     * 安全生产标准化等级
     */
    @Excel(name = "安全生产标准化等级", width = 15, dicCode = "aqscbzdj")
    @Dict(dicCode = "aqscbzdj")
    @ApiModelProperty(value = "安全生产标准化等级")
    private String safetyStandardGrad;
    /**
     * 安全生产许可证号
     */
    @Excel(name = "安全生产许可证号", width = 15)
    @ApiModelProperty(value = "安全生产许可证号")
    private String safetyLicenseNo;
    /**
     * 安全生产许可证有效期开始日期
     */
    @Excel(name = "安全生产许可证有效期开始日期", width = 15)
    @ApiModelProperty(value = "安全生产许可证有效期开始日期")
    private String safetyLicenseStart;
    /**
     * 安全生产许可证有效期结束日期
     */
    @Excel(name = "安全生产许可证有效期结束日期", width = 15)
    @ApiModelProperty(value = "安全生产许可证有效期结束日期")
    private String safetyLicenseEnd;
    /**
     * 职工人数
     */
    @Excel(name = "职工人数", width = 15)
    @ApiModelProperty(value = "职工人数")
    private Integer peopleEmployee;
    /**
     * 从业人员人数
     */
    @Excel(name = "从业人员人数", width = 15)
    @ApiModelProperty(value = "从业人员人数")
    private Integer peoplePractitioner;
    /**
     * 剧毒化学品作业人数
     */
    @Excel(name = "剧毒化学品作业人数", width = 15)
    @ApiModelProperty(value = "剧毒化学品作业人数")
    private Integer peopleToxic;
    /**
     * 危险化学品作业人数
     */
    @Excel(name = "危险化学品作业人数", width = 15)
    @ApiModelProperty(value = "危险化学品作业人数")
    private Integer peopleHazard;
    /**
     * 特种作业人数
     */
    @Excel(name = "特种作业人数", width = 15)
    @ApiModelProperty(value = "特种作业人数")
    private Integer peopleOperation;
    /**
     * 是否在化工园区内
     */
    @Excel(name = "是否在化工园区内", width = 15)
    @ApiModelProperty(value = "是否在化工园区内")
    private String inIndustrialPark;
    /**
     * 所属化工园区名称
     */
    @Excel(name = "所属化工园区名称", width = 15)
    @ApiModelProperty(value = "所属化工园区名称")
    private String industrialParkName;
    /**
     * 企业状态
     */
    @Excel(name = "企业状态", width = 15, dicCode = "qyzt2")
    @Dict(dicCode = "qyzt2")
    @ApiModelProperty(value = "企业状态")
    private String companyStatus;
    /**
     * 厂区面积
     */
    @Excel(name = "厂区面积", width = 15)
    @ApiModelProperty(value = "厂区面积")
    private String factoryArea;
    /**
     * 边界地理信息
     */
    @Excel(name = "边界地理信息", width = 15)
    @ApiModelProperty(value = "边界地理信息")
    private String rangeGeometryData;
    /**
     * 生产状态
     */
    @Excel(name = "生产状态", width = 15, dicCode = "sczt")
    @Dict(dicCode = "sczt")
    @ApiModelProperty(value = "生产状态")
    private String productionStatus;
    /**
     * 静默区域
     */
    @Excel(name = "静默区域", width = 15)
    @ApiModelProperty(value = "静默区域")
    private String personnelSlienceArea;
    /**
     * 是否取得安全生产许可证
     */
    @Excel(name = "是否取得安全生产许可证", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否取得安全生产许可证")
    private String isSafetyLicense;
    /**
     * 是否取得危险化学品经营许可证
     */
    @Excel(name = "是否取得危险化学品经营许可证 ", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否取得危险化学品经营许可证 ")
    private String isUseLicense;
    /**
     * 危险化学品使用许可证编号
     */
    @Excel(name = "危险化学品使用许可证编号", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证编号")
    private String useLicenseCode;
    /**
     * 危险化学品使用许可证开始日期
     */
    @Excel(name = "危险化学品使用许可证开始日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证开始日期")
    private String useLicenseBegin;
    /**
     * 危险化学品使用许可证结束日期
     */
    @Excel(name = "危险化学品使用许可证结束日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证结束日期")
    private String useLicenseEnd;
    /**
     * 危险化学品使用许可证初次申领日期
     */
    @Excel(name = "危险化学品使用许可证初次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证初次申领日期")
    private String useLicenseFirstDate;
    /**
     * 危险化学品使用许可证发证机关
     */
    @Excel(name = "危险化学品使用许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证发证机关")
    private String useLicenseGov;
    /**
     * 危险化学品生产许可证发证机关
     */
    @Excel(name = "危险化学品生产许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品生产许可证发证机关")
    private String safetyLicenseGov;
    /**
     * 安全生产标准化证书编号
     */
    @Excel(name = "安全生产标准化证书编号", width = 15)
    @ApiModelProperty(value = "安全生产标准化证书编号")
    private String safetyStandardCode;
    /**
     * 安全标准化等级认证时间
     */
    @Excel(name = "安全标准化等级认证时间", width = 15)
    @ApiModelProperty(value = "安全标准化等级认证时间")
    private String safetyStandardAuthDate;
    /**
     * 安全标准化等级认证机构
     */
    @Excel(name = "安全标准化等级认证机构", width = 15)
    @ApiModelProperty(value = "安全标准化等级认证机构")
    private String safetyStandardAuthMachiner;
    /**
     * 危险化学品生产许可证初次申领日期
     */
    @Excel(name = "危险化学品生产许可证初次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品生产许可证初次申领日期")
    private String safetyLicenseFirstDate;
    /**
     * 生产许可范围
     */
    @Excel(name = "生产许可范围", width = 15)
    @ApiModelProperty(value = "生产许可范围")
    private String safetyLicenseRange;
    /**
     * 危险化学品经营许可证编号
     */
    @Excel(name = "危险化学品经营许可证编号", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证编号")
    private String businessLicenseCode;
    /**
     * 是否危险化学品经营许可证
     */
    @Excel(name = "是否危险化学品经营许可证", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否危险化学品经营许可证")
    private String isBusinessLicense;
    /**
     * 危险化学品经营许可证开始日期
     */
    @Excel(name = "危险化学品经营许可证开始日期", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证开始日期")
    private String businessLicenseBegin;
    /**
     * 危险化学品经营许可证结束日期
     */
    @Excel(name = "危险化学品经营许可证结束日期", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证结束日期")
    private String businessLicenseEnd;
    /**
     * 经营许可范围
     */
    @Excel(name = "经营许可范围", width = 15)
    @ApiModelProperty(value = "经营许可范围")
    private String businessLicenseRange;
    /**
     * 危险化学品许可证首次申领日期
     */
    @Excel(name = "危险化学品许可证首次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品许可证首次申领日期")
    private String businessLicenseFirstDate;
    /**
     * 危险化学品经营许可证发证机关
     */
    @Excel(name = "危险化学品经营许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证发证机关")
    private String businessLicenseGov;
    /**
     * 删除标志
     */
    @Excel(name = "删除标志", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private Integer deleted;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private String createDate;
    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    private String createBy;
    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private String updateDate;
    /**
     * 修改人姓名
     */
    @ApiModelProperty(value = "修改人姓名")
    private String updateBy;
    /**
     * 主键uuid
     */
    @Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private String uuid;
    /**
     * 进表时间
     */
    @ApiModelProperty(value = "进表时间")
    private String createTime;
    /**
     * 企业负责人电话
     */
    @Excel(name = "企业负责人电话", width = 15)
    @ApiModelProperty(value = "企业负责人电话")
    private String responsibleMoble;
    /**
     * 安全负责人手机
     */
    @Excel(name = "安全负责人手机", width = 15)
    @ApiModelProperty(value = "安全负责人手机")
    private String safetyResponsibleMoble;
    /**
     * 企业负责人手机
     */
    @Excel(name = "企业负责人手机", width = 15)
    @ApiModelProperty(value = "企业负责人手机")
    private String responsiblePhone;
    /**
     * 批次编号(我们返给企业的)
     */
    @Excel(name = "批次编号(我们返给企业的)", width = 15)
    @ApiModelProperty(value = "批次编号(我们返给企业的)")
    private String wbatchId;
    /**
     * 应急部返回的批次id
     */
    @Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private String batchId;
}
