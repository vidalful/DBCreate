package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	private String nombreBD;
	private String usuario;
	private String pass;
	private String url;
	String conectarBD="Generate";
	//JOptionPane.showInputDialog(null, "Ingresa el nombre de la base de datos", "Solicitud",JOptionPane.QUESTION_MESSAGE)
	
	public Conexion(){
		nombreBD=conectarBD;
		usuario="root";
		pass=null;
		url="jdbc:mysql://localhost/"+nombreBD;
		
	}
	
	public Connection conectandoBD(){
	Connection lineaConexion=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			lineaConexion=DriverManager.getConnection(url,usuario,pass);
			JOptionPane.showMessageDialog(null,"Conexion exitosa","Aviso",JOptionPane.INFORMATION_MESSAGE);
			
		
		}catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null,"No se pudo crear la instancia","Error",JOptionPane.ERROR_MESSAGE);
			
			
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null,"Acceso denegado a la clase","Error",JOptionPane.ERROR_MESSAGE);
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"No se encontro la clase","Error",JOptionPane.ERROR_MESSAGE);
			
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Error con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				
		}
		return lineaConexion;
	}
	public static void main(String[] args) {
		Conexion objC=new Conexion();
		objC.conectandoBD();

	}

}
//Vidal Andrade

