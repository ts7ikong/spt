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
    dataIndex: 'equipName'
   },
   {
    title: '设备编码',
    align:"center",
    dataIndex: 'equipCode'
   },
   {
    title: '设备描述',
    align:"center",
    dataIndex: 'equipDescribe'
   },
   {
    title: '设备类型',
    align:"center",
    dataIndex: 'equipType_dictText'
   },
   {
    title: '设备运行状态',
    align:"center",
    dataIndex: 'equipStatus_dictText'
   },
   {
    title: '危险源名称',
    align:"center",
    dataIndex: 'hazardCode_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "设备名称",
    field: "equipName",
    component: 'JInput',
  },
	{
      label: "设备类型",
      field: 'equipType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sblx"
      },
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
	{
      label: "危险源名称",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
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
    label: '设备描述',
    field: 'equipDescribe',
    component: 'InputTextArea',
  },
  {
    label: '设备类型',
    field: 'equipType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sblx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备类型!'},
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
    label: '经度',
    field: 'longitude',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经度!'},
          ];
     },
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纬度!'},
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
  equipName: {title: '设备名称',order: 1,view: 'text', type: 'string',},
  equipCode: {title: '设备编码',order: 2,view: 'text', type: 'string',},
  equipDescribe: {title: '设备描述',order: 3,view: 'textarea', type: 'string',},
  equipType: {title: '设备类型',order: 4,view: 'list', type: 'string',dictCode: 'sblx',},
  equipStatus: {title: '设备运行状态',order: 5,view: 'number', type: 'number',dictCode: 'sbyxzt',},
  hazardCode: {title: '危险源名称',order: 6,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}