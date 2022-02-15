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
		//consola.probarcarga();
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
		//String nombre = input("ingrese su nombre: ");
		//String direccion = input ("ingrese su direccion: ");
		while (continuar)
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
			// aqui van los ifs para hacer funcionnar el programa 
			if (opcion_seleccionada  == 1) 
			{
				mostrar_menu();
				
			}
			else if (opcion_seleccionada  == 2) 
			{
				System.out.println("cerrando programa");
				
			} 
			else if (opcion_seleccionada  == 3) 
			{
				System.out.println("cerrando programa");
				
			} 
			else if (opcion_seleccionada  == 4) 
			{
				System.out.println("cerrando programa");
				
			} 
			else if (opcion_seleccionada  == 5) 
			{
				System.out.println("cerrando programa");
				
			} 
			
			else if (opcion_seleccionada  == 6) 
			{
				System.out.println("cerrando programa");
				continuar = false;
			}
			
		}
	}
	
	public void mostrarMenu()
	{
		
		
		System.out.println("\nOpciones de la aplicaci√≥n\n");
		System.out.println("1. mostrar menu");
		System.out.println("2. iniciar un nuevo pedido");
		//Pedir nombre y direccion
		//2 Preguntar si quiere combo 
		//3 Si quiere:  Ingrese los combos que desea pedir separados por ;
		//4 Preguntar si quiere productos del Menu
		//Si quiere: Ingrese los productos del menu que quiere pedir separados por ; 
		//5 Preguntar si quiere ingredientes adicionales
		//Si quiere Infresar ingredientes que quiere pedir separados por ; 
		//6 Terminar pedido
		System.out.println("3. agregar un elemento a un pedido");
		
		System.out.println("4. cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la informacion de un pedido y guardar la factura");
		System.out.println("6. Salir de la aplicaci√≥n\n");
	}
	
	// funcion para mostrar el menu

	private void mostrar_menu() 
	{
		
		System.out.println("el menu es: ");
		//insertar el menu 
	}

	//private void nuevoPedido()
	//{
	//	String productos = new String("");
	//	int numeroProductos = Integer.parseInt(input("Por favor seleccione una opcion"));
	//	int contador = 0;
	//	while (contador < numeroProductos)
	//	{
	//		if (contador == (numeroProductos - 1))
	//		{
	//			string producto = input("inserte el producto")
	//			productos = productos+ 
	//		}
	//	}
	//}
	
	//para que nos de el nombre del combo
	
	private String nombreCombo ()
	{
		String respuesta = new String("");
		System.out.print("1. combo corral \n");
		System.out.print("2. combo corral queso\n");
		System.out.print("3. combo todoterreno\n");
		System.out.print("4. combo especial\n");
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > 4)){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < 5)) {
				hasta = false;
			}
		}
		
		if (opcion_seleccionada == 1) {
			respuesta = "combo corral";
		}
		else if (opcion_seleccionada == 2) {
			respuesta = "combo corral queso";
		}
		else if (opcion_seleccionada == 3) {
			respuesta = "combo todoterreno";
		}
		else if (opcion_seleccionada == 4) {
			respuesta = "combo especial";
		}
		return respuesta;
	}
	
	private String nombreMenu ()
	{
		System.out.print("1. corral \n");
		System.out.print("2. corral queso \n");
		System.out.print("3. corral pollo \n");
		System.out.print("4. corralita \n");
		System.out.print("5. todoterreno \n");
		System.out.print("6. 1/2 libra \n");
		System.out.print("7. especial \n");
		System.out.print("8. casera \n");
		System.out.print("9. mexicana \n");
		System.out.print("10. criolla \n");
		System.out.print("11. costeÒa \n");
		System.out.print("12. hawaiana \n");
		System.out.print("13. wrap de pollo \n");
		System.out.print("14. wrap de lomo \n");
		System.out.print("15. ensalada mexicana \n");
		System.out.print("16. papas medianas \n");
		System.out.print("17. papas grandes \n");
		System.out.print("18. papas en casco medianas \n");
		System.out.print("19. papas en casco grandes \n");
		System.out.print("20. agua cristal sin gas \n");
		System.out.print("21. agua cristal con gas \n");
		System.out.print("22. gaseosa \n");
		String respuesta = new String("");
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > 22)){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < 23)) {
				hasta = false;
			}
		}
		if (opcion_seleccionada == 1) {
			respuesta = "corral";
		}
		else if (opcion_seleccionada == 2) {
			respuesta = "corral queso";
		}
		else if (opcion_seleccionada == 3) {
			respuesta = "corral pollo";
		}
		else if (opcion_seleccionada == 4) {
			respuesta = "corralita";
		}
		else if (opcion_seleccionada == 5) {
			respuesta = "todoterreno";
		}
		else if (opcion_seleccionada == 6) {
			respuesta = "1/2 libra";
		}
		else if (opcion_seleccionada == 7) {
			respuesta = "especial";
		}
		else if (opcion_seleccionada == 8) {
			respuesta = "casera";
		}
		else if (opcion_seleccionada == 9) {
			respuesta = "mexicana";
		}
		else if (opcion_seleccionada == 10) {
			respuesta = "criolla";
		}
		else if (opcion_seleccionada == 11) {
			respuesta = "costeÒa";
		}
		else if (opcion_seleccionada == 12) {
			respuesta = "hawaiana";
		}
		else if (opcion_seleccionada == 13) {
			respuesta = "wrap de pollo";
		}
		else if (opcion_seleccionada == 14) {
			respuesta = "wrap de lomo";
		}
		else if (opcion_seleccionada == 15) {
			respuesta = "ensalada mexicana";
		}
		else if (opcion_seleccionada == 16) {
			respuesta = "papas medianas";
		}
		else if (opcion_seleccionada == 17) {
			respuesta = "papas grandes";
		}
		else if (opcion_seleccionada == 18) {
			respuesta = "papas en casco medianas";
		}
		else if (opcion_seleccionada == 19) {
			respuesta = "papas en casco grandes";
		}
		else if (opcion_seleccionada == 20) {
			respuesta = "agua cristal sin gas";
		}
		else if (opcion_seleccionada == 21) {
			respuesta = "agua cristal con gas";
		}
		else if (opcion_seleccionada == 22) {
			respuesta = "gaseosa";
		}
		return respuesta;
	}

	private String ingrediente ()
	{
		System.out.print("1. lechuga \n");
		System.out.print("2. tomate \n");
		System.out.print("3. cebolla \n");
		System.out.print("4. queso mozzarella \n");
		System.out.print("5. huevo \n");
		System.out.print("6. queso americano \n");
		System.out.print("7. tocineta express \n");
		System.out.print("8. papa callejera \n");
		System.out.print("9. pepinillos \n");
		System.out.print("10. cebolla grille \n");
		System.out.print("11. suero costeÒo \n");
		System.out.print("12. frijol refrito \n");
		System.out.print("13. queso fundido \n");
		System.out.print("14. tocineta picada \n");
		System.out.print("15. piÒa \n");
		String respuesta = new String("");
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > 15)){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < 16)) {
				hasta = false;
			}
		}
		if (opcion_seleccionada == 1) {
			respuesta = "lechuga";
		}
		else if (opcion_seleccionada == 2) {
			respuesta = "tomate";
		}
		else if (opcion_seleccionada == 3) {
			respuesta = "cebolla";
		}
		else if (opcion_seleccionada == 4) {
			respuesta = "queso mozzarella";
		}
		else if (opcion_seleccionada == 5) {
			respuesta = "huevo";
		}
		else if (opcion_seleccionada == 6) {
			respuesta = "queso americano";
		}
		else if (opcion_seleccionada == 7) {
			respuesta = "tocineta express";
		}
		else if (opcion_seleccionada == 8) {
			respuesta = "papa callejera";
		}
		else if (opcion_seleccionada == 9) {
			respuesta = "pepinillos";
		}
		else if (opcion_seleccionada == 10) {
			respuesta = "cebolla grille";
		}
		else if (opcion_seleccionada == 11) {
			respuesta = "suero costeÒo";
		}
		else if (opcion_seleccionada == 12) {
			respuesta = "frijol refrito";
		}
		else if (opcion_seleccionada == 13) {
			respuesta = "queso fundido";
		}
		else if (opcion_seleccionada == 14) {
			respuesta = "tocineta picada";
		}
		else if (opcion_seleccionada == 15) {
			respuesta = "piÒa";
		}
		return respuesta ;
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