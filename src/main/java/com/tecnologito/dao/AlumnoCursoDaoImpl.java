package com.tecnologito.dao;

import java.util.ArrayList;
import java.util.List;

import com.tecnologito.dto.AlumnoCurso;
import com.tecnologito.modelo.Alumno;
import com.tecnologito.modelo.Curso;

public class AlumnoCursoDaoImpl implements AlumnoCursoDao {

	private AlumnoDao alumnoDao = new AlumnoDaoImpl();
	private CursoDao cursoDao = new CursoDaoImpl();
	
	@Override
	public List<AlumnoCurso> listaAlumnosCurso() {
		
		List<AlumnoCurso> lista = new ArrayList<>();
		List<Alumno> alumnos = alumnoDao.listarAlumnos();
		
		for (Alumno a: alumnos) {
			AlumnoCurso ac = new AlumnoCurso();
			
			Curso c = cursoDao.buscarCurso(a.getIdCurso());
			ac.setAlumno(a);
			ac.setCurso(c);
			
			lista.add(ac);
		}
		
		return lista;
	}
}
