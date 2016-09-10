/**
 * 
 */
package studio.baxia.foweb.module.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	private Logger log = Logger.getLogger(this.getClass());

	public static final String RESPONSE_SUCCESS_CODE = "1";
	public static final String RESPONSE_ERROR_CODE = "0";
	public static final String RESPONSE_NULL_MESSAGE = "请求的数据不存在或者为空！";
	public static final String RESPONSE_OPERATE_FAILED_MESSAGE = "进行数据库操作失败！";

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
				commonResult = new CommonResult(RESPONSE_SUCCESS_CODE, t);
			} else {
				// 失败运行
				commonResult = new CommonResult(RESPONSE_ERROR_CODE, message);
			}
		}
		return commonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.POST })
	public CommonResult save(@RequestBody T t) {
		log.info("请求参数: t=" + t);
		CommonResult commonResult = null;
		Boolean isSuccess = true;
		String message = null;
		Integer result = 0;
		try {
			result = getService().save(t);
			if (result == 0) {
				isSuccess = false;
				message = RESPONSE_OPERATE_FAILED_MESSAGE;
			}
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
			message = e.getLocalizedMessage();
		} finally {
			if (isSuccess) {
				// 成功运行
				commonResult = new CommonResult(RESPONSE_SUCCESS_CODE, t);
			} else {
				// 失败运行
				commonResult = new CommonResult(RESPONSE_ERROR_CODE, message);
			}
		}
		return commonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.PUT })
	public CommonResult update(@RequestBody T t) {
		log.info("请求参数: t=" + t);
		CommonResult commonResult = null;
		Boolean isSuccess = true;
		String message = null;
		Integer result = 0;
		try {
			result = getService().update(t);
			if (result == 0) {
				isSuccess = false;
				message = RESPONSE_OPERATE_FAILED_MESSAGE;
			}
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
			message = e.getLocalizedMessage();
		} finally {
			if (isSuccess) {
				// 成功运行
				commonResult = new CommonResult(RESPONSE_SUCCESS_CODE, t);
			} else {
				// 失败运行
				commonResult = new CommonResult(RESPONSE_ERROR_CODE, message);
			}
		}
		return commonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public CommonResult delete(@PathVariable(value = "id") Integer id) {
		CommonResult commonResult = null;
		Boolean isSuccess = true;
		String message = null;
		Integer result = 0;
		try {
			result = getService().delete(id);
			if (result == 0) {
				isSuccess = false;
				message = RESPONSE_OPERATE_FAILED_MESSAGE;
			}
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
			message = e.getLocalizedMessage();
		} finally {
			if (isSuccess) {
				// 成功运行
				commonResult = new CommonResult(RESPONSE_SUCCESS_CODE, result);
			} else {
				// 失败运行
				commonResult = new CommonResult(RESPONSE_ERROR_CODE, message);
			}
		}
		return commonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public CommonResult list(PageConfig pageConfig) {
		CommonResult commonResult = null;
		
		return commonResult;
	}

}
