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
    title: '园区编号',
    align:"center",
    dataIndex: 'parkCode'
   },
   {
    title: '警示通报编码',
    align:"center",
    dataIndex: 'noticeCode'
   },
   {
    title: '预警事件 ID',
    align:"center",
    dataIndex: 'warningId'
   },
   {
    title: '警示通报内容',
    align:"center",
    dataIndex: 'content'
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
    title: '发送方的组织编码',
    align:"center",
    dataIndex: 'fromOrgCode'
   },
   {
    title: '接收方的组织编码',
    align:"center",
    dataIndex: 'toOrgCode'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted'
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
      label: "园区编号",
      field: 'parkCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "警示通报编码",
      field: 'noticeCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "预警事件 ID",
      field: 'warningId',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "警示通报内容",
      field: 'content',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "原因",
      field: 'reason',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "处置措施",
      field: 'measure',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "发送方的组织编码",
      field: 'fromOrgCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "接收方的组织编码",
      field: 'toOrgCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "删除标志",
      field: 'deleted',
      component: 'Input',
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
    label: '园区编号',
    field: 'parkCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编号!'},
          ];
     },
  },
  {
    label: '警示通报编码',
    field: 'noticeCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入警示通报编码!'},
          ];
     },
  },
  {
    label: '预警事件 ID',
    field: 'warningId',
    component: 'Input',
  },
  {
    label: '警示通报内容',
    field: 'content',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入警示通报内容!'},
          ];
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
  },
  {
    label: '发送方的组织编码',
    field: 'fromOrgCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发送方的组织编码!'},
          ];
     },
  },
  {
    label: '接收方的组织编码',
    field: 'toOrgCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接收方的组织编码!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'Input',
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
  parkCode: {title: '园区编号',order: 1,view: 'text', type: 'string',},
  noticeCode: {title: '警示通报编码',order: 2,view: 'text', type: 'string',},
  warningId: {title: '预警事件 ID',order: 3,view: 'text', type: 'string',},
  content: {title: '警示通报内容',order: 4,view: 'textarea', type: 'string',},
  reason: {title: '原因',order: 5,view: 'textarea', type: 'string',},
  measure: {title: '处置措施',order: 6,view: 'textarea', type: 'string',},
  fromOrgCode: {title: '发送方的组织编码',order: 7,view: 'text', type: 'string',},
  toOrgCode: {title: '接收方的组织编码',order: 8,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 9,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 10,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 11,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 12,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 13,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}