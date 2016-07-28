package br.com.jservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
		{
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			boolean login = false;
			
					
			if (userid != null && password !=null)
			{
				
				
//				Statement stmt = dbConnection.createStatement();
//				ResultSet rs =	stmt.executeQuery("SELECT * FROM LOGIN WHERE ID='"+userid+"' AND PWD='"+password+"'");
//				if (rs.next())
//					login = true;
			}
			
			if (login)
			{
				//Setando o userid na sessão
				
				HttpSession session = request.getSession(true);
				
				session.setAttribute("userid", userid);	
				
							
				RequestDispatcher rd = request.getRequestDispatcher("Contato.html");
				
				rd.forward(request, response);
				
				return;
				
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				
				rd.forward(request, response);
				
				return;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
