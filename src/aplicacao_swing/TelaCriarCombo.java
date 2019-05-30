package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Combo;
import modelo.Produto;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaCriarCombo extends JFrame {

	private JPanel contentPane;
	private JTextField txtids;
	private JTextField txtnome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarCombo frame = new TelaCriarCombo();
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
	public TelaCriarCombo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIds = new JLabel("Id's:");
		lblIds.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIds.setBounds(23, 119, 67, 26);
		contentPane.add(lblIds);
		
		txtids = new JTextField();
		txtids.setBounds(187, 119, 176, 20);
		contentPane.add(txtids);
		txtids.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				try {
					if(txtids.equals("") || txtnome.equals("")) {
						JOptionPane.showMessageDialog(null,"Informações obrigatórias" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String nome = txtnome.getText();
						String ids = txtids.getText();
						ArrayList<Integer> lista = new ArrayList<>();
						Combo c1;
						
						String idsArray[] = ids.split(",");
						for(String i: idsArray) {
							lista.add(Integer.parseInt(i));
						}
						c1 = Fachada.criarCombo(nome, lista);
						JOptionPane.showMessageDialog(null,"Combo criado com sucesso!");
					}
				}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
			
				
			}
		});
		btnCriar.setBounds(144, 191, 125, 34);
		contentPane.add(btnCriar);
		
		JLabel lblNewLabel = new JLabel("Nome Combo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(23, 34, 165, 34);
		contentPane.add(lblNewLabel);
		
		txtnome = new JTextField();
		txtnome.setBounds(187, 47, 176, 21);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
	}
}
