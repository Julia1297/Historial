<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informacion Medica</title>
</head>
<body>
<h1>Ingrese la siguiente informacion</h1>
<form action=" "
      method="post">
    <input type="hidden" name="id" value="${user.id}"/>

    <div>
        <label>Grupo sanguineo: </label>
        <input  name="grupoSanguineo" type="text" value="${user.grupoSanguineo}" placeholder="Ingrese su grupo sanguineo" required/>
    </div>

    <div>
        <label>Alergias: </label>
        <input  name="alergias" type="text" value="${user.alergias}" placeholder="Ingrese sus alergias" />
    </div>

    <div>
        <label>Peso: </label>
        <input  name="peso" type="text" value="${user.peso}" placeholder="Ingrese su peso"  required/>
    </div>

    <div>
        <label>Altura: </label>
        <input  name="altura"  type="text" value="${user.altura}" placeholder="Ingrese su  altura" required/>
    </div>

    <div>
        <label>Edad: </label>
        <input  name="edad" type="text" value="${user.edad}" placeholder="Ingrese su edad" required/>
    </div>

    <button type="submit" value="Guardar">Enviar</button>
</form>
</body>
</html>