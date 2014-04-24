package cn.edu.sdu.qlsc.yh.jsoneditor;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.edu.sdu.qlsc.yh.test.IPersonDao;
import cn.edu.sdu.qlsc.yh.test.Person;
import cn.edu.sdu.qlsc.yh.test.SqlMapUtils;

public class IPersonDaoTest{
	IPersonDao studentMapper;
	SqlSession session;
	@Before
	public void init(){
		session = SqlMapUtils.getInstance().getSession();
		studentMapper = session.getMapper(IPersonDao.class);
	}
	//@Test
	public void testInsert(){
		Person student = new Person();
		student.setPassword("123");
		student.setName("luce");
		student.setId("1");
		studentMapper.insert(student);
		session.commit();
		
	}

	@Test
	public void testFind(){
		Person student = new Person();
		student.setPassword("123");
		student.setName("luce");
		student.setId("1");
		Person student2  = studentMapper.select("1");
		Assert.assertEquals("测试成功",student.getName(), student2.getName());
	}

	
	@After
	public void end(){
		session.close();
	}


}
