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
    title: '园区编号',
    align:"center",
    dataIndex: 'parkCode_dictText'
   },
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode'
   },
   {
    title: '承诺日期',
    align:"center",
    dataIndex: 'commitDate'
   },
   {
    title: '生产装置套数',
    align:"center",
    dataIndex: 'unitsNumber'
   },
   {
    title: '运行套数',
    align:"center",
    dataIndex: 'runNumber'
   },
   {
    title: '停车套数',
    align:"center",
    dataIndex: 'parkNumber'
   },
   {
    title: '特级动火作业',
    align:"center",
    dataIndex: 'firesNumber'
   },
   {
    title: '一级动火作业',
    align:"center",
    dataIndex: 'fire1Number'
   },
   {
    title: '二级动火作业',
    align:"center",
    dataIndex: 'fire2Number'
   },
   {
    title: '断路作业',
    align:"center",
    dataIndex: 'roadworkNumber'
   },
   {
    title: '动土作业',
    align:"center",
    dataIndex: 'soilworkNumber'
   },
   {
    title: '高处作业',
    align:"center",
    dataIndex: 'highworkNumber'
   },
   {
    title: '临时用电作业',
    align:"center",
    dataIndex: 'electricityworkNumber'
   },
   {
    title: '吊装作业',
    align:"center",
    dataIndex: 'liftingworkNumber'
   },
   {
    title: '盲板作业',
    align:"center",
    dataIndex: 'blindplateNumber'
   },
   {
    title: '受限空间作业',
    align:"center",
    dataIndex: 'spaceworkNumber'
   },
   {
    title: '检维修作业',
    align:"center",
    dataIndex: 'inspectionNumber'
   },
   {
    title: '倒罐作业',
    align:"center",
    dataIndex: 'pourOutNumber'
   },
   {
    title: '清罐作业',
    align:"center",
    dataIndex: 'cleanTankNumber'
   },
   {
    title: '切水作业',
    align:"center",
    dataIndex: 'drainingNumber'
   },
   {
    title: '承包商作业',
    align:"center",
    dataIndex: 'contractorNumber'
   },
   {
    title: '变更作业',
    align:"center",
    dataIndex: 'changedTaskNumber'
   },
   {
    title: '是否有承包商作业',
    align:"center",
    dataIndex: 'contractor_dictText'
   },
   {
    title: '是否处于试生产期',
    align:"center",
    dataIndex: 'trialProduction_dictText'
   },
   {
    title: '是否处于开停车状态',
    align:"center",
    dataIndex: 'openParking_dictText'
   },
   {
    title: '正在开停车装置数',
    align:"center",
    dataIndex: 'openParkingNumber'
   },
   {
    title: '开车装置数',
    align:"center",
    dataIndex: 'workNumber'
   },
   {
    title: '停车装置数',
    align:"center",
    dataIndex: 'notWorkNumber'
   },
   {
    title: '是否开展中（扩）试',
    align:"center",
    dataIndex: 'test_dictText'
   },
   {
    title: '试生产装置 数',
    align:"center",
    dataIndex: 'testNumber'
   },
   {
    title: '检维修套数',
    align:"center",
    dataIndex: 'overhaulWorkNumber'
   },
   {
    title: '重点监管危险工艺数量',
    align:"center",
    dataIndex: 'dangerProcessNumber'
   },
   {
    title: '有无重大隐 患',
    align:"center",
    dataIndex: 'mmHazards_dictText'
   },
   {
    title: '风险级别',
    align:"center",
    dataIndex: 'riskGrade_dictText'
   },
   {
    title: '承诺人',
    align:"center",
    dataIndex: 'commitment'
   },
   {
    title: '承诺内容',
    align:"center",
    dataIndex: 'commitContent'
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
      label: "园区编号",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否有承包商作业",
      field: 'contractor',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否处于试生产期",
      field: 'trialProduction',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否处于开停车状态",
      field: 'openParking',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否开展中（扩）试",
      field: 'test',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "有无重大隐 患",
      field: 'mmHazards',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sf"
      },
      //colProps: {span: 6},
 	},
	{
      label: "风险级别",
      field: 'riskGrade',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"fxjb"
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
    label: '园区编号',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编号!'},
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
    label: '承诺日期',
    field: 'commitDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入承诺日期!'},
          ];
     },
  },
  {
    label: '生产装置套数',
    field: 'unitsNumber',
    component: 'InputNumber',
  },
  {
    label: '运行套数',
    field: 'runNumber',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入运行套数!'},
          ];
     },
  },
  {
    label: '停车套数',
    field: 'parkNumber',
    component: 'InputNumber',
  },
  {
    label: '特级动火作业',
    field: 'firesNumber',
    component: 'InputNumber',
  },
  {
    label: '一级动火作业',
    field: 'fire1Number',
    component: 'InputNumber',
  },
  {
    label: '二级动火作业',
    field: 'fire2Number',
    component: 'InputNumber',
  },
  {
    label: '断路作业',
    field: 'roadworkNumber',
    component: 'InputNumber',
  },
  {
    label: '动土作业',
    field: 'soilworkNumber',
    component: 'InputNumber',
  },
  {
    label: '高处作业',
    field: 'highworkNumber',
    component: 'InputNumber',
  },
  {
    label: '临时用电作业',
    field: 'electricityworkNumber',
    component: 'InputNumber',
  },
  {
    label: '吊装作业',
    field: 'liftingworkNumber',
    component: 'InputNumber',
  },
  {
    label: '盲板作业',
    field: 'blindplateNumber',
    component: 'InputNumber',
  },
  {
    label: '受限空间作业',
    field: 'spaceworkNumber',
    component: 'InputNumber',
  },
  {
    label: '检维修作业',
    field: 'inspectionNumber',
    component: 'InputNumber',
  },
  {
    label: '倒罐作业',
    field: 'pourOutNumber',
    component: 'InputNumber',
  },
  {
    label: '清罐作业',
    field: 'cleanTankNumber',
    component: 'InputNumber',
  },
  {
    label: '切水作业',
    field: 'drainingNumber',
    component: 'InputNumber',
  },
  {
    label: '承包商作业',
    field: 'contractorNumber',
    component: 'InputNumber',
  },
  {
    label: '变更作业',
    field: 'changedTaskNumber',
    component: 'InputNumber',
  },
  {
    label: '是否有承包商作业',
    field: 'contractor',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否处于试生产期',
    field: 'trialProduction',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '是否处于开停车状态',
    field: 'openParking',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '正在开停车装置数',
    field: 'openParkingNumber',
    component: 'InputNumber',
  },
  {
    label: '开车装置数',
    field: 'workNumber',
    component: 'InputNumber',
  },
  {
    label: '停车装置数',
    field: 'notWorkNumber',
    component: 'InputNumber',
  },
  {
    label: '是否开展中（扩）试',
    field: 'test',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '试生产装置 数',
    field: 'testNumber',
    component: 'InputNumber',
  },
  {
    label: '检维修套数',
    field: 'overhaulWorkNumber',
    component: 'InputNumber',
  },
  {
    label: '重点监管危险工艺数量',
    field: 'dangerProcessNumber',
    component: 'InputNumber',
  },
  {
    label: '有无重大隐 患',
    field: 'mmHazards',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sf"
     },
  },
  {
    label: '风险级别',
    field: 'riskGrade',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"fxjb"
     },
  },
  {
    label: '承诺人',
    field: 'commitment',
    component: 'Input',
  },
  {
    label: '承诺内容',
    field: 'commitContent',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入承诺内容!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    defaultValue: "0",
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
  parkCode: {title: '园区编号',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  companyCode: {title: '企业编码',order: 2,view: 'text', type: 'string',},
  commitDate: {title: '承诺日期',order: 3,view: 'datetime', type: 'string',},
  unitsNumber: {title: '生产装置套数',order: 4,view: 'number', type: 'number',},
  runNumber: {title: '运行套数',order: 5,view: 'number', type: 'number',},
  parkNumber: {title: '停车套数',order: 6,view: 'number', type: 'number',},
  firesNumber: {title: '特级动火作业',order: 7,view: 'number', type: 'number',},
  fire1Number: {title: '一级动火作业',order: 8,view: 'number', type: 'number',},
  fire2Number: {title: '二级动火作业',order: 9,view: 'number', type: 'number',},
  roadworkNumber: {title: '断路作业',order: 10,view: 'number', type: 'number',},
  soilworkNumber: {title: '动土作业',order: 11,view: 'number', type: 'number',},
  highworkNumber: {title: '高处作业',order: 12,view: 'number', type: 'number',},
  electricityworkNumber: {title: '临时用电作业',order: 13,view: 'number', type: 'number',},
  liftingworkNumber: {title: '吊装作业',order: 14,view: 'number', type: 'number',},
  blindplateNumber: {title: '盲板作业',order: 15,view: 'number', type: 'number',},
  spaceworkNumber: {title: '受限空间作业',order: 16,view: 'number', type: 'number',},
  inspectionNumber: {title: '检维修作业',order: 17,view: 'number', type: 'number',},
  pourOutNumber: {title: '倒罐作业',order: 18,view: 'number', type: 'number',},
  cleanTankNumber: {title: '清罐作业',order: 19,view: 'number', type: 'number',},
  drainingNumber: {title: '切水作业',order: 20,view: 'number', type: 'number',},
  contractorNumber: {title: '承包商作业',order: 21,view: 'number', type: 'number',},
  changedTaskNumber: {title: '变更作业',order: 22,view: 'number', type: 'number',},
  contractor: {title: '是否有承包商作业',order: 23,view: 'list', type: 'string',dictCode: 'sf',},
  trialProduction: {title: '是否处于试生产期',order: 24,view: 'list', type: 'string',dictCode: 'sf',},
  openParking: {title: '是否处于开停车状态',order: 25,view: 'list', type: 'string',dictCode: 'sf',},
  openParkingNumber: {title: '正在开停车装置数',order: 26,view: 'number', type: 'number',},
  workNumber: {title: '开车装置数',order: 27,view: 'number', type: 'number',},
  notWorkNumber: {title: '停车装置数',order: 28,view: 'number', type: 'number',},
  test: {title: '是否开展中（扩）试',order: 29,view: 'list', type: 'string',dictCode: 'sf',},
  testNumber: {title: '试生产装置 数',order: 30,view: 'number', type: 'number',},
  overhaulWorkNumber: {title: '检维修套数',order: 31,view: 'number', type: 'number',},
  dangerProcessNumber: {title: '重点监管危险工艺数量',order: 32,view: 'number', type: 'number',},
  mmHazards: {title: '有无重大隐 患',order: 33,view: 'list', type: 'string',dictCode: 'sf',},
  riskGrade: {title: '风险级别',order: 34,view: 'list', type: 'string',dictCode: 'fxjb',},
  commitment: {title: '承诺人',order: 35,view: 'text', type: 'string',},
  commitContent: {title: '承诺内容',order: 36,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 37,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 38,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 39,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 40,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 41,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}