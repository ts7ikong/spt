import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '主键uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '危险源名称',
    align:"center",
    dataIndex: 'hazardCode_dictText'
   },
   {
    title: '中文名',
    align:"center",
    dataIndex: 'chemicalName'
   },
   {
    title: '别名',
    align:"center",
    dataIndex: 'chemicalAlias'
   },
   {
    title: '化学品类型',
    align:"center",
    dataIndex: 'chemicalType_dictText'
   },
   {
    title: 'cas号',
    align:"center",
    dataIndex: 'cas'
   },
   {
    title: '产品生产能力（吨）',
    align:"center",
    dataIndex: 'capacity'
   },
   {
    title: '产品生产能力气体（方）',
    align:"center",
    dataIndex: 'capacityGas'
   },
   {
    title: '产品最大储量（吨）',
    align:"center",
    dataIndex: 'reserve'
   },
   {
    title: '产品最大储量气体（方',
    align:"center",
    dataIndex: 'reserveGas'
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
      label: "危险源名称",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "中文名",
    field: "chemicalName",
    component: 'JInput',
  },
	{
      label: "化学品类型",
      field: 'chemicalType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"hxplx"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '主键uuid',
    field: 'uuid',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '危险源名称',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
  },
  {
    label: '中文名',
    field: 'chemicalName',
    component: 'Input',
  },
  {
    label: '别名',
    field: 'chemicalAlias',
    component: 'Input',
  },
  {
    label: '化学品类型',
    field: 'chemicalType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"hxplx"
     },
  },
  {
    label: 'cas号',
    field: 'cas',
    component: 'Input',
  },
  {
    label: '产品生产能力（吨）',
    field: 'capacity',
    component: 'InputTextArea',
  },
  {
    label: '产品生产能力气体（方）',
    field: 'capacityGas',
    component: 'InputTextArea',
  },
  {
    label: '产品最大储量（吨）',
    field: 'reserve',
    component: 'InputTextArea',
  },
  {
    label: '产品最大储量气体（方',
    field: 'reserveGas',
    component: 'InputTextArea',
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
  uuid: {title: '主键uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  hazardCode: {title: '危险源名称',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
  chemicalName: {title: '中文名',order: 3,view: 'text', type: 'string',},
  chemicalAlias: {title: '别名',order: 4,view: 'text', type: 'string',},
  chemicalType: {title: '化学品类型',order: 5,view: 'number', type: 'number',dictCode: 'hxplx',},
  cas: {title: 'cas号',order: 6,view: 'text', type: 'string',},
  capacity: {title: '产品生产能力（吨）',order: 7,view: 'textarea', type: 'string',},
  capacityGas: {title: '产品生产能力气体（方）',order: 8,view: 'textarea', type: 'string',},
  reserve: {title: '产品最大储量（吨）',order: 9,view: 'textarea', type: 'string',},
  reserveGas: {title: '产品最大储量气体（方',order: 10,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}