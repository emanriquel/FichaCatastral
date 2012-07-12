package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEVereda;


public class CDVereda
{
    public ArrayList<CEVereda> listarVereda()
    {
        ArrayList<CEVereda> oLstVereda=new ArrayList<CEVereda>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM vereda";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEVereda oCEVereda=new CEVereda();
                oCEVereda.setIdVereda(rs.getInt(1));
                oCEVereda.setVereda(rs.getString(2));
                oCEVereda.setCodigo(rs.getInt(3));
                oLstVereda.add(oCEVereda);
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
        return oLstVereda;

    }
}
