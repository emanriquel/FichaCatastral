package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEUbiCajaConexAgua;


public class CDUbiCajaConexAgua
{
    public ArrayList<CEUbiCajaConexAgua> listarUbiCajaConexAgua()
    {
        ArrayList<CEUbiCajaConexAgua> oLstUbiCajaConexAgua=new ArrayList<CEUbiCajaConexAgua>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM ubi_caja_conex_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEUbiCajaConexAgua oCEUbiCajaConexAgua=new CEUbiCajaConexAgua();
                oCEUbiCajaConexAgua.setIdUbiCajaConexAgua(rs.getInt(1));
                oCEUbiCajaConexAgua.setUbiCajaConexAgua(rs.getString(2));
                oCEUbiCajaConexAgua.setCodigo(rs.getInt(3));
                oLstUbiCajaConexAgua.add(oCEUbiCajaConexAgua);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstUbiCajaConexAgua;

    }
}
