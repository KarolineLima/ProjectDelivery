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

public class TelaConsultarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txttel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarPedido frame = new TelaConsultarPedido();
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
	public TelaConsultarPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar Pedido");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(119, 21, 262, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(23, 115, 131, 29);
		contentPane.add(lblNewLabel_1);
		
		txttel = new JTextField();
		txttel.setBounds(181, 115, 183, 29);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				try {
					if(txttel.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					
					else {
						String telefone = txttel.getText();
						
						
						Pedido ped = Fachada.consultarPedido(telefone);
						JOptionPane.showMessageDialog(null, "Pedido: " + ped, "Retorno", JOptionPane.DEFAULT_OPTION);						
					}
					txttel.setText("");
					txttel.requestFocus();
					
					
				}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
			}
		});
		btnConsultar.setBounds(87, 250, 111, 29);
		contentPane.add(btnConsultar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(250, 250, 114, 29);
		contentPane.add(btnCancelar);
	}

}
