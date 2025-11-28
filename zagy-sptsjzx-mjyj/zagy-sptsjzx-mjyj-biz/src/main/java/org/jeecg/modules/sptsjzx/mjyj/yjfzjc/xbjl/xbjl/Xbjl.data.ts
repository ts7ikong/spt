import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '唯一uuid',
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
    title: '事故现场图片',
    align:"center",
    dataIndex: 'accidentSceneImg',
    customRender:render.renderImage,
   },
   {
    title: '事故最新情况',
    align:"center",
    dataIndex: 'accidentLastSituation'
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
    label: "唯一uuid",
    field: "uuid",
    component: 'JInput',
  },
	{
      label: "园区编码",
      field: 'parkCode',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
  {
    label: "事故最新情况",
    field: "accidentLastSituation",
    component: 'JInput',
  },
	{
      label: "删除标志",
      field: 'deleted',
      component: 'JSelectMultiple',
      componentProps:{
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '唯一uuid',
    field: 'uuid',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入唯一uuid!'},
          ];
     },
  },
  {
    label: '园区编码',
    field: 'parkCode',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
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
    label: '事故最新情况',
    field: 'accidentLastSituation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入事故最新情况!'},
          ];
     },
  },
  {
    label: '删除标志',
    field: 'deleted',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:""
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
  uuid: {title: '唯一uuid',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictCode: '',},
  serialCode: {title: '接警编码',order: 2,view: 'text', type: 'string',},
  accidentSceneImg: {title: '事故现场图片',order: 3,view: 'image', type: 'string',},
  accidentLastSituation: {title: '事故最新情况',order: 4,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 5,view: 'list', type: 'string',dictCode: '',},
  createTimeCompany: {title: '创建日期_企业',order: 6,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 7,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 8,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 9,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}