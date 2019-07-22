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
	//�����б�
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
	//ɾ���б�
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����id
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
	//�������
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil fu = new FileUtil();
		
		String menuDesc = request.getParameter("menuDesc");
		String menuImg = request.getParameter("menuImg");
		/*
		 * // ----------------------
			// ��ȡͼƬ��tomcat�ĵ�ַ
			String image = request.getParameter("image");
			image = image.substring(image.indexOf("\\") + 1);
			// ��ȡͼƬ�������ַ
			String path = this.getServletContext().getRealPath("/" + image);
			// �ϴ�ͼƬ�����һ�ȡͼƬ���ƶ˵�key
			String key = fu.upload(path, path.substring(path.lastIndexOf(".")));
			// ͨ��key��ȡ����ͼƬ�ĵ�ַ
			String url = fu.getDownLoadUrl(key);
			// ------------------------
			int type = Integer.parseInt(request.getParameter("type"));
			// �ֲ�ͼ�����飨html���룩
			// ----------
			String images = request.getParameter("images");
			// ----------
		 */
		//��ͼƬ���д���
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
			request.setAttribute("ERRO", "��ӳɹ�");
			request.getRequestDispatcher("addMenu.jsp").forward(request, response);
		}else {
			request.setAttribute("ERRO", "ʧ��");
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





