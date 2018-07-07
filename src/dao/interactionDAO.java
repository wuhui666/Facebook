
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

  
public class interactionDAO {
  
    public interactionDAO() {
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
  
    public void add(Interaction interaction) {
  
        String sql ="insert into interaction values(?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(1,interaction.account);
            ps.setInt(2, interaction.friendnumber);
            ps.setString(3, interaction.words);
            ps.setString(4, format.format(interaction.date));
           
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
  
    public void delete(String account2,int friendnumber2,Date date2) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "delete from interaction where " +
            		"account = " +"'"+account2+"'"+" and time="+"'"+format.format(date2)+"'"+"and friendnumber= "
            		+"'"+friendnumber2+"'";
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("delete failed!");
        }
    }
  
    public Interaction get(String account2,int friendnumber2,Date date2) {
    	Interaction temp=null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "select * from interaction where account = " +"'"+account2+"'"
        	+" and time="+"'"+format.format(date2)+"'"+"and friendnumber= "
            		+"'"+friendnumber2+"'";
            ResultSet rs = s.executeQuery(sql);
  
          
            if (rs.next()) {
                temp= new Interaction();
                String account= rs.getString(1);
                int friendnumber=rs.getInt(2);
                String words= rs.getString(3);
                Date date=rs.getDate(4);
               
                temp.account = account;
                temp.friendnumber = friendnumber;
                temp.words = words;
                temp.date = date;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("get interaction failed!");
        }
        return temp;
    }
    public String getFriendname(Interaction interaction) {
    	String temp=null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
        	
            String sql = "select name from user where number = " +"'"+interaction.friendnumber+"'";
            ResultSet rs = s.executeQuery(sql);
  
          
            rs.next();
            temp=rs.getString(1);
        } catch (SQLException e) {
  
            e.printStackTrace();
            System.out.println("get friendname failed!");
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
    public List<Interaction> list(String account2) {
        return list(0, Short.MAX_VALUE,account2);
    }
  
    public List<Interaction> list(int start, int count,String account2) {
        List<Interaction> wordlist = new ArrayList<Interaction>();
        
        
        
  
       // SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "select * from interaction  where account = " +"'"+account2+"'"+"limit ?,?";
        
        
        
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
            	Interaction temp= new Interaction();
                String account= rs.getString(1);
                int friendnumber=rs.getInt(2);
                String words= rs.getString(3);
                Date date=rs.getDate(4);
               
                temp.account = account;
                temp.words = words;
                temp.friendnumber=friendnumber;
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
