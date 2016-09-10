/**
 * 
 */
package studio.baxia.test.module.dao.impl;

import org.springframework.stereotype.Repository;

import studio.baxia.foweb.module.common.test.TestBean;
import studio.baxia.foweb.module.dao.impl.MyBatisDaoImpl;
import studio.baxia.test.module.dao.api.ITestBeanDao;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
@Repository("iTestBeanDao")
public class TestBeanDaoImpl extends MyBatisDaoImpl<TestBean> implements
		ITestBeanDao {

}
