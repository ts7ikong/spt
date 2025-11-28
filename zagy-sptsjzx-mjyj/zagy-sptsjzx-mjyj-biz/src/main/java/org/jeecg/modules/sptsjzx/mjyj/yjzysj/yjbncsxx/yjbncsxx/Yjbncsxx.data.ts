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
    title: '避难场所编码',
    align:"center",
    dataIndex: 'shelterId'
   },
   {
    title: '避难场所名称',
    align:"center",
    dataIndex: 'shelterName'
   },
   {
    title: '避难场所级别',
    align:"center",
    dataIndex: 'shelterLevel'
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'affiliation'
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
    title: '容纳人数',
    align:"center",
    dataIndex: 'capacity'
   },
   {
    title: '有效避难面积',
    align:"center",
    dataIndex: 'area'
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
    label: "避难场所编码",
    field: "shelterId",
    component: 'JInput',
  },
  {
    label: "避难场所名称",
    field: "shelterName",
    component: 'JInput',
  },
  {
    label: "避难场所级别",
    field: "shelterLevel",
    component: 'JInput',
  },
  {
    label: "所属单位",
    field: "affiliation",
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
      label: "容纳人数",
      field: "capacity",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "有效避难面积",
      field: "area",
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
    label: '避难场所编码',
    field: 'shelterId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入避难场所编码!'},
          ];
     },
  },
  {
    label: '避难场所名称',
    field: 'shelterName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入避难场所名称!'},
          ];
     },
  },
  {
    label: '避难场所级别',
    field: 'shelterLevel',
    component: 'Input',
  },
  {
    label: '所属单位',
    field: 'affiliation',
    component: 'Input',
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
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputNumber',
  },
  {
    label: '容纳人数',
    field: 'capacity',
    component: 'InputNumber',
  },
  {
    label: '有效避难面积',
    field: 'area',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效避难面积!'},
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
  shelterId: {title: '避难场所编码',order: 3,view: 'text', type: 'string',},
  shelterName: {title: '避难场所名称',order: 4,view: 'text', type: 'string',},
  shelterLevel: {title: '避难场所级别',order: 5,view: 'text', type: 'string',},
  affiliation: {title: '所属单位',order: 6,view: 'text', type: 'string',},
  address: {title: '地址',order: 7,view: 'text', type: 'string',},
  longitude: {title: '经度',order: 8,view: 'number', type: 'number',},
  latitude: {title: '纬度',order: 9,view: 'number', type: 'number',},
  capacity: {title: '容纳人数',order: 10,view: 'number', type: 'number',},
  area: {title: '有效避难面积',order: 11,view: 'number', type: 'number',},
  director: {title: '负责人',order: 12,view: 'text', type: 'string',},
  telephone: {title: '联系方式',order: 13,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 14,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 15,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 16,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 17,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 18,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}