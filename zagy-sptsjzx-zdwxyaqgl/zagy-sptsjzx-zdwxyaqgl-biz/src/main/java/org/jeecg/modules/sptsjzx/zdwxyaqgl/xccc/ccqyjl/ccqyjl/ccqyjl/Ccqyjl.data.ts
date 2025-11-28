import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '抽查日期',
    align:"center",
    dataIndex: 'patrolDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '抽查记录状态',
    align:"center",
    dataIndex: 'inspectStatus_dictText'
   },
   {
    title: '是否要求企业反馈离线的原因',
    align:"center",
    dataIndex: 'needOnline'
   },
   {
    title: '是否在线',
    align:"center",
    dataIndex: 'online_dictText'
   },
   {
    title: '是否要求企业反馈视频离线的原因',
    align:"center",
    dataIndex: 'needVideoOnline_dictText'
   },
   {
    title: '是否视频在线',
    align:"center",
    dataIndex: 'videoOnline_dictText'
   },
   {
    title: '是否要求企业反馈预警等级高的原因',
    align:"center",
    dataIndex: 'needWarnRank_dictText'
   },
   {
    title: '预警等级',
    align:"center",
    dataIndex: 'warnRank'
   },
   {
    title: '是否要求企业反馈未上报安全承诺的原因',
    align:"center",
    dataIndex: 'needCommitStatus_dictText'
   },
   {
    title: '是否安全承诺',
    align:"center",
    dataIndex: 'commitStatus_dictText'
   },
   {
    title: '是否要求企业反馈报警多的原因',
    align:"center",
    dataIndex: 'needAlarmCount_dictText'
   },
   {
    title: '未销警数量',
    align:"center",
    dataIndex: 'alarmCount'
   },
   {
    title: '是否要求企业反馈最近一周预警等级高的原因',
    align:"center",
    dataIndex: 'needLastWeekWarnRank_dictText'
   },
   {
    title: '最近一周最高的预警等级',
    align:"center",
    dataIndex: 'lastWeekWarnRank_dictText'
   },
   {
    title: '其他异常情况',
    align:"center",
    dataIndex: 'otherContent'
   },
   {
    title: '抽查人',
    align:"center",
    dataIndex: 'patrolledBy'
   },
   {
    title: '抽查时间',
    align:"center",
    dataIndex: 'patrolledTime'
   },
   {
    title: '删除标记',
    align:"center",
    dataIndex: 'status_dictText'
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
      label: "uuid",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "抽查日期",
      field: "patrolDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "抽查记录状态",
      field: 'inspectStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"ccjlzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否在线",
      field: 'online',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否要求企业反馈视频离线的原因",
      field: 'needVideoOnline',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否视频在线",
      field: 'videoOnline',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否要求企业反馈预警等级高的原因",
      field: 'needWarnRank',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否要求企业反馈未上报安全承诺的原因",
      field: 'needCommitStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否安全承诺",
      field: 'commitStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否要求企业反馈报警多的原因",
      field: 'needAlarmCount',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否要求企业反馈最近一周预警等级高的原因",
      field: 'needLastWeekWarnRank',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "最近一周最高的预警等级",
      field: 'lastWeekWarnRank',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yjdj"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'uuid',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入uuid!'},
          ];
     },
  },
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '抽查日期',
    field: 'patrolDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入抽查日期!'},
          ];
     },
  },
  {
    label: '抽查记录状态',
    field: 'inspectStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"ccjlzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入抽查记录状态!'},
          ];
     },
  },
  {
    label: '是否要求企业反馈离线的原因',
    field: 'needOnline',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈离线的原因!'},
          ];
     },
  },
  {
    label: '是否在线',
    field: 'online',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否要求企业反馈视频离线的原因',
    field: 'needVideoOnline',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈视频离线的原因!'},
          ];
     },
  },
  {
    label: '是否视频在线',
    field: 'videoOnline',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否要求企业反馈预警等级高的原因',
    field: 'needWarnRank',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈预警等级高的原因!'},
          ];
     },
  },
  {
    label: '预警等级',
    field: 'warnRank',
    component: 'Input',
  },
  {
    label: '是否要求企业反馈未上报安全承诺的原因',
    field: 'needCommitStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈未上报安全承诺的原因!'},
          ];
     },
  },
  {
    label: '是否安全承诺',
    field: 'commitStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否要求企业反馈报警多的原因',
    field: 'needAlarmCount',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈报警多的原因!'},
          ];
     },
  },
  {
    label: '未销警数量',
    field: 'alarmCount',
    component: 'InputNumber',
  },
  {
    label: '是否要求企业反馈最近一周预警等级高的原因',
    field: 'needLastWeekWarnRank',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否要求企业反馈最近一周预警等级高的原因!'},
          ];
     },
  },
  {
    label: '最近一周最高的预警等级',
    field: 'lastWeekWarnRank',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yjdj"
     },
  },
  {
    label: '其他异常情况',
    field: 'otherContent',
    component: 'InputTextArea',
  },
  {
    label: '抽查人',
    field: 'patrolledBy',
    component: 'InputTextArea',
  },
  {
    label: '抽查时间',
    field: 'patrolledTime',
    component: 'Input',
  },
  {
    label: '删除标记',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"scbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标记!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业编码',order: 1,view: 'text', type: 'string',},
  patrolDate: {title: '抽查日期',order: 2,view: 'date', type: 'string',},
  inspectStatus: {title: '抽查记录状态',order: 3,view: 'list', type: 'string',dictCode: 'ccjlzt',},
  needOnline: {title: '是否要求企业反馈离线的原因',order: 4,view: 'text', type: 'string',},
  online: {title: '是否在线',order: 5,view: 'list', type: 'string',dictCode: 'sf',},
  needVideoOnline: {title: '是否要求企业反馈视频离线的原因',order: 6,view: 'list', type: 'string',dictCode: 'sf',},
  videoOnline: {title: '是否视频在线',order: 7,view: 'list', type: 'string',dictCode: 'sf',},
  needWarnRank: {title: '是否要求企业反馈预警等级高的原因',order: 8,view: 'list', type: 'string',dictCode: 'sf',},
  warnRank: {title: '预警等级',order: 9,view: 'text', type: 'string',},
  needCommitStatus: {title: '是否要求企业反馈未上报安全承诺的原因',order: 10,view: 'list', type: 'string',dictCode: 'sf',},
  commitStatus: {title: '是否安全承诺',order: 11,view: 'list', type: 'string',dictCode: 'sf',},
  needAlarmCount: {title: '是否要求企业反馈报警多的原因',order: 12,view: 'list', type: 'string',dictCode: 'sf',},
  alarmCount: {title: '未销警数量',order: 13,view: 'number', type: 'number',},
  needLastWeekWarnRank: {title: '是否要求企业反馈最近一周预警等级高的原因',order: 14,view: 'list', type: 'string',dictCode: 'sf',},
  lastWeekWarnRank: {title: '最近一周最高的预警等级',order: 15,view: 'list', type: 'string',dictCode: 'yjdj',},
  otherContent: {title: '其他异常情况',order: 16,view: 'textarea', type: 'string',},
  patrolledBy: {title: '抽查人',order: 17,view: 'textarea', type: 'string',},
  patrolledTime: {title: '抽查时间',order: 18,view: 'text', type: 'string',},
  status: {title: '删除标记',order: 19,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 20,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 21,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 22,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 23,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}