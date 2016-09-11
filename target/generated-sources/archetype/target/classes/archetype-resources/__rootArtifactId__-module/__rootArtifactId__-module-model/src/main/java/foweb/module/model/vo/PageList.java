#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.foweb.module.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */

public final class PageList<E> implements List<E>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -129446275341656921L;
	private List<E> resulstList;

	private PageConfig pageConfig;

	public PageList(List<E> list) {
		resulstList = new ArrayList<E>();
		if (list != null) {
			resulstList.addAll(list);
		}
		/*
		 * list.addAll(c) if (resulstList == null) { resulstList = new
		 * ArrayList<E>(); }
		 */
	}

	public PageList(List<E> list, PageConfig pageConfig) {
		this(list);
		this.pageConfig = pageConfig;
	}

	@Override
	public int size() {
		return resulstList.size();
	}

	@Override
	public boolean isEmpty() {

		if (resulstList == null) {
			return true;
		}
		return resulstList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		if (resulstList == null) {
			return false;
		}
		return resulstList.contains(o);
	}

	@Override
	public Iterator<E> iterator() {

		return resulstList.iterator();
	}

	@Override
	public Object[] toArray() {

		return resulstList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return resulstList.toArray(a);
	}

	@Override
	public boolean add(E e) {

		return resulstList.add(e);
	}

	@Override
	public boolean remove(Object o) {

		return resulstList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return resulstList.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {

		return resulstList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {

		return resulstList.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return resulstList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return c.retainAll(c);
	}

	@Override
	public void clear() {

		resulstList.clear();
	}

	@Override
	public E get(int index) {

		return resulstList.get(index);
	}

	@Override
	public E set(int index, E element) {

		return resulstList.set(index, element);
	}

	@Override
	public void add(int index, E element) {

		resulstList.set(index, element);
	}

	@Override
	public E remove(int index) {

		return resulstList.remove(index);
	}

	@Override
	public int indexOf(Object o) {

		return resulstList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {

		return resulstList.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {

		return resulstList.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {

		return resulstList.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {

		return resulstList.subList(fromIndex, toIndex);
	}

	public PageConfig getPageConfig() {
		return pageConfig;
	}

	public void setPageConfig(PageConfig pageConfig) {
		this.pageConfig = pageConfig;
	}
}
