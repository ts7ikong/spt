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
    title: '任务类型',
    align:"center",
    dataIndex: 'workType_dictText'
   },
   {
    title: '管控措施 ID',
    align:"center",
    dataIndex: 'riskMeasureId'
   },
   {
    title: '隐患排查内容',
    align:"center",
    dataIndex: 'troubleshootContent'
   },
   {
    title: '巡检周期',
    align:"center",
    dataIndex: 'checkCycle'
   },
   {
    title: '巡检周期单位',
    align:"center",
    dataIndex: 'checkCycleUnit'
   },
   {
    title: '工作开始时间',
    align:"center",
    dataIndex: 'workStartTime'
   },
   {
    title: '工作日类型',
    align:"center",
    dataIndex: 'workDayType'
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
      label: "任务类型",
      field: 'workType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhrwlx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "隐患排查内容",
    field: "troubleshootContent",
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
    label: '任务类型',
    field: 'workType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhrwlx"
     },
  },
  {
    label: '管控措施 ID',
    field: 'riskMeasureId',
    component: 'Input',
  },
  {
    label: '所属日周月清单id',
    field: 'qdId',
    component: 'InputTextArea',
  },
  {
    label: '隐患排查内容',
    field: 'troubleshootContent',
    component: 'Input',
  },
  {
    label: '巡检周期',
    field: 'checkCycle',
    component: 'InputNumber',
  },
  {
    label: '巡检周期单位',
    field: 'checkCycleUnit',
    component: 'Input',
  },
  {
    label: '任务开始时间',
    field: 'taskStartTime',
    component: 'Input',
  },
  {
    label: '工作开始时间',
    field: 'workStartTime',
    component: 'Input',
  },
  {
    label: '工作结束时间',
    field: 'workEndTime',
    component: 'Input',
  },
  {
    label: '工作日类型',
    field: 'workDayType',
    component: 'Input',
  },
  {
    label: '包保任务对应项',
    field: 'taskNum',
    component: 'Input',
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
    label: '数据是否齐全',
    field: 'isCompleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
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
  companyCode: {title: '企业名称',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  workType: {title: '任务类型',order: 1,view: 'list', type: 'string',dictCode: 'yhrwlx',},
  riskMeasureId: {title: '管控措施 ID',order: 2,view: 'text', type: 'string',},
  troubleshootContent: {title: '隐患排查内容',order: 4,view: 'text', type: 'string',},
  checkCycle: {title: '巡检周期',order: 5,view: 'number', type: 'number',},
  checkCycleUnit: {title: '巡检周期单位',order: 6,view: 'text', type: 'string',},
  workStartTime: {title: '工作开始时间',order: 8,view: 'text', type: 'string',},
  workDayType: {title: '工作日类型',order: 10,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}