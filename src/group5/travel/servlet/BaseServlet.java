package group5.travel.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求参数中的OP
		String methodName = req.getParameter("op");  //detail
		
		
		//op是方法名称，所以我们可以通过反射机制直接调用对应的方法，而不需要判断
		//通过反射获取对应的方法
		Class clazz = this.getClass();
		try {
			//通过反射机制获取要执行的方法
			/**
			 * @param methodName  就是传递的OP，也就是方法的名称
			 * @param HttpServletRequest.class  方法所需要的参数类型的class对象
			 */
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//执行方法
			method.invoke(this,req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		this.doGet(req, resp);
	}
}
