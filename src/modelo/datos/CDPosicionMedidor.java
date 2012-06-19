package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEPosicionMedidor;


public class CDPosicionMedidor
{
    public ArrayList<CEPosicionMedidor> listarPosicionMedidor()
    {
        ArrayList<CEPosicionMedidor> oLstPosicionMedidor=new ArrayList<CEPosicionMedidor>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM posicion_medidor";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEPosicionMedidor oCEPosicionMedidor=new CEPosicionMedidor();
                oCEPosicionMedidor.setIdPosicionMedidor(rs.getInt(1));
                oCEPosicionMedidor.setPosicionMedidor(rs.getString(2));
                oCEPosicionMedidor.setCodigo(rs.getInt(3));
                oLstPosicionMedidor.add(oCEPosicionMedidor);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstPosicionMedidor;

    }
}
