<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mi Historia Medica</title>
<script>
</script>
</head>
<body>
	<h1>Mostrar Registro</h1>
	<a href="#" onclick="HTMLtoPDF()">Download PDF</a>
	<script src="js/jspdf.js"></script>
	<script src="js/jquery-2.1.3.js"></script>
	<script src="js/pdfFromHTML.js"></script>
	<form action="/miHistorial" method="get">
		<button type="submit">Volver</button>
	</form>
	<p>Titulo:</p>
	<p>${registroMedico.titulo}</p>
	<p>Descripcion:</p>
	<p>${registroMedico.descripcion}</p>
	<p>Fecha:</p>
	<p>${registroMedico.fecha}</p>
	<p>Categoria:</p>
	<p>${registroMedico.categoria.nombre}</p>

	<p>Fotos</p>
	<table>
		<thead>
			<tr>
				<th>Foto</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fotos}" var="foto">
				<tr>
					<td><img src="data:image/jpeg;base64,${foto.def}" width="500" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Observaciones</p>
	<table>
		<thead>
			<tr>
				<th>Observacion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registroMedico.observacionList}" var="ob">
				<tr>
					<td>${ob.descripcion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form action="/registroMedico/pdfreport/${registroMedico.id}">
		<button type="submit">PDF</button>
	</form>
</body>
</html>