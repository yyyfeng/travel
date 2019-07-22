package group5.travel.service;

import group5.travel.pojo.User;
import group5.travel.util.Page;

/**
 * 
 * @group
 * @author Ӫ��	 
 * @description TODO
 * @version
 * @date 2018��12��11������7:20:42
 */
public interface IUserService {
	/**
	 * ���û�������Ϣ���޸Ľ��б���
	 */
	public int updateSelfInfo(User u);
	/**
	 * ���û�����Ϣ�����жϣ���������֮������������������
	 */
	public int repass(String userEmail,String code,String userPass);
	/**
	 * ͨ���û�����ѯ�û��ķ���,�˴���Ӹ÷���������Ϊ������¼��֤������Ϊ�˽���ѯ���ĸ��û�����session��������ʾ��Ϣʹ��
	 * 
	 */
	public User queryByUserName(String  userName);
	/**
	 * ����û���¼��֤�ķ���
	 */
	public int login(String userEmail,String userName, String userPass);
	/**
	 * ���ͨ��������֤ʱ�޸��û�״̬�ķ���
	 */
	public int checkEmail(String userEmail,String code);
	
	/**
	 * ��Ӹ��������ѯ�û��ķ���
	 */
	public User queryByEmail(String userEmail);
	/**
	 * �Ñ��]�Եķ���
	 */
	public int regUser(User u);
	/**
	 * ����id��ѯ�û���Ϣ�ķ���
	 */
	public User queryById(int userId);
	/**
	 * �����Ե������޸�֮������ݽ��б���
	 */
	public int saveEditUser(User u);
	/**
	 * ����û��ķ���
	 */
	public int addUser(User u);
	/**
	 *	    ��ҳ��ѯ�û��б�
	 */
	public Page<User> queryByPage(int page,int rows);
	/**
	 * ɾ���û��ķ���,��������Ľ�������ݱ���ɾ��֮ʱ�����״̬�ĳ�1����ʾ���ѱ�ɾ��
	 */
	public int remove(int userId);
	/**
	 *�ָ��û���Ȩ��
	 */
	public int unRemove(int userId);
}
