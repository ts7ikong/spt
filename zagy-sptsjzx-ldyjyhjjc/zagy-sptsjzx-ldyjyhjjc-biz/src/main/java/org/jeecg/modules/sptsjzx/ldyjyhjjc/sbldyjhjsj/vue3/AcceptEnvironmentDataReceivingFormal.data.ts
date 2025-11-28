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
    title: '采集时间',
    align:"center",
    dataIndex: 'timeStamp',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '风向',
    align:"center",
    dataIndex: 'windDirection_dictText'
   },
   {
    title: '风速 单位 m/s',
    align:"center",
    dataIndex: 'windSpeed'
   },
   {
    title: '温度，摄氏度',
    align:"center",
    dataIndex: 'temperature'
   },
   {
    title: '湿度',
    align:"center",
    dataIndex: 'humidity'
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
      label: "采集时间",
      field: "timeStamp",
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
    label: '采集时间',
    field: 'timeStamp',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '风向',
    field: 'windDirection',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"fx"
     },
  },
  {
    label: '风速 单位 m/s',
    field: 'windSpeed',
    component: 'Input',
  },
  {
    label: '温度，摄氏度',
    field: 'temperature',
    component: 'Input',
  },
  {
    label: '湿度',
    field: 'humidity',
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
  equipCode: {title: '设备编码',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_equip_data_receiving_formal", dictCode: 'equip_code', dictText: 'equip_name',},
  timeStamp: {title: '采集时间',order: 2,view: 'date', type: 'string',},
  windDirection: {title: '风向',order: 3,view: 'list', type: 'string',dictCode: 'fx',},
  windSpeed: {title: '风速 单位 m/s',order: 4,view: 'text', type: 'string',},
  temperature: {title: '温度，摄氏度',order: 5,view: 'text', type: 'string',},
  humidity: {title: '湿度',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}