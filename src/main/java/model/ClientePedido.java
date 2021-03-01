package model;

public class ClientePedido {
	private String cpf;
	private String nome;
	private String telefone;
	private String codigo;
	private String saborPizza;
	private String tipoRefrigerante;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getSaborPizza() {
		return saborPizza;
	}
	public void setSaborPizza(String saborPizza) {
		this.saborPizza = saborPizza;
	}
	public String getTipoRefrigerante() {
		return tipoRefrigerante;
	}
	public void setTipoRefrigerante(String tipoRefrigerante) {
		this.tipoRefrigerante = tipoRefrigerante;
	}
	
	
	
	
	@Override
	public String toString() {
		return "CPF: " + cpf + " | Nome: " + nome + " | Telefone: " + telefone + " | Código do pedido: " + codigo
				+ " | Sabor da pizza: " + saborPizza + " | Tipo do refrigerante: " + tipoRefrigerante;
	}
	
	
	
	
	
	
}
