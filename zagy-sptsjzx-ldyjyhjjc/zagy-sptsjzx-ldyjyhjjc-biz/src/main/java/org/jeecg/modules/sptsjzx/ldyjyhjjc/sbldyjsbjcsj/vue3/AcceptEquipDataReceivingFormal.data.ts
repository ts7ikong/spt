import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
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
    title: '监控半径 单位KM',
    align:"center",
    dataIndex: 'radius'
   },
   {
    title: '设备经度',
    align:"center",
    dataIndex: 'longitude'
   },
   {
    title: '设备纬度',
    align:"center",
    dataIndex: 'latitude'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业名称",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "设备名称",
    field: "equipName",
    component: 'JInput',
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '设备名称',
    field: 'equipName',
    component: 'Input',
  },
  {
    label: '设备编码',
    field: 'equipCode',
    component: 'Input',
  },
  {
    label: '监控半径 单位KM',
    field: 'radius',
    component: 'Input',
  },
  {
    label: '设备经度',
    field: 'longitude',
    component: 'Input',
  },
  {
    label: '设备纬度',
    field: 'latitude',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '修改时间',
    field: 'updateDate',
    component: 'Input',
  },
  {
    label: '修改人姓名',
    field: 'updateBy',
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
  companyCode: {title: '企业名称',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  equipName: {title: '设备名称',order: 1,view: 'text', type: 'string',},
  equipCode: {title: '设备编码',order: 2,view: 'text', type: 'string',},
  radius: {title: '监控半径 单位KM',order: 3,view: 'text', type: 'string',},
  longitude: {title: '设备经度',order: 4,view: 'text', type: 'string',},
  latitude: {title: '设备纬度',order: 5,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}