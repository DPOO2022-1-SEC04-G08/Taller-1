package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ProductoMenu base;
	public ArrayList<Ingrediente> agregados= new ArrayList<>();
	public ArrayList<Ingrediente> eliminados= new ArrayList<>();
	private int calorias; 
	
	
	public ProductoAjustado(ProductoMenu base) {
		this.base = base; 
	}
	@Override
	public int getPrecio() {
		int precio = base.getPrecio();
		for(int i = 0;i<this.agregados.size();i++) {
			precio = precio + this.agregados.get(i).getCostoAdicional();
		}
		return precio;
	}

	@Override
	public String getNombre() {
		String sin ="";
		String extra="";
		for(int i = 0;i<this.eliminados.size();i++) {
			sin = ", sin " + this.eliminados.get(i).getNombre();
		}
		for(int i = 0;i<this.agregados.size();i++) {
			extra = ", extra " + this.agregados.get(i).getNombre();
		}
		return base.getNombre()+sin+extra;
	}

	@Override
	public String generarTextoFactura() {
		return this.getNombre() + " : " + this.getPrecio() + "COP";
	}
	@Override
	public int getCalorias() {
		
		int precio = base.getCalorias();
		for(int i = 0;i<this.agregados.size();i++) {
			calorias = calorias + this.agregados.get(i).getCalorias();
		}
		for(int i = 0;i<this.eliminados.size();i++) {
			calorias = calorias + this.eliminados.get(i).getCalorias();
		}
		return precio;
	}

}
