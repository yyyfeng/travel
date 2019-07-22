package group5.travel.service;

import java.util.List;

import group5.travel.pojo.Trip;
import group5.travel.util.Page;

/**
 * 
 * @group 
 * @author �κ���
 * @Description TODO
 * @date 2018��12��12��
 */
public interface ITripService {
	/**
	 * ��Ӳ�ѯ������������ķ���
	 */
	public List<Trip> queryAll();
	/**
	 * ��ҳ��ѯ
	 */
	public Page<Trip> queryByPage(int page,int rows);
	/**
	 * ����idɾ��һ������
	 */
	public int remove(int tripId);
	/**
	 * ����һ������
	 * @param trip
	 * @return
	 */
	public int save(Trip trip);
	/**
	 * ����id��ѯ
	 * @return
	 */
	public Trip queryById(int tripId);
	/**
	 * �޸�����
	 * @param trip
	 * @return
	 */
	public int update(Trip trip);

	
	public List<Trip> queryBymenu(String str);
	/**
	 * ����menuId��ѯ
	 */
	public List<Trip> queryByTripMenu(int TripMenu);
	public List<Trip> queryAll(int id);
	public List<Trip> choose(String tripDest, String day, String menuDesc);
}
