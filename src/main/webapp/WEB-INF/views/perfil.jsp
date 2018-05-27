<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil</title>
</head>
<body>
  <div>
        <h1>Informacion personal</h1>
        <p>Username: </p>
        <p> ${user.username}</p>
    </div>
    <div>
        <h1>Informacion medica</h1>


        <p>Grupo sanguineo: </p>
        <p >${user.grupoSanguineo}</p>
        <p>Alergias: </p>
        <p> ${user.alergias}</p>
        <p>Peso:</p>
           <p >${user.peso}</p>
        <p>Edad:  </p>
         <p >${user.edad}</p>
        <p>Altura: </p>
        <p >${user.altura}</p>
    </div>
    <button onclick="window.location.href='/miHistorial/perfil/editarInformacionMedica'">Informacion Medica</button>

</body>
</html>