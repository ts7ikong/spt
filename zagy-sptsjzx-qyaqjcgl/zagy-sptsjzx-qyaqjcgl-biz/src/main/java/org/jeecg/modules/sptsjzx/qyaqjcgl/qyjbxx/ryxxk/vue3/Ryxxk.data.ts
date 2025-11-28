import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '姓名',
    align:"center",
    dataIndex: 'personName'
   },
   {
    title: '工号',
    align:"center",
    dataIndex: 'jobCode'
   },
   {
    title: '人员类型',
    align:"center",
    dataIndex: 'personType_dictText'
   },
   {
    title: '出生日期',
    align:"center",
    dataIndex: 'birthDate'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'gender'
   },
   {
    title: '岗位名称',
    align:"center",
    dataIndex: 'positionName'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'mobileNumber'
   },
   {
    title: '最后毕业院校',
    align:"center",
    dataIndex: 'lastGradCollege'
   },
   {
    title: '专业',
    align:"center",
    dataIndex: 'major'
   },
   {
    title: '职称',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '是否具备化工 学历背景',
    align:"center",
    dataIndex: 'chemicalDiploma_dictText'
   },
   {
    title: '是否取得注册 安全工程师资 格',
    align:"center",
    dataIndex: 'certifiedSafetyEngineer_dictText'
   },
   {
    title: '证书名称',
    align:"center",
    dataIndex: 'certiName'
   },
   {
    title: '证书编号',
    align:"center",
    dataIndex: 'certiNum'
   },
   {
    title: '证书初领时间',
    align:"center",
    dataIndex: 'firstIssuDate'
   },
   {
    title: '证书有效期起',
    align:"center",
    dataIndex: 'effStime'
   },
   {
    title: '证书有效期止',
    align:"center",
    dataIndex: 'effEtime'
   },
   {
    title: '所属部门',
    align:"center",
    dataIndex: 'affiliatedDepartment'
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
    label: "姓名",
    field: "personName",
    component: 'JInput',
  },
	{
      label: "人员类型",
      field: 'personType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rylx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "联系电话",
    field: "mobileNumber",
    component: 'JInput',
  },
	{
      label: "是否具备化工 学历背景",
      field: 'chemicalDiploma',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfbz"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否取得注册 安全工程师资 格",
      field: 'certifiedSafetyEngineer',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfbz"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
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
    label: '姓名',
    field: 'personName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入姓名!'},
          ];
     },
  },
  {
    label: '工号',
    field: 'jobCode',
    component: 'Input',
  },
  {
    label: '人员类型',
    field: 'personType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rylx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员类型!'},
          ];
     },
  },
  {
    label: '出生日期',
    field: 'birthDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入出生日期!'},
          ];
     },
  },
  {
    label: '性别',
    field: 'gender',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入性别!'},
          ];
     },
  },
  {
    label: '岗位名称',
    field: 'positionName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入岗位名称!'},
          ];
     },
  },
  {
    label: '联系电话',
    field: 'mobileNumber',
    component: 'Input',
  },
  {
    label: '最后毕业院校',
    field: 'lastGradCollege',
    component: 'Input',
  },
  {
    label: '专业',
    field: 'major',
    component: 'Input',
  },
  {
    label: '职称',
    field: 'title',
    component: 'Input',
  },
  {
    label: '是否具备化工 学历背景',
    field: 'chemicalDiploma',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfbz"
     },
  },
  {
    label: '是否取得注册 安全工程师资 格',
    field: 'certifiedSafetyEngineer',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfbz"
     },
  },
  {
    label: '证书名称',
    field: 'certiName',
    component: 'Input',
  },
  {
    label: '证书编号',
    field: 'certiNum',
    component: 'Input',
  },
  {
    label: '证书初领时间',
    field: 'firstIssuDate',
    component: 'Input',
  },
  {
    label: '证书有效期起',
    field: 'effStime',
    component: 'Input',
  },
  {
    label: '证书有效期止',
    field: 'effEtime',
    component: 'Input',
  },
  {
    label: '所属部门',
    field: 'affiliatedDepartment',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属部门!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建日期',
    field: 'createTime',
    component: 'Input',
  },
  {
    label: '更新人',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '更新日期',
    field: 'updateDate',
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
  companyCode: {title: '企业名称',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  personName: {title: '姓名',order: 1,view: 'text', type: 'string',},
  jobCode: {title: '工号',order: 2,view: 'text', type: 'string',},
  personType: {title: '人员类型',order: 3,view: 'list', type: 'string',dictCode: 'rylx',},
  birthDate: {title: '出生日期',order: 4,view: 'text', type: 'string',},
  gender: {title: '性别',order: 5,view: 'text', type: 'string',},
  positionName: {title: '岗位名称',order: 6,view: 'text', type: 'string',},
  mobileNumber: {title: '联系电话',order: 7,view: 'text', type: 'string',},
  lastGradCollege: {title: '最后毕业院校',order: 8,view: 'text', type: 'string',},
  major: {title: '专业',order: 9,view: 'text', type: 'string',},
  title: {title: '职称',order: 10,view: 'text', type: 'string',},
  chemicalDiploma: {title: '是否具备化工 学历背景',order: 11,view: 'list', type: 'string',dictCode: 'sfbz',},
  certifiedSafetyEngineer: {title: '是否取得注册 安全工程师资 格',order: 12,view: 'list', type: 'string',dictCode: 'sfbz',},
  certiName: {title: '证书名称',order: 13,view: 'text', type: 'string',},
  certiNum: {title: '证书编号',order: 14,view: 'text', type: 'string',},
  firstIssuDate: {title: '证书初领时间',order: 15,view: 'text', type: 'string',},
  effStime: {title: '证书有效期起',order: 16,view: 'text', type: 'string',},
  effEtime: {title: '证书有效期止',order: 17,view: 'text', type: 'string',},
  affiliatedDepartment: {title: '所属部门',order: 18,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}