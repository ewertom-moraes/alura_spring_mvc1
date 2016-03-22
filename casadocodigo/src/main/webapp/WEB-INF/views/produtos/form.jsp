<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Casa do Código</title>
</head>
<body>
	<form action="/casadocodigo/produtos" method="post">
		<div>
			<label>titulo</label>
			<input type="text" name="titulo">
		</div>
		<div>
			<label>descrição</label>
			<textarea name="descricao" rows="10" cols="100"></textarea>
		</div>
		<div>
			<label>paginas</label>
			<input type="text" name="paginas">
		</div>
		
		<div>
			<c:forEach items="tipos" var="tipoPreco" varStatus="status">
				<label>${tipoPreco}</label>
				 <input type="text" name="precos[${status.index}].valor">
                 <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
			</c:forEach>
		</div>
		
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>