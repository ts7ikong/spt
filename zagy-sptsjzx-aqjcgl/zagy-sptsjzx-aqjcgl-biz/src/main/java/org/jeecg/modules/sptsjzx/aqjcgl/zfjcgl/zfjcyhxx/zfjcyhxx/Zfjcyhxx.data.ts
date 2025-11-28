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
    title: '关联执法检查计划编号',
    align:"center",
    dataIndex: 'enforcementId'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '隐患级别',
    align:"center",
    dataIndex: 'troubleLevel_dictText'
   },
   {
    title: '隐患状态',
    align:"center",
    dataIndex: 'troubleStatus_dictText'
   },
   {
    title: '隐患类型',
    align:"center",
    dataIndex: 'troubleType_dictText'
   },
   {
    title: '隐患描述',
    align:"center",
    dataIndex: 'troubleContent'
   },
   {
    title: '检查日期',
    align:"center",
    dataIndex: 'checkDate'
   },
   {
    title: '整改时间',
    align:"center",
    dataIndex: 'dealTime'
   },
   {
    title: '整改措施',
    align:"center",
    dataIndex: 'dealContent'
   },
   {
    title: '责令整改期限',
    align:"center",
    dataIndex: 'dutyLimitDate'
   },
   {
    title: '罚款金额',
    align:"center",
    dataIndex: 'pay'
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
      label: "所属园区",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "UUID",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "关联执法检查计划编号",
      field: 'enforcementId',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "隐患级别",
      field: 'troubleLevel',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhjb"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患状态",
      field: 'troubleStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患类型",
      field: 'troubleType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患描述",
      field: 'troubleContent',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "检查日期",
      field: "checkDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "整改时间",
      field: "dealTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "责令整改期限",
      field: "dutyLimitDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
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
    label: '关联执法检查计划编号',
    field: 'enforcementId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入关联执法检查计划编号!'},
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
    label: '隐患级别',
    field: 'troubleLevel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhjb"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入隐患级别!'},
          ];
     },
  },
  {
    label: '隐患状态',
    field: 'troubleStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入隐患状态!'},
          ];
     },
  },
  {
    label: '隐患类型',
    field: 'troubleType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhlx"
     },
  },
  {
    label: '隐患描述',
    field: 'troubleContent',
    component: 'InputTextArea',
  },
  {
    label: '检查日期',
    field: 'checkDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入检查日期!'},
          ];
     },
  },
  {
    label: '整改时间',
    field: 'dealTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '整改措施',
    field: 'dealContent',
    component: 'InputTextArea',
  },
  {
    label: '责令整改期限',
    field: 'dutyLimitDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入责令整改期限!'},
          ];
     },
  },
  {
    label: '罚款金额',
    field: 'pay',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入罚款金额!'},
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
  uuid: {title: 'UUID',order: 1,view: 'text', type: 'string',},
  enforcementId: {title: '关联执法检查计划编号',order: 2,view: 'text', type: 'string',},
  companyCode: {title: '企业编码',order: 3,view: 'text', type: 'string',},
  troubleLevel: {title: '隐患级别',order: 4,view: 'list', type: 'string',dictCode: 'yhjb',},
  troubleStatus: {title: '隐患状态',order: 5,view: 'list', type: 'string',dictCode: 'yhzt',},
  troubleType: {title: '隐患类型',order: 6,view: 'list', type: 'string',dictCode: 'yhlx',},
  troubleContent: {title: '隐患描述',order: 7,view: 'textarea', type: 'string',},
  checkDate: {title: '检查日期',order: 8,view: 'datetime', type: 'string',},
  dealTime: {title: '整改时间',order: 9,view: 'datetime', type: 'string',},
  dealContent: {title: '整改措施',order: 10,view: 'textarea', type: 'string',},
  dutyLimitDate: {title: '责令整改期限',order: 11,view: 'datetime', type: 'string',},
  pay: {title: '罚款金额',order: 12,view: 'number', type: 'number',},
  deleted: {title: '删除标志',order: 13,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 14,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 15,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 16,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 17,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}