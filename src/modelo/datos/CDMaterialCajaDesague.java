package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMaterialCajaDesague;


public class CDMaterialCajaDesague
{
    public ArrayList<CEMaterialCajaDesague> listarMaterialCajaDesague()
    {
        ArrayList<CEMaterialCajaDesague> oLstMaterialCajaDesague=new ArrayList<CEMaterialCajaDesague>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM material_caja_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEMaterialCajaDesague oCEMaterialCajaDesague=new CEMaterialCajaDesague();
                oCEMaterialCajaDesague.setIdMaterialCajaDesague(rs.getInt(1));
                oCEMaterialCajaDesague.setMaterialCajaDesague(rs.getString(2));
                oCEMaterialCajaDesague.setCodigo(rs.getInt(3));
                oLstMaterialCajaDesague.add(oCEMaterialCajaDesague);
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
        return oLstMaterialCajaDesague;

    }
}
