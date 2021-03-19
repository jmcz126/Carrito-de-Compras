package carritodecompras;

import org.springframework.stereotype.Component;

@Component
public class ListarElCarrito implements OperacionCarrito {

	@Override
	public void operacionC() {
		
		System.out.println("----------------------------------");
		System.out.println("Lista de los productos del carrito");
		System.out.println("----------------------------------");
		
		if(listaCarritoCantidad.isEmpty()) {
			System.out.println("La lista del carrito de compras se encuentra vacía.");
		} else {
			for(int i=0; i<listaCarritoCantidad.size(); i++) {
				System.out.println(listaCarritoNombre.get(i) + " " + listaCarritoCantidad.get(i) + " unidades.");
			}
		}
		
		System.out.println("");
		System.out.println("");

	}

}
