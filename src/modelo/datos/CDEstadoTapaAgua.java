package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEEstadoTapaAgua;


public class CDEstadoTapaAgua
{
    public ArrayList<CEEstadoTapaAgua> listarEstadoTapaAgua()
    {
        ArrayList<CEEstadoTapaAgua> oLstEstadoTapaAgua=new ArrayList<CEEstadoTapaAgua>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM estado_tapa_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEEstadoTapaAgua oCEEstadoTapaAgua=new CEEstadoTapaAgua();
                oCEEstadoTapaAgua.setIdEstadoTapaAgua(rs.getInt(1));
                oCEEstadoTapaAgua.setEstadoTapaAgua(rs.getString(2));
                oCEEstadoTapaAgua.setCodigo(rs.getInt(3));
                oLstEstadoTapaAgua.add(oCEEstadoTapaAgua);
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
            catch (SQLException ex)
            {

            }

        }
        return oLstEstadoTapaAgua;

    }
}
