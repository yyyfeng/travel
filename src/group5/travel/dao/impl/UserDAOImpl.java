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
	 * 查询所有用户的方法
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
	 * 查询用户总个数的方法
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
	 * 删除用户的方法,并不是真的将其从数据表中删除之时将其的状态改成1，显示是已被删除
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
	 * 恢复用户的权限
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
	 * 添加用户的方法
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
	 * 根据id查询用户信息的方法
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
	 * 将会显得数据修改之后的数据进行保存
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
	 * 用戶註冊的方法
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
	 * 添加根据邮箱查询用户的方法
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
	 * 根据邮箱秘钥找到对应的用户的状态，如果验证正确将用户的状态改为可以正常使用，如果匹配不成功则返回0
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
	 * 根据用户名查询用户的方法
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
	 * 添加用户找回密码的方法，即当符合验证条件时，将密码设置为新的密码
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
	 * 将用户个人信息的修改进行保存
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
