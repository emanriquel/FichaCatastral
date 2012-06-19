package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEUbiCajaConexDesague;


public class CDUbiCajaConexDesague
{
    public ArrayList<CEUbiCajaConexDesague> listarUbiCajaConexDesague()
    {
        ArrayList<CEUbiCajaConexDesague> oLstUbiCajaConexDesague=new ArrayList<CEUbiCajaConexDesague>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM ubi_caja_conex_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEUbiCajaConexDesague oCEUbiCajaConexDesague=new CEUbiCajaConexDesague();
                oCEUbiCajaConexDesague.setIdUbiCajaConexDesague(rs.getInt(1));
                oCEUbiCajaConexDesague.setUbiCajaConexDesague(rs.getString(2));
                oCEUbiCajaConexDesague.setCodigo(rs.getInt(3));
                oLstUbiCajaConexDesague.add(oCEUbiCajaConexDesague);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstUbiCajaConexDesague;

    }
}
