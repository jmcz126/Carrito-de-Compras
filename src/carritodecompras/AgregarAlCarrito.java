package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AgregarAlCarrito implements OperacionCarrito {

	@Override
	public void operacionC() {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		Scanner entrada = new Scanner(System.in);
		
		// Listas para guardar los nombres, precios y descuento de los productos que existen en la tienda
		List listarNombres = new ArrayList();
		List listarPrecios = new ArrayList();
		List listarDescuento = new ArrayList();
		
		int numeroProductos = 0;
		int cantidad = 0;
		
		try {
			
			miSession.beginTransaction();
			
			List<Productos> losProductos = miSession.createQuery("from Productos").getResultList();
			
			// Se guardan los nombres de los productos de la tienda en la lista listarNombres
			for(Productos producto:losProductos){
				listarNombres.add(producto.getNombre());
				listarPrecios.add(producto.getPrecio());
				listarDescuento.add(producto.getDescuento());
			}
				
			// Se ingresa el nombre del producto que se desea ingresar al carrito
			System.out.print("Ingrese el nombre del producto que desea Agregar al carrito: ");
			String nombreProducto = entrada.nextLine();
			
			// Se guarda el index del nombre del producto en una variable, para acceder al precio y descuento por medio de este mismo
			int x = listarNombres.indexOf(nombreProducto);
				
			// Se comprueba si el producto ya se encuentra en el carrito, de ser así, no se  agrega al carrito
			if(listaCarritoNombre.contains(nombreProducto)){
				System.out.println("El producto ya se encuentra en el carrito.");
			// Ahora se comprueba si el nombre del producto deseado coincide con el de alguno de los productos en la tienda, de ser así, se agrega al carrito
			} else if(listarNombres.contains(nombreProducto)){
					
				System.out.print("Ingrese el número de unidades que desea del producto con nombre '" + nombreProducto + "': ");
				cantidad = entrada.nextInt();
				
				listaCarritoCantidad.add(cantidad);
				listaCarritoNombre.add(nombreProducto);
				listaCarritoPrecio.add(listarPrecios.get(x));
				listaCarritoDescuento.add(listarDescuento.get(x));
				listaCarritoTotal.add((float) listarPrecios.get(x) * cantidad);
				
				
				System.out.println("-------------------------------------------------");
				System.out.println("El producto ha sido agregado al carrito con exito");
				System.out.println("-------------------------------------------------");
				
			// En caso de que no coincida, se da el aviso y no se agrega nada al carrito
			} else{
				System.out.println("El nombre ingresado no se encuentra en los registros.");
			}	
			
			
			
			
			miSession.close();
			
		} finally {
			miFactory.close();
		}
	}
}
