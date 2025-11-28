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
    title: '装置负责人姓名',
    align:"center",
    dataIndex: 'plantPrincipalPersonName'
   },
   {
    title: '装置负责人手机号',
    align:"center",
    dataIndex: 'plantPrincipalPersonMobile'
   },
   {
    title: '检修名称',
    align:"center",
    dataIndex: 'maintenanceName'
   },
   {
    title: '检修内容',
    align:"center",
    dataIndex: 'maintenanceContent'
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
    title: '大检修实际结束时间',
    align:"center",
    dataIndex: 'maintenanceEndTime'
   },
   {
    title: '大检修责任人',
    align:"center",
    dataIndex: 'maintenancePersonName'
   },
   {
    title: '大检修责任人手机号',
    align:"center",
    dataIndex: 'maintenancePersonMobile'
   },
   {
    title: '大检修计划结束时间',
    align:"center",
    dataIndex: 'maintenanceExpireTime'
   },
   {
    title: '当前状态',
    align:"center",
    dataIndex: 'operationStatus_dictText'
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
      label: "园区编号",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "装置编号",
    field: "deviceCode",
    component: 'JInput',
  },
  {
    label: "装置负责人姓名",
    field: "plantPrincipalPersonName",
    component: 'JInput',
  },
  {
    label: "检修名称",
    field: "maintenanceName",
    component: 'JInput',
  },
     {
      label: "大检修开始时间",
      field: "maintenanceStartTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "大检修实际结束时间",
      field: "maintenanceEndTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
  {
    label: "大检修责任人",
    field: "maintenancePersonName",
    component: 'JInput',
  },
     {
      label: "大检修计划结束时间",
      field: "maintenanceExpireTime",
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
                 { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号码!'},
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
    component: 'InputTextArea',
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
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修开始时间!'},
          ];
     },
  },
  {
    label: '大检修实际结束时间',
    field: 'maintenanceEndTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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
    label: '大检修计划结束时间',
    field: 'maintenanceExpireTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入大检修计划结束时间!'},
          ];
     },
  },
  {
    label: '当前状态',
    field: 'operationStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zzdjxbadqzz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入当前状态!'},
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
  plantPrincipalPersonName: {title: '装置负责人姓名',order: 5,view: 'text', type: 'string',},
  plantPrincipalPersonMobile: {title: '装置负责人手机号',order: 6,view: 'text', type: 'string',},
  maintenanceName: {title: '检修名称',order: 7,view: 'text', type: 'string',},
  maintenanceContent: {title: '检修内容',order: 8,view: 'textarea', type: 'string',},
  hazardCode: {title: '重大危险源编码',order: 9,view: 'text', type: 'string',},
  maintenanceStartTime: {title: '大检修开始时间',order: 10,view: 'datetime', type: 'string',},
  maintenanceEndTime: {title: '大检修实际结束时间',order: 11,view: 'datetime', type: 'string',},
  maintenancePersonName: {title: '大检修责任人',order: 12,view: 'text', type: 'string',},
  maintenancePersonMobile: {title: '大检修责任人手机号',order: 13,view: 'text', type: 'string',},
  maintenanceExpireTime: {title: '大检修计划结束时间',order: 14,view: 'datetime', type: 'string',},
  operationStatus: {title: '当前状态',order: 15,view: 'list', type: 'string',dictCode: 'zzdjxbadqzz',},
  deleted: {title: '删除标志',order: 16,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 17,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 18,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 19,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 20,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}