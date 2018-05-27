<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mi Historia Medica</title>
</head>
<body>
	<form action="/registration" method="get">
		<div>
			<button type="submit">Registrarse</button>
		</div>
	</form>
	<h1>Login</h1>
	<form action="/login" method="post">
		<div>
			<input name="username" type="email" placeholder="Email" required>
		</div>
		<div>
			<input name="password" type="password" placeholder="Password" required>
		</div>
		<div>
			<button type="submit">Iniciar sesion</button>
		</div>
	</form>
</body>
</html>