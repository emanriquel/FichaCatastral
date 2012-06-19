package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoPropiedad;


public class CDTipoPropiedad
{
    public ArrayList<CETipoPropiedad> listarTipoPropiedad()
    {
        ArrayList<CETipoPropiedad> oLstTipoPropiedad=new ArrayList<CETipoPropiedad>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM tipo_propiedad";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoPropiedad oCETipoPropiedad=new CETipoPropiedad();
                oCETipoPropiedad.setIdTipoPropiedad(rs.getInt(1));
                oCETipoPropiedad.setTipoPropiedad(rs.getString(2));
                oCETipoPropiedad.setCodigo(rs.getInt(3));
                oLstTipoPropiedad.add(oCETipoPropiedad);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstTipoPropiedad;

    }
}
