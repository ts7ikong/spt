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
    title: '巡查记录日期',
    align:"center",
    dataIndex: 'inspectDate'
   },
   {
    title: '巡查记录编码',
    align:"center",
    dataIndex: 'inspectCode'
   },
   {
    title: '巡查记录状态',
    align:"center",
    dataIndex: 'inspectStatus_dictText'
   },
   {
    title: '生成巡查记录的行政区划',
    align:"center",
    dataIndex: 'genAreaCode'
   },
   {
    title: '接受巡查的行政区划',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '是否需要下级单位反馈视频在线情况',
    align:"center",
    dataIndex: 'needOnline'
   },
   {
    title: '在线率',
    align:"center",
    dataIndex: 'onlineRate'
   },
   {
    title: '在线率排名',
    align:"center",
    dataIndex: 'onlineSort'
   },
   {
    title: '是否需要下级单位反馈安全承诺情况',
    align:"center",
    dataIndex: 'needVideoOnline'
   },
   {
    title: '视频在线率',
    align:"center",
    dataIndex: 'videoOnlineRate'
   },
   {
    title: '视频在线率 排名',
    align:"center",
    dataIndex: 'videoOnlineSort'
   },
   {
    title: '是否需要下级单位反馈 安全承诺情况',
    align:"center",
    dataIndex: 'needPromise'
   },
   {
    title: '安全承诺率',
    align:"center",
    dataIndex: 'promiseRate'
   },
   {
    title: '安全承诺排名',
    align:"center",
    dataIndex: 'promiseSort'
   },
   {
    title: '是否需要下级单位反馈未销警情况',
    align:"center",
    dataIndex: 'needLatestAlarm'
   },
   {
    title: '近24小时未销警指标 数',
    align:"center",
    dataIndex: 'latestAlarmTargetCount'
   },
   {
    title: '近24小时未销警时长',
    align:"center",
    dataIndex: 'latestAlarmTargetInterval'
   },
   {
    title: '是否需要下级单位反馈预警情况',
    align:"center",
    dataIndex: 'needWarn'
   },
   {
    title: '预警未销警数量',
    align:"center",
    dataIndex: 'warnCount'
   },
   {
    title: '预警未反馈数量',
    align:"center",
    dataIndex: 'warnNoRespCount'
   },
   {
    title: '警示通报未反馈数量',
    align:"center",
    dataIndex: 'warnNoticeNoRespCount'
   },
   {
    title: '其他巡查内容',
    align:"center",
    dataIndex: 'otherContent'
   },
   {
    title: '反馈时间',
    align:"center",
    dataIndex: 'feedbackTime'
   },
   {
    title: '联系人',
    align:"center",
    dataIndex: 'contactor'
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
    field: "uuid",
    component: 'JInput',
  },
     {
      label: "巡查记录日期",
      field: "inspectDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "巡查记录编码",
      field: 'inspectCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "巡查记录状态",
      field: 'inspectStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"xcjlzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "生成巡查记录的行政区划",
      field: 'genAreaCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "接受巡查的行政区划",
      field: 'areaCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否需要下级单位反馈视频在线情况",
      field: 'needOnline',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否需要下级单位反馈安全承诺情况",
      field: 'needVideoOnline',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否需要下级单位反馈 安全承诺情况",
      field: 'needPromise',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否需要下级单位反馈未销警情况",
      field: 'needLatestAlarm',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "近24小时未销警指标 数",
      field: 'latestAlarmTargetCount',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "是否需要下级单位反馈预警情况",
      field: 'needWarn',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "反馈时间",
      field: "feedbackTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "联系人",
      field: 'contactor',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "删除标记",
      field: 'status',
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
    label: '巡查记录日期',
    field: 'inspectDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入巡查记录日期!'},
          ];
     },
  },
  {
    label: '巡查记录编码',
    field: 'inspectCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入巡查记录编码!'},
          ];
     },
  },
  {
    label: '巡查记录状态',
    field: 'inspectStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xcjlzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入巡查记录状态!'},
          ];
     },
  },
  {
    label: '生成巡查记录的行政区划',
    field: 'genAreaCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入生成巡查记录的行政区划!'},
          ];
     },
  },
  {
    label: '接受巡查的行政区划',
    field: 'areaCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接受巡查的行政区划!'},
          ];
     },
  },
  {
    label: '是否需要下级单位反馈视频在线情况',
    field: 'needOnline',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否需要下级单位反馈视频在线情况!'},
          ];
     },
  },
  {
    label: '在线率',
    field: 'onlineRate',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '在线率排名',
    field: 'onlineSort',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '是否需要下级单位反馈安全承诺情况',
    field: 'needVideoOnline',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否需要下级单位反馈安全承诺情况!'},
          ];
     },
  },
  {
    label: '视频在线率',
    field: 'videoOnlineRate',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '视频在线率 排名',
    field: 'videoOnlineSort',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '是否需要下级单位反馈 安全承诺情况',
    field: 'needPromise',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否需要下级单位反馈 安全承诺情况!'},
          ];
     },
  },
  {
    label: '安全承诺率',
    field: 'promiseRate',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+\.?\d*$/, message: '请输入数字!'},
          ];
     },
  },
  {
    label: '安全承诺排名',
    field: 'promiseSort',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '是否需要下级单位反馈未销警情况',
    field: 'needLatestAlarm',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否需要下级单位反馈未销警情况!'},
          ];
     },
  },
  {
    label: '近24小时未销警指标 数',
    field: 'latestAlarmTargetCount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入近24小时未销警指标 数!'},
          ];
     },
  },
  {
    label: '近24小时未销警时长',
    field: 'latestAlarmTargetInterval',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入近24小时未销警时长!'},
          ];
     },
  },
  {
    label: '是否需要下级单位反馈预警情况',
    field: 'needWarn',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否需要下级单位反馈预警情况!'},
          ];
     },
  },
  {
    label: '预警未销警数量',
    field: 'warnCount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '预警未反馈数量',
    field: 'warnNoRespCount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '警示通报未反馈数量',
    field: 'warnNoticeNoRespCount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
          ];
     },
  },
  {
    label: '其他巡查内容',
    field: 'otherContent',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入其他巡查内容!'},
          ];
     },
  },
  {
    label: '反馈时间',
    field: 'feedbackTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入反馈时间!'},
          ];
     },
  },
  {
    label: '联系人',
    field: 'contactor',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入联系人!'},
          ];
     },
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
  inspectDate: {title: '巡查记录日期',order: 1,view: 'datetime', type: 'string',},
  inspectCode: {title: '巡查记录编码',order: 2,view: 'text', type: 'string',},
  inspectStatus: {title: '巡查记录状态',order: 3,view: 'list', type: 'string',dictCode: 'xcjlzt',},
  genAreaCode: {title: '生成巡查记录的行政区划',order: 4,view: 'text', type: 'string',},
  areaCode: {title: '接受巡查的行政区划',order: 5,view: 'text', type: 'string',},
  needOnline: {title: '是否需要下级单位反馈视频在线情况',order: 6,view: 'text', type: 'string',},
  onlineRate: {title: '在线率',order: 7,view: 'number', type: 'number',},
  onlineSort: {title: '在线率排名',order: 8,view: 'number', type: 'number',},
  needVideoOnline: {title: '是否需要下级单位反馈安全承诺情况',order: 9,view: 'text', type: 'string',},
  videoOnlineRate: {title: '视频在线率',order: 10,view: 'number', type: 'number',},
  videoOnlineSort: {title: '视频在线率 排名',order: 11,view: 'number', type: 'number',},
  needPromise: {title: '是否需要下级单位反馈 安全承诺情况',order: 12,view: 'text', type: 'string',},
  promiseRate: {title: '安全承诺率',order: 13,view: 'number', type: 'number',},
  promiseSort: {title: '安全承诺排名',order: 14,view: 'number', type: 'number',},
  needLatestAlarm: {title: '是否需要下级单位反馈未销警情况',order: 15,view: 'text', type: 'string',},
  latestAlarmTargetCount: {title: '近24小时未销警指标 数',order: 16,view: 'number', type: 'number',},
  latestAlarmTargetInterval: {title: '近24小时未销警时长',order: 17,view: 'text', type: 'string',},
  needWarn: {title: '是否需要下级单位反馈预警情况',order: 18,view: 'text', type: 'string',},
  warnCount: {title: '预警未销警数量',order: 19,view: 'number', type: 'number',},
  warnNoRespCount: {title: '预警未反馈数量',order: 20,view: 'number', type: 'number',},
  warnNoticeNoRespCount: {title: '警示通报未反馈数量',order: 21,view: 'number', type: 'number',},
  otherContent: {title: '其他巡查内容',order: 22,view: 'textarea', type: 'string',},
  feedbackTime: {title: '反馈时间',order: 23,view: 'datetime', type: 'string',},
  contactor: {title: '联系人',order: 24,view: 'text', type: 'string',},
  status: {title: '删除标记',order: 25,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 26,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 27,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 28,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 29,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}