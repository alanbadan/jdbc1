package aplication;

import java.sql.Connection;

import db.DB;
// obtendo conexão
public class Programa {

	public static void main(String[] args) {

            Connection conn = DB.getConnection();
            DB.closeConnection();

	}

}
