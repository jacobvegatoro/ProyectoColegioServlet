package com.tecnologito.conexiondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDatabase {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/colegio?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conexion = null;
	
	private static void crearConexion() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection obtenerConexion() {
		if (conexion == null) {
			crearConexion();
		}
		
		return conexion;
	}
	
}
