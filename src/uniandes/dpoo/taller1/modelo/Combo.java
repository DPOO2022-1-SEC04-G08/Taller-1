package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	/**
	 * @param descuento
	 * @param nombreCombo
	 */
	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.itemsCombo = new ArrayList<ProductoMenu>();
	}

	@Override
	public int getPrecio() {
		double precio=0;
		for(int i =0;i<this.itemsCombo.size();i++) {
			precio = precio + this.itemsCombo.get(i).getPrecio();
		}
		precio = precio - this.descuento;
		return (int) precio;
	}

	@Override
	public String getNombre() {
		return this.nombreCombo;
	}

	@Override
	public String generarTextoFactura() {
		return this.getNombre() + " : " + this.getPrecio() + "COP";
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo) {
		itemsCombo.add(itemCombo);
	}

}
