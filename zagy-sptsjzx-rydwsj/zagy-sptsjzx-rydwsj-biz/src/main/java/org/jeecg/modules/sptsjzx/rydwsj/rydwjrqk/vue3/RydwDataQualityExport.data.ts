import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '实时数据',
    align:"center",
    dataIndex: 'realTimeSuccess_dictText'
   },
   {
    title: '历史轨迹',
    align:"center",
    dataIndex: 'historyTrackSuccess_dictText'
   },
   {
    title: '聚集报警',
    align:"center",
    dataIndex: 'crowdAlarmMatch_dictText'
   },
   {
    title: '区域报警',
    align:"center",
    dataIndex: 'areaAlarmMatch_dictText'
   },
   {
    title: '人员报警',
    align:"center",
    dataIndex: 'personAlarmMatch_dictText'
   },
   {
    title: '区域边界',
    align:"center",
    dataIndex: 'geoFormatValid_dictText'
   },
   {
    title: '检查时间',
    align:"center",
    dataIndex: 'checkTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
     {
      label: "检查时间",
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
    label: '企业编码',
    field: 'companyCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"v_accept_company,name,code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '实时数据',
    field: 'realTimeSuccess',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sssjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入实时数据!'},
          ];
     },
  },
  {
    label: '历史轨迹',
    field: 'historyTrackSuccess',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sssjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入历史轨迹!'},
          ];
     },
  },
  {
    label: '聚集报警',
    field: 'crowdAlarmMatch',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjbjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入聚集报警!'},
          ];
     },
  },
  {
    label: '区域报警',
    field: 'areaAlarmMatch',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjbjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入区域报警!'},
          ];
     },
  },
  {
    label: '人员报警',
    field: 'personAlarmMatch',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjbjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员报警!'},
          ];
     },
  },
  {
    label: '区域边界',
    field: 'geoFormatValid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjbjsfjr",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入区域边界!'},
          ];
     },
  },
  {
    label: '检查时间',
    field: 'checkTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入检查时间!'},
          ];
     },
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
  companyCode: {title: '企业编码',order: 0,view: 'list', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  realTimeSuccess: {title: '实时数据',order: 1,view: 'number', type: 'number',dictCode: 'sssjsfjr',},
  historyTrackSuccess: {title: '历史轨迹',order: 2,view: 'number', type: 'number',dictCode: 'sssjsfjr',},
  crowdAlarmMatch: {title: '聚集报警',order: 3,view: 'number', type: 'number',dictCode: 'jjbjsfjr',},
  areaAlarmMatch: {title: '区域报警',order: 4,view: 'number', type: 'number',dictCode: 'jjbjsfjr',},
  personAlarmMatch: {title: '人员报警',order: 5,view: 'number', type: 'number',dictCode: 'jjbjsfjr',},
  geoFormatValid: {title: '区域边界',order: 6,view: 'number', type: 'number',dictCode: 'jjbjsfjr',},
  checkTime: {title: '检查时间',order: 7,view: 'datetime', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}