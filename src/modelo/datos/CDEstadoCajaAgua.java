package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEEstadoCajaAgua;


public class CDEstadoCajaAgua
{
    public ArrayList<CEEstadoCajaAgua> listarEstadoCajaAgua()
    {
        ArrayList<CEEstadoCajaAgua> oLstEstadoCajaAgua=new ArrayList<CEEstadoCajaAgua>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM estado_caja_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEEstadoCajaAgua oCEEstadoCajaAgua=new CEEstadoCajaAgua();
                oCEEstadoCajaAgua.setIdEstadoCajaAgua(rs.getInt(1));
                oCEEstadoCajaAgua.setEstadoCajaAgua(rs.getString(2));
                oCEEstadoCajaAgua.setCodigo(rs.getInt(3));
                oLstEstadoCajaAgua.add(oCEEstadoCajaAgua);
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
        return oLstEstadoCajaAgua;

    }
}
