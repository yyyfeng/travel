package group5.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.bean.BeansFactory;

import group5.travel.pojo.Menu;
import group5.travel.service.IMenuService;
import group5.travel.util.FileUtil;
import group5.travel.util.JSONUtils;
import group5.travel.util.Page;


@WebServlet("/menu")
public class MenuServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	IMenuService menuService = (IMenuService) BeansFactory.getBean("menuService");
	//主题列表
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		int rows = 5;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
		}
		try {
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch (NumberFormatException e) {
		}
		Page p =  menuService.queryBy(page,rows);
		response.setCharacterEncoding("utf-8");
		String json = JSONUtils.ObejcToJson(p);
		response.getWriter().write(json);
	}
	//删除列表
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表格的id
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		if(menuId==0) {
			String json = JSONUtils.ObejcToJson("2");
			response.getWriter().write(json);
			return;
		}
		int rs = menuService.remove(menuId);
		if(rs==1) {
			String json = JSONUtils.ObejcToJson("1");
			response.getWriter().write(json);
			return;
		}else {
			String json = JSONUtils.ObejcToJson("0");
			response.getWriter().write(json);
			return;
		}
	}
	//添加主题
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil fu = new FileUtil();
		
		String menuDesc = request.getParameter("menuDesc");
		String menuImg = request.getParameter("menuImg");
		/*
		 * // ----------------------
			// 获取图片在tomcat的地址
			String image = request.getParameter("image");
			image = image.substring(image.indexOf("\\") + 1);
			// 获取图片的物理地址
			String path = this.getServletContext().getRealPath("/" + image);
			// 上传图片，并且获取图片在云端的key
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			// 通过key获取访问图片的地址
			String url = fu.getDownLoadUrl(key);
			// ------------------------
			int type = Integer.parseInt(request.getParameter("type"));
			// 轮播图，详情（html代码）
			// ----------
			String images = request.getParameter("images");
			// ----------
		 */
		//对图片进行处理
		Menu menu = new Menu();
		if(menuImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && menuImg.length()>0) {
			String path = this.getServletContext().getRealPath("/"+menuImg);
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			String url = fu.getDownLoadUrl(key);
			System.out.println(url);
			menu.setMenuImg(url);
		}else {
			menu.setMenuImg(menuImg);
		}
		menu.setMenuDesc(menuDesc);
		int rs = menuService.Add(menu);
		System.out.println(rs);
		if(rs==1) {
			//response.getWriter().write("1");
			request.setAttribute("ERRO", "添加成功");
			request.getRequestDispatcher("addMenu.jsp").forward(request, response);
		}else {
			request.setAttribute("ERRO", "失败");
			request.getRequestDispatcher("addMenu.jsp").forward(request, response);
		}
	}
	public void inputed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("menuId"));
		Menu menu=menuService.queryById(id);
		System.out.println(menu);
		String json = JSONUtils.ObejcToJson(menu);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil fu = new FileUtil();
		
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String menuDesc = request.getParameter("menuDesc");
		String menuImg = request.getParameter("menuImg");
		System.out.println(menuImg);
		Menu menu = new Menu();
		if(menuImg.indexOf("http://pjnyft8b0.bkt.clouddn.com/") == -1 && menuImg.length()>0) {
			String path = this.getServletContext().getRealPath("/"+menuImg);
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			String url = fu.getDownLoadUrl(key);
			System.out.println(url);
			menu.setMenuImg(url);
		}else {
			menu.setMenuImg(menuImg);
		}
		menu.setMenuDesc(menuDesc);
		menu.setMenuId(menuId);	
		int rs=menuService.update(menu);
		System.out.println(menu);
		response.setCharacterEncoding("utf-8");
		if(rs==1) {
			response.getWriter().write("1");
		}else {
			response.getWriter().write("0");
		}
	}
}





