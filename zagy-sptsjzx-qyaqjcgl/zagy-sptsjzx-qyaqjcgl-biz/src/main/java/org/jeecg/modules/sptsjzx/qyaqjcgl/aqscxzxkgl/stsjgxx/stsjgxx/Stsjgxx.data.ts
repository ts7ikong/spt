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
    title: '园区编号',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '装置编码',
    align:"center",
    dataIndex: 'plantCode_dictText'
   },
   {
    title: '装置名称',
    align:"center",
    dataIndex: 'plantName'
   },
   {
    title: '项目名称',
    align:"center",
    dataIndex: 'projectName'
   },
   {
    title: '项目类型',
    align:"center",
    dataIndex: 'projectType_dictText'
   },
   {
    title: '项目开始日期',
    align:"center",
    dataIndex: 'projectBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '项目结束日期',
    align:"center",
    dataIndex: 'projectEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '项目描述',
    align:"center",
    dataIndex: 'projectDesc'
   },
   {
    title: '项目状态',
    align:"center",
    dataIndex: 'projectStatus'
   },
   {
    title: '立项申请日期',
    align:"center",
    dataIndex: 'approvalApplyForDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '立项通过日期',
    align:"center",
    dataIndex: 'approvalPassDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '设计开始日期',
    align:"center",
    dataIndex: 'designBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '设计结束日期',
    align:"center",
    dataIndex: 'designEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '建设施工开始日期',
    align:"center",
    dataIndex: 'buildBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '建设施工结束日期',
    align:"center",
    dataIndex: 'buildEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '试生产开始日期',
    align:"center",
    dataIndex: 'testProductionBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '试生产结束日期',
    align:"center",
    dataIndex: 'testProductionEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '验收开始日期',
    align:"center",
    dataIndex: 'acceptanceBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '验收结束日期',
    align:"center",
    dataIndex: 'acceptanceEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '立项审批状态',
    align:"center",
    dataIndex: 'approvalStatus_dictText'
   },
   {
    title: '设计审批状态',
    align:"center",
    dataIndex: 'designStatus_dictText'
   },
   {
    title: '建设施工审批状态',
    align:"center",
    dataIndex: 'buildStatus_dictText'
   },
   {
    title: '试生产审批状态',
    align:"center",
    dataIndex: 'testProductionStatus_dictText'
   },
   {
    title: '验收审批状态',
    align:"center",
    dataIndex: 'acceptanceStatus_dictText'
   },
   {
    title: '总体项目开始时间',
    align:"center",
    dataIndex: 'overallProjectStartTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '总体项目结束时间',
    align:"center",
    dataIndex: 'overallProjectEndTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '当前阶段',
    align:"center",
    dataIndex: 'currentGeneration_dictText'
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
      label: "园区编号",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "企业编码",
    field: "companyCode",
    component: 'JInput',
  },
	{
      label: "装置编码",
      field: 'plantCode',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
  {
    label: "项目名称",
    field: "projectName",
    component: 'JInput',
  },
	{
      label: "项目类型",
      field: 'projectType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"xmlx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "项目开始日期",
      field: "projectBeginDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "项目结束日期",
      field: "projectEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "立项申请日期",
      field: "approvalApplyForDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "立项通过日期",
      field: "approvalPassDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "设计开始日期",
      field: "designBeginDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "设计结束日期",
      field: "designEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "建设施工开始日期",
      field: "buildBeginDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "建设施工结束日期",
      field: "buildEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "试生产开始日期",
      field: "testProductionBeginDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "试生产结束日期",
      field: "testProductionEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "验收开始日期",
      field: "acceptanceBeginDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "验收结束日期",
      field: "acceptanceEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "立项审批状态",
      field: 'approvalStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "设计审批状态",
      field: 'designStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "建设施工审批状态",
      field: 'buildStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "试生产审批状态",
      field: 'testProductionStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "验收审批状态",
      field: 'acceptanceStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "总体项目开始时间",
      field: 'overallProjectStartTime',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "总体项目结束时间",
      field: 'overallProjectEndTime',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "当前阶段",
      field: 'currentGeneration',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dqjd"
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
    label: '园区编号',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编号!'},
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
    label: '装置编码',
    field: 'plantCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置编码!'},
          ];
     },
  },
  {
    label: '装置名称',
    field: 'plantName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置名称!'},
          ];
     },
  },
  {
    label: '项目名称',
    field: 'projectName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目名称!'},
          ];
     },
  },
  {
    label: '项目类型',
    field: 'projectType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xmlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目类型!'},
          ];
     },
  },
  {
    label: '项目开始日期',
    field: 'projectBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目开始日期!'},
          ];
     },
  },
  {
    label: '项目结束日期',
    field: 'projectEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '项目描述',
    field: 'projectDesc',
    component: 'Input',
  },
  {
    label: '项目状态',
    field: 'projectStatus',
    component: 'Input',
  },
  {
    label: '立项申请日期',
    field: 'approvalApplyForDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '立项通过日期',
    field: 'approvalPassDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '设计开始日期',
    field: 'designBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '设计结束日期',
    field: 'designEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '建设施工开始日期',
    field: 'buildBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '建设施工结束日期',
    field: 'buildEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '试生产开始日期',
    field: 'testProductionBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '试生产结束日期',
    field: 'testProductionEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '验收开始日期',
    field: 'acceptanceBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '验收结束日期',
    field: 'acceptanceEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '立项审批状态',
    field: 'approvalStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '设计审批状态',
    field: 'designStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '建设施工审批状态',
    field: 'buildStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '试生产审批状态',
    field: 'testProductionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '验收审批状态',
    field: 'acceptanceStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '总体项目开始时间',
    field: 'overallProjectStartTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总体项目开始时间!'},
          ];
     },
  },
  {
    label: '总体项目结束时间',
    field: 'overallProjectEndTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总体项目结束时间!'},
          ];
     },
  },
  {
    label: '当前阶段',
    field: 'currentGeneration',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dqjd"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入当前阶段!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    defaultValue: "0",
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
  parkCode: {title: '园区编号',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  companyCode: {title: '企业编码',order: 2,view: 'text', type: 'string',},
  plantCode: {title: '装置编码',order: 3,view: 'list', type: 'string',dictCode: '',},
  plantName: {title: '装置名称',order: 4,view: 'text', type: 'string',},
  projectName: {title: '项目名称',order: 5,view: 'text', type: 'string',},
  projectType: {title: '项目类型',order: 6,view: 'list', type: 'string',dictCode: 'xmlx',},
  projectBeginDate: {title: '项目开始日期',order: 7,view: 'date', type: 'string',},
  projectEndDate: {title: '项目结束日期',order: 8,view: 'date', type: 'string',},
  projectDesc: {title: '项目描述',order: 9,view: 'text', type: 'string',},
  projectStatus: {title: '项目状态',order: 10,view: 'text', type: 'string',},
  approvalApplyForDate: {title: '立项申请日期',order: 11,view: 'date', type: 'string',},
  approvalPassDate: {title: '立项通过日期',order: 12,view: 'date', type: 'string',},
  designBeginDate: {title: '设计开始日期',order: 13,view: 'date', type: 'string',},
  designEndDate: {title: '设计结束日期',order: 14,view: 'date', type: 'string',},
  buildBeginDate: {title: '建设施工开始日期',order: 15,view: 'date', type: 'string',},
  buildEndDate: {title: '建设施工结束日期',order: 16,view: 'date', type: 'string',},
  testProductionBeginDate: {title: '试生产开始日期',order: 17,view: 'date', type: 'string',},
  testProductionEndDate: {title: '试生产结束日期',order: 18,view: 'date', type: 'string',},
  acceptanceBeginDate: {title: '验收开始日期',order: 19,view: 'date', type: 'string',},
  acceptanceEndDate: {title: '验收结束日期',order: 20,view: 'date', type: 'string',},
  approvalStatus: {title: '立项审批状态',order: 21,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  designStatus: {title: '设计审批状态',order: 22,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  buildStatus: {title: '建设施工审批状态',order: 23,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  testProductionStatus: {title: '试生产审批状态',order: 24,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  acceptanceStatus: {title: '验收审批状态',order: 25,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  overallProjectStartTime: {title: '总体项目开始时间',order: 26,view: 'date', type: 'string',},
  overallProjectEndTime: {title: '总体项目结束时间',order: 27,view: 'date', type: 'string',},
  currentGeneration: {title: '当前阶段',order: 28,view: 'list', type: 'string',dictCode: 'dqjd',},
  deleted: {title: '删除标志',order: 29,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 30,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 31,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 32,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 33,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}