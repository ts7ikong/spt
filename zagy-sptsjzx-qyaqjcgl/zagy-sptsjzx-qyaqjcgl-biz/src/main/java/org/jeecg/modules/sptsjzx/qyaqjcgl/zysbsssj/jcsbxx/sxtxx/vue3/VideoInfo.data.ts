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
    title: '视频编码',
    align:"center",
    dataIndex: 'videoCode'
   },
   {
    title: '视频名称',
    align:"center",
    dataIndex: 'videoName'
   },
   {
    title: '所属企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '危险源名称',
    align:"center",
    dataIndex: 'hazardCode_dictText'
   },
   {
    title: '摄像头类型',
    align:"center",
    dataIndex: 'videoType_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "视频名称",
    field: "videoName",
    component: 'JInput',
  },
	{
      label: "所属企业名称",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "危险源名称",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "摄像头类型",
      field: 'videoType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sxtlx"
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
    label: '视频编码',
    field: 'videoCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频编码!'},
          ];
     },
  },
  {
    label: '视频名称',
    field: 'videoName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入视频名称!'},
          ];
     },
  },
  {
    label: '所属企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属企业名称!'},
          ];
     },
  },
  {
    label: '危险源名称',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
  },
  {
    label: '摄像头类型',
    field: 'videoType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sxtlx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入摄像头类型!'},
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
    label: '创建人',
    field: 'createBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建人!'},
          ];
     },
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入创建时间!'},
          ];
     },
  },
  {
    label: '最后修改人',
    field: 'updateBy',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改人!'},
          ];
     },
  },
  {
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
          ];
     },
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
  videoCode: {title: '视频编码',order: 1,view: 'text', type: 'string',},
  videoName: {title: '视频名称',order: 2,view: 'text', type: 'string',},
  companyCode: {title: '所属企业名称',order: 3,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  hazardCode: {title: '危险源名称',order: 4,view: 'sel_search', type: 'string',dictTable: "v_accept_hazard_code", dictCode: 'hazard_code', dictText: 'hazard_name',},
  videoType: {title: '摄像头类型',order: 5,view: 'number', type: 'number',dictCode: 'sxtlx',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}