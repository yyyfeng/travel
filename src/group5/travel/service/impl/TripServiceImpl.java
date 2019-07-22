package group5.travel.service.impl;

import java.util.List;

import group5.travel.dao.ITripDAO;
import group5.travel.pojo.Trip;
import group5.travel.service.ITripService;
import group5.travel.util.Page;
/**
 * 
 * @group 
 * @author 任浩男
 * @Description TODO
 * @date 2018年12月12日
 */
public class TripServiceImpl implements ITripService {
	private ITripDAO tripDAO;
	public void setTripDAO(ITripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}


	/**
	 * 分页查询行程商品列表
	 */
	@Override
	public Page<Trip> queryByPage(int page, int rows) {
		Page<Trip> p=new Page<>();
		//给page对象设置当前页码
		p.setPage(page);
		//设置总条数
		int  total = tripDAO.queryCount();
		p.setTotal(total);
		//设置分页查询的数据
		List<Trip> trips = tripDAO.queryByPage(page, rows);
		p.setRows(trips);
		//设置最大页码
		int maxPage = (int)Math.ceil(total/rows);
		p.setMaxPageNum(maxPage);
		return p;
	}

	/**
	 * 根据id删除数据
	 */
	@Override
	public int remove(int tripId) {
		return tripDAO.remove(tripId);
	}

	/**
	 * 插入一条数据
	 */
	@Override
	public int save(Trip trip) {
		return tripDAO.save(trip);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Trip queryById(int tripId) {
		return tripDAO.queryById(tripId);
	}


	@Override
	public int update(Trip trip) {
		return tripDAO.update(trip);
	}


	@Override
	public List<Trip> queryBymenu(String str) {
		return tripDAO.queryBymenu(str);
	}


	@Override
	public List<Trip> queryByTripMenu(int tripMenu) {
		return tripDAO.queryByTripMenu(tripMenu);
	}


	@Override
	public List<Trip> queryAll(int id) {
		// TODO Auto-generated method stub
		return tripDAO.queryAll(id);
	}


	@Override
	public List<Trip> choose(String tripDest, String day, String menuDesc) {
		// TODO Auto-generated method stub
		return tripDAO.choose(tripDest,day,menuDesc);
	}

	/**
	 * 添加查询所有旅行详情的方法
	 */
	@Override
	public List<Trip> queryAll() {
		// TODO Auto-generated method stub
		return tripDAO.queryAll();
	}
}
