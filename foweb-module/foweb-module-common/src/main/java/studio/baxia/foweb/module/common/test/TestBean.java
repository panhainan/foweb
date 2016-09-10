/**
 * 
 */
package studio.baxia.foweb.module.common.test;

import java.util.Date;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
public class TestBean {
	private Integer id;
	private String name;
	private Date saveDate;

	@Override
	public String toString() {
		return "TestBean [id=" + id + ", name=" + name + ", saveDate="
				+ saveDate + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

}
