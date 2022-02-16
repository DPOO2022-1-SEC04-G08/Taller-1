package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.dpoo.taller1.modelo.Producto;


public class Pedido {
	// Attributes
		private static int numeroPedidos;
		private static int idPedido;
		private String nombreCliente; 
		private String direccionCliente; 
		
		private  ArrayList<Producto> itemsPedido= new ArrayList<>();  
		
		//Constructor
		public Pedido(String nombreCliente, String direccionCliente) {
			this.nombreCliente = nombreCliente; 
			this.direccionCliente = direccionCliente;
			Pedido.idPedido += 1;
		}
		
		// Get methods
		
		public int getIdPedido() {
			return idPedido;
		}
		 
		public ArrayList<Producto> getItemsPedido() {
			return itemsPedido;
		}
		//Precio neto antes de impuestos
		// Preguntar si se deberian hacer estos metodos float para casos donde 
		//el precio o el impuesto no es entero?
		private int getPrecioNetoPedido() {
			int PrecioNeto = 0;
			
			
			for (Producto producto: itemsPedido) {
				
				PrecioNeto += producto.getPrecio();
			}
			return PrecioNeto;
			
		}
		//Impuestos
		private int getPrecioIVAPedido() {
			
			int IVA = (getPrecioNetoPedido()*(19))/100;
			
			return IVA;
			
			
		}
		
		//Precio total despues de impuestos
		private int getPrecioTotalPedido() {
			int neto = getPrecioNetoPedido();
			int impuestos = getPrecioIVAPedido();
			
			int PrecioTotal = neto + impuestos; 
			
			return PrecioTotal;
		}
		
		//Methods
		
		public void agregarProducto(Producto nuevoItem) {
			itemsPedido.add(nuevoItem);
			
		}
		
		private String generarTextoFactura() {
			String FacturaText = "Factura; Id del Pedido: " + String.valueOf(idPedido) + "; Precio por producto: ;";
			
			
					
			for (Producto producto: itemsPedido ) {
				
				String nameProducto = producto.getNombre();
				int precioProducto = producto.getPrecio();
				
				String format = nameProducto + "    " + String.valueOf(precioProducto)+";"; 
				FacturaText += format; 
				
			}
			FacturaText += ";" + ";"+ ";";
			FacturaText += "Precio neto: " + String.valueOf(getPrecioNetoPedido())+ ";";
			FacturaText += "IVA: " + String.valueOf(getPrecioIVAPedido())+ ";";
			FacturaText += "Precio Total: " + String.valueOf(getPrecioTotalPedido())+ ";";
			return FacturaText; 
			
		}
		// Preguntar si el archivo nos es dado por parametro o se crea desde 0 el archivo 
		public void guardarFactura(File archivo) throws IOException {
			//El formato del archi ha de ser ./Facturas/archivo.txt para que se guarde en la carpeta Facturas
			// Creacion de directorio (carpeta Facturas) dentro del proyecto
			File directorio = new File("./Facturas");
			
			if ( !directorio.exists()) {
				directorio.mkdirs();
			}
			
			// Escribir el texto generado en la otra funcion dentro del archivo de parámetro
			//Ojo al hacer restaurante incluir los tipos de archivo ./Facturas/archivo.txt
			//para que se guarde en facturas
			
			
			 FileWriter escribir = new FileWriter(archivo, true);
			 String[] facturaPartida = generarTextoFactura().split(";"); 
			 for (String linea:facturaPartida) {
				 //Imprimir linea y salto de linea
				 escribir.write(linea);
				 escribir.write(System.getProperty( "line.separator" ));
				 
			 }
			 
			 escribir.close();
			
		}
		public void equals(Pedido pedidoComparar) {
			
			boolean same = true; 
			for (Producto prod: this.itemsPedido) {
				for (Producto prod2: pedidoComparar.getItemsPedido()) {
					if (prod.getNombre().equals(prod2.getNombre())) {
						same = true; 
					}
					else {
						same=false; 
					}
					
				}
				
			}
			
			
		}

}
