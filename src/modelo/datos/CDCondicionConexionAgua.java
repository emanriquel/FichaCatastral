package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.acceso.ConexionBD;
import modelo.entidad.CECondicionConexionAgua;


public class CDCondicionConexionAgua
{
    public  ArrayList<CECondicionConexionAgua> listarCondicionConexionAgua()
    {
        ArrayList<CECondicionConexionAgua> oLstCondicionConexionAgua=new ArrayList<CECondicionConexionAgua>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT * FROM condicion_conexion_agua";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECondicionConexionAgua oCECondicionConexionAgua=new CECondicionConexionAgua();
                oCECondicionConexionAgua.setIdCondicionConexionAgua(rs.getInt(1));
                oCECondicionConexionAgua.setCondicionConexionAgua(rs.getString(2));
                oCECondicionConexionAgua.setCodigo(rs.getInt(3));
                oLstCondicionConexionAgua.add(oCECondicionConexionAgua);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCondicionConexionAgua;

    }
    public CECondicionConexionAgua DetalleCondicionConexionAgua(CECondicionConexionAgua oCECondicionConexionAgua)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CECondicionConexionAgua> Lst = new ArrayList<CECondicionConexionAgua>();
                  String sql = null;
                    sql = "SELECT * FROM Condicion_Conexion_Agua WHERE IdCondicionConexionAgua = "+oCECondicionConexionAgua.getIdCondicionConexionAgua()+";";

                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {
                        oCECondicionConexionAgua.setIdCondicionConexionAgua(resultado.getInt(1));
                        oCECondicionConexionAgua.setCodigo(resultado.getInt(3));
                        oCECondicionConexionAgua.setCondicionConexionAgua(resultado.getString(2));


                        Lst.add(oCECondicionConexionAgua);
                    }
                    conexion.close();
                    return oCECondicionConexionAgua;
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
}
