package group5.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import group5.travel.dao.IOrderDAO;
import group5.travel.pojo.Order;
import group5.travel.util.JDBCUtils;

/**
 * @group 
 * @author 王凯
 * @Description TODO
 * @date 2018年12月11日
 */
public class OrderDAOImpl implements IOrderDAO{
	QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());

	@Override
	public List<Order> queryByPage(int page, int rows) {
		String sql = "select * from g_order limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Order>(Order.class),(page-1)*rows,rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int queryCount() {
		String sql = "select count(*) from g_order";
		try {
			return new Integer(qr.query(sql, new ScalarHandler()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOrder(int orderId) {
		String sql = "delete from g_order where orderId=?";
		try {
			return qr.update(sql, orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int status(Order o) {
		String sql = " update g_order set orderStatus=? where orderId=?";
		try {
			return qr.update(sql,o.getOrderStatus(),o.getOrderId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int add(Order o) {
		String sql = "insert into g_order(createTime,adultNum,childNum,startTime,tripId,userId,orderCost)values(?,?,?,?,?,?,?)";
		try {
			return qr.update(sql,o.getCreateTime(),o.getAdultNum(),o.getChildNum(),o.getStartTime(),o.getTripId(),o.getUserId(),o.getOrderCost());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Order queryById(int orderId) {
		String sql = "select * from g_order where orderId=? ";
		try {
			return qr.query(sql, new BeanHandler<Order>(Order.class),orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int edit(Order o) {
		String sql = "update g_order set startTime=?,adultNum=?,childNum=?,userId=?,tripId=?,orderCost=? where orderId=?";
		try {
			return qr.update(sql,o.getStartTime(),o.getAdultNum(),o.getChildNum(),o.getUserId(),o.getTripId(),o.getOrderCost(),o.getOrderId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Order> queryAll(int id) {
		String sql = "select  o.*, t.tripMenu,t.tripName from g_order o , g_trip t where o.tripId=t.tripId and userId =?";
		try {
			return qr.query(sql, new BeanListHandler<Order>(Order.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> queryBystatus(int id,int status) {
		String sql = "select  o.*, t.tripMenu,t.tripName from g_order o , g_trip t where o.tripId=t.tripId and userId =? and orderStatus=?";
		try {
			return qr.query(sql, new BeanListHandler<Order>(Order.class),id,status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
