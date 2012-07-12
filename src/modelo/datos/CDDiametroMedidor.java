package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CECondicionConexionAgua;
import modelo.entidad.CEDiametroMedidor;


public class CDDiametroMedidor
{
    public ArrayList<CEDiametroMedidor> listarDiametroMedidor()
    {
        ArrayList<CEDiametroMedidor> oLstDiametroMedidor=new ArrayList<CEDiametroMedidor>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM diametro_medidor";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEDiametroMedidor oCEDiametroMedidor=new CEDiametroMedidor();
                oCEDiametroMedidor.setIdDiametroMedidor(rs.getInt(1));
                oCEDiametroMedidor.setDiametroMedidor(rs.getString(2));
                oCEDiametroMedidor.setCodigo(rs.getInt(3));
                oLstDiametroMedidor.add(oCEDiametroMedidor);
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
            catch (SQLException ex)
            {

            }
        
        }
      return oLstDiametroMedidor;
    }
}
