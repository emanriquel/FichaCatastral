package modelo.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.acceso.ConexionBD;
import modelo.entidad.CEMedida;

public class CDMedida
{
    public boolean registrarMedida(CEMedida oCEMedida)
    {
        try
        {
            Connection con = ConexionBD.obtenerConexion();
            String sql = "INSERT INTO registro_medida (NumeroFicha,"//1
                    + "FechaEncuesta, "//2
                    + "IdCondicionConexionAgua," //3
                    + "IdCondicionConexionDesague, " //4
                    + "IdDiametroConexionDesague, " //5
                    + "IdDiametroConexionAgua," //6
                    + " IdDiametroMedidor,"//7
                    + " IdEstadoCajaDesague," //8
                    + " IdEstadoCajaAgua," //9
                    + " IdEstadoTapaDesague," //10
                    + " IdEstadoTapaAgua, " //11
                    + "IdLlavePaso," //12
                    + " IdMaterialCajaAgua," //13
                    + " IdMaterialCajaDesague," //14
                    + " IdMaterialTapaAgua, " //15
                    + "IdMaterialTapaDesague," //16
                    + " IdMedioAbastecimiento," //17
                    + " IdPavimentacion,"//18
                    + " IdPosicionMedidor, "//19
                    + "IdPozoArtesanal, "//20
                    + "IdSeguridadMedidor, "//21
                    + "IdSituacionAgua, "//22
                    + "IdSituacionPredio, "//23
                    + "IdTipoAlmacenamiento,"//24
                    + " IdTipoPredio,"//25
                    + "IdTipoPropiedad,"//26
                    + " IdTipoServicio,"//27
                    + " IdUbiCajaConexAgua," //28
                    + " IdUbiCajaConexDesague," //29
                    + " IdUsoPredio, " //30
                    + "IdVereda,"//31
                    + " Cod_Encuestador," //32
                    + " Fecha_Encuestador, " //33
                    + "Cod_Supervisor,"//34
                    + " Fecha_Supervisor,"//35
                    + " Cod_Digitador,"//36
                    + " Fecha_Digitador,"//37
                    + " Cod_Inscripcion,"//38
                    + " Manzana, "//39
                    + "Lote, "//40
                    + "Conexion,"//41
                    + "RutaLectura,"//42
                    + "RutaReparto,"//43
                    + "Secuencia,"//44
                    + "Categoria,"//45
                    + "CodigoVia,"//46
                    + "TipoVia,"//47
                    + "NombreVia,"//48
                    + "NumMunicipal,"//49
                    + "CodigoHabilitacion,"//50
                    + "TipoHabilitacion,"//51
                    + "NombreHabilitacion,"//52
                    + "NumManzana,"//53
                    + "NumLote,"//54
                    + "Block, "//55
                    + "Piso, "//56
                    + "Numero,"//57
                    + "Complemento,"//58
                    + "ApellidoPaternoPropietario,"//59
                    + "ApellidoMaternoPropietario,"//60
                    + "NombrePropietario,"//61
                    + "ApellidoPaternoConyugue,"//62
                    + "ApellidoMaternoConyugue,"//63
                    + "NombreConyugue,"//64
                    + "CorreoElectronico, "//65
                    + "CantHabitantesPredio,"//66
                    + "NumPiso,"//67
                    + "SiNoPredioHabilitado,"//68
                    + "SiNoMedidor,"//69
                    + "NumeroMedidor,"//70
                    + "SiNoIlegibleNumMedidor,"//71
                    + "Lectura, "//72
                    + "SiNoIlegibleLectura, "//73
                    + "MarcaMedidor, "//74
                    + "SiNoTapaConexionAgua, "//75
                    + "MaterialConexionAgua,"//76
                    + "SiNoFugaAgua, "//77
                    + "TipoFugaAgua,"//78
                    + "SiNoFugaDesague,"//79
                    + "FrecuenciaAbastecimientoHorasPorDia, "//80
                    + "FrecuenciaAbastecimientoDiasPorSemana, "//81
                    + "Observaciones, "//82
                    + "ApellidoPaternoEntrevistado, "//83
                    + "ApellidoMaternoEntrevistado, "//84
                    + "NombreCompletoEntrevistado, "//85
                    + "DocumentoEntrevistado, "//86
                    + "IdTipoPropiedadInquilino, "//87
                    + "CodigoFotoCaja, "//88
                    + "CodigoFotoPredio, "//89
                    + "CodDepartamento, "//90
                    + "CodProvincia, "//91
                    + "CodDistrito,"//92
                    + "Seccion,"//93
                    + "IdTipoDocumento,"//94
                    + "NumeroDocumento,"//95
                    + "Telefono) "//96
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,oCEMedida.getNumeroFicha());
            ps.setString(2,oCEMedida.getFechaEncuesta());
            ps.setInt(3,oCEMedida.getIdCondicionConexionAgua());
            ps.setInt(4,oCEMedida.getIdCondicionConexionDesague());
            ps.setInt(5,oCEMedida.getIdDiametroConexionDesague());
            ps.setInt(6,oCEMedida.getIdDiametroConexionAgua());
            ps.setInt(7,oCEMedida.getIdDiametroMedidor());
            ps.setInt(8,oCEMedida.getIdEstadoCajaDesague());
            ps.setInt(9,oCEMedida.getIdEstadoCajaAgua());
            ps.setInt(10,oCEMedida.getIdEstadoTapaDesague());
            ps.setInt(11,oCEMedida.getIdEstadoTapaAgua());
            ps.setInt(12,oCEMedida.getIdLlavePaso());
            ps.setInt(13,oCEMedida.getIdMaterialCajaAgua());
            ps.setInt(14,oCEMedida.getIdMaterialCajaDesague());
            ps.setInt(15,oCEMedida.getIdMaterialTapaAgua());
            ps.setInt(16,oCEMedida.getIdMaterialTapaDesague());
            ps.setInt(17,oCEMedida.getIdMedioAbastecimiento());
            ps.setInt(18,oCEMedida.getIdPavimentacion());
            ps.setInt(19,oCEMedida.getIdPosicionMedidor());
            ps.setInt(20,oCEMedida.getIdPozoArtesanal());
            ps.setInt(21,oCEMedida.getIdSeguridadMedidor());
            ps.setInt(22,oCEMedida.getIdSituacionAgua());
            ps.setInt(23,oCEMedida.getIdSituacionPredio());
            ps.setInt(24,oCEMedida.getIdTipoAlmacenamiento());
            ps.setInt(25,oCEMedida.getIdTipoPredio());
            ps.setInt(26,oCEMedida.getIdTipoPropiedad());
            ps.setInt(27,oCEMedida.getIdTipoServicio());
            ps.setInt(28,oCEMedida.getIdUbiCajaConexAgua());
            ps.setInt(29,oCEMedida.getIdUbiCajaConexDesague());
            ps.setInt(30,oCEMedida.getIdUsoPredio());
            ps.setInt(31,oCEMedida.getIdVereda());
            ps.setString(32,oCEMedida.getCod_Encuestador());
            ps.setString(33,oCEMedida.getFecha_Encuestador());
            ps.setString(34,oCEMedida.getCod_Supervisor());
            ps.setString(35,oCEMedida.getFecha_Supervisor());
            ps.setString(36,oCEMedida.getCod_Digitado());
            ps.setString(37,oCEMedida.getFecha_Digitador());
            ps.setString(38,oCEMedida.getCod_Inscripcion());
            ps.setString(39,oCEMedida.getManzana());
            ps.setString(40,oCEMedida.getLote());
            ps.setString(41,oCEMedida.getConexion());
            ps.setString(42,oCEMedida.getRutaLectura());
            ps.setString(43,oCEMedida.getRutaReparto());
            ps.setString(44,oCEMedida.getSecuencia());
            ps.setString(45,oCEMedida.getCategoria());
            ps.setString(46,oCEMedida.getCodigoVia());
            ps.setString(47,oCEMedida.getTipoVia());
            ps.setString(48,oCEMedida.getNombreVia());
            ps.setString(49,oCEMedida.getNumMunicipal());
            ps.setString(50,oCEMedida.getCodigoHabilitacion());
            ps.setString(51,oCEMedida.getTipoHabilitacion());
            ps.setString(52,oCEMedida.getNombreHabilitacion());
            ps.setString(53,oCEMedida.getNumManzana());
            ps.setString(54,oCEMedida.getNumLote());
            ps.setString(55,oCEMedida.getBlock());
            ps.setString(56,oCEMedida.getPiso());
            ps.setString(57,oCEMedida.getNumero());
            ps.setString(58,oCEMedida.getComplemento());
            ps.setString(59,oCEMedida.getApellidoPaternoPropietario());
            ps.setString(60,oCEMedida.getApellidoMaternoPropietario());
            ps.setString(61,oCEMedida.getNombrePropietario());
            ps.setString(62,oCEMedida.getApellidoPaternoConyugue());
            ps.setString(63,oCEMedida.getApellidoMaternoConyugue());
            ps.setString(64,oCEMedida.getNombreConyugue());
            ps.setString(65,oCEMedida.getCorreoElectronico());
            ps.setInt(66,oCEMedida.getCantHabitantesPredio());
            ps.setInt(67,oCEMedida.getNumPiso());
            ps.setBoolean(68,oCEMedida.isSiNoPredioHabilitado());
            ps.setBoolean(69,oCEMedida.isSiNoMedidor());
            ps.setString(70,oCEMedida.getNumeroMedidor());
            ps.setBoolean(71,oCEMedida.isSiNoIlegibleNumMedidor());
            ps.setDouble(72,oCEMedida.getLectura());
            ps.setBoolean(73,oCEMedida.isSiNoIlegibleLectura());
            ps.setString(74,oCEMedida.getMarcaMedidor());
            ps.setBoolean(75,oCEMedida.isSiNoTapaConexionAgua());
            ps.setString(76,oCEMedida.getMaterialConexionAgua());
            ps.setBoolean(77,oCEMedida.isSiNoFugaAgua());
            ps.setInt(78,oCEMedida.getTipoFugaAgua());
            ps.setBoolean(79,oCEMedida.isSiNoFugaDesague());
            ps.setDouble(80,oCEMedida.getFrecuenciaAbastecimientoHorasPorDia());
            ps.setDouble(81,oCEMedida.getFrecuenciaAbastecimientoDiasPorSemana());
            ps.setString(82,oCEMedida.getObservaciones());
            ps.setString(83,oCEMedida.getApellidoPaternoEntrevistado());
            ps.setString(84,oCEMedida.getApellidoMaternoEntrevistado());
            ps.setString(85,oCEMedida.getNombreCompletoEntrevistado());
            ps.setString(86,oCEMedida.getDocumentoEntrevistado());
            ps.setInt(87,oCEMedida.getIdTipoPropiedadEntrevistado());
            ps.setString(88,oCEMedida.getCodigoFotoCaja());
            ps.setString(89,oCEMedida.getCodigoFotoPredio());
            ps.setString(90,oCEMedida.getCodDepartamento());
            ps.setString(91,oCEMedida.getCodProvincia());
            ps.setString(92,oCEMedida.getCodDistrito());
            ps.setString(93,oCEMedida.getSeccion());
            ps.setInt(94, oCEMedida.getIdTipoDocumento());
            ps.setString(95, oCEMedida.getNumeroDocumento());
            ps.setString(96, oCEMedida.getTelefono());
            ps.execute();



            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CDMedida.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        

    }
}
