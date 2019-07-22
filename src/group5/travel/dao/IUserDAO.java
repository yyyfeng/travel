package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.User;

/**
 * 
 * @group
 * @author Ӫ��	 
 * @description TODO���û�����еĲ���
 * @version
 * @date 2018��12��11������7:12:22
 */
public interface IUserDAO {
	/**
	 * ���û�������Ϣ���޸Ľ��б���
	 */
	public int updateSelfInfo(User u);
	/**
	 * ����û��һ�����ķ���������������֤����ʱ������������Ϊ�µ�����
	 */
	public int updatePass(String userPass,String userEmail);
	/**
	 * �����û�����ѯ�û��ķ���
	 */
	public User queryByUserName(String userName);
	/**
	 * ���������֤�ķ���
	 */
	public int  checkEmail(String code);
	/**
	 * ��Ӹ��������ѯ�û��ķ���
	 */
	public User queryByEmail(String userEmail);
	/**
	 * �Ñ��]�Եķ���
	 */
	public int regUser(User u);
	/**
	 * �����Ե������޸�֮������ݽ��б���
	 */
	public int saveEditUser(User u);
	/**
	 * ����id��ѯ�û���������Ϣ
	 */
	public User queryById(int userId);
	/**
	 * ����û��ķ���
	 */
	public int save(User u);
	/**
	 * 	��ҳ��ѯ�����û��ķ���
	 */
	public List<User> queryByPage(int page,int rows);
	/**
	 * ��ѯ�û������ķ���
	 */
	public int queryCount();
	/**
	 * ɾ���û��ķ���
	 */
	public int delete(int userId);
	/**
	 * �ָ��û�Ȩ�޵ķ���
	 */
	public int unDelete(int userId);
	
}
