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
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '请求类型',
    align:"center",
    dataIndex: 'requestType_dictText'
   },
   {
    title: '请求方 IP',
    align:"center",
    dataIndex: 'clientIp'
   },
   {
    title: '账号名称',
    align:"center",
    dataIndex: 'username'
   },
   {
    title: '用户类型',
    align:"center",
    dataIndex: 'personType_dictText'
   },
   {
    title: '客户端类型',
    align:"center",
    dataIndex: 'clientType_dictText'
   },
   {
    title: '行政区划编码',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '删除标记',
    align:"center",
    dataIndex: 'status_dictText'
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
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "请求类型",
      field: 'requestType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"qqlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "请求方 IP",
      field: 'clientIp',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "账号名称",
      field: 'username',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "用户类型",
      field: 'personType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dlyhlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "客户端类型",
      field: 'clientType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"khdlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "行政区划编码",
      field: 'areaCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "删除标记",
      field: 'status',
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
  },
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
  },
  {
    label: '请求类型',
    field: 'requestType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qqlx"
     },
  },
  {
    label: '请求方 IP',
    field: 'clientIp',
    component: 'Input',
  },
  {
    label: '账号名称',
    field: 'username',
    component: 'Input',
  },
  {
    label: '用户类型',
    field: 'personType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dlyhlx"
     },
  },
  {
    label: '客户端类型',
    field: 'clientType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"khdlx"
     },
  },
  {
    label: '行政区划编码',
    field: 'areaCode',
    component: 'Input',
  },
  {
    label: '删除标记',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"scbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标记!'},
          ];
     },
  },
  {
    label: '创建日期_企业',
    field: 'createTimeCompany',
    component: 'Input',
  },
  {
    label: '创建人_企业',
    field: 'createByCompany',
    component: 'Input',
  },
  {
    label: '更新日期_企业',
    field: 'updateTimeCompany',
    component: 'Input',
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
  companyCode: {title: '企业编码',order: 1,view: 'text', type: 'string',},
  requestType: {title: '请求类型',order: 2,view: 'list', type: 'string',dictCode: 'qqlx',},
  clientIp: {title: '请求方 IP',order: 3,view: 'text', type: 'string',},
  username: {title: '账号名称',order: 4,view: 'text', type: 'string',},
  personType: {title: '用户类型',order: 5,view: 'list', type: 'string',dictCode: 'dlyhlx',},
  clientType: {title: '客户端类型',order: 6,view: 'list', type: 'string',dictCode: 'khdlx',},
  areaCode: {title: '行政区划编码',order: 7,view: 'text', type: 'string',},
  status: {title: '删除标记',order: 8,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 9,view: 'text', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 10,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 11,view: 'text', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 12,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}