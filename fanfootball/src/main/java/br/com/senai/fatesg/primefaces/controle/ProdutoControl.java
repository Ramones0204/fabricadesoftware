package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.senai.fatesg.primefaces.entidade.Gola;
import br.com.senai.fatesg.primefaces.entidade.Manga;
import br.com.senai.fatesg.primefaces.entidade.Marca;
import br.com.senai.fatesg.primefaces.entidade.OrigemProduto;
import br.com.senai.fatesg.primefaces.entidade.Produto;
import br.com.senai.fatesg.primefaces.entidade.Tamanho;
import br.com.senai.fatesg.primefaces.entidade.Time;
import br.com.senai.fatesg.primefaces.entidade.TipoProduto;
import br.com.senai.fatesg.primefaces.persistencia.MarcaDao;
import br.com.senai.fatesg.primefaces.persistencia.ProdutoDao;
import br.com.senai.fatesg.primefaces.persistencia.TimeDao;
import br.com.senai.fatesg.primefaces.persistencia.TipoProdutoDao;

@Named("ProdutoControl")
@Scope("conversation")
public class ProdutoControl {
	
	private Produto produto = new Produto();
	@Autowired
	private ProdutoDao produtoDao;
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Marca> marcas = new ArrayList<Marca>();
	private Marca marca = new Marca();
	@Autowired
	private MarcaDao marcaDao;
	private List<Time> times = new ArrayList<Time>();
	private Time time = new Time();
	@Autowired
	private TimeDao timeDao;
	private List<TipoProduto> tipoProdutos = new ArrayList<TipoProduto>();
	private TipoProduto tipoProduto= new TipoProduto();
	@Autowired
	private TipoProdutoDao tipoProdutoDao;
	
	@PostConstruct
	public void init() {
		listar(null);
		listarMarca(null);
		listarTime(null);
		listarTipoProduto(null);
	}
	
	
	public void confirmar(ActionEvent evt) {
		try {
			produto.setMarca(marca);
			produto.setTime(time);
			produto.setTipoProduto(tipoProduto);
			produtoDao.incluir(produto);
			listar(evt);
			produto = new Produto();
			UtilFaces.addMensagemFaces("Produto salvo com Sucesso ");
		} catch (Exception e) {
			// TODO: handle exception
			UtilFaces.addMensagemFaces(e.getMessage());
			System.out.println(e.getMessage());
			
		}
	}
	
	public void listar(ActionEvent evt) {
		try {
			produtos = produtoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar as marcas ");
		}
	}
	
	public void excluir(Produto produto) {
		try {
			produtoDao.excluirPorId(produto.getCodigo());
			UtilFaces.addMensagemFaces("Produto Excluido com sucesso");
			produtos = produtoDao.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void selecionarProdutosParaEdicao(Produto produto) {

		try {
			this.produto = produtoDao.consultar(produto.getCodigo());
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void listarMarca(ActionEvent evt) {
		try {
			marcas = marcaDao.listar();

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getMessage());
		}
	}

	public void listarTime(ActionEvent evt) {
		try {
			times = timeDao.listar();

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getMessage());
		}
	}
	
	public void listarTipoProduto(ActionEvent evt) {
		try {
			tipoProdutos = tipoProdutoDao.listar();

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getMessage());
		}
	}

	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}


	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	public Manga[] getMangas(){
		return Manga.values();
	}
	
	public Gola[] getGolas(){
		return Gola.values();
	}
	
	public Tamanho[] getTamanhos(){
		return Tamanho.values();
	}
	
	public OrigemProduto[] getOrigemProdutos(){
		return OrigemProduto.values();
	}


	public List<Marca> getMarcas() {
		return marcas;
	}


	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public MarcaDao getMarcaDao() {
		return marcaDao;
	}


	public void setMarcaDao(MarcaDao marcaDao) {
		this.marcaDao = marcaDao;
	}


	public List<Time> getTimes() {
		return times;
	}


	public void setTimes(List<Time> times) {
		this.times = times;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}


	public TimeDao getTimeDao() {
		return timeDao;
	}


	public void setTimeDao(TimeDao timeDao) {
		this.timeDao = timeDao;
	}


	public List<TipoProduto> getTipoProdutos() {
		return tipoProdutos;
	}


	public void setTipoProdutos(List<TipoProduto> tipoProdutos) {
		this.tipoProdutos = tipoProdutos;
	}


	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}


	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}


	public TipoProdutoDao getTipoProdutoDao() {
		return tipoProdutoDao;
	}


	public void setTipoProdutoDao(TipoProdutoDao tipoProdutoDao) {
		this.tipoProdutoDao = tipoProdutoDao;
	}
	
	
	
}
