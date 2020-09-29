package aplication;
// demo transações
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Programa6 {

	public static void main(String[] args) {
	
		
		
		Connection conn = null;
		Statement st = null; 
        try {
        	conn = DB.getConnection();
        	conn.setAutoCommit(false);
        	st = conn.createStatement();
        	
        	int rows1 = st.executeUpdate("Update seller Set BaseSalary = 2090 where DepartmentId = 1");
        	//int x =1;
        	//if(x < 2) {
        		//throw new SQLException(" Update error");
        	//}
        	int rows2= st.executeUpdate("Update seller Set BaseSalary = 3090 where DepartmentId = 2" );
        	
        	conn.commit();
        	
        	System.out.println("Rows --" + rows1);
            System.out.println("rows --" + rows2);
            
        	
        }
        catch(SQLException e) {
        	try {
        		conn.rollback();
        		throw new DbException("Rolled back :" +e.getMessage());
        	}
        	catch (SQLException e1) {
        		throw new DbException("Erro trying to rollback :" + e1.getMessage());
        	}
        }
        finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

		
		
	}

}
