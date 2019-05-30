package repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Restaurante {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private TreeMap<String,Cliente> clientes = new TreeMap<>();
	
	
	// ----------------Getters/Setters---------------------//
	public ArrayList<Produto> getProdutos() {
		produtos.sort((new Comparator<Produto>() {
			public int compare(Produto produto,Produto outroProduto) {
				return produto.getNome().compareTo(outroProduto.getNome());	
			}
			
			}));
		return produtos;
	}



	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}



	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}



	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public TreeMap<String, Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(TreeMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}


	//---------------Relacionamento--------------//
	
	// Restaurante -> Cliente
		

	public void adicionarCliente(Cliente cli) {
		clientes.put(cli.getTelefone(),cli);
	}
				
	public void removerCliente(Cliente cli) {
		clientes.remove(cli.getTelefone(),cli);
	}
		
	public Cliente localizarCliente(String telefone) {
		for(Cliente cli: clientes.values()) {
			if(cli.getTelefone().equals(telefone)) {
				return cli;
			}
		}
		return null;	
	}
	

	//Restaurante -> Pedido
	
	public void adicionarPedido(Pedido p) {
		pedidos.add(p);
	}
	
	
	public void removerPedido(Pedido p) {
		pedidos.remove(p);
	}
	
	public Pedido localizarPedido(int id) {
		for(Pedido p: pedidos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;	
		
	}	
		

	//Restaurante -> Produto
	
	public void adicionarProduto(Produto p) {
		produtos.add(p);
	}

	public void removerProduto(Produto p) {
		produtos.remove(p);
	}	
		
	public Produto localizarProduto(String nome) {
		for(Produto p: produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;	
	}
	
	public Produto localizarProduto(int id) {
		for(Produto p: produtos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;	
	}
	

	
	
	// -------- ToString ------- //
	
	public String toString() {
		return "Restaurante [produtos=" + produtos + ", pedidos=" + pedidos + ", clientes=" + clientes + "]";
	}

	
}
