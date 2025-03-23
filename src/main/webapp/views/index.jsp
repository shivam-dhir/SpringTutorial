<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	Hello ${name} !!!
	
	<form action="add">
		Enter ID : <input name="gameId" type="text"><br>
		Enter Name : <input name="gameName" type="text"><br>
		Enter Metascore : <input name="metascore" type="text"><br>
		<input value="Add Game" type="submit">
	</form>
	
	<hr>
	
	<form action="getGame">
		Enter ID: <input name="gameId" type="text"><br>
		<input value="Get Game" type="submit">
	</form>
	
</body>
</html>