package nl.ing.crowdfunding.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnecetion() throws SQLException 
	{
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://172.17.34.100:3306/crowdfunding?"
						+ "user=crowdfunding&password=Welkom01");
		
		return connection;
	}
}
