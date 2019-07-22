package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.Order;

/**
 * @group 
 * @author 王凯
 * @Description TODO
 * @date 2018年12月11日
 */
public interface IOrderDAO {

	/**
	 * 分页查询数据
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Order> queryByPage(int page, int rows);

	/**
	 * 查询总条数
	 * @return
	 */
	public int queryCount();

	/**
	 * 根据ID删除订单
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(int orderId);

	/**
	 * 修改订单完成状态
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
	 * 修改订单
	 * @param order
	 * @return
	 */
	public int edit(Order order);


	public List<Order> queryAll(int id);

	public List<Order> queryBystatus(int id, int status2);


}
