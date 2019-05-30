package modelo;
import java.util.ArrayList;



public class Cliente {
	private String telefone;
	private String nome;
	private String email;
	private String endereco;
	private ArrayList<Pedido> pedidos= new ArrayList<>();
	
	
	public Cliente(String telefone, String nome,String email, String endereco) {
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Cliente(String telefone) {
		this.telefone = telefone;
	}
	

	
	
	// ----------------Getters/Setters---------------------//	
	
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	//---------------Relacionamento--------------//
	
	

	//Cliente -> Pedido
	public void adicionar(Pedido p) {
		pedidos.add(p);
	}
	
	
	
	public void remover(Pedido p) {
		pedidos.remove(p);
	}
	

	public Pedido localizar(int id) {
		for(Pedido ped: pedidos) {
			if(ped.getId() == id) {
				return ped;
			}
		}
		return null;
	}
	
	//--------------Métodos-------//
	
	public Pedido isOpen() {
		for(Pedido ped: pedidos) {
			if(!ped.isFechado()) {
				return ped;
			}
		}
		return null;
	}
	
	// -------- ToString ------- //
	

	public String toString() {
		return "Cliente [telefone = " + telefone + ", nome = " + nome + ", email = " + email + ", endereco = " + endereco
				+ ", pedidos = " + pedidos + "]";
	}
	
	
	
	
	
	
	
}
