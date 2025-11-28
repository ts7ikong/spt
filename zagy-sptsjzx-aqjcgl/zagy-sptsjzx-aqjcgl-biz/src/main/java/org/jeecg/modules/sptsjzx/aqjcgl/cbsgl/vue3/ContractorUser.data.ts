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
    title: '第三方uuid',
    align:"center",
    dataIndex: 'contractorUuid_dictText'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '姓名',
    align:"center",
    dataIndex: 'personName'
   },
   {
    title: '人员编码',
    align:"center",
    dataIndex: 'ersonCode'
   },
   {
    title: '身份证号',
    align:"center",
    dataIndex: 'idCode'
   },
   {
    title: '年龄',
    align:"center",
    dataIndex: 'age'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '黑名单原因',
    align:"center",
    dataIndex: 'description'
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
    title: '员工照片',
    align:"center",
    dataIndex: 'personPicture'
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
    dataIndex: 'starttime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '证书有效期止',
    align:"center",
    dataIndex: 'endtime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "UUID",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
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
      label: "第三方uuid",
      field: 'contractorUuid',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"contractor_basic_information,contractor_name,uuid"
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
          dictCode:"zt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "岗位名称",
      field: 'positionName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "是否高风险岗位",
      field: 'highRiskPosition',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"gxfgw"
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
    label: '第三方uuid',
    field: 'contractorUuid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"contractor_basic_information,contractor_name,uuid"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方uuid!'},
          ];
     },
  },
  {
    label: '上报企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入上报企业编码!'},
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
    field: 'ersonCode',
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
    component: 'Input',
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
        dictCode:"zt"
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
        dictCode:"gxfgw"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否高风险岗位!'},
          ];
     },
  },
  {
    label: '员工照片',
    field: 'personPicture',
    component: 'Input',
  },
  {
    label: '证书名称',
    field: 'certificateName',
    component: 'Input',
  },
  {
    label: '证书号码',
    field: 'certificateNumber',
    component: 'Input',
  },
  {
    label: '证书级别',
    field: 'certificateLevel',
    component: 'Input',
  },
  {
    label: '证书有效期起',
    field: 'starttime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '证书有效期止',
    field: 'endtime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
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
  contractorUuid: {title: '第三方uuid',order: 2,view: 'list', type: 'string',dictTable: "contractor_basic_information", dictCode: 'uuid', dictText: 'contractor_name',},
  companyCode: {title: '上报企业编码',order: 3,view: 'text', type: 'string',},
  personName: {title: '姓名',order: 4,view: 'text', type: 'string',},
  ersonCode: {title: '人员编码',order: 5,view: 'text', type: 'string',},
  idCode: {title: '身份证号',order: 6,view: 'text', type: 'string',},
  age: {title: '年龄',order: 7,view: 'text', type: 'string',},
  status: {title: '状态',order: 8,view: 'list', type: 'string',dictCode: 'zt',},
  description: {title: '黑名单原因',order: 9,view: 'text', type: 'string',},
  mobileNumber: {title: '联系电话',order: 10,view: 'text', type: 'string',},
  positionName: {title: '岗位名称',order: 11,view: 'text', type: 'string',},
  highRiskPosition: {title: '是否高风险岗位',order: 12,view: 'list', type: 'string',dictCode: 'gxfgw',},
  personPicture: {title: '员工照片',order: 13,view: 'text', type: 'string',},
  certificateName: {title: '证书名称',order: 14,view: 'text', type: 'string',},
  certificateNumber: {title: '证书号码',order: 15,view: 'text', type: 'string',},
  certificateLevel: {title: '证书级别',order: 16,view: 'text', type: 'string',},
  starttime: {title: '证书有效期起',order: 17,view: 'date', type: 'string',},
  endtime: {title: '证书有效期止',order: 18,view: 'date', type: 'string',},
  deleted: {title: '删除标志',order: 19,view: 'list', type: 'string',dictCode: 'scbz',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}