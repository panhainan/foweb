/**
 * 
 */
package studio.baxia.foweb.module.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import com.alibaba.fastjson.JSONObject;

import studio.baxia.test.module.common.BaseControlTest;
import studio.baxia.test.module.model.pojo.TBean;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016年9月10日
 */

public class TBeanControllerTest extends BaseControlTest {

	@Test
	public void testGet() throws Exception {
		String responseString = mockMvc.perform(get("/testbean/2") // 请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
				// .param("id", "6") // 添加参数
				).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out
				.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out
				.println("==========================================================================");
	}
	@Test
	public void testList() throws Exception {
		String responseString = mockMvc.perform(get("/testbean/") // 请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
				// .param("id", "6") // 添加参数
				).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out
				.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out
				.println("==========================================================================");
	}
	// 有些单元测试你不希望回滚
	@Rollback(false)
	@Test
	public void testSave() throws Exception {
		TBean tBean = new TBean();
		tBean.setName("OCT" + Math.random());
		tBean.setSaveDate(new Date());
		String requestJson = JSONObject.toJSONString(tBean);
		String responseString = mockMvc.perform(post("/testbean/") // 请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out
				.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out
				.println("==========================================================================");
	}
	@Rollback(false)
	@Test
	public void testUpdate() throws Exception {
		TBean tBean = new TBean();
		tBean.setId(1);
		tBean.setName("ut FireOct" + Math.random());
		tBean.setSaveDate(new Date());

		 String requestJson = JSONObject.toJSONString(tBean);
		String responseString = mockMvc.perform(put("/testbean/") // 请求的url,请求的方法是get
				// .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式 
				// .flashAttr("t", tBean)		// 这里直接传实体对象
					 .contentType(MediaType.APPLICATION_JSON)
					 .content(requestJson)
				).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out
				.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out
				.println("==========================================================================");
	}

	@Test
	public void testDelete() throws Exception {
		String responseString = mockMvc.perform(delete("/testbean/1") // 请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
				).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		System.out
				.println("==================================  测试结果  ================================");
		System.out.println("返回的json = " + responseString);
		System.out
				.println("==========================================================================");
	}
}
