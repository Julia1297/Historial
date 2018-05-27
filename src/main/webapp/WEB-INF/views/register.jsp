<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mi Historia Medica</title>
</head>
<body>
	<form action="/miHistorial" method="get">
		<button type="submit">Iniciar sesion</button>
	</form>
	<h2>Registration Form</h2>
	<form action="/registration" method="post">
		<div>
			<input name="username" type="email" placeholder="Email" required>
		</div>
		<div>
			<input name="password" type="password" placeholder="Password" required>
		</div>
		<div>
			<input name="passwordConfirm" type="password" placeholder="PasswordConfirm" required>
		</div>
		<div>
			<button type="submit">Registrarse</button>
		</div>
	</form>
</body>
</html>