package phdhtl.cntt.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectSQL {
	
	// mysql
//	public static final String jdbcURL = "jdbc:mysql://node33321-tmdt4.proen.app.ruk-com.cloud:3306/bansach??useUnicode=true&characterEncoding=UTF-8&useSSL=false";
//	public static final String jdbcUsername = "root";
//	public static final String jdbcPassword = "CEKgik26274";
	
	public static final String jdbcURL = "jdbc:mysql://localhost:3306/bansach?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	public static final String jdbcUsername = "root";
	public static final String jdbcPassword = "";


	// phương thức kết nối với CSDL
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("sucsses connect");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}
	
	// sql server
    /*public static final  String jdbcURL = 
    		"jdbc:sqlserver://localhost:1433;"
    		+ "DatabaseName=bansach;"
    		+ "encrypt = true;"
    		+ "trustServerCertificate=true;"
    		;
    public static final  String USERNAME = "sa";
    public static final  String PASSWORD = "1";
 
    public static Connection getConnectionSQLServer () {
    	
    	Connection connection = null;
    	try {
    		java.security.Security.setProperty("jdk.tls.disabledAlgorithms","");
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		connection = DriverManager.getConnection(jdbcURL,USERNAME,PASSWORD);
    		System.out.println("success connect");
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
    }*/
    
    /*
    public static void main(String[] args) {
    	// test connect
		Connection connection = getConnectionSQLServer();
		System.out.println(connection);
	}*/
}
