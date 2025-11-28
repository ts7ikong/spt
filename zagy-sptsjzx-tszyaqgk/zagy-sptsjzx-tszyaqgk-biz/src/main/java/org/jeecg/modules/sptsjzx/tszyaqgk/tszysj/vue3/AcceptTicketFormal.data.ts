import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '作业类型',
    align:"center",
    dataIndex: 'ticketType_dictText'
   },
   {
    title: '作业开始时间',
    align:"center",
    dataIndex: 'startTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '作业结束时间',
    align:"center",
    dataIndex: 'endTime'
   },
   {
    title: '作业地点',
    align:"center",
    dataIndex: 'ticketPosition'
   },
   {
    title: '作业内容',
    align:"center",
    dataIndex: 'ticketContent'
   },
   {
    title: '作业状态',
    align:"center",
    dataIndex: 'ticketStatus_dictText'
   },
   {
    title: '是否承包商作业',
    align:"center",
    dataIndex: 'isContractorWork_dictText'
   },
   {
    title: '作业是否变更过',
    align:"center",
    dataIndex: 'isChanged_dictText'
   },
   {
    title: '作业票唯一编码',
    align:"center",
    dataIndex: 'ticketNum'
   },
   {
    title: '验收时间',
    align:"center",
    dataIndex: 'acceptanceTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '活动id',
    align:"center",
    dataIndex: 'jobId'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "作业类型",
      field: 'ticketType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zylx"
      },
      //colProps: {span: 6},
 	},
     {
      label: "作业开始时间",
      field: "startTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
  {
    label: "作业内容",
    field: "ticketContent",
    component: 'JInput',
  },
	{
      label: "作业状态",
      field: 'ticketStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zyzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否承包商作业",
      field: 'isContractorWork',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
     {
      label: "验收时间",
      field: "acceptanceTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '作业类型',
    field: 'ticketType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zylx"
     },
  },
  {
    label: '作业开始时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '作业结束时间',
    field: 'endTime',
    component: 'Input',
  },
  {
    label: '作业地点',
    field: 'ticketPosition',
    component: 'Input',
  },
  {
    label: '作业内容',
    field: 'ticketContent',
    component: 'Input',
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'Input',
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'Input',
  },
  {
    label: '作业状态',
    field: 'ticketStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zyzt"
     },
  },
  {
    label: '安全监管人员姓名',
    field: 'supervisorName',
    component: 'Input',
  },
  {
    label: '施工人员姓名',
    field: 'workerName',
    component: 'Input',
  },
  {
    label: '施工人员id',
    field: 'personId',
    component: 'Input',
  },
  {
    label: '施工单位名称',
    field: 'workDepartment',
    component: 'Input',
  },
  {
    label: '施工单位统一社会信用代码',
    field: 'socialCreditCode',
    component: 'Input',
  },
  {
    label: '是否承包商作业',
    field: 'isContractorWork',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '作业负责人',
    field: 'ticketResponsName',
    component: 'Input',
  },
  {
    label: '负责人联系方式手机号',
    field: 'majorPersonMobile',
    component: 'Input',
  },
  {
    label: '作业是否变更过',
    field: 'isChanged',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '作业变更原因',
    field: 'changedCause',
    component: 'Input',
  },
  {
    label: '作业是否取消',
    field: 'isCancelled',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '作业作废原因',
    field: 'cancelledCause',
    component: 'Input',
  },
  {
    label: '作业票唯一编码',
    field: 'ticketNum',
    component: 'Input',
  },
  {
    label: '票证地址',
    field: 'ticketPic',
    component: 'Input',
  },
  {
    label: '签发时间',
    field: 'issueTime',
    component: 'Input',
  },
  {
    label: '验收时间',
    field: 'acceptanceTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '活动id',
    field: 'jobId',
    component: 'Input',
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
  companyCode: {title: '企业编码',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  ticketType: {title: '作业类型',order: 1,view: 'list', type: 'string',dictCode: 'zylx',},
  startTime: {title: '作业开始时间',order: 2,view: 'date', type: 'string',},
  endTime: {title: '作业结束时间',order: 3,view: 'text', type: 'string',},
  ticketPosition: {title: '作业地点',order: 4,view: 'text', type: 'string',},
  ticketContent: {title: '作业内容',order: 5,view: 'text', type: 'string',},
  ticketStatus: {title: '作业状态',order: 8,view: 'list', type: 'string',dictCode: 'zyzt',},
  isContractorWork: {title: '是否承包商作业',order: 14,view: 'list', type: 'string',dictCode: 'sf',},
  isChanged: {title: '作业是否变更过',order: 17,view: 'list', type: 'string',dictCode: 'sf',},
  ticketNum: {title: '作业票唯一编码',order: 21,view: 'text', type: 'string',},
  acceptanceTime: {title: '验收时间',order: 24,view: 'date', type: 'string',},
  jobId: {title: '活动id',order: 25,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}