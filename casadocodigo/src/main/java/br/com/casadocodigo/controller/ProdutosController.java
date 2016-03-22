package br.com.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDao produtos;

	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView mv = new ModelAndView("produtos/form");
		mv.addObject("tipos",TipoPreco.values());
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String gravar(Produto produto){
		System.out.println(produto);
		
		produtos.salvar(produto);
		
		return "produtos/ok";
	}
	
	@RequestMapping( method= RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("produtos/lista");
		mv.addObject("produtos",produtos.listar());
		return mv;
	}
	

}
