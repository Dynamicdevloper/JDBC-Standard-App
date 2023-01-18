package jdbcStandApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection=null;
		PreparedStatement stat=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection = JDBCUtil.getJdbcConnection();
			
			if(connection!=null)
				statement=connection.createStatement();
			
			if(statement!=null)
				resultSet=statement.executeQuery("select * from test");
			
			if(resultSet!=null) {
				System.out.println("id\tname\tage\tteam\tgender");
				while(resultSet.next()) {
					int id=resultSet.getInt(1);
					String name= resultSet.getString(2);
					int age=resultSet.getInt(3);
					String team= resultSet.getString(4);
					char ch='M';
					System.out.println(id+"\t"+name+"\t"+age+"\t"+team+"\t"+ch);
				
				}
			}
//			String query="insert into test values(?,?,?,?)";
//			if(connection!=null) {
//				statement=connection.prepareCall(query);
//			}
//			
//			if(statement!=null) {
//				statement.setInt(1, 5);
//				statement.setString(2, "gayle");
//				statement.setInt(3, 43);
//				statement.setString(4, "RCB");
//				
//				int rowCount= statement.executeUpdate();
//				System.out.println(rowCount);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.cleanUp(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
