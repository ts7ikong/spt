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
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '事故编号',
    align:"center",
    dataIndex: 'accidentId'
   },
   {
    title: '事故名称',
    align:"center",
    dataIndex: 'accidentName'
   },
   {
    title: '事故来源',
    align:"center",
    dataIndex: 'accidentSource'
   },
   {
    title: '事故类型',
    align:"center",
    dataIndex: 'typeOfAccident_dictText'
   },
   {
    title: '事故等级',
    align:"center",
    dataIndex: 'accidentLevel_dictText'
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
    title: '死亡人数',
    align:"center",
    dataIndex: 'deathToll'
   },
   {
    title: '重伤人数',
    align:"center",
    dataIndex: 'seriouslyInjuredNumber'
   },
   {
    title: '轻伤人数',
    align:"center",
    dataIndex: 'minorInjuriesNumber'
   },
   {
    title: '事故概况',
    align:"center",
    dataIndex: 'accidentDescription'
   },
   {
    title: '处置状态',
    align:"center",
    dataIndex: 'dispositionStatus_dictText'
   },
   {
    title: '上报状态',
    align:"center",
    dataIndex: 'registrationStatus_dictText'
   },
   {
    title: '上报时间',
    align:"center",
    dataIndex: 'reportionTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业名称",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "事故名称",
    field: "accidentName",
    component: 'JInput',
  },
	{
      label: "事故类型",
      field: 'typeOfAccident',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sglx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "事故等级",
      field: 'accidentLevel',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sgdj"
      },
      //colProps: {span: 6},
 	},
	{
      label: "处置状态",
      field: 'dispositionStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"czzt"
      },
      //colProps: {span: 6},
 	},
	{
      label: "上报状态",
      field: 'registrationStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sbzt"
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
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业名称!'},
          ];
     },
  },
  {
    label: '事故编号',
    field: 'accidentId',
    component: 'Input',
  },
  {
    label: '事故名称',
    field: 'accidentName',
    component: 'Input',
  },
  {
    label: '事故来源',
    field: 'accidentSource',
    component: 'Input',
  },
  {
    label: '事故类型',
    field: 'typeOfAccident',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sglx"
     },
  },
  {
    label: '事故等级',
    field: 'accidentLevel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sgdj"
     },
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'InputTextArea',
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'InputTextArea',
  },
  {
    label: '死亡人数',
    field: 'deathToll',
    component: 'Input',
  },
  {
    label: '重伤人数',
    field: 'seriouslyInjuredNumber',
    component: 'Input',
  },
  {
    label: '轻伤人数',
    field: 'minorInjuriesNumber',
    component: 'Input',
  },
  {
    label: '事故概况',
    field: 'accidentDescription',
    component: 'Input',
  },
  {
    label: '处置状态',
    field: 'dispositionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"czzt"
     },
  },
  {
    label: '上报状态',
    field: 'registrationStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sbzt"
     },
  },
  {
    label: '上报时间',
    field: 'reportionTime',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '修改时间',
    field: 'updateDate',
    component: 'Input',
  },
  {
    label: '修改人姓名',
    field: 'updateBy',
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
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  accidentId: {title: '事故编号',order: 2,view: 'text', type: 'string',},
  accidentName: {title: '事故名称',order: 3,view: 'text', type: 'string',},
  accidentSource: {title: '事故来源',order: 4,view: 'text', type: 'string',},
  typeOfAccident: {title: '事故类型',order: 5,view: 'list', type: 'string',dictCode: 'sglx',},
  accidentLevel: {title: '事故等级',order: 6,view: 'list', type: 'string',dictCode: 'sgdj',},
  longitude: {title: '经度',order: 7,view: 'textarea', type: 'string',},
  latitude: {title: '纬度',order: 8,view: 'textarea', type: 'string',},
  deathToll: {title: '死亡人数',order: 9,view: 'text', type: 'string',},
  seriouslyInjuredNumber: {title: '重伤人数',order: 10,view: 'text', type: 'string',},
  minorInjuriesNumber: {title: '轻伤人数',order: 11,view: 'text', type: 'string',},
  accidentDescription: {title: '事故概况',order: 12,view: 'text', type: 'string',},
  dispositionStatus: {title: '处置状态',order: 13,view: 'list', type: 'string',dictCode: 'czzt',},
  registrationStatus: {title: '上报状态',order: 14,view: 'list', type: 'string',dictCode: 'sbzt',},
  reportionTime: {title: '上报时间',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}