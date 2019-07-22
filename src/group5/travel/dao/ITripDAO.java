package group5.travel.dao;
/**
 * 
 * @group 
 * @author 任浩男
 * @Description TODO
 * @date 2018年12月12日
 */

import java.util.List;

import group5.travel.pojo.Trip;

public interface ITripDAO {
	/**
	 * 添加查询所有旅行详情的方法
	 */
	public List<Trip> queryAll();
	/**
	 * 保存商品
	 * @return
	 */
	public int save(Trip trip);
	/**
	 * 分页查询行程
	 */
	public List<Trip> queryByPage(int page,int rows);

	/**
	 * 查询用户总数的方法
	 */
	public int queryCount();
	/**
	 * 刪除行程商品的方法
	 */
	public int remove(int tripId);
	/**
	 * 根据tripId查询
	 * @param tripId
	 * @return
	 */
	public Trip queryById(int tripId);
	/**
	 * 修改行程商品的方法
	 * @param trip
	 * @return
	 */
	public int update(Trip trip);
	
	public List<Trip> queryBymenu(String str);
	/**
	 * 根据menuId查询商品集合
	 */
	public List<Trip> queryByTripMenu(int TripMenu);
	public List<Trip> queryAll(int id);
	public List<Trip> choose(String tripDest, String day, String menuDesc);
}
