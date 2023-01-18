package jdbcStandApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	private JDBCUtil() {}
	//static class to return connection
	public static Connection getJdbcConnection() throws SQLException, IOException {
		
		Connection connection=null;
		
		//Create application.properties
		FileInputStream fileInputStream=new FileInputStream("/Users/kunalmadne/eclipse-workspace/JDBCStandApp/appliction.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		String url=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		
		connection=DriverManager.getConnection(url,username,password);
		
		return connection;
		
	}
	
	public static void cleanUp(Connection con, Statement stat, ResultSet rs) throws SQLException {
		
		if(con!=null) con.close();
		if(stat!=null) stat.close();
		if(rs!=null) rs.close();
		
	}
}
