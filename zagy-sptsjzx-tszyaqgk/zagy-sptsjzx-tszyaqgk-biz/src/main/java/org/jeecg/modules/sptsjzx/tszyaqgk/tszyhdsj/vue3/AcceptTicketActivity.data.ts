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
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '作业类型',
    align:"center",
    dataIndex: 'ticketType_dictText'
   },
   {
    title: '作业开始时间',
    align:"center",
    dataIndex: 'startTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '作业结束时间',
    align:"center",
    dataIndex: 'endTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '作业地点',
    align:"center",
    dataIndex: 'ticketPosition'
   },
   {
    title: '作业内容',
    align:"center",
    dataIndex: 'jobContent'
   },
   {
    title: '是否承包商作业',
    align:"center",
    dataIndex: 'isContractorWork_dictText'
   },
   {
    title: '作业负责人',
    align:"center",
    dataIndex: 'ticketResponsName'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业名称",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "作业类型",
      field: 'ticketType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zylx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "作业开始时间",
      field: "startTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "作业结束时间",
      field: "endTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "是否承包商作业",
      field: 'isContractorWork',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
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
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业名称!'},
          ];
     },
  },
  {
    label: '作业类型',
    field: 'ticketType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zylx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业类型!'},
          ];
     },
  },
  {
    label: '作业开始时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业开始时间!'},
          ];
     },
  },
  {
    label: '作业结束时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业结束时间!'},
          ];
     },
  },
  {
    label: '作业地点',
    field: 'ticketPosition',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业地点!'},
          ];
     },
  },
  {
    label: '作业内容',
    field: 'jobContent',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业内容!'},
          ];
     },
  },
  {
    label: '安全监护人员姓名',
    field: 'supervisorName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入安全监护人员姓名!'},
          ];
     },
  },
  {
    label: '施工人员姓名',
    field: 'workerName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入施工人员姓名!'},
          ];
     },
  },
  {
    label: '施工单位名称',
    field: 'workDepartment',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入施工单位名称!'},
          ];
     },
  },
  {
    label: '施工人员编码',
    field: 'personId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入施工人员编码!'},
          ];
     },
  },
  {
    label: '施工单位统一社会信用代码',
    field: 'socialCreditCode',
    component: 'Input',
  },
  {
    label: '是否承包商作业',
    field: 'isContractorWork',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否承包商作业!'},
          ];
     },
  },
  {
    label: '作业负责人',
    field: 'ticketResponsName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入作业负责人!'},
          ];
     },
  },
  {
    label: '负责人联系方式',
    field: 'majorPersonMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人联系方式!'},
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  ticketType: {title: '作业类型',order: 2,view: 'list', type: 'string',dictCode: 'zylx',},
  startTime: {title: '作业开始时间',order: 3,view: 'date', type: 'string',},
  endTime: {title: '作业结束时间',order: 4,view: 'date', type: 'string',},
  ticketPosition: {title: '作业地点',order: 5,view: 'text', type: 'string',},
  jobContent: {title: '作业内容',order: 6,view: 'text', type: 'string',},
  isContractorWork: {title: '是否承包商作业',order: 12,view: 'list', type: 'string',dictCode: 'sf',},
  ticketResponsName: {title: '作业负责人',order: 13,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}