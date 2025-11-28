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
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '队伍编码',
    align:"center",
    dataIndex: 'unitId'
   },
   {
    title: '队伍名称',
    align:"center",
    dataIndex: 'unitName'
   },
   {
    title: '队伍分类',
    align:"center",
    dataIndex: 'unitType_dictText'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'affiliation'
   },
   {
    title: '总人数',
    align:"center",
    dataIndex: 'total'
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
    title: '地址',
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
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "行政区划",
    field: "areaCode",
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
    label: "队伍编码",
    field: "unitId",
    component: 'JInput',
  },
  {
    label: "队伍名称",
    field: "unitName",
    component: 'JInput',
  },
	{
      label: "队伍分类",
      field: 'unitType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"dwfl"
      },
      //colProps: {span: 6},
 	},
  {
    label: "所属单位",
    field: "affiliation",
    component: 'JInput',
  },
     {
      label: "总人数",
      field: "total",
      component: 'JRangeNumber',
      //colProps: {span: 6},
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
    label: "地址",
    field: "address",
    component: 'JInput',
  },
	{
      label: "经度",
      field: 'longitude',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "纬度",
      field: 'latitude',
      component: 'InputNumber',
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
    label: '队伍编码',
    field: 'unitId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入队伍编码!'},
          ];
     },
  },
  {
    label: '队伍名称',
    field: 'unitName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入队伍名称!'},
          ];
     },
  },
  {
    label: '队伍分类',
    field: 'unitType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"dwfl"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入队伍分类!'},
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
    label: '总人数',
    field: 'total',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总人数!'},
                 { pattern: /^-?\d+$/, message: '请输入整数!'},
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
    label: '地址',
    field: 'address',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入地址!'},
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
  parkCode: {title: '园区编码',order: 2,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  unitId: {title: '队伍编码',order: 3,view: 'text', type: 'string',},
  unitName: {title: '队伍名称',order: 4,view: 'text', type: 'string',},
  unitType: {title: '队伍分类',order: 5,view: 'list', type: 'string',dictCode: 'dwfl',},
  affiliation: {title: '所属单位',order: 6,view: 'text', type: 'string',},
  total: {title: '总人数',order: 7,view: 'number', type: 'number',},
  director: {title: '负责人',order: 8,view: 'text', type: 'string',},
  telephone: {title: '联系方式',order: 9,view: 'text', type: 'string',},
  address: {title: '地址',order: 10,view: 'text', type: 'string',},
  longitude: {title: '经度',order: 11,view: 'number', type: 'number',},
  latitude: {title: '纬度',order: 12,view: 'number', type: 'number',},
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