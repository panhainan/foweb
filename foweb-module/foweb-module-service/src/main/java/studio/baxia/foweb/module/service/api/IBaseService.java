package studio.baxia.foweb.module.service.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import studio.baxia.foweb.module.model.vo.PageConfig;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
public abstract interface IBaseService<T> {
	public abstract Integer save(T paramT);

	public abstract List<Integer> save(List<T> paramList);

	public abstract T get(Serializable paramSerializable);

	public abstract Integer delete(Serializable paramSerializable);

	public abstract Integer update(T paramT);

	public abstract List<Integer> update(List<T> paramList);

	public abstract Integer[] deleteAll(Serializable[] paramArrayOfSerializable);

	public abstract List<T> list(Map paramMap, PageConfig paramPageConfig);

	public abstract List<T> list(PageConfig paramPageConfig);

	public abstract List<T> list(T paramT, PageConfig paramPageConfig);
}