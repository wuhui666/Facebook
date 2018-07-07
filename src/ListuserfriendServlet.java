
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import Bean.*;
import dao.*;
 
public class ListuserfriendServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        //List<Hero> heros = new HeroDAO().list();
//		if (request.getSession().getAttribute("user")==null) {
//			response.sendRedirect("login.html");
//			return;
//		}
		int start=0;
		int count=3;
		String accountString=request.getParameter("account");
		try {
			start=Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		        List<User> users = new ArrayList<User>();
		  
		        int size=0;
		        String sql = "select friendnumber from friendship where account=? order by friendnumber desc limit ?,?";
		        String sql2 = "select friendnumber from friendship where account=?";
		        
		        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
		                "admin"); PreparedStatement ps = c.prepareStatement(sql);PreparedStatement ps2 = c.prepareStatement(sql2);) {
		  
		        	ps.setString(1,accountString);
		            ps.setInt(2, start);
		            ps.setInt(3, count);
		            ps2.setString(1,accountString);
		            ResultSet rs = ps.executeQuery();
		  
		            ResultSet rs2 = ps2.executeQuery();
		            //the max index  is the number of hero -1
		            while (rs2.next()) {
		            	++size;
		            }
		            while (rs.next()) {
		            	
		                User user = new UserDAO().get(rs.getInt(1));
		                
		                users.add(user);
		            }
		        } catch (SQLException e) {
		  
		            e.printStackTrace();
		        }
		        
				int last=(size/count)==0&&size>count?size-count:size-(size%count);
				int next=start+count>=last?last:start+count;
				
				int pre=start-count<0?0:start-count;
				
				
        request.setAttribute("users",users);
        request.setAttribute("next",next);
        request.setAttribute("pre",pre);
        request.setAttribute("last",last);
        request.getRequestDispatcher("listfriend.jsp").forward(request, response);
        
    }
}