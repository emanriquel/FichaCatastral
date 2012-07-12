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
import modelo.entidad.CEUsos;

public class CDMedida
{
    public boolean registrarMedida(CEMedida oCEMedida)
    {
        Connection con = ConexionBD.obtenerConexion();
        try
        {
            
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            String sql = "INSERT INTO registro_medida (NumeroFicha,"//1
                    + "PorcentajeSocial,"//2
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
                    + "IdMaterialConexionAgua,"//76
                    + "SiNoFugaAgua, "//77
                    + "IdTipoFugaAgua,"//78
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
                    + "NumeroDocumentoPropietario,"//95
                    + "Telefono,"//96
                    + "UbicacionConexionAgua,"//97
                    + "UbicacionConexionDesague,"//98
                    + "IdEstadoMedidorAgua,"
                    + "PorcentajeComercial,"
                    + "PorcentajeDomestico,"
                    + "PorcentajeEstatal,"
                    + "IdSituacionConexion,"
                    + "IdMaterialConexionDesague,"
                    + "IdTipoCaracteristicaDesague,"
                    + "IdTipoFotoAgua,SiNoTapaConexionDesague)"//99
                    + "VALUES (?, "
                    + "?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + "?,"
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + "?, "
                    + "?,"
                    + " ?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + "?, "
                    + "?, "
                    + "?,"
                    + "?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,?,?,?,?,?) ";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,oCEMedida.getNumeroFicha());
            ps.setString(2,oCEMedida.getPorcentajeSocial());
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
            ps.setString(66,oCEMedida.getCantHabitantesPredio());
            ps.setString(67,oCEMedida.getNumPiso());
            ps.setBoolean(68,oCEMedida.isSiNoPredioHabilitado());
            ps.setBoolean(69,oCEMedida.isSiNoMedidor());
            ps.setString(70,oCEMedida.getNumeroMedidor());
            ps.setBoolean(71,oCEMedida.isSiNoIlegibleNumMedidor());
            ps.setString(72,oCEMedida.getLectura());
            ps.setBoolean(73,oCEMedida.isSiNoIlegibleLectura());
            ps.setString(74,oCEMedida.getMarcaMedidor());
            ps.setBoolean(75,oCEMedida.isSiNoTapaConexionAgua());
            ps.setInt(76,oCEMedida.getIdMaterialCajaAgua());
            ps.setBoolean(77,oCEMedida.isSiNoFugaAgua());
            ps.setInt(78,oCEMedida.getTipoFugaAgua());
            ps.setBoolean(79,oCEMedida.isSiNoFugaDesague());
            ps.setString(80,oCEMedida.getFrecuenciaAbastecimientoHorasPorDia());
            ps.setString(81,oCEMedida.getFrecuenciaAbastecimientoDiasPorSemana());
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
            ps.setString(97, oCEMedida.getUbicacionConexionAgua());
            ps.setString(98, oCEMedida.getUbicacionConexionDesague());
            ps.setInt(99, oCEMedida.getIdEstadoMedidor());
            ps.setString(100, oCEMedida.getPorcentajeComercial());
            ps.setString(101, oCEMedida.getPorcentajeDomestico());
            ps.setString(102, oCEMedida.getPorcentajeEstatal());
            ps.setInt(103, oCEMedida.getIdSituacionConexion());
            ps.setInt(104, oCEMedida.getIdMaterialConexionDesague());
            ps.setInt(105, oCEMedida.getIdTipoCaracteristicasCajaDesague());
            ps.setInt(106, oCEMedida.getIdTipoFotoAgua());
            ps.setBoolean(107, oCEMedida.isSiNoTapaConexionDesague());
            int valor=ps.executeUpdate();
            ResultSet oRS=ps.getGeneratedKeys();
            if(oRS.next())
            {
                oCEMedida.setIdRegistroMedida(oRS.getInt(1));
            }

            if(valor>0)
            {
                int a=1;
                for(CEUsos oCEUsos:oCEMedida.getoLstUsos())
                {

                    if(oCEUsos.getCodigo()==1)
                    {
                        String sql2="INSERT INTO usos (Numero, Respo, TipoUso, CodUso, PtosAgua, NumPersona, Complemento, Categoria,IdRegistroMedida) VALUES ( ?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps1 = con.prepareCall(sql2);
                        ps1.setString(1, oCEUsos.getNumero());
                        ps1.setString(2, oCEUsos.getRespo());
                        ps1.setString(3, oCEUsos.getTipoUso());
                        ps1.setString(4, oCEUsos.getCodUso());
                        ps1.setString(5, oCEUsos.getPtosAgua());
                        ps1.setString(6, oCEUsos.getNumPersona());
                        ps1.setString(7, oCEUsos.getComplemento());
                        ps1.setString(8, oCEUsos.getCategoria());
                        ps1.setInt(9, oCEUsos.getIdRegistroMedida());
                        a=ps1.executeUpdate();
                        if(a==2)
                        {
                            break;
                        }
                    }
                }
                if(a==1)
                {
                   
                    String sql4 = "update parametros m set m.Valor=(select max(cast( NumeroFicha as signed)) from registro_medida ) where m.Nombre='NumFicha'";
                    PreparedStatement ps1 = con.prepareCall(sql4);
                    ps1.execute();
                     con.commit();
                    return true;
                }
                else
                {
                   con.rollback();
                   return false; 
                }
            }
            else
            {
                con.rollback();
                return false;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CDMedida.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        

    }
     public boolean actualizarMedida(CEMedida oCEMedida)
    {
         Connection con = ConexionBD.obtenerConexion();
        try
        {
            
            con.setAutoCommit(false);
            String sql = "update  registro_medida  set NumeroFicha =?,"//1
                    + "PorcentajeSocial  =?,"//2
                    + "IdCondicionConexionAgua  =?," //3
                    + "IdCondicionConexionDesague  =?, " //4
                    + "IdDiametroConexionDesague  =?, " //5
                    + "IdDiametroConexionAgua =?," //6
                    + " IdDiametroMedidor =?,"//7
                    + " IdEstadoCajaDesague =?," //8
                    + " IdEstadoCajaAgua =?," //9
                    + " IdEstadoTapaDesague =?," //10
                    + " IdEstadoTapaAgua =?, " //11
                    + "IdLlavePaso =?," //12
                    + " IdMaterialCajaAgua =?," //13
                    + " IdMaterialCajaDesague =?," //14
                    + " IdMaterialTapaAgua =?, " //15
                    + "IdMaterialTapaDesague =?," //16
                    + " IdMedioAbastecimiento =?," //17
                    + " IdPavimentacion =?,"//18
                    + " IdPosicionMedidor =?, "//19
                    + "IdPozoArtesanal =?, "//20
                    + "IdSeguridadMedidor =?, "//21
                    + "IdSituacionAgua =?, "//22
                    + "IdSituacionPredio =?, "//23
                    + "IdTipoAlmacenamiento =?,"//24
                    + " IdTipoPredio =?,"//25
                    + "IdTipoPropiedad =?,"//26
                    + " IdTipoServicio =?,"//27
                    + " IdUbiCajaConexAgua =?," //28
                    + " IdUbiCajaConexDesague =?," //29
                    + " IdUsoPredio =?, " //30
                    + "IdVereda =?,"//31
                    + " Cod_Encuestador =?," //32
                    + " Fecha_Encuestador =?, " //33
                    + "Cod_Supervisor =?,"//34
                    + " Fecha_Supervisor =?,"//35
                    + " Cod_Digitador =?,"//36
                    + " Fecha_Digitador =?,"//37
                    + " Cod_Inscripcion =?,"//38
                    + " Manzana =?, "//39
                    + "Lote =?, "//40
                    + "Conexion =?,"//41
                    + "RutaLectura =?,"//42
                    + "RutaReparto =?,"//43
                    + "Secuencia =?,"//44
                    + "Categoria =?,"//45
                    + "CodigoVia =?,"//46
                    + "TipoVia =?,"//47
                    + "NombreVia =?,"//48
                    + "NumMunicipal =?,"//49
                    + "CodigoHabilitacion =?,"//50
                    + "TipoHabilitacion =?,"//51
                    + "NombreHabilitacion =?,"//52
                    + "NumManzana =?,"//53
                    + "NumLote =?,"//54
                    + "Block =?, "//55
                    + "Piso =?, "//56
                    + "Numero =?,"//57
                    + "Complemento =?,"//58
                    + "ApellidoPaternoPropietario =?,"//59
                    + "ApellidoMaternoPropietario =?,"//60
                    + "NombrePropietario =?,"//61
                    + "ApellidoPaternoConyugue =?,"//62
                    + "ApellidoMaternoConyugue =?,"//63
                    + "NombreConyugue =?,"//64
                    + "CorreoElectronico =?, "//65
                    + "CantHabitantesPredio =?,"//66
                    + "NumPiso =?,"//67
                    + "SiNoPredioHabilitado =?,"//68
                    + "SiNoMedidor =?,"//69
                    + "NumeroMedidor =?,"//70
                    + "SiNoIlegibleNumMedidor =?,"//71
                    + "Lectura =?, "//72
                    + "SiNoIlegibleLectura =?, "//73
                    + "MarcaMedidor =?, "//74
                    + "SiNoTapaConexionAgua =?, "//75
                    + "IdMaterialConexionAgua =?,"//76
                    + "SiNoFugaAgua =?, "//77
                    + "IdTipoFugaAgua =?,"//78
                    + "SiNoFugaDesague =?,"//79
                    + "FrecuenciaAbastecimientoHorasPorDia =?, "//80
                    + "FrecuenciaAbastecimientoDiasPorSemana =?, "//81
                    + "Observaciones =?, "//82
                    + "ApellidoPaternoEntrevistado =?, "//83
                    + "ApellidoMaternoEntrevistado =?, "//84
                    + "NombreCompletoEntrevistado =?, "//85
                    + "DocumentoEntrevistado =?, "//86
                    + "IdTipoPropiedadInquilino =?, "//87
                    + "CodigoFotoCaja =?, "//88
                    + "CodigoFotoPredio =?, "//89
                    + "CodDepartamento =?, "//90
                    + "CodProvincia =?, "//91
                    + "CodDistrito =?,"//92
                    + "Seccion =?,"//93
                    + "IdTipoDocumento =?,"//94
                    + "NumeroDocumentoPropietario =?,"//95
                    + "Telefono =?,"//96
                    + "UbicacionConexionAgua =?,"//97
                    + "UbicacionConexionDesague =?,"//98
                    + "IdEstadoMedidorAgua =?,"//99
                    + "PorcentajeComercial =?,"//100
                    + "PorcentajeDomestico =?,"//101
                    + "PorcentajeEstatal =?,"//102
                    + "IdSituacionConexion =?,"
                    + "IdMaterialConexionDesague=?,"
                    + "IdTipoCaracteristicaDesague=?,"
                    + "IdTipoFotoAgua=?,"
                    + "SiNoTapaConexionDesague=?"//103
                    + " where IdRegistroMedida="+oCEMedida.getIdRegistroMedida();//104
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,oCEMedida.getNumeroFicha());
            ps.setString(2,oCEMedida.getPorcentajeSocial());
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
            ps.setString(66,oCEMedida.getCantHabitantesPredio());
            ps.setString(67,oCEMedida.getNumPiso());
            ps.setBoolean(68,oCEMedida.isSiNoPredioHabilitado());
            ps.setBoolean(69,oCEMedida.isSiNoMedidor());
            ps.setString(70,oCEMedida.getNumeroMedidor());
            ps.setBoolean(71,oCEMedida.isSiNoIlegibleNumMedidor());
            ps.setString(72,oCEMedida.getLectura());
            ps.setBoolean(73,oCEMedida.isSiNoIlegibleLectura());
            ps.setString(74,oCEMedida.getMarcaMedidor());
            ps.setBoolean(75,oCEMedida.isSiNoTapaConexionAgua());
            ps.setInt(76,oCEMedida.getIdMaterialConexionAgua());
            ps.setBoolean(77,oCEMedida.isSiNoFugaAgua());
            ps.setInt(78,oCEMedida.getTipoFugaAgua());
            ps.setBoolean(79,oCEMedida.isSiNoFugaDesague());
            ps.setString(80,oCEMedida.getFrecuenciaAbastecimientoHorasPorDia());
            ps.setString(81,oCEMedida.getFrecuenciaAbastecimientoDiasPorSemana());
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
            ps.setString(97, oCEMedida.getUbicacionConexionAgua());
            ps.setString(98, oCEMedida.getUbicacionConexionDesague());
            ps.setDouble(99, oCEMedida.getIdEstadoMedidor());
            ps.setString(100, oCEMedida.getPorcentajeComercial());
            ps.setString(101, oCEMedida.getPorcentajeDomestico());
            ps.setString(102, oCEMedida.getPorcentajeEstatal());
            ps.setDouble(103, oCEMedida.getIdSituacionConexion());
            ps.setInt(104,oCEMedida.getIdMaterialConexionDesague());
            ps.setInt(105,oCEMedida.getIdTipoCaracteristicasCajaDesague());
            ps.setInt(106,oCEMedida.getIdTipoFotoAgua());
            ps.setBoolean(107,oCEMedida.isSiNoTapaConexionDesague());

            int valor=ps.executeUpdate();
            if(valor==1)
            {
                int a=1;
                for(CEUsos oCEUsos:oCEMedida.getoLstUsos())
                {

                    if(oCEUsos.getCodigo()==1)
                    {
                        String sql2="INSERT INTO usos (Numero, Respo, TipoUso, CodUso, PtosAgua, NumPersona, Complemento, Categoria,IdRegistroMedida) VALUES ( ?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps1 = con.prepareCall(sql2);
                        ps1.setString(1, oCEUsos.getNumero());
                        ps1.setString(2, oCEUsos.getRespo());
                        ps1.setString(3, oCEUsos.getTipoUso());
                        ps1.setString(4, oCEUsos.getCodUso());
                        ps1.setString(5, oCEUsos.getPtosAgua());
                        ps1.setString(6, oCEUsos.getNumPersona());
                        ps1.setString(7, oCEUsos.getComplemento());
                        ps1.setString(8, oCEUsos.getCategoria());
                         ps1.setInt(9, oCEMedida.getIdRegistroMedida());
                        a=ps1.executeUpdate();
                        if(a==2)
                        {
                            break;
                        }
                    }
                    else
                    {
                        if(oCEUsos.getCodigo()==2)
                        {
                            String sql2="UPDATE   usos SET   Numero = ?, Respo = ?, TipoUso = ?, CodUso =?, PtosAgua =?,  NumPersona = ?, Complemento = ?, Categoria = ?,IdRegistroMedida=? WHERE IdUso = ?";
                            PreparedStatement ps1 = con.prepareCall(sql2);
                            ps1.setString(1, oCEUsos.getNumero());
                            ps1.setString(2, oCEUsos.getRespo());
                            ps1.setString(3, oCEUsos.getTipoUso());
                            ps1.setString(4, oCEUsos.getCodUso());
                            ps1.setString(5, oCEUsos.getPtosAgua());
                            ps1.setString(6, oCEUsos.getNumPersona());
                            ps1.setString(7, oCEUsos.getComplemento());
                            ps1.setString(8, oCEUsos.getCategoria());
                            ps1.setInt(9, oCEMedida.getIdRegistroMedida());
                            ps1.setInt(10, oCEUsos.getIdUso());
                            a=ps1.executeUpdate();
                            if(a==2)
                            {
                                break;
                            }
                        }
                        else
                        {
                            if(oCEUsos.getCodigo()==3)
                            {
                                String sql2="delete from usos where IdUso=?";
                                PreparedStatement ps1 = con.prepareCall(sql2);
                                ps1.setInt(1, oCEUsos.getIdUso());
                                a=ps1.executeUpdate();
                                if(a==2)
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
                if(a==1)
                {
                    con.commit();
                    return true;
                }
                else
                {
                   con.rollback();
                   return false;
                }
            }
            else
            {
                con.rollback();
                return false;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CDMedida.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          finally
           {
                try
                {
                    con.close();
                }
                catch (SQLException ex) {

                }
            }


    }
       public ArrayList<CEMedida> listarPorCodigoInscripcion(String dato)
    {
        ArrayList<CEMedida> oLstLlavesPaso=new ArrayList<CEMedida>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT  rm.NumeroFicha,"
                    + " rm.Cod_Inscripcion,"
                    + "concat(rm.ApellidoPaternoPropietario,' ',rm.ApellidoMaternoPropietario,',',rm.NombrePropietario),"
                    + "  rm.CodDepartamento,  "
                    + "rm.CodProvincia,"
                    + "  rm.CodDistrito,  "
                    + "rm.Manzana, "
                    + " rm.Lote, "
                    + " rm.CodigoVia,"
                    + "  rm.TipoVia, "
                    + " rm.NombreVia, "
                    + " rm.CodigoHabilitacion, "
                    + " rm.TipoHabilitacion, "
                    + " rm.NombreHabilitacion,"
                    + "rm.IdRegistroMedida,"
                     + "date_format(rm.Fecha_Encuestador,'%d/%m/%Y')"
                    + " FROM medidor.registro_medida rm"
                    + " WHERE rm.Cod_Inscripcion like '"+dato+"%'";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            while(rs.next())
            {
                CEMedida oCEMedida=new CEMedida();
                oCEMedida.setNumeroFicha(rs.getString(1));
                oCEMedida.setCod_Inscripcion(rs.getString(2));
                oCEMedida.setApellidoPaternoPropietario(rs.getString(3));
                oCEMedida.setCodDepartamento(rs.getString(4));
                oCEMedida.setCodProvincia(rs.getString(5));
                oCEMedida.setCodDistrito(rs.getString(6));
                oCEMedida.setManzana(rs.getString(7));
                oCEMedida.setLote(rs.getString(8));
                oCEMedida.setCodigoVia(rs.getString(9));
                oCEMedida.setTipoVia(rs.getString(10));
                oCEMedida.setNombreVia(rs.getString(11));
                oCEMedida.setCodigoHabilitacion(rs.getString(12));
                oCEMedida.setTipoHabilitacion(rs.getString(13));
                oCEMedida.setNombreHabilitacion(rs.getString(14));
                oCEMedida.setIdRegistroMedida(rs.getInt(15));
                oCEMedida.setFecha_Encuestador(rs.getString(16));
                oLstLlavesPaso.add(oCEMedida);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return oLstLlavesPaso;

    }
       public ArrayList<CEMedida> listarPorUsuario(String dato)
    {
        ArrayList<CEMedida> oLstLlavesPaso=new ArrayList<CEMedida>();
           Connection conn = ConexionBD.obtenerConexion();
        try
        {
         
            String sql = "SELECT  rm.NumeroFicha, rm.Cod_Inscripcion,concat(rm.ApellidoPaternoPropietario,' ',rm.ApellidoMaternoPropietario,',',rm.NombrePropietario), date_format(rm.Fecha_Encuestador,'%d/%m/%Y'),  rm.CodDepartamento,  rm.CodProvincia,  rm.CodDistrito,  rm.Manzana,  rm.Lote,  rm.CodigoVia,  rm.TipoVia,  rm.NombreVia,  rm.CodigoHabilitacion,  rm.TipoHabilitacion,  rm.NombreHabilitacion FROM medidor.registro_medida rm"
                    + " WHERE rm.concat(rm.ApellidoPaternoPropietario,' ',rm.ApellidoMaternoPropietario,',',rm.NombrePropietario,rm.IdRegistroMedida) like '"+dato+"%'";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            while(rs.next())
            {
                CEMedida oCEMedida=new CEMedida();
                oCEMedida.setNumeroFicha(rs.getString(1));
                oCEMedida.setCod_Inscripcion(rs.getString(2));
                oCEMedida.setApellidoPaternoPropietario(rs.getString(3));
                oCEMedida.setCodDepartamento(rs.getString(4));
                oCEMedida.setCodProvincia(rs.getString(5));
                oCEMedida.setCodDistrito(rs.getString(6));
                oCEMedida.setManzana(rs.getString(7));
                oCEMedida.setLote(rs.getString(8));
                oCEMedida.setCodigoVia(rs.getString(9));
                oCEMedida.setTipoVia(rs.getString(10));
                oCEMedida.setNombreVia(rs.getString(11));
                oCEMedida.setCodigoHabilitacion(rs.getString(12));
                oCEMedida.setTipoHabilitacion(rs.getString(13));
                oCEMedida.setNombreHabilitacion(rs.getString(14));
                oCEMedida.setIdRegistroMedida(rs.getInt(15));
                oLstLlavesPaso.add(oCEMedida);
            }

        }
        catch (SQLException ex)
        {

            ex.printStackTrace();
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
        return oLstLlavesPaso;

    }
    public ArrayList<CEMedida> listarPorNumeroFicha(String dato)
    {
        ArrayList<CEMedida> oLstLlavesPaso=new ArrayList<CEMedida>();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT  rm.NumeroFicha,"
                    + " rm.Cod_Inscripcion,"
                    + "concat(rm.ApellidoPaternoPropietario,' ',rm.ApellidoMaternoPropietario,',',rm.NombrePropietario),"
                    + "  rm.CodDepartamento,  "
                    + "rm.CodProvincia,"
                    + "  rm.CodDistrito,  "
                    + "rm.Manzana, "
                    + " rm.Lote, "
                    + " rm.CodigoVia,"
                    + "  rm.TipoVia, "
                    + " rm.NombreVia, "
                    + " rm.CodigoHabilitacion, "
                    + " rm.TipoHabilitacion, "
                    + " rm.NombreHabilitacion,"
                    + "rm.IdRegistroMedida,"
                     + "date_format(rm.Fecha_Encuestador,'%d/%m/%Y') "
                    + " FROM medidor.registro_medida rm"
                    + " WHERE rm.NumeroFicha like '"+dato+"%'";
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            while(rs.next())
            {
                CEMedida oCEMedida=new CEMedida();
                oCEMedida.setNumeroFicha(rs.getString(1));
                oCEMedida.setCod_Inscripcion(rs.getString(2));
                oCEMedida.setApellidoPaternoPropietario(rs.getString(3));
                oCEMedida.setCodDepartamento(rs.getString(4));
                oCEMedida.setCodProvincia(rs.getString(5));
                oCEMedida.setCodDistrito(rs.getString(6));
                oCEMedida.setManzana(rs.getString(7));
                oCEMedida.setLote(rs.getString(8));
                oCEMedida.setCodigoVia(rs.getString(9));
                oCEMedida.setTipoVia(rs.getString(10));
                oCEMedida.setNombreVia(rs.getString(11));
                oCEMedida.setCodigoHabilitacion(rs.getString(12));
                oCEMedida.setTipoHabilitacion(rs.getString(13));
                oCEMedida.setNombreHabilitacion(rs.getString(14));
                oCEMedida.setIdRegistroMedida(rs.getInt(15));
                oCEMedida.setFecha_Encuestador(rs.getString(16));
                oLstLlavesPaso.add(oCEMedida);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
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
        return oLstLlavesPaso;

    }
    public CEMedida ConsultarMedida(int dato)
    {
        CEMedida oCEMedida=new CEMedida();
        Connection conn = ConexionBD.obtenerConexion();
        try
        {
            
            String sql = "SELECT "
                    + "IdRegistroMedida,"
                    + "NumeroFicha,"
                    + "IdCondicionConexionAgua,"
                    + "IdCondicionConexionDesague,"
                    + "IdDiametroConexionDesague,"
                    + "IdDiametroConexionAgua,"
                    + "IdDiametroMedidor,"
                    + "IdEstadoCajaAgua,"
                    + "IdEstadoCajaDesague,"
                    + "IdEstadoTapaAgua,"
                    + "IdEstadoTapaDesague,"
                    + "IdLlavePaso,"
                    + "IdMaterialCajaAgua,"
                    + "IdMaterialCajaDesague,"
                    + "IdMaterialTapaAgua,"
                    + "IdMaterialTapaDesague,"
                    + "IdMedioAbastecimiento,"
                    + "IdPavimentacion,"
                    + "IdPosicionMedidor,"
                    + "IdPozoArtesanal,"
                    + "IdSeguridadMedidor,"
                    + "IdSituacionAgua,"
                    + "IdSituacionPredio,"
                    + "IdTipoAlmacenamiento,"
                    + "IdTipoPredio,"
                    + "IdTipoPropiedad,"
                    + "IdTipoServicio,"
                    + "IdUbiCajaConexAgua,"
                    + "IdUbiCajaConexDesague,"
                    + "IdUsoPredio,"
                    + "IdVereda,"
                    + "Cod_Encuestador,"
                    + "Fecha_Encuestador,"
                    + "Cod_Supervisor,"
                    + "Fecha_Supervisor,"
                    + "Cod_Digitador,"
                    + "Fecha_Digitador,"
                    + "Cod_Inscripcion,"
                    + "Manzana,"
                    + "Lote,"
                    + "Conexion,"
                    + "RutaLectura,"
                    + "RutaReparto,"
                    + "Secuencia,"
                    + "Categoria,"
                    + "CodigoVia,"
                    + "TipoVia,"
                    + "NombreVia,"
                    + "NumMunicipal,"
                    + "CodigoHabilitacion,"
                    + "TipoHabilitacion,"
                    + "NombreHabilitacion,"
                    + "NumManzana,"
                    + "NumLote,"
                    + "Block,"
                    + "Piso,"
                    + "Numero,"
                    + "Complemento,"
                    + "ApellidoPaternoPropietario,"
                    + "ApellidoMaternoPropietario,"
                    + "NombrePropietario,"
                    + "ApellidoPaternoConyugue,"
                    + "ApellidoMaternoConyugue,"
                    + "NombreConyugue,"
                    + "CorreoElectronico,"
                    + "CantHabitantesPredio,"
                    + "NumPiso,"
                    + "SiNoPredioHabilitado,"
                    + "SiNoMedidor,"
                    + "NumeroMedidor,"
                    + "SiNoIlegibleNumMedidor,"
                    + "Lectura,"
                    + "SiNoIlegibleLectura,"
                    + "MarcaMedidor,"
                    + "SiNoTapaConexionAgua,"
                    + "IdMaterialConexionAgua,"
                    + "IdTipoFugaAgua,"
                    + "SiNoFugaAgua,"
                    + "SiNoFugaDesague,"
                    + "FrecuenciaAbastecimientoHorasPorDia,"
                    + "FrecuenciaAbastecimientoDiasPorSemana,"
                    + "Observaciones,"
                    + "ApellidoPaternoEntrevistado,"
                    + "ApellidoMaternoEntrevistado,"
                    + "NombreCompletoEntrevistado,"
                    + "DocumentoEntrevistado,"
                    + "IdTipoPropiedadInquilino,"
                    + "CodigoFotoCaja,"
                    + "CodigoFotoPredio,"
                    + "CodDepartamento,"
                    + "CodProvincia,"
                    + "CodDistrito,"
                    + "Seccion,"
                    + "IdTipoDocumento,"
                    + "Telefono,"
                    + "NumeroDocumentoPropietario,"
                    + "UbicacionConexionAgua,"
                    + "UbicacionConexionDesague,"
                    + "IdEstadoMedidorAgua,"
                    + "PorcentajeComercial,"
                    + "PorcentajeEstatal,"
                    + "PorcentajeDomestico,"
                    + "PorcentajeSocial,"
                    + "IdSituacionConexion,"
                    + "IdMaterialConexionDesague,"
                    + "IdTipoCaracteristicaDesague,"
                    + "IdTipoFotoAgua,"
                    + "SiNoTapaConexionDesague"
                    + " FROM"
                    + " registro_medida m where m.IdRegistroMedida="+dato;
            PreparedStatement sp = conn.prepareStatement(sql);
            ResultSet rs=sp.executeQuery();
            if(rs.next())
            {
                oCEMedida.setNumeroFicha(rs.getString(2));//1
                oCEMedida.setIdSituacionConexion(rs.getInt(104));//2
                oCEMedida.setIdMaterialConexionDesague(rs.getInt(105));//2
                oCEMedida.setIdTipoCaracteristicasCajaDesague(rs.getInt(106));//2
                oCEMedida.setIdTipoFotoAgua(rs.getInt(107));//2
                oCEMedida.setCodDepartamento(rs.getString(90));//3
                oCEMedida.setCodProvincia(rs.getString(91));//4
                oCEMedida.setCodDistrito(rs.getString(92));//5
                oCEMedida.setSeccion(rs.getString(93));//6
                oCEMedida.setManzana(rs.getString(39));//7
                oCEMedida.setLote(rs.getString(40));//8
                oCEMedida.setConexion(rs.getString(41));//9 OK

                oCEMedida.setCod_Inscripcion(rs.getString(38));//10
                oCEMedida.setRutaLectura(rs.getString(42));//11
                oCEMedida.setRutaReparto(rs.getString(43));//12
                oCEMedida.setSecuencia(rs.getString(44));//13
                oCEMedida.setCategoria(rs.getString(45));//14 OK

                oCEMedida.setIdTipoDocumento(rs.getInt(94));//15
                oCEMedida.setNumeroDocumento(rs.getString(96));//16
                oCEMedida.setTelefono(rs.getString(95));//17
                oCEMedida.setApellidoPaternoPropietario(rs.getString(59));//18
                oCEMedida.setApellidoMaternoPropietario(rs.getString(60));//19
                oCEMedida.setNombrePropietario(rs.getString(61));//20
                oCEMedida.setApellidoPaternoConyugue(rs.getString(62));//21
                oCEMedida.setApellidoMaternoConyugue(rs.getString(63));//22 OK

                oCEMedida.setNombreConyugue(rs.getString(64));//23
                oCEMedida.setCorreoElectronico(rs.getString(65));//24
                oCEMedida.setIdTipoPropiedad(rs.getInt(26));//25
                oCEMedida.setCantHabitantesPredio(rs.getString(66));//26
                oCEMedida.setNumPiso(rs.getString(67));//27
                oCEMedida.setIdTipoPredio(rs.getInt(25));//28 OK


                oCEMedida.setCodigoVia(rs.getString(46));//29
                oCEMedida.setTipoVia(rs.getString(47));//30
                oCEMedida.setNombreVia(rs.getString(48));//31
                oCEMedida.setNumMunicipal(rs.getString(49));//32
                oCEMedida.setCodigoHabilitacion(rs.getString(50));//33
                oCEMedida.setTipoHabilitacion(rs.getString(51));//34
                oCEMedida.setNombreHabilitacion(rs.getString(52));//35
                oCEMedida.setNumManzana(rs.getString(53));//36 OK


                oCEMedida.setNumLote(rs.getString(54));//37
                oCEMedida.setBlock(rs.getString(55));//38
                oCEMedida.setPiso(rs.getString(56));//39
                oCEMedida.setNumero(rs.getString(57));//40
                oCEMedida.setIdUsoPredio(rs.getInt(30));//41 ok


                oCEMedida.setComplemento(rs.getString(58));//42
                oCEMedida.setSiNoPredioHabilitado(rs.getBoolean(68));//43
                oCEMedida.setIdTipoServicio(rs.getInt(27));//44
                oCEMedida.setIdMedioAbastecimiento(rs.getInt(17));//45
                oCEMedida.setIdSituacionPredio(rs.getInt(23));//46
                oCEMedida.setIdTipoAlmacenamiento(rs.getInt(24));//47

                oCEMedida.setPorcentajeDomestico(rs.getString(102));//48
                oCEMedida.setPorcentajeComercial(rs.getString(100));//49
                oCEMedida.setPorcentajeEstatal(rs.getString(101));//50
                oCEMedida.setPorcentajeSocial(rs.getString(103));//51

                oCEMedida.setSiNoMedidor(rs.getBoolean(69));//52
                oCEMedida.setNumeroMedidor(rs.getString(70));//53
                oCEMedida.setSiNoIlegibleNumMedidor(rs.getBoolean(71));//54
                oCEMedida.setMarcaMedidor(rs.getString(74));//55
                oCEMedida.setLectura(rs.getString(72));//56
                oCEMedida.setSiNoIlegibleLectura(rs.getBoolean(73));//57


                oCEMedida.setIdDiametroMedidor(rs.getInt(7));//58
                oCEMedida.setIdEstadoMedidor(rs.getInt(99));//59 ok


                oCEMedida.setIdLlavePaso(rs.getInt(12));//60
                oCEMedida.setIdSeguridadMedidor(rs.getInt(21));//61
                oCEMedida.setIdPosicionMedidor(rs.getInt(19));//62
                oCEMedida.setIdSituacionAgua(rs.getInt(22));//63
                oCEMedida.setIdUbiCajaConexAgua(rs.getInt(28));//64
                oCEMedida.setIdDiametroConexionAgua(rs.getInt(6));//65 ok


                oCEMedida.setIdCondicionConexionAgua(rs.getInt(3));//66
                oCEMedida.setIdMaterialCajaAgua(rs.getInt(13));//67
                oCEMedida.setIdEstadoCajaAgua(rs.getInt(8));//68
                oCEMedida.setIdMaterialConexionAgua(rs.getInt(76));//69
                oCEMedida.setSiNoTapaConexionAgua(rs.getBoolean(75));//70

                oCEMedida.setIdMaterialTapaAgua(rs.getInt(15));//68

                oCEMedida.setIdEstadoTapaAgua(rs.getInt(10));//68

                oCEMedida.setSiNoFugaAgua(rs.getBoolean(78));//71
                oCEMedida.setTipoFugaAgua(rs.getInt(77));//72 ok

                oCEMedida.setIdUbiCajaConexDesague(rs.getInt(29));//74
                oCEMedida.setIdDiametroConexionDesague(rs.getInt(5));//75
                oCEMedida.setIdCondicionConexionDesague(rs.getInt(4));//76
                oCEMedida.setIdMaterialCajaDesague(rs.getInt(14));//77
                oCEMedida.setIdMaterialTapaDesague(rs.getInt(16));//78   ok


                oCEMedida.setIdEstadoTapaDesague(rs.getInt(11));//79
                oCEMedida.setIdEstadoCajaDesague(rs.getInt(9));//80
                oCEMedida.setSiNoFugaDesague(rs.getBoolean(79));//81
                oCEMedida.setIdPavimentacion(rs.getInt(18));//82
                oCEMedida.setIdVereda(rs.getInt(31));//83 ok


                oCEMedida.setIdPozoArtesanal(rs.getInt(20));//84
                oCEMedida.setFrecuenciaAbastecimientoHorasPorDia(rs.getString(80));//85
                oCEMedida.setFrecuenciaAbastecimientoDiasPorSemana(rs.getString(81));//86 ok

                oCEMedida.setObservaciones(rs.getString(82));//87
                oCEMedida.setApellidoPaternoEntrevistado(rs.getString(83));//88
                oCEMedida.setApellidoMaternoEntrevistado(rs.getString(84));//89
                oCEMedida.setNombreCompletoEntrevistado(rs.getString(85));//90
                oCEMedida.setDocumentoEntrevistado(rs.getString(86));//91
                oCEMedida.setIdTipoPropiedadEntrevistado(rs.getInt(87));//92 ok

                oCEMedida.setCodigoFotoCaja(rs.getString(88));//93
                oCEMedida.setCodigoFotoPredio(rs.getString(89));//94
                oCEMedida.setUbicacionConexionAgua(rs.getString(97));//95
                oCEMedida.setUbicacionConexionDesague(rs.getString(98));//96
                oCEMedida.setCod_Encuestador(rs.getString(32));//97


                oCEMedida.setFecha_Encuestador(rs.getString(33));//98
                oCEMedida.setCod_Supervisor(rs.getString(34));//99
                oCEMedida.setFecha_Supervisor(rs.getString(35));//100
                oCEMedida.setCod_Digitado(rs.getString(36));//101
                oCEMedida.setFecha_Digitador(rs.getString(37));//102
                oCEMedida.setSiNoTapaConexionDesague(rs.getBoolean(108));//102

                oCEMedida.setoLstUsos(oLstUsos());
            }
            conn.close();

        }
        catch (SQLException ex)
        {

            ex.printStackTrace();
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
        return oCEMedida;

    }
    public ArrayList oLstUsos()
    {
        Connection con = ConexionBD.obtenerConexion();
        try {
            
            ArrayList<CEUsos> oLstUsos=new ArrayList<CEUsos>();
            String sql = "SELECT IdRegistroMedida,IdUso, Numero, Respo,TipoUso,CodUso,PtosAgua,NumPersona,Complemento,Categoria FROM medidor.usos";
            PreparedStatement sp = con.prepareStatement(sql);
            ResultSet rs = sp.executeQuery();
            while(rs.next())
            {
                CEUsos oCEUsos=new CEUsos();
                oCEUsos.setIdRegistroMedida(rs.getInt(1));
                oCEUsos.setIdUso(rs.getInt(2));
                oCEUsos.setNumero(rs.getString(3));
                oCEUsos.setRespo(rs.getString(4));
                oCEUsos.setTipoUso(rs.getString(5));
                oCEUsos.setCodUso(rs.getString(6));
                oCEUsos.setPtosAgua(rs.getString(7));
                oCEUsos.setNumPersona(rs.getString(8));
                oCEUsos.setComplemento(rs.getString(9));
                oCEUsos.setCategoria(rs.getString(10));
                oLstUsos.add(oCEUsos);
            }
            return oLstUsos;
        } catch (SQLException ex) {
            Logger.getLogger(CDMedida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         finally
           {
                try
                {
                    con.close();
                }
                catch (SQLException ex) {

                }
            }
    }
    public boolean eliminarMedida(int dato)
    {
        try
        {
            Connection con = ConexionBD.obtenerConexion();
            String sql = "DELETE FROM registro_medida where IdRegistroMedida="+dato;
            String sql2 = "DELETE FROM usos where IdRegistroMedida="+dato;
            PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps1 = con.prepareCall(sql2);
            
            ps.execute();
            ps1.execute();
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CDMedida.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }
}
