import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/list',
  save='/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/add',
  edit='/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/edit',
  deleteOne = '/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/delete',
  deleteBatch = '/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/deleteBatch',
  importExcel = '/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/importExcel',
  exportXls = '/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/exportXls',
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
