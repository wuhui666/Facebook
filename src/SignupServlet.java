import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


//public class SignupServlet {
//
//}
public class  SignupServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("issignup","");
		request.setCharacterEncoding("UTF-8");
		try {
            Class.forName("com.mysql.jdbc.Driver");
            }catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
	                "admin");
			String sqlString="insert into user values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sqlString);
			preparedStatement.setString(1,request.getParameter("account"));
			preparedStatement.setString(2,request.getParameter("password"));
			preparedStatement.setInt(3,Integer.parseInt(request.getParameter("number")));
			preparedStatement.setString(4,request.getParameter("sex"));
			preparedStatement.setString(5,request.getParameter("name2"));
			preparedStatement.setInt(6,Integer.parseInt(request.getParameter("age")));
//			if(preparedStatement.execute()==false){
//				//只有查询成功才返回true，如果是更新或插入的成功的话就返回false了；
//				//execute()会首先分析你传进去的SQL语句，如果是查询，无论有无结果都返回true，更新（增删改）无论是不是有效果都返回false，如果你传进去的SQL本身就是错的，那么就是报异常
//				request.setAttribute("issignup","true");
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//			else {
//				System.out.println(preparedStatement.execute());
//				request.getRequestDispatcher("home.jsp").forward(request, response);
//			}
			if(preparedStatement.executeUpdate()==1){
				request.setAttribute("issignup","true");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("issignup","false");
				
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}