import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'UUID',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '所属园区',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '关联执法检查计划编号',
    align:"center",
    dataIndex: 'enforcementId'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '执法检查人员编号',
    align:"center",
    dataIndex: 'lawEnforcementOfficalsId'
   },
   {
    title: '执法检查执法检查日期日期',
    align:"center",
    dataIndex: 'lawEnforcementDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '执法检查情况描述',
    align:"center",
    dataIndex: 'lawEnforcementContent'
   },
   {
    title: '是否执法',
    align:"center",
    dataIndex: 'isLawEnforcement_dictText'
   },
   {
    title: '是否停产整顿',
    align:"center",
    dataIndex: 'isSuspendReorganization_dictText'
   },
   {
    title: '是否提请关闭',
    align:"center",
    dataIndex: 'isRequestClose_dictText'
   },
   {
    title: '是否经济处罚',
    align:"center",
    dataIndex: 'isEconomicPenalty_dictText'
   },
   {
    title: '罚款金额（元）',
    align:"center",
    dataIndex: 'fineAmount'
   },
   {
    title: '查封扣押决定 书（附件）',
    align:"center",
    dataIndex: 'sealConfiscationDecision',
   },
   {
    title: '调查询问笔录 （附件）',
    align:"center",
    dataIndex: 'inquiryRecord',
   },
   {
    title: '行政当场处罚 决定书（附件）',
    align:"center",
    dataIndex: 'onsitePenaltyDecision',
   },
   {
    title: '执法检查现场照片',
    align:"center",
    dataIndex: 'enforcePicture',
    customRender:render.renderImage,
   },
   {
    title: '是否立案',
    align:"center",
    dataIndex: 'register_dictText'
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
    label: "UUID",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "所属园区",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "关联执法检查计划编号",
    field: "enforcementId",
    component: 'JInput',
  },
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "执法检查人员编号",
      field: 'lawEnforcementOfficalsId',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "执法检查执法检查日期日期",
      field: "lawEnforcementDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "执法检查情况描述",
      field: 'lawEnforcementContent',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否执法",
      field: 'isLawEnforcement',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否停产整顿",
      field: 'isSuspendReorganization',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否提请关闭",
      field: 'isRequestClose',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否经济处罚",
      field: 'isEconomicPenalty',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
     {
      label: "罚款金额（元）",
      field: "fineAmount",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
	{
      label: "是否立案",
      field: 'register',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfbz"
      },
      //colProps: {span: 6},
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
    label: '所属园区',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属园区!'},
          ];
     },
  },
  {
    label: '关联执法检查计划编号',
    field: 'enforcementId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入关联执法检查计划编号!'},
          ];
     },
  },
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '执法检查人员编号',
    field: 'lawEnforcementOfficalsId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查人员编号!'},
          ];
     },
  },
  {
    label: '执法检查执法检查日期日期',
    field: 'lawEnforcementDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查执法检查日期日期!'},
          ];
     },
  },
  {
    label: '执法检查情况描述',
    field: 'lawEnforcementContent',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查情况描述!'},
          ];
     },
  },
  {
    label: '是否执法',
    field: 'isLawEnforcement',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否执法!'},
          ];
     },
  },
  {
    label: '是否停产整顿',
    field: 'isSuspendReorganization',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否停产整顿!'},
          ];
     },
  },
  {
    label: '是否提请关闭',
    field: 'isRequestClose',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否提请关闭!'},
          ];
     },
  },
  {
    label: '是否经济处罚',
    field: 'isEconomicPenalty',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否经济处罚!'},
          ];
     },
  },
  {
    label: '罚款金额（元）',
    field: 'fineAmount',
    component: 'InputNumber',
  },
  {
    label: '查封扣押决定 书（附件）',
    field: 'sealConfiscationDecision',
    component: 'JUpload',
    componentProps:{
     },
  },
  {
    label: '调查询问笔录 （附件）',
    field: 'inquiryRecord',
    component: 'JUpload',
    componentProps:{
     },
  },
  {
    label: '行政当场处罚 决定书（附件）',
    field: 'onsitePenaltyDecision',
    component: 'JUpload',
    componentProps:{
     },
  },
  {
    label: '执法检查现场照片',
    field: 'enforcePicture',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
  },
  {
    label: '是否立案',
    field: 'register',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否立案!'},
          ];
     },
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '所属园区',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  enforcementId: {title: '关联执法检查计划编号',order: 2,view: 'text', type: 'string',},
  companyCode: {title: '企业编码',order: 3,view: 'text', type: 'string',},
  lawEnforcementOfficalsId: {title: '执法检查人员编号',order: 4,view: 'text', type: 'string',},
  lawEnforcementDate: {title: '执法检查执法检查日期日期',order: 5,view: 'date', type: 'string',},
  lawEnforcementContent: {title: '执法检查情况描述',order: 6,view: 'textarea', type: 'string',},
  isLawEnforcement: {title: '是否执法',order: 7,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  isSuspendReorganization: {title: '是否停产整顿',order: 8,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  isRequestClose: {title: '是否提请关闭',order: 9,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  isEconomicPenalty: {title: '是否经济处罚',order: 10,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  fineAmount: {title: '罚款金额（元）',order: 11,view: 'number', type: 'number',},
  sealConfiscationDecision: {title: '查封扣押决定 书（附件）',order: 12,view: 'file', type: 'string',},
  inquiryRecord: {title: '调查询问笔录 （附件）',order: 13,view: 'file', type: 'string',},
  onsitePenaltyDecision: {title: '行政当场处罚 决定书（附件）',order: 14,view: 'file', type: 'string',},
  enforcePicture: {title: '执法检查现场照片',order: 15,view: 'image', type: 'string',},
  register: {title: '是否立案',order: 16,view: 'list', type: 'string',dictCode: 'sfbz',},
  deleted: {title: '删除标志',order: 17,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 18,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 19,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 20,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 21,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}