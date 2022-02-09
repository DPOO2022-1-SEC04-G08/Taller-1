package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Ingrediente {
	private String nombre;
	private int costoAdicional ;
	/**
	 * @param nombre
	 * @param costeAdicional
	 */

	public Ingrediente (int costoAdiconal, String nombre){
		this.costoAdicional = costoAdiconal;
		this.nombre = nombre;
	}
	
	
		
	public int getCostoAdicional() {
		// aqui solo tengo que coger el precio o comparar el precio con el nombre del producto ?
		return this.costoAdicional;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
