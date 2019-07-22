package group5.travel.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ��������е�OP
		String methodName = req.getParameter("op");  //detail
		
		
		//op�Ƿ������ƣ��������ǿ���ͨ���������ֱ�ӵ��ö�Ӧ�ķ�����������Ҫ�ж�
		//ͨ�������ȡ��Ӧ�ķ���
		Class clazz = this.getClass();
		try {
			//ͨ��������ƻ�ȡҪִ�еķ���
			/**
			 * @param methodName  ���Ǵ��ݵ�OP��Ҳ���Ƿ���������
			 * @param HttpServletRequest.class  ��������Ҫ�Ĳ������͵�class����
			 */
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//ִ�з���
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
