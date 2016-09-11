/**
 * 
 */
package it.pkg.test.module.dao.impl;

import org.springframework.stereotype.Repository;

import it.pkg.foweb.module.dao.impl.MyBatisDaoImpl;
import it.pkg.test.module.dao.api.ITBeanDao;
import it.pkg.test.module.model.pojo.TBean;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
@Repository("iTBeanDao")
public class TBeanDaoImpl extends MyBatisDaoImpl<TBean> implements
		ITBeanDao {

}
