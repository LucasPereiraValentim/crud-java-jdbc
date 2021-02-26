package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conecao.com.banco.ConexaoPostgreSql;
import model.Cliente;
import model.Pedido;

public class PizzariaDAO {
	private Connection connection;
	
	public PizzariaDAO() {
		connection = ConexaoPostgreSql.getConnection();
	}
	
	
	public void inserirCliente(Cliente cliente) {
		try {
			
			String sql = "INSERT INTO cliente (cpf, nome, telefone) VALUES(?, ?, ?)";
			PreparedStatement insertCliente = connection.prepareStatement(sql);
			insertCliente.setString(1, cliente.getCpf());
			insertCliente.setString(2, cliente.getNome());
			insertCliente.setString(3, cliente.getTelefone());
			
			insertCliente.execute();
			
			connection.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void inserirPedido(Pedido pedido) {
		try {
			
			String Sql = "INSERT INTO pedido (sabor_pizza, tipo_refrigerante, cpf_cliente) VALUES(?, ?, ?)";
			PreparedStatement inserirPedido = connection.prepareStatement(Sql);
			
			inserirPedido.setString(1, pedido.getSaborPizza());
			inserirPedido.setString(2, pedido.getTipoRefrigerante());
			inserirPedido.setString(3, pedido.getCpfCliente());
			
			inserirPedido.execute();
			
			connection.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	
}
