#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.test.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.foweb.module.controller.BaseController;
import ${package}.foweb.module.service.api.IBaseService;
import ${package}.test.module.model.pojo.TBean;
import ${package}.test.module.service.api.ITBeanService;

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
