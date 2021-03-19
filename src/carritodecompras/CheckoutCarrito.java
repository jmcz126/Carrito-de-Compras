package carritodecompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CheckoutCarrito implements OperacionCarrito {

	@Override
	public void operacionC() {
		
		float total = 0;
		
		for(int i=0; i<listaCarritoTotal.size(); i++) {
			if(listaCarritoDescuento.get(i).equals(true)) {
				total += (float) listaCarritoTotal.get(i)/2;
			} else {
				total += (float) listaCarritoTotal.get(i);
			}
		}
		
		System.out.println("El total de a pagar de todos los productos includios en el carrito es de:" + total);
		total = 0;

	}

}
