package group5.travel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Menu;
import group5.travel.pojo.User;
import group5.travel.service.IUserService;
import group5.travel.util.FileUtil;
import group5.travel.util.JSONUtils;
import group5.travel.util.Page;

/**
 * 
 * @group
 * @author 营峰
 * @description TODO关于用户的servlet
 * @version
 * @date 2018年12月11日下午7:31:01
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = (IUserService) BeansFactory.getBean("userService");
	/**
	 * 添加user退出的方法
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//将session清空
		 request.getSession().removeAttribute("u");
		 response.sendRedirect("front/login.jsp");
	}
	/**
	 * 	修改个人信息的方法
	 */
	public void updateSelfInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//首先获取表单提交的数据
		String nickName = request.getParameter("nickName");
		String userName=request.getParameter("userName");
		String userTel=request.getParameter("userTel");
		 int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userBirth=request.getParameter("userBirth");
		String userEmail=request.getParameter("userEmail");
		String userImg = request.getParameter("userImg");
		System.out.println(userImg);
		System.out.println("userImg"+userImg);
		User u=new User();
		//对图片进行处理
		FileUtil fu=new FileUtil();
		if(userImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && userImg.length()>0) {
			String path = this.getServletContext().getRealPath("/"+userImg);
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			String url = fu.getDownLoadUrl(key);
			System.out.println(url);
			u.setUserImg(url);
		}else {
			u.setUserImg(userImg);
		}
		User u1 = userService.queryByEmail(userEmail);
		
		u.setUserId(u1.getUserId());
		u.setNickName(nickName);
		u.setUserName(userName);
		u.setUserAge(userAge);
		u.setUserTel(userTel);
		u.setUserBirth(userBirth);
		u.setUserEmail(userEmail);
		System.out.println("u修改"+u);
			//调用service方法进行修改
		int result = userService.updateSelfInfo(u);
		if (result==1) {
			request.setCharacterEncoding("utf-8");
			System.out.println("修改前");
			request.setAttribute("updateSucMsg","修改成功！重新登录信息方可生效！");
			System.out.println("修改后"+request.getAttribute("updateSucMsg"));
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
			return ;
		}else {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("updateErrorMsg","修改失败，请重新修改！");
			request.getRequestDispatcher("front/pcenter.jsp").forward(request, response);
			return ;
		}
	}
	/**
	 * 找回密码的方法
	 */
	public void repass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户输入的参数
		String userEmail = request.getParameter("userEmail");
		String code=request.getParameter("code");
		String userPass=request.getParameter("userPass");
		//调用service方法
		int result = userService.repass(userEmail, code, userPass);
		if (result==1) {//修改成功进入登录界面
			response.sendRedirect("front/login.jsp");
			return ;
		}else {//修改失败再次进入找回密码界面
			response.sendRedirect("front/repass.html");
			return ;
		}
	}
	/**
	 * 添加邮箱验证的方法，操作是让用户输入邮箱和验证秘钥，如果两项都相同，则判定为验证通过，且当判定成功是，
	 * 将用户的状态值改为1，即可以正常使用状态，否则是禁用状态
	 * 
	 */
	public void checkEmailAndLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 首先获取用户的输入参数
		// 创建一个user对象
		User u = null;
		String userEmail="";
		String userName="";
		HttpSession session = request.getSession();
		String loadMsg = request.getParameter("loadMsg");
		String uri = request.getParameter("uri");
		if (loadMsg.contains("@")&&loadMsg.contains(".")) {
			 userEmail =loadMsg;
		}else {
			userName=loadMsg;
		}
		String code = request.getParameter("code");
		if (!code.equals("")) {
			userEmail = request.getParameter("userEmail");
		}
		String userPass = request.getParameter("userPass");
		System.out.println("登录与验证：userName="+userName+"--userPass="+userPass+"--userEmail="+userEmail+"--code="+code);
		// 首先进行判断，该用户将进行的操作
		if (code.equals("") && userPass != null) {
			// 则说明用户将进行登录而不是验证
			// 然后根据用户的邮箱或用户名查询
			if (userEmail != null && userName.equals("")) {
				// 调用根据用户邮箱查询用户的方法，判断其状态
				u = userService.queryByEmail(userEmail);
				session.setAttribute("u", u);
				System.out.println("获取的用户的状态status"+u.getUserStatus());
				if (u.getUserStatus() == 0) {
					request.setCharacterEncoding("utf-8");
					request.setAttribute("errorMsg", "请您先完成邮箱验证！");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				} else if (u.getUserStatus() == 1) {// 调用用户登录的方法
					int result = userService.login(userEmail, userName, userPass);
					if (result == 1) {
						// 登陆成功则进入详情界面
						if (uri == null || "".equals(uri)) {
							response.sendRedirect("front/myoujia.jsp");
							return;
						}else {
							response.sendRedirect(uri);
						}
					}
				}

			} else if (userEmail.equals("") && userName != null) {
				// 调用根据用户邮箱查询用户的方法，判断其状态
				u = userService.queryByUserName(userName);
				
				if(u==null) {
					request.setCharacterEncoding("utf-8");
					request.setAttribute("errorMsg", "账号或密码错误！");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					System.out.println("执行了页面的跳转！");
				}else {
					System.out.println("u="+u);
					session.setAttribute("u", u);
					if (u.getUserStatus() == 0) {
						System.out.println("执行了状态的判断！");
						request.setCharacterEncoding("utf-8");
						request.setAttribute("errorMsg", "请您先完成邮箱验证！");
						request.getRequestDispatcher("front/login.jsp").forward(request, response);
						System.out.println("执行了页面的跳转！");
						return;
					} else if (u.getUserStatus() == 1) {// 调用用户登录的方法
						System.out.println("进入登录验证！");
						int result = userService.login(userEmail, userName, userPass);
						if (result == 1) {
							// 登陆成功则进入详情界面
							if (uri == null || "".equals(uri)) {
								response.sendRedirect("front/myoujia.jsp");
								return;
							}else {
								response.sendRedirect(uri);
							}
						}else {
							response.sendRedirect("front/login.jsp");
							return ;
						}
					}

				}
			} else if (code != null && userPass.equals("")) {// 则用户进行的是验证操作
				System.out.println("执行邮箱验证！");
				// 然后调用service中的方法进行邮箱验证
				System.out.println("邮箱验证的参数userEmail"+userEmail);
				int result = userService.checkEmail(userEmail, code);
				System.out.println("邮箱验证result="+result);
				if (result == 1) {// 说明验证成功，且状态为可用
					//直接跳转进入登陆界面
					request.setAttribute("sucMsg","邮箱验证成功，请进行登录！");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				} else {
					// 否则让他再次进入验证界面
					request.setAttribute("sucMsg","邮箱验证失败！请重新进行验证");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				}
			}
				}
				

	}

	/**
	 * 用户注册的方法
	 */
	public void regUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行了reg方法！");
		FileUtil fu=new FileUtil();
		// 获取表单提交的参数
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		String userTel = request.getParameter("userTel");
		String userPass = request.getParameter("userPass");
		String userEmail = request.getParameter("userEmail");
		String userImg=request.getParameter("userImg");
		// 创建user对象进行数据的封装
				User u = new User();
		//对图片进行处理
				if(userImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && userImg.length()>0) {
					String path = this.getServletContext().getRealPath("/"+userImg);
					String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
					String url = fu.getDownLoadUrl(key);
					u.setUserImg(url);
					System.out.println(url);
				}else {
					u.setUserImg(userImg);
				}
					
		System.out.println("界面获取到的userImg"+userImg);
		if (userService.queryByEmail(userEmail)!=null||userService.queryByUserName(userName)!=null) {
			response.setCharacterEncoding("utf-8");
			request.setAttribute("regError", "该用户名或邮箱已经存在，请重新注册！");
			request.getRequestDispatcher("front/register.jsp").forward(request, response);
			return ;
		}
		
		u.setNickName(nickName);
		u.setUserName(userName);
		u.setUserTel(userTel);
		u.setUserPass(userPass);
		u.setUserEmail(userEmail);
		System.out.println("reg--u" + u);
		// 调用service方法保存注册对象，将对象u作为参数传入
		int result = userService.regUser(u);
		if (result == 1) {
			response.setCharacterEncoding("utf-8");
			request.setAttribute("regSucMsg","注册成功，请先进行邮箱验证！");
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
			return;
		} else {
			response.sendRedirect("front/index.jsp");
			return;
		}
	}

	/**
	 * 接收回显的数据进行修改之后的数据，然后将最新的数据进行修改保存
	 */
	public void saveEditUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		int userId = Integer.parseInt(request.getParameter("userId"));
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userPass = request.getParameter("userPass");
		String userBirth = request.getParameter("userBirth");
		String userEmail = request.getParameter("userEmail");
		String userTel = request.getParameter("userTel");
		// 创建user对象
		User u = new User();
		u.setUserId(userId);
		u.setNickName(nickName);
		u.setUserAge(userAge);
		u.setUserBirth(userBirth);
		u.setUserEmail(userEmail);
		u.setUserName(userName);
		u.setUserPass(userPass);
		u.setUserTel(userTel);
		System.out.println("u:" + u);
		// 调用service方法保存user对象
		int result = userService.saveEditUser(u);
		if (result == 1) {
			String saveMsg = "修改成功！";
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONUtils.ObejcToJson(saveMsg));
//			request.setAttribute("saveMsg","success");
//			request.getRequestDispatcher("editUser.jsp").forward(request, response);
			return;
		} else if (result == 0) {
			String saveMsg = "修改失败！";
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONUtils.ObejcToJson(saveMsg));
			return;
		}
	}

	/**
	 * 实现数据回显
	 */
	public void reviewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 首先获取要进行修改的用户的id

		int userId = Integer.parseInt(request.getParameter("userId"));
		// 调用根据id查询用户的方法
		User u = userService.queryById(userId);
		// 将u传入json
		String json = JSONUtils.ObejcToJson(u);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * 实现后台添加用户
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userPass = request.getParameter("userPass");
		String userBirth = request.getParameter("userBirth");
		String userEmail = request.getParameter("userEmail");
		String userTel = request.getParameter("userTel");
		// 创建user对象
		User u = new User();
		u.setNickName(nickName);
		u.setUserAge(userAge);
		u.setUserBirth(userBirth);
		u.setUserEmail(userEmail);
		u.setUserName(userName);
		u.setUserPass(userPass);
		u.setUserTel(userTel);
		// 调用service方法保存user对象
		int result = userService.addUser(u);
		if (result == 1) {
			// 判断是否添加成功
//			request.setAttribute("addSuccess","添加成功！");
			String addSuccess = "添加成功!";
			String json = JSONUtils.ObejcToJson(addSuccess);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			return;
		} else {
			// 判断是否添加成功
//			request.setAttribute("addError","添加失败！");
			String addError = "添加失败！";
			String json = JSONUtils.ObejcToJson(addError);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//跳转到列表界面
//			request.getRequestDispatcher("addUser.jsp").forward(request, response);

		}
	}

	/**
	 * 恢复用户权限的方法
	 * 
	 */
	public void unRemove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要恢复的参数
		int userId = Integer.parseInt(request.getParameter("userId"));
		// 调用修改状态的方法
		int result = userService.unRemove(userId);
		// 将结果放入json中
		String json = JSONUtils.ObejcToJson(result);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * 删除用户的方法,并不是真的将其从数据表中删除之时将其的状态改成1，显示是已被删除
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的参数
		int userId = Integer.parseInt(request.getParameter("userId"));
		// 调用修改状态的方法
		int result = userService.remove(userId);
		// 将结果放入json中
		String json = JSONUtils.ObejcToJson(result);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * 查询用户列表的方法
	 */
	public void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("执行了userList方法！");
		// 获取参数
		// 获取当前页码
		// 设置页码默认为1
		int page = 1;
		int rows = 10;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 调用分页查询的方法
		Page<User> p = userService.queryByPage(page, rows);
		// 将page对象放入json中
		String json = JSONUtils.ObejcToJson(p);
		// System.out.println("p:"+p);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);

	}

}
