package it.pkg.foweb.module.common.util;

import java.io.Serializable;

public class CommonResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String RESULT_MSG_SUCCESS = "success";

	private static final String RESULT_MSG_ERROR = "error";

	/**
	 * 1成功,0失败
	 */
	private String resultCode;
	/**
	 * 简要异常信息
	 */
	private String resultMsg;
	/**
	 * 如果是成功请求,存放数据信息,如果失败,存放UdalException异常信息
	 */
	private Object resultData;

	public CommonResult() {

	}

	public CommonResult(String resultCode) {
		this.resultCode = resultCode;
		this.resultMsg = RESULT_MSG_SUCCESS;
	}

	public CommonResult(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public CommonResult(String resultCode, Object data) {
		this.resultCode = resultCode;
		this.resultMsg = RESULT_MSG_SUCCESS;
		this.resultData = data;
	}

	public CommonResult(String resultCode, String resultMsg, Object data) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = data;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
