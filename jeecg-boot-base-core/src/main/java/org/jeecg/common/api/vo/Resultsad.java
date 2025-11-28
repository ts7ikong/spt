package org.jeecg.common.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.common.constant.CommonConstant;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author scott
 * @email jeecgos@163.com
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Resultsad<T> implements Serializable {

	private static final long serialVersionUID = 1L;

//	/**
//	 * 成功标志
//	 */
//	@ApiModelProperty(value = "成功标志")
//	private Boolean success = true;
//
//	/**
//	 * 返回处理消息
//	 */
//	@ApiModelProperty(value = "返回处理消息")
//	private String message = "";
//
	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 500;

//	/**
//	 * 返回数据对象 data
//	 */
	@ApiModelProperty(value = "返回数据对象")
	private T data;

//	/**
//	 * 时间戳
//	 */
//	@ApiModelProperty(value = "时间戳")
//	private long timestamp = System.currentTimeMillis();
//
//	private Integer state;
//	private String token ;

	public Resultsad() {
	}

//    /**
//     * 兼容VUE3版token失效不跳转登录页面
//     * @param code
//     * @param message
//     */
//	public Resultsad(Integer code, String message) {
//		this.code = code;
//		this.message = message;
//	}
//
//	public Resultsad<T> success(String message) {
//		this.message = message;
//		this.code = CommonConstant.SC_OK_200;
//		this.success = true;
//		return this;
//	}
//
//	@Deprecated
//	public static Resultsad<Object> ok() {
//		Resultsad<Object> r = new Resultsad<Object>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		return r;
//	}
//
//	@Deprecated
//	public static Resultsad<Object> ok(String msg) {
//		Resultsad<Object> r = new Resultsad<Object>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		r.setMessage(msg);
//		return r;
//	}
//
//	@Deprecated
//	public static Resultsad<Object> ok(Object data) {
//		Resultsad<Object> r = new Resultsad<Object>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		r.setResult(data);
//		return r;
//	}
//
//	public static<T> Resultsad<T> OK() {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		return r;
//	}
//
//	public static<T> Resultsad<T> OK(String msg) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		r.setMessage(msg);
//		//Result OK(String msg)方法会造成兼容性问题 issues/I4IP3D
//		r.setResult((T) msg);
//		r.setState(1);
//		return r;
//	}
	public static<T> Resultsad<T> OKs(T data) {
		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_0);
//		r.setMessage(msg);
		//Result OK(String msg)方法会造成兼容性问题 issues/I4IP3D
		r.setData((T) data);
//		r.setToken(msg);
//		r.setState(1);
		return r;
	}
//	public static<T> Resultsad<T> OK(T data) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		r.setResult(data);
//		r.setState(1);
//		return r;
//	}
//
//	public static<T> Resultsad<T> OK(String msg, T data) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(true);
//		r.setCode(CommonConstant.SC_OK_200);
//		r.setMessage(msg);
//		r.setResult(data);
//		r.setState(1);
//		return r;
//	}
//
public Resultsad<T> error500(String message) {
//	this.message = message;
	this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
//	this.success = false;
	return this;
}
//	public static<T> Resultsad<T> error(String msg, T data) {
//		Resultsad<T> r = new Resultsad<T>();
////		r.setSuccess(false);
//		r.setCode(CommonConstant.SC_INTERNAL_SERVER_ERROR_500);
////		r.setMessage(msg);
//		r.setData(data);
////		r.setState(0);
//		return r;
//	}
//
//	public static<T> Resultsad<T> errorMsg(String msg, T data) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(false);
//		r.setCode(HttpConstant.HTTP_400);
//		r.setMessage(msg);
//		r.setResult(data);
//		r.setState(0);
//		return r;
//	}
//
//	public static<T> Resultsad<T> errorStateMsg(String msg, T data) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(false);
//		r.setCode(HttpConstant.HTTP_200);
//		r.setMessage(msg);
//		r.setResult(data);
//		r.setState(0);
//		return r;
//	}
//
//	public static<T> Resultsad<T> errorStateMsg(String msg) {
//		Resultsad<T> r = new Resultsad<T>();
//		r.setSuccess(false);
//		r.setCode(HttpConstant.HTTP_200);
//		r.setMessage(msg);
//		r.setResult(null);
//		r.setState(0);
//		return r;
//	}
//
//	public static Resultsad<Object> error(String msg) {
//		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
//	}
//
//	public static Resultsad<Object> error(int code, String msg) {
//		Resultsad<Object> r = new Resultsad<Object>();
//		r.setCode(code);
//		r.setMessage(msg);
//		r.setSuccess(false);
//		r.setState(0);
//		return r;
//	}
//
//	public Resultsad<T> error500(String message) {
//		this.message = message;
//		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
//		this.success = false;
//		return this;
//	}
//	/**
//	 * 无权限访问返回结果
//	 */
//	public static Resultsad<Object> noauth(String msg) {
//		return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
//	}
//
//	@JsonIgnore
//	private String onlTable;
//
}