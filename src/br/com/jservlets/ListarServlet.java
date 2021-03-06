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

@WebServlet("/ListarServlet")
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Produto> lista = new ArrayList<>();
		ProdutoDAO dao = new ProdutoDAO();
		dao.beginTransaction();
		lista = dao.lista();
		dao.commitAndCloseTransaction();
		request.setAttribute("lista", lista);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listarprodutos.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request, response);
	}
}
