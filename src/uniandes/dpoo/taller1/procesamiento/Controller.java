package uniandes.dpoo.taller1.procesamiento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.modelo.Restaurante;

public class Controller {
	
	
	
	//Metodos

	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Restaurante.iniciarPedido(nombreCliente, direccionCliente);
		
	}
	 
	
	
	

}
