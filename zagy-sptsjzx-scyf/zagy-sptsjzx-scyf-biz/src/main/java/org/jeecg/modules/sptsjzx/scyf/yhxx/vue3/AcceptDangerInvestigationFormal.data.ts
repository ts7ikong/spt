import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '隐患主键uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '隐患名称',
    align:"center",
    dataIndex: 'dangerName'
   },
   {
    title: '隐患等级',
    align:"center",
    dataIndex: 'dangerLevel_dictText'
   },
   {
    title: '隐患来源',
    align:"center",
    dataIndex: 'dangerSrc_dictText'
   },
   {
    title: '隐患治理类型',
    align:"center",
    dataIndex: 'dangerManageType_dictText'
   },
   {
    title: '隐患描述',
    align:"center",
    dataIndex: 'dangerDesc'
   },
   {
    title: '隐患治理期限',
    align:"center",
    dataIndex: 'dangerManageDeadline'
   },
   {
    title: '隐患状态',
    align:"center",
    dataIndex: 'dangerState_dictText'
   },
   {
    title: '隐患类型',
    align:"center",
    dataIndex: 'hazardDangerType_dictText'
   },
   {
    title: '隐患类别',
    align:"center",
    dataIndex: 'hazardCategory_dictText'
   },
   {
    title: '登记时间',
    align:"center",
    dataIndex: 'registTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '验收时间',
    align:"center",
    dataIndex: 'checkAcceptTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "隐患主键uuid",
    field: "uuid",
    component: 'JInput',
  },
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
      label: "风险分析对象",
      field: 'hazardCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_hazard_code,hazard_name,hazard_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "隐患名称",
    field: "dangerName",
    component: 'JInput',
  },
	{
      label: "隐患等级",
      field: 'dangerLevel',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhdj"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患来源",
      field: 'dangerSrc',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhly"
      },
      //colProps: {span: 6},
 	},
  {
    label: "隐患描述",
    field: "dangerDesc",
    component: 'JInput',
  },
	{
      label: "隐患状态",
      field: 'dangerState',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhzt3"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患类型",
      field: 'hazardDangerType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhlx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "隐患类别",
      field: 'hazardCategory',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yhlb"
      },
      //colProps: {span: 6},
 	},
     {
      label: "登记时间",
      field: "registTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "验收时间",
      field: "checkAcceptTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '隐患主键uuid',
    field: 'uuid',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '风险分析对象',
    field: 'hazardCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_hazard_code,hazard_name,hazard_code"
    },
  },
  {
    label: '管控措施ID',
    field: 'riskMeasureId',
    component: 'Input',
  },
  {
    label: '隐患排查记录ID',
    field: 'checkRecordId',
    component: 'Input',
  },
  {
    label: '隐患名称',
    field: 'dangerName',
    component: 'Input',
  },
  {
    label: '隐患等级',
    field: 'dangerLevel',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhdj"
     },
  },
  {
    label: '隐患来源',
    field: 'dangerSrc',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhly"
     },
  },
  {
    label: '隐患治理类型',
    field: 'dangerManageType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhzllx"
     },
  },
  {
    label: '隐患描述',
    field: 'dangerDesc',
    component: 'Input',
  },
  {
    label: '隐患产生原因',
    field: 'dangerReason',
    component: 'InputTextArea',
  },
  {
    label: '控制措施',
    field: 'controlMeasures',
    component: 'InputTextArea',
  },
  {
    label: '资金',
    field: 'cost',
    component: 'Input',
  },
  {
    label: '隐患治理期限',
    field: 'dangerManageDeadline',
    component: 'Input',
  },
  {
    label: '隐患状态',
    field: 'dangerState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhzt3"
     },
  },
  {
    label: '隐患类型',
    field: 'hazardDangerType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhlx"
     },
  },
  {
    label: '隐患类别',
    field: 'hazardCategory',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yhlb"
     },
  },
  {
    label: '登记人姓名',
    field: 'registrant',
    component: 'Input',
  },
  {
    label: '登记时间',
    field: 'registTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '整改责任人姓名',
    field: 'liablePerson',
    component: 'Input',
  },
  {
    label: '验收人',
    field: 'checkAcceptPerson',
    component: 'Input',
  },
  {
    label: '验收情况',
    field: 'checkAcceptComment',
    component: 'Input',
  },
  {
    label: '验收时间',
    field: 'checkAcceptTime',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: '整改前图片',
    field: 'pictureBefore',
    component: 'InputTextArea',
  },
  {
    label: '整改后图片',
    field: 'pictureAfter',
    component: 'InputTextArea',
  },
  {
    label: '推送状态 ',
    field: 'pushState',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"tszt2"
     },
  },
  {
    label: '推送次数',
    field: 'pushNum',
    component: 'InputNumber',
  },
  {
    label: '是否激活',
    field: 'isActivation',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfjh"
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
  uuid: {title: '隐患主键uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  dangerName: {title: '隐患名称',order: 5,view: 'text', type: 'string',},
  dangerLevel: {title: '隐患等级',order: 6,view: 'list', type: 'string',dictCode: 'yhdj',},
  dangerSrc: {title: '隐患来源',order: 7,view: 'list', type: 'string',dictCode: 'yhly',},
  dangerManageType: {title: '隐患治理类型',order: 8,view: 'list', type: 'string',dictCode: 'yhzllx',},
  dangerDesc: {title: '隐患描述',order: 9,view: 'text', type: 'string',},
  dangerManageDeadline: {title: '隐患治理期限',order: 13,view: 'text', type: 'string',},
  dangerState: {title: '隐患状态',order: 14,view: 'list', type: 'string',dictCode: 'yhzt3',},
  hazardDangerType: {title: '隐患类型',order: 15,view: 'list', type: 'string',dictCode: 'yhlx',},
  hazardCategory: {title: '隐患类别',order: 16,view: 'number', type: 'number',dictCode: 'yhlb',},
  registTime: {title: '登记时间',order: 18,view: 'date', type: 'string',},
  checkAcceptTime: {title: '验收时间',order: 22,view: 'date', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}