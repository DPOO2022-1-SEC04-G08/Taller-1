package uniandes.dpoo.taller1.consola;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import uniandes.dpoo.taller1.procesamiento.Controller;
import uniandes.dpoo.taller1.procesamiento.LoaderInformacionArchivos;
import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.Producto;
import uniandes.dpoo.taller1.modelo.ProductoAjustado;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.modelo.Restaurante; 
public class Aplicacion {
	
	Restaurante restaurante = new Restaurante();
	private ArrayList<Ingrediente> ingredientes= new ArrayList<>(); 
	private ArrayList<ProductoMenu> ProductosMenu= new ArrayList<>(); 
	private ArrayList<Combo> combos= new ArrayList<>(); 	
	private ArrayList<ProductoMenu> bebidas= new ArrayList<>(); 
	
	

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
		ArrayList<ProductoMenu> bebidas = LoaderInformacionArchivos.leerInfoArchivoBebidas("./data/bebidas.txt");
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
		Pedido pedido = null;
		while (continuar)
		{
			mostrarOpciones();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
			// aqui van los ifs para hacer funcionnar el programa 
			if (opcion_seleccionada == 0){
				try {
					cargar_informacion();//Cargar informacion del restaurante
				} catch (IOException e) {
					// FIXME Auto-generated catch block
					e.printStackTrace();
				}
			}
			if ((this.ingredientes.size()!=0 ) ||  (this.combos.size()!=0) || (this.ProductosMenu.size()!=0)    ) {
				if (opcion_seleccionada  == 1) 
				{
					mostrar_menu();
					
				}
				else if (opcion_seleccionada  == 2) 
				{
					pedido = nuevoPedido();
					System.out.println(pedido.getIdPedido());
				
					
					
				} if (opcion_seleccionada  == 3) {
					try {
						cerrar_guardar(pedido);
					} catch (IOException e) {
						// FIXME Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(restaurante.getPedidoEnCurso().getIdPedido());
					
				}
					if (opcion_seleccionada  == 4) 
				{
					int id= Integer.parseInt(input("Ingrese el id del pedido que desea consultar"));
					Pedido pedido1 = consultar_pedido(id);
					System.out.println(id);
					
					
					if (pedido1 != null) {
						Desktop ficheroAEjecutar = Desktop.getDesktop();
					   
					    try {
							ficheroAEjecutar.open(new File ("./Facturas/factura" + String.valueOf(id) + ".txt"));
							System.out.println("Se ha abierto la factura");
						} catch (IOException e) {
							// FIXME Auto-generated catch block
							e.printStackTrace();
						}
					   
					}
					
				
				} 
					else if (opcion_seleccionada  == 5) {
						int id = Integer.parseInt(input("Ingrese el id del pedido 1 que desea consultar"));
						Pedido pedido1 = restaurante.pedidos.get(id-1);
						int id2 = Integer.parseInt(input("Ingrese el id del pedido 2 que desea consultar"));
						Pedido pedido2 = restaurante.pedidos.get((id2-1));
						System.out.println(pedido1.getIdPedido());
						
						boolean same = pedido1.equals(pedido2); 
						
						if (same ==true) {
							System.out.println("En ambos pedidos se ordeno lo mismo ");
						}else {
							System.out.println("Los pedidos ordenaron diferentes productos");
						}
						
					}
				else if (opcion_seleccionada  == 6) 
				{
					
					System.out.println("cerrando programa");
					continuar=false;
					
				} 
	
			}
			else {
				System.out.println("No puede ejcutar esa opcion. Cargue el archivo e intente de nuevo");
				continue;
			}
			
		}
	}
	
	public void mostrarOpciones()
	{
		
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("0. Cargar");
		System.out.println("1. mostrar menu");
		
		System.out.println("2. iniciar un nuevo pedido");
		System.out.println("3. Cerrar pedido actual y guardar factura");
		System.out.println("4. Consultar la informacion de un pedido");
		System.out.println("5. Consultar si dos pedidos son iguales");
		System.out.println("6. Salir de la aplicación\n");
	}
	
	// funcion para mostrar el menu

	private void mostrar_menu() 
	{
		
		System.out.println("el menu es: ");
		Controller menu = new Controller();
		menu.menu();
		
	}

	
	
