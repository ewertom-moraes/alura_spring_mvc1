<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Casa do Código</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Descricao</th>
				<th>Paginas</th>
				<th>Precos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="p">
				<tr>
					<td>${p.titulo}</td>
					<td>${p.descricao}</td>
					<td>${p.paginas}</td>
					<td>
<%-- 						<c:forEach items="${p.preco}" var="preco"> --%>
<%-- 							<span>${preco.valor}</span> --%>
<%-- 						</c:forEach> --%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>