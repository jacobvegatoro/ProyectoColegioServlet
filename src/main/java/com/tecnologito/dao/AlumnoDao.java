package com.tecnologito.dao;

import java.util.List;

import com.tecnologito.modelo.Alumno;

public interface AlumnoDao {

	public Alumno buscarAlumno(int id);
	public List<Alumno> listarAlumnos();
	public Alumno agregarAlumno(Alumno alumno);
	public Alumno modificarAlumno(Alumno alumno);
	public boolean eliminarAlumno(int id);
	public int obtenerUltimoId();
	
}
