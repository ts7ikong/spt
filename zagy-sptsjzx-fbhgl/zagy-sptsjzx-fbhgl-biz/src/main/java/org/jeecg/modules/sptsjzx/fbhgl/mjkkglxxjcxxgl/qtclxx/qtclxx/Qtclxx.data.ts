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
    title: '车牌号码',
    align:"center",
    dataIndex: 'licensePlate'
   },
   {
    title: '车牌颜色',
    align:"center",
    dataIndex: 'licensePlateColor'
   },
   {
    title: '驾驶员姓名',
    align:"center",
    dataIndex: 'driverName'
   },
   {
    title: '证件号码',
    align:"center",
    dataIndex: 'driverIdCard'
   },
   {
    title: '押运员姓名',
    align:"center",
    dataIndex: 'supercargoName'
   },
   {
    title: '驾驶证',
    align:"center",
    dataIndex: 'vehicleLicense'
   },
   {
    title: '有效期起',
    align:"center",
    dataIndex: 'lenStartDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '有效期止',
    align:"center",
    dataIndex: 'lenEndDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '是否有效',
    align:"center",
    dataIndex: 'whetherLen_dictText'
   },
   {
    title: '所属企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '车辆类型',
    align:"center",
    dataIndex: 'vehicleType_dictText'
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
    label: "车牌号码",
    field: "licensePlate",
    component: 'JInput',
  },
  {
    label: "车牌颜色",
    field: "licensePlateColor",
    component: 'JInput',
  },
  {
    label: "驾驶员姓名",
    field: "driverName",
    component: 'JInput',
  },
  {
    label: "证件号码",
    field: "driverIdCard",
    component: 'JInput',
  },
  {
    label: "押运员姓名",
    field: "supercargoName",
    component: 'JInput',
  },
  {
    label: "驾驶证",
    field: "vehicleLicense",
    component: 'JInput',
  },
     {
      label: "有效期起",
      field: "lenStartDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "有效期止",
      field: "lenEndDate",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
	{
      label: "是否有效",
      field: 'whetherLen',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfbz"
      },
      //colProps: {span: 6},
 	},
  {
    label: "所属企业编码",
    field: "companyCode",
    component: 'JInput',
  },
	{
      label: "车辆类型",
      field: 'vehicleType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"cllx"
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
    label: '车牌颜色',
    field: 'licensePlateColor',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入车牌颜色!'},
          ];
     },
  },
  {
    label: '驾驶员姓名',
    field: 'driverName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入驾驶员姓名!'},
          ];
     },
  },
  {
    label: '证件号码',
    field: 'driverIdCard',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证件号码!'},
          ];
     },
  },
  {
    label: '押运员姓名',
    field: 'supercargoName',
    component: 'Input',
  },
  {
    label: '驾驶证',
    field: 'vehicleLicense',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入驾驶证!'},
          ];
     },
  },
  {
    label: '有效期起',
    field: 'lenStartDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期起!'},
          ];
     },
  },
  {
    label: '有效期止',
    field: 'lenEndDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期止!'},
          ];
     },
  },
  {
    label: '是否有效',
    field: 'whetherLen',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfbz"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否有效!'},
          ];
     },
  },
  {
    label: '所属企业编码',
    field: 'companyCode',
    component: 'Input',
  },
  {
    label: '车辆类型',
    field: 'vehicleType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cllx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入车辆类型!'},
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
  licensePlate: {title: '车牌号码',order: 2,view: 'text', type: 'string',},
  licensePlateColor: {title: '车牌颜色',order: 3,view: 'text', type: 'string',},
  driverName: {title: '驾驶员姓名',order: 4,view: 'text', type: 'string',},
  driverIdCard: {title: '证件号码',order: 5,view: 'text', type: 'string',},
  supercargoName: {title: '押运员姓名',order: 6,view: 'text', type: 'string',},
  vehicleLicense: {title: '驾驶证',order: 7,view: 'text', type: 'string',},
  lenStartDate: {title: '有效期起',order: 8,view: 'date', type: 'string',},
  lenEndDate: {title: '有效期止',order: 9,view: 'date', type: 'string',},
  whetherLen: {title: '是否有效',order: 10,view: 'list', type: 'string',dictCode: 'sfbz',},
  companyCode: {title: '所属企业编码',order: 11,view: 'text', type: 'string',},
  vehicleType: {title: '车辆类型',order: 12,view: 'list', type: 'string',dictCode: 'cllx',},
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