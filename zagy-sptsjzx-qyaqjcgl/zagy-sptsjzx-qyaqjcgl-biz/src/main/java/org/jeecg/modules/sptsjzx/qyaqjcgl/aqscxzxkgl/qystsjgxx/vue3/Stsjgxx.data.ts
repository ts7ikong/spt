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
    title: '装置名称',
    align:"center",
    dataIndex: 'plantName'
   },
   {
    title: '装置编码',
    align:"center",
    dataIndex: 'plantCode'
   },
   {
    title: '项目名称',
    align:"center",
    dataIndex: 'projectName'
   },
   {
    title: '项目类型',
    align:"center",
    dataIndex: 'projectType_dictText'
   },
   {
    title: '项目开始日期',
    align:"center",
    dataIndex: 'projectBeginDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '项目结束日期',
    align:"center",
    dataIndex: 'projectEndDate'
   },
   {
    title: '项目描述',
    align:"center",
    dataIndex: 'projectDesc'
   },
   {
    title: '项目状态',
    align:"center",
    dataIndex: 'projectStatus_dictText'
   },
   {
    title: '立项申请日期',
    align:"center",
    dataIndex: 'approvalApplyForDate'
   },
   {
    title: '立项通过日期',
    align:"center",
    dataIndex: 'approvalPassDate'
   },
   {
    title: '设计开始日期',
    align:"center",
    dataIndex: 'designBeginDate'
   },
   {
    title: '设计结束日期',
    align:"center",
    dataIndex: 'designEndDate'
   },
   {
    title: '建设施工开始日期',
    align:"center",
    dataIndex: 'buildBeginDate'
   },
   {
    title: '建设施工结束日期',
    align:"center",
    dataIndex: 'buildEndDate'
   },
   {
    title: '试生产开始日期',
    align:"center",
    dataIndex: 'testProductionBeginDate'
   },
   {
    title: '试生产结束日期',
    align:"center",
    dataIndex: 'testProductionEndDate'
   },
   {
    title: '验收开始日期',
    align:"center",
    dataIndex: 'acceptanceBeginDate'
   },
   {
    title: '验收结束日期',
    align:"center",
    dataIndex: 'acceptanceEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '立项审批状态',
    align:"center",
    dataIndex: 'approvalStatus_dictText'
   },
   {
    title: '设计审批状态',
    align:"center",
    dataIndex: 'designStatus_dictText'
   },
   {
    title: '建设施工审批状态',
    align:"center",
    dataIndex: 'buildStatus_dictText'
   },
   {
    title: '试生产审批状态',
    align:"center",
    dataIndex: 'testProductionStatus_dictText'
   },
   {
    title: '验收审批状态',
    align:"center",
    dataIndex: 'acceptanceStatus_dictText'
   },
   {
    title: '总体项目开始时间',
    align:"center",
    dataIndex: 'overallProjectStartTime'
   },
   {
    title: '总体项目结束时间',
    align:"center",
    dataIndex: 'overallProjectEndTime'
   },
   {
    title: '当前阶段',
    align:"center",
    dataIndex: 'currentGeneration'
   },
   {
    title: '所属阶段开始时间',
    align:"center",
    dataIndex: 'designPhaseStartTime'
   },
   {
    title: '所属阶段结束时间',
    align:"center",
    dataIndex: 'designPhaseEndTime'
   },
   {
    title: '所属阶段资料台账',
    align:"center",
    dataIndex: 'designPhaseRecordsAccount'
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
      label: "项目类型",
      field: 'projectType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"xmlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "项目开始日期",
      field: 'projectBeginDate',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "项目状态",
      field: 'projectStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"xmzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "验收结束日期",
      field: 'acceptanceEndDate',
      component: 'DatePicker',
      componentProps: {
        valueFormat: 'YYYY-MM-DD'
      },
      //colProps: {span: 6},
 	},
	{
      label: "立项审批状态",
      field: 'approvalStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "设计审批状态",
      field: 'designStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "建设施工审批状态",
      field: 'buildStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "试生产审批状态",
      field: 'testProductionStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "验收审批状态",
      field: 'acceptanceStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"stsjgspzt"
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
    label: '装置名称',
    field: 'plantName',
    component: 'Input',
  },
  {
    label: '装置编码',
    field: 'plantCode',
    component: 'Input',
  },
  {
    label: '项目名称',
    field: 'projectName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目名称!'},
          ];
     },
  },
  {
    label: '项目类型',
    field: 'projectType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xmlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目类型!'},
          ];
     },
  },
  {
    label: '项目开始日期',
    field: 'projectBeginDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目开始日期!'},
          ];
     },
  },
  {
    label: '项目结束日期',
    field: 'projectEndDate',
    component: 'Input',
  },
  {
    label: '项目描述',
    field: 'projectDesc',
    component: 'InputTextArea',
  },
  {
    label: '项目状态',
    field: 'projectStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"xmzt"
     },
  },
  {
    label: '立项申请日期',
    field: 'approvalApplyForDate',
    component: 'Input',
  },
  {
    label: '立项通过日期',
    field: 'approvalPassDate',
    component: 'Input',
  },
  {
    label: '设计开始日期',
    field: 'designBeginDate',
    component: 'Input',
  },
  {
    label: '设计结束日期',
    field: 'designEndDate',
    component: 'Input',
  },
  {
    label: '建设施工开始日期',
    field: 'buildBeginDate',
    component: 'Input',
  },
  {
    label: '建设施工结束日期',
    field: 'buildEndDate',
    component: 'Input',
  },
  {
    label: '试生产开始日期',
    field: 'testProductionBeginDate',
    component: 'Input',
  },
  {
    label: '试生产结束日期',
    field: 'testProductionEndDate',
    component: 'Input',
  },
  {
    label: '验收开始日期',
    field: 'acceptanceBeginDate',
    component: 'Input',
  },
  {
    label: '验收结束日期',
    field: 'acceptanceEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '立项审批状态',
    field: 'approvalStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '设计审批状态',
    field: 'designStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '建设施工审批状态',
    field: 'buildStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '试生产审批状态',
    field: 'testProductionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '验收审批状态',
    field: 'acceptanceStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"stsjgspzt"
     },
  },
  {
    label: '总体项目开始时间',
    field: 'overallProjectStartTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总体项目开始时间!'},
          ];
     },
  },
  {
    label: '总体项目结束时间',
    field: 'overallProjectEndTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总体项目结束时间!'},
          ];
     },
  },
  {
    label: '当前阶段',
    field: 'currentGeneration',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入当前阶段!'},
          ];
     },
  },
  {
    label: '所属阶段开始时间',
    field: 'designPhaseStartTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属阶段开始时间!'},
          ];
     },
  },
  {
    label: '所属阶段结束时间',
    field: 'designPhaseEndTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属阶段结束时间!'},
          ];
     },
  },
  {
    label: '所属阶段资料台账',
    field: 'designPhaseRecordsAccount',
    component: 'Input',
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
    field: 'updateTime',
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
  plantName: {title: '装置名称',order: 2,view: 'text', type: 'string',},
  plantCode: {title: '装置编码',order: 3,view: 'text', type: 'string',},
  projectName: {title: '项目名称',order: 4,view: 'text', type: 'string',},
  projectType: {title: '项目类型',order: 5,view: 'list', type: 'string',dictCode: 'xmlx',},
  projectBeginDate: {title: '项目开始日期',order: 6,view: 'date', type: 'string',},
  projectEndDate: {title: '项目结束日期',order: 7,view: 'text', type: 'string',},
  projectDesc: {title: '项目描述',order: 8,view: 'textarea', type: 'string',},
  projectStatus: {title: '项目状态',order: 9,view: 'list', type: 'string',dictCode: 'xmzt',},
  approvalApplyForDate: {title: '立项申请日期',order: 10,view: 'text', type: 'string',},
  approvalPassDate: {title: '立项通过日期',order: 11,view: 'text', type: 'string',},
  designBeginDate: {title: '设计开始日期',order: 12,view: 'text', type: 'string',},
  designEndDate: {title: '设计结束日期',order: 13,view: 'text', type: 'string',},
  buildBeginDate: {title: '建设施工开始日期',order: 14,view: 'text', type: 'string',},
  buildEndDate: {title: '建设施工结束日期',order: 15,view: 'text', type: 'string',},
  testProductionBeginDate: {title: '试生产开始日期',order: 16,view: 'text', type: 'string',},
  testProductionEndDate: {title: '试生产结束日期',order: 17,view: 'text', type: 'string',},
  acceptanceBeginDate: {title: '验收开始日期',order: 18,view: 'text', type: 'string',},
  acceptanceEndDate: {title: '验收结束日期',order: 19,view: 'date', type: 'string',},
  approvalStatus: {title: '立项审批状态',order: 20,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  designStatus: {title: '设计审批状态',order: 21,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  buildStatus: {title: '建设施工审批状态',order: 22,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  testProductionStatus: {title: '试生产审批状态',order: 23,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  acceptanceStatus: {title: '验收审批状态',order: 24,view: 'list', type: 'string',dictCode: 'stsjgspzt',},
  overallProjectStartTime: {title: '总体项目开始时间',order: 25,view: 'text', type: 'string',},
  overallProjectEndTime: {title: '总体项目结束时间',order: 26,view: 'text', type: 'string',},
  currentGeneration: {title: '当前阶段',order: 27,view: 'text', type: 'string',},
  designPhaseStartTime: {title: '所属阶段开始时间',order: 28,view: 'text', type: 'string',},
  designPhaseEndTime: {title: '所属阶段结束时间',order: 29,view: 'text', type: 'string',},
  designPhaseRecordsAccount: {title: '所属阶段资料台账',order: 30,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}