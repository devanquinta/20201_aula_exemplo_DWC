package model;

public class Endereco {

	private int id;
	private String logradouro;
	private String bairro;
	private String estado;
	private String cidade;
	
	//private Pessoa pessoa;
	
	public Endereco() {}
	
	public Endereco(int id, String logradouro, String bairro, String estado, String cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Logradouro:" + logradouro + ", " + bairro + ", " + cidade + " / " + estado;
	}
}
