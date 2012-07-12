package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEPavimentacion;

public class CDPavimentacion
{
  public ArrayList<CEPavimentacion> listarPavimentacion()
    {
      Connection conn = ConexionBD.obtenerConexion();
        ArrayList<CEPavimentacion> oLstPavimentacion=new ArrayList<CEPavimentacion>();
        try
        {
            
            String sql = "SELECT * FROM pavimentacion";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            while(rs.next())
            {
                CEPavimentacion oCEPavimentacion=new CEPavimentacion();
                oCEPavimentacion.setIdPavimentacion(rs.getInt(1));
                oCEPavimentacion.setPavimentacion(rs.getString(2));
                oCEPavimentacion.setCodigo(rs.getInt(3));
                oLstPavimentacion.add(oCEPavimentacion);
            }
        }
        catch (SQLException ex)
        {

        }
         finally
           {
                try
                {
                    conn.close();
                }
                catch (SQLException ex) {

                }
            }
        return oLstPavimentacion;

    }
}
