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
 * @author Ӫ��
 * @description TODO�����û���servlet
 * @version
 * @date 2018��12��11������7:31:01
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = (IUserService) BeansFactory.getBean("userService");
	/**
	 * ���user�˳��ķ���
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//��session���
		 request.getSession().removeAttribute("u");
		 response.sendRedirect("front/login.jsp");
	}
	/**
	 * 	�޸ĸ�����Ϣ�ķ���
	 */
	public void updateSelfInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���Ȼ�ȡ���ύ������
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
		//��ͼƬ���д���
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
		System.out.println("u�޸�"+u);
			//����service���������޸�
		int result = userService.updateSelfInfo(u);
		if (result==1) {
			request.setCharacterEncoding("utf-8");
			System.out.println("�޸�ǰ");
			request.setAttribute("updateSucMsg","�޸ĳɹ������µ�¼��Ϣ������Ч��");
			System.out.println("�޸ĺ�"+request.getAttribute("updateSucMsg"));
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
			return ;
		}else {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("updateErrorMsg","�޸�ʧ�ܣ��������޸ģ�");
			request.getRequestDispatcher("front/pcenter.jsp").forward(request, response);
			return ;
		}
	}
	/**
	 * �һ�����ķ���
	 */
	public void repass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�û�����Ĳ���
		String userEmail = request.getParameter("userEmail");
		String code=request.getParameter("code");
		String userPass=request.getParameter("userPass");
		//����service����
		int result = userService.repass(userEmail, code, userPass);
		if (result==1) {//�޸ĳɹ������¼����
			response.sendRedirect("front/login.jsp");
			return ;
		}else {//�޸�ʧ���ٴν����һ��������
			response.sendRedirect("front/repass.html");
			return ;
		}
	}
	/**
	 * ���������֤�ķ��������������û������������֤��Կ����������ͬ�����ж�Ϊ��֤ͨ�����ҵ��ж��ɹ��ǣ�
	 * ���û���״ֵ̬��Ϊ1������������ʹ��״̬�������ǽ���״̬
	 * 
	 */
	public void checkEmailAndLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���Ȼ�ȡ�û����������
		// ����һ��user����
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
		System.out.println("��¼����֤��userName="+userName+"--userPass="+userPass+"--userEmail="+userEmail+"--code="+code);
		// ���Ƚ����жϣ����û������еĲ���
		if (code.equals("") && userPass != null) {
			// ��˵���û������е�¼��������֤
			// Ȼ������û���������û�����ѯ
			if (userEmail != null && userName.equals("")) {
				// ���ø����û������ѯ�û��ķ������ж���״̬
				u = userService.queryByEmail(userEmail);
				session.setAttribute("u", u);
				System.out.println("��ȡ���û���״̬status"+u.getUserStatus());
				if (u.getUserStatus() == 0) {
					request.setCharacterEncoding("utf-8");
					request.setAttribute("errorMsg", "���������������֤��");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				} else if (u.getUserStatus() == 1) {// �����û���¼�ķ���
					int result = userService.login(userEmail, userName, userPass);
					if (result == 1) {
						// ��½�ɹ�������������
						if (uri == null || "".equals(uri)) {
							response.sendRedirect("front/myoujia.jsp");
							return;
						}else {
							response.sendRedirect(uri);
						}
					}
				}

			} else if (userEmail.equals("") && userName != null) {
				// ���ø����û������ѯ�û��ķ������ж���״̬
				u = userService.queryByUserName(userName);
				
				if(u==null) {
					request.setCharacterEncoding("utf-8");
					request.setAttribute("errorMsg", "�˺Ż��������");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					System.out.println("ִ����ҳ�����ת��");
				}else {
					System.out.println("u="+u);
					session.setAttribute("u", u);
					if (u.getUserStatus() == 0) {
						System.out.println("ִ����״̬���жϣ�");
						request.setCharacterEncoding("utf-8");
						request.setAttribute("errorMsg", "���������������֤��");
						request.getRequestDispatcher("front/login.jsp").forward(request, response);
						System.out.println("ִ����ҳ�����ת��");
						return;
					} else if (u.getUserStatus() == 1) {// �����û���¼�ķ���
						System.out.println("�����¼��֤��");
						int result = userService.login(userEmail, userName, userPass);
						if (result == 1) {
							// ��½�ɹ�������������
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
			} else if (code != null && userPass.equals("")) {// ���û����е�����֤����
				System.out.println("ִ��������֤��");
				// Ȼ�����service�еķ�������������֤
				System.out.println("������֤�Ĳ���userEmail"+userEmail);
				int result = userService.checkEmail(userEmail, code);
				System.out.println("������֤result="+result);
				if (result == 1) {// ˵����֤�ɹ�����״̬Ϊ����
					//ֱ����ת�����½����
					request.setAttribute("sucMsg","������֤�ɹ�������е�¼��");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				} else {
					// ���������ٴν�����֤����
					request.setAttribute("sucMsg","������֤ʧ�ܣ������½�����֤");
					request.getRequestDispatcher("front/login.jsp").forward(request, response);
					return;
				}
			}
				}
				

	}

	/**
	 * �û�ע��ķ���
	 */
	public void regUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ����reg������");
		FileUtil fu=new FileUtil();
		// ��ȡ���ύ�Ĳ���
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		String userTel = request.getParameter("userTel");
		String userPass = request.getParameter("userPass");
		String userEmail = request.getParameter("userEmail");
		String userImg=request.getParameter("userImg");
		// ����user����������ݵķ�װ
				User u = new User();
		//��ͼƬ���д���
				if(userImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && userImg.length()>0) {
					String path = this.getServletContext().getRealPath("/"+userImg);
					String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
					String url = fu.getDownLoadUrl(key);
					u.setUserImg(url);
					System.out.println(url);
				}else {
					u.setUserImg(userImg);
				}
					
		System.out.println("�����ȡ����userImg"+userImg);
		if (userService.queryByEmail(userEmail)!=null||userService.queryByUserName(userName)!=null) {
			response.setCharacterEncoding("utf-8");
			request.setAttribute("regError", "���û����������Ѿ����ڣ�������ע�ᣡ");
			request.getRequestDispatcher("front/register.jsp").forward(request, response);
			return ;
		}
		
		u.setNickName(nickName);
		u.setUserName(userName);
		u.setUserTel(userTel);
		u.setUserPass(userPass);
		u.setUserEmail(userEmail);
		System.out.println("reg--u" + u);
		// ����service��������ע����󣬽�����u��Ϊ��������
		int result = userService.regUser(u);
		if (result == 1) {
			response.setCharacterEncoding("utf-8");
			request.setAttribute("regSucMsg","ע��ɹ������Ƚ���������֤��");
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
			return;
		} else {
			response.sendRedirect("front/index.jsp");
			return;
		}
	}

	/**
	 * ���ջ��Ե����ݽ����޸�֮������ݣ�Ȼ�����µ����ݽ����޸ı���
	 */
	public void saveEditUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		int userId = Integer.parseInt(request.getParameter("userId"));
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userPass = request.getParameter("userPass");
		String userBirth = request.getParameter("userBirth");
		String userEmail = request.getParameter("userEmail");
		String userTel = request.getParameter("userTel");
		// ����user����
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
		// ����service��������user����
		int result = userService.saveEditUser(u);
		if (result == 1) {
			String saveMsg = "�޸ĳɹ���";
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONUtils.ObejcToJson(saveMsg));
//			request.setAttribute("saveMsg","success");
//			request.getRequestDispatcher("editUser.jsp").forward(request, response);
			return;
		} else if (result == 0) {
			String saveMsg = "�޸�ʧ�ܣ�";
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONUtils.ObejcToJson(saveMsg));
			return;
		}
	}

	/**
	 * ʵ�����ݻ���
	 */
	public void reviewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���Ȼ�ȡҪ�����޸ĵ��û���id

		int userId = Integer.parseInt(request.getParameter("userId"));
		// ���ø���id��ѯ�û��ķ���
		User u = userService.queryById(userId);
		// ��u����json
		String json = JSONUtils.ObejcToJson(u);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * ʵ�ֺ�̨����û�
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userPass = request.getParameter("userPass");
		String userBirth = request.getParameter("userBirth");
		String userEmail = request.getParameter("userEmail");
		String userTel = request.getParameter("userTel");
		// ����user����
		User u = new User();
		u.setNickName(nickName);
		u.setUserAge(userAge);
		u.setUserBirth(userBirth);
		u.setUserEmail(userEmail);
		u.setUserName(userName);
		u.setUserPass(userPass);
		u.setUserTel(userTel);
		// ����service��������user����
		int result = userService.addUser(u);
		if (result == 1) {
			// �ж��Ƿ���ӳɹ�
//			request.setAttribute("addSuccess","��ӳɹ���");
			String addSuccess = "��ӳɹ�!";
			String json = JSONUtils.ObejcToJson(addSuccess);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			return;
		} else {
			// �ж��Ƿ���ӳɹ�
//			request.setAttribute("addError","���ʧ�ܣ�");
			String addError = "���ʧ�ܣ�";
			String json = JSONUtils.ObejcToJson(addError);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//��ת���б����
//			request.getRequestDispatcher("addUser.jsp").forward(request, response);

		}
	}

	/**
	 * �ָ��û�Ȩ�޵ķ���
	 * 
	 */
	public void unRemove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҪ�ָ��Ĳ���
		int userId = Integer.parseInt(request.getParameter("userId"));
		// �����޸�״̬�ķ���
		int result = userService.unRemove(userId);
		// ���������json��
		String json = JSONUtils.ObejcToJson(result);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * ɾ���û��ķ���,��������Ľ�������ݱ���ɾ��֮ʱ�����״̬�ĳ�1����ʾ���ѱ�ɾ��
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡҪɾ���Ĳ���
		int userId = Integer.parseInt(request.getParameter("userId"));
		// �����޸�״̬�ķ���
		int result = userService.remove(userId);
		// ���������json��
		String json = JSONUtils.ObejcToJson(result);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * ��ѯ�û��б�ķ���
	 */
	public void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ִ����userList������");
		// ��ȡ����
		// ��ȡ��ǰҳ��
		// ����ҳ��Ĭ��Ϊ1
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
		// ���÷�ҳ��ѯ�ķ���
		Page<User> p = userService.queryByPage(page, rows);
		// ��page�������json��
		String json = JSONUtils.ObejcToJson(p);
		// System.out.println("p:"+p);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);

	}

}
