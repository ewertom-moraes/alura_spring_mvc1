package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDao produtos;

	@RequestMapping("/produtos/form")
	public String form(){
		System.out.println("entrou no metodo form");
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto){
		System.out.println(produto);
		
		produtos.salvar(produto);
		
		return "produtos/ok";
	}

}
