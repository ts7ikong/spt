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
    title: '边界名称',
    align:"center",
    dataIndex: 'zoneName'
   },
   {
    title: '区域类型',
    align:"center",
    dataIndex: 'zoneType_dictText'
   },
   {
    title: '边界信息',
    align:"center",
    dataIndex: 'geo'
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
    label: "边界名称",
    field: "zoneName",
    component: 'JInput',
  },
	{
      label: "区域类型",
      field: 'zoneType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"qylx"
      },
      //colProps: {span: 6},
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
    label: '边界名称',
    field: 'zoneName',
    component: 'Input',
  },
  {
    label: '区域类型',
    field: 'zoneType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qylx"
     },
  },
  {
    label: '边界信息',
    field: 'geo',
    component: 'InputTextArea',
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '修改人姓名',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '修改时间',
    field: 'updateDate',
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
  zoneName: {title: '边界名称',order: 1,view: 'text', type: 'string',},
  zoneType: {title: '区域类型',order: 2,view: 'number', type: 'number',dictCode: 'qylx',},
  geo: {title: '边界信息',order: 3,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}