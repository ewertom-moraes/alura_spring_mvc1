<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Casa do Código</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" 
	commandName="produto" enctype="multipart/form-data">
		<div>
			<label>titulo</label>
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label>descrição</label>
			<textarea name="descricao" rows="10" cols="100"></textarea>
			<form:errors path="descricao" />
		</div>
		<div>
			<label>paginas</label>
			<form:input path="paginas" />
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data Lançamento</label>
			<form:input path="dataLancamento" />
			<form:errors path="dataLancamento" />
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label> 
                <form:input
                    path="preco[${status.index}].valor" />
                 <form:input type="hidden"
                    path="preco[${status.index}].tipo" value="${tipoPreco}" />
            </div>
        </c:forEach>
		
		<div>
			<label>Sumario</label>
			<input type="file" name="sumario" id="sumario"/>
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>