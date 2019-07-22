package group5.travel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Appoint;
import group5.travel.pojo.User;
import group5.travel.service.IAppointService;
import group5.travel.util.JSONUtils;
import group5.travel.util.Page;

/**
 * Servlet implementation class AppointServlet
 */
@WebServlet("/appoint")
public class AppointServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IAppointService appointService=(IAppointService) BeansFactory.getBean("appointService");
	/**
	 * ����ԤԼ��
	 */
	public  void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡԤԼ��������
		String appointName = request.getParameter("appointName");
		String appointTel = request.getParameter("appointTel");
		String appointDest = request.getParameter("appointDest");
		String appointDay = request.getParameter("appointDay");
		String appointTime = request.getParameter("appointTime");
		int appointAdult = Integer.parseInt(request.getParameter("appointAdult"));
		int appointChild = Integer.parseInt(request.getParameter("appointChild"));
		//����һ��appoint����
		Appoint a=new Appoint();
		User u=null;
		try {
			u = (User) request.getSession().getAttribute("u");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int userId=0;
		if (u!=null) {
			userId=u.getUserId();
		}
		System.out.println("u"+u);
		a.setUserId(userId);
		System.out.println("session�е�userId"+a.getUserId());
		a.setAppointAdult(appointAdult);
		a.setAppointChild(appointChild);
		a.setAppointDay(appointDay);
		a.setAppointDest(appointDest);
		a.setAppointName(appointName);
		a.setAppointTel(appointTel);
		a.setAppointTime(appointTime);
		System.out.println("a--"+a);
		if (appointName.equals("")||appointTel.equals("")) {
			//������Ƶ�������������δ��д����ֱ����תdao��¼���棬���û�ѡѡ���ǵ�¼����ע��
			response.sendRedirect("trip?op=queryAll2");
			return;
		}
		//���÷���
		int result = appointService.save(a);
		if (result==1) {
			request.getRequestDispatcher("trip?op=queryAll").forward(request, response);
			return ;
		}else {
			request.getRequestDispatcher("trip?op=queryAll1").forward(request, response);
			return ;
		}
	}
       /**
        * 	��ԤԼ����״̬�����޸�
        */
	public  void updateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		int appointId = Integer.parseInt(request.getParameter("appointId"));
		//����service��������������
		int result = appointService.updateStatus(appointId);
	//���������json��
		String json=JSONUtils.ObejcToJson(result);
		response.getWriter().write(json);
	}
	/**
	 * 	��ԤԼ����״̬�����޸�
	 */
	public  void reUpdateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		int appointId = Integer.parseInt(request.getParameter("appointId"));
		//����service��������������
		int result = appointService.reUpdateStatus(appointId);
		//���������json��
		String json=JSONUtils.ObejcToJson(result);
		response.getWriter().write(json);
	}
	public  void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Ȼ�ȡdao��ҳ��ѯ�Ĳ���
		int page=1;
		int rows=10;
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
		//���ÒOҲ��ѯ�ķ���
		Page<Appoint> p = appointService.queryByPage(page, rows);
		//�����ݷ���json��
		String json=JSONUtils.ObejcToJson(p);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
		
	}

}
