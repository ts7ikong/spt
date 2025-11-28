import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: 'UUID',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '事故编号',
    align:"center",
    dataIndex: 'accidentCode'
   },
   {
    title: '预案编码',
    align:"center",
    dataIndex: 'emergencePlanId_dictText'
   },
   {
    title: '应急资源编码',
    align:"center",
    dataIndex: 'materialId_dictText'
   },
   {
    title: '应急队伍编码',
    align:"center",
    dataIndex: 'unitId_dictText'
   },
   {
    title: '避难场所编码',
    align:"center",
    dataIndex: 'shelterId_dictText'
   },
   {
    title: '机构编码',
    align:"center",
    dataIndex: 'institutionId_dictText'
   },
   {
    title: '接警编码',
    align:"center",
    dataIndex: 'serialCode_dictText'
   },
   {
    title: '专家编码',
    align:"center",
    dataIndex: 'expertId_dictText'
   },
   {
    title: '事故日期时间',
    align:"center",
    dataIndex: 'accidentTime'
   },
   {
    title: '事故概况',
    align:"center",
    dataIndex: 'accidentOverview'
   },
   {
    title: '现场图片',
    align:"center",
    dataIndex: 'annex',
    customRender:render.renderImage,
   },
   {
    title: '总指挥',
    align:"center",
    dataIndex: 'generalCommander'
   },
   {
    title: '副总指挥',
    align:"center",
    dataIndex: 'deputyCommander'
   },
   {
    title: '现场指挥长',
    align:"center",
    dataIndex: 'onSiteCommander'
   },
   {
    title: '现场副指挥长',
    align:"center",
    dataIndex: 'deputyOnSiteCommander'
   },
   {
    title: '现场响应小组',
    align:"center",
    dataIndex: 'responseTeam'
   },
   {
    title: '现场处置措施建议',
    align:"center",
    dataIndex: 'dispositionGuidance'
   },
   {
    title: '个体防护处置建议',
    align:"center",
    dataIndex: 'personalprotectionGuidance'
   },
   {
    title: '其他注意事项',
    align:"center",
    dataIndex: 'note'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
   {
    title: '创建日期_企业',
    align:"center",
    dataIndex: 'createTimeCompany'
   },
   {
    title: '创建人_企业',
    align:"center",
    dataIndex: 'createByCompany'
   },
   {
    title: '更新日期_企业',
    align:"center",
    dataIndex: 'updateTimeCompany'
   },
   {
    title: '更新人_企业',
    align:"center",
    dataIndex: 'updateByCompany'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "UUID",
    field: "uuid",
    component: 'JInput',
  },
  {
    label: "事故编号",
    field: "accidentCode",
    component: 'JInput',
  },
	{
      label: "预案编码",
      field: 'emergencePlanId',
      component: 'JSearchSelect',
      componentProps:{
         dict:"yjyaxx,emergence_plan_name,emergence_plan_id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "应急资源编码",
      field: 'materialId',
      component: 'JSelectMultiple',
      componentProps:{
        dictCode:"yjwzjcxx,material_name,material_id",
        triggerChange: true
     },
      //colProps: {span: 6},
 	},
	{
      label: "应急队伍编码",
      field: 'unitId',
      component: 'JSelectMultiple',
      componentProps:{
        dictCode:"yjjydwxx,unit_name,unit_id",
        triggerChange: true
     },
      //colProps: {span: 6},
 	},
	{
      label: "避难场所编码",
      field: 'shelterId',
      component: 'JSelectMultiple',
      componentProps:{
        dictCode:"yjblcsxx,shelter_name,shelter_id",
        triggerChange: true
     },
      //colProps: {span: 6},
 	},
	{
      label: "机构编码",
      field: 'institutionId',
      component: 'JSelectMultiple',
      componentProps:{
        dictCode:"ylzyxx,institution_name,institution_id",
        triggerChange: true
     },
      //colProps: {span: 6},
 	},
	{
      label: "接警编码",
      field: 'serialCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jjjl,accident_name,serial_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "专家编码",
      field: 'expertId',
      component: 'JSelectMultiple',
      componentProps:{
        dictCode:"yjzjxx,expert_name,expert_id",
        triggerChange: true
     },
      //colProps: {span: 6},
 	},
     {
      label: "事故日期时间",
      field: "accidentTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
  {
    label: "总指挥",
    field: "generalCommander",
    component: 'JInput',
  },
  {
    label: "副总指挥",
    field: "deputyCommander",
    component: 'JInput',
  },
  {
    label: "现场指挥长",
    field: "onSiteCommander",
    component: 'JInput',
  },
  {
    label: "现场副指挥长",
    field: "deputyOnSiteCommander",
    component: 'JInput',
  },
	{
      label: "删除标志",
      field: 'deleted',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"scbz"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '园区编码',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: 'UUID',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入UUID!'},
          ];
     },
  },
  {
    label: '事故编号',
    field: 'accidentCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故编号!'},
          ];
     },
  },
  {
    label: '预案编码',
    field: 'emergencePlanId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"yjyaxx,emergence_plan_name,emergence_plan_id"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入预案编码!'},
          ];
     },
  },
  {
    label: '应急资源编码',
    field: 'materialId',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"yjwzjcxx,material_name,material_id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入应急资源编码!'},
          ];
     },
  },
  {
    label: '应急队伍编码',
    field: 'unitId',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"yjjydwxx,unit_name,unit_id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入应急队伍编码!'},
          ];
     },
  },
  {
    label: '避难场所编码',
    field: 'shelterId',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"yjblcsxx,shelter_name,shelter_id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入避难场所编码!'},
          ];
     },
  },
  {
    label: '机构编码',
    field: 'institutionId',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"ylzyxx,institution_name,institution_id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入机构编码!'},
          ];
     },
  },
  {
    label: '接警编码',
    field: 'serialCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjjl,accident_name,serial_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接警编码!'},
          ];
     },
  },
  {
    label: '专家编码',
    field: 'expertId',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"yjzjxx,expert_name,expert_id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入专家编码!'},
          ];
     },
  },
  {
    label: '事故日期时间',
    field: 'accidentTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故日期时间!'},
          ];
     },
  },
  {
    label: '事故概况',
    field: 'accidentOverview',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故概况!'},
          ];
     },
  },
  {
    label: '现场图片',
    field: 'annex',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场图片!'},
          ];
     },
  },
  {
    label: '总指挥',
    field: 'generalCommander',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总指挥!'},
          ];
     },
  },
  {
    label: '副总指挥',
    field: 'deputyCommander',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入副总指挥!'},
          ];
     },
  },
  {
    label: '现场指挥长',
    field: 'onSiteCommander',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场指挥长!'},
          ];
     },
  },
  {
    label: '现场副指挥长',
    field: 'deputyOnSiteCommander',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场副指挥长!'},
          ];
     },
  },
  {
    label: '现场响应小组',
    field: 'responseTeam',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场响应小组!'},
          ];
     },
  },
  {
    label: '现场处置措施建议',
    field: 'dispositionGuidance',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场处置措施建议!'},
          ];
     },
  },
  {
    label: '个体防护处置建议',
    field: 'personalprotectionGuidance',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入个体防护处置建议!'},
          ];
     },
  },
  {
    label: '其他注意事项',
    field: 'note',
    component: 'Input',
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"scbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标志!'},
          ];
     },
  },
  {
    label: '创建日期_企业',
    field: 'createTimeCompany',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '创建人_企业',
    field: 'createByCompany',
    component: 'Input',
  },
  {
    label: '更新日期_企业',
    field: 'updateTimeCompany',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新人_企业',
    field: 'updateByCompany',
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
  parkCode: {title: '园区编码',order: 0,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  uuid: {title: 'UUID',order: 1,view: 'text', type: 'string',},
  accidentCode: {title: '事故编号',order: 2,view: 'text', type: 'string',},
  emergencePlanId: {title: '预案编码',order: 3,view: 'sel_search', type: 'string',dictTable: "yjyaxx", dictCode: 'emergence_plan_id', dictText: 'emergence_plan_name',},
  materialId: {title: '应急资源编码',order: 4,view: 'list_multi', type: 'string',dictTable: "yjwzjcxx", dictCode: 'material_id', dictText: 'material_name',},
  unitId: {title: '应急队伍编码',order: 5,view: 'list_multi', type: 'string',dictTable: "yjjydwxx", dictCode: 'unit_id', dictText: 'unit_name',},
  shelterId: {title: '避难场所编码',order: 6,view: 'list_multi', type: 'string',dictTable: "yjblcsxx", dictCode: 'shelter_id', dictText: 'shelter_name',},
  institutionId: {title: '机构编码',order: 7,view: 'list_multi', type: 'string',dictTable: "ylzyxx", dictCode: 'institution_id', dictText: 'institution_name',},
  serialCode: {title: '接警编码',order: 8,view: 'list', type: 'string',dictTable: "jjjl", dictCode: 'serial_code', dictText: 'accident_name',},
  expertId: {title: '专家编码',order: 9,view: 'list_multi', type: 'string',dictTable: "yjzjxx", dictCode: 'expert_id', dictText: 'expert_name',},
  accidentTime: {title: '事故日期时间',order: 10,view: 'datetime', type: 'string',},
  accidentOverview: {title: '事故概况',order: 11,view: 'textarea', type: 'string',},
  annex: {title: '现场图片',order: 12,view: 'image', type: 'string',},
  generalCommander: {title: '总指挥',order: 13,view: 'text', type: 'string',},
  deputyCommander: {title: '副总指挥',order: 14,view: 'text', type: 'string',},
  onSiteCommander: {title: '现场指挥长',order: 15,view: 'text', type: 'string',},
  deputyOnSiteCommander: {title: '现场副指挥长',order: 16,view: 'text', type: 'string',},
  responseTeam: {title: '现场响应小组',order: 17,view: 'text', type: 'string',},
  dispositionGuidance: {title: '现场处置措施建议',order: 18,view: 'text', type: 'string',},
  personalprotectionGuidance: {title: '个体防护处置建议',order: 19,view: 'text', type: 'string',},
  note: {title: '其他注意事项',order: 20,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 21,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 22,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 23,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 24,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 25,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}