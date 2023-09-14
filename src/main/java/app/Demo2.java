package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Usuario;

public class Demo2 {
	//Actualizar los datos de un usuario
	public static void main(String[] args) {
		//llamar a la conexión 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//Crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Obejeto a modificar
		Usuario u= new Usuario();
		u.setCod_usua(3);
		u.setNom_usua("Zoila");
		u.setApe_usua("Torre");
		u.setUsr_usua("ztoro@mnail.com");
		u.setCla_usua("21498124");
		u.setFna_usua("2008/03/07");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		//si queremos grabar, registrar, actuaizar  eliminar --> transa 
		try {
			manager.getTransaction().begin();
			manager.merge(u); //comando - 
			manager.getTransaction().commit();
			System.out.println("Acualizacion ok");
		
		} catch (Exception e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		manager.close();
		
	
		
		
	}

}
