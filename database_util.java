package InterfaceGraphique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseUtil// Classe contenant toutes les methodes communiquant avec la DB
{
	static public int addUser(String nom, String prenom, String mail, String ID, String PassWord) throws SQLException, ClassNotFoundException {
		Connection conn = databaseUtil.getConn();// Toujours appeler le get connection au debut de chaque method
		String insert_query = "INSERT INTO user_app (UserFirstName, Employee_last_name, Employee_emailID) values ('"+ nom +"','"+ prenom +"','"+ PassWord +"');";
	    System.out.format(insert_query);
		Statement st = conn.createStatement();
		try {
			st.executeUpdate(insert_query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      st.close();
		return 0;
	}
	
	static public int printdatabase() throws SQLException, ClassNotFoundException {
		Connection conn = databaseUtil.getConn();
        Statement st = conn.createStatement();
        String query = "SELECT * FROM tblEmployee;";
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	        String firstName = rs.getString("Employee_last_name");  
	        // print the results
	        System.out.format("%s\n", firstName);
	      }
	      st.close();
		return 0;
	}

	static public Connection getConn() throws ClassNotFoundException, SQLException {
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/melvin";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
		return conn;
	}
	
	
	static public int aaaaaa() throws ClassNotFoundException, SQLException {
		Connection conn = databaseUtil.getConn();
		Statement st = conn.createStatement();
        String query = "SELECT * FROM tblEmployee;";
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	        String firstName = rs.getString("Employee_last_name");  
	        // print the results
	        System.out.format("%s\n", firstName);
	      }
	     st.close();
		return 0;
	}
	
	
	
  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection

      //JavaMysqlSelectExample.printdatabase(conn);
      //JavaMysqlSelectExample.addUser("tutu", "titi", conn);
      //System.out.format("__________\n");
      //JavaMysqlSelectExample.printdatabase(conn);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}
