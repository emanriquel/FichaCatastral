package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEEstadoCajaDesague;


public class CDEstadoCajaDesague
{
    public ArrayList<CEEstadoCajaDesague> listarEstadoCajaDesague()
    {
        ArrayList<CEEstadoCajaDesague> oLstEstadoCajaDesague=new ArrayList<CEEstadoCajaDesague>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM estado_caja_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEEstadoCajaDesague oCEEstadoCajaDesague=new CEEstadoCajaDesague();
                oCEEstadoCajaDesague.setIdEstadoCajaDesague(rs.getInt(1));
                oCEEstadoCajaDesague.setEstadoCajaDesague(rs.getString(2));
                oCEEstadoCajaDesague.setCodigo(rs.getInt(3));
                oLstEstadoCajaDesague.add(oCEEstadoCajaDesague);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstEstadoCajaDesague;

    }
}
