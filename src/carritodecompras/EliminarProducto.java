package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class EliminarProducto implements OperacionProductos {

	@Override
	public void operacionP() {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList listarSku = new ArrayList();
		
		// Se ingresa el identificador del producto que se desea eliminar
		System.out.print("Ingrese el identificador del producto que desea eliminar: ");
		String skuProducto = entrada.nextLine();
		
		try {
			
			// Se crea la instrucción para eliminar el producto seleccionado de la BD
			String query = "delete Productos where sku='" + skuProducto + "'";
			
			miSession.beginTransaction();
			
			List<Productos> losProductos = miSession.createQuery("from Productos").getResultList();
			
			for(Productos producto:losProductos){
				listarSku.add(producto.getSku());
			}
			
			if(listarSku.contains(skuProducto)){
				
				miSession.createQuery(query).executeUpdate();
				System.out.println("Registro eliminado correctamente.");
				
			} else{
				System.out.println("El identificador ingresado no se encuentra en los registros.");
			}
			
			miSession.getTransaction().commit();
			miSession.close();
			
		} finally {
			miFactory.close();
		}

	}

}
