package conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Gestion {
	Statement sentencia;
	Connection cadenaConexion;
	ResultSet cdr;
	ResultSet cdrr;
	Conexion objConexion= new Conexion();
	public Gestion(){
		cadenaConexion=objConexion.conectandoBD();
		
	}
	
	public void ejecutarSentencia(String sentenciaSQL){
		try {
			sentencia=cadenaConexion.createStatement();
			sentencia.execute(sentenciaSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio el error \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
		}

	}

	public ResultSet ejecutarConsulta(String sentenciaSQL) {
		try{
			sentencia=cadenaConexion.createStatement();
			cdr=sentencia.executeQuery(sentenciaSQL);
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Ocurrio el error \n"+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
		return cdr;
	}

}
//Vidal Andrade