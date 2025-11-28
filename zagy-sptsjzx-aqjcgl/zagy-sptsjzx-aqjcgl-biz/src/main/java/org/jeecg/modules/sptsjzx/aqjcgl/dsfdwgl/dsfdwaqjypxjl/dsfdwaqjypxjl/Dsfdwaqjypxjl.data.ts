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
    dataIndex: 'socialcode'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'reportCompanyCode'
   },
   {
    title: '人员编码',
    align:"center",
    dataIndex: 'ersonCode'
   },
   {
    title: '人员姓名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '身份证号',
    align:"center",
    dataIndex: 'idNumber'
   },
   {
    title: '培训类型',
    align:"center",
    dataIndex: 'trainingType_dictText'
   },
   {
    title: '培训名称',
    align:"center",
    dataIndex: 'trainingName'
   },
   {
    title: '培训内容',
    align:"center",
    dataIndex: 'trainingContents'
   },
   {
    title: '培训时间',
    align:"center",
    dataIndex: 'trainingTime'
   },
   {
    title: '培训成绩',
    align:"center",
    dataIndex: 'trainingResult'
   },
   {
    title: '是否合格',
    align:"center",
    dataIndex: 'qualified_dictText'
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
      field: 'socialcode',
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
      label: "人员姓名",
      field: 'name',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "身份证号",
      field: 'idNumber',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "培训类型",
      field: 'trainingType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"pxlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "培训名称",
      field: 'trainingName',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "培训时间",
      field: "trainingTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "培训成绩",
      field: 'trainingResult',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "是否合格",
      field: 'qualified',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"aqjypxjlsfhg"
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
  },
  {
    label: '第三方单位社会统一信用代码',
    field: 'socialcode',
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
    label: '人员编码',
    field: 'ersonCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员编码!'},
          ];
     },
  },
  {
    label: '人员姓名',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员姓名!'},
          ];
     },
  },
  {
    label: '身份证号',
    field: 'idNumber',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入身份证号!'},
          ];
     },
  },
  {
    label: '培训类型',
    field: 'trainingType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"pxlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训类型!'},
          ];
     },
  },
  {
    label: '培训名称',
    field: 'trainingName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训名称!'},
          ];
     },
  },
  {
    label: '培训内容',
    field: 'trainingContents',
    component: 'InputTextArea',
  },
  {
    label: '培训时间',
    field: 'trainingTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训时间!'},
          ];
     },
  },
  {
    label: '培训成绩',
    field: 'trainingResult',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入培训成绩!'},
          ];
     },
  },
  {
    label: '是否合格',
    field: 'qualified',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"aqjypxjlsfhg"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否合格!'},
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
  socialcode: {title: '第三方单位社会统一信用代码',order: 1,view: 'text', type: 'string',},
  reportCompanyCode: {title: '上报企业编码',order: 2,view: 'text', type: 'string',},
  ersonCode: {title: '人员编码',order: 3,view: 'text', type: 'string',},
  name: {title: '人员姓名',order: 4,view: 'text', type: 'string',},
  idNumber: {title: '身份证号',order: 5,view: 'text', type: 'string',},
  trainingType: {title: '培训类型',order: 6,view: 'list', type: 'string',dictCode: 'pxlx',},
  trainingName: {title: '培训名称',order: 7,view: 'text', type: 'string',},
  trainingContents: {title: '培训内容',order: 8,view: 'textarea', type: 'string',},
  trainingTime: {title: '培训时间',order: 9,view: 'datetime', type: 'string',},
  trainingResult: {title: '培训成绩',order: 10,view: 'number', type: 'number',},
  qualified: {title: '是否合格',order: 11,view: 'list', type: 'string',dictCode: 'aqjypxjlsfhg',},
  deleted: {title: '删除标志',order: 12,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 13,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 14,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 15,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 16,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}