package br.com.jservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jservlets.dao.ProdutoDAO;
import br.com.jservlets.model.Produto;

/**
 * Servlet implementation class AdicionaProduto
 */
@WebServlet("/AdicionaProduto")
public class AdicionaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaProduto() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if (action.equals("Gravar")) {
			// pegando os parâmetros do request
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String preco = request.getParameter("preco");
			String estoque = request.getParameter("estoque");

			Produto p = new Produto();
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPreco(Double.parseDouble(preco));
			p.setEstoque(Integer.parseInt(estoque));

			out.println("<html>");
			out.println("<body>");

			ProdutoDAO dao = new ProdutoDAO();
			try {
				dao.beginTransaction();
				dao.save(p);
				dao.commitAndCloseTransaction();
				
				out.println("Produto " + p.getNome() + " adicionado com sucesso");
			} catch (Exception e) {
				dao.rollbackAndCloseTransaction();
				out.println("Problemas no adicionamento do produto, contate o administrador");
				e.printStackTrace();
			}

			out.println("</body>");
			out.println("</html>");
		}
	}

}
