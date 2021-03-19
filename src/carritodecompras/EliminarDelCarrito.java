package carritodecompras;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class EliminarDelCarrito implements OperacionCarrito {

	@Override
	public void operacionC() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingrese el nombre del producto que desea Eliminar: ");
		String nombreProducto = entrada.nextLine();
		
		if(listaCarritoNombre.contains(nombreProducto)){
			
			int x = listaCarritoNombre.indexOf(nombreProducto);
			
			listaCarritoCantidad.remove(x);
			listaCarritoNombre.remove(x);
			listaCarritoPrecio.remove(x);
			listaCarritoDescuento.remove(x);
			listaCarritoTotal.remove(x);
			
			System.out.println("---------------------------------------------------");
			System.out.println("El producto ha sido eliminado del carrito con exito");
			System.out.println("---------------------------------------------------");
			
			
		} else{
			System.out.println("El nombre ingresado no se encuentra en el carrito de compras.");
		}

	}

}
