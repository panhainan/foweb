/**
 * 
 */
package it.pkg.test.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pkg.foweb.module.controller.BaseController;
import it.pkg.foweb.module.service.api.IBaseService;
import it.pkg.test.module.model.pojo.TBean;
import it.pkg.test.module.service.api.ITBeanService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016年9月10日
 */
@Controller
@RequestMapping("/testbean")
public class TBeanController extends BaseController<TBean> {
	@Autowired
	private ITBeanService iTBeanService;

	@Override
	protected IBaseService<TBean> getService() {
		return iTBeanService;
	}
	
	

}
