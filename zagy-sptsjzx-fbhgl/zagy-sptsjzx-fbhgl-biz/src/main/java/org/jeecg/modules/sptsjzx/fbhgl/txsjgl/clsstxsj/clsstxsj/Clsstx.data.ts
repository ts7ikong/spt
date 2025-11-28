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
    title: '车辆类型',
    align:"center",
    dataIndex: 'vehicleType_dictText'
   },
   {
    title: '设备编码',
    align:"center",
    dataIndex: 'equipmentCode'
   },
   {
    title: '车牌号码',
    align:"center",
    dataIndex: 'licensePlate'
   },
   {
    title: '通行时间',
    align:"center",
    dataIndex: 'passTime'
   },
   {
    title: '通行类型',
    align:"center",
    dataIndex: 'passType_dictText'
   },
   {
    title: '通行抓拍',
    align:"center",
    dataIndex: 'passImg',
    customRender:render.renderImage,
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
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "车辆类型",
      field: 'vehicleType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"txsjcllx"
      },
      //colProps: {span: 6},
 	},
  {
    label: "设备编码",
    field: "equipmentCode",
    component: 'JInput',
  },
  {
    label: "车牌号码",
    field: "licensePlate",
    component: 'JInput',
  },
     {
      label: "通行时间",
      field: "passTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "通行类型",
      field: 'passType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"txlx"
      },
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
    label: '车辆类型',
    field: 'vehicleType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"txsjcllx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入车辆类型!'},
          ];
     },
  },
  {
    label: '设备编码',
    field: 'equipmentCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编码!'},
          ];
     },
  },
  {
    label: '车牌号码',
    field: 'licensePlate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入车牌号码!'},
          ];
     },
  },
  {
    label: '通行时间',
    field: 'passTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入通行时间!'},
          ];
     },
  },
  {
    label: '通行类型',
    field: 'passType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"txlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入通行类型!'},
          ];
     },
  },
  {
    label: '通行抓拍',
    field: 'passImg',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入通行抓拍!'},
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
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  vehicleType: {title: '车辆类型',order: 2,view: 'list', type: 'string',dictCode: 'txsjcllx',},
  equipmentCode: {title: '设备编码',order: 3,view: 'text', type: 'string',},
  licensePlate: {title: '车牌号码',order: 4,view: 'text', type: 'string',},
  passTime: {title: '通行时间',order: 5,view: 'datetime', type: 'string',},
  passType: {title: '通行类型',order: 6,view: 'list', type: 'string',dictCode: 'txlx',},
  passImg: {title: '通行抓拍',order: 7,view: 'image', type: 'string',},
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