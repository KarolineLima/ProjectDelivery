package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaListarPedidosCliente extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnListar;
	private JLabel lblNewLabel;
	private JTextField txttel;
	private JButton btnNewButton;

	
	public TelaListarPedidosCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnListar.doClick();
			}
		});
		setTitle("Listar pedidos do cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnListar = new JButton("Listar");
		
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(31, 66, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(10, 22, 120, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		txttel = new JTextField();
		txttel.setBounds(124, 22, 135, 20);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					if(txttel.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informação obrigatória" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String telefone = txttel.getText();
						
						String texto;
						ArrayList<Pedido> lista = Fachada.listarPedidos(telefone);
						texto = "Lista de pedidos: \n";
						if (lista.isEmpty())
							texto += "Cliente não possui pedidos cadastrados \n";
						else 	
							for(Pedido p: lista) 
								texto +=  p + "\n"; 

						textArea.setText(texto);
					}	
				
					}
					catch(Exception e2){
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}

			}
		});
		btnNewButton.setBounds(284, 22, 110, 23);
		contentPane.add(btnNewButton);
	}
}