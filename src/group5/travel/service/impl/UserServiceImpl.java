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
	 * 查询用户列表
	 */
	@Override
	public Page<User> queryByPage(int page, int rows) {
		Page<User> p=new Page<>();
		//首先将当前页码设置给page对象
		p.setPage(page);
		//查询总条数
		int total = userDAO.queryCount();
		p.setTotal(total);
		//设置最大页码
		int maxPage = (int)Math.ceil(total/rows);
		p.setMaxPageNum(maxPage);
		//查询数据
		List<User> users = userDAO.queryByPage(page, rows);
		p.setRows(users);
		return p;
	}
	/**
	 * 删除用户的方法,并不是真的将其从数据表中删除之时将其的状态改成1，显示是已被删除
	 */
	@Override
	public int remove(int userId) {
		return userDAO.delete(userId);
	}
	/**
	 *恢复用户的权限
	 */
	@Override
	public int unRemove(int userId) {
		return userDAO.unDelete(userId);
	}
	/**
	 * 添加用户
	 */
	@Override
	public int addUser(User u) {
		return userDAO.save(u);
	}
	/**
	 * 将会显得数据修改之后的数据进行保存
	 */
	@Override
	public int saveEditUser(User u) {
		// TODO Auto-generated method stub
		return userDAO.saveEditUser(u);
	}
	/**
	 * 根据id查询用户信息的方法
	 */
	@Override
	public User queryById(int userId) {
		return userDAO.queryById(userId);
	}
	/**
	 * 用戶註冊的方法,在这里添加向用户邮箱发送秘钥的方法，此处密码用于后期完善信息时的邮箱验证
	 */
	@Override
	public int regUser(User u) {
		//对密码进行MD5加密
		u.setUserPass(Md5Util.getMD5(u.getUserPass()));
		//发送秘钥验证邮件
		MailUtil mailUtil=new MailUtil();
		StringBuffer sb=new StringBuffer();
		sb.append("亲爱的"+u.getNickName()+",");
		//生成秘钥
		String code=UUID.randomUUID().toString().replace("-","");
		//将秘钥放入user对象中
		u.setCode(code);
		//拼接要发送的字符串
		String path="http://localhost:8888/travel/user?op=checkEmailAndLogin&userEmail="+u.getUserEmail()+"&code="+code;
		sb.append("点击[<a href='"+path+"'>验证</a>]进行邮箱验证,如果点击之后没有反应请复制下面的连接到浏览器中进行验证<br/>");
		sb.append(path);
		sb.append("  尊敬的游加用户，在此提醒您，请保留接收的邮箱秘钥（code:"+code+"),以便进行邮箱验证和密码的找回，谢谢！");
		//实现邮箱发送
		try {
			mailUtil.sendMaill("游加旅行邮箱验证", sb.toString(), u.getUserEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDAO.regUser(u);
	}
	/**
	 * 添加根据邮箱查询用户的方法
	 */
	@Override
	public User queryByEmail(String userEmail) {
		return userDAO.queryByEmail(userEmail);
	}
	/**
	 * 添加通过邮箱验证时修改用户状态的方法
	 */
	@Override
	public int checkEmail(String userEmail,String code) {
		//首先调用dao中根据邮箱查询用户信息的方法
		User u = userDAO.queryByEmail(userEmail);
		if (u==null) {
			return 0;
		}
		System.out.println("u="+u);
		//然后将用户输入的验证秘钥和查询出来的结果进行对比
		if (u.getCode().equals(code)) {
			//验证成功之后将状态改为1
			int result =userDAO.checkEmail(code);
			if (result==1) {
				return 1;
			}
		}
		return 0;
	}
	/**
	 * 添加用户登录验证的方法
	 */
	@Override
	public int login(String userEmail, String userName, String userPass) {
		//首先判断是根据邮箱还是根据用户名进行的登录操作
		if (userEmail.equals("")&&userName!=null) {
			//电泳根据用户名查询的方法
			User u = userDAO.queryByUserName(userName);
			if (u.getUserPass().equals(Md5Util.getMD5(userPass))) {
				return 1;
			}else {
				return 0;
			}
			
		}else if (userEmail!=null&&userName.equals("")) {
			//调用根据用户邮箱查询用户的方法
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
	 * 通过用户名查询用户的方法,此处添加该方法并不是为了做登录验证，而是为了将查询到的该用户放入session供界面显示信息使用
	 * 
	 */
	@Override
	public User queryByUserName(String userName) {
		return userDAO.queryByUserName(userName);
	}
	/**
	 * 对用户的信息进行判断，符合条件之后进行密码的重新设置
	 */
	@Override
	public int repass(String userEmail, String code, String userPass) {
		//首先根据参数查询用户的所有信息
		User u = userDAO.queryByEmail(userEmail);
		if (u.getCode().equals(code)) {//如果判定用户秘钥输入正确，就进行修改
			int result = userDAO.updatePass(Md5Util.getMD5(userPass), userEmail);
			if (result==1) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
	/**
	 * 将用户个人信息的修改进行保存
	 */
	@Override
	public int updateSelfInfo(User u) {
		return userDAO.updateSelfInfo(u);
	}

	
}
