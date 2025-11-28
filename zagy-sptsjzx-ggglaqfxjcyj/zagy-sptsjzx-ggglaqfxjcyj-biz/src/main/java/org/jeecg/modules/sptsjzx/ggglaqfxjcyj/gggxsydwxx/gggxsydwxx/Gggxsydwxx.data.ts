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
    title: '管线编号',
    align:"center",
    dataIndex: 'pipelineCode'
   },
   {
    title: '管线使用单位编号',
    align:"center",
    dataIndex: 'useCode'
   },
   {
    title: '所属单位编号',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '使用类型',
    align:"center",
    dataIndex: 'useType_dictText'
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
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管线编号",
      field: 'pipelineCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管线使用单位编号",
      field: 'useCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所属单位编号",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所属单位",
      field: 'companyName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "使用类型",
      field: 'useType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sylx"
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
    label: '管线编号',
    field: 'pipelineCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管线编号!'},
          ];
     },
  },
  {
    label: '管线使用单位编号',
    field: 'useCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管线使用单位编号!'},
          ];
     },
  },
  {
    label: '所属单位编号',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属单位编号!'},
          ];
     },
  },
  {
    label: '所属单位',
    field: 'companyName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属单位!'},
          ];
     },
  },
  {
    label: '使用类型',
    field: 'useType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sylx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入使用类型!'},
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
  pipelineCode: {title: '管线编号',order: 1,view: 'text', type: 'string',},
  useCode: {title: '管线使用单位编号',order: 2,view: 'text', type: 'string',},
  companyCode: {title: '所属单位编号',order: 3,view: 'text', type: 'string',},
  companyName: {title: '所属单位',order: 4,view: 'text', type: 'string',},
  useType: {title: '使用类型',order: 5,view: 'list', type: 'string',dictCode: 'sylx',},
  deleted: {title: '删除标志',order: 6,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 7,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 8,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 9,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 10,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}