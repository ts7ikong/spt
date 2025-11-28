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
    title: '罐类型',
    align:"center",
    dataIndex: 'tankType_dictText'
   },
   {
    title: '压力类型',
    align:"center",
    dataIndex: 'pressureType_dictText'
   },
   {
    title: '设计压力',
    align:"center",
    dataIndex: 'pressureDesign'
   },
   {
    title: '最高工作压力',
    align:"center",
    dataIndex: 'pressureMax'
   },
   {
    title: '温度类型',
    align:"center",
    dataIndex: 'temperatureType_dictText'
   },
   {
    title: '设计温度低限',
    align:"center",
    dataIndex: 'temperatureMin'
   },
   {
    title: '设计温度高限',
    align:"center",
    dataIndex: 'temperatureMax'
   },
   {
    title: '存储介质',
    align:"center",
    dataIndex: 'medium'
   },
   {
    title: '介质形态',
    align:"center",
    dataIndex: 'mediumStatus_dictText'
   },
   {
    title: '储量',
    align:"center",
    dataIndex: 'reserves'
   },
   {
    title: '液位最高值',
    align:"center",
    dataIndex: 'liquidLevel'
   },
   {
    title: '建造日期',
    align:"center",
    dataIndex: 'buildDate'
   },
   {
    title: '投用日期',
    align:"center",
    dataIndex: 'useDate'
   },
   {
    title: '最近检维修日期',
    align:"center",
    dataIndex: 'maintenanceDate'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备名称",
      field: 'equipCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_device_base_info,equip_name,equip_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "罐类型",
      field: 'tankType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"glx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "压力类型",
      field: 'pressureType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yllx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "温度类型",
      field: 'temperatureType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"wdlx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "存储介质",
    field: "medium",
    component: 'JInput',
  },
	{
      label: "介质形态",
      field: 'mediumStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jzxt"
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
       dict:"v_device_base_info,equip_name,equip_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
  },
  {
    label: '罐类型',
    field: 'tankType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"glx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入罐类型!'},
          ];
     },
  },
  {
    label: '压力类型',
    field: 'pressureType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yllx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入压力类型!'},
          ];
     },
  },
  {
    label: '设计压力',
    field: 'pressureDesign',
    component: 'Input',
  },
  {
    label: '最高工作压力',
    field: 'pressureMax',
    component: 'Input',
  },
  {
    label: '温度类型',
    field: 'temperatureType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"wdlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入温度类型!'},
          ];
     },
  },
  {
    label: '设计温度低限',
    field: 'temperatureMin',
    component: 'Input',
  },
  {
    label: '设计温度高限',
    field: 'temperatureMax',
    component: 'Input',
  },
  {
    label: '存储介质',
    field: 'medium',
    component: 'Input',
  },
  {
    label: '介质形态',
    field: 'mediumStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jzxt"
     },
  },
  {
    label: '储量',
    field: 'reserves',
    component: 'Input',
  },
  {
    label: '液位最高值',
    field: 'liquidLevel',
    component: 'Input',
  },
  {
    label: '建造日期',
    field: 'buildDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入建造日期!'},
          ];
     },
  },
  {
    label: '投用日期',
    field: 'useDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入投用日期!'},
          ];
     },
  },
  {
    label: '最近检维修日期',
    field: 'maintenanceDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最近检维修日期!'},
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
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
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
  equipCode: {title: '设备名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_device_base_info", dictCode: 'equip_code', dictText: 'equip_name',},
  tankType: {title: '罐类型',order: 2,view: 'list', type: 'string',dictCode: 'glx',},
  pressureType: {title: '压力类型',order: 3,view: 'list', type: 'string',dictCode: 'yllx',},
  pressureDesign: {title: '设计压力',order: 4,view: 'text', type: 'string',},
  pressureMax: {title: '最高工作压力',order: 5,view: 'text', type: 'string',},
  temperatureType: {title: '温度类型',order: 6,view: 'list', type: 'string',dictCode: 'wdlx',},
  temperatureMin: {title: '设计温度低限',order: 7,view: 'text', type: 'string',},
  temperatureMax: {title: '设计温度高限',order: 8,view: 'text', type: 'string',},
  medium: {title: '存储介质',order: 9,view: 'text', type: 'string',},
  mediumStatus: {title: '介质形态',order: 10,view: 'list', type: 'string',dictCode: 'jzxt',},
  reserves: {title: '储量',order: 11,view: 'text', type: 'string',},
  liquidLevel: {title: '液位最高值',order: 12,view: 'text', type: 'string',},
  buildDate: {title: '建造日期',order: 13,view: 'text', type: 'string',},
  useDate: {title: '投用日期',order: 14,view: 'text', type: 'string',},
  maintenanceDate: {title: '最近检维修日期',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}