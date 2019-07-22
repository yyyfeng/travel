package group5.travel.service;

import group5.travel.pojo.User;
import group5.travel.util.Page;

/**
 * 
 * @group
 * @author 营峰	 
 * @description TODO
 * @version
 * @date 2018年12月11日下午7:20:42
 */
public interface IUserService {
	/**
	 * 将用户个人信息的修改进行保存
	 */
	public int updateSelfInfo(User u);
	/**
	 * 对用户的信息进行判断，符合条件之后进行密码的重新设置
	 */
	public int repass(String userEmail,String code,String userPass);
	/**
	 * 通过用户名查询用户的方法,此处添加该方法并不是为了做登录验证，而是为了将查询到的该用户放入session供界面显示信息使用
	 * 
	 */
	public User queryByUserName(String  userName);
	/**
	 * 添加用户登录验证的方法
	 */
	public int login(String userEmail,String userName, String userPass);
	/**
	 * 添加通过邮箱验证时修改用户状态的方法
	 */
	public int checkEmail(String userEmail,String code);
	
	/**
	 * 添加根据邮箱查询用户的方法
	 */
	public User queryByEmail(String userEmail);
	/**
	 * 用戶註冊的方法
	 */
	public int regUser(User u);
	/**
	 * 根据id查询用户信息的方法
	 */
	public User queryById(int userId);
	/**
	 * 将会显得数据修改之后的数据进行保存
	 */
	public int saveEditUser(User u);
	/**
	 * 添加用户的方法
	 */
	public int addUser(User u);
	/**
	 *	    分页查询用户列表
	 */
	public Page<User> queryByPage(int page,int rows);
	/**
	 * 删除用户的方法,并不是真的将其从数据表中删除之时将其的状态改成1，显示是已被删除
	 */
	public int remove(int userId);
	/**
	 *恢复用户的权限
	 */
	public int unRemove(int userId);
}
