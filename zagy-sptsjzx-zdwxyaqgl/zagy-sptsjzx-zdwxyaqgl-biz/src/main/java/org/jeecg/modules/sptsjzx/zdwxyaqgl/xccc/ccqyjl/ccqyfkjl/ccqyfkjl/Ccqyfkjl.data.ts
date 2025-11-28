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
    title: '抽查企业记录ID',
    align:"center",
    dataIndex: 'inspectCompanyId'
   },
   {
    title: '巡查记录反馈的类型',
    align:"center",
    dataIndex: 'replyType_dictText'
   },
   {
    title: '情况说明',
    align:"center",
    dataIndex: 'situation'
   },
   {
    title: '处置措施',
    align:"center",
    dataIndex: 'measure'
   },
   {
    title: '补充信息',
    align:"center",
    dataIndex: 'otherInfo'
   },
   {
    title: '延期说明',
    align:"center",
    dataIndex: 'delayInfo'
   },
   {
    title: '延期日期',
    align:"center",
    dataIndex: 'delayDate'
   },
   {
    title: '计划完成日期',
    align:"center",
    dataIndex: 'planDate'
   },
   {
    title: '是否已完成',
    align:"center",
    dataIndex: 'isFinish_dictText'
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
      label: "抽查企业记录ID",
      field: 'inspectCompanyId',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "巡查记录反馈的类型",
      field: 'replyType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"xcjlfkdlx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "延期日期",
      field: "delayDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "计划完成日期",
      field: "planDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "是否已完成",
      field: 'isFinish',
      component: 'JSelectMultiple',
      componentProps:{
      },
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
  },
  {
    label: '抽查企业记录ID',
    field: 'inspectCompanyId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入抽查企业记录ID!'},
          ];
     },
  },
  {
    label: '巡查记录反馈的类型',
    field: 'replyType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xcjlfkdlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入巡查记录反馈的类型!'},
          ];
     },
  },
  {
    label: '情况说明',
    field: 'situation',
    component: 'InputTextArea',
  },
  {
    label: '处置措施',
    field: 'measure',
    component: 'InputTextArea',
  },
  {
    label: '补充信息',
    field: 'otherInfo',
    component: 'InputTextArea',
  },
  {
    label: '延期说明',
    field: 'delayInfo',
    component: 'InputTextArea',
  },
  {
    label: '延期日期',
    field: 'delayDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '计划完成日期',
    field: 'planDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入计划完成日期!'},
          ];
     },
  },
  {
    label: '是否已完成',
    field: 'isFinish',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否已完成!'},
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
  inspectCompanyId: {title: '抽查企业记录ID',order: 1,view: 'text', type: 'string',},
  replyType: {title: '巡查记录反馈的类型',order: 2,view: 'list', type: 'string',dictCode: 'xcjlfkdlx',},
  situation: {title: '情况说明',order: 3,view: 'textarea', type: 'string',},
  measure: {title: '处置措施',order: 4,view: 'textarea', type: 'string',},
  otherInfo: {title: '补充信息',order: 5,view: 'textarea', type: 'string',},
  delayInfo: {title: '延期说明',order: 6,view: 'textarea', type: 'string',},
  delayDate: {title: '延期日期',order: 7,view: 'datetime', type: 'string',},
  planDate: {title: '计划完成日期',order: 8,view: 'datetime', type: 'string',},
  isFinish: {title: '是否已完成',order: 9,view: 'list', type: 'string',dictCode: '',},
  status: {title: '删除标记',order: 10,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 11,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 12,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 13,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 14,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}