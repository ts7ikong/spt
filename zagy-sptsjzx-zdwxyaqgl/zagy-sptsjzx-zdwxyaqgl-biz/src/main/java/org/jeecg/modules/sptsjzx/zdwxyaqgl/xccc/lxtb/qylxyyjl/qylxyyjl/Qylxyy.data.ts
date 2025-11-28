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
    title: '离线 /停产类型',
    align:"center",
    dataIndex: 'offlineType'
   },
   {
    title: '离线 /停产原因',
    align:"center",
    dataIndex: 'offlineReason'
   },
   {
    title: '离线 /停产时间',
    align:"center",
    dataIndex: 'offlineTime'
   },
   {
    title: '计划上线时间',
    align:"center",
    dataIndex: 'planOnlineTime'
   },
   {
    title: '批次填写的报备时间戳',
    align:"center",
    dataIndex: 'batchTime'
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
      label: "离线 /停产类型",
      field: 'offlineType',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "离线 /停产时间",
      field: "offlineTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "计划上线时间",
      field: "planOnlineTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "批次填写的报备时间戳",
      field: "batchTime",
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
    label: '离线 /停产类型',
    field: 'offlineType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入离线 /停产类型!'},
          ];
     },
  },
  {
    label: '离线 /停产原因',
    field: 'offlineReason',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入离线 /停产原因!'},
          ];
     },
  },
  {
    label: '离线 /停产时间',
    field: 'offlineTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入离线 /停产时间!'},
          ];
     },
  },
  {
    label: '计划上线时间',
    field: 'planOnlineTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '批次填写的报备时间戳',
    field: 'batchTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入批次填写的报备时间戳!'},
          ];
     },
  },
  {
    label: '删除标记',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
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
  offlineType: {title: '离线 /停产类型',order: 2,view: 'text', type: 'string',},
  offlineReason: {title: '离线 /停产原因',order: 3,view: 'text', type: 'string',},
  offlineTime: {title: '离线 /停产时间',order: 4,view: 'datetime', type: 'string',},
  planOnlineTime: {title: '计划上线时间',order: 5,view: 'datetime', type: 'string',},
  batchTime: {title: '批次填写的报备时间戳',order: 6,view: 'datetime', type: 'string',},
  status: {title: '删除标记',order: 7,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 8,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 9,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 10,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 11,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}