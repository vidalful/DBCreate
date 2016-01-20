package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexionBD.Conexion;
import conexionBD.Gestion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class FrmGenerate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGenerate frame = new FrmGenerate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmGenerate() {
		setTitle("Sistema de Creaci\u00F3n de Bases de Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarBase();
				
			}
		});
		btnExportar.setBounds(181, 189, 89, 23);
		contentPane.add(btnExportar);
		
		JButton btnRestaurar = new JButton("Restaurar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restaurar();
				
			}
		});
		btnRestaurar.setBounds(55, 189, 89, 23);
		contentPane.add(btnRestaurar);
	}
	protected void restaurar() {
		JOptionPane.showMessageDialog(null, "Restaurando Base");
		
		 try {
		      Process p = Runtime
		            .getRuntime()
		            .exec("C:/wamp/bin/mysql/mysql5.1.53/bin/mysql -u root -ppassword database");
		 
		      OutputStream os = p.getOutputStream();
		      FileInputStream fis = new FileInputStream("Generate.sql");
		      byte[] buffer = new byte[1000];
		 
		      int leido = fis.read(buffer);
		      while (leido > 0) {
		         os.write(buffer, 0, leido);
		         leido = fis.read(buffer);
		      }
		 
		      os.flush();
		      os.close();
		      fis.close();
		 
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		}
	
	Gestion objGestion=new Gestion();


	protected void exportarBase() {
		try{
			
			Process p = Runtime
	            .getRuntime()
	            .exec("C:/wamp/bin/mysql/mysql5.1.53/bin/mysqldump -u root -ppassword database");
	 
	      InputStream is =p.getInputStream();
	      FileOutputStream fos = new FileOutputStream("Generate.sql");
	      byte[] buffer = new byte[1000];
	 
	      int leido = is.read(buffer);
	      while (leido > 0) {
	         fos.write(buffer, 0, leido);
	         leido = is.read(buffer);
	         JOptionPane.showMessageDialog(null, "guardado");
	      }
	 
	      fos.close();
	 
	   } catch (Exception e) {
	      e.printStackTrace();
	   }
		
	}
}
