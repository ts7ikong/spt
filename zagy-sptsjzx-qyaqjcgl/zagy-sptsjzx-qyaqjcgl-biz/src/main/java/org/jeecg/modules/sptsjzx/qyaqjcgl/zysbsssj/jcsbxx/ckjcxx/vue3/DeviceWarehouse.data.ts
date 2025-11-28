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
    title: '仓库建设日期',
    align:"center",
    dataIndex: 'buildDate'
   },
   {
    title: '仓库投产日期',
    align:"center",
    dataIndex: 'startDate'
   },
   {
    title: '占地面积',
    align:"center",
    dataIndex: 'floorArea'
   },
   {
    title: '仓库类型',
    align:"center",
    dataIndex: 'storeType_dictText'
   },
   {
    title: '设计储量',
    align:"center",
    dataIndex: 'designReserve'
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
      label: "仓库类型",
      field: 'storeType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"cklx"
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
    label: '仓库建设日期',
    field: 'buildDate',
    component: 'Input',
  },
  {
    label: '仓库投产日期',
    field: 'startDate',
    component: 'Input',
  },
  {
    label: '占地面积',
    field: 'floorArea',
    component: 'Input',
  },
  {
    label: '仓库类型',
    field: 'storeType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cklx"
     },
  },
  {
    label: '设计储量',
    field: 'designReserve',
    component: 'Input',
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
  buildDate: {title: '仓库建设日期',order: 2,view: 'text', type: 'string',},
  startDate: {title: '仓库投产日期',order: 3,view: 'text', type: 'string',},
  floorArea: {title: '占地面积',order: 4,view: 'text', type: 'string',},
  storeType: {title: '仓库类型',order: 5,view: 'list', type: 'string',dictCode: 'cklx',},
  designReserve: {title: '设计储量',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}