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
    title: '风险事件
ID',
    align:"center",
    dataIndex: 'riskEventId'
   },
   {
    title: '管控方式',
    align:"center",
    dataIndex: 'dataSrc_dictText'
   },
   {
    title: '管控措施描述',
    align:"center",
    dataIndex: 'riskMeasureDesc'
   },
   {
    title: '管控措施分类1',
    align:"center",
    dataIndex: 'classify1_dictText'
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
      label: "管控方式",
      field: 'dataSrc',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gkfs"
      },
      //colProps: {span: 6},
 	},
  {
    label: "管控措施描述",
    field: "riskMeasureDesc",
    component: 'JInput',
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'UUID',
    field: 'uuid',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '风险事件
ID',
    field: 'riskEventId',
    component: 'Input',
  },
  {
    label: '管控方式',
    field: 'dataSrc',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gkfs"
     },
  },
  {
    label: '管控措施描述',
    field: 'riskMeasureDesc',
    component: 'Input',
  },
  {
    label: '管控措施分类1',
    field: 'classify1',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gkcsfl1"
     },
  },
  {
    label: '管控措施分类2',
    field: 'classify2',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"gkcsfl2"
     },
  },
  {
    label: '管控措施分类3',
    field: 'classify3',
    component: 'InputTextArea',
  },
  {
    label: '是否激活',
    field: 'isActivation',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfjh"
     },
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  riskEventId: {title: '风险事件
ID',order: 2,view: 'text', type: 'string',},
  dataSrc: {title: '管控方式',order: 3,view: 'list', type: 'string',dictCode: 'gkfs',},
  riskMeasureDesc: {title: '管控措施描述',order: 4,view: 'text', type: 'string',},
  classify1: {title: '管控措施分类1',order: 5,view: 'list', type: 'string',dictCode: 'gkcsfl1',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}