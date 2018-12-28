<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

<div class="container">
<br>
<li><a href="${s:mvcUrl('UC#form').build() }" rel="nofollow"><fmt:message key="menu.cadastro_usuario"/></a></li>
		<h1><fmt:message key="lista.usuarios"/></h1>
			
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="usuario.nome"/></th>
				<th><fmt:message key="usuario.email"/></th>
				<th><fmt:message key="usuario.roles"/></th>
				<th><fmt:message key="usuario.alterar.roles"/></th>
				
			</tr>
 			<c:forEach items="${usuario}" var="usuario"> 	
			<tr> 
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td><c:forEach items="${usuario.roles}" var="roles">
						${roles.nome},
					</c:forEach></td>
					<td><button type="submit" value="${usuario}" ><a href="${s:mvcUrl('UC#alterar').arg(0, usuario.id).build() }"/>
					<fmt:message key="usuario.alterar"/></button></td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
				
</tags:pageTemplate>
