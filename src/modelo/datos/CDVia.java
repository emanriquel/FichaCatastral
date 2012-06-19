/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEVia;
import modelo.entidad.CEVia;

/**
 *
 * @author Edwar
 */
public class CDVia {
    public CEVia DetalleVia(CEVia oCEVia)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CEVia> Lst = new ArrayList<CEVia>();
                  String sql = null;                  
                    sql = "SELECT * FROM Via WHERE idvia = "+oCEVia.getIdVia()+";";
                    
                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);                    

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {                        
                        oCEVia.setIdVia(resultado.getInt(1));                        
                        oCEVia.setCodigo(resultado.getInt(2));
                        oCEVia.setTipo(resultado.getString(3));
                        oCEVia.setNombreVia(resultado.getString(4));

                        Lst.add(oCEVia);
                    }
                    conexion.close();
                    return oCEVia;
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
    public ArrayList<CEVia> listarVia(int tipo,String Parametro)
    {
        ArrayList<CEVia> oLstVia=new ArrayList<CEVia>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = null;
            String SqlBase = "SELECT * FROM Via ";
                  switch(tipo)
                   {  
                      case 1:
                            sql = SqlBase+";";                            
                        break; 
                      case 2:                            
                            sql = SqlBase+" WHERE NombreVia LIKE CONCAT('"+Parametro+"', '%')";                            
                        break;                       
                   }
            
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEVia oCEVia=new CEVia();
                oCEVia.setIdVia(rs.getInt(1));
                oCEVia.setCodigo(rs.getInt(2));
                oCEVia.setTipo(rs.getString(3));
                oCEVia.setNombreVia(rs.getString(4));
                oLstVia.add(oCEVia);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstVia;

    }
}
