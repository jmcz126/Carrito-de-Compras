package carritodecompras;

import javax.persistence.*;

@Entity
@Table(name="Productos")
public class Productos {
	
	public Productos() {
	}

	public Productos(String sku, String nombre, String descripcion, float precio, boolean descuento) {
		this.sku = sku;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
	}

	@Id
	@Column(name="Sku")
	private String sku;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Precio")
	private float precio;
	
	@Column(name="Descuento")
	private boolean descuento;
	

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean getDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return "Productos [sku=" + sku + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", descuento=" + descuento + "]";
	}
	

}
