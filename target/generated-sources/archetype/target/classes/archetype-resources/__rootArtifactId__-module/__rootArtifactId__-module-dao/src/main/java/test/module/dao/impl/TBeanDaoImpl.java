#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.test.module.dao.impl;

import org.springframework.stereotype.Repository;

import ${package}.foweb.module.dao.impl.MyBatisDaoImpl;
import ${package}.test.module.dao.api.ITBeanDao;
import ${package}.test.module.model.pojo.TBean;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
@Repository("iTBeanDao")
public class TBeanDaoImpl extends MyBatisDaoImpl<TBean> implements
		ITBeanDao {

}
