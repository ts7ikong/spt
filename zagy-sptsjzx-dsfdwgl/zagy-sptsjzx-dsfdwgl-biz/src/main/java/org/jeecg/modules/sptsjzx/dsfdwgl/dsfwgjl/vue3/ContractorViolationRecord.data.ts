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
    title: '违规发生地点',
    align:"center",
    dataIndex: 'place'
   },
   {
    title: '违规描述内容',
    align:"center",
    dataIndex: 'disposeDesc'
   },
   {
    title: '违规发生时间',
    align:"center",
    dataIndex: 'startTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
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
    label: "违规描述内容",
    field: "disposeDesc",
    component: 'JInput',
  },
     {
      label: "违规发生时间",
      field: "startTime",
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
    label: '违规发生地点',
    field: 'place',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入违规发生地点!'},
          ];
     },
  },
  {
    label: '违规描述内容',
    field: 'disposeDesc',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入违规描述内容!'},
          ];
     },
  },
  {
    label: '处理过程描述',
    field: 'disposeProcess',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处理过程描述!'},
          ];
     },
  },
  {
    label: '违规发生时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入违规发生时间!'},
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
  socialCode: {title: '第三方单位名称',order: 1,view: 'sel_search', type: 'string',dictTable: "contractor_basic_info", dictCode: 'social_code', dictText: 'company_name',},
  reportCompanyCode: {title: '上报企业',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  place: {title: '违规发生地点',order: 3,view: 'text', type: 'string',},
  disposeDesc: {title: '违规描述内容',order: 4,view: 'text', type: 'string',},
  startTime: {title: '违规发生时间',order: 6,view: 'date', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}