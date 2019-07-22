package group5.travel.service;

import java.util.List;

import group5.travel.pojo.Trip;
import group5.travel.util.Page;

/**
 * 
 * @group 
 * @author 任浩男
 * @Description TODO
 * @date 2018年12月12日
 */
public interface ITripService {
	/**
	 * 添加查询所有旅行详情的方法
	 */
	public List<Trip> queryAll();
	/**
	 * 分页查询
	 */
	public Page<Trip> queryByPage(int page,int rows);
	/**
	 * 根据id删除一行数据
	 */
	public int remove(int tripId);
	/**
	 * 插入一调数据
	 * @param trip
	 * @return
	 */
	public int save(Trip trip);
	/**
	 * 根据id查询
	 * @return
	 */
	public Trip queryById(int tripId);
	/**
	 * 修改数据
	 * @param trip
	 * @return
	 */
	public int update(Trip trip);

	
	public List<Trip> queryBymenu(String str);
	/**
	 * 根据menuId查询
	 */
	public List<Trip> queryByTripMenu(int TripMenu);
	public List<Trip> queryAll(int id);
	public List<Trip> choose(String tripDest, String day, String menuDesc);
}
