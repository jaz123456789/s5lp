package app;

	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

	public class Demo08 {
		// Listado de Usuarios según un tipo (filtro)
		public static void main(String[] args) {
			String usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
			String clave = JOptionPane.showInputDialog("Ingrese su clave:");
			
			
			
			
			
			
			
			
			
			// llamar a la conexión
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
			// crear un manejador de las entidades
			EntityManager manager = fabrica.createEntityManager();
			
			//select * from tb_xx where usir_usuario = ? and cla_usua = ?
			
			String slq = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
			
			try {
				Usuario u = manager.createQuery(slq, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
				
				
				
					System.out.println("Codigo....:" + u.getCod_usua());
					System.out.println("Nombre....:" + u.getCod_usua() + " " + u.getApe_usua());
					System.out.println("Tipo......:" + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
					System.out.println("..........................");
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario clave incorrecto");
			}
			
			
			manager.close();
			
			
		}
}
