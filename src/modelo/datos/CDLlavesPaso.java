package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CELlavesPaso;


public class CDLlavesPaso
{
    public ArrayList<CELlavesPaso> listarLlavesPaso()
    {
        ArrayList<CELlavesPaso> oLstLlavesPaso=new ArrayList<CELlavesPaso>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM llaves_paso";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CELlavesPaso oCELlavesPaso=new CELlavesPaso();
                oCELlavesPaso.setIdLlavesPaso(rs.getInt(1));
                oCELlavesPaso.setLlavesPaso(rs.getString(2));
                oCELlavesPaso.setCodigo(rs.getInt(3));
                oLstLlavesPaso.add(oCELlavesPaso);
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
        return oLstLlavesPaso;

    }
}
