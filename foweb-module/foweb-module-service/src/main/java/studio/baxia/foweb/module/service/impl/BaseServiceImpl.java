package studio.baxia.foweb.module.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import studio.baxia.foweb.module.dao.api.IBaseDao;
import studio.baxia.foweb.module.model.vo.PageConfig;
import studio.baxia.foweb.module.service.api.IBaseService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
@Transactional
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	final Logger logger = LoggerFactory.getLogger(getClass());

	public abstract IBaseDao<T> getDao();

	public Integer save(T entity) {
		return getDao().insert(entity);
	}

	public List<Integer> save(List<T> pojos) {
		List<Integer> results = new ArrayList<Integer>(
				(pojos != null ? pojos.size() : 0));
		for (T pojo : pojos) {
			results.add(getDao().insert(pojo));
		}
		return results;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public T get(Serializable id) {
		return getDao().get(id);
	}

	public Integer delete(Serializable id) {
		return getDao().delete(id);
	}

	public Integer[] deleteAll(Serializable[] ids) {
		Integer[] results = new Integer[(ids != null ? ids.length : 0)];
		for (int i = 0; i < ids.length; i++) {
			results[i] = delete(ids[i]);
		}
		return results;
	}

	public Integer update(T entity) {
		return getDao().update(entity);
	}

	public List<Integer> update(List<T> pojos) {
		List<Integer> results = new ArrayList<Integer>(
				(pojos != null ? pojos.size() : 0));
		for (T pojo : pojos)
			results.add(getDao().update(pojo));
		return results;
	}
	public Integer getCount(T t) {
		return getDao().getCount(t);
	}
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> list(Map paramMap, PageConfig pageConfig) {
		return getDao().queryPage(paramMap, pageConfig);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> list(PageConfig pageConfig) {
		return getDao().queryPage(pageConfig);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> list(T pojo, PageConfig pageConfig) {
		return getDao().queryPage(pojo, pageConfig);
	}
}