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
    title: '第三方单位社 会统一信用代 码',
    align:"center",
    dataIndex: 'socialcode'
   },
   {
    title: '上报企业编码',
    align:"center",
    dataIndex: 'reportCompanyCode'
   },
   {
    title: '资质名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '证书编号',
    align:"center",
    dataIndex: 'code'
   },
   {
    title: '资质等级',
    align:"center",
    dataIndex: 'level'
   },
   {
    title: '有效期起',
    align:"center",
    dataIndex: 'starttime'
   },
   {
    title: '有效期止',
    align:"center",
    dataIndex: 'endtime'
   },
   {
    title: '删除标志',
    align:"center",
    dataIndex: 'deleted'
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
      label: "资质名称",
      field: 'name',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "资质等级",
      field: 'level',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "有效期起",
      field: "starttime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "有效期止",
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
      component: 'Input',
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
    label: '第三方单位社 会统一信用代 码',
    field: 'socialcode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入第三方单位社 会统一信用代 码!'},
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
    label: '资质名称',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资质名称!'},
          ];
     },
  },
  {
    label: '证书编号',
    field: 'code',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书编号!'},
          ];
     },
  },
  {
    label: '资质等级',
    field: 'level',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资质等级!'},
          ];
     },
  },
  {
    label: '有效期起',
    field: 'starttime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期起!'},
          ];
     },
  },
  {
    label: '有效期止',
    field: 'endtime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期止!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'Input',
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
  socialcode: {title: '第三方单位社 会统一信用代 码',order: 1,view: 'text', type: 'string',},
  reportCompanyCode: {title: '上报企业编码',order: 2,view: 'text', type: 'string',},
  name: {title: '资质名称',order: 3,view: 'text', type: 'string',},
  code: {title: '证书编号',order: 4,view: 'text', type: 'string',},
  level: {title: '资质等级',order: 5,view: 'text', type: 'string',},
  starttime: {title: '有效期起',order: 6,view: 'datetime', type: 'string',},
  endtime: {title: '有效期止',order: 7,view: 'datetime', type: 'string',},
  deleted: {title: '删除标志',order: 8,view: 'text', type: 'string',},
  createTimeCompany: {title: '创建日期_企业',order: 9,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 10,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 11,view: 'datetime', type: 'string',},
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