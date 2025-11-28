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
    title: '指标编码',
    align:"center",
    dataIndex: 'targetCode'
   },
   {
    title: '所属设备编码',
    align:"center",
    dataIndex: 'equipCode'
   },
   {
    title: '指标名称',
    align:"center",
    dataIndex: 'targetName'
   },
   {
    title: '指标类型',
    align:"center",
    dataIndex: 'targetType_dictText'
   },
   {
    title: '计量单位',
    align:"center",
    dataIndex: 'unit'
   },
   {
    title: '指标描述',
    align:"center",
    dataIndex: 'parameterDesc'
   },
   {
    title: '一级阈值上限',
    align:"center",
    dataIndex: 'thresholdUp'
   },
   {
    title: '二级阈值上限',
    align:"center",
    dataIndex: 'thresholdUp2'
   },
   {
    title: '一级阈值下限',
    align:"center",
    dataIndex: 'thresholdDown'
   },
   {
    title: '二级阈值下限',
    align:"center",
    dataIndex: 'thresholdDown2'
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
    title: '删除标记',
    align:"center",
    dataIndex: 'status'
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
      label: "指标编码",
      field: 'targetCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所属设备编码",
      field: 'equipCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "指标名称",
      field: 'targetName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "指标类型",
      field: 'targetType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zblx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "计量单位",
      field: 'unit',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "指标描述",
      field: 'parameterDesc',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "删除标记",
      field: 'status',
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
  },
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
    label: '所属设备编码',
    field: 'equipCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属设备编码!'},
          ];
     },
  },
  {
    label: '指标名称',
    field: 'targetName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入指标名称!'},
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
    label: '计量单位',
    field: 'unit',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入计量单位!'},
          ];
     },
  },
  {
    label: '指标描述',
    field: 'parameterDesc',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入指标描述!'},
          ];
     },
  },
  {
    label: '一级阈值上限',
    field: 'thresholdUp',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入一级阈值上限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '二级阈值上限',
    field: 'thresholdUp2',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入二级阈值上限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '一级阈值下限',
    field: 'thresholdDown',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入一级阈值下限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '二级阈值下限',
    field: 'thresholdDown2',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入二级阈值下限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '量程上限',
    field: 'rangeUp',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入量程上限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '量程下限',
    field: 'rangeDown',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入量程下限!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '删除标记',
    field: 'status',
    component: 'Input',
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
  targetCode: {title: '指标编码',order: 1,view: 'text', type: 'string',},
  equipCode: {title: '所属设备编码',order: 2,view: 'text', type: 'string',},
  targetName: {title: '指标名称',order: 3,view: 'text', type: 'string',},
  targetType: {title: '指标类型',order: 4,view: 'list', type: 'string',dictCode: 'zblx',},
  unit: {title: '计量单位',order: 5,view: 'text', type: 'string',},
  parameterDesc: {title: '指标描述',order: 6,view: 'textarea', type: 'string',},
  thresholdUp: {title: '一级阈值上限',order: 7,view: 'number', type: 'number',},
  thresholdUp2: {title: '二级阈值上限',order: 8,view: 'number', type: 'number',},
  thresholdDown: {title: '一级阈值下限',order: 9,view: 'number', type: 'number',},
  thresholdDown2: {title: '二级阈值下限',order: 10,view: 'number', type: 'number',},
  rangeUp: {title: '量程上限',order: 11,view: 'number', type: 'number',},
  rangeDown: {title: '量程下限',order: 12,view: 'number', type: 'number',},
  status: {title: '删除标记',order: 13,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 14,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 15,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 16,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 17,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}