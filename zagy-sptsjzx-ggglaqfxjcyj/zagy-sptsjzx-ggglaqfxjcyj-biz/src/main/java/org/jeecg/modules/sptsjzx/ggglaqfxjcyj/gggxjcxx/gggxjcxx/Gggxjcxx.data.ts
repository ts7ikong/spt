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
    title: '所在管廊',
    align:"center",
    dataIndex: 'pipeCode_dictText'
   },
   {
    title: '管线编号',
    align:"center",
    dataIndex: 'pipelineCode'
   },
   {
    title: '管线名称',
    align:"center",
    dataIndex: 'pipelineName'
   },
   {
    title: '所在层数',
    align:"center",
    dataIndex: 'pipelineCs'
   },
   {
    title: '管位',
    align:"center",
    dataIndex: 'pipelinePosition'
   },
   {
    title: '危化品编号',
    align:"center",
    dataIndex: 'chemicalsCode'
   },
   {
    title: '介质名称',
    align:"center",
    dataIndex: 'pipelineMedianame'
   },
   {
    title: '地理位置信息',
    align:"center",
    dataIndex: 'pipelineGlocation'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'pipelineState_dictText'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'pipelineRemarks'
   },
   {
    title: '资料附件',
    align:"center",
    dataIndex: 'pipelineInfomation'
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
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所在管廊",
      field: 'pipeCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gggljcxx,pipe_name,pipe_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "管线编号",
      field: 'pipelineCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管线名称",
      field: 'pipelineName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "所在层数",
      field: 'pipelineCs',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "管位",
      field: 'pipelinePosition',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "危化品编号",
      field: 'chemicalsCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "介质名称",
      field: 'pipelineMedianame',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "状态",
      field: 'pipelineState',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gxzt"
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
    label: '所在管廊',
    field: 'pipeCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gggljcxx,pipe_name,pipe_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所在管廊!'},
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
    label: '管线名称',
    field: 'pipelineName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管线名称!'},
          ];
     },
  },
  {
    label: '所在层数',
    field: 'pipelineCs',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所在层数!'},
          ];
     },
  },
  {
    label: '管位',
    field: 'pipelinePosition',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入管位!'},
          ];
     },
  },
  {
    label: '危化品编号',
    field: 'chemicalsCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入危化品编号!'},
          ];
     },
  },
  {
    label: '介质名称',
    field: 'pipelineMedianame',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入介质名称!'},
          ];
     },
  },
  {
    label: '地理位置信息',
    field: 'pipelineGlocation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地理位置信息!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'pipelineState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gxzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '备注',
    field: 'pipelineRemarks',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入备注!'},
          ];
     },
  },
  {
    label: '资料附件',
    field: 'pipelineInfomation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资料附件!'},
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
  companyCode: {title: '企业编码',order: 1,view: 'text', type: 'string',},
  pipeCode: {title: '所在管廊',order: 2,view: 'list', type: 'string',dictTable: "gggljcxx", dictCode: 'pipe_code', dictText: 'pipe_name',},
  pipelineCode: {title: '管线编号',order: 3,view: 'text', type: 'string',},
  pipelineName: {title: '管线名称',order: 4,view: 'text', type: 'string',},
  pipelineCs: {title: '所在层数',order: 5,view: 'text', type: 'string',},
  pipelinePosition: {title: '管位',order: 6,view: 'text', type: 'string',},
  chemicalsCode: {title: '危化品编号',order: 7,view: 'text', type: 'string',},
  pipelineMedianame: {title: '介质名称',order: 8,view: 'text', type: 'string',},
  pipelineGlocation: {title: '地理位置信息',order: 9,view: 'text', type: 'string',},
  pipelineState: {title: '状态',order: 10,view: 'list', type: 'string',dictCode: 'gxzt',},
  pipelineRemarks: {title: '备注',order: 11,view: 'text', type: 'string',},
  pipelineInfomation: {title: '资料附件',order: 12,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 13,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 14,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 15,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 16,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 17,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}