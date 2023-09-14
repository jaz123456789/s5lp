package app;

	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;


import model.Usuario;

	public class Demo7 {
		// Listado de Usuarios según un tipo (filtro)
		public static void main(String[] args) {
			// llamar a la conexión
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
			// crear un manejador de las entidades
			EntityManager manager = fabrica.createEntityManager();
			
			//select * from tb_xx where idtipo = ?
			
			String slq = "select u from Usuario u where u.idtipo = :xtipo";
			List<Usuario> lstUsuarios = manager.createQuery(slq, Usuario.class).setParameter("xtipo", 1).getResultList();
			
			
			for(Usuario u : lstUsuarios) {
				System.out.println("Codigo....:" + u.getCod_usua());
				System.out.println("Nombre....:" + u.getCod_usua() + " " + u.getApe_usua());
				System.out.println("Tipo......:" + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
				System.out.println("..........................");
			}
			
			manager.close();
			
			
		}
}
