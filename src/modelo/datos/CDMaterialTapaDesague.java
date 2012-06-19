package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMaterialTapaDesague;


public class CDMaterialTapaDesague
{
    public ArrayList<CEMaterialTapaDesague> listarMaterialTapaDesague()
    {
        ArrayList<CEMaterialTapaDesague> oLstMaterialTapaDesague=new ArrayList<CEMaterialTapaDesague>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM material_tapa_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEMaterialTapaDesague oCEMaterialTapaDesague=new CEMaterialTapaDesague();
                oCEMaterialTapaDesague.setIdMaterialTapaDesague(rs.getInt(1));
                oCEMaterialTapaDesague.setMaterialTapaDesague(rs.getString(2));
                oCEMaterialTapaDesague.setCodigo(rs.getInt(3));
                oLstMaterialTapaDesague.add(oCEMaterialTapaDesague);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstMaterialTapaDesague;

    }
}
