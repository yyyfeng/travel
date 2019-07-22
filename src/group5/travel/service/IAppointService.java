package group5.travel.service;

import java.util.List;

import group5.travel.pojo.Appoint;
import group5.travel.servlet.AppointServlet;
import group5.travel.util.Page;

/**
 * 
 * @group
 * @author 营峰	 
 * @description TODO
 * @version
 * @date 2018年12月18日下午4:12:23
 */
public interface IAppointService {
	/**
	 * 保存预约单
	 */
	public int save(Appoint a);
	/**
	 * 修改预约单的状态
	 */
	public int updateStatus(int appointId);
	/**
	 * 修改预约单的状态
	 */
	public int reUpdateStatus(int appointId);
	/**
	 * 分页查询
	 */
	public Page<Appoint> queryByPage(int page,int rows);
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
