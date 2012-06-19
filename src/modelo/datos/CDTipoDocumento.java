package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoDocumento;


public class CDTipoDocumento
{
    public ArrayList<CETipoDocumento> listarTipoDocumento()
    {
        ArrayList<CETipoDocumento> oLstTipoDocumento=new ArrayList<CETipoDocumento>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM tipo_documento";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoDocumento oCETipoDocumento=new CETipoDocumento();
                oCETipoDocumento.setIdTipoDocumento(rs.getInt(1));
                oCETipoDocumento.setTipoDocumento(rs.getString(2));
                oCETipoDocumento.setCodigo(rs.getInt(3));
                oLstTipoDocumento.add(oCETipoDocumento);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstTipoDocumento;

    }
}
