package br.com.jservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jservlets.dao.ProdutoDAO;
import br.com.jservlets.model.Produto;

@WebServlet("/PesquisarServlet")
public class PesquisarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Produto> lista = new ArrayList<>();
		ProdutoDAO dao = new ProdutoDAO();
		String nome = req.getParameter("nome");
		
		dao.beginTransaction();
		lista = dao.findByProduto(nome);
		dao.commitAndCloseTransaction();
		req.setAttribute("lista", lista);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pesquisarProdutos.jsp");
		rd.forward(req, res);
	}

}
