import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '培训名称',
    align:"center",
    dataIndex: 'trainName'
   },
   {
    title: '培训类型',
    align:"center",
    dataIndex: 'trainType_dictText'
   },
   {
    title: '培训方式',
    align:"center",
    dataIndex: 'trainMethod_dictText'
   },
   {
    title: '培训途径',
    align:"center",
    dataIndex: 'trainApproach_dictText'
   },
   {
    title: '培训学时',
    align:"center",
    dataIndex: 'trainPeriod'
   },
   {
    title: '培训开始日期',
    align:"center",
    dataIndex: 'trainDateStart',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '培训结束日期',
    align:"center",
    dataIndex: 'trainDateEnd',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '培训级别',
    align:"center",
    dataIndex: 'trainLevel'
   },
   {
    title: '培训组织单位（部门）',
    align:"center",
    dataIndex: 'trainOrgnizeDepart'
   },
   {
    title: '培训地点',
    align:"center",
    dataIndex: 'trainLocate'
   },
   {
    title: '参加人数',
    align:"center",
    dataIndex: 'participantNum'
   },
   {
    title: '培训合格人数',
    align:"center",
    dataIndex: 'qualifyTrainNum'
   },
   {
    title: '培训不合格人数',
    align:"center",
    dataIndex: 'unqualifyTrainNum'
   },
   {
    title: '培训资料附件',
    align:"center",
    dataIndex: 'trainMaterialDocument'
   },
   {
    title: '考核结果',
    align:"center",
    dataIndex: 'exameResult'
   },
   {
    title: '考核人',
    align:"center",
    dataIndex: 'assessor'
   },
   {
    title: '考核日期',
    align:"center",
    dataIndex: 'exameDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '删除标记',
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
      label: "uuid",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
	{
      label: "培训名称",
      field: 'trainName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "培训类型",
      field: 'trainType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"aqjypxlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "培训方式",
      field: 'trainMethod',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"pxfs"
      },
      //colProps: {span: 6},
 	},
	{
      label: "培训途径",
      field: 'trainApproach',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"pxtj"
      },
      //colProps: {span: 6},
 	},
	{
      label: "培训学时",
      field: 'trainPeriod',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "培训开始日期",
      field: "trainDateStart",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "培训结束日期",
      field: "trainDateEnd",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "培训级别",
      field: 'trainLevel',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "培训组织单位（部门）",
      field: 'trainOrgnizeDepart',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "培训地点",
      field: 'trainLocate',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "考核结果",
      field: 'exameResult',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "考核人",
      field: 'assessor',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "考核日期",
      field: "exameDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "删除标记",
      field: 'deleted',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'uuid',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入uuid!'},
          ];
     },
  },
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '培训名称',
    field: 'trainName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训名称!'},
          ];
     },
  },
  {
    label: '培训类型',
    field: 'trainType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"aqjypxlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训类型!'},
          ];
     },
  },
  {
    label: '培训方式',
    field: 'trainMethod',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"pxfs"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训方式!'},
          ];
     },
  },
  {
    label: '培训途径',
    field: 'trainApproach',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"pxtj"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训途径!'},
          ];
     },
  },
  {
    label: '培训学时',
    field: 'trainPeriod',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训学时!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '培训开始日期',
    field: 'trainDateStart',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训开始日期!'},
          ];
     },
  },
  {
    label: '培训结束日期',
    field: 'trainDateEnd',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训结束日期!'},
          ];
     },
  },
  {
    label: '培训级别',
    field: 'trainLevel',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训级别!'},
          ];
     },
  },
  {
    label: '培训组织单位（部门）',
    field: 'trainOrgnizeDepart',
    component: 'Input',
  },
  {
    label: '培训地点',
    field: 'trainLocate',
    component: 'Input',
  },
  {
    label: '参加人数',
    field: 'participantNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '培训合格人数',
    field: 'qualifyTrainNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '培训不合格人数',
    field: 'unqualifyTrainNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '培训资料附件',
    field: 'trainMaterialDocument',
    component: 'Input',
  },
  {
    label: '考核结果',
    field: 'exameResult',
    component: 'Input',
  },
  {
    label: '考核人',
    field: 'assessor',
    component: 'Input',
  },
  {
    label: '考核日期',
    field: 'exameDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '删除标记',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标记!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业编码',order: 1,view: 'list', type: 'string',dictCode: '',},
  trainName: {title: '培训名称',order: 2,view: 'text', type: 'string',},
  trainType: {title: '培训类型',order: 3,view: 'list', type: 'string',dictCode: 'aqjypxlx',},
  trainMethod: {title: '培训方式',order: 4,view: 'list', type: 'string',dictCode: 'pxfs',},
  trainApproach: {title: '培训途径',order: 5,view: 'list', type: 'string',dictCode: 'pxtj',},
  trainPeriod: {title: '培训学时',order: 6,view: 'text', type: 'string',},
  trainDateStart: {title: '培训开始日期',order: 7,view: 'date', type: 'string',},
  trainDateEnd: {title: '培训结束日期',order: 8,view: 'date', type: 'string',},
  trainLevel: {title: '培训级别',order: 9,view: 'text', type: 'string',},
  trainOrgnizeDepart: {title: '培训组织单位（部门）',order: 10,view: 'text', type: 'string',},
  trainLocate: {title: '培训地点',order: 11,view: 'text', type: 'string',},
  participantNum: {title: '参加人数',order: 12,view: 'number', type: 'number',},
  qualifyTrainNum: {title: '培训合格人数',order: 13,view: 'number', type: 'number',},
  unqualifyTrainNum: {title: '培训不合格人数',order: 14,view: 'number', type: 'number',},
  trainMaterialDocument: {title: '培训资料附件',order: 15,view: 'text', type: 'string',},
  exameResult: {title: '考核结果',order: 16,view: 'text', type: 'string',},
  assessor: {title: '考核人',order: 17,view: 'text', type: 'string',},
  exameDate: {title: '考核日期',order: 18,view: 'date', type: 'string',},
  deleted: {title: '删除标记',order: 19,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 20,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 21,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 22,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 23,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}