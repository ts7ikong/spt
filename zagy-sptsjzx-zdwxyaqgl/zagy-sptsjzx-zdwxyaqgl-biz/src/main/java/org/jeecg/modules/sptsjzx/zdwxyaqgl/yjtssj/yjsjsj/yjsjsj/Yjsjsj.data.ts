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
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '预警等级',
    align:"center",
    dataIndex: 'yjRank_dictText'
   },
   {
    title: '预警描述',
    align:"center",
    dataIndex: 'message'
   },
   {
    title: '预警起始时间',
    align:"center",
    dataIndex: 'startTime'
   },
   {
    title: '预警状态',
    align:"center",
    dataIndex: 'warnStatus_dictText'
   },
   {
    title: '预警销警时间',
    align:"center",
    dataIndex: 'resumeTime'
   },
   {
    title: '预警结束时间',
    align:"center",
    dataIndex: 'endTime'
   },
   {
    title: '原因',
    align:"center",
    dataIndex: 'reason'
   },
   {
    title: '处置措施',
    align:"center",
    dataIndex: 'measure'
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
    label: "企业编码",
    field: "companyCode",
    component: 'JInput',
  },
	{
      label: "预警等级",
      field: 'yjRank',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yjdj"
      },
      //colProps: {span: 6},
 	},
     {
      label: "预警起始时间",
      field: "startTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "预警状态",
      field: 'warnStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yjzt"
      },
      //colProps: {span: 6},
 	},
     {
      label: "预警销警时间",
      field: "resumeTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "预警结束时间",
      field: "endTime",
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
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
  },
  {
    label: '预警等级',
    field: 'yjRank',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yjdj"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入预警等级!'},
          ];
     },
  },
  {
    label: '预警描述',
    field: 'message',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入预警描述!'},
          ];
     },
  },
  {
    label: '预警起始时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入预警起始时间!'},
          ];
     },
  },
  {
    label: '预警状态',
    field: 'warnStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yjzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入预警状态!'},
          ];
     },
  },
  {
    label: '预警销警时间',
    field: 'resumeTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '预警结束时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '原因',
    field: 'reason',
    component: 'InputTextArea',
  },
  {
    label: '处置措施',
    field: 'measure',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处置措施!'},
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
  companyCode: {title: '企业编码',order: 2,view: 'text', type: 'string',},
  yjRank: {title: '预警等级',order: 3,view: 'list', type: 'string',dictCode: 'yjdj',},
  message: {title: '预警描述',order: 4,view: 'textarea', type: 'string',},
  startTime: {title: '预警起始时间',order: 5,view: 'datetime', type: 'string',},
  warnStatus: {title: '预警状态',order: 6,view: 'list', type: 'string',dictCode: 'yjzt',},
  resumeTime: {title: '预警销警时间',order: 7,view: 'datetime', type: 'string',},
  endTime: {title: '预警结束时间',order: 8,view: 'datetime', type: 'string',},
  reason: {title: '原因',order: 9,view: 'textarea', type: 'string',},
  measure: {title: '处置措施',order: 10,view: 'textarea', type: 'string',},
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