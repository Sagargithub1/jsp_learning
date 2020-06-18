package web.practice.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import web.practice.bean.UserBean;

public class UserDao {
	
	public int registerUser(UserBean user) throws ClassNotFoundException {
		String INSERT_USER_SQL="INSERT into user001(id,firstname,lastname,username,userpassword,email) VALUES(?,?,?,?,?,?);";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learningDB?autoReconnect=true&useSSL=false","root","");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(INSERT_USER_SQL);
//			ps.setInt(1, 2);
			ps.setInt(1,user.getId() );
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getUserName());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getEmail());
			
			System.out.println(ps);
			
			result=ps.executeUpdate();
			/*
			 * try (ResultSet rs = ps.getGeneratedKeys()) { if (rs.next()) {
			 * user.setId(rs.getInt(1)); }}catch(Exception e) {}
			 */
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return result;
		/*
		 * try (Connection connection = DriverManager
		 * .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false",
		 * "root", "root");
		 * 
		 * // Step 2:Create a statement using connection object PreparedStatement
		 * preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		 * preparedStatement.setInt(1, 1); preparedStatement.setString(2,
		 * user.getFirstName()); preparedStatement.setString(3, user.getLastName());
		 * preparedStatement.setString(4, user.getUsername());
		 * preparedStatement.setString(5, user.getPassword());
		 * preparedStatement.setString(6, user.getEmail());
		 * 
		 * 
		 * System.out.println(preparedStatement); // Step 3: Execute the query or update
		 * query result = preparedStatement.executeUpdate();
		 * 
		 * } catch (SQLException e) { // process sql exception printSQLException(e); }
		 */
		
	}

	public boolean checkLogin(String userName, String userPassword) {
		
		String url="jdbc:mysql://localhost:3306/learningDB?autoReconnect=true&useSSL=false";
		String username="root";
		String password="";//rootgivenpassword
		String fetch_user_login_sql="select * from user001 where username=? and userpassword=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=(PreparedStatement) con.prepareStatement(fetch_user_login_sql);
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
