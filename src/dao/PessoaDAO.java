package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Pessoa;

public class PessoaDAO implements PessoaInDAO {

	private Connection conexao;
	
	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		
		String SQL = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		
		ps.execute();
	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			
			EnderecoDAO daoEndereco = new EnderecoDAO(this.conexao);
			
			List<Endereco> enderecos = daoEndereco.listarTodosPorPessoa(id);
			
			Pessoa p = new Pessoa(id, nome, email, enderecos);
			
			pessoas.add(p);
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		
		String SQL = "DELETE FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		
		String SQL = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setInt(3, _objeto.getId());
				
		return ps.execute();
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			
			EnderecoDAO daoEndereco = new EnderecoDAO(this.conexao);
			
			List<Endereco> enderecos = daoEndereco.listarTodosPorPessoa(id);
			
			Pessoa p = new Pessoa(id, nome, email, enderecos);
			
			return p;
		}
		
		return null;
	}

}
