// Interfaz que contiene el metodo que se encargará de listar,  agregar, modificar y eliminar un productos al carrito de compras

package carritodecompras;

import java.util.ArrayList;
import java.util.List;

public interface OperacionCarrito {
	
	// Listas donde se guardaran las caracteristicas de la compra en el carrtio
	List listaCarritoNombre = new ArrayList();
	List listaCarritoCantidad = new ArrayList();
	List listaCarritoPrecio = new ArrayList();
	List listaCarritoDescuento = new ArrayList();
	List listaCarritoTotal = new ArrayList();
	
	public void operacionC();

}
