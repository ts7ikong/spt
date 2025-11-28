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
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '统一信用代码',
    align:"center",
    dataIndex: 'socialCode'
   },
   {
    title: '第三方单位名称',
    align:"center",
    dataIndex: 'contractorName'
   },
   {
    title: '第三方单位类 型',
    align:"center",
    dataIndex: 'contractorType_dictText'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '第三方单位负责人',
    align:"center",
    dataIndex: 'responsiblePerson'
   },
   {
    title: '负责人联系方式',
    align:"center",
    dataIndex: 'responsibleMobile'
   },
   {
    title: '地址',
    align:"center",
    dataIndex: 'addressregistry'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '行政区划编码',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '黑名单原因',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '服务期限起',
    align:"center",
    dataIndex: 'serviceStart',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '服务期限止',
    align:"center",
    dataIndex: 'serviceEnd',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '营业执照',
    align:"center",
    dataIndex: 'businessLicense',
    customRender:render.renderImage,
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted_dictText'
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
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "第三方单位名称",
    field: "contractorName",
    component: 'JInput',
  },
	{
      label: "第三方单位类 型",
      field: 'contractorType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"cbslx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "上报企业编码",
    field: "companyCode",
    component: 'JInput',
  },
	{
      label: "地址",
      field: 'addressregistry',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zt"
      },
      //colProps: {span: 6},
 	},
  {
    label: "行政区划编码",
    field: "areaCode",
    component: 'JInput',
  },
     {
      label: "服务期限起",
      field: "serviceStart",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "服务期限止",
      field: "serviceEnd",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
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
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
  },
  {
    label: '统一信用代码',
    field: 'socialCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入统一信用代码!'},
          ];
     },
  },
  {
    label: '第三方单位名称',
    field: 'contractorName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位名称!'},
          ];
     },
  },
  {
    label: '第三方单位类 型',
    field: 'contractorType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cbslx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位类 型!'},
          ];
     },
  },
  {
    label: '上报企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入上报企业编码!'},
          ];
     },
  },
  {
    label: '第三方单位负责人',
    field: 'responsiblePerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位负责人!'},
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
    field: 'addressregistry',
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
        dictCode:"zt"
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
    component: 'Input',
  },
  {
    label: '服务期限起',
    field: 'serviceStart',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入服务期限起!'},
          ];
     },
  },
  {
    label: '服务期限止',
    field: 'serviceEnd',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入服务期限止!'},
          ];
     },
  },
  {
    label: '营业执照',
    field: 'businessLicense',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入营业执照!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    defaultValue: "0",
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
  parkCode: {title: '园区编号',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  socialCode: {title: '统一信用代码',order: 2,view: 'text', type: 'string',},
  contractorName: {title: '第三方单位名称',order: 3,view: 'text', type: 'string',},
  contractorType: {title: '第三方单位类 型',order: 4,view: 'list', type: 'string',dictCode: 'cbslx',},
  companyCode: {title: '上报企业编码',order: 5,view: 'text', type: 'string',},
  responsiblePerson: {title: '第三方单位负责人',order: 6,view: 'text', type: 'string',},
  responsibleMobile: {title: '负责人联系方式',order: 7,view: 'text', type: 'string',},
  addressregistry: {title: '地址',order: 8,view: 'text', type: 'string',},
  status: {title: '状态',order: 9,view: 'list', type: 'string',dictCode: 'zt',},
  areaCode: {title: '行政区划编码',order: 10,view: 'text', type: 'string',},
  description: {title: '黑名单原因',order: 11,view: 'text', type: 'string',},
  serviceStart: {title: '服务期限起',order: 12,view: 'date', type: 'string',},
  serviceEnd: {title: '服务期限止',order: 13,view: 'date', type: 'string',},
  businessLicense: {title: '营业执照',order: 14,view: 'image', type: 'string',},
  deleted: {title: '删除标志',order: 15,view: 'list', type: 'string',dictCode: 'scbz',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}