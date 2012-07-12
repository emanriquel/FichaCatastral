package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoPropiedadInquilino;


public class CDTipoPropiedadInquilino
{
    public ArrayList<CETipoPropiedadInquilino> listarTipoPropiedadInquilino()
    {
        ArrayList<CETipoPropiedadInquilino> oLstTipoPropiedadInquilino=new ArrayList<CETipoPropiedadInquilino>();
          Connection conn = ConexionBD.obtenerConexion();
        try
        {
          
            String sql = "SELECT * FROM tipo_propiedad_inquilino";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoPropiedadInquilino oCETipoPropiedadInquilino=new CETipoPropiedadInquilino();
                oCETipoPropiedadInquilino.setIdTipoPropiedadInquilino(rs.getInt(1));
                oCETipoPropiedadInquilino.setTipoPropiedadInquilino(rs.getString(2));
                oCETipoPropiedadInquilino.setCodigo(rs.getInt(3));
                oLstTipoPropiedadInquilino.add(oCETipoPropiedadInquilino);
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
        return oLstTipoPropiedadInquilino;

    }
}
