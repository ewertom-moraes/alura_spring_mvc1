package br.com.casadocodigo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDao {

	@PersistenceContext
	EntityManager em;
	
	public void salvar(Produto produto){
		em.persist(produto);
	}
	
	public List<Produto> listar(){
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}
}
