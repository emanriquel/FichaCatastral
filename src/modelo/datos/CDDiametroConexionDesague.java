package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEDiametroConexionDesague;


public class CDDiametroConexionDesague
{
    public ArrayList<CEDiametroConexionDesague> listarDiametroConexionDesague()
    {
        ArrayList<CEDiametroConexionDesague> oLstDiametroConexionDesague=new ArrayList<CEDiametroConexionDesague>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM diametro_conexion_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEDiametroConexionDesague oCEDiametroConexionDesague=new CEDiametroConexionDesague();
                oCEDiametroConexionDesague.setIdDiametroConexionDesague(rs.getInt(1));
                oCEDiametroConexionDesague.setDiametroConexionDesague(rs.getString(2));
                oCEDiametroConexionDesague.setCodigo(rs.getInt(3));
                oLstDiametroConexionDesague.add(oCEDiametroConexionDesague);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstDiametroConexionDesague;

    }
}
