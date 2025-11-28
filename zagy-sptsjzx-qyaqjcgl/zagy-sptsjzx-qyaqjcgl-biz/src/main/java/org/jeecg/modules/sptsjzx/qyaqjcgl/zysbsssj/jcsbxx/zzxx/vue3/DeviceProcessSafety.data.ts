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
    title: '设备名称',
    align:"center",
    dataIndex: 'equipCode_dictText'
   },
   {
    title: '所属工艺',
    align:"center",
    dataIndex: 'chemprocessType'
   },
   {
    title: '安全仪表联锁回路总数',
    align:"center",
    dataIndex: 'interlockingCount'
   },
   {
    title: '安全仪表系统投用状态的指标编码',
    align:"center",
    dataIndex: 'mainSwitchStatusTargetCode'
   },
   {
    title: '安全仪表联锁回路旁路数的指标编码',
    align:"center",
    dataIndex: 'bypassSwitchTotalTargetCode'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备名称",
      field: 'equipCode',
      component: 'JSearchSelect',
      componentProps:{
         dict:"v_device_base_info,equip_name,equip_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "所属工艺",
    field: "chemprocessType",
    component: 'JInput',
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
    label: '设备名称',
    field: 'equipCode',
    component: 'JSearchSelect',
    componentProps:{
       dict:"v_device_base_info,equip_name,equip_code"
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备名称!'},
          ];
     },
    dynamicDisabled:true
  },
  {
    label: '所属工艺',
    field: 'chemprocessType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属工艺!'},
          ];
     },
  },
  {
    label: '安全仪表联锁回路总数',
    field: 'interlockingCount',
    component: 'InputNumber',
  },
  {
    label: '安全仪表系统投用状态的指标编码',
    field: 'mainSwitchStatusTargetCode',
    component: 'Input',
  },
  {
    label: '安全仪表联锁回路旁路数的指标编码',
    field: 'bypassSwitchTotalTargetCode',
    component: 'Input',
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
    label: '最后修改时间',
    field: 'updateDate',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最后修改时间!'},
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
  equipCode: {title: '设备名称',order: 1,view: 'sel_search', type: 'string',dictTable: "v_device_base_info", dictCode: 'equip_code', dictText: 'equip_name',},
  chemprocessType: {title: '所属工艺',order: 2,view: 'text', type: 'string',},
  interlockingCount: {title: '安全仪表联锁回路总数',order: 3,view: 'number', type: 'number',},
  mainSwitchStatusTargetCode: {title: '安全仪表系统投用状态的指标编码',order: 4,view: 'text', type: 'string',},
  bypassSwitchTotalTargetCode: {title: '安全仪表联锁回路旁路数的指标编码',order: 5,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}