package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.Appoint;
import group5.travel.servlet.AppointServlet;
/**
 * 
 * @group
 * @author Ӫ��	 
 * @description TODO
 * @version
 * @date 2018��12��18������6:27:32
 */
public interface IAppointDAO {
	/**
	 * ��ӱ���ԤԼ���ķ���
	 */
	public int save(Appoint a);
	/**
	 * ��ԤԼ����״̬��Ϊ1����ʾ�Ѿ��������
	 */
	public int updateStatus(int appointId);
	/**
	 * ��ԤԼ����״̬��Ϊ0����ʾ�Ѿ��������
	 */
	public int reUpdateStatus(int appointId);
	/**
	 *	��ӷ�ҳ��ѯ�ķ���
	 */
	 public List<Appoint> queryByPage(int page,int rows);
	 /**
	  * ��Ӳ�ѯ����ԤԼ�������ķ���
	  */
	 public int queryCount();
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
