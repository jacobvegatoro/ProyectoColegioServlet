package com.tecnologito.dao;

import java.util.List;

import com.tecnologito.modelo.Curso;

public interface CursoDao {

	public Curso buscarCurso(int id);
	public List<Curso> listarCursos();
	
}
