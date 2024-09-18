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

import iostar.services.UserService;
import iostar.services.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgetpassword")
public class ForgotPassword extends HttpServlet{
	 private UserService userService = new UserServiceImpl();
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	        request.getRequestDispatcher("views/forgetpassword.jsp").forward(request, response);
	    }
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        String username = request.getParameter("username");
	        String newPassword = request.getParameter("newPassword");
	        String confirmPassword = request.getParameter("confirmPassword");

	    
	        if (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword)) {
	         
	            boolean isUpdated = userService.update(username, newPassword);

	            if (isUpdated) {
	                request.setAttribute("message", "Mật khẩu đã được cập nhật thành công.");
	                request.getRequestDispatcher("views/login.jsp").forward(request, response);
	            } else {
	              
	                request.setAttribute("error", "Cập nhật mật khẩu thất bại. Vui lòng thử lại.");
	                request.getRequestDispatcher("views/forgetpassword.jsp").forward(request, response);
	            }
	        } 
	        else {
	           
	            request.setAttribute("error", "Mật khẩu và mật khẩu xác nhận không trùng khớp.");
	            request.getRequestDispatcher("views/forgetpassword.jsp").forward(request, response);
	        }
	    }

}
