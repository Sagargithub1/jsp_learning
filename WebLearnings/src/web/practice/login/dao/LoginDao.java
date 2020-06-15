package web.practice.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class LoginDao {
	String url="jdbc:mysql://localhost:3306/learningDB?autoReconnect=true&useSSL=false";
	String username="root";
	String password="";//rootgivenpassword
	String sql="select * from login where uname=? and pass=?";
	
	public boolean checkLogin(String userName, String userPassword) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, userPassword);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("Error Caught "+e);
		}
		
		return false;
	}
}
