import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/list',
  save='/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/add',
  edit='/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/edit',
  deleteOne = '/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/delete',
  deleteBatch = '/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/deleteBatch',
  importExcel = '/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/importExcel',
  exportXls = '/sptsjzx/dsfdwgl/dsfwgjl/contractorViolationRecord/exportXls',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;
/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;
/**
 * 列表接口
 * @param params
 */
export const list = (params) =>
  defHttp.get({url: Api.list, params});

/**
 * 删除单个
 */
export const deleteOne = (params,handleSuccess) => {
  return defHttp.delete({url: Api.deleteOne, params}, {joinParamsToUrl: true}).then(() => {
    handleSuccess();
  });
}
/**
 * 批量删除
 * @param params
 */
export const batchDelete = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({url: Api.deleteBatch, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({url: url, params});
}
