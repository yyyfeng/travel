package group5.travel.service;

import java.util.List;
import java.util.Map;

import group5.travel.pojo.Order;
import group5.travel.pojo.User;
import group5.travel.util.Page;

/**
 * @group 
 * @author ����
 * @Description TODO
 * @date 2018��12��11��
 */
public interface IOrderService {

	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<Order> queryByPage(int page, int rows);

	/**
	 * ɾ������
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(int orderId);

	/**
	 * �޸Ķ���״̬
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
	 * �༭����
	 * @param order
	 * @return
	 */
	public int edit(Order order);


	public List<Order> queryAll(int userId);

	public List<Order> queryBystatus(int id, int status2);

	public Map<String, Object> detail(int orderId);

}
