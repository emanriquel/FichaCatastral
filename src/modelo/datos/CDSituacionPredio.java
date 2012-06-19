package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CESituacionPredio;


public class CDSituacionPredio
{
    public ArrayList<CESituacionPredio> listarSituacionPredio()
    {
        ArrayList<CESituacionPredio> oLstSituacionPredio=new ArrayList<CESituacionPredio>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM situacion_predio";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CESituacionPredio oCESituacionPredio=new CESituacionPredio();
                oCESituacionPredio.setIdSituacionPredio(rs.getInt(1));
                oCESituacionPredio.setSituacionPredio(rs.getString(2));
                oCESituacionPredio.setCodigo(rs.getInt(3));
                oLstSituacionPredio.add(oCESituacionPredio);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstSituacionPredio;

    }
}
