/**
 * 
 */
package it.pkg.test.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pkg.foweb.module.dao.api.IBaseDao;
import it.pkg.foweb.module.service.impl.BaseServiceImpl;
import it.pkg.test.module.dao.api.ITBeanDao;
import it.pkg.test.module.model.pojo.TBean;
import it.pkg.test.module.service.api.ITBeanService;

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
