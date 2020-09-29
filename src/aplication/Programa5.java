package aplication;
// deletar dados
// tratando exceção de integridade referencial
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Programa5 {

	public static void main(String[] args) {
	
		
		Connection conn = null;
		PreparedStatement st = null; 
        try {
        	conn = DB.getConnection();
        	
        	st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");

			st.setInt(1, 8);
			
        	int rowsAffectede = st.executeUpdate();
        	
        	System.out.println(" feito " + rowsAffectede);
        
        }
        catch(SQLException e) {
        	throw new DbIntegrityException(e.getMessage());
        }
        finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}    

}


