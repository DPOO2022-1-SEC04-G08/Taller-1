package uniandes.dpoo.taller1.modelo;
import uniandes.dpoo.taller1.procesamiento.LoaderInformacionArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {
	
	public Restaurante () {
	}
	
	
	private ArrayList<Pedido> pedidos;
	private Pedido PedidoEnCurso;
	
	private ArrayList<Producto> ingredientes; 
	private ArrayList<Producto> ProductosMenu; 
	private ArrayList<Producto> combos; 	
	
	
	
	//Modificacion a iniciarPedido para que sea capaz de a�adir los ingredientes una vex sean ingresados por parametro 
	
	public void iniciarPedido(String nombreCliente, String direccionCliente, String productos ) {
		Pedido newPedido  = new Pedido(nombreCliente, direccionCliente);
		// Se a�ade al listado de pedidos
		pedidos.add(newPedido);
		// Si no existe pedido en curso se asigna al primero ingresado
		
		if (PedidoEnCurso == null) {
			
			PedidoEnCurso = pedidos.get(0);
		}
		
		String[] productosList = productos.split(","); 
		
		//for (String[]: productosList) 
			//for (Producto e: combos)
			
			
		//}

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


	public  void cerrarYGuardarPedido() throws IOException {
		
		File archivo = new File("./Facturas/factura" + String.valueOf(getPedidoEnCurso().getIdPedido()) + ".txt");
		
		//Se crea la factura y se guarda en un File dentro de la carpeta Facturas
		getPedidoEnCurso().guardarFactura(archivo);
		
		//  Se elimina el pedido en curso de la lista
		pedidos.remove(0);
		
		 //Se asigna un nuevo pedido en curso-> El siguiente que ha llegado
		
		PedidoEnCurso = pedidos.get(0);

		
	}
	public Pedido getPedidoEnCurso(){
		return this.PedidoEnCurso;
		
	}
}
