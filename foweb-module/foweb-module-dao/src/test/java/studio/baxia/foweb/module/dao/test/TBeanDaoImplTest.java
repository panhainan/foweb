/**
 * 
 */
package studio.baxia.foweb.module.dao.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import studio.baxia.test.module.common.BaseTest;
import studio.baxia.test.module.dao.api.ITBeanDao;
import studio.baxia.test.module.model.pojo.TBean;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
public class TBeanDaoImplTest extends BaseTest {

//	public static void main(String[] args) {
//		String n1 = null, n2 = null, n3 = null;
//		Date s = new Date();
//		for (int i = 0; i < 10000000; i++) {
//			n1 = Thread.currentThread().getStackTrace()[1].getMethodName();
//		}
//		Date s1 = new Date();
//		for (int i = 0; i < 10000000; i++) {
//			n2 = new Object() {
//			}.getClass().getEnclosingMethod().getName();
//		}
//		Date s2 = new Date();
//		for (int i = 0; i < 10000000; i++) {
//			n3 = new Throwable().getStackTrace()[0].getMethodName();
//		}
//		Date s3 = new Date();
//
//		System.out.println(s1.getTime() - s.getTime());
//		System.out.println(s2.getTime() - s1.getTime());
//		System.out.println(s3.getTime() - s2.getTime());
//		System.out.println(n1 + "\t" + n2 + "\t" + n3);
//	}

	@Autowired
	private ITBeanDao iTBeanDao;


	@Test
	public void testInsert() {
		TBean entity = new TBean();
		entity.setName("FireOct" + Math.random());
		entity.setSaveDate(new Date());
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanDao.insert(entity));
	}

	@Test
	public void testGet() {
		Integer id = 8;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(), null)
				+ iTBeanDao.get(id));
	}

	@Test
	public void testDelete() {
		Integer id = 25;
		System.out.println(printResultStr(
				new Throwable().getStackTrace()[0].getMethodName(),
				"受影响的行数（0表示删除失败或者该记录不存在）：") + iTBeanDao.delete(id));
	}

	@Test
	public void testUpdate() {
		Integer id = 0;
		TBean entity = iTBeanDao.get(id);
		if (null != entity) {
			entity.setName("ut FireOct" + Math.random());
			entity.setSaveDate(new Date());
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),
					"受影响的行数（0表示删除失败或者该记录不存在）：")
					+ iTBeanDao.update(entity));
		} else {
			System.out.println(printResultStr(
					new Throwable().getStackTrace()[0].getMethodName(),"ID错误，数据库不存在该id对应的记录!"));
		}

	}

}
