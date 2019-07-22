package group5.travel.service.impl;

import java.util.List;
import java.util.UUID;

import group5.travel.dao.IUserDAO;
import group5.travel.pojo.User;
import group5.travel.service.IUserService;
import group5.travel.util.MailUtil;
import group5.travel.util.Md5Util;
import group5.travel.util.Page;

public class UserServiceImpl implements IUserService {
	private IUserDAO userDAO;
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * ��ѯ�û��б�
	 */
	@Override
	public Page<User> queryByPage(int page, int rows) {
		Page<User> p=new Page<>();
		//���Ƚ���ǰҳ�����ø�page����
		p.setPage(page);
		//��ѯ������
		int total = userDAO.queryCount();
		p.setTotal(total);
		//�������ҳ��
		int maxPage = (int)Math.ceil(total/rows);
		p.setMaxPageNum(maxPage);
		//��ѯ����
		List<User> users = userDAO.queryByPage(page, rows);
		p.setRows(users);
		return p;
	}
	/**
	 * ɾ���û��ķ���,��������Ľ�������ݱ���ɾ��֮ʱ�����״̬�ĳ�1����ʾ���ѱ�ɾ��
	 */
	@Override
	public int remove(int userId) {
		return userDAO.delete(userId);
	}
	/**
	 *�ָ��û���Ȩ��
	 */
	@Override
	public int unRemove(int userId) {
		return userDAO.unDelete(userId);
	}
	/**
	 * ����û�
	 */
	@Override
	public int addUser(User u) {
		return userDAO.save(u);
	}
	/**
	 * �����Ե������޸�֮������ݽ��б���
	 */
	@Override
	public int saveEditUser(User u) {
		// TODO Auto-generated method stub
		return userDAO.saveEditUser(u);
	}
	/**
	 * ����id��ѯ�û���Ϣ�ķ���
	 */
	@Override
	public User queryById(int userId) {
		return userDAO.queryById(userId);
	}
	/**
	 * �Ñ��]�Եķ���,������������û����䷢����Կ�ķ������˴��������ں���������Ϣʱ��������֤
	 */
	@Override
	public int regUser(User u) {
		//���������MD5����
		u.setUserPass(Md5Util.getMD5(u.getUserPass()));
		//������Կ��֤�ʼ�
		MailUtil mailUtil=new MailUtil();
		StringBuffer sb=new StringBuffer();
		sb.append("�װ���"+u.getNickName()+",");
		//������Կ
		String code=UUID.randomUUID().toString().replace("-","");
		//����Կ����user������
		u.setCode(code);
		//ƴ��Ҫ���͵��ַ���
		String path="http://localhost:8888/travel/user?op=checkEmailAndLogin&userEmail="+u.getUserEmail()+"&code="+code;
		sb.append("���[<a href='"+path+"'>��֤</a>]����������֤,������֮��û�з�Ӧ�븴����������ӵ�������н�����֤<br/>");
		sb.append(path);
		sb.append("  �𾴵��μ��û����ڴ����������뱣�����յ�������Կ��code:"+code+"),�Ա����������֤��������һأ�лл��");
		//ʵ�����䷢��
		try {
			mailUtil.sendMaill("�μ�����������֤", sb.toString(), u.getUserEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDAO.regUser(u);
	}
	/**
	 * ��Ӹ��������ѯ�û��ķ���
	 */
	@Override
	public User queryByEmail(String userEmail) {
		return userDAO.queryByEmail(userEmail);
	}
	/**
	 * ���ͨ��������֤ʱ�޸��û�״̬�ķ���
	 */
	@Override
	public int checkEmail(String userEmail,String code) {
		//���ȵ���dao�и��������ѯ�û���Ϣ�ķ���
		User u = userDAO.queryByEmail(userEmail);
		if (u==null) {
			return 0;
		}
		System.out.println("u="+u);
		//Ȼ���û��������֤��Կ�Ͳ�ѯ�����Ľ�����жԱ�
		if (u.getCode().equals(code)) {
			//��֤�ɹ�֮��״̬��Ϊ1
			int result =userDAO.checkEmail(code);
			if (result==1) {
				return 1;
			}
		}
		return 0;
	}
	/**
	 * ����û���¼��֤�ķ���
	 */
	@Override
	public int login(String userEmail, String userName, String userPass) {
		//�����ж��Ǹ������仹�Ǹ����û������еĵ�¼����
		if (userEmail.equals("")&&userName!=null) {
			//��Ӿ�����û�����ѯ�ķ���
			User u = userDAO.queryByUserName(userName);
			if (u.getUserPass().equals(Md5Util.getMD5(userPass))) {
				return 1;
			}else {
				return 0;
			}
			
		}else if (userEmail!=null&&userName.equals("")) {
			//���ø����û������ѯ�û��ķ���
			User u = userDAO.queryByEmail(userEmail);
			if (u.getUserPass().equals(Md5Util.getMD5(userPass))) {
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	/**
	 * ͨ���û�����ѯ�û��ķ���,�˴���Ӹ÷���������Ϊ������¼��֤������Ϊ�˽���ѯ���ĸ��û�����session��������ʾ��Ϣʹ��
	 * 
	 */
	@Override
	public User queryByUserName(String userName) {
		return userDAO.queryByUserName(userName);
	}
	/**
	 * ���û�����Ϣ�����жϣ���������֮������������������
	 */
	@Override
	public int repass(String userEmail, String code, String userPass) {
		//���ȸ��ݲ�����ѯ�û���������Ϣ
		User u = userDAO.queryByEmail(userEmail);
		if (u.getCode().equals(code)) {//����ж��û���Կ������ȷ���ͽ����޸�
			int result = userDAO.updatePass(Md5Util.getMD5(userPass), userEmail);
			if (result==1) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
	/**
	 * ���û�������Ϣ���޸Ľ��б���
	 */
	@Override
	public int updateSelfInfo(User u) {
		return userDAO.updateSelfInfo(u);
	}

	
}
