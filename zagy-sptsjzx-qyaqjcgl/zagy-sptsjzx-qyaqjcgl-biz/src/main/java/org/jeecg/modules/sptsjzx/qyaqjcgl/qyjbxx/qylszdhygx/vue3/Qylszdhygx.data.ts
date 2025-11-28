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
    title: '重点行业编码',
    align:"center",
    dataIndex: 'keyIndustryCode'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createDate'
   },
   {
    title: '创建人姓名',
    align:"center",
    dataIndex: 'createBy'
   },
   {
    title: '修改时间',
    align:"center",
    dataIndex: 'updateDate'
   },
   {
    title: '修改人姓名',
    align:"center",
    dataIndex: 'updateBy'
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
    label: '重点行业编码',
    field: 'keyIndustryCode',
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
  uuid: {title: '主键uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  keyIndustryCode: {title: '重点行业编码',order: 2,view: 'text', type: 'string',},
  createDate: {title: '创建时间',order: 3,view: 'text', type: 'string',},
  createBy: {title: '创建人姓名',order: 4,view: 'text', type: 'string',},
  updateDate: {title: '修改时间',order: 5,view: 'text', type: 'string',},
  updateBy: {title: '修改人姓名',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}