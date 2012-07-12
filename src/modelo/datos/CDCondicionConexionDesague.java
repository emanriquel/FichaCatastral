package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.acceso.ConexionBD;
import modelo.entidad.CECondicionConexionDesague;


public class CDCondicionConexionDesague
{
    public ArrayList<CECondicionConexionDesague> listarCondicionConexionDesague()
    {
        ArrayList<CECondicionConexionDesague> oLstCondicionConexionDesague=new ArrayList<CECondicionConexionDesague>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT * FROM condicion_conexion_desague";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECondicionConexionDesague oCECondicionConexionDesague=new CECondicionConexionDesague();
                oCECondicionConexionDesague.setIdCondicionConexionDesague(rs.getInt(1));
                oCECondicionConexionDesague.setCondicionConexionDesague(rs.getString(2));
                oCECondicionConexionDesague.setCodigo(rs.getInt(3));
                oLstCondicionConexionDesague.add(oCECondicionConexionDesague);
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
        return oLstCondicionConexionDesague;

    }
    public CECondicionConexionDesague DetalleCondicionConexionDesague(CECondicionConexionDesague oCECondicionConexionDesague)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  String sql = null;
                    sql = "SELECT * FROM Condicion_Conexion_Desague WHERE IdCondicionConexionDesague = "+oCECondicionConexionDesague.getIdCondicionConexionDesague()+";";

                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {
                        oCECondicionConexionDesague.setIdCondicionConexionDesague(resultado.getInt(1));
                        oCECondicionConexionDesague.setCodigo(resultado.getInt(3));
                        oCECondicionConexionDesague.setCondicionConexionDesague(resultado.getString(2));

                    }
                    conexion.close();
                    return oCECondicionConexionDesague;
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

}
