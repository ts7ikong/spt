package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity;

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
    private java.lang.Integer id;
    /**
     * 公司名称
     */
    @Excel(name = "公司名称", width = 15)
    @ApiModelProperty(value = "公司名称")
    private java.lang.String name;
    /**
     * 企业编码
     */
    @Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String code;
    /**
     * 区县名称
     */
    @Excel(name = "区县名称", width = 15, dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @Dict(dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @ApiModelProperty(value = "区县名称")
    private java.lang.String countryname;
    /**
     * 所属园区
     */
    @Excel(name = "所属园区", width = 15, dicCode = "ssyq")
    @Dict(dicCode = "ssyq")
    @ApiModelProperty(value = "所属园区")
    private java.lang.Integer yqType;
    /**
     * 是否生产企业
     */
    @Excel(name = "是否生产企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否生产企业")
    private java.lang.Integer isScqy;
    /**
     * 是否重大危险源企业
     */
    @Excel(name = "是否重大危险源企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否重大危险源企业")
    private java.lang.Integer isZdwxy;
    /**
     * 是否统建双控企业
     */
    @Excel(name = "是否统建双控企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否统建双控企业")
    private java.lang.Integer isTjsk;
    /**
     * 是否统建作业票企业
     */
    @Excel(name = "是否统建作业票企业", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否统建作业票企业")
    private java.lang.Integer isTjzyp;
    /**
     * 企业类型
     */
    @Excel(name = "企业类型", width = 15, dicCode = "qiyelx")
    @Dict(dicCode = "qiyelx")
    @ApiModelProperty(value = "企业类型")
    private java.lang.String companyTypeName;
    /**
     * 企业作业票接入状态
     */
    @Excel(name = "企业作业票接入状态", width = 15, dicCode = "sfjr")
    @Dict(dicCode = "sfjr")
    @ApiModelProperty(value = "企业作业票接入状态")
    private java.lang.Integer isCompanyTicket;
    /**
     * 企业人员定位接入状态
     */
    @Excel(name = "企业人员定位接入状态", width = 15, dicCode = "sfjr")
    @Dict(dicCode = "sfjr")
    @ApiModelProperty(value = "企业人员定位接入状态")
    private java.lang.Integer isCompanyAlarm;
    /**
     * 双控是否接入
     */
    @Excel(name = "双控是否接入", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "双控是否接入")
    private java.lang.Integer isbuild;
    /**
     * 所属园区
     */
    @Excel(name = "所属园区", width = 15)
    @ApiModelProperty(value = "所属园区")
    private java.lang.String parkname;
    /**
     * 化学品登记系统编码
     */
    @Excel(name = "化学品登记系统编码", width = 15)
    @ApiModelProperty(value = "化学品登记系统编码")
    private java.lang.String nrccCode;
    /**
     * 父级企业名称
     */
    @Excel(name = "父级企业名称", width = 15)
    @ApiModelProperty(value = "父级企业名称")
    private java.lang.String parentname;
    /**
     * 父级企业编码
     */
    @Excel(name = "父级企业编码", width = 15)
    @ApiModelProperty(value = "父级企业编码")
    private java.lang.String parent;
    /**
     * 所属区县省编码
     */
    @Excel(name = "所属区县省编码", width = 15)
    @ApiModelProperty(value = "所属区县省编码")
    private java.lang.String provincecode;
    /**
     * 省名称
     */
    @Excel(name = "省名称", width = 15)
    @ApiModelProperty(value = "省名称")
    private java.lang.String provincename;
    /**
     * 所属区县城市编码
     */
    @Excel(name = "所属区县城市编码", width = 15)
    @ApiModelProperty(value = "所属区县城市编码")
    private java.lang.String citycode;
    /**
     * 城市名称
     */
    @Excel(name = "城市名称", width = 15)
    @ApiModelProperty(value = "城市名称")
    private java.lang.String cityname;
    /**
     * 所属区县区县编码
     */
    @Excel(name = "所属区县区县编码", width = 15)
    @ApiModelProperty(value = "所属区县区县编码")
    private java.lang.String countycode;
    /**
     * 所属区县镇编码
     */
    @Excel(name = "所属区县镇编码", width = 15)
    @ApiModelProperty(value = "所属区县镇编码")
    private java.lang.String towncode;
    /**
     * 镇名称
     */
    @Excel(name = "镇名称", width = 15)
    @ApiModelProperty(value = "镇名称")
    private java.lang.String townname;
    /**
     * 详细地址
     */
    @Excel(name = "详细地址", width = 15)
    @ApiModelProperty(value = "详细地址")
    private java.lang.String detail;
    /**
     * 经度
     */
    @Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.math.BigDecimal longitude;
    /**
     * 纬度
     */
    @Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.math.BigDecimal latitude;
    /**
     * 行业
     */
    @Excel(name = "行业", width = 15, dicCode = "hy")
    @Dict(dicCode = "hy")
    @ApiModelProperty(value = "行业")
    private java.lang.String industry;
    /**
     * 行业id
     */
    @Excel(name = "行业id", width = 15)
    @ApiModelProperty(value = "行业id")
    private java.lang.Integer industryid;
    /**
     * 统一社会信用编码
     */
    @Excel(name = "统一社会信用编码", width = 15)
    @ApiModelProperty(value = "统一社会信用编码")
    private java.lang.String creditcode;
    /**
     * 法定代表人
     */
    @Excel(name = "法定代表人", width = 15)
    @ApiModelProperty(value = "法定代表人")
    private java.lang.String legal;
    /**
     * 注册地址
     */
    @Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private java.lang.String address;
    /**
     * 经营范围
     */
    @Excel(name = "经营范围", width = 15)
    @ApiModelProperty(value = "经营范围")
    private java.lang.String scope;
    /**
     * 联系人
     */
    @Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String linkman;
    /**
     * 联系电话
     */
    @Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String linkphone;
    /**
     * 行政区域
     */
    @Excel(name = "行政区域", width = 15)
    @ApiModelProperty(value = "行政区域")
    private java.lang.String subjectionname;
    /**
     * 备注
     */
    @Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String mark;
    /**
     * 缩放级别
     */
    @Excel(name = "缩放级别", width = 15)
    @ApiModelProperty(value = "缩放级别")
    private java.lang.Double zoom;
    /**
     * app滚动地址
     */
    @Excel(name = "app滚动地址", width = 15)
    @ApiModelProperty(value = "app滚动地址")
    private java.lang.String indexpic;
    /**
     * 级别
     */
    @Excel(name = "级别", width = 15, dicCode = "jb")
    @Dict(dicCode = "jb")
    @ApiModelProperty(value = "级别")
    private java.lang.Integer level;
    /**
     * 所属园区编码
     */
    @Excel(name = "所属园区编码", width = 15)
    @ApiModelProperty(value = "所属园区编码")
    private java.lang.String parkcode;
    /**
     * 是否为两江新区
     */
    @Excel(name = "是否为两江新区", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否为两江新区")
    private java.lang.Integer isljxq;
    /**
     * 唯一所属监管行业id
     */
    @Excel(name = "唯一所属监管行业id", width = 15)
    @ApiModelProperty(value = "唯一所属监管行业id")
    private java.lang.Integer beenindustryid;
    /**
     * 企业边界坐标
     */
    @Excel(name = "企业边界坐标", width = 15)
    @ApiModelProperty(value = "企业边界坐标")
    private java.lang.String boundaries;
    /**
     * 中心点
     */
    @Excel(name = "中心点", width = 15)
    @ApiModelProperty(value = "中心点")
    private java.lang.String mapcenter;
    /**
     * 边界缩放级别
     */
    @Excel(name = "边界缩放级别", width = 15)
    @ApiModelProperty(value = "边界缩放级别")
    private java.lang.Double mapzoom;
    /**
     * 企业秘钥
     */
    @Excel(name = "企业秘钥", width = 15)
    @ApiModelProperty(value = "企业秘钥")
    private java.lang.String secretKey;
    /**
     * token应急部
     */
    @Excel(name = "token应急部", width = 15)
    @ApiModelProperty(value = "token应急部")
    private java.lang.String token;
    /**
     * 回执url
     */
    @Excel(name = "回执url", width = 15)
    @ApiModelProperty(value = "回执url")
    private java.lang.String receiptUrl;
    /**
     * 得分
     */
    @Excel(name = "得分", width = 15)
    @ApiModelProperty(value = "得分")
    private java.math.BigDecimal score;
    /**
     * 运行等级
     */
    @Excel(name = "运行等级", width = 15, dicCode = "yxdj")
    @Dict(dicCode = "yxdj")
    @ApiModelProperty(value = "运行等级")
    private java.lang.String runLevel;
    /**
     * 规则一
     */
    @Excel(name = "规则一", width = 15)
    @ApiModelProperty(value = "规则一")
    private java.lang.String ruleOne;
    /**
     * 规则二
     */
    @Excel(name = "规则二", width = 15)
    @ApiModelProperty(value = "规则二")
    private java.lang.String ruleTwo;
    /**
     * 规则三
     */
    @Excel(name = "规则三", width = 15)
    @ApiModelProperty(value = "规则三")
    private java.lang.String ruleThree;
    /**
     * 上周隐患排查任务完成率
     */
    @Excel(name = "上周隐患排查任务完成率", width = 15)
    @ApiModelProperty(value = "上周隐患排查任务完成率")
    private java.lang.String rateCheck;
    /**
     * 上周隐患整改率
     */
    @Excel(name = "上周隐患整改率", width = 15)
    @ApiModelProperty(value = "上周隐患整改率")
    private java.lang.String rateDanger;
    /**
     * 排查任务得分
     */
    @Excel(name = "排查任务得分", width = 15)
    @ApiModelProperty(value = "排查任务得分")
    private java.math.BigDecimal screeTaskScore;
    /**
     * 包保责任制扣分
     */
    @Excel(name = "包保责任制扣分", width = 15)
    @ApiModelProperty(value = "包保责任制扣分")
    private java.math.BigDecimal coverageScore;
    /**
     * 隐患治理扣分
     */
    @Excel(name = "隐患治理扣分", width = 15)
    @ApiModelProperty(value = "隐患治理扣分")
    private java.math.BigDecimal hiddenGovernScore;
    /**
     * 隐患过少扣分
     */
    @Excel(name = "隐患过少扣分", width = 15)
    @ApiModelProperty(value = "隐患过少扣分")
    private java.math.BigDecimal hiddenFewScore;
    /**
     * 是否否决
     */
    @Excel(name = "是否否决", width = 15, dicCode = "sffj")
    @Dict(dicCode = "sffj")
    @ApiModelProperty(value = "是否否决")
    private java.lang.Integer vetoItem;
    /**
     * 成立日期
     */
    @Excel(name = "成立日期", width = 15)
    @ApiModelProperty(value = "成立日期")
    private java.lang.String setupday;
    /**
     * 主要负责人
     */
    @Excel(name = "主要负责人", width = 15)
    @ApiModelProperty(value = "主要负责人")
    private java.lang.String safemainprincipal;
    /**
     * 主要负责人联系电话
     */
    @Excel(name = "主要负责人联系电话", width = 15)
    @ApiModelProperty(value = "主要负责人联系电话")
    private java.lang.String safemainprincipalphone;
    /**
     * 安全负责人
     */
    @Excel(name = "安全负责人", width = 15)
    @ApiModelProperty(value = "安全负责人")
    private java.lang.String safebranchedprincipal;
    /**
     * 安全负责人联系电话
     */
    @Excel(name = "安全负责人联系电话", width = 15)
    @ApiModelProperty(value = "安全负责人联系电话")
    private java.lang.String safebranchedprincipalphone;
    /**
     * 企业规模
     */
    @Excel(name = "企业规模", width = 15, dicCode = "qygm")
    @Dict(dicCode = "qygm")
    @ApiModelProperty(value = "企业规模")
    private java.lang.Integer scale;
    /**
     * 上年末从业人数
     */
    @Excel(name = "上年末从业人数", width = 15)
    @ApiModelProperty(value = "上年末从业人数")
    private java.lang.Integer personnum;
    /**
     * 企业状态
     */
    @Excel(name = "企业状态", width = 15, dicCode = "qyzt")
    @Dict(dicCode = "qyzt")
    @ApiModelProperty(value = "企业状态")
    private java.lang.Integer companyState;
    /**
     * 是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业
     */
    @Excel(name = "是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业", width = 15, dicCode = "sfsj")
    @Dict(dicCode = "sfsj")
    @ApiModelProperty(value = "是否涉及一、二级重大危险源企业和重点监管危化化工工艺企业")
    private java.lang.Integer involveState;
    /**
     * 企业性质
     */
    @Excel(name = "企业性质", width = 15)
    @ApiModelProperty(value = "企业性质")
    private java.lang.Integer companyNature;
    /**
     * 企业推送全链条状态
     */
    @Excel(name = "企业推送全链条状态", width = 15, dicCode = "tszt")
    @Dict(dicCode = "tszt")
    @ApiModelProperty(value = "企业推送全链条状态")
    private java.lang.Integer companyPushState;
    /**
     * 行业类型
     */
    @Excel(name = "行业类型", width = 15, dicCode = "hylx")
    @Dict(dicCode = "hylx")
    @ApiModelProperty(value = "行业类型")
    private java.lang.Integer industryType;
    /**
     * 发证企业
     */
    @Excel(name = "发证企业", width = 15, dicCode = "fzqy")
    @Dict(dicCode = "fzqy")
    @ApiModelProperty(value = "发证企业")
    private java.lang.Integer isFzqy;
    /**
     * 企业注册所在地地址
     */
    @Excel(name = "企业注册所在地地址", width = 15)
    @ApiModelProperty(value = "企业注册所在地地址")
    private java.lang.String addressRegistry;
    /**
     * 企业负责人
     */
    @Excel(name = "企业负责人", width = 15)
    @ApiModelProperty(value = "企业负责人")
    private java.lang.String responsiblePerson;
    /**
     * 安全负责人电话
     */
    @Excel(name = "安全负责人电话", width = 15)
    @ApiModelProperty(value = "安全负责人电话")
    private java.lang.String safetyResponsiblePhone;
    /**
     * 安全值班室电话
     */
    @Excel(name = "安全值班室电话", width = 15)
    @ApiModelProperty(value = "安全值班室电话")
    private java.lang.String dutyPhone;
    /**
     * 邮政编码
     */
    @Excel(name = "邮政编码", width = 15)
    @ApiModelProperty(value = "邮政编码")
    private java.lang.String postCode;
    /**
     * 企业网址
     */
    @Excel(name = "企业网址", width = 15)
    @ApiModelProperty(value = "企业网址")
    private java.lang.String webSite;
    /**
     * 企业类型
     */
    @Excel(name = "企业类型", width = 15, dicCode = "qiyelx")
    @Dict(dicCode = "qiyelx")
    @ApiModelProperty(value = "企业类型")
    private java.lang.String companyType;
    /**
     * 经营二级分类
     */
    @Excel(name = "经营二级分类", width = 15, dicCode = "jyejfl")
    @Dict(dicCode = "jyejfl")
    @ApiModelProperty(value = "经营二级分类")
    private java.lang.String businessType;
    /**
     * 进口二级分类
     */
    @Excel(name = "进口二级分类", width = 15, dicCode = "jkejfl")
    @Dict(dicCode = "jkejfl")
    @ApiModelProperty(value = "进口二级分类")
    private java.lang.String importType;
    /**
     * 涉及进口
     */
    @Excel(name = "涉及进口", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "涉及进口")
    private java.lang.String isImport;
    /**
     * 经济类型
     */
    @Excel(name = "经济类型", width = 15)
    @ApiModelProperty(value = "经济类型")
    private java.lang.String economicType;
    /**
     * 所属行业门类
     */
    @Excel(name = "所属行业门类", width = 15)
    @ApiModelProperty(value = "所属行业门类")
    private java.lang.String industryCategory;
    /**
     * 所属行业大类
     */
    @Excel(name = "所属行业大类", width = 15)
    @ApiModelProperty(value = "所属行业大类")
    private java.lang.String industryClass;
    /**
     * 营业执照经营范围
     */
    @Excel(name = "营业执照经营范围", width = 15)
    @ApiModelProperty(value = "营业执照经营范围")
    private java.lang.String businessScope;
    /**
     * 安全生产标准化等级
     */
    @Excel(name = "安全生产标准化等级", width = 15, dicCode = "aqscbzdj")
    @Dict(dicCode = "aqscbzdj")
    @ApiModelProperty(value = "安全生产标准化等级")
    private java.lang.String safetyStandardGrad;
    /**
     * 安全生产许可证号
     */
    @Excel(name = "安全生产许可证号", width = 15)
    @ApiModelProperty(value = "安全生产许可证号")
    private java.lang.String safetyLicenseNo;
    /**
     * 安全生产许可证有效期开始日期
     */
    @Excel(name = "安全生产许可证有效期开始日期", width = 15)
    @ApiModelProperty(value = "安全生产许可证有效期开始日期")
    private java.lang.String safetyLicenseStart;
    /**
     * 安全生产许可证有效期结束日期
     */
    @Excel(name = "安全生产许可证有效期结束日期", width = 15)
    @ApiModelProperty(value = "安全生产许可证有效期结束日期")
    private java.lang.String safetyLicenseEnd;
    /**
     * 职工人数
     */
    @Excel(name = "职工人数", width = 15)
    @ApiModelProperty(value = "职工人数")
    private java.lang.Integer peopleEmployee;
    /**
     * 从业人员人数
     */
    @Excel(name = "从业人员人数", width = 15)
    @ApiModelProperty(value = "从业人员人数")
    private java.lang.Integer peoplePractitioner;
    /**
     * 剧毒化学品作业人数
     */
    @Excel(name = "剧毒化学品作业人数", width = 15)
    @ApiModelProperty(value = "剧毒化学品作业人数")
    private java.lang.Integer peopleToxic;
    /**
     * 危险化学品作业人数
     */
    @Excel(name = "危险化学品作业人数", width = 15)
    @ApiModelProperty(value = "危险化学品作业人数")
    private java.lang.Integer peopleHazard;
    /**
     * 特种作业人数
     */
    @Excel(name = "特种作业人数", width = 15)
    @ApiModelProperty(value = "特种作业人数")
    private java.lang.Integer peopleOperation;
    /**
     * 是否在化工园区内
     */
    @Excel(name = "是否在化工园区内", width = 15)
    @ApiModelProperty(value = "是否在化工园区内")
    private java.lang.String inIndustrialPark;
    /**
     * 所属化工园区名称
     */
    @Excel(name = "所属化工园区名称", width = 15)
    @ApiModelProperty(value = "所属化工园区名称")
    private java.lang.String industrialParkName;
    /**
     * 企业状态
     */
    @Excel(name = "企业状态", width = 15, dicCode = "qyzt2")
    @Dict(dicCode = "qyzt2")
    @ApiModelProperty(value = "企业状态")
    private java.lang.String companyStatus;
    /**
     * 厂区面积
     */
    @Excel(name = "厂区面积", width = 15)
    @ApiModelProperty(value = "厂区面积")
    private java.lang.String factoryArea;
    /**
     * 边界地理信息
     */
    @Excel(name = "边界地理信息", width = 15)
    @ApiModelProperty(value = "边界地理信息")
    private java.lang.String rangeGeometryData;
    /**
     * 生产状态
     */
    @Excel(name = "生产状态", width = 15, dicCode = "sczt")
    @Dict(dicCode = "sczt")
    @ApiModelProperty(value = "生产状态")
    private java.lang.String productionStatus;
    /**
     * 静默区域
     */
    @Excel(name = "静默区域", width = 15)
    @ApiModelProperty(value = "静默区域")
    private java.lang.String personnelSlienceArea;
    /**
     * 是否取得安全生产许可证
     */
    @Excel(name = "是否取得安全生产许可证", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否取得安全生产许可证")
    private java.lang.String isSafetyLicense;
    /**
     * 是否取得危险化学品经营许可证
     */
    @Excel(name = "是否取得危险化学品经营许可证 ", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否取得危险化学品经营许可证 ")
    private java.lang.String isUseLicense;
    /**
     * 危险化学品使用许可证编号
     */
    @Excel(name = "危险化学品使用许可证编号", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证编号")
    private java.lang.String useLicenseCode;
    /**
     * 危险化学品使用许可证开始日期
     */
    @Excel(name = "危险化学品使用许可证开始日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证开始日期")
    private java.lang.String useLicenseBegin;
    /**
     * 危险化学品使用许可证结束日期
     */
    @Excel(name = "危险化学品使用许可证结束日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证结束日期")
    private java.lang.String useLicenseEnd;
    /**
     * 危险化学品使用许可证初次申领日期
     */
    @Excel(name = "危险化学品使用许可证初次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证初次申领日期")
    private java.lang.String useLicenseFirstDate;
    /**
     * 危险化学品使用许可证发证机关
     */
    @Excel(name = "危险化学品使用许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品使用许可证发证机关")
    private java.lang.String useLicenseGov;
    /**
     * 危险化学品生产许可证发证机关
     */
    @Excel(name = "危险化学品生产许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品生产许可证发证机关")
    private java.lang.String safetyLicenseGov;
    /**
     * 安全生产标准化证书编号
     */
    @Excel(name = "安全生产标准化证书编号", width = 15)
    @ApiModelProperty(value = "安全生产标准化证书编号")
    private java.lang.String safetyStandardCode;
    /**
     * 安全标准化等级认证时间
     */
    @Excel(name = "安全标准化等级认证时间", width = 15)
    @ApiModelProperty(value = "安全标准化等级认证时间")
    private java.lang.String safetyStandardAuthDate;
    /**
     * 安全标准化等级认证机构
     */
    @Excel(name = "安全标准化等级认证机构", width = 15)
    @ApiModelProperty(value = "安全标准化等级认证机构")
    private java.lang.String safetyStandardAuthMachiner;
    /**
     * 危险化学品生产许可证初次申领日期
     */
    @Excel(name = "危险化学品生产许可证初次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品生产许可证初次申领日期")
    private java.lang.String safetyLicenseFirstDate;
    /**
     * 生产许可范围
     */
    @Excel(name = "生产许可范围", width = 15)
    @ApiModelProperty(value = "生产许可范围")
    private java.lang.String safetyLicenseRange;
    /**
     * 危险化学品经营许可证编号
     */
    @Excel(name = "危险化学品经营许可证编号", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证编号")
    private java.lang.String businessLicenseCode;
    /**
     * 是否危险化学品经营许可证
     */
    @Excel(name = "是否危险化学品经营许可证", width = 15, dicCode = "sf")
    @Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否危险化学品经营许可证")
    private java.lang.String isBusinessLicense;
    /**
     * 危险化学品经营许可证开始日期
     */
    @Excel(name = "危险化学品经营许可证开始日期", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证开始日期")
    private java.lang.String businessLicenseBegin;
    /**
     * 危险化学品经营许可证结束日期
     */
    @Excel(name = "危险化学品经营许可证结束日期", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证结束日期")
    private java.lang.String businessLicenseEnd;
    /**
     * 经营许可范围
     */
    @Excel(name = "经营许可范围", width = 15)
    @ApiModelProperty(value = "经营许可范围")
    private java.lang.String businessLicenseRange;
    /**
     * 危险化学品许可证首次申领日期
     */
    @Excel(name = "危险化学品许可证首次申领日期", width = 15)
    @ApiModelProperty(value = "危险化学品许可证首次申领日期")
    private java.lang.String businessLicenseFirstDate;
    /**
     * 危险化学品经营许可证发证机关
     */
    @Excel(name = "危险化学品经营许可证发证机关", width = 15)
    @ApiModelProperty(value = "危险化学品经营许可证发证机关")
    private java.lang.String businessLicenseGov;
    /**
     * 删除标志
     */
    @Excel(name = "删除标志", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.Integer deleted;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
    /**
     * 修改人姓名
     */
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
    /**
     * 主键uuid
     */
    @Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private java.lang.String uuid;
    /**
     * 进表时间
     */
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
    /**
     * 企业负责人电话
     */
    @Excel(name = "企业负责人电话", width = 15)
    @ApiModelProperty(value = "企业负责人电话")
    private java.lang.String responsibleMoble;
    /**
     * 安全负责人手机
     */
    @Excel(name = "安全负责人手机", width = 15)
    @ApiModelProperty(value = "安全负责人手机")
    private java.lang.String safetyResponsibleMoble;
    /**
     * 企业负责人手机
     */
    @Excel(name = "企业负责人手机", width = 15)
    @ApiModelProperty(value = "企业负责人手机")
    private java.lang.String responsiblePhone;
    /**
     * 批次编号(我们返给企业的)
     */
    @Excel(name = "批次编号(我们返给企业的)", width = 15)
    @ApiModelProperty(value = "批次编号(我们返给企业的)")
    private java.lang.String wbatchId;
    /**
     * 应急部返回的批次id
     */
    @Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
}
