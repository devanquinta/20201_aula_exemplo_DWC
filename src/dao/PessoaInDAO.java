package dao;

import java.sql.SQLException;

import model.Pessoa;

public interface PessoaInDAO {

	void Inserir(Pessoa _objeto) throws SQLException;
}
