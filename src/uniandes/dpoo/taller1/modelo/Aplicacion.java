package uniandes.dpoo.taller1.modelo;

import java.io.BufferedReader;



public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public static void main()
	{
		Aplicacion consola = new Aplicacion();
		consola.mostrarMenu();
		System.out.println("6. Salir de la aplicación\n");
	}
}
