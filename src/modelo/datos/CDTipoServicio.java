package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.acceso.ConexionBD;
import modelo.entidad.CETipoServicio;


public class CDTipoServicio
{
    public CETipoServicio DetalleServicio(CETipoServicio oCETipoServicio)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CETipoServicio> Lst = new ArrayList<CETipoServicio>();
                  String sql = null;
                    sql = "SELECT * FROM tipo_servicio WHERE IdTipoServicio = "+oCETipoServicio.getIdTipoServicio()+";";

                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {
                        oCETipoServicio.setIdTipoServicio(resultado.getInt(1));
                        oCETipoServicio.setCodigo(resultado.getInt(3));
                        oCETipoServicio.setTipoServicio(resultado.getString(2));


                        Lst.add(oCETipoServicio);
                    }
                    conexion.close();
                    return oCETipoServicio;
                    }
               return null;
                }
                catch(SQLException e)
            {
                e.printStackTrace();
                return null;
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
         }
    public ArrayList<CETipoServicio> listarTipoServicio()
    {
        ArrayList<CETipoServicio> oLstTipoServicio=new ArrayList<CETipoServicio>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM tipo_servicio";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CETipoServicio oCETipoServicio=new CETipoServicio();
                oCETipoServicio.setIdTipoServicio(rs.getInt(1));
                oCETipoServicio.setTipoServicio(rs.getString(2));
                oCETipoServicio.setCodigo(rs.getInt(3));
                oLstTipoServicio.add(oCETipoServicio);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstTipoServicio;

    }
}
