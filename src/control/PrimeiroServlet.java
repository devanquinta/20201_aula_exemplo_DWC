package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FabricaConexao;
import dao.PessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/PrimeiroServlet")
public class PrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			FabricaConexao fab = new FabricaConexao();
			
			Connection conn = fab.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conn);
			
			Pessoa p = dao.buscarPorId(1);
			
			PrintWriter out = response.getWriter();

		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Primeiro Servlet</title>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<h1>Oi mundo Servlet!</h1>");
		    out.println("<h2>Cadastro de Pessoa</h2>");
		    out.println("<p>ID: " + p.getId() + "</p>");
		    out.println("<p>Nome: " + p.getNome() + "</p>");
		    out.println("<p>E-mail: " + p.getEmail() + "</p>");
		    out.println("</body>");
		    out.println("</html>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
