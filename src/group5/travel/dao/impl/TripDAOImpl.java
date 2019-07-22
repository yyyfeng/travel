package group5.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import group5.travel.dao.ITripDAO;
import group5.travel.pojo.Trip;
import group5.travel.util.JDBCUtils;

/**
 * 
 * @group 
 * @author 任浩男
 * @Description TODO
 * @date 2018年12月12日
 */

public class TripDAOImpl implements ITripDAO{
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
	/**
	 * 分页查询的方法
	 */

	@Override
	public List<Trip> queryByPage(int page, int rows) {
		String sql = "select * from g_trip limit ?,?;";
		try {
			return qr.query(sql,new BeanListHandler<Trip>(Trip.class), (page-1)*rows,rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询总条数的方法
	 */
	@Override
	public int queryCount() {
		String sql = "select COUNT(*) FROM g_trip;";
		try {
			return new Integer(qr.query(sql, new ScalarHandler()).toString()) ;
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
	 * 刪除行程商品Dao的实现
	 */
	@Override
	public int remove(int tripId) {
		String sql = "delete from g_trip where tripId =?";
		try {
			return qr.update(sql, tripId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int save(Trip trip) {
		String sql = "INSERT INTO g_trip (tripDays,tripName,tripDesc,tripImg,tripDest,experience,tripDetail,tripHotel,tripCost,costInclude,costUnInclude,reserveNote,tripMenu) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			return qr.update(sql,trip.getTripDays(),trip.getTripName(),trip.getTripDesc(),trip.getTripImg()
					,trip.getTripDest(),trip.getExperience(),trip.getTripDetail(),trip.getTripHotel(),trip.getTripCost(),trip.getCostInclude(),trip.getCostUnInclude(),trip.getReserveNote(),trip.getTripMenu());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 根据tripId查询查询的方法
	 */
	@Override
	public Trip queryById(int tripId) {
		String sql = "SELECT * FROM g_trip WHERE tripId=?;";
		try {
			return qr.query(sql,new BeanHandler<Trip>(Trip.class), tripId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改商品的方法
	 */
	@Override
	public int update(Trip trip) {
		String sql = "UPDATE g_trip SET tripDays=?,tripName=?,tripDesc=?,tripImg=?,tripDest=?,experience=?,tripDetail=?,tripHotel=?,tripCost=?,costInclude=?,costUnInclude=?,reserveNote=?,tripMenu=? WHERE tripId=?;";
		try {
			return qr.update(sql,trip.getTripDays(),trip.getTripName(),trip.getTripDesc(),trip.getTripImg(),trip.getTripDest(),
					trip.getExperience(),trip.getTripDetail(),trip.getTripHotel(),trip.getTripCost(),trip.getCostInclude(),trip.getCostUnInclude(),trip.getReserveNote(),trip.getTripMenu(),trip.getTripId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Trip> queryBymenu(String str) {
		String sql ="select t.* from g_trip t , g_menu m where t.tripMenu=m.menuId and m.menuDesc=?";
		try {
			List<Trip> st = qr.query(sql,new BeanListHandler<Trip>(Trip.class),str);
			System.out.println(st);
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据tripMenu查询的方法
	 */
	@Override
	public List<Trip> queryByTripMenu(int tripMenu) {
		String sql = "SELECT t.*,m.menuDesc FROM g_trip t ,g_menu m WHERE m.menuId=t.tripmenu and tripMenu=?;";
		try {
			return qr.query(sql,new BeanListHandler<Trip>(Trip.class),tripMenu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Trip> queryAll(int id) {
		String sql = "SELECT t.*,m.menuDesc FROM g_trip t ,g_menu m WHERE m.menuId=t.tripmenu and m.menuId<>1;";
		try {
			return qr.query(sql,new BeanListHandler<Trip>(Trip.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Trip> choose(String tripDest, String day, String menuDesc) {
		String sql = "select t.* ,m.menuDesc from g_trip t,g_menu m where t.tripmenu=m.menuId";
		if(!tripDest.equals("") && tripDest != null) {
			sql += " and t.tripDest = '"+tripDest+"'";
		}
		if(day.equals("1")) {
			sql += " and t.tripDays<7";
		}
		if(day.equals("2")) {
			sql += " and t.tripDays between 7 and 14";
		}
		if(day.equals("3")) {
			sql += " and t.tripDays>14";
		}
		if(menuDesc != null && !menuDesc.equals("")) {
			sql += " and m.menuDesc= '" +menuDesc+"'" ;
		}
		System.out.println(sql);
		try {
			return qr.query(sql, new BeanListHandler<>(Trip.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加查询所有旅行详情的方法
	 */
	@Override
	public List<Trip> queryAll() {
		String sql="select * from g_trip ";
		try {
			return qr.query(sql, new BeanListHandler<Trip>(Trip.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
