/**
 * 
 */
package it.pkg.foweb.module.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import it.pkg.foweb.module.dao.api.IBaseDao;
import it.pkg.foweb.module.model.vo.PageConfig;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
public class MyBatisDaoImpl<T> implements IBaseDao<T> {
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	private String insert = this.getClass().getName() + ".insert";
	private String updateByKey = this.getClass().getName() + ".updateByKey";
	private String update = this.getClass().getName() + ".update";
	private String deleteByKey = this.getClass().getName() + ".deleteByKey";
	private String delete = this.getClass().getName() + ".delete";
	private String seleteByKey = this.getClass().getName() + ".selectByKey";
	private String select = this.getClass().getName() + ".select";
	private String list = this.getClass().getName() + ".list";
	private String count = this.getClass().getName() + ".getCount";
	@Override
	public Integer insert(T entity) {
		return this.insertBySqlMapId(insert, entity);
	}

	@Override
	public Integer insertBySqlMapId(String sqlMapId, T entity) {
		return sqlSessionTemplate.insert(sqlMapId, entity);
	}

	@Override
	public T get(Serializable id) {
		return sqlSessionTemplate.selectOne(seleteByKey, id);
	}
	
	public List<T> select(T entity){
		return sqlSessionTemplate.selectOne(select, entity);
	}

	@Override
	public Integer delete(Serializable paramSerializable) {
		return sqlSessionTemplate.delete(deleteByKey, paramSerializable);
	}

	@Override
	public Integer deleteBy(Object objParam) {
		return sqlSessionTemplate.delete(delete, objParam);
	}

	@Override
	public Integer update(T entity) {
		return this.updateBySqlMapId(updateByKey, entity);

	}

	@Override
	public Integer updateBy(T entity) {
		return this.updateBySqlMapId(update, entity);

	}

	@Override
	public Integer updateBySqlMapId(String sqlMapId, Object objParam) {
		return sqlSessionTemplate.update(sqlMapId, objParam);
	}

	@Override
	public List<T> queryPage(Map<String, Object> paramMap, PageConfig pageConfig) {
		return null;
	}

	@Override
	public List<T> queryPage(T entity, PageConfig pageConfig) {
		return null;
	}
	@Override
	public List<T> queryPage( PageConfig pageConfig) {
		return sqlSessionTemplate.selectList(list, pageConfig);
	}
	@Override
	public Integer getCount(T t) {
		return this.sqlSessionTemplate.selectOne(count, t);
	}
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


}
