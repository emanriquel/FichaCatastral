/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEHabitacion;

/**
 *
 * @author Edwar
 */
public class CDHabitacion {
    public CEHabitacion DetalleVia(CEHabitacion oCEHabitacion)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CEHabitacion> Lst = new ArrayList<CEHabitacion>();
                  String sql = null;                  
                    sql = "SELECT * FROM habilitacion WHERE idhabilitacion = "+oCEHabitacion.getIdHabitacion()+";";
                    
                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);                    

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {                        
                        oCEHabitacion.setIdHabitacion(resultado.getInt(1));                        
                        oCEHabitacion.setCodigo(resultado.getInt(2));
                        oCEHabitacion.setTipo(resultado.getString(3));
                        oCEHabitacion.setNombreHabitacion(resultado.getString(4));

                        Lst.add(oCEHabitacion);
                    }
                    conexion.close();
                    return oCEHabitacion;
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
    public ArrayList<CEHabitacion> listarHabilitacion(int tipo,String Parametro)
    {
        ArrayList<CEHabitacion> oLstHabilitacion=new ArrayList<CEHabitacion>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = null;
            String SqlBase = "SELECT * FROM habilitacion ";
                  switch(tipo)
                   {  
                      case 1:
                            sql = SqlBase+";";                            
                        break; 
                      case 2:                            
                            sql = SqlBase+" WHERE NombreHabilitacion LIKE CONCAT('"+Parametro+"', '%')";                            
                        break;                       
                   }
            
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEHabitacion oCEHabitacion=new CEHabitacion();
                oCEHabitacion.setIdHabitacion(rs.getInt(1));
                oCEHabitacion.setCodigo(rs.getInt(2));
                oCEHabitacion.setTipo(rs.getString(3));
                oCEHabitacion.setNombreHabitacion(rs.getString(4));
                oLstHabilitacion.add(oCEHabitacion);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstHabilitacion;

    }
}
