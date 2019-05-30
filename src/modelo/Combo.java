package modelo;

import java.util.ArrayList;

public class Combo extends Produto{

	private ArrayList<Produto> componentes = new ArrayList<>();

	
	//-------------Construtores-------------//
	

	public Combo(int id, String nome, double preco, ArrayList<Produto> componentes) {
		super(id, nome, preco);
		this.componentes = componentes;
	}
	
	
	//-------------Getters e Setters---------------//

	public ArrayList<Produto> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Produto> componentes) {
		this.componentes = componentes;
	}
	
	
	//----------------Relacionamento-------------//
	
	//Combo -> Produto
	public void adicionar(Produto p) {
		componentes.add(p);
	}

	public void remover(Produto p) {
		componentes.remove(p);
	}	
		
	public Produto localizar(String nome) {
		for(Produto p: componentes) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;	
	}
	
	//-----------------Método-------------------//
	@Override
	public double getPreco() {
		return super.getPreco() * 0.9 ;
	}


	@Override
	public String toString() {
		return "Combo [" + super.toString() + ", componentes=" + componentes + "]";
	}

	
	
	//--------To String-----//
	
	
	
}
