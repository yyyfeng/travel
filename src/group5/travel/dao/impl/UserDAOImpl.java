package group5.travel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import group5.travel.dao.IUserDAO;
import group5.travel.pojo.User;
import group5.travel.util.JDBCUtils;

public class UserDAOImpl implements IUserDAO {
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
	/**
	 * ��ѯ�����û��ķ���
	 */
	@Override
	public List<User> queryByPage(int page,int rows){
		String sql="select * from g_user limit ?,?;";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class),(page-1)*rows,rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��ѯ�û��ܸ����ķ���
	 */
	@Override
	public int queryCount() {
		String sql="select count(*) from g_user;";
		
		try {
			return new Integer(qr.query(sql, new ScalarHandler()).toString()) ;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ɾ���û��ķ���,��������Ľ�������ݱ���ɾ��֮ʱ�����״̬�ĳ�1����ʾ���ѱ�ɾ��
	 */
	@Override
	public int delete(int userId) {
		String sql="update g_user set userStatus=0 where userId=?"; 
		try {
			return qr.update(sql,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * �ָ��û���Ȩ��
	 */
	@Override
	public int unDelete(int userId) {
		String sql="update g_user set userStatus=1 where userId=?"; 
		try {
			return qr.update(sql,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ����û��ķ���
	 */
	@Override
	public int save(User u) {
		String sql="insert into g_user(nickname,username,userTel,"
				+ "userPass,userAge,userBirth,userEmail) values(?,?,?,?,?,?,?);";
		try {
			return qr.update(sql,u.getNickName(),u.getUserName(),u.getUserTel(),u.getUserPass()
					,u.getUserAge(),u.getUserBirth(),u.getUserEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ����id��ѯ�û���Ϣ�ķ���
	 */
	@Override
	public User queryById(int userId) {
		String sql="select * from g_user where userId=?;";
		try {
			return qr.query(sql, new BeanHandler<>(User.class),userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �����Ե������޸�֮������ݽ��б���
	 * userId,nickname,username,userTel,userPass,userAge,userBirth,userEmail)
	 */
	@Override
	public int saveEditUser(User u) {
		String sql="update  g_user set nickName=?,username=?,"
				+ " userTel=?,userPass=?, userAge=?,"
				+ " userBirth=?,userEmail=? where userId=?;";
		try {
			return qr.update(sql,u.getNickName(),u.getUserName(),u.getUserTel(),
					u.getUserPass(),u.getUserAge(),u.getUserBirth(),u.getUserEmail(),u.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * �Ñ��]�Եķ���
	 */
	@Override
	public int regUser(User u) {
		String  sql="insert into g_user(nickname,username,userTel,userPass,userAge,userBirth,userEmail,code,userImg) values(?,?,?,?,'0',now(),?,?,?);";
		try {
			return qr.update(sql,u.getNickName(),u.getUserName(),u.getUserTel(),u.getUserPass(),u.getUserEmail(),u.getCode(),u.getUserImg());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ��Ӹ��������ѯ�û��ķ���
	 */
	@Override
	public User queryByEmail(String userEmail) {
		String sql="select * from g_user where userEmail=?";
		try {
			return qr.query(sql, new BeanHandler<>(User.class),userEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����������Կ�ҵ���Ӧ���û���״̬�������֤��ȷ���û���״̬��Ϊ��������ʹ�ã����ƥ�䲻�ɹ��򷵻�0
	 */
	@Override
	public int checkEmail(String code) {
		String sql="update g_user set userStatus=1 where code=?";
		try {
			return qr.update(sql,code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * �����û�����ѯ�û��ķ���
	 */
	@Override
	public User queryByUserName(String userName) {
		String sql="select * from g_user where userName=?";
		try {
			return qr.query(sql, new BeanHandler<>(User.class),userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����û��һ�����ķ���������������֤����ʱ������������Ϊ�µ�����
	 */
	@Override
	public int updatePass(String userPass,String userEmail) {
		String  sql="update g_user set userPass=? where userEmail=?";
		try {
			return qr.update(sql,userPass,userEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ���û�������Ϣ���޸Ľ��б���
	 */
	@Override
	public int updateSelfInfo(User u) {
		String sql="update g_user set nickName=?, userName=?, "
				+ "userTel=?,userAge=?,userBirth=?, userEmail=?,userImg=? where userId=? ";
		try {
			return qr.update(sql,u.getNickName(),u.getUserName(),u.getUserTel(),u.getUserAge(),u.getUserBirth(),u.getUserEmail(),u.getUserImg(),u.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
