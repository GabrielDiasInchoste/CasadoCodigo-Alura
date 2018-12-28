<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate
	titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<div class="container">
		<br>
		<form:form action="${s:mvcUrl('UC#gravarRole').arg(0, usuario.id).build()}" method="post" modelAttribute="rolesList">
			<table class="table table-bordered table-striped table-hover">
				<h1>
					<fmt:message key="usuario.alterar" /> ${usuario.nome}<br>
						<c:forEach items="${usuario.roles}" var="roles"> 	
					${roles.nome}
					</c:forEach>
				</h1>
						<td>
						<fmt:message key = "role.admin"/>
							<form:checkbox path="rolesList"  value='ROLE_ADMIN' />
						</td>
						<td>
						<fmt:message key = "role.user"/>
							<form:checkbox path="rolesList"  value='ROLE_USER' />
						</td>
						<td>
							<fmt:message key = "role.comercial"/>
							<form:checkbox path="rolesList" value="ROLE_COMERCIAL"/>
						</td>
						<td>
						<button type="submit" class="btn btn-primary"><fmt:message key="usuario.alterar"/></button>
						</td>
			</table>
		</form:form>
	</div>
</tags:pageTemplate>
