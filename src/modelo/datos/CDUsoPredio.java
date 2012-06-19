package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEUsoPredio;


public class CDUsoPredio
{
    public ArrayList<CEUsoPredio> listarUsoPredio()
    {
        ArrayList<CEUsoPredio> oLstUsoPredio=new ArrayList<CEUsoPredio>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM uso_predio";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEUsoPredio oCEUsoPredio=new CEUsoPredio();
                oCEUsoPredio.setIdUsoPredio(rs.getInt(1));
                oCEUsoPredio.setUsoPredio(rs.getString(2));
                oCEUsoPredio.setCodigo(rs.getInt(3));
                oLstUsoPredio.add(oCEUsoPredio);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstUsoPredio;

    }
}
