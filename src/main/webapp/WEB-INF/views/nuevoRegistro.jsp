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
	<h1>Nuevo Registro</h1>
	<form action="/miHistorial/registro" method="post" enctype="multipart/form-data">
		<div>
			<label>Titulo</label>
			<input name="titulo" type="text" placeholder="Titulo" required>
		</div>
		<div>
			<label>Descripcion</label>
			<input name="descripcion" type="text" placeholder="Descripcion" required>
		</div>
		<div>
			<label>Fecha</label>
			<input name="fecha" type="date" required>
		</div>
		<div>
			<label>Tipo</label>
			<select name="categoria">
			<c:forEach items="${categorias}" var="categori">
				<option value="${categori.id}">${categori.nombre}</option>			
			</c:forEach>
			</select>
		</div>
		<div>
			<input name="file" type="file" multiple="multiple">
		</div>
		<div>
			<button type="submit">Registrar registro</button>
		</div>
	</form>
</body>
</html>