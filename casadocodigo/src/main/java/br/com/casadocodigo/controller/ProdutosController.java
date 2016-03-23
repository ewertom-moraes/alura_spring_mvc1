package br.com.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.daos.ProdutoDao;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDao produtos;

	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb){
		wdb.addValidators(new ProdutoValidation());
	}
	
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto){
		ModelAndView mv = new ModelAndView("produtos/form");
		mv.addObject("tipos",TipoPreco.values());
		return mv;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("produtos/detalhe");
		Produto produto = produtos.find(id);
		mv.addObject("produto", produto);
		System.out.println(produto.getTitulo());
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView gravar(MultipartFile sumario,@Valid Produto produto, BindingResult binder, 
			RedirectAttributes red){
		
		if(binder.hasErrors()){
			return form(produto);
		}
		
		String path = fileSaver.write("/arquivos-sumarios", sumario);
		produto.setSumario(path);
		
		produtos.salvar(produto);
		red.addFlashAttribute("sucesso", "Produto Cadastrado com sucesso!");
		
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping( method= RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("produtos/lista");
		mv.addObject("produtos",produtos.listar());
		return mv;
	}
	

}
