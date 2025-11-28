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
    title: '人员姓名',
    align:"center",
    dataIndex: 'personName'
   },
   {
    title: '人员编码 ',
    align:"center",
    dataIndex: 'staffCode'
   },
   {
    title: '人员类型',
    align:"center",
    dataIndex: 'personType_dictText'
   },
   {
    title: '出生日期',
    align:"center",
    dataIndex: 'birthday'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'gender_dictText'
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
    label: "人员姓名",
    field: "personName",
    component: 'JInput',
  },
  {
    label: "人员编码 ",
    field: "staffCode",
    component: 'JInput',
  },
	{
      label: "人员类型",
      field: 'personType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rydwrylx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "联系电话",
    field: "mobileNumber",
    component: 'JInput',
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
  },
  {
    label: '人员姓名',
    field: 'personName',
    component: 'Input',
  },
  {
    label: '人员编码 ',
    field: 'staffCode',
    component: 'Input',
  },
  {
    label: '人员类型',
    field: 'personType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rydwrylx"
     },
  },
  {
    label: '出生日期',
    field: 'birthday',
    component: 'Input',
  },
  {
    label: '性别',
    field: 'gender',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xb"
     },
  },
  {
    label: '岗位名称',
    field: 'positionName',
    component: 'Input',
  },
  {
    label: '联系电话',
    field: 'mobileNumber',
    component: 'Input',
  },
  {
    label: '部门名称',
    field: 'affiliatedDepartment',
    component: 'Input',
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '修改人姓名',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '修改时间',
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
  personName: {title: '人员姓名',order: 1,view: 'text', type: 'string',},
  staffCode: {title: '人员编码 ',order: 2,view: 'text', type: 'string',},
  personType: {title: '人员类型',order: 3,view: 'list', type: 'string',dictCode: 'rydwrylx',},
  birthday: {title: '出生日期',order: 4,view: 'text', type: 'string',},
  gender: {title: '性别',order: 5,view: 'list', type: 'string',dictCode: 'xb',},
  positionName: {title: '岗位名称',order: 6,view: 'text', type: 'string',},
  mobileNumber: {title: '联系电话',order: 7,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}