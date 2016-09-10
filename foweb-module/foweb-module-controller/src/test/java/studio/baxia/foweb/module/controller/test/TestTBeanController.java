/**
 * 
 */
package studio.baxia.foweb.module.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import studio.baxia.test.module.common.BaseControlTest;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016年9月10日
 */

public class TestTBeanController extends BaseControlTest {

	@Test
	public void testGet() throws Exception {
		String responseString = mockMvc
				.perform(get("/testbean/5") // 请求的url,请求的方法是get
						.contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
//						.param("id", "6") // 添加参数
				).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out.println("==========================================================================");
	}
}
