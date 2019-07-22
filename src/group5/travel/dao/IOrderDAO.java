package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.Order;

/**
 * @group 
 * @author ����
 * @Description TODO
 * @date 2018��12��11��
 */
public interface IOrderDAO {

	/**
	 * ��ҳ��ѯ����
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Order> queryByPage(int page, int rows);

	/**
	 * ��ѯ������
	 * @return
	 */
	public int queryCount();

	/**
	 * ����IDɾ������
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(int orderId);

	/**
	 * �޸Ķ������״̬
	 * @param o
	 * @return
	 */
	public int status(Order o);

	/**
	 * ��Ӷ���
	 * @param o
	 * @return
	 */
	public int add(Order o);

	/**
	 * ����Id��ѯ����
	 * @param orderId
	 * @return
	 */
	public Order queryById(int orderId);

	/**
	 * �޸Ķ���
	 * @param order
	 * @return
	 */
	public int edit(Order order);


	public List<Order> queryAll(int id);

	public List<Order> queryBystatus(int id, int status2);


}
