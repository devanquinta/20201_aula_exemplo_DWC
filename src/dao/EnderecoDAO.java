package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoDAO implements EnderecoInDAO {

	private Connection conexao;
	
	public EnderecoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Endereco> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Endereco> listarTodosPorPessoa(int _idPessoa) throws SQLException {
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, logradouro, bairro, estado, cidade FROM endereco WHERE pessoa_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idPessoa);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String logradouro = rs.getString(2);
			String bairro = rs.getString(3);
			String estado = rs.getString(4);
			String cidade = rs.getString(5);
			
			Endereco end = new Endereco(id, logradouro, bairro, estado, cidade);
			
			enderecos.add(end);
		}
		
		return enderecos;
	}

}
