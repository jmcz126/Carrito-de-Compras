package carritodecompras;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EjecutarCarrito {	

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		// Leer el xml de configuraci�n
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		GenerarOperacion op = contexto.getBean("operacionGeneral", GenerarOperacion.class);
		
		// Se usa el bean
		int seleccion = 0;
		int bandera = 0;
		do {
            do {
            	System.out.println("-----------------------------------------");
                System.out.println("Bienvenido al Men� principal de la tienda");
                System.out.println("-----------------------------------------");
                System.out.println("Por favor seleccione una opci�n");
                System.out.println("    1. Acceder para ver, agregar, modificar o eliminar los productos de la tienda.");
                System.out.println("    2. Acceder a un carrito de compras de la tienda.");
                System.out.println("    3. Salir.");
                System.out.print("	-> Ingrese su opci�n: ");
                seleccion = entrada.nextInt();

                //Condicional para controlar la selecci�n del usuario
                if (seleccion >= 1 && seleccion <= 3) {
                    bandera = 1;
                //En caso de que el usuario seleccione una opci�n no valida
                } else {    
                    System.out.println("-------------------------------------------------");
                    System.out.println("Opci�n no disponible, vuelva a intentar por favor");
                    System.out.println("-------------------------------------------------");
                }
            } while (bandera == 0);

            if (seleccion == 1) {
            	op.getOperacionProducto();
            } else if (seleccion == 2) {
            	op.getOperacionCarrito();
            } else if (seleccion == 3) {
                System.out.println("----------------------------------------");
                System.out.println("Gracias por visitarnos, vuelva pronto.");
                System.out.println("----------------------------------------");
                bandera = 2;
            }
        } while (bandera == 1);
		
		// Se cierra el contexto
		contexto.close();

	}

}
