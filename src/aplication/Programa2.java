package aplication;
//recuperar dados
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Programa2 {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
		conn = DB.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery("select * from seller");
		
		while(rs.next()) {
			System.out.println(rs.getString("email") +"--" + rs.getString("name"));
		}
		
	} catch ( SQLException e) {
		e.printStackTrace();
	}
     finally {
    	 DB.closeResultSet(rs);
    	 DB.closeStatement(st);
    	 DB.closeConnection();
     }
  }
}