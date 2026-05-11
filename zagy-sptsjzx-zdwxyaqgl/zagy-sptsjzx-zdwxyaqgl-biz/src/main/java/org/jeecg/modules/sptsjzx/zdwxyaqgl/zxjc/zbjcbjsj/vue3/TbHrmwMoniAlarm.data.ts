import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '指标编码',
    align:"center",
    dataIndex: 'targetCode'
   },
   {
    title: '指标报警时间',
    align:"center",
    dataIndex: 'alarmTime'
   },
   {
    title: '当前报警值',
    align:"center",
    dataIndex: 'alarmValue'
   },
   {
    title: '当前报警状态对应的阈值',
    align:"center",
    dataIndex: 'threshold'
   },
   {
    title: '最开始的状态',
    align:"center",
    dataIndex: 'startStatus'
   },
   {
    title: '最坏的状态',
    align:"center",
    dataIndex: 'worstStatus'
   },
   {
    title: '当前的状态',
    align:"center",
    dataIndex: 'currentStatus'
   },
   {
    title: '销警类型',
    align:"center",
    dataIndex: 'dispelType_dictText'
   },
   {
    title: '最近的报警状态变更时间',
    align:"center",
    dataIndex: 'statusChangedTime'
   },
   {
    title: '是否销警',
    align:"center",
    dataIndex: 'isDispel_dictText'
   },
   {
    title: '云端阈值2',
    align:"center",
    dataIndex: 'thresholdBase2'
   },
   {
    title: '云端阈值1',
    align:"center",
    dataIndex: 'thresholdBase'
   },
   {
    title: '边缘端阈值1',
    align:"center",
    dataIndex: 'thresholdEdge'
   },
   {
    title: '边缘端阈值2',
    align:"center",
    dataIndex: 'thresholdEdge2'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '指标编码',
    field: 'targetCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入指标编码!'},
          ];
     },
  },
  {
    label: '指标报警时间',
    field: 'alarmTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入指标报警时间!'},
          ];
     },
  },
  {
    label: '当前报警值',
    field: 'alarmValue',
    component: 'InputNumber',
  },
  {
    label: '当前报警状态对应的阈值',
    field: 'threshold',
    component: 'InputNumber',
  },
  {
    label: '最开始的状态',
    field: 'startStatus',
    component: 'Input',
  },
  {
    label: '最坏的状态',
    field: 'worstStatus',
    component: 'Input',
  },
  {
    label: '当前的状态',
    field: 'currentStatus',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入当前的状态!'},
          ];
     },
  },
  {
    label: '销警类型',
    field: 'dispelType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xjlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入销警类型!'},
          ];
     },
  },
  {
    label: '最近的报警状态变更时间',
    field: 'statusChangedTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '是否销警',
    field: 'isDispel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfxj",
        type: "radio"
     },
  },
  {
    label: '云端阈值2',
    field: 'thresholdBase2',
    component: 'InputNumber',
  },
  {
    label: '云端阈值1',
    field: 'thresholdBase',
    component: 'InputNumber',
  },
  {
    label: '边缘端阈值1',
    field: 'thresholdEdge',
    component: 'InputNumber',
  },
  {
    label: '边缘端阈值2',
    field: 'thresholdEdge2',
    component: 'InputNumber',
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
  targetCode: {title: '指标编码',order: 0,view: 'text', type: 'string',},
  alarmTime: {title: '指标报警时间',order: 1,view: 'datetime', type: 'string',},
  alarmValue: {title: '当前报警值',order: 2,view: 'number', type: 'number',},
  threshold: {title: '当前报警状态对应的阈值',order: 3,view: 'number', type: 'number',},
  startStatus: {title: '最开始的状态',order: 4,view: 'text', type: 'string',},
  worstStatus: {title: '最坏的状态',order: 5,view: 'text', type: 'string',},
  currentStatus: {title: '当前的状态',order: 6,view: 'text', type: 'string',},
  dispelType: {title: '销警类型',order: 7,view: 'list', type: 'string',dictCode: 'xjlx',},
  statusChangedTime: {title: '最近的报警状态变更时间',order: 8,view: 'datetime', type: 'string',},
  isDispel: {title: '是否销警',order: 9,view: 'radio', type: 'string',dictCode: 'sfxj',},
  thresholdBase2: {title: '云端阈值2',order: 10,view: 'number', type: 'number',},
  thresholdBase: {title: '云端阈值1',order: 11,view: 'number', type: 'number',},
  thresholdEdge: {title: '边缘端阈值1',order: 12,view: 'number', type: 'number',},
  thresholdEdge2: {title: '边缘端阈值2',order: 13,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}