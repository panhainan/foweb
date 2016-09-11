#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.test.module.service.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.foweb.module.model.vo.PageConfig;
import ${package}.test.module.common.BaseTest;
import ${package}.test.module.model.pojo.TBean;
import ${package}.test.module.service.api.ITBeanService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
public class TBeanServiceImplTest extends BaseTest {
	@Autowired
	private ITBeanService iTBeanService;

	// 获取当前方法名
	// new Throwable().getStackTrace()[0].getMethodName();

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSaveT() {
		TBean testBean = new TBean();
		testBean.setName("FireOct" + Math.random());
		testBean.setSaveDate(new Date());
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.save(testBean));
	}

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}save(java.util.List)}
	 * .
	 */
	@Test
	public void testSaveListOfT() {
		List<TBean> list = new ArrayList<TBean>();
		for(int i=0;i<10;i++){
			TBean testBean = new TBean();
			testBean.setName("FireOct" + Math.random());
			testBean.setSaveDate(new Date());
			list.add(testBean);
		}
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.save(list));
	}

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}get(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testGet() {
		Integer id = 8;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.get(id));
	}
	@Test
	public void testList() {
		PageConfig pageConfig = new PageConfig();
		pageConfig.setPageIndex(0);
		pageConfig.setPageSize(4);
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.list(pageConfig));
	}
	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}delete(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testDelete() {
		Integer id = 05;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.delete(id));
	}

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}deleteAll(java.io.Serializable[])}
	 * .
	 */
	@Test
	public void testDeleteAll() {
		Integer[] ids = new Integer[10];
		for(int i=5,j=0;i<15;i++,j++){
			ids[j]=i+10;
		}
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ Arrays.toString(iTBeanService.deleteAll(ids)));
	}
	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}update(java.lang.Object)}
	 * .
	 */
	@Test
	public void testUpdateT() {
		Integer id = 26;
		TBean entity = iTBeanService.get(id);
		if (null != entity) {
			entity.setName("ut FireOct" + Math.random());
			entity.setSaveDate(new Date());
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),
					"受影响的行数（0表示删除失败或者该记录不存在）：")
					+ iTBeanService.update(entity));
		} else {
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),"ID错误，数据库不存在该id对应的记录!"));
		}
	}
	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}update(java.util.List)}
	 * .
	 */
	@Test
	public void testUpdateListOfT() {
		List<TBean> list = new ArrayList<TBean>();
		for(int i=5;i<15;i++){
			TBean testBean = new TBean();
			testBean.setId(i);
			testBean.setName("ut FireOct" + Math.random());
			testBean.setSaveDate(new Date());
			list.add(testBean);
		}
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanService.update(list));
	}

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}list(java.util.Map, ${package}.foweb.common.model.PageConfig)}
	 * .
	 */
	@Test
	public void testListMapPageConfig() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ${package}.foweb.service.impl.BaseServiceImpl${symbol_pound}list(java.lang.Object, ${package}.foweb.common.model.PageConfig)}
	 * .
	 */
	@Test
	public void testListTPageConfig() {
		fail("Not yet implemented");
	}

}
