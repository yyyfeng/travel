package group5.travel.dao;
/**
 * 
 * @group 
 * @author �κ���
 * @Description TODO
 * @date 2018��12��12��
 */

import java.util.List;

import group5.travel.pojo.Trip;

public interface ITripDAO {
	/**
	 * ��Ӳ�ѯ������������ķ���
	 */
	public List<Trip> queryAll();
	/**
	 * ������Ʒ
	 * @return
	 */
	public int save(Trip trip);
	/**
	 * ��ҳ��ѯ�г�
	 */
	public List<Trip> queryByPage(int page,int rows);

	/**
	 * ��ѯ�û������ķ���
	 */
	public int queryCount();
	/**
	 * �h���г���Ʒ�ķ���
	 */
	public int remove(int tripId);
	/**
	 * ����tripId��ѯ
	 * @param tripId
	 * @return
	 */
	public Trip queryById(int tripId);
	/**
	 * �޸��г���Ʒ�ķ���
	 * @param trip
	 * @return
	 */
	public int update(Trip trip);
	
	public List<Trip> queryBymenu(String str);
	/**
	 * ����menuId��ѯ��Ʒ����
	 */
	public List<Trip> queryByTripMenu(int TripMenu);
	public List<Trip> queryAll(int id);
	public List<Trip> choose(String tripDest, String day, String menuDesc);
}
