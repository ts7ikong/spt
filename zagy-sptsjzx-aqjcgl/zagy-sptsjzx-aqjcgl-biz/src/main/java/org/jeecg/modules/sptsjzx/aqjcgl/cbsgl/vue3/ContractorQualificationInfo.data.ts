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
    title: '第三方uuid',
    align:"center",
    dataIndex: 'contractorUuid_dictText'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '资质名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '证书编号',
    align:"center",
    dataIndex: 'code'
   },
   {
    title: '资质等级',
    align:"center",
    dataIndex: 'level'
   },
   {
    title: '有效期起',
    align:"center",
    dataIndex: 'starttime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '有效期止',
    align:"center",
    dataIndex: 'endtime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
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
      label: "第三方uuid",
      field: 'contractorUuid',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"contractor_basic_information,contractor_name,uuid"
      },
      //colProps: {span: 6},
 	},
  {
    label: "资质名称",
    field: "name",
    component: 'JInput',
  },
  {
    label: "证书编号",
    field: "code",
    component: 'JInput',
  },
     {
      label: "有效期起",
      field: "starttime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "有效期止",
      field: "endtime",
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
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编号!'},
          ];
     },
  },
  {
    label: '第三方uuid',
    field: 'contractorUuid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"contractor_basic_information,contractor_name,uuid"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方uuid!'},
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
    label: '资质名称',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资质名称!'},
          ];
     },
  },
  {
    label: '证书编号',
    field: 'code',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书编号!'},
          ];
     },
  },
  {
    label: '资质等级',
    field: 'level',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资质等级!'},
          ];
     },
  },
  {
    label: '有效期起',
    field: 'starttime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期起!'},
          ];
     },
  },
  {
    label: '有效期止',
    field: 'endtime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期止!'},
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
  contractorUuid: {title: '第三方uuid',order: 2,view: 'list', type: 'string',dictTable: "contractor_basic_information", dictCode: 'uuid', dictText: 'contractor_name',},
  companyCode: {title: '上报企业编码',order: 3,view: 'text', type: 'string',},
  name: {title: '资质名称',order: 4,view: 'text', type: 'string',},
  code: {title: '证书编号',order: 5,view: 'text', type: 'string',},
  level: {title: '资质等级',order: 6,view: 'text', type: 'string',},
  starttime: {title: '有效期起',order: 7,view: 'date', type: 'string',},
  endtime: {title: '有效期止',order: 8,view: 'date', type: 'string',},
  deleted: {title: '删除标志',order: 9,view: 'list', type: 'string',dictCode: 'scbz',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}