import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '主键uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '企业',
    align:"center",
    dataIndex: 'companyCode_dictText'
   },
   {
    title: '实时数据接口地址',
    align:"center",
    dataIndex: 'rydwSssj'
   },
   {
    title: '历史定位数据接口地址',
    align:"center",
    dataIndex: 'rydwLssj'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "企业",
      field: 'companyCode',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"v_accept_company,name,code"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '主键uuid',
    field: 'uuid',
    component: 'Input',
  },
  {
    label: '企业',
    field: 'companyCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"v_accept_company,name,code"
     },
  },
  {
    label: '实时数据接口地址',
    field: 'rydwSssj',
    component: 'Input',
  },
  {
    label: '历史定位数据接口地址',
    field: 'rydwLssj',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createTime',
    component: 'Input',
  },
  {
    label: '应急部返回batch编码',
    field: 'batchId',
    component: 'Input',
  },
  {
    label: '我们返回企业的batch编码',
    field: 'wbatchId',
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
  uuid: {title: '主键uuid',order: 0,view: 'text', type: 'string',},
  companyCode: {title: '企业',order: 1,view: 'list', type: 'string',dictTable: "v_accept_company", dictCode: 'code', dictText: 'name',},
  rydwSssj: {title: '实时数据接口地址',order: 2,view: 'text', type: 'string',},
  rydwLssj: {title: '历史定位数据接口地址',order: 3,view: 'text', type: 'string',},
  createTime: {title: '创建时间',order: 4,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}