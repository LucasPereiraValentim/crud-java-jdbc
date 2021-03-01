package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conecao.com.banco.ConexaoPostgreSql;
import model.Cliente;
import model.ClientePedido;
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
			
			System.out.println("Cliente cadastrado com sucesso");
			
			
			
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
			
			System.out.println("Pedido cadastrado com sucesso");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public List<ClientePedido> getFazerJoin(){
		List<ClientePedido> listClientesPedidos = new ArrayList<ClientePedido>();
		try {
		
		
		
		
		String sql = "SELECT cpf, nome, telefone, codigo, sabor_pizza, tipo_refrigerante FROM cliente as cliente "
				+ "INNER JOIN pedido as pedido ON pedido.cpf_cliente = cliente.cpf";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet query = preparedStatement.executeQuery();
		
		
		while (query.next()) {
			
			ClientePedido clientePedido = new ClientePedido();
			
			clientePedido.setCpf(query.getString("cpf"));
			clientePedido.setNome(query.getString("nome"));
			clientePedido.setTelefone(query.getString("telefone"));
			clientePedido.setCodigo(query.getString("codigo"));
			clientePedido.setSaborPizza(query.getString("sabor_pizza"));
			clientePedido.setTipoRefrigerante(query.getString("tipo_refrigerante"));
			
			listClientesPedidos.add(clientePedido);
			
			
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listClientesPedidos;
	}
	
	
	public void deletarTupla(String cpfCliente) {
		try {
			String sqlPedido = "DELETE FROM pedido WHERE cpf_cliente = '" + cpfCliente + "'";
			String sqlCliente = "DELETE FROM cliente WHERE cpf = '" + cpfCliente + "'";
			
			
			PreparedStatement statement = connection.prepareStatement(sqlPedido);
			
			statement.executeUpdate();
			
			connection.commit();
			
			
			
			statement = connection.prepareStatement(sqlCliente);
			
			statement.executeUpdate();
			
			connection.commit();
			
			
			System.out.println("Registro deletado com sucesso");
			
			
			
			
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
