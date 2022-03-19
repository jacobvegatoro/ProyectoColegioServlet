<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de alumnos</title>
	</head>
	<body>
		<div>
			<h1>Lista de alumnos</h1>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th>Curso</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${alumnos.size() == 0} }">
						<tr>
							<td colspan="6">No hay alumnos que mostrar</td>
						</tr>
					</c:if>
					<c:forEach items="${alumnos}" var="alumno">
						<tr>
							<td><c:out value="${alumno.getAlumno().getId()}" /></td>
							<td><c:out value="${alumno.getAlumno().getNombre()}" /></td>
							<td><c:out value="${alumno.getAlumno().getApellido()}" /></td>
							<td><c:out value="${alumno.getAlumno().getEdad()}" /></td>
							<td><c:out value="${alumno.getCurso().getNombre()}" /></td>
							<td>
								<a href="ModificarAlumno?id=${alumno.getAlumno().getId()}">Editar</a>
								&nbsp;
								<a href="EliminarAlumno?id=${alumno.getAlumno().getId()}">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="${pageContext.request.contextPath}">Volver</a>
		</div>
	</body>
</html>