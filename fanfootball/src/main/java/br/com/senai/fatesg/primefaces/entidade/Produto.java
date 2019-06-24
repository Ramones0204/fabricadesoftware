package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto {
	@Id
	@GeneratedValue(generator = "produto_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1, initialValue = 1)
	private int codigo;
	private String tituloProduto;
	private String descProduto;
	private double preco;
	private String cor;
	@Lob
	private byte[] imagemProduto;
	@ManyToOne
	private Marca marca;
	@ManyToOne
	private Time time;
	@ManyToOne
	private TipoProduto tipoProduto;
	@Enumerated(EnumType.STRING)
	private Manga manga;
	@Enumerated(EnumType.STRING)
	private Gola gola;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	@Enumerated(EnumType.STRING)
	private OrigemProduto origemProduto;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Manga getManga() {
		return manga;
	}
	public void setManga(Manga manga) {
		this.manga = manga;
	}
	
	
	public String getTituloProduto() {
		return tituloProduto;
	}
	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public Gola getGola() {
		return gola;
	}
	public void setGola(Gola gola) {
		this.gola = gola;
	}
	public OrigemProduto getOrigemProduto() {
		return origemProduto;
	}
	public void setOrigemProduto(OrigemProduto origemProduto) {
		this.origemProduto = origemProduto;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public byte[] getImagem() {
		return imagemProduto;
	}
	public void setImagem(byte[] imagem) {
		this.imagemProduto = imagem;
	}
	
	
	
	
	
	
	
	

}
