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
    title: '园区编码',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '行政区划',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '物资编码',
    align:"center",
    dataIndex: 'materialId'
   },
   {
    title: '物资名称',
    align:"center",
    dataIndex: 'materialName'
   },
   {
    title: '物资分类',
    align:"center",
    dataIndex: 'materialType'
   },
   {
    title: '用途',
    align:"center",
    dataIndex: 'materialUse'
   },
   {
    title: '存储和运输要求',
    align:"center",
    dataIndex: 'storageTransportRequirement'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'affiliation'
   },
   {
    title: '存放位置',
    align:"center",
    dataIndex: 'address'
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
    title: '数量',
    align:"center",
    dataIndex: 'number'
   },
   {
    title: '负责人',
    align:"center",
    dataIndex: 'director'
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
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "行政区划",
    field: "areaCode",
    component: 'JInput',
  },
  {
    label: "物资编码",
    field: "materialId",
    component: 'JInput',
  },
  {
    label: "物资名称",
    field: "materialName",
    component: 'JInput',
  },
	{
      label: "物资分类",
      field: 'materialType',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "用途",
    field: "materialUse",
    component: 'JInput',
  },
	{
      label: "存储和运输要求",
      field: 'storageTransportRequirement',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "所属单位",
    field: "affiliation",
    component: 'JInput',
  },
  {
    label: "存放位置",
    field: "address",
    component: 'JInput',
  },
  {
    label: "负责人",
    field: "director",
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
    label: '物资编码',
    field: 'materialId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入物资编码!'},
          ];
     },
  },
  {
    label: '物资名称',
    field: 'materialName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入物资名称!'},
          ];
     },
  },
  {
    label: '物资分类',
    field: 'materialType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入物资分类!'},
          ];
     },
  },
  {
    label: '用途',
    field: 'materialUse',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入用途!'},
          ];
     },
  },
  {
    label: '存储和运输要求',
    field: 'storageTransportRequirement',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入存储和运输要求!'},
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
    label: '存放位置',
    field: 'address',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入存放位置!'},
          ];
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入经度!'},
          ];
     },
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纬度!'},
          ];
     },
  },
  {
    label: '数量',
    field: 'number',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入数量!'},
          ];
     },
  },
  {
    label: '负责人',
    field: 'director',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人!'},
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
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  areaCode: {title: '行政区划',order: 2,view: 'text', type: 'string',},
  materialId: {title: '物资编码',order: 3,view: 'text', type: 'string',},
  materialName: {title: '物资名称',order: 4,view: 'text', type: 'string',},
  materialType: {title: '物资分类',order: 5,view: 'text', type: 'string',},
  materialUse: {title: '用途',order: 6,view: 'text', type: 'string',},
  storageTransportRequirement: {title: '存储和运输要求',order: 7,view: 'text', type: 'string',},
  affiliation: {title: '所属单位',order: 8,view: 'text', type: 'string',},
  address: {title: '存放位置',order: 9,view: 'text', type: 'string',},
  longitude: {title: '经度',order: 10,view: 'number', type: 'number',},
  latitude: {title: '纬度',order: 11,view: 'number', type: 'number',},
  number: {title: '数量',order: 12,view: 'number', type: 'number',},
  director: {title: '负责人',order: 13,view: 'text', type: 'string',},
  telephone: {title: '联系方式',order: 14,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 15,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 16,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 17,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 18,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 19,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}