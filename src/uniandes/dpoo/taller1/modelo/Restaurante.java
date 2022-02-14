package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {
	
	public Restaurante () {
	}
	
	
	private ArrayList<Pedido> pedidos;
	private Pedido PedidoEnCurso;
	
	//Duda: Como se deben agregar los productos al pedido?
	
	public void iniciarPedido(String nombreCliente, String direccionCliente ) {
		Pedido newPedido  = new Pedido(nombreCliente, direccionCliente);
		// Se añade al listado de pedidos
		pedidos.add(newPedido);
		// Si no existe pedido en curso se asigna al primero ingresado
		
		if (PedidoEnCurso == null) {
		PedidoEnCurso = pedidos.get(0);
		}
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
