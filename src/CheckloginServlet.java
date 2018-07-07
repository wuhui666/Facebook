import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;


//public class CheckloginServlet {
//
//}
public class CheckloginServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		boolean flag=false;
		request.setAttribute("ispasswordwrong", "");
		request.setAttribute("userNotExist", "");
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            }catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
	                "admin");
			Statement statement=connection.createStatement();
			statement.execute("select * from user where account="+"'"+request.getParameter("account")+"'"+" and password="+"'"+request.getParameter("password")+"'");
			log(request.getParameter("password"));
			ResultSet resultSet=(ResultSet) statement.getResultSet();
			if (resultSet.next()) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			}
			else {
				Statement statement2=connection.createStatement();
				statement2.execute("select * from user where account="+"'"+request.getParameter("account")+"'");
				ResultSet resultSet2=(ResultSet) statement2.getResultSet();
				if (resultSet2.next()) {
					request.setAttribute("ispasswordwrong", "true");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					request.setAttribute("userNotExist", "true");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}