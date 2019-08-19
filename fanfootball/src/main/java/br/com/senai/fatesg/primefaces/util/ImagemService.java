package br.com.senai.fatesg.primefaces.util;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.sound.midi.Patch;


import antlr.StringUtils;

public class ImagemService implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	private Path diretorioRaiz;
	private Path diretorioRaizTemp;
	
	@PostConstruct
	void init() throws IOException {
		Path raizApp = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".fotoimagem");
		
		raizApp = raizApp.resolve("imagem-produto");
		diretorioRaizTemp = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fotos-temp");
		
		try {
			Files.createDirectories(diretorioRaiz);
			Files.createDirectories(diretorioRaizTemp);
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("Problemas ao tentar criar os diretorios", e);
		}
	}
	
	public String salvarFotoTemp(String nome, byte[] conteudo) throws IOException {
		String novoNome = renomearFoto(nome);
		Path fotoTemp = diretorioRaizTemp.resolve(novoNome);
		Files.write(fotoTemp, conteudo);
		return novoNome;
		
	}
	
	public String renomearFoto(String original) {
		return UUID.randomUUID().toString()  + "___" + original;
	}
	
	public void deletar(String nome) throws IOException {
		deletar(diretorioRaiz, nome);

	}
	
	public void deletarTemp(String nome) throws IOException {
		deletar(diretorioRaizTemp, nome);
		
	}
	
	private void deletar(Path raiz, String nome) throws IOException {
		if(org.apache.commons.lang.StringUtils.isEmpty(nome)) {
			return;
		}
		Path foto = raiz.resolve(nome);
		
		if(Files.exists(foto)) {
			Files.delete(foto);
		}
	}
	
	public void recuperarFotoTemp(String nome) throws IOException {
		if(org.apache.commons.lang.StringUtils.isEmpty(nome)) {
			return;
		}
		
		Path fotoTemp = diretorioRaizTemp.resolve(nome);
		if(!Files.exists(fotoTemp)) {
			return;
		}
		
		byte[] conteudo = Files.readAllBytes(fotoTemp);
		Path foto = diretorioRaiz.resolve(nome);
		Files.write(foto,conteudo);
		Files.delete(fotoTemp);
	}
	
	public byte[] recuperar(String nome) throws IOException {
		Path foto = diretorioRaizTemp.resolve(nome);
		if(Files.exists(foto)) {
			return Files.readAllBytes(foto);
		}
		
		foto = diretorioRaiz.resolve(nome);
		
		if(Files.exists(foto)) {
			return Files.readAllBytes(foto);
		}
		return null;
	}

}
