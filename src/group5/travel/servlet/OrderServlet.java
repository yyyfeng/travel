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
	//后台添加订单
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
			//设置一个错误信息，用于传入显示
			request.setAttribute("addError", "添加成功");
			//转发进入添加界面（就是如果添加失败，显示一个错误信息并且可以立即再次添加）
			request.getRequestDispatcher("addOrder.jsp").forward(request, response);
		}else {
			//设置一个错误信息，用于传入显示
			request.setAttribute("addError", "添加失败");
			//转发进入添加界面（就是如果添加失败，显示一个错误信息并且可以立即再次添加）
			request.getRequestDispatcher("addOrder.jsp").forward(request, response);
		}
	}
	//订单列表
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
	
	//删除订单
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
	//修改订单完成状态
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
	//后台修改时回显订单信息
	public void reviewOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Order order = orderService.queryById(orderId);
		String json = JSONUtils.ObejcToJson(order);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	//修改订单
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
			response.getWriter().write("<h3>修改成功</h3>");
		}else {
			response.getWriter().write("<h3>修改失败</h3>");
		}
	}
	//回显订单信息中的旅游信息
	public void inputOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		//将订单信息传给前台下单界面
		Trip trip = tripService.queryById(tripId);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("trip", trip);
		request.getRequestDispatcher("front/order-tijiao.jsp").forward(request, response);
	}
	//确认订单（前台添加订单）
	public void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String createTime = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		String startTime = request.getParameter("startTime");
		int adultNum = Integer.parseInt(request.getParameter("adultNum"));
		int childNum = Integer.parseInt(request.getParameter("childNum"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		double orderCost =Double.parseDouble(request.getParameter("orderCost"));
		System.out.println(startTime+","+adultNum+","+childNum+",订单金额："+orderCost);
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
