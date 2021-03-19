package carritodecompras;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ListarProductos implements OperacionProductos {

	@Override
	public void operacionP() {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {	
			
			miSession.beginTransaction();
			
			//Consulta de productos o en este caso, listar todos los productos en la BD
			List<Productos> losProductos = miSession.createQuery("from Productos").getResultList();
			
			//Mostrar los productos
			for(Productos producto:losProductos) {
				System.out.println("Identificador: " + producto.getSku() + "	Nombre: " + producto.getNombre() + 
						"		Descripción: " + producto.getDescripcion() + "		Precio: " + producto.getPrecio() + 
						"	Descuento: " + producto.getDescuento());
			}
			
			miSession.close();
			
		} finally {
			miFactory.close();
		}

	}

}