	private void cargar_informacion() throws FileNotFoundException, IOException {
		//LoaderInformacionArchivos.leerInfoArchivoProductosMenu(.);
		this.ProductosMenu = LoaderInformacionArchivos.leerInfoArchivoProductosMenu("./data/menu.txt");
		this.ingredientes = LoaderInformacionArchivos.leerInfoArchivoIngredientes("./data/ingredientes.txt");
		this.combos = LoaderInformacionArchivos.leerInfoArchivoCombos("./data/combos.txt", ProductosMenu);
		this.bebidas =LoaderInformacionArchivos.leerInfoArchivoBebidas("./data/bebidas.txt");
	}
	
	
	private void cerrar_guardar(Pedido pedido) throws IOException{
		restaurante.cerrarYGuardarPedido(pedido);
		
	}
	private Pedido consultar_pedido(int id) {
		
		for (Pedido ped: restaurante.pedidos) {
			
			if (ped.getIdPedido() == id) {
				System.out.print("Se ha encontrado el pedido");
				return ped;
				
			}
			
		}
		return null;
		
	}
	
	
	
	private Pedido nuevoPedido()
	{
		String nombreCliente = input("Porfavor ingrese su nombre:"); 
		String direccionCliente = input ("Porfavor ingrese su direccion:");
		
		
		//Se crea un producto 
		
		Pedido newPedido= restaurante.iniciarPedido(nombreCliente,direccionCliente);
		
		
		ArrayList<Producto> productosPedido = new ArrayList<Producto>();
		//Producto producto =null;
		
		//Hace Lista de Productos
		boolean pidiendo = true; 
		
		while (pidiendo) {
			
			System.out.print("�Que desea comprar?");
			System.out.print("1. combos \n");
			System.out.print("2. menu normal \n");
			System.out.print("3. Bebidas\n");
			System.out.print("4. Salir \n");
			//System.out.print("2. ingredientes \n");
			int indiceProducto  = Integer.parseInt(input("Por favor seleccione una opcion"));
			
			//Opcion valida
			boolean hasta = false;
			if ((indiceProducto== 0) || ( indiceProducto> 4)){
				hasta = true;
			}
			while (hasta) {
				indiceProducto = Integer.parseInt(input("Por favor seleccione una opcion valida"));
				if (( indiceProducto != 0) && (indiceProducto< 5)) {
					hasta = false;
				}
			}
			
			//Condicional 
			
			if (indiceProducto == 1)
			{
				Combo productoCombo = nombreCombo();	
				productosPedido.add(productoCombo); 
			}
			else if (indiceProducto == 3) {
				ProductoMenu productoBebida = nombreBebidas();	
				productosPedido.add(productoBebida); 
				
			}
			else if (indiceProducto == 2)
			{
				ProductoMenu productoMenu = nombreMenu();
				
				boolean modificarIngrediente = true; 
				ProductoAjustado productoConIngrediente = new ProductoAjustado(productoMenu);
				
				
				while (modificarIngrediente) {
					
					System.out.print("Desea a�adir/eliminar un ingrediente?");
					
					System.out.print("1. No \n");
					System.out.print("2. A�adir \n");
					System.out.print("3. Eliminar \n");
					
					int indiceingrediente  = Integer.parseInt(input("Por favor seleccione una opcion"));
					
					//Valida opcion
					boolean hasta1 = false;
					if ((indiceingrediente== 0) || ( indiceingrediente> 3)){
						hasta1 = true;
					}
					while (hasta1) {
						indiceingrediente = Integer.parseInt(input("Por favor seleccione una opcion valida"));
						if (( indiceingrediente != 0) && (indiceingrediente< 4)) {
							hasta1 = false;
						}
					}
					
					//Condicionales
					if (indiceingrediente ==1) {
						modificarIngrediente = false; 
					}
					if (indiceingrediente == 2) {
						//Crea Ingrediente
						Ingrediente ingredienteanadido = nombreIngrediente ();
						
						//Se a�ade ingrediente producto base
						
						//Agregar a arraylist de agregados
						productoConIngrediente.agregados.add(ingredienteanadido); 
	
					}
					if (indiceingrediente == 3) {
						//Crea Ingrediente
						Ingrediente ingredienteanadido = nombreIngrediente ();
		
						//Agregar a ArrayList de eliminados
						productoConIngrediente.eliminados.add(ingredienteanadido); 
	
					}
					
				}
				
				
				productosPedido.add(productoConIngrediente); 
				
				
	
				}
			else if (indiceProducto == 4)
			{ 
				pidiendo = false; 
			}
			
			}
		
		for (Producto p: productosPedido) {
			System.out.print(p.getNombre());
			newPedido.agregarProducto(p);
			
		}
		return newPedido;
		
		}
		
		
		
