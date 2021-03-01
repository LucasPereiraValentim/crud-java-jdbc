package projeto_cadastro_de_pizzaria.projeto_cadastro_de_pizzaria;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.PizzariaDAO;
import model.Cliente;
import model.ClientePedido;
import model.Pedido;

public class App {
	public static void main(String[] args) {
		String login = JOptionPane.showInputDialog("Bem-vindo ao sistema de cadastramento de pedidos",
				"Digite seu login");
		String senha = JOptionPane.showInputDialog("Bem-vindo ao sistema de cadastramento de pedidos",
				"Digite sua senha");

		if (login.equals("admin") && senha.equals("admin")) {

			String menuOpcao = JOptionPane
					.showInputDialog("1. Cadastrar cliente e pedido\n2. Visualizar Pedidos Cadastrados");

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

				

			} else if (menuOpcao.equals("2")) {
				try {
					PizzariaDAO dao = new PizzariaDAO();
					
					List<ClientePedido> list = dao.getFazerJoin();
					
					System.out.println("Pedidos Cadastrados");
					for (ClientePedido clienteP : list) {
						System.out.println(clienteP.toString());
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						
					}
					
					Scanner scan = new Scanner(System.in);
					
					System.out.println("Deseja deletar algum pedido? (1. Sim) (2. Não)");
					int opcaoMenu1 = scan.nextInt();
					
					if (opcaoMenu1 == 1) {
						String deletarRegistro = JOptionPane.showInputDialog(null, "Digite o CPF do registro para excluir");
						dao.deletarTupla(deletarRegistro);
					} else {
						System.exit(0);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Acesso negado");
		}

	}
}
