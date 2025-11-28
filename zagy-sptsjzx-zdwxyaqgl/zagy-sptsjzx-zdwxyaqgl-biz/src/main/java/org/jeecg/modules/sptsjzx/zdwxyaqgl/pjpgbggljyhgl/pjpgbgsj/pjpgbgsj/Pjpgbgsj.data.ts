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
    title: '危险源编码',
    align:"center",
    dataIndex: 'hazardCode'
   },
   {
    title: '资质证书分类',
    align:"center",
    dataIndex: 'certificateType_dictText'
   },
   {
    title: '报告附件',
    align:"center",
    dataIndex: 'fileUrl'
   },
   {
    title: '日期',
    align:"center",
    dataIndex: 'date'
   },
   {
    title: '评价/评估机构名称',
    align:"center",
    dataIndex: 'organizationName'
   },
   {
    title: '经办人',
    align:"center",
    dataIndex: 'agentName'
   },
   {
    title: '联系方式',
    align:"center",
    dataIndex: 'contactPhone'
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
      label: "危险源编码",
      field: 'hazardCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "资质证书分类",
      field: 'certificateType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zzzsfl"
      },
      //colProps: {span: 6},
 	},
     {
      label: "日期",
      field: "date",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "评价/评估机构名称",
      field: 'organizationName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "经办人",
      field: 'agentName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "联系方式",
      field: 'contactPhone',
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
    label: '危险源编码',
    field: 'hazardCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入危险源编码!'},
          ];
     },
  },
  {
    label: '资质证书分类',
    field: 'certificateType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zzzsfl"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入资质证书分类!'},
          ];
     },
  },
  {
    label: '报告附件',
    field: 'fileUrl',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报告附件!'},
          ];
     },
  },
  {
    label: '日期',
    field: 'date',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入日期!'},
          ];
     },
  },
  {
    label: '评价/评估机构名称',
    field: 'organizationName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入评价/评估机构名称!'},
          ];
     },
  },
  {
    label: '经办人',
    field: 'agentName',
    component: 'Input',
  },
  {
    label: '联系方式',
    field: 'contactPhone',
    component: 'Input',
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
  hazardCode: {title: '危险源编码',order: 1,view: 'text', type: 'string',},
  certificateType: {title: '资质证书分类',order: 2,view: 'list', type: 'string',dictCode: 'zzzsfl',},
  fileUrl: {title: '报告附件',order: 3,view: 'text', type: 'string',},
  date: {title: '日期',order: 4,view: 'datetime', type: 'string',},
  organizationName: {title: '评价/评估机构名称',order: 5,view: 'text', type: 'string',},
  agentName: {title: '经办人',order: 6,view: 'text', type: 'string',},
  contactPhone: {title: '联系方式',order: 7,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 8,view: 'list', type: 'string',dictCode: 'scbz',},
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