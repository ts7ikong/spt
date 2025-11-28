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
    title: '岗位名称',
    align:"center",
    dataIndex: 'positon'
   },
   {
    title: '责任部门',
    align:"center",
    dataIndex: 'hazardDep'
   },
   {
    title: '责任部门负责人姓名',
    align:"center",
    dataIndex: 'hazardLiablePerson'
   },
   {
    title: '作业程序',
    align:"center",
    dataIndex: 'program'
   },
   {
    title: '作业标准及注意事项',
    align:"center",
    dataIndex: 'attention'
   },
   {
    title: '作业顺序',
    align:"center",
    dataIndex: 'index'
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
    label: "岗位名称",
    field: "positon",
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
    label: '岗位唯一uuid',
    field: 'positonid',
    component: 'Input',
  },
  {
    label: '岗位名称',
    field: 'positon',
    component: 'Input',
  },
  {
    label: '责任部门',
    field: 'hazardDep',
    component: 'Input',
  },
  {
    label: '责任部门负责人姓名',
    field: 'hazardLiablePerson',
    component: 'Input',
  },
  {
    label: '作业程序',
    field: 'program',
    component: 'InputTextArea',
  },
  {
    label: '作业标准及注意事项',
    field: 'attention',
    component: 'InputTextArea',
  },
  {
    label: '作业顺序',
    field: 'index',
    component: 'InputNumber',
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
  positon: {title: '岗位名称',order: 2,view: 'text', type: 'string',},
  hazardDep: {title: '责任部门',order: 3,view: 'text', type: 'string',},
  hazardLiablePerson: {title: '责任部门负责人姓名',order: 4,view: 'text', type: 'string',},
  program: {title: '作业程序',order: 5,view: 'textarea', type: 'string',},
  attention: {title: '作业标准及注意事项',order: 6,view: 'textarea', type: 'string',},
  index: {title: '作业顺序',order: 7,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}