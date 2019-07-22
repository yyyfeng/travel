package group5.travel.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Appoint;
import group5.travel.pojo.Order;
import group5.travel.pojo.Trip;
import group5.travel.pojo.User;
import group5.travel.service.IAppointService;
import group5.travel.service.IOrderService;
import group5.travel.service.ITripService;

/**
 * Servlet implementation class DingDanServlet
 */
//订单状态
@WebServlet("/dingdan")
public class DingDanServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	IOrderService orderservice  = (IOrderService) BeansFactory.getBean("orderService");
	ITripService tripService = (ITripService) BeansFactory.getBean("tripService");
	IAppointService appointService=(IAppointService) BeansFactory.getBean("appointService");
	//所有订单
	public void QueryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("u");
		System.out.println(user);
		List<Order> order = orderservice.queryAll(user.getUserId());
		//System.out.println(order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("front/myorder.jsp").forward(request, response);
	}
	//未完成
	public void NotDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("u");
		int status =0;
		List<Order> order = orderservice.queryBystatus(user.getUserId(),status);
		System.out.println(order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("front/myorder-dzf.jsp").forward(request, response);
	}
	//已完成
	public void Completed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("u");
		int status =1;
		List<Order> order = orderservice.queryBystatus(user.getUserId(),status);
		System.out.println(order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("front/myorder-ywc.jsp").forward(request, response);
	}
	//我的定制
	public void Dingzhi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("u");
		List<Appoint> as = appointService.queryByUserId(user.getUserId());
		request.setAttribute("as", as);
		request.getRequestDispatcher("front/myorder-dz.jsp").forward(request, response);
	}
	//订单详情
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("u");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Map<String, Object> map = orderservice.detail(orderId);
		Order order = (Order)map.get("order");
		Trip trip = tripService.queryById(order.getTripId());
		map.put("trip", trip);
		map.put("user", user);
		request.setAttribute("map", map);
		request.getRequestDispatcher("front/orderdetail.jsp").forward(request, response);
	}
	//定制详情
	public void dzDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("u");
		int appointId = Integer.parseInt(request.getParameter("appointId"));
		Appoint a  = appointService.queryByAppointId(appointId);
		request.setAttribute("a", a);
		request.getRequestDispatcher("front/appointdetail.jsp").forward(request, response);
	}
}
