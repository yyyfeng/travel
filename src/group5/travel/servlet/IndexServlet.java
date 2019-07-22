package group5.travel.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Trip;
import group5.travel.service.IMenuService;
import group5.travel.service.ITripService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	IMenuService menuService = (IMenuService) BeansFactory.getBean("menuService");
	 ITripService tripService = (ITripService) BeansFactory.getBean("tripService");
	//首页信息
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = menuService.index();
		List<Trip> st=null;
		try {
			st = tripService.queryBymenu("当季旅行");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(st.size()>3) {
			map.put("st","2");
		}
		map.put("trip", st);
		System.out.println(map);
		request.setAttribute("map", map);
		request.getRequestDispatcher("front/index.jsp").forward(request, response);
	}

}
