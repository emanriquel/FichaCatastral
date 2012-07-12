package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEDiametroConexionAgua;


public class CDDiametroConexionAgua
{
    public ArrayList<CEDiametroConexionAgua> listarDiametroConexionAgua()
    {
        ArrayList<CEDiametroConexionAgua> oLstDiametroConexionAgua=new ArrayList<CEDiametroConexionAgua>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM diametro_conexion_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEDiametroConexionAgua oCEDiametroConexionAgua=new CEDiametroConexionAgua();
                oCEDiametroConexionAgua.setIdDiametroConexionAgua(rs.getInt(1));
                oCEDiametroConexionAgua.setDiametroConexionAgua(rs.getString(2));
                oCEDiametroConexionAgua.setCodigo(rs.getInt(3));
                oLstDiametroConexionAgua.add(oCEDiametroConexionAgua);
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
                catch (SQLException ex) {

                }
            }
        return oLstDiametroConexionAgua;

    }
}
