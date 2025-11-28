import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '主键',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '第三方单位名称',
    align:"center",
    dataIndex: 'socialCode_dictText'
   },
   {
    title: '上报企业',
    align:"center",
    dataIndex: 'reportCompanyCode_dictText'
   },
   {
    title: '人员编码',
    align:"center",
    dataIndex: 'personCode'
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
    title: '培训时间',
    align:"center",
    dataIndex: 'trainingTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
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
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "第三方单位名称",
      field: 'socialCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"contractor_basic_info,company_name,social_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "上报企业",
      field: 'reportCompanyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "人员姓名",
    field: "name",
    component: 'JInput',
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
    field: "trainingName",
    component: 'JInput',
  },
     {
      label: "培训时间",
      field: "trainingTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '主键',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入主键!'},
          ];
     },
  },
  {
    label: '第三方单位名称',
    field: 'socialCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"contractor_basic_info,company_name,social_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位名称!'},
          ];
     },
  },
  {
    label: '上报企业',
    field: 'reportCompanyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入上报企业!'},
          ];
     },
  },
  {
    label: '人员编码',
    field: 'personCode',
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
      valueFormat: 'YYYY-MM-DD'
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
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否合格!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建人!'},
          ];
     },
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建时间!'},
          ];
     },
  },
  {
    label: '最后修改人',
    field: 'updateBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改人!'},
          ];
     },
  },
  {
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
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
  uuid: {title: '主键',order: 0,view: 'text', type: 'string',},
  socialCode: {title: '第三方单位名称',order: 1,view: 'sel_search', type: 'string',dictTable: "contractor_basic_info", dictCode: 'social_code', dictText: 'company_name',},
  reportCompanyCode: {title: '上报企业',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  personCode: {title: '人员编码',order: 3,view: 'text', type: 'string',},
  name: {title: '人员姓名',order: 4,view: 'text', type: 'string',},
  idNumber: {title: '身份证号',order: 5,view: 'text', type: 'string',},
  trainingType: {title: '培训类型',order: 6,view: 'list', type: 'string',dictCode: 'pxlx',},
  trainingName: {title: '培训名称',order: 7,view: 'text', type: 'string',},
  trainingTime: {title: '培训时间',order: 9,view: 'date', type: 'string',},
  trainingResult: {title: '培训成绩',order: 10,view: 'number', type: 'number',},
  qualified: {title: '是否合格',order: 11,view: 'list', type: 'string',dictCode: 'sf',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}