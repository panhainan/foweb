/**
 * 
 */
package studio.baxia.test.module.dao.impl;

import org.springframework.stereotype.Repository;

import studio.baxia.foweb.module.dao.impl.MyBatisDaoImpl;
import studio.baxia.test.module.dao.api.ITBeanDao;
import studio.baxia.test.module.model.pojo.TBean;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
@Repository("iTBeanDao")
public class TBeanDaoImpl extends MyBatisDaoImpl<TBean> implements
		ITBeanDao {

}
