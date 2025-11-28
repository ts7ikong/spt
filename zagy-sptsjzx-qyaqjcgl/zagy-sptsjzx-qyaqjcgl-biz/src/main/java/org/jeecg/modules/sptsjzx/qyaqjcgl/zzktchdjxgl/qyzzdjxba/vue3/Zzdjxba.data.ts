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
    dataIndex: 'deviceName'
   },
   {
    title: '装置编号',
    align:"center",
    dataIndex: 'deviceCode'
   },
   {
    title: '检修名称',
    align:"center",
    dataIndex: 'maintenanceName'
   },
   {
    title: '重大危险源编码',
    align:"center",
    dataIndex: 'hazardCode'
   },
   {
    title: '大检修开始时间',
    align:"center",
    dataIndex: 'maintenanceStartTime'
   },
   {
    title: '大检修计划结束时间',
    align:"center",
    dataIndex: 'maintenanceExpireTime'
   },
   {
    title: '大检修实际结束时间',
    align:"center",
    dataIndex: 'maintenanceEndTime'
   },
   {
    title: '当前状态',
    align:"center",
    dataIndex: 'operationStatus_dictText'
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
    label: "装置名称",
    field: "deviceName",
    component: 'JInput',
  },
	{
      label: "当前状态",
      field: 'operationStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jxzt"
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
    field: 'deviceName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置名称!'},
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
    label: '装置负责人姓名',
    field: 'plantPrincipalPersonName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置负责人姓名!'},
          ];
     },
  },
  {
    label: '装置负责人手机号',
    field: 'plantPrincipalPersonMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入装置负责人手机号!'},
          ];
     },
  },
  {
    label: '检修名称',
    field: 'maintenanceName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入检修名称!'},
          ];
     },
  },
  {
    label: '检修内容',
    field: 'maintenanceContent',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入检修内容!'},
          ];
     },
  },
  {
    label: '重大危险源编码',
    field: 'hazardCode',
    component: 'Input',
  },
  {
    label: '大检修开始时间',
    field: 'maintenanceStartTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修开始时间!'},
          ];
     },
  },
  {
    label: '大检修计划结束时间',
    field: 'maintenanceExpireTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修计划结束时间!'},
          ];
     },
  },
  {
    label: '大检修实际结束时间',
    field: 'maintenanceEndTime',
    component: 'Input',
  },
  {
    label: '大检修责任人',
    field: 'maintenancePersonName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修责任人!'},
          ];
     },
  },
  {
    label: '大检修责任人手机号',
    field: 'maintenancePersonMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修责任人手机号!'},
          ];
     },
  },
  {
    label: '当前状态',
    field: 'operationStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jxzt"
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
  deviceName: {title: '装置名称',order: 2,view: 'text', type: 'string',},
  deviceCode: {title: '装置编号',order: 3,view: 'text', type: 'string',},
  maintenanceName: {title: '检修名称',order: 6,view: 'text', type: 'string',},
  hazardCode: {title: '重大危险源编码',order: 8,view: 'text', type: 'string',},
  maintenanceStartTime: {title: '大检修开始时间',order: 9,view: 'text', type: 'string',},
  maintenanceExpireTime: {title: '大检修计划结束时间',order: 10,view: 'text', type: 'string',},
  maintenanceEndTime: {title: '大检修实际结束时间',order: 11,view: 'text', type: 'string',},
  operationStatus: {title: '当前状态',order: 14,view: 'list', type: 'string',dictCode: 'jxzt',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}