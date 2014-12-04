package fr.miage.coo.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MarkingsDBConnection {

	public static Connection connexion;

	public static void main(String[] args) throws SQLException {
		connexion = DriverManager.getConnection("jdbc:hsqlbd:file:bdd/Markings;shutdown=true", "user", "user");
	}

}
