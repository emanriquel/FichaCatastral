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
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
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
        return oLstSituacionAgua;

    }
}
