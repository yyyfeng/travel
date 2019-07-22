package group5.travel.service;

import java.util.List;

import group5.travel.pojo.Appoint;
import group5.travel.servlet.AppointServlet;
import group5.travel.util.Page;

/**
 * 
 * @group
 * @author Ӫ��	 
 * @description TODO
 * @version
 * @date 2018��12��18������4:12:23
 */
public interface IAppointService {
	/**
	 * ����ԤԼ��
	 */
	public int save(Appoint a);
	/**
	 * �޸�ԤԼ����״̬
	 */
	public int updateStatus(int appointId);
	/**
	 * �޸�ԤԼ����״̬
	 */
	public int reUpdateStatus(int appointId);
	/**
	 * ��ҳ��ѯ
	 */
	public Page<Appoint> queryByPage(int page,int rows);
	/**
	 * @param userId
	 * @return
	 */
	public List<Appoint> queryByUserId(int userId);
	/**
	 * @param appointId
	 * @return
	 */
	public Appoint queryByAppointId(int appointId);
}
