package uniandes.dpoo.taller1.modelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	
	
	
	/**
	 * @param nombre
	 * @param precioBase
	 */
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	@Override
	public int getPrecio() {
		return this.precioBase;
	}
	@Override
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public String generarTextoFactura() {
		return this.getNombre() + " : " + this.getPrecio() + "COP";
	}
	
	
}
