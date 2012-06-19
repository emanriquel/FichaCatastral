/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.acceso.ConexionBD;
import modelo.entidad.CECliente;

/**
 *
 * @author Edwar
 */
public class CDCliente {
 public  ArrayList<CECliente> listarCliente()
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,numerodocumento,CONCAT( ApellidoPaternoPropietario,' ',ApellidoMaternoPropietario,' ,',NombrePropietario) as NombreClientes from cliente; ";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroDocumento(rs.getString(2));
                oCECliente.setNombrePropietario(rs.getString(3));
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
                        oCECliente.setIdSituacionConexion(resultado.getInt(2));
                        oCECliente.setAntiguoCodigoCatastral(resultado.getString(3));
                        oCECliente.setNuevoCodigoCatastral(resultado.getString(4));
                        oCECliente.setNumeroInscripcion(resultado.getString(5));
                        oCECliente.setRutaLectura(resultado.getString(6));
                        oCECliente.setRutaReparto(resultado.getString(7));
                        oCECliente.setSecuencia(resultado.getString(8));
                        oCECliente.setCategoria(resultado.getString(9));
                        oCECliente.setNumMunicipal(resultado.getString(10));
                        oCECliente.setIdTipoDocumento(resultado.getInt(11));
                        oCECliente.setNumeroDocumento(resultado.getString(12));
                        oCECliente.setTelefono(resultado.getString(13));
                        oCECliente.setApellidoPaternoPropietario(resultado.getString(14));
                        oCECliente.setApellidoMaternoPropietario(resultado.getString(15));
                        oCECliente.setNombrePropietario(resultado.getString(16));
                        oCECliente.setApellidopPaternoConyugue(resultado.getString(17));
                        oCECliente.setApellidoMaternoConyugue(resultado.getString(18));
                        oCECliente.setNombreConyugue(resultado.getString(19));
                        oCECliente.setCorreoElectronico(resultado.getString(20));
                        oCECliente.setIdTipoPropiedad(resultado.getInt(21));
                        oCECliente.setCantidadHabitantesPredio(resultado.getInt(22));
                        oCECliente.setNumeroPisos(resultado.getInt(23));
                        oCECliente.setIdTipoPredio(resultado.getInt(24));
                        oCECliente.setIdVia(resultado.getInt(25));
                        oCECliente.setNumeroMunicipal(resultado.getString(26));
                        oCECliente.setIdHabilitacion(resultado.getInt(27));
                        oCECliente.setNumeroManzana(resultado.getString(28));
                        oCECliente.setNumeroLote(resultado.getString(29));
                        oCECliente.setBlock(resultado.getString(30));
                        oCECliente.setPiso(resultado.getInt(31));
                        oCECliente.setNumero(resultado.getInt(32));
                        oCECliente.setIdUsoPredio(resultado.getInt(33));
                        oCECliente.setComplemento(resultado.getString(34));
                        oCECliente.setSiNoPredioHabilitado(resultado.getInt(35));
                        oCECliente.setIdTipoServicio(resultado.getInt(36));
                        oCECliente.setIdMedioAbastecimiento(resultado.getInt(37));
                        oCECliente.setIdSituacionPredio(resultado.getInt(38));
                        oCECliente.setIdTipoAlmacenamiento(resultado.getInt(39));

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
 public  ArrayList<CECliente> filtrarCliente(String Paramentro)
    {
        ArrayList<CECliente> oLstCCliente=new ArrayList<CECliente>();
        try
        {
            Connection conn = ConexionBD.obtenerConexion();
            String sql = "select IdCliente,numerodocumento,CONCAT( ApellidoPaternoPropietario,' ',ApellidoMaternoPropietario,' ,',NombrePropietario) as NombreClientes  from cliente  where CONCAT( ApellidoPaternoPropietario,' ',ApellidoMaternoPropietario,' ',NombrePropietario) like CONCAT('"+Paramentro+"', '%');";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();

            while(rs.next())
            {
                CECliente oCECliente=new CECliente();
                oCECliente.setIdCliente(rs.getInt(1));
                oCECliente.setNumeroDocumento(rs.getString(2));
                oCECliente.setNombrePropietario(rs.getString(3));
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
            String sql = "INSERT INTO cliente (IdSituacionConexion, AntiguoCodigoCatastral, NuevoCodigoCatastral, NumeroInscripcion, RutaLectura, RutaReparto,  Secuencia,  Categoria,  NumMunicipal,  IdTipoDocumento,  NumeroDocumento,  Telefono,  ApellidoPaternoPropietario,  ApellidoMaternoPropietario,  NombrePropietario,  ApellidopPaternoConyugue,  ApellidoMaternoConyugue,  NombreConyugue,  CorreoElectronico,  IdTipoPropiedad,  CantidadHabitantesPredio,  NumeroPisos,  IdTipoPredio,  IdVia,  NumeroMunicipal,  IdHabilitacion,  NumeroManzana,  NumeroLote,  Block,  Piso,  Numero,  IdUsoPredio,  Complemento,  SiNoPredioHabilitado,  IdTipoServicio,  IdMedioAbastecimiento,  IdSituacionPredio,  IdTipoAlmacenamiento ) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1,oCECliente.getIdSituacionConexion());
            ps.setString(2,oCECliente.getAntiguoCodigoCatastral());
            ps.setString(3,oCECliente.getNuevoCodigoCatastral());
            ps.setString(4,oCECliente.getNumeroInscripcion());
            ps.setString(5,oCECliente.getRutaLectura());
            ps.setString(6,oCECliente.getRutaReparto());
            ps.setString(7,oCECliente.getSecuencia());
            ps.setString(8,oCECliente.getCategoria());
            ps.setString(9,oCECliente.getNumMunicipal());
            ps.setInt(10,oCECliente.getIdTipoDocumento());
            ps.setString(11,oCECliente.getNumeroDocumento());
            ps.setString(12,oCECliente.getTelefono());
            ps.setString(13,oCECliente.getApellidoPaternoPropietario());
            ps.setString(14,oCECliente.getApellidoMaternoPropietario());
            ps.setString(15,oCECliente.getNombrePropietario());
            ps.setString(16,oCECliente.getApellidopPaternoConyugue());
            ps.setString(17,oCECliente.getApellidoMaternoConyugue());
            ps.setString(18,oCECliente.getNombreConyugue());
            ps.setString(19,oCECliente.getCorreoElectronico());
            ps.setInt(20,oCECliente.getIdTipoPropiedad());
            ps.setInt(21,oCECliente.getCantidadHabitantesPredio());
            ps.setInt(22,oCECliente.getNumeroPisos());
            ps.setInt(23,oCECliente.getIdTipoPredio());
            ps.setInt(24,oCECliente.getIdVia());
            ps.setString(25,oCECliente.getNumeroMunicipal());
            ps.setInt(26,oCECliente.getIdHabilitacion());
            ps.setString(27,oCECliente.getNumeroManzana());
            ps.setString(28,oCECliente.getNumeroLote());
            ps.setString(29,oCECliente.getBlock());
            ps.setInt(30,oCECliente.getPiso());
            ps.setInt(31,oCECliente.getNumero());
            ps.setInt(32,oCECliente.getIdUsoPredio());
            ps.setString(33,oCECliente.getComplemento());
            ps.setInt(34,oCECliente.getSiNoPredioHabilitado());
            ps.setInt(35,oCECliente.getIdTipoServicio());
            ps.setInt(36,oCECliente.getIdMedioAbastecimiento());
            ps.setInt(37,oCECliente.getIdSituacionPredio());
            ps.setInt(38,oCECliente.getIdTipoAlmacenamiento());            
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
            String sql = "UPDATE cliente set IdSituacionConexion = ?, AntiguoCodigoCatastral= ?, NuevoCodigoCatastral= ?, NumeroInscripcion= ?, RutaLectura= ?, RutaReparto= ?,  Secuencia= ?,  Categoria = ?,  NumMunicipal = ?,  IdTipoDocumento= ?,  NumeroDocumento = ?,  Telefono= ?,  ApellidoPaternoPropietario= ?,  ApellidoMaternoPropietario= ?,  NombrePropietario= ?,  ApellidopPaternoConyugue= ?,  ApellidoMaternoConyugue = ?,  NombreConyugue = ?,  CorreoElectronico = ?,  IdTipoPropiedad = ?,  CantidadHabitantesPredio = ?,  NumeroPisos = ?,  IdTipoPredio= ?,  IdVia = ?,  NumeroMunicipal= ?,  IdHabilitacion = ?,  NumeroManzana= ?,  NumeroLote= ?,  Block= ?,  Piso= ?,  Numero= ?,  IdUsoPredio= ?,  Complemento= ?,  SiNoPredioHabilitado= ?,  IdTipoServicio = ?,  IdMedioAbastecimiento= ?,  IdSituacionPredio = ?,  IdTipoAlmacenamiento= ?  "
                    + "where IdCliente = ? ;";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1,oCECliente.getIdSituacionConexion());
            ps.setString(2,oCECliente.getAntiguoCodigoCatastral());
            ps.setString(3,oCECliente.getNuevoCodigoCatastral());
            ps.setString(4,oCECliente.getNumeroInscripcion());
            ps.setString(5,oCECliente.getRutaLectura());
            ps.setString(6,oCECliente.getRutaReparto());
            ps.setString(7,oCECliente.getSecuencia());
            ps.setString(8,oCECliente.getCategoria());
            ps.setString(9,oCECliente.getNumMunicipal());
            ps.setInt(10,oCECliente.getIdTipoDocumento());
            ps.setString(11,oCECliente.getNumeroDocumento());
            ps.setString(12,oCECliente.getTelefono());
            ps.setString(13,oCECliente.getApellidoPaternoPropietario());
            ps.setString(14,oCECliente.getApellidoMaternoPropietario());
            ps.setString(15,oCECliente.getNombrePropietario());
            ps.setString(16,oCECliente.getApellidopPaternoConyugue());
            ps.setString(17,oCECliente.getApellidoMaternoConyugue());
            ps.setString(18,oCECliente.getNombreConyugue());
            ps.setString(19,oCECliente.getCorreoElectronico());
            ps.setInt(20,oCECliente.getIdTipoPropiedad());
            ps.setInt(21,oCECliente.getCantidadHabitantesPredio());
            ps.setInt(22,oCECliente.getNumeroPisos());
            ps.setInt(23,oCECliente.getIdTipoPredio());
            ps.setInt(24,oCECliente.getIdVia());
            ps.setString(25,oCECliente.getNumeroMunicipal());
            ps.setInt(26,oCECliente.getIdHabilitacion());
            ps.setString(27,oCECliente.getNumeroManzana());
            ps.setString(28,oCECliente.getNumeroLote());
            ps.setString(29,oCECliente.getBlock());
            ps.setInt(30,oCECliente.getPiso());
            ps.setInt(31,oCECliente.getNumero());
            ps.setInt(32,oCECliente.getIdUsoPredio());
            ps.setString(33,oCECliente.getComplemento());
            ps.setInt(34,oCECliente.getSiNoPredioHabilitado());
            ps.setInt(35,oCECliente.getIdTipoServicio());
            ps.setInt(36,oCECliente.getIdMedioAbastecimiento());
            ps.setInt(37,oCECliente.getIdSituacionPredio());
            ps.setInt(38,oCECliente.getIdTipoAlmacenamiento());            
            ps.setInt(39,oCECliente.getIdCliente());            
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
