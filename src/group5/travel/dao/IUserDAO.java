package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.User;

/**
 * 
 * @group
 * @author 营峰	 
 * @description TODO对用户表进行的操作
 * @version
 * @date 2018年12月11日下午7:12:22
 */
public interface IUserDAO {
	/**
	 * 将用户个人信息的修改进行保存
	 */
	public int updateSelfInfo(User u);
	/**
	 * 添加用户找回密码的方法，即当符合验证条件时，将密码设置为新的密码
	 */
	public int updatePass(String userPass,String userEmail);
	/**
	 * 根据用户名查询用户的方法
	 */
	public User queryByUserName(String userName);
	/**
	 * 添加邮箱验证的方法
	 */
	public int  checkEmail(String code);
	/**
	 * 添加根据邮箱查询用户的方法
	 */
	public User queryByEmail(String userEmail);
	/**
	 * 用戶註冊的方法
	 */
	public int regUser(User u);
	/**
	 * 将会显得数据修改之后的数据进行保存
	 */
	public int saveEditUser(User u);
	/**
	 * 根据id查询用户的所有信息
	 */
	public User queryById(int userId);
	/**
	 * 添加用户的方法
	 */
	public int save(User u);
	/**
	 * 	分页查询所有用户的方法
	 */
	public List<User> queryByPage(int page,int rows);
	/**
	 * 查询用户总数的方法
	 */
	public int queryCount();
	/**
	 * 删除用户的方法
	 */
	public int delete(int userId);
	/**
	 * 恢复用户权限的方法
	 */
	public int unDelete(int userId);
	
}
