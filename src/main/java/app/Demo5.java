package app;

	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;


import model.Usuario;

	public class Demo5 {
		// encontrar y mostrar los datos de un Usuario, según su código.
		public static void main(String[] args) {
			// llamar a la conexión
			EntityManagerFactory fabrica = 
					Persistence.createEntityManagerFactory("jpa_sesion01");
			// crear un manejador de las entidades
			EntityManager manager = fabrica.createEntityManager();
			
			String slq = "select u from Usuario u";
			List<Usuario> lstUsuarios = manager.createQuery(slq, Usuario.class).getResultList();
			
			
			for(Usuario u : lstUsuarios) {
				System.out.println("Codigo....:" + u.getCod_usua());
				System.out.println("Nombre....:" + u.getCod_usua() + " " + u.getApe_usua());
				System.out.println("Tipo......:" + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
				System.out.println("..........................");
			}
			
			manager.close();
			
			
		}
}
