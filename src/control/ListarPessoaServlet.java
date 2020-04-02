package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FabricaConexao;
import dao.PessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class ListarPessoaServlet
 */
@WebServlet("/ListarPessoaServlet")
public class ListarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			List<Pessoa> listaPessoas = dao.listarTodos();
			request.setAttribute("listaPessoas", listaPessoas);
			
			RequestDispatcher despachante = request.getRequestDispatcher("/listarPessoas.jsp");
			despachante.forward(request, response);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/listarPessoas.jsp?msg=ERRO NA APLICAÇÂO!!!");
	        rd.forward(request, response);
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
