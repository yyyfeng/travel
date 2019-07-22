package group5.travel.service;

import java.util.List;
import java.util.Map;

import group5.travel.pojo.Order;
import group5.travel.pojo.User;
import group5.travel.util.Page;

/**
 * @group 
 * @author 王凯
 * @Description TODO
 * @date 2018年12月11日
 */
public interface IOrderService {

	/**
	 * 分页查询订单信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<Order> queryByPage(int page, int rows);

	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(int orderId);

	/**
	 * 修改订单状态
	 * @param o
	 * @return
	 */
	public int status(Order o);

	/**
	 * 添加订单
	 * @param o
	 * @return
	 */
	public int add(Order o);

	/**
	 * 根据Id查询订单
	 * @param orderId
	 * @return
	 */
	public Order queryById(int orderId);

	/**
	 * 编辑订单
	 * @param order
	 * @return
	 */
	public int edit(Order order);


	public List<Order> queryAll(int userId);

	public List<Order> queryBystatus(int id, int status2);

	public Map<String, Object> detail(int orderId);

}
