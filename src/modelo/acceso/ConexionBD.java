package modelo.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;


public class ConexionBD
{

    public static String cone = "Conexion.properties";
    
    public static Connection obtenerConexion()
    {
         Connection cnn= null;
         try
		 {
            Properties props = new Properties();
            props.load(ConexionBD.class.getResourceAsStream(cone));

            String drivers = props.getProperty("jdbc.drivers");            
            Class.forName(drivers);
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            cnn = DriverManager.getConnection( url, username, password );
                  
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error en Conexion");
             cnn= null;
         }

         return cnn;
   }
}
