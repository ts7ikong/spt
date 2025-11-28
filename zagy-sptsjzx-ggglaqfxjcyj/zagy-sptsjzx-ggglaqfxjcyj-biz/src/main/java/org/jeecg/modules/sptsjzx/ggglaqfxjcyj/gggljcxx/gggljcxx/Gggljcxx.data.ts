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
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode'
   },
   {
    title: '管理单位编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '管理单位',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '管廊编号',
    align:"center",
    dataIndex: 'pipeCode'
   },
   {
    title: '管廊名称',
    align:"center",
    dataIndex: 'pipeName'
   },
   {
    title: '管廊分类',
    align:"center",
    dataIndex: 'pipeType_dictText'
   },
   {
    title: '空间位置',
    align:"center",
    dataIndex: 'pipeSpaceaddress_dictText'
   },
   {
    title: '管廊层数',
    align:"center",
    dataIndex: 'pipePcs'
   },
   {
    title: '管廊宽度（m）',
    align:"center",
    dataIndex: 'pipeWidth'
   },
   {
    title: '管廊长度（M）',
    align:"center",
    dataIndex: 'pipeLength'
   },
   {
    title: '管控距离（m）',
    align:"center",
    dataIndex: 'pipeDistance'
   },
   {
    title: '建设单位',
    align:"center",
    dataIndex: 'pipeJunit'
   },
   {
    title: '投用日期',
    align:"center",
    dataIndex: 'pipeUdate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '地理位置信息',
    align:"center",
    dataIndex: 'pipeGlocation'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'pipeState_dictText'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'pipeRemarks'
   },
   {
    title: '资料附件',
    align:"center",
    dataIndex: 'pipeInfomation'
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
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted'
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
      label: "园区编码",
      field: 'parkCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管理单位编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管理单位",
      field: 'companyName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管廊编号",
      field: 'pipeCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管廊名称",
      field: 'pipeName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管廊分类",
      field: 'pipeType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"glfl"
      },
      //colProps: {span: 6},
 	},
	{
      label: "空间位置",
      field: 'pipeSpaceaddress',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"kjwz"
      },
      //colProps: {span: 6},
 	},
	{
      label: "管廊层数",
      field: 'pipePcs',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
  {
    label: "建设单位",
    field: "pipeJunit",
    component: 'JInput',
  },
     {
      label: "投用日期",
      field: "pipeUdate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "地理位置信息",
      field: 'pipeGlocation',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "状态",
      field: 'pipeState',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"glzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "备注",
      field: 'pipeRemarks',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "资料附件",
      field: 'pipeInfomation',
      component: 'Input',
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
    label: '园区编码',
    field: 'parkCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '管理单位编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管理单位编码!'},
          ];
     },
  },
  {
    label: '管理单位',
    field: 'companyName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管理单位!'},
          ];
     },
  },
  {
    label: '管廊编号',
    field: 'pipeCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊编号!'},
          ];
     },
  },
  {
    label: '管廊名称',
    field: 'pipeName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊名称!'},
          ];
     },
  },
  {
    label: '管廊分类',
    field: 'pipeType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"glfl"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊分类!'},
          ];
     },
  },
  {
    label: '空间位置',
    field: 'pipeSpaceaddress',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"kjwz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入空间位置!'},
          ];
     },
  },
  {
    label: '管廊层数',
    field: 'pipePcs',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊层数!'},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '管廊宽度（m）',
    field: 'pipeWidth',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊宽度（m）!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '管廊长度（M）',
    field: 'pipeLength',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管廊长度（M）!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '管控距离（m）',
    field: 'pipeDistance',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管控距离（m）!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '建设单位',
    field: 'pipeJunit',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入建设单位!'},
          ];
     },
  },
  {
    label: '投用日期',
    field: 'pipeUdate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入投用日期!'},
          ];
     },
  },
  {
    label: '地理位置信息',
    field: 'pipeGlocation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地理位置信息!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'pipeState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"glzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '备注',
    field: 'pipeRemarks',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入备注!'},
          ];
     },
  },
  {
    label: '资料附件',
    field: 'pipeInfomation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资料附件!'},
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
  parkCode: {title: '园区编码',order: 1,view: 'text', type: 'string',},
  companyCode: {title: '管理单位编码',order: 2,view: 'text', type: 'string',},
  companyName: {title: '管理单位',order: 3,view: 'text', type: 'string',},
  pipeCode: {title: '管廊编号',order: 4,view: 'text', type: 'string',},
  pipeName: {title: '管廊名称',order: 5,view: 'text', type: 'string',},
  pipeType: {title: '管廊分类',order: 6,view: 'list', type: 'string',dictCode: 'glfl',},
  pipeSpaceaddress: {title: '空间位置',order: 7,view: 'number', type: 'number',dictCode: 'kjwz',},
  pipePcs: {title: '管廊层数',order: 8,view: 'number', type: 'number',},
  pipeWidth: {title: '管廊宽度（m）',order: 9,view: 'number', type: 'number',},
  pipeLength: {title: '管廊长度（M）',order: 10,view: 'number', type: 'number',},
  pipeDistance: {title: '管控距离（m）',order: 11,view: 'number', type: 'number',},
  pipeJunit: {title: '建设单位',order: 12,view: 'text', type: 'string',},
  pipeUdate: {title: '投用日期',order: 13,view: 'date', type: 'string',},
  pipeGlocation: {title: '地理位置信息',order: 14,view: 'text', type: 'string',},
  pipeState: {title: '状态',order: 15,view: 'list', type: 'string',dictCode: 'glzt',},
  pipeRemarks: {title: '备注',order: 16,view: 'text', type: 'string',},
  pipeInfomation: {title: '资料附件',order: 17,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 18,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 19,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 20,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 21,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 22,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}