package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMedida;
import modelo.entidad.CEUsuario;


public class CDUsuario
{
    public ArrayList<CEUsuario> listarUsuario()
    {
        ArrayList<CEUsuario> oLstUsuario=new ArrayList<CEUsuario>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT us.IdUsuario,us.Usuario,us.Contrasenia,if(us.IdTipoUsuario=1,'Administrador','Limitado'),us.IdTipoUsuario FROM usuario us";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CEUsuario oCEUsuario=new CEUsuario();
                oCEUsuario.setIdUsuario(rs.getInt(1));
                oCEUsuario.setUsuario(rs.getString(2));
                oCEUsuario.setPassword(rs.getString(3));
                oCEUsuario.setTipoUsuario(rs.getString(4));
                oCEUsuario.setIdTipoUsuario(rs.getInt(5));
                oLstUsuario.add(oCEUsuario);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return oLstUsuario;
    }
    public boolean verificarUsuario(String usuario, String password)
    {

        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "SELECT usuario,contrasenia FROM usuario us where us.usuario='"+usuario+"'";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            if(rs.next())
            {
                CEUsuario oCEUsuario=new CEUsuario();
                
                oCEUsuario.setUsuario(rs.getString(1));
                oCEUsuario.setPassword(rs.getString(2));

                if(oCEUsuario.getPassword().equals(password))
                {
                    return true;
                }
                return false;

            }
            return false;

        }
        catch (SQLException ex)
        {
            return false;
        }

    }
  public boolean abmUsuario(CEUsuario oCEMedida,int valor)
  {
        try {
            Connection conn = ConexionBD.obtenerConexion();
            String sql ;
            if(valor==1)
            {
            sql = "insert into usuario(Usuario,Contrasenia,IdTipoUsuario) values ('" + oCEMedida.getUsuario() + "','" + oCEMedida.getPassword() + "'," + oCEMedida.getIdTipoUsuario() + ")";
            }
            else
            {
                if(valor==2)
                {
                sql = "update usuario set usuario='"+oCEMedida.getUsuario()+
                        "',contrasenia='"+oCEMedida.getPassword()+
                       "',IdTipoUsuario="+oCEMedida.getIdTipoUsuario()+
                       " where IdUsuario="+oCEMedida.getIdUsuario();
                }
                else
                {
                    sql = "delete from usuario"+
                       " where IdUsuario="+oCEMedida.getIdUsuario();
                }
            }
            PreparedStatement sp = conn.prepareStatement(sql);
            int result = sp.executeUpdate();
            if(result==1) return true;
            else return false;

        } catch (SQLException ex) {
            Logger.getLogger(CDUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


  }
}
