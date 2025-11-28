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
    title: '设备编码',
    align:"center",
    dataIndex: 'equipCode_dictText'
   },
   {
    title: '预警事件编号',
    align:"center",
    dataIndex: 'crashNumber'
   },
   {
    title: '预警等级',
    align:"center",
    dataIndex: 'level_dictText'
   },
   {
    title: '预警开始时间',
    align:"center",
    dataIndex: 'beginTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '预警结束时间',
    align:"center",
    dataIndex: 'endTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
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
      label: "设备编码",
      field: 'equipCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_equip_data_receiving_formal,equip_name,equip_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "预警等级",
      field: 'level',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"ldyjdj"
      },
      //colProps: {span: 6},
 	},
     {
      label: "预警开始时间",
      field: "beginTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "预警结束时间",
      field: "endTime",
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
    label: '设备编码',
    field: 'equipCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_equip_data_receiving_formal,equip_name,equip_code"
    },
  },
  {
    label: '预警事件编号',
    field: 'crashNumber',
    component: 'Input',
  },
  {
    label: '预警等级',
    field: 'level',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"ldyjdj"
     },
  },
  {
    label: '预警开始时间',
    field: 'beginTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '预警结束时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
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
  equipCode: {title: '设备编码',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_equip_data_receiving_formal", dictCode: 'equip_code', dictText: 'equip_name',},
  crashNumber: {title: '预警事件编号',order: 2,view: 'text', type: 'string',},
  level: {title: '预警等级',order: 3,view: 'list', type: 'string',dictCode: 'ldyjdj',},
  beginTime: {title: '预警开始时间',order: 4,view: 'date', type: 'string',},
  endTime: {title: '预警结束时间',order: 5,view: 'date', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}