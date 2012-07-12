package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEEstadoTapaDesague;


public class CDEstadoTapaDesague
{
    public ArrayList<CEEstadoTapaDesague> listarEstadoTapaDesague()
    {
        ArrayList<CEEstadoTapaDesague> oLstEstadoTapaDesague=new ArrayList<CEEstadoTapaDesague>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM estado_tapa_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEEstadoTapaDesague oCEEstadoTapaDesague=new CEEstadoTapaDesague();
                oCEEstadoTapaDesague.setIdEstadoTapaDesague(rs.getInt(1));
                oCEEstadoTapaDesague.setEstadoTapaDesague(rs.getString(2));
                oCEEstadoTapaDesague.setCodigo(rs.getInt(3));
                oLstEstadoTapaDesague.add(oCEEstadoTapaDesague);
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
        return oLstEstadoTapaDesague;

    }
}
