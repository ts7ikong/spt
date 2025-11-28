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
    title: '风险点名称',
    align:"center",
    dataIndex: 'risklistName'
   },
   {
    title: '风险等级',
    align:"center",
    dataIndex: 'risklistLevel_dictText'
   },
   {
    title: '防控级别',
    align:"center",
    dataIndex: 'risklistPreventionlevel_dictText'
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
    title: '危险和有害因素',
    align:"center",
    dataIndex: 'risklistHarmful'
   },
   {
    title: '风险事件',
    align:"center",
    dataIndex: 'risklistConsequence'
   },
   {
    title: '管控措施',
    align:"center",
    dataIndex: 'risklistMeasure'
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
      label: "风险等级",
      field: 'risklistLevel',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"fxdj"
      },
      //colProps: {span: 6},
 	},
	{
      label: "防控级别",
      field: 'risklistPreventionlevel',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"fkjb"
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
  },
  {
    label: '风险点名称',
    field: 'risklistName',
    component: 'Input',
  },
  {
    label: '风险等级',
    field: 'risklistLevel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"fxdj"
     },
  },
  {
    label: '风险标志完整图片地址',
    field: 'risklistSafetymark',
    component: 'InputTextArea',
  },
  {
    label: '防控级别',
    field: 'risklistPreventionlevel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"fkjb"
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
    label: '危险和有害因素',
    field: 'risklistHarmful',
    component: 'InputTextArea',
  },
  {
    label: '风险事件',
    field: 'risklistConsequence',
    component: 'InputTextArea',
  },
  {
    label: '管控措施',
    field: 'risklistMeasure',
    component: 'InputTextArea',
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
  risklistName: {title: '风险点名称',order: 1,view: 'text', type: 'string',},
  risklistLevel: {title: '风险等级',order: 2,view: 'number', type: 'number',dictCode: 'fxdj',},
  risklistPreventionlevel: {title: '防控级别',order: 4,view: 'number', type: 'number',dictCode: 'fkjb',},
  positon: {title: '岗位名称',order: 6,view: 'text', type: 'string',},
  hazardDep: {title: '责任部门',order: 7,view: 'text', type: 'string',},
  hazardLiablePerson: {title: '责任部门负责人姓名',order: 8,view: 'text', type: 'string',},
  risklistHarmful: {title: '危险和有害因素',order: 9,view: 'textarea', type: 'string',},
  risklistConsequence: {title: '风险事件',order: 10,view: 'textarea', type: 'string',},
  risklistMeasure: {title: '管控措施',order: 11,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}