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
    title: '机构/企业',
    align:"center",
    dataIndex: 'consumptionIspe'
   },
   {
    title: '汇总编号',
    align:"center",
    dataIndex: 'consumptionCode'
   },
   {
    title: '周期',
    align:"center",
    dataIndex: 'scucle_dictText'
   },
   {
    title: '耗水量/万立方米',
    align:"center",
    dataIndex: 'consumptionWater'
   },
   {
    title: '耗电量/万千瓦时',
    align:"center",
    dataIndex: 'consumptionWire'
   },
   {
    title: '耗煤量/万吨',
    align:"center",
    dataIndex: 'consumptionCoal'
   },
   {
    title: '耗气量/万立方米',
    align:"center",
    dataIndex: 'consumptionGas'
   },
   {
    title: '耗热量/万吨',
    align:"center",
    dataIndex: 'consumptionHeat'
   },
   {
    title: '能耗(标煤)/万吨',
    align:"center",
    dataIndex: 'consumptionEc'
   },
   {
    title: '中水回用率（%）',
    align:"center",
    dataIndex: 'consumptionRwater'
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
      label: "uuid",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "机构/企业",
      field: 'consumptionIspe',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "汇总编号",
      field: 'consumptionCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "周期",
      field: 'scucle',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"hztjzq"
      },
      //colProps: {span: 6},
 	},
     {
      label: "耗水量/万立方米",
      field: "consumptionWater",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "耗电量/万千瓦时",
      field: "consumptionWire",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "耗煤量/万吨",
      field: "consumptionCoal",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "耗气量/万立方米",
      field: "consumptionGas",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "耗热量/万吨",
      field: "consumptionHeat",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
	{
      label: "能耗(标煤)/万吨",
      field: 'consumptionEc',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
     {
      label: "中水回用率（%）",
      field: "consumptionRwater",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
	{
      label: "删除标志",
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
    label: '机构/企业',
    field: 'consumptionIspe',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入机构/企业!'},
          ];
     },
  },
  {
    label: '汇总编号',
    field: 'consumptionCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入汇总编号!'},
          ];
     },
  },
  {
    label: '周期',
    field: 'scucle',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"hztjzq"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入周期!'},
          ];
     },
  },
  {
    label: '耗水量/万立方米',
    field: 'consumptionWater',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入耗水量/万立方米!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '耗电量/万千瓦时',
    field: 'consumptionWire',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入耗电量/万千瓦时!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '耗煤量/万吨',
    field: 'consumptionCoal',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入耗煤量/万吨!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '耗气量/万立方米',
    field: 'consumptionGas',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入耗气量/万立方米!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '耗热量/万吨',
    field: 'consumptionHeat',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入耗热量/万吨!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '能耗(标煤)/万吨',
    field: 'consumptionEc',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入能耗(标煤)/万吨!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '中水回用率（%）',
    field: 'consumptionRwater',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入中水回用率（%）!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  consumptionIspe: {title: '机构/企业',order: 1,view: 'text', type: 'string',},
  consumptionCode: {title: '汇总编号',order: 2,view: 'text', type: 'string',},
  scucle: {title: '周期',order: 3,view: 'list', type: 'string',dictCode: 'hztjzq',},
  consumptionWater: {title: '耗水量/万立方米',order: 4,view: 'number', type: 'number',},
  consumptionWire: {title: '耗电量/万千瓦时',order: 5,view: 'number', type: 'number',},
  consumptionCoal: {title: '耗煤量/万吨',order: 6,view: 'number', type: 'number',},
  consumptionGas: {title: '耗气量/万立方米',order: 7,view: 'number', type: 'number',},
  consumptionHeat: {title: '耗热量/万吨',order: 8,view: 'number', type: 'number',},
  consumptionEc: {title: '能耗(标煤)/万吨',order: 9,view: 'number', type: 'number',},
  consumptionRwater: {title: '中水回用率（%）',order: 10,view: 'number', type: 'number',},
  deleted: {title: '删除标志',order: 11,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 12,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 13,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 14,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}