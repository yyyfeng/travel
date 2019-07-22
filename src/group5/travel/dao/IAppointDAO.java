package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.Appoint;
import group5.travel.servlet.AppointServlet;
/**
 * 
 * @group
 * @author 营峰	 
 * @description TODO
 * @version
 * @date 2018年12月18日下午6:27:32
 */
public interface IAppointDAO {
	/**
	 * 添加保存预约单的方法
	 */
	public int save(Appoint a);
	/**
	 * 将预约单的状态改为1，表示已经处理完成
	 */
	public int updateStatus(int appointId);
	/**
	 * 将预约单的状态改为0，表示已经处理完成
	 */
	public int reUpdateStatus(int appointId);
	/**
	 *	添加分页查询的方法
	 */
	 public List<Appoint> queryByPage(int page,int rows);
	 /**
	  * 添加查询所有预约单总数的方法
	  */
	 public int queryCount();
	/**
	 * @param userId
	 * @return
	 */
	public List<Appoint> queryByUserId(int userId);
	/**
	 * @param appointId
	 * @return
	 */
	public Appoint queryByAppointId(int appointId);
}
