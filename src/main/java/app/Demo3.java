package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo3 {
	//Encontrar y mostrar los datos de un usuario segun su codigo
	public static void main(String[] args) {
		//llamar a la conexión 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//Crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Obejeto a modificar
		Usuario u= new Usuario();
		
		//si queremos grabar, registrar, actuaizar  eliminar --> transa 
		//UPDATE TB_XX SET CAMPO=?,...WHERE...
		
		try {
		u = manager.find(Usuario.class, 1);
		
		if (u == null) {
			System.out.println("Usuario no existe");
		}else {
			System.out.println(u);
		 }
		
		} catch (Exception e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		
	manager.close();
		
		
	}

}
