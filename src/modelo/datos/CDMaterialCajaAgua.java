package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMaterialCajaAgua;


public class CDMaterialCajaAgua
{
    public ArrayList<CEMaterialCajaAgua> listarMaterialCajaAgua()
    {
        ArrayList<CEMaterialCajaAgua> oLstMaterialCajaAgua=new ArrayList<CEMaterialCajaAgua>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM material_caja_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEMaterialCajaAgua oCEMaterialCajaAgua=new CEMaterialCajaAgua();
                oCEMaterialCajaAgua.setIdMaterialCajaAgua(rs.getInt(1));
                oCEMaterialCajaAgua.setMaterialCajaAgua(rs.getString(2));
                oCEMaterialCajaAgua.setCodigo(rs.getInt(3));
                oLstMaterialCajaAgua.add(oCEMaterialCajaAgua);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstMaterialCajaAgua;

    }
}
