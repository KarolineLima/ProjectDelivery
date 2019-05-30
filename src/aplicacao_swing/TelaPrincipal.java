package aplicacao_swing;

import fachada.Fachada;
import modelo.Pedido;
import modelo.Cliente;
import modelo.Produto;
import modelo.Combo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Delivery");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				JOptionPane.showMessageDialog(null,"Bem Vindo");
				try {
					//Pré - cadastro

					Cliente cli1, cli2; 
					cli1 = Fachada.cadastrarCliente("111", "Manuel",  "manuel@gmail.com", "Manaira");
					cli2 = Fachada.cadastrarCliente("222", "Patricia",  "patricia@gmail.com","Cabo Branco");

					Produto p1,p2,p3,p4,p5;
					p1 = Fachada.cadastrarProduto("Sanduiche natural",4.50);
					p2 = Fachada.cadastrarProduto("Batata frita",6.00);
					p3 = Fachada.cadastrarProduto("Refrigerante",6.00);
					p4 = Fachada.cadastrarProduto("Pizza",20.00);
					p5 = Fachada.cadastrarProduto("Salgado",4.00);

					ArrayList<Integer> ids = new ArrayList<>();
					ids.add(p3.getId());
					ids.add(p4.getId());
					
					Combo c1, c2;				
					c1 = Fachada.criarCombo("Dia de pizza",ids);
					
					ids.clear();
					ids.add(p2.getId());
					ids.add(p3.getId());
					c2 = Fachada.criarCombo("Dia do salgado",ids);

				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Volte Sempre!");
			}

		});

		frame.setBounds(100, 100, 612, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel imagem = new JLabel("");
		imagem.setBounds(0, 0, 596, 349);

		ImageIcon image = new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagem_delivery.png"));
		Image img = image.getImage().getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_SMOOTH);
		imagem.setIcon(new ImageIcon(img));

		frame.getContentPane().add(imagem);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnPodutos = new JMenu("Produtos");
		menuBar.add(mnPodutos);

		JCheckBoxMenuItem chckbxmntmListar_1 = new JCheckBoxMenuItem("Listar");
		chckbxmntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarProdutos t = new TelaListarProdutos();
				t.setVisible(true);
			}
		});
		mnPodutos.add(chckbxmntmListar_1);

		JCheckBoxMenuItem chckbxmntmAdd_1 = new JCheckBoxMenuItem("Add");
		chckbxmntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarProduto t = new TelaCadastrarProduto();
				t.setVisible(true);
			}
		});
		mnPodutos.add(chckbxmntmAdd_1);

		JMenu mnNewMenu = new JMenu("Clientes");
		menuBar.add(mnNewMenu);

		JMenu mnListar = new JMenu("Listar");
		mnNewMenu.add(mnListar);

		JCheckBoxMenuItem chckbxmntmClientes = new JCheckBoxMenuItem("Clientes");
		chckbxmntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarClientes t = new TelaListarClientes();
				t.setVisible(true);

			}
		});
		mnListar.add(chckbxmntmClientes);

		JCheckBoxMenuItem chckbxmntmPedidos = new JCheckBoxMenuItem("Pedidos");
		chckbxmntmPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPedidosCliente t = new TelaListarPedidosCliente();
				t.setVisible(true);
			}
		});
		mnListar.add(chckbxmntmPedidos);

		JCheckBoxMenuItem chckbxmntmAdd = new JCheckBoxMenuItem("Add");
		chckbxmntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarCliente t = new TelaCadastrarCliente();
				t.setVisible(true);
			}
		});
		mnNewMenu.add(chckbxmntmAdd);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JCheckBoxMenuItem chckbxmntmListar = new JCheckBoxMenuItem("Listar");
		chckbxmntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPedidos t = new TelaListarPedidos();
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmListar);

		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Add");
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAbrirPedido t = new TelaAbrirPedido();
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmNewCheckItem);

		JCheckBoxMenuItem chckbxmntmConsultar = new JCheckBoxMenuItem("Consultar");
		chckbxmntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarPedido t = new TelaConsultarPedido();
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmConsultar);

		JCheckBoxMenuItem chckbxmntmCancelar = new JCheckBoxMenuItem("Cancelar");
		chckbxmntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelarPedido t = new TelaCancelarPedido();
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmCancelar);

		JCheckBoxMenuItem chckbxmntmFechar = new JCheckBoxMenuItem("Fechar");
		chckbxmntmFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFecharPedido t = new TelaFecharPedido(); 
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmFechar);

		JMenu mnProduto = new JMenu("Produto");
		mnPedido.add(mnProduto);

		JCheckBoxMenuItem chckbxmntmAddProduto = new JCheckBoxMenuItem("Add Produto");
		chckbxmntmAddProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarProdutoPedido t = new TelaAdicionarProdutoPedido();
				t.setVisible(true);
			}
		});
		mnProduto.add(chckbxmntmAddProduto);

		JCheckBoxMenuItem chckbxmntmRetirarProduto = new JCheckBoxMenuItem("Retirar Produto");
		chckbxmntmRetirarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRetirarProdutoPedido t = new TelaRetirarProdutoPedido();
				t.setVisible(true);
			}
		});
		mnProduto.add(chckbxmntmRetirarProduto);

		JCheckBoxMenuItem chckbxmntmExcluir = new JCheckBoxMenuItem("Excluir");
		chckbxmntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExcluirPedido t = new TelaExcluirPedido();
				t.setVisible(true);
			}
		});
		mnPedido.add(chckbxmntmExcluir);

		JMenu mnCombo = new JMenu("Combo");
		menuBar.add(mnCombo);

		JCheckBoxMenuItem chckbxmntmCria = new JCheckBoxMenuItem("Criar");
		chckbxmntmCria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarCombo t = new TelaCriarCombo();
				t.setVisible(true);

			}
		});
		mnCombo.add(chckbxmntmCria);

	}	
}
