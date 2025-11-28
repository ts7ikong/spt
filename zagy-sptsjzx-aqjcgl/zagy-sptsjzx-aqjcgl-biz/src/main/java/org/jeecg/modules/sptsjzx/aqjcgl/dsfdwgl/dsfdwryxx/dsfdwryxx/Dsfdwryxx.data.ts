import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '第三方单位统一社会信用代码',
    align:"center",
    dataIndex: 'sociaCode'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'reportCompanyCode'
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
    dataIndex: 'highRiskPosition'
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
    dataIndex: 'starttime'
   },
   {
    title: '证书有效期止',
    align:"center",
    dataIndex: 'endtime'
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
    label: "uuid",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "第三方单位统一社会信用代码",
      field: 'sociaCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "上报企业编码",
      field: 'reportCompanyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "姓名",
      field: 'personName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "人员编码",
      field: 'ersonCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "身份证号",
      field: 'idCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "年龄",
      field: 'age',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"lhzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "联系电话",
      field: 'mobileNumber',
      component: 'Input',
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
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "证书名称",
      field: 'certificateName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "证书号码",
      field: 'certificateNumber',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "证书级别",
      field: 'certificateLevel',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "证书有效期起",
      field: "starttime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "证书有效期止",
      field: "endtime",
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
    label: 'uuid',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入uuid!'},
          ];
     },
  },
  {
    label: '第三方单位统一社会信用代码',
    field: 'sociaCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位统一社会信用代码!'},
          ];
     },
  },
  {
    label: '上报企业编码',
    field: 'reportCompanyCode',
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
        dictCode:"lhzt",
        type: "radio"
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
    component: 'InputTextArea',
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
    component: 'Input',
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
    field: 'starttime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书有效期起!'},
          ];
     },
  },
  {
    label: '证书有效期止',
    field: 'endtime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书有效期止!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  sociaCode: {title: '第三方单位统一社会信用代码',order: 1,view: 'text', type: 'string',},
  reportCompanyCode: {title: '上报企业编码',order: 2,view: 'text', type: 'string',},
  personName: {title: '姓名',order: 3,view: 'text', type: 'string',},
  ersonCode: {title: '人员编码',order: 4,view: 'text', type: 'string',},
  idCode: {title: '身份证号',order: 5,view: 'text', type: 'string',},
  age: {title: '年龄',order: 6,view: 'number', type: 'number',},
  status: {title: '状态',order: 7,view: 'radio', type: 'string',dictCode: 'lhzt',},
  description: {title: '黑名单原因',order: 8,view: 'textarea', type: 'string',},
  mobileNumber: {title: '联系电话',order: 9,view: 'text', type: 'string',},
  positionName: {title: '岗位名称',order: 10,view: 'text', type: 'string',},
  highRiskPosition: {title: '是否高风险岗位',order: 11,view: 'text', type: 'string',},
  personPicture: {title: '员工照片',order: 12,view: 'text', type: 'string',},
  certificateName: {title: '证书名称',order: 13,view: 'text', type: 'string',},
  certificateNumber: {title: '证书号码',order: 14,view: 'text', type: 'string',},
  certificateLevel: {title: '证书级别',order: 15,view: 'text', type: 'string',},
  starttime: {title: '证书有效期起',order: 16,view: 'datetime', type: 'string',},
  endtime: {title: '证书有效期止',order: 17,view: 'datetime', type: 'string',},
  deleted: {title: '删除标志',order: 18,view: 'list', type: 'string',dictCode: 'scbz',},
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