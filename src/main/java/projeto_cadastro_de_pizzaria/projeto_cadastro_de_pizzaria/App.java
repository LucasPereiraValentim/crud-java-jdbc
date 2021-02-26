package projeto_cadastro_de_pizzaria.projeto_cadastro_de_pizzaria;

import javax.swing.JOptionPane;

import dao.PizzariaDAO;
import model.Cliente;
import model.Pedido;

public class App {
    public static void main( String[] args ){
    	String login = JOptionPane.showInputDialog("Bem-vindo ao sistema de cadastramento de pedidos", "Digite seu login");
    	String senha = JOptionPane.showInputDialog("Bem-vindo ao sistema de cadastramento de pedidos", "Digite sua senha");
    	
    	
    	if (login.equals("admin") && senha.equals("admin")) {
    		
    		String menuOpcao = JOptionPane.showInputDialog("1. Cadastrar cliente e pedido\n2. Visualizar Pedido Cadastrados");
    		
    		if (menuOpcao.equals("1")) {
    			PizzariaDAO dao = new PizzariaDAO();
    			
    			Cliente cliente = new Cliente();
    			
    			cliente.setCpf(JOptionPane.showInputDialog("Digite o CPF do Cliente"));
    			cliente.setNome(JOptionPane.showInputDialog("Digite o nome do cliente"));
    			cliente.setTelefone(JOptionPane.showInputDialog("Digite o telefone do cliente"));
    			
    			dao.inserirCliente(cliente);
    			
    			
    			Pedido pedido = new Pedido();
    			
    			pedido.setSaborPizza(JOptionPane.showInputDialog("Digite o sabor da pizza"));
    			pedido.setTipoRefrigerante(JOptionPane.showInputDialog("Digite o sabor do refrigerante"));
    			pedido.setCpfCliente(cliente.getCpf());
    			
    			dao.inserirPedido(pedido);
    			
    			JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso");
    			
    			
    			
    		}
    		
    		
    	}
    
    }
}
