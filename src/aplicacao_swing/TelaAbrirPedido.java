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

public class TelaAbrirPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAbrirPedido frame = new TelaAbrirPedido();
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
	public TelaAbrirPedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Abertura de Pedido");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(103, 11, 319, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(23, 103, 120, 29);
		contentPane.add(lblNewLabel_1);
		
		txt = new JTextField();
		txt.setBounds(138, 103, 202, 30);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JButton btnAbrirPedido = new JButton("Abrir Pedido");
		btnAbrirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(txt.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Telefone é obrigatório" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					
					else {
						String telefone = txt.getText();
						Pedido p = Fachada.abrirPedido(telefone);
						
						if(p != null) {
							JOptionPane.showMessageDialog(null, "Pedido aberto -> Pedido nº  " + p.getId(), "Confirmação", JOptionPane.DEFAULT_OPTION);
						}
					}
					
					
					txt.setText("");
					txt.requestFocus();	
				}
				
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
				
				
				
			}
		});
		btnAbrirPedido.setBounds(62, 203, 134, 30);
		contentPane.add(btnAbrirPedido);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(232, 203, 134, 30);
		contentPane.add(btnNewButton);
	}

}
