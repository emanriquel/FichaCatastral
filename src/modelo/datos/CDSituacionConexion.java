package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CESituacionConexion;


public class CDSituacionConexion
{
    public ArrayList<CESituacionConexion> listarSituacionConexion()
    {
        ArrayList<CESituacionConexion> oLstSituacionConexion=new ArrayList<CESituacionConexion>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM situacion_Conexion";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CESituacionConexion oCESituacionConexion=new CESituacionConexion();
                oCESituacionConexion.setIdSituacionConexion(rs.getInt(1));
                oCESituacionConexion.setSituacionConexion(rs.getString(2));
                oCESituacionConexion.setCodigo(rs.getInt(3));
                oLstSituacionConexion.add(oCESituacionConexion);
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
        return oLstSituacionConexion;

    }
}
