<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Novo cadastro de pessoa</title>
</head>
<body>
	<div align="right" style="width: 300px; padding-left: 50px; padding-top: 100px;">
	<p align="center">Form Novo Cadastro</p>
	<form action="InserirPessoaServlet" method="post">
		<fieldset>
			
			<label>Nome:</label>
			<input type="text" name="nome" />
			<br />
			<label>E-mail:</label>
			<input type="text" name="email" />
			<br />
			<input type="submit" value="Salvar" />
			<br />
		</fieldset>
	</form>
	
	</div>
	<br />
	<br />
	<br />
	<br />
	<a href="index.jsp">Home Page</a>
</body>
</html>