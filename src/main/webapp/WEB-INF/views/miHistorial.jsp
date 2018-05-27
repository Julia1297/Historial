<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mi Historia Medica</title>
</head>
<body>
	<form action="/logout">
		<button type="submit">Cerrar sesion</button>
	</form>
	<form action="/miHistorial/nuevoRegistro">
		<button type="submit">Nuevo registro</button>
	</form>
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" id="checkbox"></th>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Fecha</th>
				<th>Tipo</th>
				<th>Editar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user.registroMedicoList}" var="registro">
				<tr>
					<td><input type="checkbox"></td>
					<td>${registro.titulo}</td>
					<td><a href="/miHistorial/mostrarRegistro/${registro.id}">${registro.descripcion}</a></td>
					<td>${registro.fecha}</td>
					<td>${registro.categoria.nombre}</td>
					<td><a href="/miHistorial/editarRegistro/${registro.id}">Editar</a></td>
					<td><a href="/miHistorial/eliminarRegistro/${registro.id}" onclick="return confirm('Estas seguro que quieres eliminar este registro?');">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="/pdfreport">
		<button type="submit">PDF</button>
	</form>
	
</body>
</html>