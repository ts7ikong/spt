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
    title: '第三方单位社会统一信用代码',
    align:"center",
    dataIndex: 'socialCode'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'reportCompanyCode'
   },
   {
    title: '地点',
    align:"center",
    dataIndex: 'place'
   },
   {
    title: '违规描述',
    align:"center",
    dataIndex: 'disposDesc'
   },
   {
    title: '处理过程',
    align:"center",
    dataIndex: 'disposeProcess'
   },
   {
    title: '发生时间',
    align:"center",
    dataIndex: 'startTime'
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
    label: "uuid",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "第三方单位社会统一信用代码",
      field: 'socialCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "上报企业编码",
      field: 'reportCompanyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "地点",
      field: 'place',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "违规描述",
      field: 'disposDesc',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "处理过程",
      field: 'disposeProcess',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "发生时间",
      field: "startTime",
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
    label: '第三方单位社会统一信用代码',
    field: 'socialCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位社会统一信用代码!'},
          ];
     },
  },
  {
    label: '上报企业编码',
    field: 'reportCompanyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入上报企业编码!'},
          ];
     },
  },
  {
    label: '地点',
    field: 'place',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地点!'},
          ];
     },
  },
  {
    label: '违规描述',
    field: 'disposDesc',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入违规描述!'},
          ];
     },
  },
  {
    label: '处理过程',
    field: 'disposeProcess',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处理过程!'},
          ];
     },
  },
  {
    label: '发生时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发生时间!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  socialCode: {title: '第三方单位社会统一信用代码',order: 1,view: 'text', type: 'string',},
  reportCompanyCode: {title: '上报企业编码',order: 2,view: 'text', type: 'string',},
  place: {title: '地点',order: 3,view: 'text', type: 'string',},
  disposDesc: {title: '违规描述',order: 4,view: 'textarea', type: 'string',},
  disposeProcess: {title: '处理过程',order: 5,view: 'textarea', type: 'string',},
  startTime: {title: '发生时间',order: 6,view: 'datetime', type: 'string',},
  deleted: {title: '删除标志',order: 7,view: 'list', type: 'string',dictCode: 'scbz',},
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