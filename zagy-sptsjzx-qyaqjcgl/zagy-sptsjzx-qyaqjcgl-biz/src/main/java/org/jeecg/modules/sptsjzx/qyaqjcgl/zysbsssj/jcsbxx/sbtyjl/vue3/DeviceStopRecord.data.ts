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
    title: '设备名称',
    align:"center",
    dataIndex: 'equipCode_dictText'
   },
   {
    title: '危险源名称',
    align:"center",
    dataIndex: 'hazardCode_dictText'
   },
   {
    title: '停用日期',
    align:"center",
    dataIndex: 'stopDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '计划启用日期',
    align:"center",
    dataIndex: 'planEnableDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '实际启用日期，设备启用后更新',
    align:"center",
    dataIndex: 'enableDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '停用类型',
    align:"center",
    dataIndex: 'stopType_dictText'
   },
   {
    title: '停用原因',
    align:"center",
    dataIndex: 'stopReason'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备名称",
      field: 'equipCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_device_base_info, equip_name,equip_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "危险源名称",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "停用日期",
      field: 'stopDate',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "计划启用日期",
      field: 'planEnableDate',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "实际启用日期，设备启用后更新",
      field: 'enableDate',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "停用类型",
      field: 'stopType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"tylx"
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
    label: '设备名称',
    field: 'equipCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_device_base_info, equip_name,equip_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
  },
  {
    label: '危险源名称',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入危险源名称!'},
          ];
     },
  },
  {
    label: '停用日期',
    field: 'stopDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入停用日期!'},
          ];
     },
  },
  {
    label: '计划启用日期',
    field: 'planEnableDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入计划启用日期!'},
          ];
     },
  },
  {
    label: '实际启用日期，设备启用后更新',
    field: 'enableDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '停用类型',
    field: 'stopType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"tylx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入停用类型!'},
          ];
     },
  },
  {
    label: '停用原因',
    field: 'stopReason',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入停用原因!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建人!'},
          ];
     },
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建时间!'},
          ];
     },
  },
  {
    label: '最后修改人',
    field: 'updateBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改人!'},
          ];
     },
  },
  {
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  equipCode: {title: '设备名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_device_base_info", dictCode: 'equip_code', dictText: ' equip_name',},
  hazardCode: {title: '危险源名称',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
  stopDate: {title: '停用日期',order: 3,view: 'date', type: 'string',},
  planEnableDate: {title: '计划启用日期',order: 4,view: 'date', type: 'string',},
  enableDate: {title: '实际启用日期，设备启用后更新',order: 5,view: 'date', type: 'string',},
  stopType: {title: '停用类型',order: 6,view: 'list', type: 'string',dictCode: 'tylx',},
  stopReason: {title: '停用原因',order: 7,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}