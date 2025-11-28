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
    title: '人员编码',
    align:"center",
    dataIndex: 'staffCode'
   },
   {
    title: '人员姓名',
    align:"center",
    dataIndex: 'staffName'
   },
   {
    title: '人员类型',
    align:"center",
    dataIndex: 'staffType_dictText'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'affiliation'
   },
   {
    title: '职位名称',
    align:"center",
    dataIndex: 'staffPosition'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'staffGender_dictText'
   },
   {
    title: '专业',
    align:"center",
    dataIndex: 'staffMajor'
   },
   {
    title: '证件号码',
    align:"center",
    dataIndex: 'idCard'
   },
   {
    title: '其他证件',
    align:"center",
    dataIndex: 'papers'
   },
   {
    title: '联系方式',
    align:"center",
    dataIndex: 'telephone'
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
    label: "人员编码",
    field: "staffCode",
    component: 'JInput',
  },
  {
    label: "人员姓名",
    field: "staffName",
    component: 'JInput',
  },
	{
      label: "人员类型",
      field: 'staffType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqrylx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "所属单位",
    field: "affiliation",
    component: 'JInput',
  },
  {
    label: "职位名称",
    field: "staffPosition",
    component: 'JInput',
  },
	{
      label: "性别",
      field: 'staffGender',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sex"
      },
      //colProps: {span: 6},
 	},
  {
    label: "专业",
    field: "staffMajor",
    component: 'JInput',
  },
  {
    label: "证件号码",
    field: "idCard",
    component: 'JInput',
  },
  {
    label: "联系方式",
    field: "telephone",
    component: 'JInput',
  },
	{
      label: "删除标志",
      field: 'deleted',
      component: 'JSelectMultiple',
      componentProps:{
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
    label: '人员编码',
    field: 'staffCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员编码!'},
          ];
     },
  },
  {
    label: '人员姓名',
    field: 'staffName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员姓名!'},
          ];
     },
  },
  {
    label: '人员类型',
    field: 'staffType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqrylx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入人员类型!'},
          ];
     },
  },
  {
    label: '所属单位',
    field: 'affiliation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属单位!'},
          ];
     },
  },
  {
    label: '职位名称',
    field: 'staffPosition',
    component: 'Input',
  },
  {
    label: '性别',
    field: 'staffGender',
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
    label: '专业',
    field: 'staffMajor',
    component: 'Input',
  },
  {
    label: '证件号码',
    field: 'idCard',
    component: 'Input',
  },
  {
    label: '其他证件',
    field: 'papers',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入其他证件!'},
          ];
     },
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
    label: '删除标志',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
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
  staffCode: {title: '人员编码',order: 2,view: 'text', type: 'string',},
  staffName: {title: '人员姓名',order: 3,view: 'text', type: 'string',},
  staffType: {title: '人员类型',order: 4,view: 'list', type: 'string',dictCode: 'yqrylx',},
  affiliation: {title: '所属单位',order: 5,view: 'text', type: 'string',},
  staffPosition: {title: '职位名称',order: 6,view: 'text', type: 'string',},
  staffGender: {title: '性别',order: 7,view: 'list', type: 'string',dictCode: 'sex',},
  staffMajor: {title: '专业',order: 8,view: 'text', type: 'string',},
  idCard: {title: '证件号码',order: 9,view: 'text', type: 'string',},
  papers: {title: '其他证件',order: 10,view: 'text', type: 'string',},
  telephone: {title: '联系方式',order: 11,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 12,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 13,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 14,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 15,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 16,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}