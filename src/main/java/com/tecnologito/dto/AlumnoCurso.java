package com.tecnologito.dto;

import com.tecnologito.modelo.Alumno;
import com.tecnologito.modelo.Curso;

public class AlumnoCurso {

	private Alumno alumno;
	private Curso curso;
	
	public AlumnoCurso() {
		super();
	}
	
	public AlumnoCurso(Alumno alumno, Curso curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
