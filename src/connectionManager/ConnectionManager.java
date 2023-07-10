package connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	Connection con =null;
	
	public Connection establishConnection()throws ClassNotFoundException,SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://Localhost:3306/INVENTORY",
				"root","gowtham");
		return con;
	}
	public void closeConnection()throws SQLException{
		con.close();
	}

}
