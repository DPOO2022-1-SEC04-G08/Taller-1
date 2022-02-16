package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Ingrediente {
	private String nombre;
	private int costoAdicional ;
	private int calorias;
	/**
	 * @param nombre
	 * @param costeAdicional
	 */

	public Ingrediente (int costoAdiconal, String nombre, int calorias){
		this.costoAdicional = costoAdiconal;
		this.nombre = nombre;
		this.calorias = calorias; 
	}
	
	
		
	public int getCostoAdicional() {
		// aqui solo tengo que coger el precio o comparar el precio con el nombre del producto ?
		return this.costoAdicional;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public int getCalorias() {
		return this.calorias;
	}

}
