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
    title: '人员基础信息id',
    align:"center",
    dataIndex: 'personId'
   },
   {
    title: '区域边界',
    align:"center",
    dataIndex: 'zoneId'
   },
   {
    title: '报警类型',
    align:"center",
    dataIndex: 'alarmType_dictText'
   },
   {
    title: '经度',
    align:"center",
    dataIndex: 'longitude'
   },
   {
    title: '纬度',
    align:"center",
    dataIndex: 'latitude'
   },
   {
    title: '报警时间',
    align:"center",
    dataIndex: 'alarmTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '销警时间',
    align:"center",
    dataIndex: 'dispelTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '报警描述',
    align:"center",
    dataIndex: 'describex'
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
      label: "报警类型",
      field: 'alarmType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rydwbjlx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "报警时间",
      field: "alarmTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "销警时间",
      field: "dispelTime",
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
    label: '人员基础信息id',
    field: 'personId',
    component: 'Input',
  },
  {
    label: '区域边界',
    field: 'zoneId',
    component: 'Input',
  },
  {
    label: '报警类型',
    field: 'alarmType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rydwbjlx"
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'Input',
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'Input',
  },
  {
    label: '报警时间',
    field: 'alarmTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '销警时间',
    field: 'dispelTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '报警描述',
    field: 'describex',
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
  personId: {title: '人员基础信息id',order: 1,view: 'text', type: 'string',},
  zoneId: {title: '区域边界',order: 2,view: 'text', type: 'string',},
  alarmType: {title: '报警类型',order: 3,view: 'list', type: 'string',dictCode: 'rydwbjlx',},
  longitude: {title: '经度',order: 4,view: 'text', type: 'string',},
  latitude: {title: '纬度',order: 5,view: 'text', type: 'string',},
  alarmTime: {title: '报警时间',order: 6,view: 'date', type: 'string',},
  dispelTime: {title: '销警时间',order: 7,view: 'date', type: 'string',},
  describex: {title: '报警描述',order: 8,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}