package com.tecnologito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tecnologito.conexiondatabase.ConexionDatabase;
import com.tecnologito.modelo.Curso;

public class CursoDaoImpl implements CursoDao {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public Curso buscarCurso(int id) {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return null;
		}
		
		String query = "SELECT * FROM curso WHERE id_curso = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			Curso curso = new Curso();
			
			if (rs.next()) {
				curso.setId(rs.getInt("id_curso"));
				curso.setNombre(rs.getString("nombre_curso"));
			}
			
			return curso;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<Curso> listarCursos() {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return null;
		}
		
		String query = "SELECT * FROM curso";
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			List<Curso> lista = new ArrayList<>();
			
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id_curso"));
				curso.setNombre(rs.getString("nombre_curso"));
				lista.add(curso);
			}
			
			return lista;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
