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
    dataIndex: 'parkCode'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '设备编号',
    align:"center",
    dataIndex: 'equipmentCode'
   },
   {
    title: '设备名称',
    align:"center",
    dataIndex: 'equipmentName'
   },
   {
    title: '设备位置',
    align:"center",
    dataIndex: 'equipmentLocation'
   },
   {
    title: '经度',
    align:"center",
    dataIndex: 'longitude'
   },
   {
    title: '纬度',
    align:"center",
    dataIndex: 'latitude'
   },
   {
    title: '设备类型',
    align:"center",
    dataIndex: 'equipmentType'
   },
   {
    title: '设备状态',
    align:"center",
    dataIndex: 'equipmentStatus'
   },
   {
    title: '生产厂家',
    align:"center",
    dataIndex: 'equipmentFactory'
   },
   {
    title: '型号',
    align:"center",
    dataIndex: 'equipmentModel'
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
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备编号",
      field: 'equipmentCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备名称",
      field: 'equipmentName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备位置",
      field: 'equipmentLocation',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备类型",
      field: 'equipmentType',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "设备状态",
      field: 'equipmentStatus',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "生产厂家",
      field: 'equipmentFactory',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "型号",
      field: 'equipmentModel',
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
    label: '企业编码',
    field: 'companyCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业编码!'},
          ];
     },
  },
  {
    label: '设备编号',
    field: 'equipmentCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编号!'},
          ];
     },
  },
  {
    label: '设备名称',
    field: 'equipmentName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
  },
  {
    label: '设备位置',
    field: 'equipmentLocation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备位置!'},
          ];
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经度!'},
          ];
     },
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纬度!'},
          ];
     },
  },
  {
    label: '设备类型',
    field: 'equipmentType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备类型!'},
          ];
     },
  },
  {
    label: '设备状态',
    field: 'equipmentStatus',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备状态!'},
          ];
     },
  },
  {
    label: '生产厂家',
    field: 'equipmentFactory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入生产厂家!'},
          ];
     },
  },
  {
    label: '型号',
    field: 'equipmentModel',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入型号!'},
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
  parkCode: {title: '园区编码',order: 1,view: 'text', type: 'string',},
  companyCode: {title: '企业编码',order: 2,view: 'text', type: 'string',},
  equipmentCode: {title: '设备编号',order: 3,view: 'text', type: 'string',},
  equipmentName: {title: '设备名称',order: 4,view: 'text', type: 'string',},
  equipmentLocation: {title: '设备位置',order: 5,view: 'text', type: 'string',},
  longitude: {title: '经度',order: 6,view: 'text', type: 'string',},
  latitude: {title: '纬度',order: 7,view: 'text', type: 'string',},
  equipmentType: {title: '设备类型',order: 8,view: 'text', type: 'string',},
  equipmentStatus: {title: '设备状态',order: 9,view: 'text', type: 'string',},
  equipmentFactory: {title: '生产厂家',order: 10,view: 'text', type: 'string',},
  equipmentModel: {title: '型号',order: 11,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 12,view: 'list', type: 'string',dictCode: 'scbz',},
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