package it.pkg.foweb.module.dao.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import it.pkg.foweb.module.model.vo.PageConfig;


/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
public abstract interface IBaseDao<T> {
	/**
	 * 添加任意对象
	 * @param entity
	 */
	public abstract Integer insert(T entity);

	/**
	 * @param sqlMapId
	 * @param entity
	 * @return
	 */
	public abstract Integer insertBySqlMapId(String sqlMapId, T entity);

	/**
	 * 根据id取得实体
	 * @param id
	 */
	public abstract T get(Serializable paramSerializable);

	/**
	 * @param objParam
	 * @return
	 */
	public abstract Integer delete(Serializable paramSerializable);

	/**
	 * 删除
	 * @param id
	 */
	public abstract Integer deleteBy(T entity);

	/**
	 * 修改任意对象
	 * @param entity
	 */
	public abstract Integer update(T entity);

	/**
	 * @param entity
	 * @return
	 */
	public abstract Integer updateBy(T entity);

	/**
	 * @param sqlMapId
	 * @param objParam
	 * @return
	 */
	public abstract Integer updateBySqlMapId(String sqlMapId, Object objParam);

	public abstract Integer getCount(T t);
	
	/**
	 * 分页查询带查询条
	 * @param param
	 *            条件的MAP 包含排序等
	 * @param pageConfig
	 *            分页的信息
	 * @return
	 */
	public abstract List<T> queryPage(Map<String, Object> paramMap,
			PageConfig pageConfig);

	/**
	 * 分页查询带查询条
	 * @param param
	 *            条件的MAP 包含排序等
	 * @param pageConfig
	 *            分页的信息
	 * @return
	 */
	public abstract List<T> queryPage(T entity, PageConfig pageConfig);

	public abstract List<T> queryPage(PageConfig pageConfig);

}
