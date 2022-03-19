package com.tecnologito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tecnologito.conexiondatabase.ConexionDatabase;
import com.tecnologito.modelo.Alumno;

public class AlumnoDaoImpl implements AlumnoDao  {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public Alumno buscarAlumno(int id) {
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return null;
		}
		
		String query = "SELECT * FROM alumno WHERE id_alumno = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			Alumno alumno = new Alumno();
			
			if (rs.next()) {
				alumno.setId(rs.getInt("id_alumno"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				alumno.setEdad(rs.getInt("edad"));
				alumno.setIdCurso(rs.getInt("curso_id"));
			}
			
			return alumno;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return new Alumno();
		}
	}

	@Override
	public List<Alumno> listarAlumnos() {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new ArrayList<Alumno>();
		}
		
		String query = "SELECT * FROM alumno;";
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			List<Alumno> lista = new ArrayList<>();
			
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id_alumno"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				alumno.setEdad(rs.getInt("edad"));
				alumno.setIdCurso(rs.getInt("curso_id"));
				lista.add(alumno);
			}
			
			return lista;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<Alumno>();
		}
	
	}
	
	@Override
	public Alumno agregarAlumno(Alumno alumno) {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new Alumno();
		}
		
		String query = "INSERT INTO alumno " 
				+ "(id_alumno, nombre, apellido, edad, curso_id) " 
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, alumno.getId());
			pstm.setString(2, alumno.getNombre());
			pstm.setString(3, alumno.getApellido());
			pstm.setInt(4, alumno.getEdad());
			pstm.setInt(5, alumno.getIdCurso());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return alumno;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return new Alumno();
	}
	
	@Override
	public Alumno modificarAlumno(Alumno alumno) {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new Alumno();
		}
		
		String query = "UPDATE alumno " 
				+ "SET nombre = ?, apellido = ?, edad = ?, curso_id = ? " 
				+ "WHERE id_alumno = ?;";
		
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, alumno.getNombre());
			pstm.setString(2, alumno.getApellido());
			pstm.setInt(3, alumno.getEdad());
			pstm.setInt(4, alumno.getIdCurso());
			pstm.setInt(5, alumno.getId());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return alumno;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return new Alumno();	
	
	}
	
	@Override
	public boolean eliminarAlumno(int id) {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return false;
		}
		
		String query = "DELETE FROM alumno " 
				+ "WHERE id_alumno = ?;";
		
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public int obtenerUltimoId() {

		conn = ConexionDatabase.obtenerConexion();
		
		int resultado = -1;
		
		if (conn == null) {
			return resultado;
		}
		
		String query = "SELECT MAX(id_alumno) as max_id " 
				+ "FROM producto;";
		
		try {
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getInt("max_id");
			}
			
			return resultado;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return resultado;
		}
	}

	
}
