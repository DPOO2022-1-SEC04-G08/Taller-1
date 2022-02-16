package uniandes.dpoo.taller1.modelo;
import uniandes.dpoo.taller1.procesamiento.LoaderInformacionArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {
	
	public Restaurante () {
	}
	
	
	public ArrayList<Pedido> pedidos = new ArrayList<>();
	public Pedido PedidoEnCurso;
	
	private ArrayList<Producto> ingredientes= new ArrayList<>(); 
	private ArrayList<Producto> ProductosMenu= new ArrayList<>(); 
	private ArrayList<Producto> combos= new ArrayList<>(); 	
	private ArrayList<Producto> bebidas= new ArrayList<>(); 	
	
	
	
	//Modificacion a iniciarPedido para que sea capaz de añadir los ingredientes una vex sean ingresados por parametro 
	
	public Pedido iniciarPedido(String nombreCliente, String direccionCliente ) {
		Pedido newPedido  = new Pedido(nombreCliente, direccionCliente);
		// Se añade al listado de pedidos
		pedidos.add(newPedido);
		// Si no existe pedido en curso se asigna al primero ingresado
		
		if (PedidoEnCurso == null) {
			
			PedidoEnCurso = pedidos.get(0);
		}
		return newPedido; 

	}
	
	
	public ArrayList<Ingrediente> cargarIngredientes() throws IOException {
		ArrayList<Ingrediente> ingredientes = LoaderInformacionArchivos.leerInfoArchivoIngredientes("./data/ingredientes.txt");
		return 	ingredientes; 
	}

	public ArrayList<ProductoMenu>cargarMenu() throws FileNotFoundException, IOException {
		
		ArrayList<ProductoMenu> menu = LoaderInformacionArchivos.leerInfoArchivoProductosMenu("./data/menu.txt");
		return menu; 
	}
	
	//Al usar funcion de carfar combos se debe ingresar previamente el cargar Producto Menu 
	public ArrayList<Combo> cargarCombos(ArrayList<ProductoMenu> menu) throws FileNotFoundException, IOException {
		
		ArrayList<Combo> combos = LoaderInformacionArchivos.leerInfoArchivoCombos("./data/combos.txt", menu);
		return combos; 
	}
	public ArrayList<ProductoMenu>cargarBebidas() throws FileNotFoundException, IOException {
		
		ArrayList<ProductoMenu> menu = LoaderInformacionArchivos.leerInfoArchivoBebidas("./data/menu.txt");
		return menu; 
	}


	public  void cerrarYGuardarPedido(Pedido pedido) throws IOException {
		
		File archivo = new File("./Facturas/factura" + String.valueOf(pedido.getIdPedido()) + ".txt");
		
		//Se crea la factura y se guarda en un File dentro de la carpeta Facturas
		getPedidoEnCurso().guardarFactura(archivo);
		
		//  Se elimina el pedido en curso de la lista
		//pedidos.remove(0);
		
		 //Se asigna un nuevo pedido en curso-> El siguiente que ha llegado
		if (pedidos.indexOf(PedidoEnCurso)+1 < pedidos.size()) {
	
		PedidoEnCurso = pedidos.get(pedidos.indexOf(PedidoEnCurso)+1);
		}

		
	}
	public Pedido getPedidoEnCurso(){
		return this.PedidoEnCurso;
		
	}
}
