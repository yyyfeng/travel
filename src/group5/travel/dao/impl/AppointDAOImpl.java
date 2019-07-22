package group5.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import group5.travel.dao.IAppointDAO;
import group5.travel.pojo.Appoint;
import group5.travel.servlet.AppointServlet;
import group5.travel.util.JDBCUtils;

public class AppointDAOImpl implements IAppointDAO {
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
	/**
	 * 分页查询
	 */
	@Override
	public List<Appoint> queryByPage(int page, int rows) {
		String sql="select * from g_appoint limit ?,?;";
		try {
			return qr.query(sql,new BeanListHandler<Appoint>(Appoint.class),(page-1)*rows,rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int queryCount() {
		String sql="select count(*) from g_appoint";
	try {
		int result =new Integer( qr.query(sql, new ScalarHandler()).toString());
		return result;
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}
	/**
	 * 将预约单的状态改为1，表示已经处理完成
	 */
	@Override
	public int updateStatus(int appointId) {
		String sql="update g_appoint set appointStatus=1 where appointId=?";
		try {
			return qr.update(sql,appointId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 将预约单的状态改为0，表示已经处理完成
	 */
	@Override
	public int reUpdateStatus(int appointId) {
		String sql="update g_appoint set appointStatus=0 where appointId=?";
		try {
			return qr.update(sql,appointId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 保存预约单
	 */
	@Override
	public int save(Appoint a) {
		String sql="insert into g_appoint(appointName,appointTel,appointDest,appointDay,appointTime,"
				+ "appointAdult,appointChild,userId) values(?,?,?,?,?,?,?,?)";
		try {
			return qr.update(sql,a.getAppointName(),a.getAppointTel(),a.getAppointDest()
					,a.getAppointDay(),a.getAppointTime(),a.getAppointAdult(),a.getAppointChild(),a.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Appoint> queryByUserId(int userId) {
		String sql = "select * from g_appoint where userId=? ";
		try {
			return qr.query(sql, new BeanListHandler<Appoint>(Appoint.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Appoint queryByAppointId(int appointId) {
		String sql ="select * from g_appoint where appointId=?";
		try {
			return qr.query(sql, new BeanHandler<Appoint>(Appoint.class),appointId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
