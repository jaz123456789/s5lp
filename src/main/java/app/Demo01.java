package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		//llamar a la conexión 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//Crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Obejeto a grabar
		Usuario u= new Usuario();
		u.setCod_usua(12);
		u.setNom_usua("luis");
		u.setApe_usua("coron");
		u.setUsr_usua("coronado");
		u.setCla_usua("405345");
		u.setFna_usua("2010/10/11");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		//si queremos grabar, registrar, actuaizar  eliminar --> transa 
		manager.getTransaction().begin();
		manager.persist(u); //comando - registrar
		manager.getTransaction().commit();
		System.out.println("Registro ok");
		manager.close();
		
	

		
	}

}
