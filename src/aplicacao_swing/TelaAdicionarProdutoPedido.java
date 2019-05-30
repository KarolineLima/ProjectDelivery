package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  TelaAdicionarProdutoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txttel;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarProdutoPedido frame = new TelaAdicionarProdutoPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdicionarProdutoPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdicionarProdutoAo = new JLabel("Adicionar Produto ao Pedido");
		lblAdicionarProdutoAo.setFont(new Font("Arial", Font.BOLD, 30));
		lblAdicionarProdutoAo.setBounds(58, 11, 414, 35);
		contentPane.add(lblAdicionarProdutoAo);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(28, 84, 119, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdDoPedido = new JLabel("Id do produto:");
		lblIdDoPedido.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIdDoPedido.setBounds(28, 137, 173, 29);
		contentPane.add(lblIdDoPedido);
		
		txttel = new JTextField();
		txttel.setBounds(198, 84, 208, 35);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(198, 143, 208, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(txttel.getText().equals("")||txtid.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String telefone = txttel.getText();
						Integer id = Integer.parseInt(txtid.getText());
						
						Fachada.adicionarProdutoPedido(telefone, id);
						JOptionPane.showMessageDialog(null, "Produto foi adicionado ao pedido com sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION);						
					}
					txttel.setText("");
					txttel.requestFocus();
					
					txtid.setText("");
					txtid.requestFocus();
					
				}	
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
			}});
		btnAdicionar.setBounds(105, 237, 97, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(301, 237, 108, 23);
		contentPane.add(btnNewButton);
	}

}
