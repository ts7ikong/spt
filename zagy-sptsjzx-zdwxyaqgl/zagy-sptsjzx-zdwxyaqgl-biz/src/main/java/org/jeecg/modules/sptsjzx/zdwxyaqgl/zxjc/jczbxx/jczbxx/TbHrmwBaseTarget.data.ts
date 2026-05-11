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
    title: '指标名称',
    align:"center",
    dataIndex: 'targetName'
   },
   {
    title: '设备编码',
    align:"center",
    dataIndex: 'equipCode'
   },
   {
    title: '指标类型',
    align:"center",
    dataIndex: 'targetType_dictText'
   },
   {
    title: '二级阈值下限，低低报',
    align:"center",
    dataIndex: 'thresholdDown2'
   },
   {
    title: '一级阈值下限，低报',
    align:"center",
    dataIndex: 'thresholdDown'
   },
   {
    title: '一级阈值上限，高报',
    align:"center",
    dataIndex: 'thresholdUp'
   },
   {
    title: '二级阈值上限，高高报',
    align:"center",
    dataIndex: 'thresholdUp2'
   },
   {
    title: '量程上限',
    align:"center",
    dataIndex: 'rangeUp'
   },
   {
    title: '量程下限',
    align:"center",
    dataIndex: 'rangeDown'
   },
   {
    title: '计量单位',
    align:"center",
    dataIndex: 'unit'
   },
   {
    title: '位号',
    align:"center",
    dataIndex: 'localeNo'
   },
   {
    title: '上报的数据类型',
    align:"center",
    dataIndex: 'dataType'
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '是否删除',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
   {
    title: '指标接入日期，亦是指标首次采集时间',
    align:"center",
    dataIndex: 'linkedDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '接入状态',
    align:"center",
    dataIndex: 'linked_dictText'
   },
   {
    title: '审核状态',
    align:"center",
    dataIndex: 'auditStatus_dictText'
   },
   {
    title: '最后的审核时间',
    align:"center",
    dataIndex: 'auditTime'
   },
   {
    title: '数据完善状态',
    align:"center",
    dataIndex: 'completeStatus_dictText'
   },
   {
    title: '数据来源',
    align:"center",
    dataIndex: 'dataSource_dictText'
   },
   {
    title: '量程或阈值是否填写有误',
    align:"center",
    dataIndex: 'rangeError_dictText'
   },
   {
    title: '指标信息变更状态',
    align:"center",
    dataIndex: 'targetSubStatus_dictText'
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
    label: '指标名称',
    field: 'targetName',
    component: 'Input',
  },
  {
    label: '设备编码',
    field: 'equipCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编码!'},
          ];
     },
  },
  {
    label: '指标类型',
    field: 'targetType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zblx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入指标类型!'},
          ];
     },
  },
  {
    label: '二级阈值下限，低低报',
    field: 'thresholdDown2',
    component: 'InputNumber',
  },
  {
    label: '一级阈值下限，低报',
    field: 'thresholdDown',
    component: 'InputNumber',
  },
  {
    label: '一级阈值上限，高报',
    field: 'thresholdUp',
    component: 'InputNumber',
  },
  {
    label: '二级阈值上限，高高报',
    field: 'thresholdUp2',
    component: 'InputNumber',
  },
  {
    label: '量程上限',
    field: 'rangeUp',
    component: 'InputNumber',
  },
  {
    label: '量程下限',
    field: 'rangeDown',
    component: 'InputNumber',
  },
  {
    label: '计量单位',
    field: 'unit',
    component: 'Input',
  },
  {
    label: '位号',
    field: 'localeNo',
    component: 'Input',
  },
  {
    label: '上报的数据类型',
    field: 'dataType',
    component: 'Input',
  },
  {
    label: '描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '是否删除',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zbsfsc",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否删除!'},
          ];
     },
  },
  {
    label: '指标接入日期，亦是指标首次采集时间',
    field: 'linkedDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '接入状态',
    field: 'linked',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zbjrzt",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接入状态!'},
          ];
     },
  },
  {
    label: '审核状态',
    field: 'auditStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zbshzt",
        type: "radio"
     },
  },
  {
    label: '最后的审核时间',
    field: 'auditTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '数据完善状态',
    field: 'completeStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sjwszt",
        type: "radio"
     },
  },
  {
    label: '数据来源',
    field: 'dataSource',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sjly"
     },
  },
  {
    label: '量程或阈值是否填写有误',
    field: 'rangeError',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"lchyzsftxyw",
        type: "radio"
     },
  },
  {
    label: '指标信息变更状态',
    field: 'targetSubStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zbxxbgzt"
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
  targetCode: {title: '指标编码',order: 0,view: 'text', type: 'string',},
  targetName: {title: '指标名称',order: 1,view: 'text', type: 'string',},
  equipCode: {title: '设备编码',order: 2,view: 'text', type: 'string',},
  targetType: {title: '指标类型',order: 3,view: 'list', type: 'string',dictCode: 'zblx',},
  thresholdDown2: {title: '二级阈值下限，低低报',order: 4,view: 'number', type: 'number',},
  thresholdDown: {title: '一级阈值下限，低报',order: 5,view: 'number', type: 'number',},
  thresholdUp: {title: '一级阈值上限，高报',order: 6,view: 'number', type: 'number',},
  thresholdUp2: {title: '二级阈值上限，高高报',order: 7,view: 'number', type: 'number',},
  rangeUp: {title: '量程上限',order: 8,view: 'number', type: 'number',},
  rangeDown: {title: '量程下限',order: 9,view: 'number', type: 'number',},
  unit: {title: '计量单位',order: 10,view: 'text', type: 'string',},
  localeNo: {title: '位号',order: 11,view: 'text', type: 'string',},
  dataType: {title: '上报的数据类型',order: 12,view: 'text', type: 'string',},
  description: {title: '描述',order: 13,view: 'text', type: 'string',},
  deleted: {title: '是否删除',order: 14,view: 'radio', type: 'string',dictCode: 'zbsfsc',},
  linkedDate: {title: '指标接入日期，亦是指标首次采集时间',order: 15,view: 'date', type: 'string',},
  linked: {title: '接入状态',order: 16,view: 'radio', type: 'string',dictCode: 'zbjrzt',},
  auditStatus: {title: '审核状态',order: 17,view: 'radio', type: 'string',dictCode: 'zbshzt',},
  auditTime: {title: '最后的审核时间',order: 18,view: 'datetime', type: 'string',},
  completeStatus: {title: '数据完善状态',order: 19,view: 'radio', type: 'string',dictCode: 'sjwszt',},
  dataSource: {title: '数据来源',order: 20,view: 'list', type: 'string',dictCode: 'sjly',},
  rangeError: {title: '量程或阈值是否填写有误',order: 21,view: 'number', type: 'number',dictCode: 'lchyzsftxyw',},
  targetSubStatus: {title: '指标信息变更状态',order: 22,view: 'list', type: 'string',dictCode: 'zbxxbgzt',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}