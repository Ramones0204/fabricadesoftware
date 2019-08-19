package br.com.senai.fatesg.primefaces.util;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/produto-imagem")
public class ImagemServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Inject
	private ImagemService imagemService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		byte[] bytes = imagemService.recuperar(nome);
		resp.setContentType("image/*");
		resp.setContentLength(bytes.length);
		resp.getOutputStream().write(bytes);
		resp.getOutputStream().flush();
	}
}
