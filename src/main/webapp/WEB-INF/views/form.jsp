<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
<div class="container" >

		<h1><fmt:message key = "menu.cadastro_usuario"/></h1>
		
		<p>${message}</p>
		<form:form action="${s:mvcUrl('UC#gravar').build()}" method="post" commandName="usuario">
			<div class="form-control" style="padding: 1%">
				<label><fmt:message key = "usuario.nome"/></label>
				<form:input path="nome" type="text" />
				<form:errors path="nome" />

			</div>
			<div class="form-control" style="padding: 1%">
		        <label><fmt:message key = "usuario.email"/></label>
				<form:input path="email" type="email"/>
				<form:errors path="email" />

			</div>
			<div class="form-control" style="padding: 1%">
				<label><fmt:message key = "usuario.senha"/></label>
				<form:input path="senha" type="password" />
				<form:errors path="senha" />

			</div>
			<div class="form-control" style="padding: 1%">
				<label><fmt:message key = "usuario.confirmar.senha"/></label>
				<form:input path="confirmarSenha" type="password" />
				<form:errors path="confirmarSenha" />
			</div>
		<button type="submit" class="btn btn-primary" style="padding: 1%"><fmt:message key="usuario.botao"/></button>
		</form:form>
	</div>
	
</tags:pageTemplate>


