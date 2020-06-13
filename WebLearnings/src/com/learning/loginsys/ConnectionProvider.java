package com.learning.loginsys;
import java.sql.*;

import static com.learning.loginsys.Provider.*;
public class ConnectionProvider {
	
	public static Connection con=null;
	static {
		try {
//			Class.forName(DRIVER);
		}catch(Exception e) {}
	}
	
}
