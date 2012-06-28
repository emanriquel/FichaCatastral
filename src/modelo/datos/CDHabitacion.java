/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEHabilitacion;

/**
 *
 * @author Edwar
 */
public class CDHabitacion {
    public CEHabilitacion DetalleVia(CEHabilitacion oCEHabitacion)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CEHabilitacion> Lst = new ArrayList<CEHabilitacion>();
                  String sql = null;                  
                    sql = "SELECT * FROM habilitacion WHERE idhabilitacion = "+oCEHabitacion.getIdHabitacion()+";";
                    
                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);                    

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {                        
                        oCEHabitacion.setIdHabilitacion(resultado.getInt(1));
                        oCEHabitacion.setCodigo(resultado.getInt(2));
                        oCEHabitacion.setTipo(resultado.getString(3));
                        oCEHabitacion.setNombreHabilitacion(resultado.getString(4));

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
    public ArrayList<CEHabilitacion> listarHabilitacion(int tipo,String Parametro)
    {
        ArrayList<CEHabilitacion> oLstHabilitacion=new ArrayList<CEHabilitacion>();
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
                CEHabilitacion oCEHabitacion=new CEHabilitacion();
                oCEHabitacion.setIdHabilitacion(rs.getInt(1));
                oCEHabitacion.setCodigo(rs.getInt(2));
                oCEHabitacion.setTipo(rs.getString(3));
                oCEHabitacion.setNombreHabilitacion(rs.getString(4));
                oLstHabilitacion.add(oCEHabitacion);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstHabilitacion;

    }
   public boolean abmHabilitacion(CEHabilitacion oCEMedida,int valor)
  {
        try {
            Connection conn = ConexionBD.obtenerConexion();
            String sql ;
            if(valor==1)
            {
            sql = "insert into Habilitacion(Codigo,Tipo,NombreHabilitacion) values (" + oCEMedida.getCodigo() + ",'" + oCEMedida.getTipo()+ "','" + oCEMedida.getNombreHabilitacion()+ "')";
            }
            else
            {
                if(valor==2)
                {
                sql = "update Habilitacion set NombreHabilitacion='"+oCEMedida.getNombreHabilitacion()+
                        "',Tipo='"+oCEMedida.getTipo()+
                       "',Codigo="+oCEMedida.getCodigo()+
                       " where IdHabilitacion="+oCEMedida.getIdHabitacion();
                }
                else
                {
                    sql = "delete from Habilitacion"+
                       " where IdHabilitacion="+oCEMedida.getIdHabitacion();
                }
            }
            PreparedStatement sp = conn.prepareStatement(sql);
            int result = sp.executeUpdate();
            if(result==1) return true;
            else return false;

        } catch (SQLException ex) {
            Logger.getLogger(CDHabitacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


  }
}