		/*
		
		int numeroProductos = Integer.parseInt(input("�Cuantos productos quiere comprar?"));
		int indiceProducto = -1; 
		int contador = 0;
		while (contador <= numeroProductos)
		{

			
			System.out.print("1. combos \n");
			System.out.print("2. ingredientes \n");
			System.out.print("3. menu normal \n");
			indiceProducto  = Integer.parseInt(input("Por favor seleccione una opcion"));
			
			boolean hasta = false;
			if ((indiceProducto== 0) || ( indiceProducto> 3)){
				hasta = true;
			}
			while (hasta) {
				indiceProducto = Integer.parseInt(input("Por favor seleccione una opcion valida"));
				if (( indiceProducto != 0) && (indiceProducto< 4)) {
					hasta = false;
				}
			}
			
			if (indiceProducto == 1)
			{
				Combo productoCombo = nombreCombo();
				System.out.print(productoCombo.getNombre());
			}
			
			else if (indiceProducto == 2)
			{
				System.out.print("0. No \n");
				
			}
			else if (indiceProducto == 3)
			{
				producto = nombreMenu();
				System.out.print("Desea a�adir/eliminar un ingrediente?");
				
				System.out.print("0. No \n");
				System.out.print("1. A�adir \n");
				System.out.print("2. Eliminar \n");
				int indiceingrediente  = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (indiceingrediente ==0) {
					System.out.print("No se ha eliminado ningun ingrediente");
				}

		
			//productos = producto + ",";
			contador = contador +1;
			}
		}
			
			
			
			if (numeroProductos == 1)
			{
				
				System.out.print("1. combos \n");
				System.out.print("2. ingredientes \n");
				System.out.print("3. menu normal \n");
				
				indiceProducto  = Integer.parseInt(input("Por favor seleccione una opcion"));
				
				boolean hasta = false;
				if ((indiceProducto== 0) || ( indiceProducto> 3)){
					hasta = true;
				}
				while (hasta) {
					indiceProducto = Integer.parseInt(input("Por favor seleccione una opcion valida"));
					if (( indiceProducto != 0) && (indiceProducto< 4)) {
						hasta = false;
					}
				}
				
				if (indiceProducto == 1)
				{
					Producto productoc = (Producto) nombreCombo();
					productos.add(producto);
					
				}
				
				else if (indiceProducto == 2)
				{
					
					
					
					Producto productoi = (Producto) nombreIngrediente();
					productos.add(productoi);
				}
				else if (indiceProducto == 3)
				{
					Producto productom = nombreMenu();
					//productos.add(productom);
				}
				
				
				contador = contador +1;
			}
			else if(contador  == 0)
			{
				System.out.print("1. combos \n");
				System.out.print("2. ingredientes \n");
				System.out.print("3. menu normal \n");
				indiceProducto  = Integer.parseInt(input("Por favor seleccione una opcion"));
				boolean hasta = false;
				if ((indiceProducto== 0) || ( indiceProducto> 3)){
					hasta = true;
				}
				while (hasta) {
					indiceProducto = Integer.parseInt(input("Por favor seleccione una opcion valida"));
					if (( indiceProducto != 0) && (indiceProducto< 4)) {
						hasta = false;
					}
				}
				if (indiceProducto == 1)
				{
					Combo productoCombo = nombreCombo();
					System.out.print(productoCombo.getNombre());
				}
				
				else if (indiceProducto == 2)
				{
					System.out.print("0. No \n");
					
				}
				else if (indiceProducto == 3)
				{
					producto = nombreMenu();
					System.out.print("Desea a�adir/eliminar un ingrediente?");
					
					System.out.print("0. No \n");
					System.out.print("1. A�adir \n");
					System.out.print("2. Eliminar \n");
					int indiceingrediente  = Integer.parseInt(input("Por favor seleccione una opcion"));
					if (indiceingrediente ==0) {
						System.out.print("No se ha eliminado ningun ingrediente");
					}
	
			
				//productos = producto + ",";
				contador = contador +1;
				}
			else
			{
				System.out.print("1. combos \n");
				System.out.print("2. ingredientes \n");
				System.out.print("3. menu normal \n");
				indiceProducto  = Integer.parseInt(input("Por favor seleccione una opcion"));
				boolean hasta = false;
				if ((indiceProducto== 0) || ( indiceProducto> 3)){
					hasta = true;
				}
				while (hasta) {
					indiceProducto = Integer.parseInt(input("Por favor seleccione una opcion valida"));
					if (( indiceProducto != 0) && (indiceProducto< 4)) {
						hasta = false;
					}
				}
				if (indiceProducto == 1)
				{
					Combo productoCombo = nombreCombo();
					System.out.print(productoCombo.getNombre());
				}
				
				else if (indiceProducto == 2)
				{
					Ingrediente productoInge = nombreIngrediente();
				}
				else if (indiceProducto == 3)
				{
					producto = nombreMenu();
				}
				productos = productos+ producto + ",";
				contador = contador +1;
			}
		}
		System.out.print(productos);
		
		
		String[] listaProductos = productos.split(",");
		for (String productoLista: listaProductos ) {*/
			
			
			
			
	
			
		

	
	
	
	
