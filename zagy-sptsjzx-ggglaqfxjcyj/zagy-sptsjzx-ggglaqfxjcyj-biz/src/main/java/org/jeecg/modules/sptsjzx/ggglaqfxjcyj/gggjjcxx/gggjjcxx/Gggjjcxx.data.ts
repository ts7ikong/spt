import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '所在管廊',
    align:"center",
    dataIndex: 'pipeCode'
   },
   {
    title: '管架编号',
    align:"center",
    dataIndex: 'pipeframeCode'
   },
   {
    title: '管架名称',
    align:"center",
    dataIndex: 'pipeframeName'
   },
   {
    title: '管架类型',
    align:"center",
    dataIndex: 'pipeframeType_dictText'
   },
   {
    title: '投用日期',
    align:"center",
    dataIndex: 'pipeframeUdate'
   },
   {
    title: '地理位置信息',
    align:"center",
    dataIndex: 'pipeframeGlocation'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'pipeframeState_dictText'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'pipeframeRemarks'
   },
   {
    title: '资料附件',
    align:"center",
    dataIndex: 'pipeframeInfomation'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted'
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
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所在管廊",
      field: 'pipeCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管架编号",
      field: 'pipeframeCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管架名称",
      field: 'pipeframeName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管架类型",
      field: 'pipeframeType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gjlx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "投用日期",
      field: "pipeframeUdate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "状态",
      field: 'pipeframeState',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gjzt"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
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
    label: '所在管廊',
    field: 'pipeCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所在管廊!'},
          ];
     },
  },
  {
    label: '管架编号',
    field: 'pipeframeCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管架编号!'},
          ];
     },
  },
  {
    label: '管架名称',
    field: 'pipeframeName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管架名称!'},
          ];
     },
  },
  {
    label: '管架类型',
    field: 'pipeframeType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gjlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管架类型!'},
          ];
     },
  },
  {
    label: '投用日期',
    field: 'pipeframeUdate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入投用日期!'},
          ];
     },
  },
  {
    label: '地理位置信息',
    field: 'pipeframeGlocation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地理位置信息!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'pipeframeState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gjzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '备注',
    field: 'pipeframeRemarks',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入备注!'},
          ];
     },
  },
  {
    label: '资料附件',
    field: 'pipeframeInfomation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资料附件!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'Input',
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
  companyCode: {title: '企业编码',order: 0,view: 'text', type: 'string',},
  pipeCode: {title: '所在管廊',order: 1,view: 'text', type: 'string',},
  pipeframeCode: {title: '管架编号',order: 2,view: 'text', type: 'string',},
  pipeframeName: {title: '管架名称',order: 3,view: 'text', type: 'string',},
  pipeframeType: {title: '管架类型',order: 4,view: 'list', type: 'string',dictCode: 'gjlx',},
  pipeframeUdate: {title: '投用日期',order: 5,view: 'datetime', type: 'string',},
  pipeframeGlocation: {title: '地理位置信息',order: 6,view: 'text', type: 'string',},
  pipeframeState: {title: '状态',order: 7,view: 'list', type: 'string',dictCode: 'gjzt',},
  pipeframeRemarks: {title: '备注',order: 8,view: 'text', type: 'string',},
  pipeframeInfomation: {title: '资料附件',order: 9,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 10,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 11,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 12,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 13,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 14,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}