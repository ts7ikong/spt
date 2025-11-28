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
    title: '隐患排查任务ID',
    align:"center",
    dataIndex: 'checkTaskId'
   },
   {
    title: '排查时间',
    align:"center",
    dataIndex: 'checkTime'
   },
   {
    title: '是否包保责任人任务',
    align:"center",
    dataIndex: 'isDefend_dictText'
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
      label: "排查时间",
      field: "checkTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
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
    label: '隐患排查任务ID',
    field: 'checkTaskId',
    component: 'Input',
  },
  {
    label: '排查时间',
    field: 'checkTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: 'IMEI 码',
    field: 'mobileMe',
    component: 'Input',
  },
  {
    label: '是否包保责任人任务',
    field: 'isDefend',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否激活',
    field: 'isActivation',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfjh"
     },
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建人手机号',
    field: 'createByMobile',
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
  checkTaskId: {title: '隐患排查任务ID',order: 1,view: 'text', type: 'string',},
  checkTime: {title: '排查时间',order: 2,view: 'datetime', type: 'string',},
  isDefend: {title: '是否包保责任人任务',order: 4,view: 'number', type: 'number',dictCode: 'sf',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}