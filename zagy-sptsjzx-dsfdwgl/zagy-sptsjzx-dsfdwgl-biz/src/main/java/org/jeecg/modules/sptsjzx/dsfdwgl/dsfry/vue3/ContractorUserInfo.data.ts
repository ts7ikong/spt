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
    title: '第三方单位名称',
    align:"center",
    dataIndex: 'sociaCode_dictText'
   },
   {
    title: '上报企业',
    align:"center",
    dataIndex: 'reportCompanyCode_dictText'
   },
   {
    title: '姓名',
    align:"center",
    dataIndex: 'personName'
   },
   {
    title: '人员编码',
    align:"center",
    dataIndex: 'personCode'
   },
   {
    title: '身份证号',
    align:"center",
    dataIndex: 'idCode'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'mobileNumber'
   },
   {
    title: '岗位名称',
    align:"center",
    dataIndex: 'positionName'
   },
   {
    title: '是否高风险岗位',
    align:"center",
    dataIndex: 'highRiskPosition_dictText'
   },
   {
    title: '证书名称',
    align:"center",
    dataIndex: 'certificateName'
   },
   {
    title: '证书号码',
    align:"center",
    dataIndex: 'certificateNumber'
   },
   {
    title: '证书级别',
    align:"center",
    dataIndex: 'certificateLevel'
   },
   {
    title: '证书有效期起',
    align:"center",
    dataIndex: 'startTime'
   },
   {
    title: '证书有效期止',
    align:"center",
    dataIndex: 'endTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "第三方单位名称",
      field: 'sociaCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"contractor_basic_info,company_name,social_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "上报企业",
      field: 'reportCompanyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "姓名",
    field: "personName",
    component: 'JInput',
  },
	{
      label: "状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dsfdwzt"
      },
      //colProps: {span: 6},
 	},
  {
    label: "联系电话",
    field: "mobileNumber",
    component: 'JInput',
  },
	{
      label: "是否高风险岗位",
      field: 'highRiskPosition',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfbz"
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
    label: '第三方单位名称',
    field: 'sociaCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"contractor_basic_info,company_name,social_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位名称!'},
          ];
     },
  },
  {
    label: '上报企业',
    field: 'reportCompanyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入上报企业!'},
          ];
     },
  },
  {
    label: '姓名',
    field: 'personName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入姓名!'},
          ];
     },
  },
  {
    label: '人员编码',
    field: 'personCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员编码!'},
          ];
     },
  },
  {
    label: '身份证号',
    field: 'idCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入身份证号!'},
          ];
     },
  },
  {
    label: '年龄',
    field: 'age',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入年龄!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dsfdwzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '黑名单原因',
    field: 'description',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入黑名单原因!'},
          ];
     },
  },
  {
    label: '联系电话',
    field: 'mobileNumber',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入联系电话!'},
          ];
     },
  },
  {
    label: '岗位名称',
    field: 'positionName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入岗位名称!'},
          ];
     },
  },
  {
    label: '是否高风险岗位',
    field: 'highRiskPosition',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否高风险岗位!'},
          ];
     },
  },
  {
    label: '员工照片URL',
    field: 'personPicture',
    component: 'Input',
  },
  {
    label: '证书名称',
    field: 'certificateName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书名称!'},
          ];
     },
  },
  {
    label: '证书号码',
    field: 'certificateNumber',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书号码!'},
          ];
     },
  },
  {
    label: '证书级别',
    field: 'certificateLevel',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书级别!'},
          ];
     },
  },
  {
    label: '证书有效期起',
    field: 'startTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书有效期起!'},
          ];
     },
  },
  {
    label: '证书有效期止',
    field: 'endTime',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书有效期止!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建人!'},
          ];
     },
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建时间!'},
          ];
     },
  },
  {
    label: '最后修改人',
    field: 'updateBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改人!'},
          ];
     },
  },
  {
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
          ];
     },
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
  sociaCode: {title: '第三方单位名称',order: 1,view: 'sel_search', type: 'string',dictTable: "contractor_basic_info", dictCode: 'social_code', dictText: 'company_name',},
  reportCompanyCode: {title: '上报企业',order: 2,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  personName: {title: '姓名',order: 3,view: 'text', type: 'string',},
  personCode: {title: '人员编码',order: 4,view: 'text', type: 'string',},
  idCode: {title: '身份证号',order: 5,view: 'text', type: 'string',},
  status: {title: '状态',order: 7,view: 'list', type: 'string',dictCode: 'dsfdwzt',},
  mobileNumber: {title: '联系电话',order: 9,view: 'text', type: 'string',},
  positionName: {title: '岗位名称',order: 10,view: 'text', type: 'string',},
  highRiskPosition: {title: '是否高风险岗位',order: 11,view: 'list', type: 'string',dictCode: 'sfbz',},
  certificateName: {title: '证书名称',order: 13,view: 'text', type: 'string',},
  certificateNumber: {title: '证书号码',order: 14,view: 'text', type: 'string',},
  certificateLevel: {title: '证书级别',order: 15,view: 'text', type: 'string',},
  startTime: {title: '证书有效期起',order: 16,view: 'text', type: 'string',},
  endTime: {title: '证书有效期止',order: 17,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}