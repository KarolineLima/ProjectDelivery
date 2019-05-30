package modelo;

import java.util.ArrayList;

public class Produto {

	private int id;
	private String nome;
	private double preco;
	private ArrayList<Pedido>pedidos = new ArrayList<>();
	
	
	
	public Produto() {}
	
	public Produto( int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		
	}
	
		
	// ----------------Getters/Setters---------------------//
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	//Métodos
	public double getPreco() {
		return preco;
	}

	
	//---------------Relacionamento--------------//
	
	//Produto -> Pedido
	
	
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

	
	
	
	

	// -------- ToString ------- //
	
	
	public String toString() {
		return "Produto [id = " + id + ", nome = " + nome + ", preco = " + preco + "]";
	}
	

		
	
}
