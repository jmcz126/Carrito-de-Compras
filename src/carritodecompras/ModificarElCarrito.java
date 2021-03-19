package carritodecompras;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class ModificarElCarrito implements OperacionCarrito {

	@Override
	public void operacionC() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingrese el nombre del producto que desea modificar: ");
		String nombreProducto = entrada.nextLine();
		
		if(listaCarritoNombre.contains(nombreProducto)){
			System.out.print("Ingrese la nueva cantidad de unidades que desea del producto '" + nombreProducto + "': ");
			int cantidad = entrada.nextInt();
			
			listaCarritoCantidad.set(listaCarritoNombre.indexOf(nombreProducto), cantidad);
			listaCarritoTotal.set(listaCarritoNombre.indexOf(nombreProducto), (float) listaCarritoPrecio.get(listaCarritoNombre.indexOf(nombreProducto)) * cantidad);
			
			System.out.println("-----------------------------------------------------");
			System.out.println("El producto del carrito ha sido modificado con exito.");
			System.out.println("-----------------------------------------------------");
			
		} else{
			System.out.println("El nombre ingresado no se encuentra en el carrito de compras.");
		}

	}

}
