package uniandes.dpoo.taller1.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.taller.procesamiento.LoaderInformacionArchivos;
import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.ProductoMenu;

public class Aplicacion {
	
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Aplicacion consola = new Aplicacion();
		//Pruebas//
		consola.probarcarga();
		//Ejecutar app
		consola.ejecutarAplicacion();

	}
	
	public void probarcarga() throws FileNotFoundException, IOException {
		/////////////////Este metodo es solo de prueba se debe borrar/////////////////////////
		
		ArrayList<ProductoMenu> menu = LoaderInformacionArchivos.leerInfoArchivoProductosMenu("./data/menu.txt");
		ArrayList<Ingrediente> ingredientes = LoaderInformacionArchivos.leerInfoArchivoIngredientes("./data/ingredientes.txt");
		ArrayList<Combo> combos = LoaderInformacionArchivos.leerInfoArchivoCombos("./data/combos.txt", menu);
		for (ProductoMenu e: menu) {
			System.out.println(e.getNombre());

		}
		for (Ingrediente e: ingredientes) {
			System.out.println(e.getNombre());

		}
		for (Combo e: combos) {
			System.out.println("Nombreeeeeeeeeeeeeeeeeeee");
			System.out.println(e.getNombre());
			System.out.println(e.getPrecio());
			for ( ProductoMenu p: e.itemsCombo) {
				System.out.println(p.getNombre());
			}
		}
	}


	public void ejecutarAplicacion() 
	{
		// insertar la carga de datos aqui 
		boolean continuar = true;
		while (continuar)
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
			// aqui van los ifs para hacer funcionnar el programa 
			if (opcion_seleccionada  == 6) 
			{
				System.out.println("cerrando programa");
				continuar = false;
			}
			System.out.println(opcion_seleccionada);
		}
	}
	
	public void mostrarMenu()
	{
		
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. mostrar menu");
		System.out.println("2. iniciar un nuevo pedido");
		System.out.println("3. agregar un elemento a un pedido");
		System.out.println("4. cerar un pedido y guardar la factura");
		System.out.println("5. Consultar la informacion de un pedido y guardar la factura");
		System.out.println("6. Salir de la aplicación\n");
	}



	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
}