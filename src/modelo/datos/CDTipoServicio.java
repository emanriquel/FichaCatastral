package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoServicio;


public class CDTipoServicio
{
    public ArrayList<CETipoServicio> listarTipoServicio()
    {
        ArrayList<CETipoServicio> oLstTipoServicio=new ArrayList<CETipoServicio>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM tipo_servicio";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoServicio oCETipoServicio=new CETipoServicio();
                oCETipoServicio.setIdTipoServicio(rs.getInt(1));
                oCETipoServicio.setTipoServicio(rs.getString(2));
                oCETipoServicio.setCodigo(rs.getInt(3));
                oLstTipoServicio.add(oCETipoServicio);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstTipoServicio;

    }
}
