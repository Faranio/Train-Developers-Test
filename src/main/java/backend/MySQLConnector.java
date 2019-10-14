/**
 * 
 */
package backend;

import java.sql.*;

/**
 * @author vallre
 *
 */
public class MySQLConnector {
	
	protected Connection con;
	protected Statement stmt;
	
	/**
	 * @param port - port to your database over TCP?IP connection (address is set to localhost)
	 * @param schema - schema of the database
	 * @param username - used to log into the database
	 * @param password - used to log into the database
	 * @throws SQLException
	 */
	public MySQLConnector(int port, String schema, String username, String password) throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:" + port +"/" + schema, username, password); 
		stmt = con.createStatement();
	}

	/**
	 * @param selectStatement - write any valid SQL select statement here (e.g. select * from EMPLOYEE)
	 * @return ResultSet - returns a table for a given query; Use ResultSet.next() and ResultSet.get{DATATYPE}(int Column), where the DATATYPE is the datatype of a variable with its column number Column  
	 * @throws SQLException
	 */
	public ResultSet getData(String selectStatement) throws SQLException {
		
		return stmt.executeQuery(selectStatement);
	}
	
	/**
	 * @param select - select portion of a query (e.g. FName, LName)
	 * @param from - from portion of a query (e.g. EMPLOYEE)
	 * @return ResultSet - returns a table for a given query; Use ResultSet.next() and ResultSet.get{DATATYPE}(int Column), where the DATATYPE is the datatype of a variable with its column number Column  
	 * @throws SQLException
	 */
	public ResultSet getData(String select, String from) throws SQLException {
		
		return stmt.executeQuery("select " + select + " from " + from);
	}
	
	/**
	 * @param select - select portion of a query (e.g. FName, LName)
	 * @param from - from portion of a query (e.g. EMPLOYEE)
	 * @param where - where portion of a query (e.g. FName = 'Anne')
	 * @return ResultSet - returns a table for a given query; Use ResultSet.next() and ResultSet.get{DATATYPE}(int Column), where the DATATYPE is the datatype of a variable with its column number Column  
	 * @throws SQLException
	 */
	public ResultSet getData(String select, String from, String where) throws SQLException {
		
		return stmt.executeQuery("select " + select + " from " + from + " where " + where);
	}

	/**
	 * @param updateStatement - write any valid SQL update statement here (e.g. update EMPLOYEE set FName = 'Anne2' where FName = 'Anne')
	 * @throws SQLException
	 */
	public void updateData(String updateStatement) throws SQLException{
		
		stmt.executeUpdate(updateStatement);
	}
	
	/**
	 * @param update - update portion of a query (e.g. EMPLOYEE)
	 * @param set - set portion of a query (e.g. FName = 'Anne2')
	 * @param where - where portion of a query (e.g. FName = 'Anne')
	 * @throws SQLException
	 */
	public void updateData(String update, String set, String where) throws SQLException{
		
		stmt.executeUpdate("update " + update + " set " + set + " where " + where);
	}
	
	/**
	 * Do not forget to close the connection with your database when you are done using it!
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException{ 
	
		con.close(); 
	}

}
