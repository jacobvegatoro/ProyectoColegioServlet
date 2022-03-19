package com.tecnologito.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tecnologito.dao.AlumnoCursoDao;
import com.tecnologito.dao.AlumnoCursoDaoImpl;
import com.tecnologito.dto.AlumnoCurso;

/**
 * Servlet implementation class ListarAlumnos
 */
@WebServlet("/ListarAlumnos")
public class ListarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AlumnoCursoDao alumnoCursoDao = new AlumnoCursoDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AlumnoCurso> alumnos = alumnoCursoDao.listaAlumnosCurso();
		request.setAttribute("alumnos", alumnos);
		request.getRequestDispatcher("ListarAlumnos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
