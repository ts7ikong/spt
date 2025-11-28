import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '隐患主键id',
    align:"center",
    dataIndex: 'dangerId'
   },
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '检查类型',
    align:"center",
    dataIndex: 'checkType_dictText'
   },
   {
    title: '检查项',
    align:"center",
    dataIndex: 'checkItemId'
   },
   {
    title: '检查项评分细则 ',
    align:"center",
    dataIndex: 'checkScoreId'
   },
   {
    title: '检查时间',
    align:"center",
    dataIndex: 'checkDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '危害类型',
    align:"center",
    dataIndex: 'harmType_dictText'
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
      label: "检查类型",
      field: 'checkType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jclx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "检查时间",
      field: "checkDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
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
    label: '隐患主键id',
    field: 'dangerId',
    component: 'Input',
  },
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
    label: '检查任务id',
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
    label: '检查项',
    field: 'checkItemId',
    component: 'Input',
  },
  {
    label: '检查项评分细则 ',
    field: 'checkScoreId',
    component: 'Input',
  },
  {
    label: '检查时间',
    field: 'checkDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '罚款金额 单位:元',
    field: 'checkPay',
    component: 'InputNumber',
  },
  {
    label: '危害类型',
    field: 'harmType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"whlx"
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
  dangerId: {title: '隐患主键id',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  checkType: {title: '检查类型',order: 4,view: 'list', type: 'string',dictCode: 'jclx',},
  checkItemId: {title: '检查项',order: 5,view: 'text', type: 'string',},
  checkScoreId: {title: '检查项评分细则 ',order: 6,view: 'text', type: 'string',},
  checkDate: {title: '检查时间',order: 7,view: 'date', type: 'string',},
  harmType: {title: '危害类型',order: 9,view: 'list', type: 'string',dictCode: 'whlx',},
  taskSource: {title: '任务来源',order: 10,view: 'number', type: 'number',dictCode: 'rwly',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}