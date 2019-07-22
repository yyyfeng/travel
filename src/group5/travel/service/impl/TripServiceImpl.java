package group5.travel.service.impl;

import java.util.List;

import group5.travel.dao.ITripDAO;
import group5.travel.pojo.Trip;
import group5.travel.service.ITripService;
import group5.travel.util.Page;
/**
 * 
 * @group 
 * @author �κ���
 * @Description TODO
 * @date 2018��12��12��
 */
public class TripServiceImpl implements ITripService {
	private ITripDAO tripDAO;
	public void setTripDAO(ITripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}


	/**
	 * ��ҳ��ѯ�г���Ʒ�б�
	 */
	@Override
	public Page<Trip> queryByPage(int page, int rows) {
		Page<Trip> p=new Page<>();
		//��page�������õ�ǰҳ��
		p.setPage(page);
		//����������
		int  total = tripDAO.queryCount();
		p.setTotal(total);
		//���÷�ҳ��ѯ������
		List<Trip> trips = tripDAO.queryByPage(page, rows);
		p.setRows(trips);
		//�������ҳ��
		int maxPage = (int)Math.ceil(total/rows);
		p.setMaxPageNum(maxPage);
		return p;
	}

	/**
	 * ����idɾ������
	 */
	@Override
	public int remove(int tripId) {
		return tripDAO.remove(tripId);
	}

	/**
	 * ����һ������
	 */
	@Override
	public int save(Trip trip) {
		return tripDAO.save(trip);
	}

	/**
	 * ����id��ѯ
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
	 * ��Ӳ�ѯ������������ķ���
	 */
	@Override
	public List<Trip> queryAll() {
		// TODO Auto-generated method stub
		return tripDAO.queryAll();
	}
}
