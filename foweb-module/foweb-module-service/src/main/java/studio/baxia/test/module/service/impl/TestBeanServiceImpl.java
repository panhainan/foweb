/**
 * 
 */
package studio.baxia.test.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.baxia.foweb.module.common.test.TestBean;
import studio.baxia.foweb.module.dao.api.IBaseDao;
import studio.baxia.foweb.module.service.impl.BaseServiceImpl;
import studio.baxia.test.module.dao.api.ITestBeanDao;
import studio.baxia.test.module.service.api.ITestService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
@Service("iTestBeanService")
public class TestBeanServiceImpl extends BaseServiceImpl<TestBean> implements
		ITestService{
	@Autowired
	private ITestBeanDao iTestBeanDao;

	@Override
	public IBaseDao<TestBean> getDao() {
		return (IBaseDao<TestBean>) iTestBeanDao;
	}

}
