package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textnome;
	private JTextField txtpreco;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProduto frame = new TelaCadastrarProduto();
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
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textnome = new JTextField();
		textnome.setBounds(90, 128, 286, 31);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 128, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblCadasgramentoDeProduto = new JLabel("Cadastramento de Produto");
		lblCadasgramentoDeProduto.setFont(new Font("Arial", Font.BOLD, 30));
		lblCadasgramentoDeProduto.setBounds(49, 51, 413, 31);
		contentPane.add(lblCadasgramentoDeProduto);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 212, 74, 31);
		contentPane.add(lblNewLabel_1);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(90, 218, 286, 31);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(textnome.getText().equals("")||txtpreco.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informação obrigatória" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String nome = textnome.getText();
						double preco = Double.parseDouble(txtpreco.getText());
						
						Produto prod = Fachada.cadastrarProduto(nome, preco);
						if(prod != null) {
							JOptionPane.showMessageDialog(null, "Produto " + prod.getId()+ " cadastrado com sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION);
						}

					}
					textnome.setText("");
					textnome.requestFocus();
					
					txtpreco.setText("");
					txtpreco.requestFocus();

			}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
			}
			}
		);
		
		
		
		btnCadastrar.setBounds(49, 308, 135, 31);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(247, 308, 129, 31);
		contentPane.add(btnCancelar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
}
