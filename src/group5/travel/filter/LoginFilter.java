package group5.travel.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/order")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ǿת
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// ������Ҫ��¼�Ĳ���
		// ��ȡ�û������url
		String uri = req.getRequestURI();
		String op = req.getParameter("op");
		System.out.println(op);
		// ��ȡ�������
		if (op.equals("inputOrder")) {
			Map<String, String[]> parameterMap = req.getParameterMap();
			String params = "igeek=1";
			// ����map����ƴ�Ӳ���
			for (Entry<String, String[]> entry : parameterMap.entrySet()) {
				for (String value : entry.getValue()) {
					params += "&" + entry.getKey() + "=" + value;
				}
			}
			// ƴ��uri
			uri = "http://"+req.getServerName()+":"+req.getServerPort()+uri+"?"+params;
			System.out.println("uri:" + uri);
			// ����
			uri = URLEncoder.encode(uri, "utf-8");
			System.out.println(uri);
			// �ж��û��Ƿ��½
			HttpSession session = req.getSession();
			Object user = session.getAttribute("u");
			if (user == null) {// û��½��������
				request.setAttribute("loginError", "���ȵ�¼���ټ�����");
				// �����¼ҳ��
				resp.sendRedirect("/travel/front/login.jsp?uri=" + uri);
				return;
			}
			chain.doFilter(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
