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
    title: '设备介质ID',
    align:"center",
    dataIndex: 'mediumId'
   },
   {
    title: '品名',
    align:"center",
    dataIndex: 'medium'
   },
   {
    title: '别名',
    align:"center",
    dataIndex: 'alias'
   },
   {
    title: 'CAS号',
    align:"center",
    dataIndex: 'cas'
   },
   {
    title: '浓度',
    align:"center",
    dataIndex: 'concentration'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "设备介质ID",
    field: "mediumId",
    component: 'JInput',
  },
  {
    label: "品名",
    field: "medium",
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
    label: '设备介质ID',
    field: 'mediumId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备介质ID!'},
          ];
     },
  },
  {
    label: '品名',
    field: 'medium',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入品名!'},
          ];
     },
  },
  {
    label: '别名',
    field: 'alias',
    component: 'Input',
  },
  {
    label: 'CAS号',
    field: 'cas',
    component: 'Input',
  },
  {
    label: '浓度',
    field: 'concentration',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入浓度!'},
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
  mediumId: {title: '设备介质ID',order: 1,view: 'text', type: 'string',},
  medium: {title: '品名',order: 2,view: 'text', type: 'string',},
  alias: {title: '别名',order: 3,view: 'text', type: 'string',},
  cas: {title: 'CAS号',order: 4,view: 'text', type: 'string',},
  concentration: {title: '浓度',order: 5,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}