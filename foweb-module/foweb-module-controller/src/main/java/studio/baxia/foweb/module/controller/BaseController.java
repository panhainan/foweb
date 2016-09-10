/**
 * 
 */
package studio.baxia.foweb.module.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import studio.baxia.foweb.module.common.util.CommonResult;
import studio.baxia.foweb.module.model.vo.PageConfig;
import studio.baxia.foweb.module.service.api.IBaseService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016年9月10日
 */
public abstract class BaseController<T> {
	public static final String RESPONSE_SUCCESS_CODE = "1";
	public static final String RESPONSE_ERROR_CODE = "0";
	public static final String RESPONSE_NULL_MESSAGE = "请求的数据不存在或者为空！";

	protected abstract IBaseService<T> getService();

	@ResponseBody
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public CommonResult get(@PathVariable(value = "id") Integer id) {
		CommonResult commonResult = null;
		Boolean isSuccess = true;
		String message = null;
		T t = null;
		try {
			t = getService().get(id);
			if (null == t) {
				isSuccess = false;
				message = RESPONSE_NULL_MESSAGE;
			}
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
			message = e.getLocalizedMessage();
		} finally {
			if (isSuccess) {
				// 成功运行
				commonResult = new CommonResult(RESPONSE_SUCCESS_CODE, message,
						t);
			} else {
				// 失败运行
				commonResult = new CommonResult(RESPONSE_ERROR_CODE, message);
			}
		}
		return commonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public CommonResult list(T t, PageConfig pageConfig) {
		CommonResult commonResult = null;

		return commonResult;
	}
}
