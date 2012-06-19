package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CECondicionConexionDesague;


public class CDCondicionConexionDesague
{
    public ArrayList<CECondicionConexionDesague> listarCondicionConexionDesague()
    {
        ArrayList<CECondicionConexionDesague> oLstCondicionConexionDesague=new ArrayList<CECondicionConexionDesague>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM condicion_conexion_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECondicionConexionDesague oCECondicionConexionDesague=new CECondicionConexionDesague();
                oCECondicionConexionDesague.setIdCondicionConexionDesague(rs.getInt(1));
                oCECondicionConexionDesague.setCondicionConexionDesague(rs.getString(2));
                oCECondicionConexionDesague.setCodigo(rs.getInt(3));
                oLstCondicionConexionDesague.add(oCECondicionConexionDesague);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCondicionConexionDesague;

    }
}
