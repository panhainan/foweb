#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.test.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.foweb.module.dao.api.IBaseDao;
import ${package}.foweb.module.service.impl.BaseServiceImpl;
import ${package}.test.module.dao.api.ITBeanDao;
import ${package}.test.module.model.pojo.TBean;
import ${package}.test.module.service.api.ITBeanService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
@Service("iTBeanService")
public class TBeanServiceImpl extends BaseServiceImpl<TBean> implements
		ITBeanService{
	@Autowired
	private ITBeanDao iTBeanDao;

	@Override
	public IBaseDao<TBean> getDao() {
		return iTBeanDao;
	}

}
