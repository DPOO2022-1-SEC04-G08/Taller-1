package uniandes.dpoo.taller1.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Aplicacion {

	public static void main(String[] args) {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();

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
	
	
	
	
	



