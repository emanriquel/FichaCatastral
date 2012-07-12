package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEEstadoMedidor;


public class CDEstadoMedidor
{
    public ArrayList<CEEstadoMedidor> listarEstadoMedidor()
    {
        ArrayList<CEEstadoMedidor> oLstEstadoMedidor=new ArrayList<CEEstadoMedidor>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM estado_medidor";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEEstadoMedidor oCEEstadoMedidor=new CEEstadoMedidor();
                oCEEstadoMedidor.setIdEstadoMedidor(rs.getInt(1));
                oCEEstadoMedidor.setEstadoMedidor(rs.getString(2));
                oCEEstadoMedidor.setCodigo(rs.getInt(3));
                oLstEstadoMedidor.add(oCEEstadoMedidor);
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
        return oLstEstadoMedidor;

    }
}
