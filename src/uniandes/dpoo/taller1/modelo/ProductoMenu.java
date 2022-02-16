package uniandes.dpoo.taller1.modelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	private int calorias; 
	
	
	
	/**
	 * @param nombre
	 * @param precioBase
	 */
	public ProductoMenu(String nombre, int precioBase, int calorias) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.calorias = calorias; 
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
	@Override
	public int getCalorias() {
		return this.calorias;
	}
	
	
}
