import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'uuid',
    align:"center",
    dataIndex: 'uuid'
   },
   {
    title: '省级行政区划编码',
    align:"center",
    dataIndex: 'areaCode'
   },
   {
    title: '统计日期',
    align:"center",
    dataIndex: 'calcDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: 'APP下载次数',
    align:"center",
    dataIndex: 'appCount'
   },
   {
    title: '政府用户操作手册下载次数',
    align:"center",
    dataIndex: 'govManualCount'
   },
   {
    title: '企业用户操作手册下载次数',
    align:"center",
    dataIndex: 'cmpManualCount'
   },
   {
    title: '删除标记',
    align:"center",
    dataIndex: 'status_dictText'
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
      label: "uuid",
      field: 'uuid',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "省级行政区划编码",
      field: 'areaCode',
      component: 'Input',
      //colProps: {span: 6},
 	},
     {
      label: "统计日期",
      field: "calcDate",
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
    label: 'uuid',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入uuid!'},
          ];
     },
  },
  {
    label: '省级行政区划编码',
    field: 'areaCode',
    component: 'Input',
  },
  {
    label: '统计日期',
    field: 'calcDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD'
    },
  },
  {
    label: 'APP下载次数',
    field: 'appCount',
    component: 'InputNumber',
  },
  {
    label: '政府用户操作手册下载次数',
    field: 'govManualCount',
    component: 'InputNumber',
  },
  {
    label: '企业用户操作手册下载次数',
    field: 'cmpManualCount',
    component: 'InputNumber',
  },
  {
    label: '删除标记',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入删除标记!'},
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
  uuid: {title: 'uuid',order: 0,view: 'text', type: 'string',},
  areaCode: {title: '省级行政区划编码',order: 1,view: 'text', type: 'string',},
  calcDate: {title: '统计日期',order: 2,view: 'date', type: 'string',},
  appCount: {title: 'APP下载次数',order: 3,view: 'number', type: 'number',},
  govManualCount: {title: '政府用户操作手册下载次数',order: 4,view: 'number', type: 'number',},
  cmpManualCount: {title: '企业用户操作手册下载次数',order: 5,view: 'number', type: 'number',},
  status: {title: '删除标记',order: 6,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 7,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 8,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 9,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 10,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}