package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEUsoPredio;


public class CDUsoPredio
{
      public CEUsoPredio DetalleServicio(CEUsoPredio oCEUsoPredio)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {

                  String sql = null;
                    sql = "SELECT * FROM uso_predio WHERE IdUsoPredio = "+oCEUsoPredio.getIdUsoPredio()+";";

                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {
                        oCEUsoPredio.setIdUsoPredio(resultado.getInt(1));
                        oCEUsoPredio.setCodigo(resultado.getInt(3));
                        oCEUsoPredio.setUsoPredio(resultado.getString(2));



                    }
                    conexion.close();
                    return oCEUsoPredio;
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
                 finally
           {
                try
                {
                    conexion.close();
                }
                catch (SQLException ex) {

                }
            }
         }
    public ArrayList<CEUsoPredio> listarUsoPredio()
    {
        ArrayList<CEUsoPredio> oLstUsoPredio=new ArrayList<CEUsoPredio>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
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
         finally
           {
                try
                {
                    conn.close();
                }
                catch (SQLException ex) {

                }
            }
        return oLstUsoPredio;

    }
}
