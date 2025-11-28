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
    title: '品名',
    align:"center",
    dataIndex: 'medium'
   },
   {
    title: '别名',
    align:"center",
    dataIndex: 'alias'
   },
   {
    title: 'CAS号',
    align:"center",
    dataIndex: 'cas'
   },
   {
    title: '介质形态',
    align:"center",
    dataIndex: 'mediumStatus_dictText'
   },
   {
    title: '设计储量',
    align:"center",
    dataIndex: 'reserves'
   },
   {
    title: '是否填写组分',
    align:"center",
    dataIndex: 'isFillComponent_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备名称",
      field: 'equipCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name, hazard_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "品名",
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
       dict:"v_accept_hazard_code,hazard_name, hazard_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
  },
  {
    label: '品名',
    field: 'medium',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入品名!'},
          ];
     },
  },
  {
    label: '别名',
    field: 'alias',
    component: 'Input',
  },
  {
    label: 'CAS号',
    field: 'cas',
    component: 'Input',
  },
  {
    label: '介质形态',
    field: 'mediumStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jzxt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入介质形态!'},
          ];
     },
  },
  {
    label: '设计储量',
    field: 'reserves',
    component: 'Input',
  },
  {
    label: '是否填写组分',
    field: 'isFillComponent',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否填写组分!'},
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
  equipCode: {title: '设备名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: ' hazard_code', dictText: 'hazard_name',},
  medium: {title: '品名',order: 2,view: 'text', type: 'string',},
  alias: {title: '别名',order: 3,view: 'text', type: 'string',},
  cas: {title: 'CAS号',order: 4,view: 'text', type: 'string',},
  mediumStatus: {title: '介质形态',order: 5,view: 'list', type: 'string',dictCode: 'jzxt',},
  reserves: {title: '设计储量',order: 6,view: 'text', type: 'string',},
  isFillComponent: {title: '是否填写组分',order: 7,view: 'list', type: 'string',dictCode: 'sf',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}