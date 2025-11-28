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
    title: '现场救援行动编号',
    align:"center",
    dataIndex: 'rescueCode'
   },
   {
    title: '事故名称',
    align:"center",
    dataIndex: 'accidentName'
   },
   {
    title: '记录人',
    align:"center",
    dataIndex: 'rwcordName'
   },
   {
    title: '记录时间',
    align:"center",
    dataIndex: 'rwcordTime'
   },
   {
    title: '救援会议纪要',
    align:"center",
    dataIndex: 'summary',
   },
   {
    title: '调用物资、人员情况',
    align:"center",
    dataIndex: 'materialSituation'
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
          dictCode:"yqjbxx,park_name,park_code"
      },
      //colProps: {span: 6},
 	},
  {
    label: "现场救援行动编号",
    field: "rescueCode",
    component: 'JInput',
  },
  {
    label: "事故名称",
    field: "accidentName",
    component: 'JInput',
  },
  {
    label: "记录人",
    field: "rwcordName",
    component: 'JInput',
  },
     {
      label: "记录时间",
      field: "rwcordTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "救援会议纪要",
      field: 'summary',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "调用物资、人员情况",
      field: 'materialSituation',
      component: 'Input',
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
        dictCode:"yqjbxx,park_name,park_code"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入园区编码!'},
          ];
     },
  },
  {
    label: '现场救援行动编号',
    field: 'rescueCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入现场救援行动编号!'},
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
    label: '记录人',
    field: 'rwcordName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入记录人!'},
          ];
     },
  },
  {
    label: '记录时间',
    field: 'rwcordTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入记录时间!'},
          ];
     },
  },
  {
    label: '救援会议纪要',
    field: 'summary',
    component: 'JEditor',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入救援会议纪要!'},
          ];
     },
  },
  {
    label: '调用物资、人员情况',
    field: 'materialSituation',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入调用物资、人员情况!'},
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
  uuid: {title: '唯一uuid',order: 0,view: 'text', type: 'string',},
  parkCode: {title: '园区编码',order: 1,view: 'list', type: 'string',dictTable: "yqjbxx", dictCode: 'park_code', dictText: 'park_name',},
  rescueCode: {title: '现场救援行动编号',order: 2,view: 'text', type: 'string',},
  accidentName: {title: '事故名称',order: 3,view: 'text', type: 'string',},
  rwcordName: {title: '记录人',order: 4,view: 'text', type: 'string',},
  rwcordTime: {title: '记录时间',order: 5,view: 'datetime', type: 'string',},
  summary: {title: '救援会议纪要',order: 6,view: 'umeditor', type: 'string',},
  materialSituation: {title: '调用物资、人员情况',order: 7,view: 'text', type: 'string',},
  deleted: {title: '删除标志',order: 8,view: 'list', type: 'string',dictCode: 'scbz',},
  createTimeCompany: {title: '创建日期_企业',order: 9,view: 'datetime', type: 'string',},
  createByCompany: {title: '创建人_企业',order: 10,view: 'text', type: 'string',},
  updateTimeCompany: {title: '更新日期_企业',order: 11,view: 'datetime', type: 'string',},
  updateByCompany: {title: '更新人_企业',order: 12,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}