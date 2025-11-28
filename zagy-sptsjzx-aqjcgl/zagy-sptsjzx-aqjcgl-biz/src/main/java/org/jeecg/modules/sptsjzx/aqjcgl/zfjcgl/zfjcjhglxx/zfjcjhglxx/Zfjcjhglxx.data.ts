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
    title: '执法检查单位',
    align:"center",
    dataIndex: 'enforcementUnit'
   },
   {
    title: '执法检查编号',
    align:"center",
    dataIndex: 'enforcementId'
   },
   {
    title: '执法检查计划类型',
    align:"center",
    dataIndex: 'enforcementType_dictText'
   },
   {
    title: '执法检查开始时间',
    align:"center",
    dataIndex: 'enforcementStartTime'
   },
   {
    title: '执法检查结束时间',
    align:"center",
    dataIndex: 'enforcementEndTime'
   },
   {
    title: '是否明察暗访',
    align:"center",
    dataIndex: 'isCovertInspection_dictText'
   },
   {
    title: '是否举报核实',
    align:"center",
    dataIndex: 'isReportVerification_dictText'
   },
   {
    title: '执法检查任务描述',
    align:"center",
    dataIndex: 'lawEnTaskDes'
   },
   {
    title: '执法检查状态',
    align:"center",
    dataIndex: 'lawEnTaskStatus_dictText'
   },
   {
    title: '执法检查任务附件',
    align:"center",
    dataIndex: 'lawEnTaskMission',
   },
   {
    title: '发起人姓名',
    align:"center",
    dataIndex: 'initiatorName'
   },
   {
    title: '发起时间',
    align:"center",
    dataIndex: 'nitiatorTime'
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
    label: "执法检查单位",
    field: "enforcementUnit",
    component: 'JInput',
  },
  {
    label: "执法检查编号",
    field: "enforcementId",
    component: 'JInput',
  },
	{
      label: "执法检查计划类型",
      field: 'enforcementType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zfjcjhlx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "执法检查开始时间",
      field: "enforcementStartTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "执法检查结束时间",
      field: "enforcementEndTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "是否明察暗访",
      field: 'isCovertInspection',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否举报核实",
      field: 'isReportVerification',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfmcaf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "执法检查任务描述",
      field: 'lawEnTaskDes',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "执法检查状态",
      field: 'lawEnTaskStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zfjczt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "发起人姓名",
      field: 'initiatorName',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "发起时间",
      field: "nitiatorTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
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
                 {...rules.duplicateCheckRule('zfjcjhglxx', 'uuid',model,schema)[0]},
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
    label: '执法检查单位',
    field: 'enforcementUnit',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查单位!'},
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
    label: '执法检查计划类型',
    field: 'enforcementType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zfjcjhlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查计划类型!'},
          ];
     },
  },
  {
    label: '执法检查开始时间',
    field: 'enforcementStartTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查开始时间!'},
          ];
     },
  },
  {
    label: '执法检查结束时间',
    field: 'enforcementEndTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查结束时间!'},
          ];
     },
  },
  {
    label: '是否明察暗访',
    field: 'isCovertInspection',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否明察暗访!'},
          ];
     },
  },
  {
    label: '是否举报核实',
    field: 'isReportVerification',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfmcaf"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否举报核实!'},
          ];
     },
  },
  {
    label: '执法检查任务描述',
    field: 'lawEnTaskDes',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查任务描述!'},
          ];
     },
  },
  {
    label: '执法检查状态',
    field: 'lawEnTaskStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zfjczt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查状态!'},
          ];
     },
  },
  {
    label: '执法检查任务附件',
    field: 'lawEnTaskMission',
    component: 'JUpload',
    componentProps:{
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入执法检查任务附件!'},
          ];
     },
  },
  {
    label: '发起人姓名',
    field: 'initiatorName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发起人姓名!'},
          ];
     },
  },
  {
    label: '发起时间',
    field: 'nitiatorTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发起时间!'},
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
  enforcementUnit: {title: '执法检查单位',order: 2,view: 'text', type: 'string',},
  enforcementId: {title: '执法检查编号',order: 3,view: 'text', type: 'string',},
  enforcementType: {title: '执法检查计划类型',order: 4,view: 'list', type: 'string',dictCode: 'zfjcjhlx',},
  enforcementStartTime: {title: '执法检查开始时间',order: 5,view: 'datetime', type: 'string',},
  enforcementEndTime: {title: '执法检查结束时间',order: 6,view: 'datetime', type: 'string',},
  isCovertInspection: {title: '是否明察暗访',order: 7,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  isReportVerification: {title: '是否举报核实',order: 8,view: 'list', type: 'string',dictCode: 'sfmcaf',},
  lawEnTaskDes: {title: '执法检查任务描述',order: 9,view: 'textarea', type: 'string',},
  lawEnTaskStatus: {title: '执法检查状态',order: 10,view: 'list', type: 'string',dictCode: 'zfjczt',},
  lawEnTaskMission: {title: '执法检查任务附件',order: 11,view: 'file', type: 'string',},
  initiatorName: {title: '发起人姓名',order: 12,view: 'text', type: 'string',},
  nitiatorTime: {title: '发起时间',order: 13,view: 'datetime', type: 'string',},
  deleted: {title: '删除标志',order: 14,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 15,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 16,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 17,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 18,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}