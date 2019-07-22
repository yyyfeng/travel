package group5.travel.service.impl;

import java.util.List;

import group5.travel.dao.IAppointDAO;
import group5.travel.pojo.Appoint;
import group5.travel.service.IAppointService;
import group5.travel.servlet.AppointServlet;
import group5.travel.util.Page;

public class AppointServiceImpl implements IAppointService {
	private IAppointDAO appointDAO;
	
	public void setAppointDAO(IAppointDAO appointDAO) {
		this.appointDAO = appointDAO;
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page<Appoint> queryByPage(int page, int rows) {
		//����һ��page����
		Page p=new Page<>();
		//���÷�ҳ��ѯ�ķ���
		List<Appoint> appoints = appointDAO.queryByPage(page, rows);
		//���ò�ѯ�����ķ���
		int total = appointDAO.queryCount();
		int maxPageNum=(int) Math.ceil(total*1.0/rows);
		//�ֱ��������ý�ȥ
		//���ҳ��
		p.setMaxPageNum(maxPageNum);
		//��ǰҳ��
		p.setPage(page);
		//��ҳ��ѯ��������
		p.setRows(appoints);
		//����������
		p.setTotal(total);
		//�����ݷ���
		return p;
	}
	/**
	 * �޸�ԤԼ����״̬
	 */
	@Override
	public int updateStatus(int appointId) {
		return appointDAO.updateStatus(appointId);
	}

	@Override
	public int reUpdateStatus(int appointId) {
		// TODO Auto-generated method stub
		return appointDAO.reUpdateStatus(appointId);
	}
	/**
	 * ����ԤԼ��
	 */
	@Override
	public int save(Appoint a) {
		// TODO Auto-generated method stub
		return appointDAO.save(a);
	}

	@Override
	public List<Appoint> queryByUserId(int userId) {
		return appointDAO.queryByUserId(userId);
	}

	@Override
	public Appoint queryByAppointId(int appointId) {
		return appointDAO.queryByAppointId(appointId);
	}

}
