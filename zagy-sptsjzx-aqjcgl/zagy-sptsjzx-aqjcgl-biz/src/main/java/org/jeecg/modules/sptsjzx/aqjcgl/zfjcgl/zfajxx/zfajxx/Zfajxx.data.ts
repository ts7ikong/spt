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
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '执法检查编号',
    align:"center",
    dataIndex: 'enforcementId'
   },
   {
    title: '案件名称',
    align:"center",
    dataIndex: 'caseName'
   },
   {
    title: '案件编号',
    align:"center",
    dataIndex: 'caseCode'
   },
   {
    title: '被检查企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '执法部门',
    align:"center",
    dataIndex: 'lawEnforcementDepartment'
   },
   {
    title: '执法人员',
    align:"center",
    dataIndex: 'inspectionPersonName'
   },
   {
    title: '立案时间',
    align:"center",
    dataIndex: 'filingTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '结案时间',
    align:"center",
    dataIndex: 'closingTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '执法文书',
    align:"center",
    dataIndex: 'enforceDoc',
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
    label: "UUID",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "执法检查编号",
    field: "enforcementId",
    component: 'JInput',
  },
  {
    label: "案件名称",
    field: "caseName",
    component: 'JInput',
  },
  {
    label: "案件编号",
    field: "caseCode",
    component: 'JInput',
  },
	{
      label: "被检查企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "执法部门",
    field: "lawEnforcementDepartment",
    component: 'JInput',
  },
  {
    label: "执法人员",
    field: "inspectionPersonName",
    component: 'JInput',
  },
     {
      label: "立案时间",
      field: "filingTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "结案时间",
      field: "closingTime",
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
    label: '园区编码',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '执法检查编号',
    field: 'enforcementId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查编号!'},
          ];
     },
  },
  {
    label: '案件名称',
    field: 'caseName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入案件名称!'},
          ];
     },
  },
  {
    label: '案件编号',
    field: 'caseCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入案件编号!'},
          ];
     },
  },
  {
    label: '被检查企业编码',
    field: 'companyCode',
    component: 'Input',
  },
  {
    label: '执法部门',
    field: 'lawEnforcementDepartment',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法部门!'},
          ];
     },
  },
  {
    label: '执法人员',
    field: 'inspectionPersonName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法人员!'},
          ];
     },
  },
  {
    label: '立案时间',
    field: 'filingTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入立案时间!'},
          ];
     },
  },
  {
    label: '结案时间',
    field: 'closingTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入结案时间!'},
          ];
     },
  },
  {
    label: '执法文书',
    field: 'enforceDoc',
    component: 'JUpload',
    componentProps:{
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法文书!'},
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  enforcementId: {title: '执法检查编号',order: 2,view: 'text', type: 'string',},
  caseName: {title: '案件名称',order: 3,view: 'text', type: 'string',},
  caseCode: {title: '案件编号',order: 4,view: 'text', type: 'string',},
  companyCode: {title: '被检查企业编码',order: 5,view: 'text', type: 'string',},
  lawEnforcementDepartment: {title: '执法部门',order: 6,view: 'text', type: 'string',},
  inspectionPersonName: {title: '执法人员',order: 7,view: 'text', type: 'string',},
  filingTime: {title: '立案时间',order: 8,view: 'date', type: 'string',},
  closingTime: {title: '结案时间',order: 9,view: 'date', type: 'string',},
  enforceDoc: {title: '执法文书',order: 10,view: 'file', type: 'string',},
  deleted: {title: '删除标志',order: 11,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 12,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 13,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 14,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}