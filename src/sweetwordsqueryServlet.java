

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
 
public class sweetwordsqueryServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int start=0;
		int count=3;
		String accountString=null;
		try {
			accountString=new UserDAO().get(Integer.parseInt(request.getParameter("querynumber"))).account;
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("inputisillegal", "true");
			request.getRequestDispatcher("sweetwordsquery.jsp").forward(request, response);
		}
		try {
			start=Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
//		request.setAttribute("isquery","false");
//		request.setAttribute("inputisillegal", "false");
//		if(request.getParameter("querynumber")!=null){
//			request.setAttribute("isquery","true");
//			try {
//				accountString=new UserDAO().get(Integer.parseInt(request.getParameter("querynumber"))).account;
//			} catch (Exception e) {
//				// TODO: handle exception
//				request.setAttribute("inputisillegal", "true");
//				request.getRequestDispatcher("queryfriends.jsp").forward(request, response);
//			}
//		}
		
		
		       // List<Sweetwords> wordlist = new ArrayList<Sweetwords>();
		  
//		        int size=0;
//		        String sql = "select * from sweetwords where account=? limit ?,?";
//		        String sql2 = "select * from sweetwords where account=?";
//		        
//		        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
//		                "admin"); PreparedStatement ps = c.prepareStatement(sql);PreparedStatement ps2 = c.prepareStatement(sql2);) {
//		  
//		        	ps.setString(1,accountString);
//		            ps.setInt(2, start);
//		            ps.setInt(3, count);
//		            ps2.setString(1,accountString);
//		            ResultSet rs = ps.executeQuery();
//		  
//		            ResultSet rs2 = ps2.executeQuery();
//		            //the max index  is the number of hero -1
//		            while (rs2.next()) {
//		            	++size;
//		            }
//		            while (rs.next()) {
//		            	
//		                Sweetwords tSweetwords = new SweetwordsDAO().get(rs.getString(1),rs.getDate(3));
//		                
//		                wordlist.add(Sweetwords);
//		            }
//		        } catch (SQLException e) {
//		  
//		            e.printStackTrace();
//		        }
		        List<Sweetwords> wordslist = new ArrayList<Sweetwords>();
		        wordslist=new SweetwordsDAO().list(start, count,accountString);
		       
		        int size=new SweetwordsDAO().getTotal(accountString);
		        
				int last=(size/count)==0&&size>count?size-count:size-(size%count);
				int next=start+count>=last?last:start+count;
				
				int pre=start-count<0?0:start-count;
				
				
        request.setAttribute("wordslist",wordslist);
        request.setAttribute("next",next);
        request.setAttribute("pre",pre);
        request.setAttribute("last",last);
        request.getRequestDispatcher("listquerysweetwords.jsp").forward(request, response);
        
    }
}