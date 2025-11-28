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
    title: '停用开始时间',
    align:"center",
    dataIndex: 'stopStartTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '停用结束时间',
    align:"center",
    dataIndex: 'stopEndTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '应用原因',
    align:"center",
    dataIndex: 'stopReason'
   },
   {
    title: '开停车类型',
    align:"center",
    dataIndex: 'startStopType'
   },
   {
    title: '实际结束时间',
    align:"center",
    dataIndex: 'expireTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '当前状态',
    align:"center",
    dataIndex: 'operationStatus'
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
      label: "停用开始时间",
      field: "stopStartTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "停用结束时间",
      field: "stopEndTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "实际结束时间",
      field: "expireTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
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
    label: '风险分析对象',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
  },
  {
    label: '风险分析单元id',
    field: 'riskUnitId',
    component: 'Input',
  },
  {
    label: '停用开始时间',
    field: 'stopStartTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '停用结束时间',
    field: 'stopEndTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '应用原因',
    field: 'stopReason',
    component: 'Input',
  },
  {
    label: '开停车类型',
    field: 'startStopType',
    component: 'Input',
  },
  {
    label: '实际结束时间',
    field: 'expireTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '当前状态',
    field: 'operationStatus',
    component: 'Input',
  },
  {
    label: '开停车责任人',
    field: 'startPersonName',
    component: 'Input',
  },
  {
    label: '开停车责任人手机号',
    field: 'startPersonMobile',
    component: 'Input',
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
  hazardCode: {title: '风险分析对象',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
  stopStartTime: {title: '停用开始时间',order: 3,view: 'date', type: 'string',},
  stopEndTime: {title: '停用结束时间',order: 4,view: 'date', type: 'string',},
  stopReason: {title: '应用原因',order: 5,view: 'text', type: 'string',},
  startStopType: {title: '开停车类型',order: 6,view: 'text', type: 'string',},
  expireTime: {title: '实际结束时间',order: 7,view: 'date', type: 'string',},
  operationStatus: {title: '当前状态',order: 8,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}