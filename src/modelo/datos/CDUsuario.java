package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEUsuario;


public class CDUsuario
{
    public ArrayList<CEUsuario> listarUsuario()
    {
        ArrayList<CEUsuario> oLstUsuario=new ArrayList<CEUsuario>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM usuario";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEUsuario oCEUsuario=new CEUsuario();
                oCEUsuario.setIdUsuario(rs.getInt(1));
                oCEUsuario.setUsuario(rs.getString(2));
                oLstUsuario.add(oCEUsuario);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstUsuario;
    }
    public boolean verificarUsuario(String usuario, String password)
    {

        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT usuario,contrasenia FROM usuario us where us.usuario='"+usuario+"'";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            if(rs.next())
            {
                CEUsuario oCEUsuario=new CEUsuario();
                
                oCEUsuario.setUsuario(rs.getString(1));
                oCEUsuario.setPassword(rs.getString(2));

                if(oCEUsuario.getPassword().equals(password))
                {
                    return true;
                }
                return false;

            }
            return false;

        }
        catch (SQLException ex)
        {
            return false;
        }

    }
}
