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
    title: '接警编码',
    align:"center",
    dataIndex: 'serialCode'
   },
   {
    title: '事故名称',
    align:"center",
    dataIndex: 'accidentName'
   },
   {
    title: '接警人',
    align:"center",
    dataIndex: 'pickUpPerson'
   },
   {
    title: '报警人',
    align:"center",
    dataIndex: 'callThePolice'
   },
   {
    title: '报警电话',
    align:"center",
    dataIndex: 'policeCall'
   },
   {
    title: '事故类型',
    align:"center",
    dataIndex: 'typeOfAccident_dictText'
   },
   {
    title: '事故装置',
    align:"center",
    dataIndex: 'accidentDevice'
   },
   {
    title: '涉及危险化学品',
    align:"center",
    dataIndex: 'hazardousChemicals'
   },
   {
    title: '关联企业编码',
    align:"center",
    dataIndex: 'affiliates'
   },
   {
    title: '接警时间',
    align:"center",
    dataIndex: 'policeTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '事故发生时间',
    align:"center",
    dataIndex: 'startTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
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
    title: '已采取措施',
    align:"center",
    dataIndex: 'accidentOverview'
   },
   {
    title: '处置状态',
    align:"center",
    dataIndex: 'dispositionStatus_dictText'
   },
   {
    title: '事故现场图片',
    align:"center",
    dataIndex: 'accidentSceneImg',
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
    label: "接警编码",
    field: "serialCode",
    component: 'JInput',
  },
  {
    label: "事故名称",
    field: "accidentName",
    component: 'JInput',
  },
  {
    label: "接警人",
    field: "pickUpPerson",
    component: 'JInput',
  },
  {
    label: "报警人",
    field: "callThePolice",
    component: 'JInput',
  },
  {
    label: "报警电话",
    field: "policeCall",
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
    label: "事故装置",
    field: "accidentDevice",
    component: 'JInput',
  },
  {
    label: "涉及危险化学品",
    field: "hazardousChemicals",
    component: 'JInput',
  },
	{
      label: "关联企业编码",
      field: 'affiliates',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "接警时间",
      field: "policeTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "事故发生时间",
      field: "startTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "死亡人数",
      field: "deathToll",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "重伤人数",
      field: "seriouslyInjuredNumber",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
     {
      label: "轻伤人数",
      field: "minorInjuriesNumber",
      component: 'JRangeNumber',
      //colProps: {span: 6},
	},
	{
      label: "处置状态",
      field: 'dispositionStatus',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"jjczzt"
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
    label: '接警编码',
    field: 'serialCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接警编码!'},
          ];
     },
  },
  {
    label: '事故名称',
    field: 'accidentName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故名称!'},
          ];
     },
  },
  {
    label: '接警人',
    field: 'pickUpPerson',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接警人!'},
          ];
     },
  },
  {
    label: '报警人',
    field: 'callThePolice',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警人!'},
          ];
     },
  },
  {
    label: '报警电话',
    field: 'policeCall',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报警电话!'},
          ];
     },
  },
  {
    label: '事故类型',
    field: 'typeOfAccident',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sglx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故类型!'},
          ];
     },
  },
  {
    label: '事故装置',
    field: 'accidentDevice',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故装置!'},
          ];
     },
  },
  {
    label: '涉及危险化学品',
    field: 'hazardousChemicals',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入涉及危险化学品!'},
          ];
     },
  },
  {
    label: '关联企业编码',
    field: 'affiliates',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入关联企业编码!'},
          ];
     },
  },
  {
    label: '接警时间',
    field: 'policeTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入接警时间!'},
          ];
     },
  },
  {
    label: '事故发生时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故发生时间!'},
          ];
     },
  },
  {
    label: '死亡人数',
    field: 'deathToll',
    component: 'InputNumber',
  },
  {
    label: '重伤人数',
    field: 'seriouslyInjuredNumber',
    component: 'InputNumber',
  },
  {
    label: '轻伤人数',
    field: 'minorInjuriesNumber',
    component: 'InputNumber',
  },
  {
    label: '已采取措施',
    field: 'accidentOverview',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入已采取措施!'},
          ];
     },
  },
  {
    label: '处置状态',
    field: 'dispositionStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"jjczzt"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处置状态!'},
          ];
     },
  },
  {
    label: '事故现场图片',
    field: 'accidentSceneImg',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故现场图片!'},
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
  serialCode: {title: '接警编码',order: 2,view: 'text', type: 'string',},
  accidentName: {title: '事故名称',order: 3,view: 'text', type: 'string',},
  pickUpPerson: {title: '接警人',order: 4,view: 'text', type: 'string',},
  callThePolice: {title: '报警人',order: 5,view: 'text', type: 'string',},
  policeCall: {title: '报警电话',order: 6,view: 'text', type: 'string',},
  typeOfAccident: {title: '事故类型',order: 7,view: 'list', type: 'string',dictCode: 'sglx',},
  accidentDevice: {title: '事故装置',order: 8,view: 'text', type: 'string',},
  hazardousChemicals: {title: '涉及危险化学品',order: 9,view: 'text', type: 'string',},
  affiliates: {title: '关联企业编码',order: 10,view: 'text', type: 'string',},
  policeTime: {title: '接警时间',order: 11,view: 'date', type: 'string',},
  startTime: {title: '事故发生时间',order: 12,view: 'date', type: 'string',},
  deathToll: {title: '死亡人数',order: 13,view: 'number', type: 'number',},
  seriouslyInjuredNumber: {title: '重伤人数',order: 14,view: 'number', type: 'number',},
  minorInjuriesNumber: {title: '轻伤人数',order: 15,view: 'number', type: 'number',},
  accidentOverview: {title: '已采取措施',order: 16,view: 'textarea', type: 'string',},
  dispositionStatus: {title: '处置状态',order: 17,view: 'list', type: 'string',dictCode: 'jjczzt',},
  accidentSceneImg: {title: '事故现场图片',order: 18,view: 'image', type: 'string',},
  deleted: {title: '删除标志',order: 19,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 20,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 21,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 22,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 23,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}