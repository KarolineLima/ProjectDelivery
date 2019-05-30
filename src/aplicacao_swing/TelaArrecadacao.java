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

public class TelaArrecadacao extends JFrame {

	private JPanel contentPane;
	private JTextField txtdia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaArrecadacao frame = new TelaArrecadacao();
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
	public TelaArrecadacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrecadao = new JLabel("Arrecada\u00E7\u00E3o");
		lblArrecadao.setFont(new Font("Arial", Font.BOLD, 30));
		lblArrecadao.setBounds(135, 23, 290, 28);
		contentPane.add(lblArrecadao);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDia.setBounds(27, 97, 81, 28);
		contentPane.add(lblDia);
		
		txtdia = new JTextField();
		txtdia.setBounds(117, 97, 184, 28);
		contentPane.add(txtdia);
		txtdia.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				try {
					if(txtdia.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informação obrigatória" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						Integer dia = Integer.parseInt(txtdia.getText());
						
						double arrecadacao = Fachada.calcularArrecadacao(dia);
						JOptionPane.showMessageDialog(null, "Arrecadação do dia: " + arrecadacao, "Retorno", JOptionPane.DEFAULT_OPTION);						
					}
					txtdia.setText("");
					txtdia.requestFocus();
				}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
				
				
			}
		});
		btnCalcular.setBounds(68, 157, 106, 28);
		contentPane.add(btnCalcular);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(213, 157, 118, 25);
		contentPane.add(btnCancelar);
	}

}
