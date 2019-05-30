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

public class TelaFecharPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtent;
	private JTextField txttel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFecharPedido frame = new TelaFecharPedido();
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
	public TelaFecharPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechamentoDoPedido = new JLabel("Fechamento do Pedido");
		lblFechamentoDoPedido.setFont(new Font("Arial", Font.BOLD, 30));
		lblFechamentoDoPedido.setBounds(66, 25, 341, 35);
		contentPane.add(lblFechamentoDoPedido);
		
		JLabel lblNewLabel = new JLabel("Telefone do cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(21, 116, 229, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do entregador:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(21, 169, 229, 29);
		contentPane.add(lblNewLabel_1);
		
		txtent = new JTextField();
		txtent.setBounds(260, 169, 197, 29);
		contentPane.add(txtent);
		txtent.setColumns(10);
		
		txttel = new JTextField();
		txttel.setBounds(260, 116, 197, 29);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				try {
					if(txttel.getText().equals("")||txtent.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					
					else {
						String telefone = txttel.getText();
						String entregador = txtent.getText();
						
						Fachada.fecharPedido(telefone, entregador);
						
						JOptionPane.showMessageDialog(null, "Pedido fechado com sucesso ", "Confirmação", JOptionPane.DEFAULT_OPTION);
					}
					
					txttel.setText("");
					txttel.requestFocus();
					
					txtent.setText("");
					txtent.requestFocus();
				}
				
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
			}
		});
		btnNewButton.setBounds(87, 233, 112, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(239, 233, 112, 29);
		contentPane.add(btnNewButton_1);
	}

}
