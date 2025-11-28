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
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '设备名称',
    align:"center",
    dataIndex: 'equipName'
   },
   {
    title: '设备编码',
    align:"center",
    dataIndex: 'equipCode'
   },
   {
    title: '设备类型',
    align:"center",
    dataIndex: 'equipType_dictText'
   },
   {
    title: '计量单位',
    align:"center",
    dataIndex: 'unit'
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
    title: '设备运行状态',
    align:"center",
    dataIndex: 'equipStatus_dictText'
   },
   {
    title: '覆盖半径',
    align:"center",
    dataIndex: 'radius'
   },
   {
    title: '经度',
    align:"center",
    dataIndex: 'longitude'
   },
   {
    title: '纬度',
    align:"center",
    dataIndex: 'latitude'
   },
   {
    title: '删除标记',
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
      label: "uuid",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
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
      label: "设备名称",
      field: 'equipName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备编码",
      field: 'equipCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备类型",
      field: 'equipType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"qtxljcgksblx"
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
      label: "设备运行状态",
      field: 'equipStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sbyxzt"
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
    label: '设备名称',
    field: 'equipName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
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
    label: '设备类型',
    field: 'equipType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qtxljcgksblx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备类型!'},
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
    label: '设备运行状态',
    field: 'equipStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sbyxzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备运行状态!'},
          ];
     },
  },
  {
    label: '覆盖半径',
    field: 'radius',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入覆盖半径!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经度!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纬度!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '删除标记',
    field: 'deleted',
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
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  equipName: {title: '设备名称',order: 2,view: 'text', type: 'string',},
  equipCode: {title: '设备编码',order: 3,view: 'text', type: 'string',},
  equipType: {title: '设备类型',order: 4,view: 'list', type: 'string',dictCode: 'qtxljcgksblx',},
  unit: {title: '计量单位',order: 5,view: 'text', type: 'string',},
  rangeUp: {title: '量程上限',order: 6,view: 'number', type: 'number',},
  rangeDown: {title: '量程下限',order: 7,view: 'number', type: 'number',},
  equipStatus: {title: '设备运行状态',order: 8,view: 'list', type: 'string',dictCode: 'sbyxzt',},
  radius: {title: '覆盖半径',order: 9,view: 'number', type: 'number',},
  longitude: {title: '经度',order: 10,view: 'number', type: 'number',},
  latitude: {title: '纬度',order: 11,view: 'number', type: 'number',},
  deleted: {title: '删除标记',order: 12,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 13,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 14,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 15,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 16,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}