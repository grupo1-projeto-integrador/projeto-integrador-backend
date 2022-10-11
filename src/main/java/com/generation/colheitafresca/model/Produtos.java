package com.generation.colheitafresca.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")

public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal valor;

	@NotBlank
	@Size(min = 0)
	private String kg; // para valores que serão alterados colocamos FLOAT ou STRING ?

	@NotBlank
	@Size(min = 0) 
	private String estoque; // para valores que serão alterados colocamos FLOAT ou STRING ?

	private String imagem; // qual @ é utilizado para imagens ?

	@ManyToOne
	@JsonIgnoreProperties("Produtos")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("Produtos")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getKg() {
		return kg;
	}

	public void setKg(String kg) {
		this.kg = kg;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
