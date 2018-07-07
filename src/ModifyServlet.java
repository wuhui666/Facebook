import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import Bean.*;
import dao.*;;
//public class SignupServlet {
//
//}
public class  ModifyServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		User tempUser=new UserDAO().get(request.getParameter("account"));
		tempUser.age=Integer.parseInt(request.getParameter("age"));
		tempUser.sex=request.getParameter("sex");
		tempUser.name=request.getParameter("name2");
		tempUser.account=request.getParameter("account");
		
		new UserDAO().update(tempUser);
		request.setAttribute("ismodified", "true");
		request.getRequestDispatcher("modifyInformation.jsp").forward(request, response);
	}
}