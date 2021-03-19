package carritodecompras;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OperacionGeneral implements GenerarOperacion {
	
	Scanner entrada = new Scanner(System.in);
	
	@Autowired
	@Qualifier("listarProductos")
	private OperacionProductos p1;
	
	@Autowired
	@Qualifier("agregarProducto")
	private OperacionProductos p2;
	
	@Autowired
	@Qualifier("modificarProducto")
	private OperacionProductos p3;
	
	@Autowired
	@Qualifier("eliminarProducto")
	private OperacionProductos p4;
	
	
	@Autowired
	@Qualifier("listarElCarrito")
	private OperacionCarrito c1;
	
	@Autowired
	@Qualifier("agregarAlCarrito")
	private OperacionCarrito c2;
	
	@Autowired
	@Qualifier("modificarElCarrito")
	private OperacionCarrito c3;
	
	@Autowired
	@Qualifier("eliminarDelCarrito")
	private OperacionCarrito c4;
	
	@Autowired
	@Qualifier("checkoutCarrito")
	private OperacionCarrito c5;
	
	@Override
	public void getOperacionProducto() {
		int seleccion = 0;
		int bandera = 0;
		
		do {
            do {
            	System.out.println("------------------------------------------------------------------------");
                System.out.println("Se encuentra en el Menú donde puede modificar el inventario de la tienda");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Por favor seleccione una opción");
                System.out.println("    1. Listar los productos disponibles en la tienda.");
                System.out.println("    2. Agregar un nuevo producto a la tienda.");
                System.out.println("    3. Modificar un producto de la tienda.");
                System.out.println("    4. Eliminar un producto de la tienda.");
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
                p1.operacionP();
            } else if (seleccion == 2) {
            	p2.operacionP();
            } else if (seleccion == 3) {
            	p3.operacionP();
            }  else if (seleccion == 4) {
            	p4.operacionP();
            } else if (seleccion == 5) {
                System.out.println("----------------------------------------");
                System.out.println("Sus modificaciones en la tienda han sido realizadas con exito.");
                System.out.println("----------------------------------------");
                bandera = 2;
            }
        } while (bandera == 1);
		
	}

	@Override
	public void getOperacionCarrito() {
		int seleccion = 0;
		int estado = 0;
		do {
            do {
            	System.out.println("------------------------------------------------------------------------");
                System.out.println("Se encuentra en el Menú del carrito de compras");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Por favor seleccione una opción");
                System.out.println("    1. Listar los productos del carrito");
                System.out.println("    2. Agregar un nuevo producto aal carrito.");
                System.out.println("    3. Modificar los productos del carrito.");
                System.out.println("    4. Eliminar un producto del carrito.");
                System.out.println("    5. Checkout.");
                System.out.print("	-> Ingrese su opción: ");
                seleccion = entrada.nextInt();

                //Condicional para controlar la selección del usuario
                if (seleccion >= 1 && seleccion <= 5) {
                    estado = 1;
                //En caso de que el usuario seleccione una opción no valida
                } else {    
                    System.out.println("-------------------------------------------------");
                    System.out.println("Opción no disponible, vuelva a intentar por favor");
                    System.out.println("-------------------------------------------------");
                }
            } while (estado == 0); // Estado para desplegar el menú

            if (seleccion == 1) {
                c1.operacionC();
            } else if (seleccion == 2) {
            	c2.operacionC();
            } else if (seleccion == 3) {
            	c3.operacionC();
            }  else if (seleccion == 4) {
            	c4.operacionC();
            } else if (seleccion == 5) {
            	c5.operacionC();
                System.out.println("----------------------------------------");
                System.out.println("Estado completado, gracias por su compra");
                System.out.println("----------------------------------------");
                estado = 2; // Estado completado
            }
        } while (estado == 1); // Estado en proceso o pendiente

	}

}
