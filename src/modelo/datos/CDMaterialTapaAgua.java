package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMaterialTapaAgua;


public class CDMaterialTapaAgua
{
    public ArrayList<CEMaterialTapaAgua> listarMaterialTapaAgua()
    {
        ArrayList<CEMaterialTapaAgua> oLstMaterialTapaAgua=new ArrayList<CEMaterialTapaAgua>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM material_tapa_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEMaterialTapaAgua oCEMaterialTapaAgua=new CEMaterialTapaAgua();
                oCEMaterialTapaAgua.setIdMaterialTapaAgua(rs.getInt(1));
                oCEMaterialTapaAgua.setMaterialTapaAgua(rs.getString(2));
                oCEMaterialTapaAgua.setCodigo(rs.getInt(3));
                oLstMaterialTapaAgua.add(oCEMaterialTapaAgua);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstMaterialTapaAgua;

    }
}
