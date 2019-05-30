package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

import repositorio.Restaurante;




public class Pedido {

	private int id;
	private LocalDate data;
	private double total;
	private String entregador;
	private boolean fechado = false;
	private ArrayList<Produto>produtos = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido() {
		
	}
	
	public Pedido(int id, Cliente cliente) {
		this.id = id;
		this.cliente = cliente;
		this.data = LocalDate.now();
	}



	// ----------------Getters/Setters---------------------//
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}


	public String getEntregador() {
		return entregador;
	}


	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}


	public boolean isFechado() {
		return fechado;
	}


	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}

	
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}


	//---------------Relacionamentos--------------//
	
		//Pedido -> Cliente
		public Cliente getCliente() {
			return cliente;
		}


		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


		//Pedido -> Produto
		public void adicionar(Produto p) {
			produtos.add(p);
		}
		
		
		
		public void remover(Produto p) {
			produtos.remove(p);
		}
		
		
		
		public Produto localizar(String nome) {
			for(Produto p: produtos) {
				if(p.getNome().equals(nome)) {
					return p;
				}
			}
			return null;	
		}

	
	
		
		// -------- ToString ------- //

		@Override
		public String toString() {
			return " Pedido [id = " + id + ", data = " + data + ", total = " + total + ", entregador = " + entregador
					+ ", produtos = " + produtos + "]";
		}


	
	
}
