<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mi Historia Medica</title>
</head>
<body>
	<form action="/miHistorial" method="get">
		<button type="submit">Volver</button>
	</form>
	<h1>Editar Registro</h1>
	<form action="/miHistorial/registro" method="post" enctype="multipart/form-data">
		<div>
			<input name="id" type="hidden" value="${registro.id}">
		</div>
		<div>
			<label>Titulo</label> <input name="titulo" type="text"
				placeholder="Titulo" value="${registro.titulo}" required>
		</div>
		<div>
			<label>Descripcion</label> <input name="descripcion" type="text"
				placeholder="Descripcion" value="${registro.descripcion}" required>
		</div>
		<div>
			<label>Fecha</label> <input name="fecha" type="date"
				value="${registro.fecha}" required>
		</div>
		<div>
			<input name="categoria" type="hidden"
				value="${registro.categoria.id}">
		</div>
		<div>
			<input name="file" type="file" multiple="multiple">
		</div>
		<div>
			<button type="submit">Confirmar cambios</button>
		</div>
	</form>

	<p>Fotos</p>
	<table>
		<thead>
			<tr>
				<th>Foto</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fotos}" var="foto">
				<tr>
					<td><img src="data:image/jpeg;base64,${foto.def}" width="500" /></td>
					<td><a href="/miHistorial/eliminarFoto/${foto.id}"
						onclick="return confirm('Estas seguro que quieres eliminar esta foto?');">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="/miHistorial/agregarObservacion" method="post">
		<div>
			<input name="descripcion" type="text" required>
		</div>
		<div>
			<button type="submit">Guardar observacion</button>
		</div>


	</form>
	<p>Observaciones</p>
	<table>
		<thead>
			<tr>
				<th>Observacion</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registro.observacionList}" var="ob">
				<tr>
					<td>${ob.descripcion}</td>
					<td><a href="/miHistorial/eliminarObservacion/${ob.id}"
						onclick="return confirm('Estas seguro que quieres eliminar esta observacion?');">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>