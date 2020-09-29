package aplication;
// atualizando dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

// up date
public class Programa4 {

	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null; 
        try {
        	conn = DB.getConnection();
        	
        	st = conn.prepareStatement(
        			"UPDATE seller"
        			+" set BaseSalary = BaseSalary + ?"
        			+"Where"
        			+"(DepartmentId = ?)");
        	st.setDouble(1, 200.0);
        	st.setInt(2, 2);
        	
        	int rowsAffectede = st.executeUpdate();
        	System.out.println(" feito " + rowsAffectede);
        	
        	
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
        finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}    

}
