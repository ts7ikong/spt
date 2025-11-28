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
    title: '第三方单位统一社会信用代码',
    align:"center",
    dataIndex: 'socialCode'
   },
   {
    title: '第三方单位名称',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '类型',
    align:"center",
    dataIndex: 'companyType_dictText'
   },
   {
    title: '上报企业',
    align:"center",
    dataIndex: 'reportCompanyCode_dictText'
   },
   {
    title: '地址',
    align:"center",
    dataIndex: 'addressRegistry'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '服务期限起',
    align:"center",
    dataIndex: 'serviceStart'
   },
   {
    title: '服务期限止',
    align:"center",
    dataIndex: 'serviceEnd'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "第三方单位名称",
    field: "companyName",
    component: 'JInput',
  },
	{
      label: "类型",
      field: 'companyType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dsfdwlx"
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
    label: '第三方单位统一社会信用代码',
    field: 'socialCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位统一社会信用代码!'},
          ];
     },
  },
  {
    label: '第三方单位名称',
    field: 'companyName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位名称!'},
          ];
     },
  },
  {
    label: '类型',
    field: 'companyType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dsfdwlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入类型!'},
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
    label: '负责人姓名',
    field: 'responsiblePerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人姓名!'},
          ];
     },
  },
  {
    label: '负责人联系方式',
    field: 'responsibleMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人联系方式!'},
          ];
     },
  },
  {
    label: '地址',
    field: 'addressRegistry',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地址!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dsfdwzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '行政区划编码',
    field: 'areaCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入行政区划编码!'},
          ];
     },
  },
  {
    label: '黑名单原因',
    field: 'description',
    component: 'InputTextArea',
  },
  {
    label: '服务期限起',
    field: 'serviceStart',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入服务期限起!'},
          ];
     },
  },
  {
    label: '服务期限止',
    field: 'serviceEnd',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入服务期限止!'},
          ];
     },
  },
  {
    label: '营业执照URL',
    field: 'businessLicense',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入营业执照URL!'},
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
  socialCode: {title: '第三方单位统一社会信用代码',order: 1,view: 'text', type: 'string',},
  companyName: {title: '第三方单位名称',order: 2,view: 'text', type: 'string',},
  companyType: {title: '类型',order: 3,view: 'list', type: 'string',dictCode: 'dsfdwlx',},
  reportCompanyCode: {title: '上报企业',order: 4,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  addressRegistry: {title: '地址',order: 7,view: 'text', type: 'string',},
  status: {title: '状态',order: 8,view: 'list', type: 'string',dictCode: 'dsfdwzt',},
  serviceStart: {title: '服务期限起',order: 11,view: 'text', type: 'string',},
  serviceEnd: {title: '服务期限止',order: 12,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}