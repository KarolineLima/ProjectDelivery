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

public class TelaExcluirPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirPedido frame = new TelaExcluirPedido();
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
	public TelaExcluirPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExcluirPedido = new JLabel("Excluir Pedido");
		lblExcluirPedido.setFont(new Font("Arial", Font.BOLD, 30));
		lblExcluirPedido.setBounds(186, 22, 258, 35);
		contentPane.add(lblExcluirPedido);
		
		JLabel lblNewLabel = new JLabel("Id do pedido:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(27, 92, 151, 29);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setBounds(199, 92, 174, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				try {
					if(txtid.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Id do pedido é obrigatório" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					
					else {
						Integer id = Integer.parseInt(txtid.getText());
						Fachada.excluirPedido(id);
						
						JOptionPane.showMessageDialog(null, "Pedido excluido com sucesso ", "Confirmação", JOptionPane.DEFAULT_OPTION);
					}
					
					txtid.setText("");
					txtid.requestFocus();
				}
				
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(27, 164, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(168, 164, 121, 23);
		contentPane.add(btnNewButton_1);
	}

}
