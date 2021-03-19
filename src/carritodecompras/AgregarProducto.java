package carritodecompras;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AgregarProducto implements OperacionProductos {

	
	
	@Override
	public void operacionP() {
		
		//Se crea un objeto de tipo SessionFactory para que lea el archivo de configuración
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
				
		//Se crea el objeto de tipo Session
		Session miSession = miFactory.openSession();
				
		Scanner entrada = new Scanner(System.in);
				
		// Se crea una variable donde se guarda el identificador del producto que se desea agregar
		System.out.print("Ingrese el identificador del producto: ");
		String sku = entrada.nextLine();
			
		// Se crea una variable donde se guarda el nombre del producto que se desea agregar
		System.out.print("Ingrese el nombre del producto: ");
		String nombre = entrada.nextLine();
				
		// Se crea una variable donde se guarda la descripción del producto que se desea agregar
		System.out.print("Ingrese la descripción del producto: ");
		String descripcion = entrada.nextLine();
				
		// Se crea una variable donde se guarda el precio del producto que se desea agregar
		System.out.print("Ingrese el precio del producto: ");
		float precio = entrada.nextFloat();
				
		// Se crea una variable donde se guarda el valor que especifica si el producto se encuentra en descuento o no
		System.out.print("Si su producto se encuentra con descuento ecriba 'true', en caso contrario escriba 'false': ");
		boolean descuento = entrada.nextBoolean();
		
		try {	
			
			Productos producto = new Productos(sku, nombre, descripcion, precio, descuento); 
			
			miSession.beginTransaction();
			// Se guarda el producto agregado a la BD
			miSession.save(producto);
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente");
			
			miSession.close();
				
		} finally {
			miFactory.close();
		}
	}

}
