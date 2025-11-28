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
    title: '设备编号',
    align:"center",
    dataIndex: 'equipCode'
   },
   {
    title: '泄漏危化品名称',
    align:"center",
    dataIndex: 'chemName'
   },
   {
    title: '计量单位',
    align:"center",
    dataIndex: 'unit'
   },
   {
    title: '最大实时值',
    align:"center",
    dataIndex: 'concentration'
   },
   {
    title: '气体扩散半径',
    align:"center",
    dataIndex: 'radius'
   },
   {
    title: '最大实时值的经度',
    align:"center",
    dataIndex: 'longitude'
   },
   {
    title: '最大实时值纬度',
    align:"center",
    dataIndex: 'latitude'
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
      label: "设备编号",
      field: 'equipCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "泄漏危化品名称",
      field: 'chemName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "删除标记",
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
    label: '设备编号',
    field: 'equipCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编号!'},
          ];
     },
  },
  {
    label: '泄漏危化品名称',
    field: 'chemName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入泄漏危化品名称!'},
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
    label: '最大实时值',
    field: 'concentration',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最大实时值!'},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '气体扩散半径',
    field: 'radius',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入气体扩散半径!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '最大实时值的经度',
    field: 'longitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最大实时值的经度!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '最大实时值纬度',
    field: 'latitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最大实时值纬度!'},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '删除标记',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"scbz"
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
  equipCode: {title: '设备编号',order: 1,view: 'text', type: 'string',},
  chemName: {title: '泄漏危化品名称',order: 2,view: 'text', type: 'string',},
  unit: {title: '计量单位',order: 3,view: 'text', type: 'string',},
  concentration: {title: '最大实时值',order: 4,view: 'number', type: 'number',},
  radius: {title: '气体扩散半径',order: 5,view: 'number', type: 'number',},
  longitude: {title: '最大实时值的经度',order: 6,view: 'number', type: 'number',},
  latitude: {title: '最大实时值纬度',order: 7,view: 'number', type: 'number',},
  deleted: {title: '删除标记',order: 8,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 9,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 10,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 11,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 12,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}