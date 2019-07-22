package group5.travel.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**
 * @author www.igeekhome.com
 * TODO
 * 2018��10��23�� ����9:08:12
 */
public class JDBCUtils {
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	private static DataSource dataSource ;
	
	public static DataSource getDateSource() {
		return dataSource;
	}
	
	static {
		Properties properties = new Properties();
		try {
			//������Դ�ļ�
			properties.load(JDBCUtils.class.getResourceAsStream("/db.properties"));
			//ʹ��dataSource��������DataSource
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		Connection con = tl.get();
		if(con==null) {
			//������Դ(dataSource)�л�ȡ����
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.set(con);
		}
		return con;
	}
	
	public static void closeAll() {
		try {
			Connection con = tl.get();
			if(con!=null) {
				//�����ϲ��ܹر����ӣ�ֻ�ܻ��س���
				//ConnectionPool.getInstance().returnCon(con);
				//�������ӵ�Colse����д�����ǽ����ӻ��س���
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
