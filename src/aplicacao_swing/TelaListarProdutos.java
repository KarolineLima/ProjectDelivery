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
import modelo.Pedido;
import modelo.Produto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaListarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnListar;
	private JLabel lblNewLabel;
	private JTextField txtprod;
	private JButton btnNewButton;

	
	public TelaListarProdutos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnListar.doClick();
			}
		});
		setTitle("Listar Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					if(!txtprod.getText().equals("")) {
						String produto = txtprod.getText();
						
						String texto;
						ArrayList<Produto> lista = Fachada.listarProdutos(produto);
						texto = "Lista de produtos: \n";
						if (lista.isEmpty())
							texto += "Produto não cadastrado \n";
						else 	
							for(Produto p: lista) 
								texto +=  p + "\n"; 

						textArea.setText(texto);  

									
					}
					else {
						String texto;
						ArrayList<Produto> lista = Fachada.listarProdutos();
						texto = "Lista de produtos: \n";
						if (lista.isEmpty())
							texto += "Não têm produtos cadastrados \n";
						else 	
							for(Produto p: lista) 
								texto +=  p + "\n"; 

						textArea.setText(texto);    
					
					 }	
				
					}
					catch(Exception e2){
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
					
	
			}
		});
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 66, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lblNewLabel = new JLabel("Produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 117, 32);
		contentPane.add(lblNewLabel);
		
		txtprod = new JTextField();
		txtprod.setBounds(98, 11, 145, 32);
		contentPane.add(txtprod);
		txtprod.setColumns(10);
		
		btnNewButton = new JButton("Pesquisar");
		
		btnNewButton.setBounds(263, 20, 89, 23);
		contentPane.add(btnNewButton);
	}
}