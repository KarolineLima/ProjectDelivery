package fachada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.List;

import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {

	public static Restaurante restaurante = new Restaurante();
	public static int idpedido = 0;
	public static int idproduto = 0;
	public static int idcombo = 0;
	// ----------------Getters/Setters---------------------//
	
	public static Restaurante getRestaurante() {
		return restaurante;
	}

	public static void setRestaurante(Restaurante restaurante) {
		Fachada.restaurante = restaurante;
	}

	public static int getIdpedido() {
		return idpedido;
	}

	public static void setIdpedido(int idpedido) {
		Fachada.idpedido = idpedido;
	}
	
	
	
	
	
	//--------------------Métodos--------------------------//
	
	
	
	//Listagem
	
	public static ArrayList<Produto> listarProdutos(){
		return restaurante.getProdutos();
	}
	
	public static ArrayList<Produto> listarProdutos(String nome){
		ArrayList<Produto> prod = new ArrayList<>();
		
		for(Produto p: restaurante.getProdutos()) {
			if(p.getNome().contains(nome.toLowerCase())){
				prod.add(p);
			}
		}
		return prod;
	}
	
	
	public static TreeMap<String, Cliente> listarClientes() {
		return restaurante.getClientes();
	}
	
	public static ArrayList<Pedido> listarPedidos(){
		return restaurante.getPedidos();
	}
	
	
	public static ArrayList<Pedido> listarPedidos(String telefone) throws Exception{
		Cliente cli = restaurante.localizarCliente(telefone);
		
		if(cli == null) {
			throw new Exception("Cliente não cadastrado");
		}

		ArrayList<Pedido> ped = restaurante.getPedidos();
		ArrayList<Pedido> aux = new ArrayList<>();
		
		
		for(Pedido p : ped) {
			if(p.getCliente().getTelefone().equals(telefone)){
				aux.add(p);
			}
		}
		return aux;		
		
	}
	
	
 	
	//Cadastro
	
	public static Produto cadastrarProduto(String nome, double preco) throws Exception{
		Produto p = restaurante.localizarProduto(nome);
		if(p != null){
		 throw new Exception ("Cadastrar Produto: Produto já está cadastrado ->" + nome);	
		}
		
		idproduto ++;		
		p = new Produto(idproduto,nome,preco);
		restaurante.adicionarProduto(p);
		return p;
	}
	
	
	public static Cliente cadastrarCliente(String telefone, String nome,String email, String endereco) throws Exception {
		Cliente cli = restaurante.localizarCliente(telefone);
		if(cli != null) {
			throw new Exception("Cadastrar Cliente: Cliente já está cadastrado");
		}
		cli = new Cliente(telefone,nome,email,endereco);
		restaurante.adicionarCliente(cli);
		return cli;

	}
	
	
	
	//Abertura de Pedido
	public static Pedido abrirPedido(String telefone) throws Exception {
		Cliente cliente = restaurante.localizarCliente(telefone);
		if(cliente == null) {
			throw new Exception("Abrir pedido -> Cliente não está cadastrado");
		}
		Pedido ped = cliente.isOpen();
		if(ped != null) {
			throw new Exception("Abrir pedido -> Cliente possui pedido aberto");
		}
		
		idpedido ++ ;
		Pedido p = new Pedido(idpedido,cliente);
		restaurante.adicionarPedido(p);
		cliente.adicionar(p);
        return p;	
     }
		
		

	//Consulta 
	
	public static Pedido consultarPedido(String telefone_cliente) throws Exception {
		
		Cliente cli = restaurante.localizarCliente(telefone_cliente);
		if(cli == null) {
			throw new Exception("Cliente não cadastrado");
		}
		
		Pedido ped = cli.isOpen();
		if(ped == null) {
			throw new Exception("Cliente " + cli + "não possui pedido aberto");
		}
		
		return ped;
	}
	
	
	
	
	
	//Adição de produto no pedido
	public static void adicionarProdutoPedido(String telefone_cliente, int id_produto) throws Exception{
		Cliente cli = restaurante.localizarCliente(telefone_cliente);
		if(cli == null) {
			throw new Exception("Adicionar produto ao pedido -> Cliente não cadastrado");
		}   
		
		
		Pedido ped = cli.isOpen();
		if(ped == null) {
			throw new Exception("Adicionar produto ao pedido -> Não existe pedido aberto do cliente");
		}
		
		
		Produto prod = restaurante.localizarProduto(id_produto);
		if(prod == null) {
			throw new Exception("Adicionar produto ao pedido -> Produto não cadastrado");	
		}
				
		ped.adicionar(prod);
		prod.adicionar(ped);
	}
	  
	
	//Remoção do produto do pedido
	public static void removerProdutoPedido(String telefone_cliente, int id_produto) throws Exception{
		
		Cliente cli = restaurante.localizarCliente(telefone_cliente);
		if(cli == null) {
			throw new Exception("Remover produto -> Cliente não cadastrado");
		}   
		
		
		Pedido ped = cli.isOpen();
		if(ped == null) {
			throw new Exception("Adicionar produto ao pedido -> Não existe pedido aberto do cliente");
		}
		
		
		Produto produto = restaurante.localizarProduto(id_produto);
		
		if(produto == null) {
			throw new Exception("Remover produto ao pedido -> Produto não cadastrado");
		}
		
		
		ped.remover(produto);
		produto.remover(ped);
		
	}
	
	
	//Cancelamento do Pedido
	public static void cancelarPedido( String telefone) throws Exception{
		
		Cliente cli = restaurante.localizarCliente(telefone);
		if(cli == null) {
			throw new Exception("Cancelar pedido -> Cliente não cadastrado");
		}
		
		Pedido ped = cli.isOpen();
		if(ped == null) {
			throw new Exception("Cancelar pedido -> Cliente não possui pedido aberto");
		}
		
		for(Produto prod : ped.getProdutos()) {
			prod.remover(ped);
		}
		
		cli.remover(ped);
		restaurante.removerPedido(ped);		
	}
	

	//Fechamento do Pedido
	public static void fecharPedido(String telefone, String nome_entregador) throws Exception {
		
		Cliente cli = restaurante.localizarCliente(telefone);
		if(cli == null) {
			throw new Exception("Fechar pedido -> Cliente não cadastrado");
		}
		
		Pedido ped = cli.isOpen();
		if(ped == null) {
			throw new Exception("Fechar pedido -> Pedido já está fechado");
		}
		
		
		double total = 10;
		for(Produto p: ped.getProdutos()) {
			total += p.getPreco();
		}
		
		ped.setTotal(total);
		ped.setEntregador(nome_entregador);
		ped.setFechado(true);
	}
	
	
	// Combo
	
	public static Combo criarCombo(String nome, List<Integer>ids) {
		ArrayList<Produto> aux = new ArrayList<>();
		for(int id :ids ) {
			for(Produto prod : Fachada.listarProdutos()) {
				if(prod.getId() == id) {
					aux.add(prod);
				}
			}
		}
	
		double total = 0;
		for(Produto p: aux) {
			total += p.getPreco();
		}
		
		
		Combo combo = new Combo(idproduto,nome,total,aux);
		
		idproduto ++;
		restaurante.adicionarProduto(combo);
        return combo;
	}
	
	//Exclusão Pedido
	public static void excluirPedido(int id_ped) throws Exception {
		Pedido ped = restaurante.localizarPedido(id_ped);
		if(ped == null) {
			throw new Exception("Excluir pedido -> Pedido não foi encontrado");
		}
		if(ped.isFechado() != true) {
			throw new Exception("Excluir pedido -> Pedido aberto, não pode ser excluído");
		}
		for(Produto pd: ped.getProdutos()) {
			pd.remover(ped);
		}
		Cliente c = ped.getCliente();
		restaurante.removerPedido(ped);
		c.remover(ped);
		
	}	
		
	
	//Envio do pedido
	
	//Arrecadação
	public static double calcularArrecadacao(int dia) {
		double total = 0.0;
		ArrayList<Pedido> pedidos = restaurante.getPedidos();
		
		for(Pedido p : pedidos) {
			if(p.getData().getDayOfMonth() == dia) {
				total += p.getTotal();
			}
		}
		return total;
	}
	

	
}
