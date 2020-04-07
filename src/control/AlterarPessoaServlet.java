package control;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class AlterarPessoaServlet
 */
@WebServlet("/AlterarPessoaServlet")
public class AlterarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarPessoaServlet() {
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
			Integer id = Integer.parseInt(request.getParameter("id"));
    		
    		Pessoa p = dao.buscarPorId(id);
    		
    		request.setAttribute("id", p.getId());
    		request.setAttribute("nome", p.getNome());
    		request.setAttribute("email", p.getEmail());
    		
    		//String msg = "Cadastro achado com sucesso!";
    		//request.setAttribute("msg", msg);
    		RequestDispatcher despachante = request.getRequestDispatcher("/alterarPessoa.jsp");
    		
    		despachante.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/alterarPessoa.jsp?msg=ERRO NA APLICAÇÂO!!!");
	        rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			System.out.println("executando.....");
			
			Pessoa pessoa = new Pessoa();
			int id = Integer.parseInt(request.getParameter("id"));
			pessoa.setId(id);
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setEmail(request.getParameter("email"));
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			dao.Atualizar(pessoa);
			
			String msg = "Cadastro alterado com sucesso!";
    		request.setAttribute("msg", msg);
    		RequestDispatcher despachante = request.getRequestDispatcher("/ListarPessoaServlet");
    		
    		despachante.forward(request, response);
    		
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/alterarPessoa.jsp?msg=ERRO NA APLICAÇÂO!!!");
	        rd.forward(request, response);
		}
	}

}
