package cn.edu.sdu.qlsc.yh.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlMapUtils {

		
	private static final String CONFIG_FILE_PATH = "SqlmapConfiguration.xml";
	
	private SqlSessionFactory sessionFactory=null;
	private SqlSession session=null;
	private static SqlMapUtils instance=null;
	private static final Logger logger = LoggerFactory.getLogger(SqlMapUtils.class);
	public SqlMapUtils(){
		Reader reader=null;
		try {
			 reader = Resources.getResourceAsReader(CONFIG_FILE_PATH);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			session = sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static synchronized SqlMapUtils getInstance(){
		if (instance == null ){
			synchronized(SqlMapUtils.class){
				instance = new SqlMapUtils();
			}
		}
		
		return instance;
	}
	public SqlSession getSession(){
		if (session == null){
			throw new RuntimeException("Create SqlSession failed.");
		}
		return session;
	}

}
