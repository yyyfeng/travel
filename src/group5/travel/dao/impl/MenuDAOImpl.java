package group5.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import group5.travel.dao.IMenuDAO;
import group5.travel.pojo.Menu;
import group5.travel.util.JDBCUtils;

public class MenuDAOImpl implements IMenuDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
	//分页查询
	public List<Menu> queryBy(int page, int rows) {
		String sql = "Select * from g_menu limit ?,?;";
		try {
			return qr.query(sql, new BeanListHandler<Menu>(Menu.class),(page-1)*rows,rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//查询总条数
	public int queryCount() {
		String sql ="Select count(*) from g_menu;";
		try {
			return new Integer(qr.query(sql, new ScalarHandler()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int remove(int menuId) {
		String sql = "delete from g_menu where menuId =?";
		try {
			return  qr.update(sql,menuId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int Add(Menu menu) {
		String sql = "insert into g_menu(menuDesc,menuImg) values(?,?)";
		try {
			return qr.update(sql, menu.getMenuDesc(),menu.getMenuImg());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Menu queryById(int id) {
		String sql = "select   * from g_menu where menuId=?";
		try {
			return qr.query(sql, new BeanHandler<>(Menu.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int update(Menu menu) {
		String sql = "update g_menu set menuDesc=?,menuImg=? where menuId=? ";
		try {
			return qr.update(sql, menu.getMenuDesc(),menu.getMenuImg(),menu.getMenuId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Menu> queryAll(int i, int j) {
		String sql = "Select * from g_menu limit ?,?;";
		try {
			return qr.query(sql, new BeanListHandler<Menu>(Menu.class),i,j);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Menu> queryAll() {
			String sql = "Select * from g_menu where menuId<>1";
			try {
				return qr.query(sql, new BeanListHandler<Menu>(Menu.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
}
