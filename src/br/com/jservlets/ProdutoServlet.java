package br.com.jservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jservlets.dao.ProdutoDAO;
import br.com.jservlets.model.Produto;

@WebServlet("/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Produto p = new Produto();
		ProdutoDAO dao = new ProdutoDAO();

		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		String preco = req.getParameter("preco");
		String estoque = req.getParameter("estoque");

		p.setNome(nome);
		p.setDescricao(descricao);
		p.setPreco(Double.parseDouble(preco));
		p.setEstoque(Integer.parseInt(estoque));

		try {
			dao.beginTransaction();
			dao.save(p);
			dao.commitAndCloseTransaction();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListarServlet");
			rd.forward(req, res);
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			e.printStackTrace();
		}

	}

}
