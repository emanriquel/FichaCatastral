package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoPredio;


public class CDTipoPredio
{
    public ArrayList<CETipoPredio> listarTipoPredio()
    {
        ArrayList<CETipoPredio> oLstTipoPredio=new ArrayList<CETipoPredio>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM tipo_predio";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoPredio oCETipoPredio=new CETipoPredio();
                oCETipoPredio.setIdTipoPredio(rs.getInt(1));
                oCETipoPredio.setTipoPredio(rs.getString(2));
                oCETipoPredio.setCodigo(rs.getInt(3));
                oLstTipoPredio.add(oCETipoPredio);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstTipoPredio;

    }
}
