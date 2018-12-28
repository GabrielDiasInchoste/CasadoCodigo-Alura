<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

<div class="container">
		<h1><fmt:message key="lista_pedidos_atuais"/></h1>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="lista.id"/></th>
				<th><fmt:message key="lista.data_pedido"/></th>
				<th><fmt:message key="lista.valor_pedido"/></th>
				<th><fmt:message key="lista.titulo_pedido"/></th> 
			</tr>
			
			
			
 			<c:forEach items="${order}" var="order"> 	
			<tr> 
					<td>${order.id}</td>
					<td>${order.valor}</td>
					<td><fmt:formatDate value="${order.data.time}" pattern="yy/MM/dd"/></td>

					<td><c:forEach items="${order.produtos}" var="produtos">
						${produtos.titulo},
					</c:forEach></td>
			</tr>
			</c:forEach>
			
		</table>
	</div>

</tags:pageTemplate>
