package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMedioAbastecimiento;


public class CDMedioAbastecimiento
{
    public ArrayList<CEMedioAbastecimiento> listarMedioAbastecimiento()
    {
        ArrayList<CEMedioAbastecimiento> oLstMedioAbastecimiento=new ArrayList<CEMedioAbastecimiento>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM medio_abastecimiento";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEMedioAbastecimiento oCEMedioAbastecimiento=new CEMedioAbastecimiento();
                oCEMedioAbastecimiento.setIdMedioAbastecimiento(rs.getInt(1));
                oCEMedioAbastecimiento.setMedioAbastecimiento(rs.getString(2));
                oCEMedioAbastecimiento.setCodigo(rs.getInt(3));
                oLstMedioAbastecimiento.add(oCEMedioAbastecimiento);
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
        return oLstMedioAbastecimiento;

    }
}
