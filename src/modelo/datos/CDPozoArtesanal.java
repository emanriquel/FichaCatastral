package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEPozoArtesanal;


public class CDPozoArtesanal
{
    public ArrayList<CEPozoArtesanal> listarPozoArtesenal()
    {
        ArrayList<CEPozoArtesanal> oLstPozoArtesenal=new ArrayList<CEPozoArtesanal>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM pozo_artesanal";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEPozoArtesanal oCEPozoArtesanal=new CEPozoArtesanal();
                oCEPozoArtesanal.setIdPozoArtesanal(rs.getInt(1));
                oCEPozoArtesanal.setPozoArtesanal(rs.getString(2));
                oCEPozoArtesanal.setCodigo(rs.getInt(3));
                oLstPozoArtesenal.add(oCEPozoArtesanal);
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
        return oLstPozoArtesenal;

    }
}
