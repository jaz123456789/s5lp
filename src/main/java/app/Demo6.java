package app;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class Demo6 {
	// encontrar y mostrar los datos de un Usuario, según su código.
	public static void main(String[] args) {
		// llamar a la conexión
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		// crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		
		String slq = "select u from Productos u";
		List<Productos> lstProducto = manager.createQuery(slq, Productos.class).getResultList();
		
		
		for(Productos u : lstProducto) {
			System.out.println("Código....:" + u.getId_prod());
			System.out.println("Descuento....:" + u.getDes_prod());
			System.out.println("Stock......:" + u.getStk_prod() );
			System.out.println("Precio....." + u.getPre_prod());
			System.out.println("Idcategoria....:" + u.getIdcategoria() + " " + u.getObjcategoria().getDescripcion());
			System.out.println("Est....:" + u.getEst_prod());
			System.out.println("idProveedor....:" + u.getIdproveedor() + " " + u.getObjproveedor().getNombre_rs());
			System.out.println("........................................................");
		}
		
		manager.close();
		
		
	}

}
