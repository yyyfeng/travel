package group5.travel.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Menu;
import group5.travel.pojo.Trip;
import group5.travel.service.IMenuService;
import group5.travel.service.ITripService;
import group5.travel.util.FileUtil;
import group5.travel.util.JSONUtils;
import group5.travel.util.Page;

/**
 * Servlet implementation class TripServlet
 */
@WebServlet("/trip")
public class TripServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	ITripService tripService = (ITripService) BeansFactory.getBean("tripService");
	IMenuService menuService = (IMenuService) BeansFactory.getBean("menuService");
	/**
	 * ��Ӳ�ѯ������������ķ���
	 */
	public void queryAll2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ò�ѯ�ķ���
		List<Trip> trips = tripService.queryAll();
		System.out.println("trips--"+trips);
		//�����ݷ���request�в�������ת
		request.setAttribute("trips",trips);
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("front/dingzhi-error.jsp").forward(request, response);
	}
	/**
	 * ��Ӳ�ѯ������������ķ���
	 */
	public void queryAll1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ò�ѯ�ķ���
		List<Trip> trips = tripService.queryAll();
		System.out.println("trips--"+trips);
		//�����ݷ���request�в�������ת
		request.setAttribute("trips",trips);
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("front/dingzhi.jsp").forward(request, response);
	}
	/**
	 * ��Ӳ�ѯ������������ķ���
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ò�ѯ�ķ���
		List<Trip> trips = tripService.queryAll();
		System.out.println("trips--"+trips);
		//�����ݷ���request�в�������ת
		request.setAttribute("trips",trips);
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("front/dingzhi-succ.jsp").forward(request, response);
	}
	/**
	 * ��Ӳ�ѯ��������ķ���
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		System.out.println("tripId="+tripId);
		//����service������ѯtrip��Ϣ
		Trip trip = tripService.queryById(tripId);
		//�����ݷ���request�н�����ת
		request.setCharacterEncoding("utf-8");
		request.setAttribute("trip", trip);
		request.getRequestDispatcher("front/detail.jsp").forward(request, response);
	}
	/**
	 * ��̨��ҳ��ѯ�ķ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int rows = 10;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
		}
		try {
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch (NumberFormatException e) {
		}
		Page<Trip> p = tripService.queryByPage(page, rows);
		String json = JSONUtils.ObejcToJson(p);
		System.out.println(json);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * ����idɾ���б��е�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����id
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		String json = null;
		if (tripId == 0) {
			json = JSONUtils.ObejcToJson("2");
			response.getWriter().write(json);
			return;
		}
		int result = tripService.remove(tripId);
		System.out.println(result);
		if (result == 1) {
			json = JSONUtils.ObejcToJson("1");
			response.getWriter().write(json);
			return;
		} else {
			json = JSONUtils.ObejcToJson("0");
			response.getWriter().write(json);
			return;
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil fu = new FileUtil();
		// ��ȡ�������
		String tripName = request.getParameter("tripName");
		String tripDesc = request.getParameter("tripDesc");
		String tripDest = request.getParameter("tripDest");
		String experience = request.getParameter("experience");
		String tripDetail = request.getParameter("tripDetail");
		String tripHotel = request.getParameter("tripHotel");
		int tripCost = 0;
		try {
			tripCost = Integer.parseInt(request.getParameter("tripCost"));
		} catch (NumberFormatException e) {
		}
		int tripDays = 0;
		try {
			tripDays = Integer.parseInt(request.getParameter("tripDays"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String costInclude = request.getParameter("costInclude");
		String costUnInclude = request.getParameter("costUnInclude");
		String reserveNote = request.getParameter("reserveNote");
		String tripImg = request.getParameter("tripImg");
		int tripMenu = 0;
		try {
			tripMenu = Integer.parseInt(request.getParameter("tripMenu"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Trip t = new Trip();
		// ͼƬ�ϴ�
		if(tripImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && tripImg.length()>0 && tripImg !=null) {
			String path = this.getServletContext().getRealPath("/"+tripImg);
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			String url = fu.getDownLoadUrl(key);
			System.out.println(url);
			t.setTripImg(url);
		}else {
			t.setTripImg(tripImg);
		}
		// ��������װTrip����
		
		t.setTripDays(tripDays);
		t.setTripName(tripName);
		t.setTripDesc(tripDesc);
		t.setTripDest(tripDest);
		t.setExperience(experience);
		t.setTripDetail(tripDetail);
		t.setTripHotel(tripHotel);
		t.setTripCost(tripCost);
		t.setCostInclude(costInclude);
		t.setCostUnInclude(costUnInclude);
		t.setReserveNote(reserveNote);
		t.setTripMenu(tripMenu);
		// ��������
		String json = null;
		int result = tripService.save(t);
		System.out.println(result);
		response.setCharacterEncoding("utf-8");
		if (result == 1) {
			json = JSONUtils.ObejcToJson("1");
			response.getWriter().write(json);
			return;
		} else {
			json = JSONUtils.ObejcToJson("0");
			response.getWriter().write(json);
			return;
		}
	}

	/**
	 * �򿪱༭��ʵ�����ݻ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void inputed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�������
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		// ����id��ѯ
		Trip trip = tripService.queryById(tripId);
		System.out.println(trip);
		// ��tripת����json
		String json = JSONUtils.ObejcToJson(trip);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

	/**
	 * �޸�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil fu = new FileUtil();
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		String tripName = request.getParameter("tripName");
		String tripDesc = request.getParameter("tripDesc");
		String tripDest = request.getParameter("tripDest");
		String experience = request.getParameter("experience");
		String tripDetail = request.getParameter("tripDetail");
		String tripHotel = request.getParameter("tripHotel");
		int tripCost = Integer.parseInt(request.getParameter("tripCost"));
		String costInclude = request.getParameter("costInclude");
		String costUnInclude = request.getParameter("costUnInclude");
		String reserveNote = request.getParameter("reserveNote");
		String tripImg = request.getParameter("tripImg");
		System.out.println(tripImg);
		int tripMenu = 0;
		try {
			tripMenu = Integer.parseInt(request.getParameter("tripMenu"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tripDays = 0;
		try {
			tripDays = Integer.parseInt(request.getParameter("tripDays"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Trip t = new Trip();
    	//�޸ĺ��ļ��ϴ�
		if(tripImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") ==-1 && tripImg.length()>0 && tripImg !=null) {
			String path = this.getServletContext().getRealPath("/"+tripImg);
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			String url = fu.getDownLoadUrl(key);
			t.setTripImg(url);
		}else {
			t.setTripImg(tripImg);
		}
    	//��������װtrip����
    	
    	t.setTripDays(tripDays);
    	t.setTripId(tripId);
    	t.setTripName(tripName);
    	t.setTripDesc(tripDesc);
    	t.setTripDest(tripDest);
    	t.setExperience(experience);
    	t.setTripDetail(tripDetail);
    	t.setTripHotel(tripHotel);
    	t.setTripCost(tripCost);
    	t.setCostInclude(costInclude);
    	t.setCostUnInclude(costUnInclude);
    	t.setReserveNote(reserveNote);
    	t.setTripMenu(tripMenu);
		// ��������
		int result = tripService.update(t);
		System.out.println(result);
		// String json = null;
		if (result == 1) {
			// json = JSONUtils.ObejcToJson("1");
			response.getWriter().write("1");
			return;
		} else {
			// json = JSONUtils.ObejcToJson("0");
			response.getWriter().write("0");
			return;
		}
	}
	//����menuId�ҵ���ͬ�������Ʒ
	public void detaillist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		//��������
		List<Menu> menuList = menuService.queryAll();
		//��������֮��
		List<Trip> tripList = tripService.queryAll(0);
		Map<String,Object> map = new HashMap<>();
		map.put("menuList", menuList);
		map.put("tripList", tripList);
		
		List<Trip> trip=null;
		System.out.println(menuId);
		if(menuId==1) {
			trip = tripService.queryAll(menuId);
		}else {
			try {
				trip = tripService.queryByTripMenu(menuId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(trip.size()==0) {
			map.put("str", "0");
		}else if(trip.size()>0) {
			map.put("str", "1");
		}
		if(trip.size()>3) {
			map.put("st", "2");
		}
		map.put("trip", trip);
		System.out.println(map);
		request.setAttribute("map",map);
		request.getRequestDispatcher("front/qingshe.jsp").forward(request, response);
	}
	//ɸѡtrip
	public void choosetrip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tripDest = request.getParameter("tripDest");
		String day = request.getParameter("tripDays");
		String menuDesc = request.getParameter("menuDesc");
		System.out.println(tripDest );
		//��������
		List<Menu> menuList = menuService.queryAll();
		//��������֮��
		List<Trip> tripList = tripService.queryAll(0);
		Map<String,Object> map = new HashMap<>();
		map.put("menuList", menuList);
		map.put("tripList", tripList);
		
		List<Trip> trip = tripService.choose(tripDest,day,menuDesc);
		if(trip.size()==0) {
			map.put("str", "0");
		}else if(trip.size()>0) {
			map.put("str", "1");
		}
		if(trip.size()>3) {
			map.put("st", "2");
		}
		map.put("trip", trip);
		System.out.println(map);
		request.setAttribute("map",map);
		request.getRequestDispatcher("front/qingshe.jsp").forward(request, response);
	}
}
