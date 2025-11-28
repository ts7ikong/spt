import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '公司名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'code'
   },
   {
    title: '区县名称',
    align:"center",
    dataIndex: 'countryname_dictText'
   },
   {
    title: '所属园区',
    align:"center",
    dataIndex: 'yqType_dictText'
   },
   {
    title: '是否生产企业',
    align:"center",
    dataIndex: 'isScqy_dictText'
   },
   {
    title: '是否重大危险源企业',
    align:"center",
    dataIndex: 'isZdwxy_dictText'
   },
   {
    title: '是否统建双控企业',
    align:"center",
    dataIndex: 'isTjsk_dictText'
   },
   {
    title: '是否统建作业票企业',
    align:"center",
    dataIndex: 'isTjzyp_dictText'
   },
   {
    title: '企业类型',
    align:"center",
    dataIndex: 'companyTypeName_dictText'
   },
   {
    title: '企业作业票接入状态',
    align:"center",
    dataIndex: 'isCompanyTicket_dictText'
   },
   {
    title: '企业人员定位接入状态',
    align:"center",
    dataIndex: 'isCompanyAlarm_dictText'
   },
   {
    title: '双控是否接入',
    align:"center",
    dataIndex: 'isbuild_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "公司名称",
      field: 'name',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "区县名称",
      field: 'countryname',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"j_position_county,county_name,county_id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "所属园区",
      field: 'yqType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"ssyq"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否生产企业",
      field: 'isScqy',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否重大危险源企业",
      field: 'isZdwxy',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否统建双控企业",
      field: 'isTjsk',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否统建作业票企业",
      field: 'isTjzyp',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "企业作业票接入状态",
      field: 'isCompanyTicket',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfjr"
      },
      //colProps: {span: 6},
 	},
	{
      label: "企业人员定位接入状态",
      field: 'isCompanyAlarm',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfjr"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '公司名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '企业编码',
    field: 'code',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '区县名称',
    field: 'countryname',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"j_position_county,county_name,county_id"
     },
  },
  {
    label: '所属园区',
    field: 'yqType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"ssyq"
     },
  },
  {
    label: '是否生产企业',
    field: 'isScqy',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否重大危险源企业',
    field: 'isZdwxy',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否统建双控企业',
    field: 'isTjsk',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否统建作业票企业',
    field: 'isTjzyp',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '企业类型',
    field: 'companyTypeName',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qiyelx"
     },
  },
  {
    label: '企业作业票接入状态',
    field: 'isCompanyTicket',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfjr"
     },
  },
  {
    label: '企业人员定位接入状态',
    field: 'isCompanyAlarm',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfjr"
     },
  },
  {
    label: '双控是否接入',
    field: 'isbuild',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '化学品登记系统编码',
    field: 'nrccCode',
    component: 'Input',
  },
  {
    label: '父级企业名称',
    field: 'parentname',
    component: 'Input',
  },
  {
    label: '父级企业编码',
    field: 'parent',
    component: 'Input',
  },
  {
    label: '所属区县省编码',
    field: 'provincecode',
    component: 'Input',
  },
  {
    label: '省名称',
    field: 'provincename',
    component: 'Input',
  },
  {
    label: '所属区县城市编码',
    field: 'citycode',
    component: 'Input',
  },
  {
    label: '城市名称',
    field: 'cityname',
    component: 'Input',
  },
  {
    label: '所属区县区县编码',
    field: 'countycode',
    component: 'Input',
  },
  {
    label: '所属区县镇编码',
    field: 'towncode',
    component: 'Input',
  },
  {
    label: '镇名称',
    field: 'townname',
    component: 'Input',
  },
  {
    label: '详细地址',
    field: 'detail',
    component: 'Input',
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'InputNumber',
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputNumber',
  },
  {
    label: '统一社会信用编码',
    field: 'creditcode',
    component: 'Input',
  },
  {
    label: '法定代表人',
    field: 'legal',
    component: 'Input',
  },
  {
    label: '注册地址',
    field: 'address',
    component: 'Input',
  },
  {
    label: '企业秘钥',
    field: 'secretKey',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业秘钥!'},
          ];
     },
  },
  {
    label: '成立日期',
    field: 'setupday',
    component: 'Input',
  },
  {
    label: '主要负责人',
    field: 'safemainprincipal',
    component: 'Input',
  },
  {
    label: '主要负责人联系电话',
    field: 'safemainprincipalphone',
    component: 'Input',
  },
  {
    label: '安全负责人',
    field: 'safebranchedprincipal',
    component: 'Input',
  },
  {
    label: '安全负责人联系电话',
    field: 'safebranchedprincipalphone',
    component: 'Input',
  },
  {
    label: '企业规模',
    field: 'scale',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qygm"
     },
  },
  {
    label: '企业状态',
    field: 'companyState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qyzt"
     },
  },
  {
    label: '企业注册所在地地址',
    field: 'addressRegistry',
    component: 'Input',
  },
  {
    label: '企业负责人',
    field: 'responsiblePerson',
    component: 'Input',
  },
  {
    label: '安全负责人电话',
    field: 'safetyResponsiblePhone',
    component: 'Input',
  },
  {
    label: '安全值班室电话',
    field: 'dutyPhone',
    component: 'Input',
  },
  {
    label: '邮政编码',
    field: 'postCode',
    component: 'Input',
  },
  {
    label: '企业网址',
    field: 'webSite',
    component: 'Input',
  },
  {
    label: '企业类型',
    field: 'companyType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qiyelx"
     },
  },
  {
    label: '经营二级分类',
    field: 'businessType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jyejfl"
     },
  },
  {
    label: '进口二级分类',
    field: 'importType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jkejfl"
     },
  },
  {
    label: '涉及进口',
    field: 'isImport',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '经济类型',
    field: 'economicType',
    component: 'Input',
  },
  {
    label: '所属行业门类',
    field: 'industryCategory',
    component: 'Input',
  },
  {
    label: '所属行业大类',
    field: 'industryClass',
    component: 'Input',
  },
  {
    label: '营业执照经营范围',
    field: 'businessScope',
    component: 'InputTextArea',
  },
  {
    label: '安全生产标准化等级',
    field: 'safetyStandardGrad',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"aqscbzdj"
     },
  },
  {
    label: '安全生产许可证号',
    field: 'safetyLicenseNo',
    component: 'Input',
  },
  {
    label: '安全生产许可证有效期开始日期',
    field: 'safetyLicenseStart',
    component: 'Input',
  },
  {
    label: '安全生产许可证有效期结束日期',
    field: 'safetyLicenseEnd',
    component: 'Input',
  },
  {
    label: '职工人数',
    field: 'peopleEmployee',
    component: 'InputNumber',
  },
  {
    label: '从业人员人数',
    field: 'peoplePractitioner',
    component: 'InputNumber',
  },
  {
    label: '剧毒化学品作业人数',
    field: 'peopleToxic',
    component: 'InputNumber',
  },
  {
    label: '危险化学品作业人数',
    field: 'peopleHazard',
    component: 'InputNumber',
  },
  {
    label: '特种作业人数',
    field: 'peopleOperation',
    component: 'InputNumber',
  },
  {
    label: '是否在化工园区内',
    field: 'inIndustrialPark',
    component: 'Input',
  },
  {
    label: '企业状态',
    field: 'companyStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qyzt2"
     },
  },
  {
    label: '厂区面积',
    field: 'factoryArea',
    component: 'InputTextArea',
  },
  {
    label: '边界地理信息',
    field: 'rangeGeometryData',
    component: 'InputTextArea',
  },
  {
    label: '生产状态',
    field: 'productionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sczt"
     },
  },
  {
    label: '静默区域',
    field: 'personnelSlienceArea',
    component: 'InputTextArea',
  },
  {
    label: '是否取得安全生产许可证',
    field: 'isSafetyLicense',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否取得危险化学品经营许可证 ',
    field: 'isUseLicense',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '危险化学品使用许可证编号',
    field: 'useLicenseCode',
    component: 'Input',
  },
  {
    label: '危险化学品使用许可证开始日期',
    field: 'useLicenseBegin',
    component: 'Input',
  },
  {
    label: '危险化学品使用许可证结束日期',
    field: 'useLicenseEnd',
    component: 'Input',
  },
  {
    label: '危险化学品使用许可证初次申领日期',
    field: 'useLicenseFirstDate',
    component: 'Input',
  },
  {
    label: '危险化学品使用许可证发证机关',
    field: 'useLicenseGov',
    component: 'Input',
  },
  {
    label: '危险化学品生产许可证发证机关',
    field: 'safetyLicenseGov',
    component: 'Input',
  },
  {
    label: '安全生产标准化证书编号',
    field: 'safetyStandardCode',
    component: 'Input',
  },
  {
    label: '安全标准化等级认证时间',
    field: 'safetyStandardAuthDate',
    component: 'Input',
  },
  {
    label: '安全标准化等级认证机构',
    field: 'safetyStandardAuthMachiner',
    component: 'Input',
  },
  {
    label: '危险化学品生产许可证初次申领日期',
    field: 'safetyLicenseFirstDate',
    component: 'Input',
  },
  {
    label: '生产许可范围',
    field: 'safetyLicenseRange',
    component: 'InputTextArea',
  },
  {
    label: '危险化学品经营许可证编号',
    field: 'businessLicenseCode',
    component: 'Input',
  },
  {
    label: '是否危险化学品经营许可证',
    field: 'isBusinessLicense',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '危险化学品经营许可证开始日期',
    field: 'businessLicenseBegin',
    component: 'Input',
  },
  {
    label: '危险化学品经营许可证结束日期',
    field: 'businessLicenseEnd',
    component: 'Input',
  },
  {
    label: '经营许可范围',
    field: 'businessLicenseRange',
    component: 'Input',
  },
  {
    label: '危险化学品许可证首次申领日期',
    field: 'businessLicenseFirstDate',
    component: 'Input',
  },
  {
    label: '危险化学品经营许可证发证机关',
    field: 'businessLicenseGov',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '修改时间',
    field: 'updateDate',
    component: 'Input',
  },
  {
    label: '主键uuid',
    field: 'uuid',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '公司名称',order: 0,view: 'text', type: 'string',},
  code: {title: '企业编码',order: 1,view: 'text', type: 'string',},
  countryname: {title: '区县名称',order: 2,view: 'list', type: 'string',dictTable: "j_position_county", dictCode: 'county_id', dictText: 'county_name',},
  yqType: {title: '所属园区',order: 3,view: 'number', type: 'number',dictCode: 'ssyq',},
  isScqy: {title: '是否生产企业',order: 4,view: 'number', type: 'number',dictCode: 'sf',},
  isZdwxy: {title: '是否重大危险源企业',order: 5,view: 'number', type: 'number',dictCode: 'sf',},
  isTjsk: {title: '是否统建双控企业',order: 6,view: 'number', type: 'number',dictCode: 'sf',},
  isTjzyp: {title: '是否统建作业票企业',order: 7,view: 'number', type: 'number',dictCode: 'sf',},
  companyTypeName: {title: '企业类型',order: 8,view: 'list', type: 'string',dictCode: 'qiyelx',},
  isCompanyTicket: {title: '企业作业票接入状态',order: 9,view: 'number', type: 'number',dictCode: 'sfjr',},
  isCompanyAlarm: {title: '企业人员定位接入状态',order: 10,view: 'number', type: 'number',dictCode: 'sfjr',},
  isbuild: {title: '双控是否接入',order: 11,view: 'number', type: 'number',dictCode: 'sf',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}