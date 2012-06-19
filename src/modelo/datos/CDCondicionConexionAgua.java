package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.acceso.ConexionBD;
import modelo.entidad.CECondicionConexionAgua;


public class CDCondicionConexionAgua
{
    public  ArrayList<CECondicionConexionAgua> listarCondicionConexionAgua()
    {
        ArrayList<CECondicionConexionAgua> oLstCondicionConexionAgua=new ArrayList<CECondicionConexionAgua>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM condicion_conexion_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECondicionConexionAgua oCECondicionConexionAgua=new CECondicionConexionAgua();
                oCECondicionConexionAgua.setIdCondicionConexionAgua(rs.getInt(1));
                oCECondicionConexionAgua.setCondicionConexionAgua(rs.getString(2));
                oCECondicionConexionAgua.setCodigo(rs.getInt(3));
                oLstCondicionConexionAgua.add(oCECondicionConexionAgua);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCondicionConexionAgua;

    }
}
