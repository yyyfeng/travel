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
 * 2018年10月23日 上午9:08:12
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
			//加载资源文件
			properties.load(JDBCUtils.class.getResourceAsStream("/db.properties"));
			//使用dataSource工厂创建DataSource
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
			//从数据源(dataSource)中获取连接
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
				//理论上不能关闭连接，只能还回池中
				//ConnectionPool.getInstance().returnCon(con);
				//代理连接的Colse被重写，就是将连接还回池中
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
