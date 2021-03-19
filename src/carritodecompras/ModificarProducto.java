package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ModificarProducto implements OperacionProductos {

	@Override
	public void operacionP() {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
				
		Scanner entrada = new Scanner(System.in);
		
		// Se crea una lista para obtener todos los identificadores presentes en la BD
		ArrayList listarSku = new ArrayList();
		
		// Se ingresa el identificador del producto que se desea modificar
		System.out.print("Ingrese el identificador del producto que desea modificar: ");
		String skuProducto = entrada.nextLine();
				
		try {	 
					
			miSession.beginTransaction();

			List<Productos> losProductos = miSession.createQuery("from Productos").getResultList();
			
			//Ciclo para obtener los identificadores de la BD y añadarlos a la lista creada previamente
			for(Productos producto:losProductos) {
				listarSku.add(producto.getSku());
			}
			
			// Se crea un condicional en caso de que se escriba un identificador que no se encuentra en la BD
			if(listarSku.contains(skuProducto)) {
				
				Productos miProducto = miSession.get(Productos.class, skuProducto);
				int seleccion = 0;
				int bandera = 0;
				
				// Se crean 2 ciclos do/while para simular un menú y mantenerse en él hasta que se escoga la opción de salir (5).
				do {
		            do {
		            	System.out.println("-------------------------------------------------------------------------------------------------");
	                    System.out.println("Se encuentra en el Menú donde puede cambiar las caracteristicas de los productos en el inventario");
	                    System.out.println("-------------------------------------------------------------------------------------------------");
		                System.out.println("Por favor seleccione la opción correspondiente a su modificación");
		                System.out.println("    1. Cambiar el nombre del producto.");
		                System.out.println("    2. Cambiar la descripción del producto.");
		                System.out.println("    3. Cambiar el precio del producto.");
		                System.out.println("    4. Establecer si el producto se encuentra en descuento o no.");
		                System.out.println("    5. Salir.");
		                System.out.print("	-> Ingrese su opción: ");
		                seleccion = entrada.nextInt();

		                //Condicional para controlar la selección del usuario
		                if (seleccion >= 1 && seleccion <= 5) {
		                    bandera = 1;
		                //En caso de que el usuario seleccione una opción no valida
		                } else {    
		                    System.out.println("-------------------------------------------------");
		                    System.out.println("Opción no disponible, vuelva a intentar por favor");
		                    System.out.println("-------------------------------------------------");
		                }
		            } while (bandera == 0);

		            if (seleccion == 1) {
		                System.out.print("Ingrese el nuevo nombre del producto: ");
		                entrada.nextLine();
		                miProducto.setNombre(entrada.nextLine());
		            } else if (seleccion == 2) {
		            	System.out.print("Ingrese la nueva descripción del producto: ");
		            	entrada.nextLine();
		                miProducto.setDescripcion(entrada.nextLine());
		            } else if (seleccion == 3) {
		            	System.out.print("Ingrese el nuevo precio del producto: ");
		                miProducto.setPrecio(entrada.nextFloat());
		            }  else if (seleccion == 4) {
		            	System.out.print("Si su producto se encuentra con descuento ingrese 'true', en caso contrario ingrese 'false': ");
		                miProducto.setDescuento(entrada.nextBoolean());
		            } else if (seleccion == 5) {
		                System.out.println("----------------------------------------");
		                System.out.println("Los datos han sido modificados con exito");
		                System.out.println("----------------------------------------");
		                bandera = 2;
		            }
		        } while (bandera == 1);

			} else {
				System.out.println("El identificador ingresado no se encuentra en los registros.");
			}
			
			miSession.getTransaction().commit();
			miSession.close();
			
		} finally {
			miFactory.close();
		}

	}

}
