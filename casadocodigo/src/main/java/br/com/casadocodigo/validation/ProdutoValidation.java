package br.com.casadocodigo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator{

	@Override
	public boolean supports(Class<?> cls) {
		if(!Produto.class.isAssignableFrom(cls))
			return false;
		return true;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		Produto produto = (Produto) obj; 
		if(produto.getPaginas() <= 0){
			errors.rejectValue("paginas", "field.required");
		}
	}
}
