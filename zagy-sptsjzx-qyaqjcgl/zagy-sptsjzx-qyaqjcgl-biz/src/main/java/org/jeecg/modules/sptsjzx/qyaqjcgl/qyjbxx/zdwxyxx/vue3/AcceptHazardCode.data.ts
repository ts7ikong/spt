import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '危险源名称',
    align:"center",
    dataIndex: 'hazardName'
   },
   {
    title: '危险源编码',
    align:"center",
    dataIndex: 'hazardCode'
   },
   {
    title: '危险源等级',
    align:"center",
    dataIndex: 'level_dictText'
   },
   {
    title: '危险源简称',
    align:"center",
    dataIndex: 'hazardShortName'
   },
   {
    title: 'R值',
    align:"center",
    dataIndex: 'rvalue'
   },
   {
    title: '重大危险源分类',
    align:"center",
    dataIndex: 'hazardFactility_dictText'
   },
   {
    title: '地址',
    align:"center",
    dataIndex: 'address'
   },
   {
    title: '投用日期',
    align:"center",
    dataIndex: 'establishDate'
   },
   {
    title: '是否在化工园区 ',
    align:"center",
    dataIndex: 'inIndustrialPark_dictText'
   },
   {
    title: '园区名称',
    align:"center",
    dataIndex: 'industrialParkName'
   },
   {
    title: '是否涉及重点监管工艺',
    align:"center",
    dataIndex: 'isHazardCrafts_dictText'
   },
   {
    title: '主要负责人',
    align:"center",
    dataIndex: 'responsible'
   },
   {
    title: '技术负责人',
    align:"center",
    dataIndex: 'technical'
   },
   {
    title: '操作负责人',
    align:"center",
    dataIndex: 'operation'
   },
   {
    title: '操作负责人电话',
    align:"center",
    dataIndex: 'operationPhone'
   },
   {
    title: '生产状态',
    align:"center",
    dataIndex: 'productionStatus_dictText'
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
    label: "危险源名称",
    field: "hazardName",
    component: 'JInput',
  },
	{
      label: "危险源等级",
      field: 'level',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"wxydj"
      },
      //colProps: {span: 6},
 	},
	{
      label: "重大危险源分类",
      field: 'hazardFactility',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"zdwxyfl"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
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
    label: '危险源名称',
    field: 'hazardName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入危险源名称!'},
          ];
     },
  },
  {
    label: '危险源编码',
    field: 'hazardCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入危险源编码!'},
          ];
     },
  },
  {
    label: '危险源等级',
    field: 'level',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"wxydj"
     },
  },
  {
    label: '危险源简称',
    field: 'hazardShortName',
    component: 'Input',
  },
  {
    label: 'R值',
    field: 'rvalue',
    component: 'Input',
  },
  {
    label: '重大危险源分类',
    field: 'hazardFactility',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zdwxyfl"
     },
  },
  {
    label: '行政区域编码',
    field: 'areaCode',
    component: 'Input',
  },
  {
    label: '地址',
    field: 'address',
    component: 'Input',
  },
  {
    label: '经度',
    field: 'longitude',
    component: 'Input',
  },
  {
    label: '纬度',
    field: 'latitude',
    component: 'Input',
  },
  {
    label: '投用日期',
    field: 'establishDate',
    component: 'Input',
  },
  {
    label: '周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。',
    field: 'protectionTargetDistance',
    component: 'Input',
  },
  {
    label: '外边界500米返回人数估算',
    field: 'peoplem',
    component: 'Input',
  },
  {
    label: '是否在化工园区 ',
    field: 'inIndustrialPark',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '园区名称',
    field: 'industrialParkName',
    component: 'Input',
  },
  {
    label: '生产能力',
    field: 'produceAbility',
    component: 'Input',
  },
  {
    label: '是否涉及重点监管工艺',
    field: 'isHazardCrafts',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '装置去危险源关联的重点监管工艺 用逗号隔开',
    field: 'hazardCrafts',
    component: 'Input',
  },
  {
    label: '主要负责人',
    field: 'responsible',
    component: 'Input',
  },
  {
    label: '主要负责人电话',
    field: 'responsiblePhone',
    component: 'Input',
  },
  {
    label: '主要负责人职务',
    field: 'responsiblePost',
    component: 'Input',
  },
  {
    label: '技术负责人',
    field: 'technical',
    component: 'Input',
  },
  {
    label: '技术负责人电话',
    field: 'technicalPhone',
    component: 'Input',
  },
  {
    label: '技术负责人职务',
    field: 'technicalPost',
    component: 'Input',
  },
  {
    label: '操作负责人',
    field: 'operation',
    component: 'Input',
  },
  {
    label: '操作负责人职务',
    field: 'operationPost',
    component: 'Input',
  },
  {
    label: '操作负责人电话',
    field: 'operationPhone',
    component: 'Input',
  },
  {
    label: '生产状态',
    field: 'productionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sczt"
     },
  },
  {
    label: '创建人姓名',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createDate',
    component: 'Input',
  },
  {
    label: '修改人姓名',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '修改时间',
    field: 'updateDate',
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
  companyCode: {title: '企业名称',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  hazardName: {title: '危险源名称',order: 1,view: 'text', type: 'string',},
  hazardCode: {title: '危险源编码',order: 2,view: 'text', type: 'string',},
  level: {title: '危险源等级',order: 3,view: 'number', type: 'number',dictCode: 'wxydj',},
  hazardShortName: {title: '危险源简称',order: 4,view: 'text', type: 'string',},
  rvalue: {title: 'R值',order: 5,view: 'text', type: 'string',},
  hazardFactility: {title: '重大危险源分类',order: 6,view: 'list', type: 'string',dictCode: 'zdwxyfl',},
  address: {title: '地址',order: 8,view: 'text', type: 'string',},
  establishDate: {title: '投用日期',order: 11,view: 'text', type: 'string',},
  inIndustrialPark: {title: '是否在化工园区 ',order: 14,view: 'list', type: 'string',dictCode: 'sf',},
  industrialParkName: {title: '园区名称',order: 15,view: 'text', type: 'string',},
  isHazardCrafts: {title: '是否涉及重点监管工艺',order: 17,view: 'list', type: 'string',dictCode: 'sf',},
  responsible: {title: '主要负责人',order: 19,view: 'text', type: 'string',},
  technical: {title: '技术负责人',order: 22,view: 'text', type: 'string',},
  operation: {title: '操作负责人',order: 25,view: 'text', type: 'string',},
  operationPhone: {title: '操作负责人电话',order: 27,view: 'text', type: 'string',},
  productionStatus: {title: '生产状态',order: 28,view: 'list', type: 'string',dictCode: 'sczt',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}