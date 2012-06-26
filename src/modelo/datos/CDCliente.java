
package modelo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.acceso.ConexionBD;
import modelo.entidad.CECliente;

public class CDCliente {
 public  ArrayList<CECliente> listarCliente()
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,NumeroInscripcion,ApellidosyNombres,AntiguoCodigoCatastral,NuevoCodigoCatastral as NombreClientes from cliente; ";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroDocumento(rs.getString(2));
                oCECliente.setApellidoPaternoPropietario(rs.getString(3));
                oCECliente.setAntiguoCodigoCatastral(rs.getString(4));
                oCECliente.setNuevoCodigoCatastral(rs.getString(5));
                oLstCCliente.add(oCECliente);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCCliente;

    }
public CECliente DetalleCliente(CECliente oCECliente)
    {
                Connection conexion = ConexionBD.obtenerConexion();
                try
                {
                  List<CECliente> Lst = new ArrayList<CECliente>();
                  String sql = null;                  
                    sql = "SELECT * FROM Cliente WHERE IdCliente = "+oCECliente.getIdCliente()+";";
                    
                    Statement sentencia = conexion.createStatement();
                    ResultSet resultado = sentencia.executeQuery(sql);                    

                    if (resultado!=null)
                {
                    while (resultado.next())
                    {                        
                        oCECliente.setIdCliente(resultado.getInt(1));               
                        oCECliente.setAntiguoCodigoCatastral(resultado.getString(2));
                        oCECliente.setNuevoCodigoCatastral(resultado.getString(3));
                        oCECliente.setNumeroInscripcion(resultado.getString(4));
                        oCECliente.setRutaLectura(resultado.getString(5));
                        oCECliente.setRutaReparto(resultado.getString(6));
                        oCECliente.setSecuencia(resultado.getString(7));
                        oCECliente.setCategoria(resultado.getString(8));
                        oCECliente.setIdTipoDocumento(resultado.getInt(9));
                        oCECliente.setNumeroDocumento(resultado.getString(10));
                        oCECliente.setTelefono(resultado.getString(11));
                        oCECliente.setApellidoPaternoPropietario(resultado.getString(12));
                        oCECliente.setCorreoElectronico(resultado.getString(13));
                        oCECliente.setDireccion(resultado.getString(14));
                        oCECliente.setIdMedioAbastecimiento(resultado.getInt(15));
                        oCECliente.setIdCondicionConexionAgua(resultado.getInt(16));

                        Lst.add(oCECliente);
                    }
                    conexion.close();
                    return oCECliente;
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
 public  ArrayList<CECliente> filtrarClientePorApellidosNombres(String Paramentro)
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,NumeroInscripcion,ApellidosyNombres,AntiguoCodigoCatastral,NuevoCodigoCatastral as NombreClientes  from cliente  where ApellidosyNombres like CONCAT('"+Paramentro+"', '%');";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroInscripcion(rs.getString(2));
                oCECliente.setApellidoPaternoPropietario(rs.getString(3));
                oCECliente.setAntiguoCodigoCatastral(rs.getString(4));
                oCECliente.setNuevoCodigoCatastral(rs.getString(5));
                oLstCCliente.add(oCECliente);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCCliente;

    }
  public  ArrayList<CECliente> filtrarClientePorNumeroInscripcion(String Paramentro)
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,NumeroInscripcion,ApellidosyNombres,AntiguoCodigoCatastral,NuevoCodigoCatastral as NombreClientes  from cliente  where NumeroInscripcion like CONCAT('"+Paramentro+"', '%');";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroInscripcion(rs.getString(2));
                oCECliente.setApellidoPaternoPropietario(rs.getString(3));
                oCECliente.setAntiguoCodigoCatastral(rs.getString(4));
                oCECliente.setNuevoCodigoCatastral(rs.getString(5));
                oLstCCliente.add(oCECliente);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCCliente;

    }
    public  ArrayList<CECliente> filtrarClientePorNuevoCodigoCatastral(String Paramentro)
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,NumeroInscripcion,ApellidosyNombres,AntiguoCodigoCatastral,NuevoCodigoCatastral as NombreClientes  from cliente  where NuevoCodigoCatastral like CONCAT('"+Paramentro+"', '%');";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroInscripcion(rs.getString(2));
                oCECliente.setApellidoPaternoPropietario(rs.getString(3));
                oCECliente.setAntiguoCodigoCatastral(rs.getString(4));
                oCECliente.setNuevoCodigoCatastral(rs.getString(5));
                oLstCCliente.add(oCECliente);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCCliente;

    }
 public  ArrayList<CECliente> filtrarClientePorAntiguoCodigoCatastral(String Paramentro)
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,NumeroInscripcion,ApellidosyNombres,AntiguoCodigoCatastral,NuevoCodigoCatastral as NombreClientes  from cliente  where AntiguoCodigoCatastral like CONCAT('"+Paramentro+"', '%');";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroInscripcion(rs.getString(2));
                oCECliente.setApellidoPaternoPropietario(rs.getString(3));
                oCECliente.setAntiguoCodigoCatastral(rs.getString(4));
                oCECliente.setNuevoCodigoCatastral(rs.getString(5));
                oLstCCliente.add(oCECliente);
            }

        }
        catch (SQLException ex)
        {

        }
        return oLstCCliente;

    }
 public static boolean  Eliminar(int tipo,CECliente oCECliente)
    {
        Connection conexion = ConexionBD.obtenerConexion();
        try
        {
            String sql = null;
            switch(tipo)
            {  
                                   
              case 3:
                  sql = "Delete from Cliente where IdCliente= "+oCECliente.getIdCliente()+";";
              break;                  
                   }
            Statement sentencia = conexion.createStatement();                        
            sentencia.executeUpdate(sql);            
            return true;            
        }
        catch(SQLException e)        
        {
            e.printStackTrace();
            return false;
        }        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
 public boolean registrar(CECliente oCECliente)
    {
        try
        {
            Connection con = ConexionBD.obtenerConexion();
            String sql = "INSERT INTO cliente( "
                    + "AntiguoCodigoCatastral,"
                    + "NuevoCodigoCatastral, "
                    + "NumeroInscripcion,"
                    + "RutaLectura,"
                    + "RutaReparto,"
                    + "Secuencia,"
                    + "Categoria,"
                    + "IdTipoDocumento,"
                    + "NumeroDocumento,"
                    + "Telefono,"
                    + "ApellidosyNombres,"
                    + "CorreoElectronico,"
                    + "IdMedioAbastecimiento,"
                    + "IdCondicionConexionAgua,"
                    + "Direccion) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
              ps.setString(1,oCECliente.getAntiguoCodigoCatastral());
            ps.setString(2,oCECliente.getNuevoCodigoCatastral());
            ps.setString(3,oCECliente.getNumeroInscripcion());
            ps.setString(4,oCECliente.getRutaLectura());
            ps.setString(5,oCECliente.getRutaReparto());
            ps.setString(6,oCECliente.getSecuencia());
            ps.setString(7,oCECliente.getCategoria());
            ps.setInt(8,oCECliente.getIdTipoDocumento());
            ps.setString(9,oCECliente.getNumeroDocumento());
            ps.setString(10,oCECliente.getTelefono());
            ps.setString(11,oCECliente.getApellidoPaternoPropietario());
            ps.setString(12,oCECliente.getCorreoElectronico());
            ps.setInt(13,oCECliente.getIdMedioAbastecimiento());
            ps.setInt(14,oCECliente.getIdCondicionConexionAgua());
            ps.setString(15,oCECliente.getDireccion());
            ps.setInt(16,oCECliente.getIdCliente());
            ps.executeUpdate();

            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        

    }
 public boolean Actualizar(CECliente oCECliente)
    {
        try
        {
            Connection con = ConexionBD.obtenerConexion();
            String sql = "UPDATE cliente set "
                    + "AntiguoCodigoCatastral= ?,"
                    + "NuevoCodigoCatastral= ?, "
                    + "NumeroInscripcion= ?,"
                    + "RutaLectura= ?, "
                    + "RutaReparto= ?,"
                    + "Secuencia= ?, "
                    + "Categoria = ?, "
                    + "IdTipoDocumento= ?,"
                    + "NumeroDocumento = ?, "
                    + "Telefono= ?, "
                    + "ApellidosyNombres= ?,"
                    + "CorreoElectronico = ?,"
                    + "IdMedioAbastecimiento= ?, "
                    + "IdCondicionConexionAgua=?,"
                    + "Direccion=? "
                    + "where IdCliente = ? ;";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,oCECliente.getAntiguoCodigoCatastral());
            ps.setString(2,oCECliente.getNuevoCodigoCatastral());
            ps.setString(3,oCECliente.getNumeroInscripcion());
            ps.setString(4,oCECliente.getRutaLectura());
            ps.setString(5,oCECliente.getRutaReparto());
            ps.setString(6,oCECliente.getSecuencia());
            ps.setString(7,oCECliente.getCategoria());
            ps.setInt(8,oCECliente.getIdTipoDocumento());
            ps.setString(9,oCECliente.getNumeroDocumento());
            ps.setString(10,oCECliente.getTelefono());
            ps.setString(11,oCECliente.getApellidoPaternoPropietario());
            ps.setString(12,oCECliente.getCorreoElectronico());
            ps.setInt(13,oCECliente.getIdMedioAbastecimiento());
            ps.setInt(14,oCECliente.getIdCondicionConexionAgua());
            ps.setString(15,oCECliente.getDireccion());
            ps.setInt(16,oCECliente.getIdCliente());
            ps.executeUpdate();

            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        

    }
}
