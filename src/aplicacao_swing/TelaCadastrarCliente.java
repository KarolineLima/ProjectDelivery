package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txttel;
	private JTextField txtnome;
	private JTextField txtemail;
	private JTextField txtresid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCliente frame = new TelaCadastrarCliente();
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
	public TelaCadastrarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastramentoDoCliente = new JLabel("Cadastramento do Cliente");
		lblCadastramentoDoCliente.setFont(new Font("Arial", Font.BOLD, 30));
		lblCadastramentoDoCliente.setBounds(98, 11, 382, 35);
		contentPane.add(lblCadastramentoDoCliente);
		
		txttel = new JTextField();
		txttel.setBounds(121, 78, 214, 30);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 78, 113, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 119, 76, 30);
		contentPane.add(lblNewLabel_1);
		
		txtnome = new JTextField();
		txtnome.setBounds(121, 119, 214, 30);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(10, 160, 76, 30);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(121, 160, 214, 30);
		contentPane.add(txtemail);	
		
	
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  
			}
		});
		btnNewButton.setBounds(248, 257, 132, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Endere\u00E7o:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(10, 201, 106, 30);
		contentPane.add(label);
		
		txtresid = new JTextField();
		txtresid.setBounds(121, 201, 214, 30);
		contentPane.add(txtresid);
		txtresid.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(txttel.getText().equals("")||txtnome.getText().equals("")||txtemail.getText().equals("")||txtresid.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String telefone = txttel.getText();
						String nome = txtnome.getText();
						String email = txtemail.getText();
						String endereco = txtresid.getText();
						
						Cliente cli = Fachada.cadastrarCliente(telefone, nome, email, endereco);
						if(cli != null) {
							JOptionPane.showMessageDialog(null, "Cliente " + cli.getNome()+ " cadastrado com sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION);
						}
					}
					
					txttel.setText("");
					txttel.requestFocus();
					
					txtnome.setText("");
					txtnome.requestFocus();
					
					txtemail.setText("");
					txtemail.requestFocus();
					
					txtresid.setText("");
					txtresid.requestFocus();	
				}
				
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
					
				}
			}
		);
		btnCadastrar.setBounds(78, 257, 113, 23);
		contentPane.add(btnCadastrar);
	}
	
	
}
