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
    title: '行政区划',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode'
   },
   {
    title: '专家编码',
    align:"center",
    dataIndex: 'expertId'
   },
   {
    title: '专家姓名',
    align:"center",
    dataIndex: 'expertName'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'gender_dictText'
   },
   {
    title: '出生年月',
    align:"center",
    dataIndex: 'dateOfBirth',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '学历',
    align:"center",
    dataIndex: 'degree'
   },
   {
    title: '专业',
    align:"center",
    dataIndex: 'major'
   },
   {
    title: '职称',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'affiliation'
   },
   {
    title: '联系方式',
    align:"center",
    dataIndex: 'telephone'
   },
   {
    title: '电子邮箱',
    align:"center",
    dataIndex: 'email'
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
    label: "行政区划",
    field: "areaCode",
    component: 'JInput',
  },
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "专家编码",
    field: "expertId",
    component: 'JInput',
  },
  {
    label: "专家姓名",
    field: "expertName",
    component: 'JInput',
  },
	{
      label: "性别",
      field: 'gender',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sex"
      },
      //colProps: {span: 6},
 	},
     {
      label: "出生年月",
      field: "dateOfBirth",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
  {
    label: "学历",
    field: "degree",
    component: 'JInput',
  },
  {
    label: "专业",
    field: "major",
    component: 'JInput',
  },
  {
    label: "职称",
    field: "title",
    component: 'JInput',
  },
  {
    label: "所属单位",
    field: "affiliation",
    component: 'JInput',
  },
  {
    label: "联系方式",
    field: "telephone",
    component: 'JInput',
  },
  {
    label: "电子邮箱",
    field: "email",
    component: 'JInput',
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
    label: '行政区划',
    field: 'areaCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入行政区划!'},
          ];
     },
  },
  {
    label: '园区编码',
    field: 'parkCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '专家编码',
    field: 'expertId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入专家编码!'},
          ];
     },
  },
  {
    label: '专家姓名',
    field: 'expertName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入专家姓名!'},
          ];
     },
  },
  {
    label: '性别',
    field: 'gender',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sex"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入性别!'},
          ];
     },
  },
  {
    label: '出生年月',
    field: 'dateOfBirth',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入出生年月!'},
          ];
     },
  },
  {
    label: '学历',
    field: 'degree',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入学历!'},
          ];
     },
  },
  {
    label: '专业',
    field: 'major',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入专业!'},
          ];
     },
  },
  {
    label: '职称',
    field: 'title',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入职称!'},
          ];
     },
  },
  {
    label: '所属单位',
    field: 'affiliation',
    component: 'Input',
  },
  {
    label: '联系方式',
    field: 'telephone',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入联系方式!'},
          ];
     },
  },
  {
    label: '电子邮箱',
    field: 'email',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入电子邮箱!'},
                 { pattern: /^([\w]+\.*)([\w]+)@[\w]+\.\w{3}(\.\w{2}|)$/, message: '请输入正确的电子邮件!'},
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
  uuid: {title: 'UUID',order: 0,view: 'text', type: 'string',},
  areaCode: {title: '行政区划',order: 1,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 2,view: 'text', type: 'string',},
  expertId: {title: '专家编码',order: 3,view: 'text', type: 'string',},
  expertName: {title: '专家姓名',order: 4,view: 'text', type: 'string',},
  gender: {title: '性别',order: 5,view: 'list', type: 'string',dictCode: 'sex',},
  dateOfBirth: {title: '出生年月',order: 6,view: 'date', type: 'string',},
  degree: {title: '学历',order: 7,view: 'text', type: 'string',},
  major: {title: '专业',order: 8,view: 'text', type: 'string',},
  title: {title: '职称',order: 9,view: 'text', type: 'string',},
  affiliation: {title: '所属单位',order: 10,view: 'text', type: 'string',},
  telephone: {title: '联系方式',order: 11,view: 'text', type: 'string',},
  email: {title: '电子邮箱',order: 12,view: 'text', type: 'string',},
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