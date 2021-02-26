package model;

public class Pedido {
	private Long codigo;
	private String saborPizza;
	private String tipoRefrigerante;
	private String cpfCliente;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	
	
	
}
