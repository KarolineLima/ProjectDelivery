package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCancelarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txttel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelarPedido frame = new TelaCancelarPedido();
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
	public TelaCancelarPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancelar Pedido");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(118, 11, 302, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone do cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(25, 113, 218, 34);
		contentPane.add(lblNewLabel_1);
		
		txttel = new JTextField();
		txttel.setBounds(266, 113, 168, 34);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		JButton btnCancelamento = new JButton(" Realizar Cancelamento");
		btnCancelamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(txttel.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Telefone � obrigat�rio" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					
					else {
						String telefone = txttel.getText();
						Fachada.cancelarPedido(telefone);
						
						JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso ", "Confirma��o", JOptionPane.DEFAULT_OPTION);
					}					
					
					txttel.setText("");
					txttel.requestFocus();	
				}
				
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
				
			}
		});
		btnCancelamento.setBounds(51, 213, 168, 23);
		contentPane.add(btnCancelamento);
		
		JButton btnCancelarvoltar = new JButton("Cancelar/Voltar");
		btnCancelarvoltar.setBounds(256, 213, 164, 23);
		contentPane.add(btnCancelarvoltar);
	}

}
