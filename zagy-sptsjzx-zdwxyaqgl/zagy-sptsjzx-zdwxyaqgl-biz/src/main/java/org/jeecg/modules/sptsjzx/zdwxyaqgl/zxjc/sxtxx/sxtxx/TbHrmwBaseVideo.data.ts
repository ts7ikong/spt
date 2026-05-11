import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '视频编码，是第三方的唯一约束',
    align:"center",
    dataIndex: 'videoCode'
   },
   {
    title: '视频名称',
    align:"center",
    dataIndex: 'videoName'
   },
   {
    title: '所在企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '视频所在位置的类型',
    align:"center",
    dataIndex: 'videoLocaleType_dictText'
   },
   {
    title: '排序',
    align:"center",
    dataIndex: 'videoSort'
   },
   {
    title: '传输协议',
    align:"center",
    dataIndex: 'transMode'
   },
   {
    title: '码流类型',
    align:"center",
    dataIndex: 'streamMode_dictText'
   },
   {
    title: '监控点录像存储位置',
    align:"center",
    dataIndex: 'recordLocation'
   },
   {
    title: '是否在线',
    align:"center",
    dataIndex: 'online_dictText'
   },
   {
    title: '视频url',
    align:"center",
    dataIndex: 'url'
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '是否删除',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
   {
    title: '提交到部里用的共享国标编码',
    align:"center",
    dataIndex: 'gbCode'
   },
   {
    title: '视频数据来源',
    align:"center",
    dataIndex: 'dataSource_dictText'
   },
   {
    title: '第三方视频区域编码',
    align:"center",
    dataIndex: 'regionCode'
   },
   {
    title: '录像计划启停用状态',
    align:"center",
    dataIndex: 'recordPlanStatus_dictText'
   },
   {
    title: '关联的日常录像计划id',
    align:"center",
    dataIndex: 'recordPlanId'
   },
   {
    title: '最近在线更新时间',
    align:"center",
    dataIndex: 'onlineUpdateTime'
   },
   {
    title: '最近一次填报的离线原因',
    align:"center",
    dataIndex: 'offlineReason'
   },
   {
    title: '最近一次填报的计划上线时间',
    align:"center",
    dataIndex: 'planOnlineTime'
   },
   {
    title: '附件的文件路径',
    align:"center",
    dataIndex: 'attachFilePath'
   },
   {
    title: '附件的文件名',
    align:"center",
    dataIndex: 'attachFileName'
   },
   {
    title: '附件的文件后缀',
    align:"center",
    dataIndex: 'attachFileFormat'
   },
   {
    title: '最近一次离线id',
    align:"center",
    dataIndex: 'offlineId'
   },
   {
    title: '所属园区',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '离线时间',
    align:"center",
    dataIndex: 'offlineTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '视频编码，是第三方的唯一约束',
    field: 'videoCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频编码，是第三方的唯一约束!'},
          ];
     },
  },
  {
    label: '视频名称',
    field: 'videoName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频名称!'},
          ];
     },
  },
  {
    label: '所在企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所在企业编码!'},
          ];
     },
  },
  {
    label: '视频所在位置的类型',
    field: 'videoLocaleType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"spszwzdlx"
     },
  },
  {
    label: '排序',
    field: 'videoSort',
    component: 'InputNumber',
  },
  {
    label: '传输协议',
    field: 'transMode',
    component: 'Input',
  },
  {
    label: '码流类型',
    field: 'streamMode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
  },
  {
    label: '监控点录像存储位置',
    field: 'recordLocation',
    component: 'Input',
  },
  {
    label: '是否在线',
    field: 'online',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sxtsfzx",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否在线!'},
          ];
     },
  },
  {
    label: '视频url',
    field: 'url',
    component: 'InputTextArea',
  },
  {
    label: '描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '是否删除',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfsc",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否删除!'},
          ];
     },
  },
  {
    label: '提交到部里用的共享国标编码',
    field: 'gbCode',
    component: 'Input',
  },
  {
    label: '视频数据来源',
    field: 'dataSource',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"spsjly"
     },
  },
  {
    label: '第三方视频区域编码',
    field: 'regionCode',
    component: 'Input',
  },
  {
    label: '录像计划启停用状态',
    field: 'recordPlanStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"lxjhqtyzt",
        type: "radio"
     },
  },
  {
    label: '关联的日常录像计划id',
    field: 'recordPlanId',
    component: 'Input',
  },
  {
    label: '最近在线更新时间',
    field: 'onlineUpdateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '最近一次填报的离线原因',
    field: 'offlineReason',
    component: 'InputTextArea',
  },
  {
    label: '最近一次填报的计划上线时间',
    field: 'planOnlineTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '附件的文件路径',
    field: 'attachFilePath',
    component: 'InputTextArea',
  },
  {
    label: '附件的文件名',
    field: 'attachFileName',
    component: 'InputTextArea',
  },
  {
    label: '附件的文件后缀',
    field: 'attachFileFormat',
    component: 'Input',
  },
  {
    label: '最近一次离线id',
    field: 'offlineId',
    component: 'Input',
  },
  {
    label: '所属园区',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
  },
  {
    label: '离线时间',
    field: 'offlineTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
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
  videoCode: {title: '视频编码，是第三方的唯一约束',order: 0,view: 'text', type: 'string',},
  videoName: {title: '视频名称',order: 1,view: 'text', type: 'string',},
  companyCode: {title: '所在企业编码',order: 2,view: 'text', type: 'string',},
  videoLocaleType: {title: '视频所在位置的类型',order: 3,view: 'list', type: 'string',dictCode: 'spszwzdlx',},
  videoSort: {title: '排序',order: 4,view: 'number', type: 'number',},
  transMode: {title: '传输协议',order: 5,view: 'text', type: 'string',},
  streamMode: {title: '码流类型',order: 6,view: 'list', type: 'string',dictCode: '',},
  recordLocation: {title: '监控点录像存储位置',order: 7,view: 'text', type: 'string',},
  online: {title: '是否在线',order: 8,view: 'radio', type: 'string',dictCode: 'sxtsfzx',},
  url: {title: '视频url',order: 9,view: 'textarea', type: 'string',},
  description: {title: '描述',order: 10,view: 'text', type: 'string',},
  deleted: {title: '是否删除',order: 11,view: 'radio', type: 'string',dictCode: 'sfsc',},
  gbCode: {title: '提交到部里用的共享国标编码',order: 12,view: 'text', type: 'string',},
  dataSource: {title: '视频数据来源',order: 13,view: 'list', type: 'string',dictCode: 'spsjly',},
  regionCode: {title: '第三方视频区域编码',order: 14,view: 'text', type: 'string',},
  recordPlanStatus: {title: '录像计划启停用状态',order: 15,view: 'radio', type: 'string',dictCode: 'lxjhqtyzt',},
  recordPlanId: {title: '关联的日常录像计划id',order: 16,view: 'text', type: 'string',},
  onlineUpdateTime: {title: '最近在线更新时间',order: 17,view: 'datetime', type: 'string',},
  offlineReason: {title: '最近一次填报的离线原因',order: 18,view: 'textarea', type: 'string',},
  planOnlineTime: {title: '最近一次填报的计划上线时间',order: 19,view: 'datetime', type: 'string',},
  attachFilePath: {title: '附件的文件路径',order: 20,view: 'textarea', type: 'string',},
  attachFileName: {title: '附件的文件名',order: 21,view: 'textarea', type: 'string',},
  attachFileFormat: {title: '附件的文件后缀',order: 22,view: 'text', type: 'string',},
  offlineId: {title: '最近一次离线id',order: 23,view: 'text', type: 'string',},
  parkCode: {title: '所属园区',order: 24,view: 'list', type: 'string',dictCode: '',},
  offlineTime: {title: '离线时间',order: 25,view: 'datetime', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}