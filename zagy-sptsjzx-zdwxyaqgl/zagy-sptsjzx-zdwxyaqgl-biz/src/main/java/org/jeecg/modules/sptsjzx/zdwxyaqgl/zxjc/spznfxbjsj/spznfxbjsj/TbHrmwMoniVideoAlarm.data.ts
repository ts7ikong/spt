import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '视频编码',
    align:"center",
    dataIndex: 'videoCode'
   },
   {
    title: '视频类型',
    align:"center",
    dataIndex: 'videoType_dictText'
   },
   {
    title: '视频报警时间',
    align:"center",
    dataIndex: 'alarmTime'
   },
   {
    title: '视频报警类型',
    align:"center",
    dataIndex: 'alarmType_dictText'
   },
   {
    title: '视频报警动作',
    align:"center",
    dataIndex: 'alarmAction'
   },
   {
    title: '视频报警脉冲频率',
    align:"center",
    dataIndex: 'alarmFrequency'
   },
   {
    title: '报警截图保存路径',
    align:"center",
    dataIndex: 'picUrl'
   },
   {
    title: '图片存储唯一标识',
    align:"center",
    dataIndex: 'svrIndexCode'
   },
   {
    title: '报警截图Base64编码',
    align:"center",
    dataIndex: 'picBase64'
   },
   {
    title: '设备编码，不是视频编码',
    align:"center",
    dataIndex: 'deviceCode'
   },
   {
    title: '报警图片文件的绝对路径（含文件名）',
    align:"center",
    dataIndex: 'imgUri'
   },
   {
    title: '报警视频文件的绝对路径（含文件名）',
    align:"center",
    dataIndex: 'videoUri'
   },
   {
    title: '是否销警',
    align:"center",
    dataIndex: 'isDispel_dictText'
   },
   {
    title: '销警时间',
    align:"center",
    dataIndex: 'dispelTime'
   },
   {
    title: '是否删除',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '视频编码',
    field: 'videoCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频编码!'},
          ];
     },
  },
  {
    label: '视频类型',
    field: 'videoType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sxtlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频类型!'},
          ];
     },
  },
  {
    label: '视频报警时间',
    field: 'alarmTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频报警时间!'},
          ];
     },
  },
  {
    label: '视频报警类型',
    field: 'alarmType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"spznfxbjlx"
     },
  },
  {
    label: '视频报警动作',
    field: 'alarmAction',
    component: 'Input',
  },
  {
    label: '视频报警脉冲频率',
    field: 'alarmFrequency',
    component: 'InputNumber',
  },
  {
    label: '报警截图保存路径',
    field: 'picUrl',
    component: 'InputTextArea',
  },
  {
    label: '图片存储唯一标识',
    field: 'svrIndexCode',
    component: 'InputTextArea',
  },
  {
    label: '报警截图Base64编码',
    field: 'picBase64',
    component: 'InputTextArea',
  },
  {
    label: '设备编码，不是视频编码',
    field: 'deviceCode',
    component: 'Input',
  },
  {
    label: '报警图片文件的绝对路径（含文件名）',
    field: 'imgUri',
    component: 'InputTextArea',
  },
  {
    label: '报警视频文件的绝对路径（含文件名）',
    field: 'videoUri',
    component: 'InputTextArea',
  },
  {
    label: '是否销警',
    field: 'isDispel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfxj",
        type: "radio"
     },
  },
  {
    label: '销警时间',
    field: 'dispelTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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
  videoCode: {title: '视频编码',order: 0,view: 'text', type: 'string',},
  videoType: {title: '视频类型',order: 1,view: 'list', type: 'string',dictCode: 'sxtlx',},
  alarmTime: {title: '视频报警时间',order: 2,view: 'datetime', type: 'string',},
  alarmType: {title: '视频报警类型',order: 3,view: 'list', type: 'string',dictCode: 'spznfxbjlx',},
  alarmAction: {title: '视频报警动作',order: 4,view: 'text', type: 'string',},
  alarmFrequency: {title: '视频报警脉冲频率',order: 5,view: 'number', type: 'number',},
  picUrl: {title: '报警截图保存路径',order: 6,view: 'textarea', type: 'string',},
  svrIndexCode: {title: '图片存储唯一标识',order: 7,view: 'textarea', type: 'string',},
  picBase64: {title: '报警截图Base64编码',order: 8,view: 'textarea', type: 'string',},
  deviceCode: {title: '设备编码，不是视频编码',order: 9,view: 'text', type: 'string',},
  imgUri: {title: '报警图片文件的绝对路径（含文件名）',order: 10,view: 'textarea', type: 'string',},
  videoUri: {title: '报警视频文件的绝对路径（含文件名）',order: 11,view: 'textarea', type: 'string',},
  isDispel: {title: '是否销警',order: 12,view: 'radio', type: 'string',dictCode: 'sfxj',},
  dispelTime: {title: '销警时间',order: 13,view: 'datetime', type: 'string',},
  deleted: {title: '是否删除',order: 14,view: 'radio', type: 'string',dictCode: 'sfsc',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}