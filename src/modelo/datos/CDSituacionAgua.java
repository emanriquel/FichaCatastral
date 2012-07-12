package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CESituacionAgua;


public class CDSituacionAgua
{
    public ArrayList<CESituacionAgua> listarSituacionAgua()
    {
        ArrayList<CESituacionAgua> oLstSituacionAgua=new ArrayList<CESituacionAgua>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM situacion_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CESituacionAgua oCESituacionAgua=new CESituacionAgua();
                oCESituacionAgua.setIdSituacionAgua(rs.getInt(1));
                oCESituacionAgua.setSituacionAgua(rs.getString(2));
                oCESituacionAgua.setCodigo(rs.getInt(3));
                oLstSituacionAgua.add(oCESituacionAgua);
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
        return oLstSituacionAgua;

    }
}
