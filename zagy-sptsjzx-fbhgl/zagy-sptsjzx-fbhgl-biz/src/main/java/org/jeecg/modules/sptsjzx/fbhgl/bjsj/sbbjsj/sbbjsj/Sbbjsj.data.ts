import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'UUID',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '报警编码',
    align:"center",
    dataIndex: 'alarmCode'
   },
   {
    title: '报警设备编码',
    align:"center",
    dataIndex: 'deviceCode'
   },
   {
    title: '报警设备类型',
    align:"center",
    dataIndex: 'deviceType_dictText'
   },
   {
    title: '报警时间',
    align:"center",
    dataIndex: 'alarmStartTime'
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
    title: '处置状态',
    align:"center",
    dataIndex: 'alarmStatus_dictText'
   },
   {
    title: '处置时间',
    align:"center",
    dataIndex: 'alarmEndTime'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
   {
    title: '创建日期_企业',
    align:"center",
    dataIndex: 'createTimeCompany'
   },
   {
    title: '创建人_企业',
    align:"center",
    dataIndex: 'createByCompany'
   },
   {
    title: '更新日期_企业',
    align:"center",
    dataIndex: 'updateTimeCompany'
   },
   {
    title: '更新人_企业',
    align:"center",
    dataIndex: 'updateByCompany'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "UUID",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "报警编码",
    field: "alarmCode",
    component: 'JInput',
  },
  {
    label: "报警设备编码",
    field: "deviceCode",
    component: 'JInput',
  },
	{
      label: "报警设备类型",
      field: 'deviceType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"bjsblx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "报警时间",
      field: "alarmStartTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "报警类型",
      field: 'alarmType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rydwsbbjlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "经度",
      field: 'longitude',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "纬度",
      field: 'latitude',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "处置状态",
      field: 'alarmStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rydwbjczzt"
      },
      //colProps: {span: 6},
 	},
     {
      label: "处置时间",
      field: "alarmEndTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "删除标志",
      field: 'deleted',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"scbz"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'UUID',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入UUID!'},
          ];
     },
  },
  {
    label: '园区编码',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '报警编码',
    field: 'alarmCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警编码!'},
          ];
     },
  },
  {
    label: '报警设备编码',
    field: 'deviceCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警设备编码!'},
          ];
     },
  },
  {
    label: '报警设备类型',
    field: 'deviceType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"bjsblx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警设备类型!'},
          ];
     },
  },
  {
    label: '报警时间',
    field: 'alarmStartTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警时间!'},
          ];
     },
  },
  {
    label: '报警类型',
    field: 'alarmType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rydwsbbjlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警类型!'},
          ];
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经度!'},
          ];
     },
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纬度!'},
          ];
     },
  },
  {
    label: '处置状态',
    field: 'alarmStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rydwbjczzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处置状态!'},
          ];
     },
  },
  {
    label: '处置时间',
    field: 'alarmEndTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处置时间!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"scbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标志!'},
          ];
     },
  },
  {
    label: '创建日期_企业',
    field: 'createTimeCompany',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '创建人_企业',
    field: 'createByCompany',
    component: 'Input',
  },
  {
    label: '更新日期_企业',
    field: 'updateTimeCompany',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新人_企业',
    field: 'updateByCompany',
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  alarmCode: {title: '报警编码',order: 2,view: 'text', type: 'string',},
  deviceCode: {title: '报警设备编码',order: 3,view: 'text', type: 'string',},
  deviceType: {title: '报警设备类型',order: 4,view: 'list', type: 'string',dictCode: 'bjsblx',},
  alarmStartTime: {title: '报警时间',order: 5,view: 'datetime', type: 'string',},
  alarmType: {title: '报警类型',order: 6,view: 'list', type: 'string',dictCode: 'rydwsbbjlx',},
  longitude: {title: '经度',order: 7,view: 'number', type: 'number',},
  latitude: {title: '纬度',order: 8,view: 'number', type: 'number',},
  alarmStatus: {title: '处置状态',order: 9,view: 'list', type: 'string',dictCode: 'rydwbjczzt',},
  alarmEndTime: {title: '处置时间',order: 10,view: 'datetime', type: 'string',},
  deleted: {title: '删除标志',order: 11,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 12,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 13,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 14,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}