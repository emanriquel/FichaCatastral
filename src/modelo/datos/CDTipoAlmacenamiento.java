package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoAlmacenamiento;


public class CDTipoAlmacenamiento
{
    public ArrayList<CETipoAlmacenamiento> listarTipoAlmacenamiento()
    {
        ArrayList<CETipoAlmacenamiento> oLstTipoAlmacenamiento=new ArrayList<CETipoAlmacenamiento>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM tipo_almacenamiento";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoAlmacenamiento oCETipoAlmacenamiento=new CETipoAlmacenamiento();
                oCETipoAlmacenamiento.setIdTipoAlmacenamiento(rs.getInt(1));
                oCETipoAlmacenamiento.setTipoAlmacenamiento(rs.getString(2));
                oCETipoAlmacenamiento.setCodigo(rs.getInt(3));
                oLstTipoAlmacenamiento.add(oCETipoAlmacenamiento);
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
        return oLstTipoAlmacenamiento;

    }
}
