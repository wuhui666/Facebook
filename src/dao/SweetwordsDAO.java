package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Bean.*;

  
public class SweetwordsDAO {
  
    public SweetwordsDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                "admin");
    }
  
    public int getTotal(String account2) {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from sweetwords where account = " +"'"+account2+"'";
  
            ResultSet rs = s.executeQuery(sql);//resultset only contains one data:4,not contain sweetwords
            rs.next();//ensure move once firstly
           total=rs.getInt(1);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        
        return total;
    }
  
    public void add(Sweetwords sweetwords) {
  
        String sql ="insert into sweetwords values(?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(1,sweetwords.account);
            ps.setString(2, sweetwords.words);
            ps.setString(3, format.format(sweetwords.date));
           
            ps.execute();
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("add failed!");
        }
    }
  
//    public void update(Sweetwords sweetwords) {
//  
//        String sql = "update Sweetwords set password= ?,sex= ? , name = ? ,age= ? where number= ?";
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//  
//            ps.setString(1, user.password);
//            ps.setString(2, user.sex);
//            ps.setString(3, user.name);
//            ps.setInt(4, user.age);
//            ps.setInt(5, user.number);
//            ps.execute();
//  
//        } catch (SQLException e) {
//  
//            e.printStackTrace();
//        }
//  
//    }
  
    public void delete(String account2,Date date2) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "delete from sweetwords where account = " +"'"+account2+"'"+" and time="+"'"+format.format(date2)+"'";
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("delete failed!");
        }
    }
  
    public Sweetwords get(String account2,Date date2) {
    	Sweetwords temp=null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "select * from sweetwords where account = " +"'"+account2+"'"+" and time="+"'"+format.format(date2)+"'";
  
            ResultSet rs = s.executeQuery(sql);
  
          
            if (rs.next()) {
                temp= new Sweetwords();
                String account= rs.getString(1);
                String words= rs.getString(2);
                Date date=rs.getDate(3);
               
                temp.account = account;
                temp.words = words;
                temp.date = date;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("get sweetwords failed!");
        }
        return temp;
    }
//    public User get(String account2) {
//        User user = null;
//  
//        try (Connection c = getConnection(); Statement s = c.createStatement();) {
//  
//            String sql = "select * from user where account = " +"'"+account2+"'";
//  
//            ResultSet rs = s.executeQuery(sql);
//  
//            if (rs.next()) {
//                user= new User();
//               
//                String password = rs.getString(2);
//                
//                String sex= rs.getString(4);
//                int number= rs.getInt(3);
//                String name = rs.getString(5);
//                int age = rs.getInt(6);
//                user.number=number;
//                user.password = password;
//                user.sex = sex;
//                user.name = name;
//                user.age=age;
//                user.account = account2;
//            }
//  
//        } catch (SQLException e) {
//  
//            e.printStackTrace();
//        }
//        return user;
//    }
//  
    public List<Sweetwords> list(String account2) {
        return list(0, Short.MAX_VALUE,account2);
    }
  
    public List<Sweetwords> list(int start, int count,String account2) {
        List<Sweetwords> wordlist = new ArrayList<Sweetwords>();
        
        
        
  
       // SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "select * from sweetwords  where account = " +"'"+account2+"'"+"limit ?,?";
        
        
        
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
            	Sweetwords temp= new Sweetwords();
                String account= rs.getString(1);
                String words= rs.getString(2);
                Date date=rs.getDate(3);
               
                temp.account = account;
                temp.words = words;
                temp.date = date;
                
               
                wordlist.add(temp);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("list failed!");
        }
        return wordlist;
    }
  
    
}