	//para que nos de el nombre del combo
	
	private Combo nombreCombo ()
	{
		Combo respuesta = null;
		
		int numeral = 1; 
		
		for (Combo com: this.combos) {
			System.out.println(String.valueOf(numeral) +"."+ com.getNombre() );
			numeral+=1;
			
		}
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > this.combos.size())){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < this.combos.size())) {
				hasta = false;
			}
		}
		
		respuesta = this.combos.get((opcion_seleccionada-1));
		return respuesta;
		
		
		/*
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
		return respuesta;*/
	}
	
	private ProductoMenu nombreMenu ()
	{
		/*
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
		System.out.print("11. coste�a \n");
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
		*/
		int numeral = 1; 
		for (ProductoMenu prod: this.ProductosMenu) {
			System.out.println(String.valueOf(numeral) +"."+ prod.getNombre() );
			numeral+=1;
			
		}
		
		
		ProductoMenu respuesta = null;
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > this.ProductosMenu.size())){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < this.ProductosMenu.size())) {
				hasta = false;
			}
			
		}
		
		respuesta = this.ProductosMenu.get((opcion_seleccionada-1));
		return respuesta;
		
		/*
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
			respuesta = "coste�a";
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
		*/
		
	}
	private ProductoMenu nombreBebidas ()
	{
		int numeral = 1; 
		for (ProductoMenu prod: this.bebidas) {
			System.out.println(String.valueOf(numeral) +"."+ prod.getNombre() );
			numeral+=1;
			
		}
		
		
		ProductoMenu respuesta = null;
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > this.bebidas.size())){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < this.bebidas.size())) {
				hasta = false;
			}
			
		}
		
		respuesta = this.bebidas.get((opcion_seleccionada-1));
		return respuesta;
		
	}
	

	private Ingrediente nombreIngrediente ()
	{
		/*
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
		System.out.print("11. suero coste�o \n");
		System.out.print("12. frijol refrito \n");
		System.out.print("13. queso fundido \n");
		System.out.print("14. tocineta picada \n");
		System.out.print("15. pi�a \n");
		*/
		int numeral = 1; 
		for (Ingrediente prod: this.ingredientes) {
			System.out.println(String.valueOf(numeral) +"."+ prod.getNombre() );
			numeral+=1;
			
		}
		
		Ingrediente respuesta = null;
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
		
		boolean hasta = false;
		if ((opcion_seleccionada == 0) || ( opcion_seleccionada > this.ingredientes.size())){
			hasta = true;
		}
		while (hasta) {
			opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion valida"));
			if (( opcion_seleccionada != 0) && (opcion_seleccionada < this.ingredientes.size())) {
				hasta = false;
			}
		}
		
		respuesta = this.ingredientes.get((opcion_seleccionada-1));
		return respuesta ;
		
		
		
		/*
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
			respuesta = "suero coste�o";
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
			respuesta = "pi�a";
		}*/
		
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