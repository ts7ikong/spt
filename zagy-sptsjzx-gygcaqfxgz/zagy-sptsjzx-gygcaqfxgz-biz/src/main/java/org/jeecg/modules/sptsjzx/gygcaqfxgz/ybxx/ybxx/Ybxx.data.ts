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
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '设备编号',
    align:"center",
    dataIndex: 'equipmentCode_dictText'
   },
   {
    title: '仪表编号',
    align:"center",
    dataIndex: 'instrumentCode'
   },
   {
    title: '仪表名称',
    align:"center",
    dataIndex: 'instrumentName'
   },
   {
    title: '仪表位置',
    align:"center",
    dataIndex: 'instrumentLocation'
   },
   {
    title: '安装日期',
    align:"center",
    dataIndex: 'instrumentDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '证书编号',
    align:"center",
    dataIndex: 'instrumentZnumber'
   },
   {
    title: '证书有效期',
    align:"center",
    dataIndex: 'instrumentValidity'
   },
   {
    title: '品牌',
    align:"center",
    dataIndex: 'instrumentBrand'
   },
   {
    title: '型号',
    align:"center",
    dataIndex: 'instrumentModel'
   },
   {
    title: '仪表状态',
    align:"center",
    dataIndex: 'instrumentState'
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
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
	{
      label: "设备编号",
      field: 'equipmentCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sbxx,equipment_name,equipment_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "仪表编号",
      field: 'instrumentCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "仪表名称",
      field: 'instrumentName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "仪表位置",
      field: 'instrumentLocation',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "安装日期",
      field: "instrumentDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "证书编号",
      field: 'instrumentZnumber',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "证书有效期",
      field: 'instrumentValidity',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "品牌",
      field: 'instrumentBrand',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "型号",
      field: 'instrumentModel',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "仪表状态",
      field: 'instrumentState',
      component: 'Input',
      //colProps: {span: 6},
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
    label: '园区编码',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '设备编号',
    field: 'equipmentCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sbxx,equipment_name,equipment_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编号!'},
          ];
     },
  },
  {
    label: '仪表编号',
    field: 'instrumentCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入仪表编号!'},
          ];
     },
  },
  {
    label: '仪表名称',
    field: 'instrumentName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入仪表名称!'},
          ];
     },
  },
  {
    label: '仪表位置',
    field: 'instrumentLocation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入仪表位置!'},
          ];
     },
  },
  {
    label: '安装日期',
    field: 'instrumentDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入安装日期!'},
          ];
     },
  },
  {
    label: '证书编号',
    field: 'instrumentZnumber',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书编号!'},
          ];
     },
  },
  {
    label: '证书有效期',
    field: 'instrumentValidity',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书有效期!'},
          ];
     },
  },
  {
    label: '品牌',
    field: 'instrumentBrand',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入品牌!'},
          ];
     },
  },
  {
    label: '型号',
    field: 'instrumentModel',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入型号!'},
          ];
     },
  },
  {
    label: '仪表状态',
    field: 'instrumentState',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入仪表状态!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  companyCode: {title: '企业编码',order: 2,view: 'list', type: 'string',dictCode: '',},
  equipmentCode: {title: '设备编号',order: 3,view: 'list', type: 'string',dictTable: "sbxx", dictCode: 'equipment_code', dictText: 'equipment_name',},
  instrumentCode: {title: '仪表编号',order: 4,view: 'text', type: 'string',},
  instrumentName: {title: '仪表名称',order: 5,view: 'text', type: 'string',},
  instrumentLocation: {title: '仪表位置',order: 6,view: 'text', type: 'string',},
  instrumentDate: {title: '安装日期',order: 7,view: 'date', type: 'string',},
  instrumentZnumber: {title: '证书编号',order: 8,view: 'text', type: 'string',},
  instrumentValidity: {title: '证书有效期',order: 9,view: 'text', type: 'string',},
  instrumentBrand: {title: '品牌',order: 10,view: 'text', type: 'string',},
  instrumentModel: {title: '型号',order: 11,view: 'text', type: 'string',},
  instrumentState: {title: '仪表状态',order: 12,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 13,view: 'list', type: 'string',dictCode: '',},
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