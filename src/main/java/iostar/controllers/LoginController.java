package iostar.controllers;

import java.io.IOException;


import iostar.models.UserModel;
import iostar.services.UserService;
import iostar.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")

public class LoginController extends HttpServlet {
// login do get lấy dữ liệu từ server mà k ảnh hưởng đến trạng thái 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	@Override
	// do post thực hiện để gửi dữ liệu đến server làm thay đổi trạng thái cho server
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	//	boolean isRememberMe = false;
		boolean remember = req.getParameter("rememberMe") != null;

//		if ("on".equals(remember)) {
//			isRememberMe = true;
//		}
		String alertMsg = "";
		if(username == null) {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		UserService service = new UserServiceImpl();
		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
					  if(remember){
					  saveRemeberMe(resp, username);
					  }

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/Login_Fail.jsp").forward(req, resp);
		}
	}
	private void saveRemeberMe(HttpServletResponse response, String
			username){
			 Cookie cookie = new Cookie(SESSION_USERNAME, username);	
			 cookie.setMaxAge(10);
			 cookie.setPath("/");
			 response.addCookie(cookie);
			 }
	
	

	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";

}
