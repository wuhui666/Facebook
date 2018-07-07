package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 import Bean.*;

  
public class UserDAO {
  
    public UserDAO() {
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
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from user";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                ++total;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(User user) {
  
        String sql ="insert into user values(?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.account);
            ps.setString(2, user.password);
            ps.setInt(3, user.number);
            ps.setString(4, user.sex);
            ps.setString(5, user.name);
            ps.setInt(6, user.age);
            ps.execute();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(User user) {
  
        String sql = "update user set password= ?,sex= ? , name = ? ,age= ? where number= ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.password);
            ps.setString(2, user.sex);
            ps.setString(3, user.name);
            ps.setInt(4, user.age);
            ps.setInt(5, user.number);
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int number2) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from hero where number = " +"'"+number2+"'";
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public User get(int number2) {
        User user = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from user where number = " +"'"+number2+"'";
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                user= new User();
                String account= rs.getString(1);
                String password = rs.getString(2);
                
                String sex= rs.getString(4);
                
                String name = rs.getString(5);
                int age = rs.getInt(6);
                user.account = account;
                user.password = password;
                user.sex = sex;
                user.name = name;
                user.age=age;
                user.number = number2;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return user;
    }
    public User get(String account2) {
        User user = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from user where account = " +"'"+account2+"'";
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                user= new User();
               
                String password = rs.getString(2);
                
                String sex= rs.getString(4);
                int number= rs.getInt(3);
                String name = rs.getString(5);
                int age = rs.getInt(6);
                user.number=number;
                user.password = password;
                user.sex = sex;
                user.name = name;
                user.age=age;
                user.account = account2;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return user;
    }
  
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<User> list(int start, int count) {
        List<User> users = new ArrayList<User>();
  
        String sql = "select * from user order by number desc limit ?,? ";
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                User user = new User();
                String account= rs.getString(1);
                int number = rs.getInt(3);
                String name = rs.getString(5);
                String sex= rs.getString(4);
                int age= rs.getInt(6);
                user.number = number;
                user.name = name;
                user.age = age;
                user.sex= sex;
                users.add(user);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return users;
    }
  
    
}
