package group5.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import group5.travel.dao.IOrderDAO;
import group5.travel.dao.ITripDAO;
import group5.travel.dao.IUserDAO;
import group5.travel.pojo.Order;
import group5.travel.pojo.Trip;
import group5.travel.pojo.User;
import group5.travel.service.IOrderService;
import group5.travel.util.Page;

/**
 * @group 
 * @author 王凯
 * @Description TODO
 * @date 2018年12月11日
 */
public class OrderServiceImpl implements IOrderService{
	private IUserDAO userDAO;
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	private ITripDAO tripDAO;
	public void setTripDAO(ITripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}

	private IOrderDAO orderDAO;

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public Page<Order> queryByPage(int page, int rows) {
		Page<Order> p = new Page<>();
		p.setPage(page);
		//分页查询数据
		List<Order> oreds = orderDAO.queryByPage(page,rows);
		p.setRows(oreds);
		//查询总条数
		int total = orderDAO.queryCount();
		p.setTotal(total);
		return p;
	}

	@Override
	public int deleteOrder(int orderId) {
		return orderDAO.deleteOrder(orderId);
	}

	@Override
	public int status(Order o) {
		return orderDAO.status(o);
	}

	@Override
	public int add(Order o) {
		return orderDAO.add(o);
	}

	@Override
	public Order queryById(int orderId) {
		return orderDAO.queryById(orderId);
	}

	@Override
	public int edit(Order order) {
		return orderDAO.edit(order);
	}

	@Override
	public List<Order> queryAll(int id) {
		return orderDAO.queryAll(id);
	}

	@Override
	public List<Order> queryBystatus(int id,int status) {
		return orderDAO.queryBystatus(id,status);
	}

	@Override
	public Map<String, Object> detail(int orderId) {
		Map< String, Object> map = new HashMap<String,Object>();
		Order order = orderDAO.queryById(orderId);
		map.put("order", order);
			Trip trip=null;
			try {
				trip = tripDAO.queryById(order.getTripId());
			} catch (Exception e) {
			}
			map.put("trip", trip);
		return map;
	}

}
