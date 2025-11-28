import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业编码',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '清单名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '责任部门',
    align:"center",
    dataIndex: 'hazardDep'
   },
   {
    title: '日周月类型',
    align:"center",
    dataIndex: 'type_dictText'
   },
   {
    title: '频次',
    align:"center",
    dataIndex: 'frequency'
   },
   {
    title: '频次类型',
    align:"center",
    dataIndex: 'frequenceType'
   },
   {
    title: '是否开启',
    align:"center",
    dataIndex: 'showstate_dictText'
   },
   {
    title: '周末是否开启',
    align:"center",
    dataIndex: 'isWeekendopen_dictText'
   },
   {
    title: '节假日是否开启',
    align:"center",
    dataIndex: 'isHolidayopen_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业编码",
      field: 'companyCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "清单名称",
    field: "name",
    component: 'JInput',
  },
	{
      label: "日周月类型",
      field: 'type',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"rzylx"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否开启",
      field: 'showstate',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"sfkq"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业编码',
    field: 'companyCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_accept_company,name,code"
    },
  },
  {
    label: '清单名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '责任部门',
    field: 'hazardDep',
    component: 'Input',
  },
  {
    label: '责任部门负责人姓名',
    field: 'hazardLiablePerson',
    component: 'Input',
  },
  {
    label: '日周月类型',
    field: 'type',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"rzylx"
     },
  },
  {
    label: '频次',
    field: 'frequency',
    component: 'InputNumber',
  },
  {
    label: '频次类型',
    field: 'frequenceType',
    component: 'InputNumber',
  },
  {
    label: '负责人姓名',
    field: 'principalname',
    component: 'Input',
  },
  {
    label: '负责人电话',
    field: 'principalphone',
    component: 'Input',
  },
  {
    label: '执行状态',
    field: 'state',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zxzt"
     },
  },
  {
    label: '是否开启',
    field: 'showstate',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sfkq"
     },
  },
  {
    label: '周末是否开启',
    field: 'isWeekendopen',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zmjjrsfkq"
     },
  },
  {
    label: '节假日是否开启',
    field: 'isHolidayopen',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zmjjrsfkq"
     },
  },
  {
    label: '工作开始时间',
    field: 'workStartTime',
    component: 'Input',
  },
  {
    label: '工作结束时间',
    field: 'workEndTime',
    component: 'Input',
  },
  {
    label: '负责人类型',
    field: 'belongType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"zrrlx"
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
  {
    label: '排查清单uuid',
    field: 'uuid',
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
  companyCode: {title: '企业编码',order: 0,view: 'sel_search', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  name: {title: '清单名称',order: 1,view: 'text', type: 'string',},
  hazardDep: {title: '责任部门',order: 2,view: 'text', type: 'string',},
  type: {title: '日周月类型',order: 4,view: 'number', type: 'number',dictCode: 'rzylx',},
  frequency: {title: '频次',order: 5,view: 'number', type: 'number',},
  frequenceType: {title: '频次类型',order: 6,view: 'number', type: 'number',},
  showstate: {title: '是否开启',order: 10,view: 'number', type: 'number',dictCode: 'sfkq',},
  isWeekendopen: {title: '周末是否开启',order: 11,view: 'number', type: 'number',dictCode: 'zmjjrsfkq',},
  isHolidayopen: {title: '节假日是否开启',order: 12,view: 'number', type: 'number',dictCode: 'zmjjrsfkq',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}