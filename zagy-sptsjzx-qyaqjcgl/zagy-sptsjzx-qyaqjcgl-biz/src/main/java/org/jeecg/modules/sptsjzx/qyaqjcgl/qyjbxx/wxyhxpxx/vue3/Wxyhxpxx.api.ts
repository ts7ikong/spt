import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/list',
  save='/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/add',
  edit='/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/edit',
  deleteOne = '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/delete',
  deleteBatch = '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/deleteBatch',
  importExcel = '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/importExcel',
  exportXls = '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/exportXls',
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
