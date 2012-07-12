package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CESeguridadMedidor;


public class CDSeguridadMedidor
{
    public ArrayList<CESeguridadMedidor> listarSeguridadMedidor()
    {
        ArrayList<CESeguridadMedidor> oLstSeguridadMedidor=new ArrayList<CESeguridadMedidor>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM seguridad_medidor";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CESeguridadMedidor oCESeguridadMedidor=new CESeguridadMedidor();
                oCESeguridadMedidor.setIdSeguridadMedidor(rs.getInt(1));
                oCESeguridadMedidor.setSeguridadMedidor(rs.getString(2));
                oCESeguridadMedidor.setCodigo(rs.getInt(3));
                oLstSeguridadMedidor.add(oCESeguridadMedidor);
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
        return oLstSeguridadMedidor;

    }
}
