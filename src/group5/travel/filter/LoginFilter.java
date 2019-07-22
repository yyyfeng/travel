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
		// 强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 拦截需要登录的操作
		// 获取用户请求的url
		String uri = req.getRequestURI();
		String op = req.getParameter("op");
		System.out.println(op);
		// 获取请求参数
		if (op.equals("inputOrder")) {
			Map<String, String[]> parameterMap = req.getParameterMap();
			String params = "igeek=1";
			// 遍历map自行拼接参数
			for (Entry<String, String[]> entry : parameterMap.entrySet()) {
				for (String value : entry.getValue()) {
					params += "&" + entry.getKey() + "=" + value;
				}
			}
			// 拼接uri
			uri = "http://"+req.getServerName()+":"+req.getServerPort()+uri+"?"+params;
			System.out.println("uri:" + uri);
			// 编码
			uri = URLEncoder.encode(uri, "utf-8");
			System.out.println(uri);
			// 判断用户是否登陆
			HttpSession session = req.getSession();
			Object user = session.getAttribute("u");
			if (user == null) {// 没登陆进行拦截
				request.setAttribute("loginError", "请先登录，再继续！");
				// 进入登录页面
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
