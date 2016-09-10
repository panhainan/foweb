/**
 * 
 */
package studio.baxia.foweb.module.service.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import studio.baxia.foweb.module.common.test.BaseTest;
import studio.baxia.foweb.module.common.test.TestBean;
import studio.baxia.test.module.service.api.ITestService;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-08
 */
public class TestBeanServiceImplTest extends BaseTest {
	@Autowired
	private ITestService iTestService;

	// 获取当前方法名
	// new Throwable().getStackTrace()[0].getMethodName();

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSaveT() {
		TestBean testBean = new TestBean();
		testBean.setName("FireOct" + Math.random());
		testBean.setSaveDate(new Date());
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTestService.save(testBean));
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#save(java.util.List)}
	 * .
	 */
	@Test
	public void testSaveListOfT() {
		List<TestBean> list = new ArrayList<TestBean>();
		for(int i=0;i<10;i++){
			TestBean testBean = new TestBean();
			testBean.setName("FireOct" + Math.random());
			testBean.setSaveDate(new Date());
			list.add(testBean);
		}
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTestService.save(list));
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#get(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testGet() {
		Integer id = 0;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTestService.get(id));
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#delete(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testDelete() {
		Integer id = 05;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTestService.delete(id));
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#deleteAll(java.io.Serializable[])}
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
				+ Arrays.toString(iTestService.deleteAll(ids)));
	}
	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#update(java.lang.Object)}
	 * .
	 */
	@Test
	public void testUpdateT() {
		Integer id = 26;
		TestBean entity = iTestService.get(id);
		if (null != entity) {
			entity.setName("ut FireOct" + Math.random());
			entity.setSaveDate(new Date());
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),
					"受影响的行数（0表示删除失败或者该记录不存在）：")
					+ iTestService.update(entity));
		} else {
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),"ID错误，数据库不存在该id对应的记录!"));
		}
	}
	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#update(java.util.List)}
	 * .
	 */
	@Test
	public void testUpdateListOfT() {
		List<TestBean> list = new ArrayList<TestBean>();
		for(int i=5;i<15;i++){
			TestBean testBean = new TestBean();
			testBean.setId(i);
			testBean.setName("ut FireOct" + Math.random());
			testBean.setSaveDate(new Date());
			list.add(testBean);
		}
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTestService.update(list));
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#list(java.util.Map, studio.baxia.foweb.common.model.PageConfig)}
	 * .
	 */
	@Test
	public void testListMapPageConfig() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link studio.baxia.foweb.service.impl.BaseServiceImpl#list(java.lang.Object, studio.baxia.foweb.common.model.PageConfig)}
	 * .
	 */
	@Test
	public void testListTPageConfig() {
		fail("Not yet implemented");
	}

}
