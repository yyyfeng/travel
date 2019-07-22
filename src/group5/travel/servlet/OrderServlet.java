package group5.travel.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Order;
import group5.travel.pojo.Trip;
import group5.travel.pojo.User;
import group5.travel.service.IOrderService;
import group5.travel.service.ITripService;
import group5.travel.util.JSONUtils;
import group5.travel.util.Page;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = (IOrderService) BeansFactory.getBean("orderService");
	private ITripService tripService = (ITripService) BeansFactory.getBean("tripService");
	//��̨��Ӷ���
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startTime = request.getParameter("startTime");
		String createTime = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		int adultNum = Integer.parseInt(request.getParameter("adultNum"));
		int childNum = Integer.parseInt(request.getParameter("childNum"));
		//int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		double orderCost =Double.parseDouble(request.getParameter("orderCost"));
		Order o = new Order();
		o.setAdultNum(adultNum);
		o.setChildNum(childNum);
		//o.setOrderStatus(orderStatus);
		o.setCreateTime(createTime);
		o.setStartTime(startTime);
		o.setTripId(tripId);
		o.setUserId(userId);
		o.setOrderCost(orderCost);
		int result = orderService.add(o);
		response.setContentType("text/html;charset=UTF-8");
		if (result==1) {
			//����һ��������Ϣ�����ڴ�����ʾ
			request.setAttribute("addError", "��ӳɹ�");
			//ת��������ӽ��棨����������ʧ�ܣ���ʾһ��������Ϣ���ҿ��������ٴ���ӣ�
			request.getRequestDispatcher("addOrder.jsp").forward(request, response);
		}else {
			//����һ��������Ϣ�����ڴ�����ʾ
			request.setAttribute("addError", "���ʧ��");
			//ת��������ӽ��棨����������ʧ�ܣ���ʾһ��������Ϣ���ҿ��������ٴ���ӣ�
			request.getRequestDispatcher("addOrder.jsp").forward(request, response);
		}
	}
	//�����б�
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page =1;
		int rows = 10;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
		}
		try {
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch (NumberFormatException e) {
		}
		Page<Order> pager = orderService.queryByPage(page,rows);
		String json = JSONUtils.ObejcToJson(pager);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	
	//ɾ������
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int result = orderService.deleteOrder(orderId);
		response.setCharacterEncoding("utf-8");
		if(result==1) {
			String json = JSONUtils.ObejcToJson("1");
			response.getWriter().write(json);
			return;
		}else {
			String json = JSONUtils.ObejcToJson("0");
			response.getWriter().write(json);
			return;
		}
	}
	//�޸Ķ������״̬
	public void status(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		Order o = new Order();
		o.setOrderId(orderId);
		o.setOrderStatus(orderStatus);
		int result = orderService.status(o);
		if(result==1) {
			String json = JSONUtils.ObejcToJson("1");
			response.getWriter().write(json);
			return;
		}else {
			String json = JSONUtils.ObejcToJson("0");
			response.getWriter().write(json);
			return;
		}
	}
	//��̨�޸�ʱ���Զ�����Ϣ
	public void reviewOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Order order = orderService.queryById(orderId);
		String json = JSONUtils.ObejcToJson(order);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	//�޸Ķ���
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String startTime = request.getParameter("startTime");
		int adultNum = Integer.parseInt(request.getParameter("adultNum"));
		int childNum = Integer.parseInt(request.getParameter("childNum"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		double orderCost =Double.parseDouble(request.getParameter("orderCost"));
		Order order = new Order();
		order.setOrderId(orderId);
		order.setStartTime(startTime);
		order.setAdultNum(adultNum);
		order.setChildNum(childNum);
		order.setTripId(tripId);
		order.setUserId(userId);
		order.setOrderCost(orderCost);
		int result = orderService.edit(order);
		response.setContentType("text/html;charset=UTF-8");
		if (result==1) {
			response.getWriter().write("<h3>�޸ĳɹ�</h3>");
		}else {
			response.getWriter().write("<h3>�޸�ʧ��</h3>");
		}
	}
	//���Զ�����Ϣ�е�������Ϣ
	public void inputOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		//��������Ϣ����ǰ̨�µ�����
		Trip trip = tripService.queryById(tripId);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("trip", trip);
		request.getRequestDispatcher("front/order-tijiao.jsp").forward(request, response);
	}
	//ȷ�϶�����ǰ̨��Ӷ�����
	public void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String createTime = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		String startTime = request.getParameter("startTime");
		int adultNum = Integer.parseInt(request.getParameter("adultNum"));
		int childNum = Integer.parseInt(request.getParameter("childNum"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		double orderCost =Double.parseDouble(request.getParameter("orderCost"));
		System.out.println(startTime+","+adultNum+","+childNum+",������"+orderCost);
		System.out.println("tripId"+tripId);
		System.out.println("userId"+userId);
		Order o = new Order();
		o.setCreateTime(createTime);
		o.setStartTime(startTime);
		o.setAdultNum(adultNum);
		o.setChildNum(childNum);
		o.setTripId(tripId);
		o.setUserId(userId);
		o.setOrderCost(orderCost);
		int result = orderService.add(o);
		String json = JSONUtils.ObejcToJson(result);
		System.out.println(json);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
}
