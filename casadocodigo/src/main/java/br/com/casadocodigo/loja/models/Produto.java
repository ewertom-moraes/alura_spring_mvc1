package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Produto {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titulo;
	private String descricao;
	private int paginas;
	
	private Calendar dataLancamento;
	
	private String sumario;
	
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	@ElementCollection
	private List<Preco> preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public List<Preco> getPreco() {
		return preco;
	}
	public void setPreco(List<Preco> preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
	}
	
	
	
}
