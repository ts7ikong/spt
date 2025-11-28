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
    title: '风险分析对象',
    align:"center",
    dataIndex: 'hazardCode_dictText'
   },
   {
    title: '任务编号',
    align:"center",
    dataIndex: 'taskId'
   },
   {
    title: '检查类型',
    align:"center",
    dataIndex: 'checkType_dictText'
   },
   {
    title: '检查日期',
    align:"center",
    dataIndex: 'checkDate'
   },
   {
    title: '是否停产整顿',
    align:"center",
    dataIndex: 'resultStatus_dictText'
   },
   {
    title: '任务来源',
    align:"center",
    dataIndex: 'taskSource_dictText'
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
      label: "风险分析对象",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "检查类型",
      field: 'checkType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jclx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否停产整顿",
      field: 'resultStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sftczd"
      },
      //colProps: {span: 6},
 	},
	{
      label: "任务来源",
      field: 'taskSource',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rwly"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '公司上传uuid',
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
    label: '风险分析对象',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
  },
  {
    label: '任务编号',
    field: 'taskId',
    component: 'Input',
  },
  {
    label: '检查类型',
    field: 'checkType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jclx"
     },
  },
  {
    label: '检查日期',
    field: 'checkDate',
    component: 'Input',
  },
  {
    label: '是否停产整顿',
    field: 'resultStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sftczd"
     },
  },
  {
    label: '任务来源',
    field: 'taskSource',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rwly"
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '最后修改人',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '最后修改时间',
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
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  hazardCode: {title: '风险分析对象',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
  taskId: {title: '任务编号',order: 3,view: 'text', type: 'string',},
  checkType: {title: '检查类型',order: 4,view: 'list', type: 'string',dictCode: 'jclx',},
  checkDate: {title: '检查日期',order: 5,view: 'text', type: 'string',},
  resultStatus: {title: '是否停产整顿',order: 6,view: 'list', type: 'string',dictCode: 'sftczd',},
  taskSource: {title: '任务来源',order: 7,view: 'number', type: 'number',dictCode: 'rwly',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}