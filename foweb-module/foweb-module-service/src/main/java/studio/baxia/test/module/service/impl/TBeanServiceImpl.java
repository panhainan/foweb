/**
 * 
 */
package studio.baxia.test.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.baxia.foweb.module.dao.api.IBaseDao;
import studio.baxia.foweb.module.service.impl.BaseServiceImpl;
import studio.baxia.test.module.dao.api.ITBeanDao;
import studio.baxia.test.module.model.pojo.TBean;
import studio.baxia.test.module.service.api.ITBeanService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
@Service("iTBeanService")
public class TBeanServiceImpl extends BaseServiceImpl<TBean> implements
		ITBeanService{
	@Autowired
	private ITBeanDao iTestBeanDao;

	@Override
	public IBaseDao<TBean> getDao() {
		return iTestBeanDao;
	}

}
