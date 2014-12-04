package fr.miage.coo.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkingsDBConnection {

	public static Connection connexion;

	public static void main(String[] args) throws SQLException {
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bdd/Markings;shutdown=true", "user", "user");
		PreparedStatement st = connexion.prepareStatement("select * from Student");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
		connexion.close();
	}

}
