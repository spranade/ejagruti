package ejagruti.finsys.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	
	protected static Connection conn = null;
	protected static Statement stmt = null;
	protected static ResultSetMetaData rsmd= null;
	protected static ResultSet rs1 = null;
	protected static ResultSet rs2 = null;
	protected static String query = "";
	protected static int columnNumber;
	protected static int rowNumber;
	
	public Connection setupDatabaseConnection(String dbUrl, String username, String password)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			throw new RuntimeException (e);
		}
		
		
		try 
		{
			conn = DriverManager.getConnection(dbUrl,username,password);
		}
		catch(SQLException e)
		{
			throw new RuntimeException (e);
		}
		
		return conn;
	}
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finsys","root","");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from cities");
		int i = 0;
		while(rs.next())
		{
			i++;
			System.out.println(rs.getString("cityname"));
			System.out.println("no of records ="+i);
		}
		
	}
	
	
	
}
