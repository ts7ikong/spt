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
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '装置编号',
    align:"center",
    dataIndex: 'deviceCode'
   },
   {
    title: '装置名称',
    align:"center",
    dataIndex: 'deviceName'
   },
   {
    title: '开停车类型',
    align:"center",
    dataIndex: 'startStopType_dictText'
   },
   {
    title: '当前状态',
    align:"center",
    dataIndex: 'operationStatus_dictText'
   },
   {
    title: '开始时间',
    align:"center",
    dataIndex: 'startTime'
   },
   {
    title: '计划结束时间',
    align:"center",
    dataIndex: 'expireTime'
   },
   {
    title: '实际完成时间',
    align:"center",
    dataIndex: 'endTime'
   },
   {
    title: '开停车责任人',
    align:"center",
    dataIndex: 'startPersonName'
   },
   {
    title: '开停车责任人手机号',
    align:"center",
    dataIndex: 'startPersonMobile'
   },
   {
    title: '是否摘除联锁',
    align:"center",
    dataIndex: 'whetherRemove_dictText'
   },
   {
    title: '绑定应急预案',
    align:"center",
    dataIndex: 'emergencyPlan'
   },
   {
    title: '责任人',
    align:"center",
    dataIndex: 'responsiblePerson'
   },
   {
    title: '联系方式',
    align:"center",
    dataIndex: 'contactInformation'
   },
   {
    title: '重大危险源编码',
    align:"center",
    dataIndex: 'hazardCode'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
   {
    title: '备案资料（附 件）',
    align:"center",
    dataIndex: 'recordName',
    customRender:render.renderImage,
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
      label: "园区编号",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "装置名称",
    field: "deviceName",
    component: 'JInput',
  },
	{
      label: "开停车类型",
      field: 'startStopType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"ktclx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "当前状态",
      field: 'operationStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dqzt"
      },
      //colProps: {span: 6},
 	},
     {
      label: "开始时间",
      field: "startTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "计划结束时间",
      field: "expireTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "实际完成时间",
      field: "endTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "开停车责任人",
      field: 'startPersonName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "开停车责任人手机号",
      field: 'startPersonMobile',
      component: 'Input',
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
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '装置编号',
    field: 'deviceCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置编号!'},
          ];
     },
  },
  {
    label: '装置名称',
    field: 'deviceName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置名称!'},
          ];
     },
  },
  {
    label: '开停车类型',
    field: 'startStopType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"ktclx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入开停车类型!'},
          ];
     },
  },
  {
    label: '当前状态',
    field: 'operationStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dqzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入当前状态!'},
          ];
     },
  },
  {
    label: '开始时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入开始时间!'},
          ];
     },
  },
  {
    label: '计划结束时间',
    field: 'expireTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '实际完成时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '开停车责任人',
    field: 'startPersonName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入开停车责任人!'},
          ];
     },
  },
  {
    label: '开停车责任人手机号',
    field: 'startPersonMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入开停车责任人手机号!'},
          ];
     },
  },
  {
    label: '是否摘除联锁',
    field: 'whetherRemove',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfzcls"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否摘除联锁!'},
          ];
     },
  },
  {
    label: '绑定应急预案',
    field: 'emergencyPlan',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入绑定应急预案!'},
          ];
     },
  },
  {
    label: '责任人',
    field: 'responsiblePerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入责任人!'},
          ];
     },
  },
  {
    label: '联系方式',
    field: 'contactInformation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入联系方式!'},
          ];
     },
  },
  {
    label: '重大危险源编码',
    field: 'hazardCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入重大危险源编码!'},
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
  {
    label: '备案资料（附 件）',
    field: 'recordName',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入备案资料（附 件）!'},
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
  parkCode: {title: '园区编号',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  companyCode: {title: '企业编码',order: 2,view: 'text', type: 'string',},
  deviceCode: {title: '装置编号',order: 3,view: 'text', type: 'string',},
  deviceName: {title: '装置名称',order: 4,view: 'text', type: 'string',},
  startStopType: {title: '开停车类型',order: 5,view: 'list', type: 'string',dictCode: 'ktclx',},
  operationStatus: {title: '当前状态',order: 6,view: 'list', type: 'string',dictCode: 'dqzt',},
  startTime: {title: '开始时间',order: 7,view: 'datetime', type: 'string',},
  expireTime: {title: '计划结束时间',order: 8,view: 'datetime', type: 'string',},
  endTime: {title: '实际完成时间',order: 9,view: 'datetime', type: 'string',},
  startPersonName: {title: '开停车责任人',order: 10,view: 'text', type: 'string',},
  startPersonMobile: {title: '开停车责任人手机号',order: 11,view: 'text', type: 'string',},
  whetherRemove: {title: '是否摘除联锁',order: 12,view: 'list', type: 'string',dictCode: 'sfzcls',},
  emergencyPlan: {title: '绑定应急预案',order: 13,view: 'text', type: 'string',},
  responsiblePerson: {title: '责任人',order: 14,view: 'text', type: 'string',},
  contactInformation: {title: '联系方式',order: 15,view: 'text', type: 'string',},
  hazardCode: {title: '重大危险源编码',order: 16,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 17,view: 'list', type: 'string',dictCode: 'scbz',},
  recordName: {title: '备案资料（附 件）',order: 18,view: 'image', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 19,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 20,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 21,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 22,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}