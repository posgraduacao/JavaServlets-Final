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

@WebServlet("/EditarServlet")
public class EditarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Produto p = new Produto();
		ProdutoDAO dao = new ProdutoDAO();
		String action = req.getParameter("id");
		
		try {
			dao.beginTransaction();
			p = dao.find(Integer.parseInt(action));
			dao.commitAndCloseTransaction();
			
			req.setAttribute("p", p);
			
			RequestDispatcher rd = req.getRequestDispatcher("editarProduto.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			e.printStackTrace();
		}
		
	}
}
