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

public class TelaRetirarProdutoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField txttel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRetirarProdutoPedido frame = new TelaRetirarProdutoPedido();
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
	public TelaRetirarProdutoPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverProdutoDo = new JLabel("Remover Produto do Pedido");
		lblRemoverProdutoDo.setFont(new Font("Arial", Font.BOLD, 30));
		lblRemoverProdutoDo.setBounds(66, 21, 426, 23);
		contentPane.add(lblRemoverProdutoDo);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(26, 77, 130, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id do produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(26, 124, 159, 29);
		contentPane.add(lblNewLabel_1);
		
		textid = new JTextField();
		textid.setBounds(182, 124, 174, 29);
		contentPane.add(textid);
		textid.setColumns(10);
		
		txttel = new JTextField();
		txttel.setBounds(182, 77, 174, 29);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(txttel.getText().equals("")||textid.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String telefone = txttel.getText();
						Integer id = Integer.parseInt(textid.getText());
						
						
						Fachada.removerProdutoPedido(telefone, id);
						JOptionPane.showMessageDialog(null, "Produto foi removido do pedido com sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION);						
					}
					
					txttel.setText("");
					txttel.requestFocus();
					
					textid.setText("");
					textid.requestFocus();
	
				}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnRemover.setBounds(112, 250, 117, 29);
		contentPane.add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(265, 250, 130, 29);
		contentPane.add(btnCancelar);
	}

}
