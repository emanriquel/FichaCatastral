package modelo.entidad;

import java.util.ArrayList;

public class CEMedida
{
  private int IdRegistroMedida ;
  private String NumeroFicha ;
  private int IdSituacionConexion;
  private int IdCondicionConexionAgua;
  private int IdCondicionConexionDesague;
  private int IdDiametroConexionDesague;
  private int IdDiametroConexionAgua;
  private int IdDiametroMedidor;
  private int IdEstadoCajaDesague;
  private int IdEstadoCajaAgua;
  private int IdEstadoTapaDesague;
  private int IdEstadoTapaAgua;
  private int IdLlavePaso;
  private int IdMaterialCajaAgua;
  private int IdMaterialCajaDesague;
  private int IdMaterialTapaAgua;
  private int IdMaterialTapaDesague;
  private int IdMedioAbastecimiento;
  private int IdPavimentacion;
  private int IdPosicionMedidor;
  private int IdPozoArtesanal;
  private int IdSeguridadMedidor;
  private int IdSituacionAgua;
  private int IdSituacionPredio;
  private int IdTipoAlmacenamiento;
  private int IdTipoPredio;
  private int IdTipoPropiedad;
  private int IdTipoServicio;
  private int IdUbiCajaConexAgua;
  private int IdUbiCajaConexDesague;
  private int IdUsoPredio;
  private int IdVereda;
  private int IdTipoDocumento;
  private int IdEstadoMedidor;
  private String NumeroDocumento;
  private String Cod_Encuestador;
  private String Fecha_Encuestador;
  private String Cod_Supervisor;
  private String Fecha_Supervisor;
  private String Cod_Digitado;
  private String Fecha_Digitador;
  private String Cod_Inscripcion;
  private String Seccion;
  private String Manzana;
  private String Lote;
  private String Conexion;
  private String RutaLectura;
  private String RutaReparto;
  private String Secuencia;
  private String Categoria;
  private String CodigoVia;
  private String TipoVia;
  private String NombreVia;
  private String NumMunicipal;
  private String CodigoHabilitacion;
  private String TipoHabilitacion;
  private String NombreHabilitacion;
  private String NumManzana;
  private String NumLote;
  private String Block;
  private String Piso;
  private String Numero;
  private String Complemento;
  private String ApellidoPaternoPropietario;
  private String ApellidoMaternoPropietario;
  private String NombrePropietario;
  private String ApellidoPaternoConyugue;
  private String ApellidoMaternoConyugue;
  private String NombreConyugue;
  private String CorreoElectronico;
  private int CantHabitantesPredio;
  private int NumPiso;
  private boolean SiNoPredioHabilitado;
  private boolean SiNoMedidor;
  private String NumeroMedidor;
  private boolean SiNoIlegibleNumMedidor;
  private double Lectura;
  private boolean SiNoIlegibleLectura;
  private String MarcaMedidor;
  private boolean SiNoTapaConexionAgua;
  private boolean SiNoFugaAgua;
  private int TipoFugaAgua;
  private boolean SiNoFugaDesague;
  private double FrecuenciaAbastecimientoHorasPorDia;
  private double FrecuenciaAbastecimientoDiasPorSemana;
  private String Observaciones;
  private String ApellidoPaternoEntrevistado;
  private String ApellidoMaternoEntrevistado;
  private String NombreCompletoEntrevistado;
  private String DocumentoEntrevistado;
  private int IdTipoPropiedadEntrevistado;
  private String CodigoFotoCaja;
  private String CodigoFotoPredio;
  private String CodDepartamento;
  private String CodProvincia;
  private String CodDistrito;
  private String Telefono;
  private double PorcentajeEstatal;
  private double PorcentajeComercial;
  private double PorcentajeDomestico;
  private double PorcentajeSocial;
  private double UbicacionConexionAgua;
  private double UbicacionConexionDesague;
  private ArrayList<CEUsos> oLstUsos;
  private int IdTipoCaracteristicasCajaDesague;
  private int IdMaterialConexionAgua;
  private int IdMaterialConexionDesague;
  private int IdTipoFotoAgua;

    public int getIdMaterialConexionAgua() {
        return IdMaterialConexionAgua;
    }

    public void setIdMaterialConexionAgua(int IdMaterialConexionAgua) {
        this.IdMaterialConexionAgua = IdMaterialConexionAgua;
    }

    public int getIdMaterialConexionDesague() {
        return IdMaterialConexionDesague;
    }

    public void setIdMaterialConexionDesague(int IdMaterialConexionDesague) {
        this.IdMaterialConexionDesague = IdMaterialConexionDesague;
    }

    public int getIdTipoCaracteristicasCajaDesague() {
        return IdTipoCaracteristicasCajaDesague;
    }

    public void setIdTipoCaracteristicasCajaDesague(int IdTipoCaracteristicasCajaDesague) {
        this.IdTipoCaracteristicasCajaDesague = IdTipoCaracteristicasCajaDesague;
    }

    public String getApellidoMaternoConyugue() {
        return ApellidoMaternoConyugue;
    }

    public void setApellidoMaternoConyugue(String ApellidoMaternoConyugue) {
        this.ApellidoMaternoConyugue = ApellidoMaternoConyugue;
    }

    public String getApellidoMaternoEntrevistado() {
        return ApellidoMaternoEntrevistado;
    }

    public void setApellidoMaternoEntrevistado(String ApellidoMaternoEntrevistado) {
        this.ApellidoMaternoEntrevistado = ApellidoMaternoEntrevistado;
    }

    public String getApellidoMaternoPropietario() {
        return ApellidoMaternoPropietario;
    }

    public void setApellidoMaternoPropietario(String ApellidoMaternoPropietario) {
        this.ApellidoMaternoPropietario = ApellidoMaternoPropietario;
    }

    public String getApellidoPaternoConyugue() {
        return ApellidoPaternoConyugue;
    }

    public void setApellidoPaternoConyugue(String ApellidoPaternoConyugue) {
        this.ApellidoPaternoConyugue = ApellidoPaternoConyugue;
    }

    public String getApellidoPaternoEntrevistado() {
        return ApellidoPaternoEntrevistado;
    }

    public void setApellidoPaternoEntrevistado(String ApellidoPaternoEntrevistado) {
        this.ApellidoPaternoEntrevistado = ApellidoPaternoEntrevistado;
    }

    public String getApellidoPaternoPropietario() {
        return ApellidoPaternoPropietario;
    }

    public void setApellidoPaternoPropietario(String ApellidoPaternoPropietario) {
        this.ApellidoPaternoPropietario = ApellidoPaternoPropietario;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String Block) {
        this.Block = Block;
    }

    public int getCantHabitantesPredio() {
        return CantHabitantesPredio;
    }

    public void setCantHabitantesPredio(int CantHabitantesPredio) {
        this.CantHabitantesPredio = CantHabitantesPredio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCodDepartamento() {
        return CodDepartamento;
    }

    public void setCodDepartamento(String CodDepartamento) {
        this.CodDepartamento = CodDepartamento;
    }

    public String getCodDistrito() {
        return CodDistrito;
    }

    public void setCodDistrito(String CodDistrito) {
        this.CodDistrito = CodDistrito;
    }

    public String getCodProvincia() {
        return CodProvincia;
    }

    public void setCodProvincia(String CodProvincia) {
        this.CodProvincia = CodProvincia;
    }

    public String getCod_Digitado() {
        return Cod_Digitado;
    }

    public void setCod_Digitado(String Cod_Digitado) {
        this.Cod_Digitado = Cod_Digitado;
    }

    public String getCod_Encuestador() {
        return Cod_Encuestador;
    }

    public void setCod_Encuestador(String Cod_Encuestador) {
        this.Cod_Encuestador = Cod_Encuestador;
    }

    public String getCod_Inscripcion() {
        return Cod_Inscripcion;
    }

    public void setCod_Inscripcion(String Cod_Inscripcion) {
        this.Cod_Inscripcion = Cod_Inscripcion;
    }

    public String getCod_Supervisor() {
        return Cod_Supervisor;
    }

    public void setCod_Supervisor(String Cod_Supervisor) {
        this.Cod_Supervisor = Cod_Supervisor;
    }

    public String getCodigoFotoCaja() {
        return CodigoFotoCaja;
    }

    public void setCodigoFotoCaja(String CodigoFotoCaja) {
        this.CodigoFotoCaja = CodigoFotoCaja;
    }

    public String getCodigoFotoPredio() {
        return CodigoFotoPredio;
    }

    public void setCodigoFotoPredio(String CodigoFotoPredio) {
        this.CodigoFotoPredio = CodigoFotoPredio;
    }

    public String getCodigoHabilitacion() {
        return CodigoHabilitacion;
    }

    public void setCodigoHabilitacion(String CodigoHabilitacion) {
        this.CodigoHabilitacion = CodigoHabilitacion;
    }

    public String getCodigoVia() {
        return CodigoVia;
    }

    public void setCodigoVia(String CodigoVia) {
        this.CodigoVia = CodigoVia;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getConexion() {
        return Conexion;
    }

    public void setConexion(String Conexion) {
        this.Conexion = Conexion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getDocumentoEntrevistado() {
        return DocumentoEntrevistado;
    }

    public void setDocumentoEntrevistado(String DocumentoEntrevistado) {
        this.DocumentoEntrevistado = DocumentoEntrevistado;
    }

 
    public String getFecha_Digitador() {
        return Fecha_Digitador;
    }

    public void setFecha_Digitador(String Fecha_Digitador) {
        this.Fecha_Digitador = Fecha_Digitador;
    }

    public String getFecha_Encuestador() {
        return Fecha_Encuestador;
    }

    public void setFecha_Encuestador(String Fecha_Encuestador) {
        this.Fecha_Encuestador = Fecha_Encuestador;
    }

    public String getFecha_Supervisor() {
        return Fecha_Supervisor;
    }

    public void setFecha_Supervisor(String Fecha_Supervisor) {
        this.Fecha_Supervisor = Fecha_Supervisor;
    }

    public double getFrecuenciaAbastecimientoDiasPorSemana() {
        return FrecuenciaAbastecimientoDiasPorSemana;
    }

    public void setFrecuenciaAbastecimientoDiasPorSemana(double FrecuenciaAbastecimientoDiasPorSemana) {
        this.FrecuenciaAbastecimientoDiasPorSemana = FrecuenciaAbastecimientoDiasPorSemana;
    }

    public double getFrecuenciaAbastecimientoHorasPorDia() {
        return FrecuenciaAbastecimientoHorasPorDia;
    }

    public void setFrecuenciaAbastecimientoHorasPorDia(double FrecuenciaAbastecimientoHorasPorDia) {
        this.FrecuenciaAbastecimientoHorasPorDia = FrecuenciaAbastecimientoHorasPorDia;
    }

    public int getIdCondicionConexionAgua() {
        return IdCondicionConexionAgua;
    }

    public void setIdCondicionConexionAgua(int IdCondicionConexionAgua) {
        this.IdCondicionConexionAgua = IdCondicionConexionAgua;
    }

    public int getIdCondicionConexionDesague() {
        return IdCondicionConexionDesague;
    }

    public void setIdCondicionConexionDesague(int IdCondicionConexionDesague) {
        this.IdCondicionConexionDesague = IdCondicionConexionDesague;
    }

    public int getIdDiametroConexionAgua() {
        return IdDiametroConexionAgua;
    }

    public void setIdDiametroConexionAgua(int IdDiametroConexionAgua) {
        this.IdDiametroConexionAgua = IdDiametroConexionAgua;
    }

    public int getIdDiametroConexionDesague() {
        return IdDiametroConexionDesague;
    }

    public void setIdDiametroConexionDesague(int IdDiametroConexionDesague) {
        this.IdDiametroConexionDesague = IdDiametroConexionDesague;
    }

    public int getIdDiametroMedidor() {
        return IdDiametroMedidor;
    }

    public void setIdDiametroMedidor(int IdDiametroMedidor) {
        this.IdDiametroMedidor = IdDiametroMedidor;
    }

    public int getIdEstadoCajaDesague() {
        return IdEstadoCajaDesague;
    }

    public void setIdEstadoCajaDesague(int IdEstadoCaja) {
        this.IdEstadoCajaDesague = IdEstadoCaja;
    }

    public int getIdEstadoCajaAgua() {
        return IdEstadoCajaAgua;
    }

    public void setIdEstadoCajaAgua(int IdEstadoCajaAgua) {
        this.IdEstadoCajaAgua = IdEstadoCajaAgua;
    }

    public int getIdEstadoTapaDesague() {
        return IdEstadoTapaDesague;
    }

    public void setIdEstadoTapaDesague(int IdEstadoTapa) {
        this.IdEstadoTapaDesague = IdEstadoTapa;
    }

    public int getIdEstadoTapaAgua() {
        return IdEstadoTapaAgua;
    }

    public void setIdEstadoTapaAgua(int IdEstadoTapaAgua) {
        this.IdEstadoTapaAgua = IdEstadoTapaAgua;
    }

    public int getIdLlavePaso() {
        return IdLlavePaso;
    }

    public void setIdLlavePaso(int IdLlavePaso) {
        this.IdLlavePaso = IdLlavePaso;
    }

    public int getIdMaterialCajaAgua() {
        return IdMaterialCajaAgua;
    }

    public void setIdMaterialCajaAgua(int IdMaterialCajaAgua) {
        this.IdMaterialCajaAgua = IdMaterialCajaAgua;
    }

    public int getIdMaterialCajaDesague() {
        return IdMaterialCajaDesague;
    }

    public void setIdMaterialCajaDesague(int IdMaterialCajaDesague) {
        this.IdMaterialCajaDesague = IdMaterialCajaDesague;
    }

    public int getIdMaterialTapaAgua() {
        return IdMaterialTapaAgua;
    }

    public void setIdMaterialTapaAgua(int IdMaterialTapaAgua) {
        this.IdMaterialTapaAgua = IdMaterialTapaAgua;
    }

    public int getIdMaterialTapaDesague() {
        return IdMaterialTapaDesague;
    }

    public void setIdMaterialTapaDesague(int IdMaterialTapaDesague) {
        this.IdMaterialTapaDesague = IdMaterialTapaDesague;
    }

    public int getIdMedioAbastecimiento() {
        return IdMedioAbastecimiento;
    }

    public void setIdMedioAbastecimiento(int IdMedioAbastecimiento) {
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
    }

    public int getIdPavimentacion() {
        return IdPavimentacion;
    }

    public void setIdPavimentacion(int IdPavimentacion) {
        this.IdPavimentacion = IdPavimentacion;
    }

    public int getIdPosicionMedidor() {
        return IdPosicionMedidor;
    }

    public void setIdPosicionMedidor(int IdPosicionMedidor) {
        this.IdPosicionMedidor = IdPosicionMedidor;
    }

    public int getIdPozoArtesanal() {
        return IdPozoArtesanal;
    }

    public void setIdPozoArtesanal(int IdPozoArtesanal) {
        this.IdPozoArtesanal = IdPozoArtesanal;
    }

    public int getIdRegistroMedida() {
        return IdRegistroMedida;
    }

    public void setIdRegistroMedida(int IdRegistroMedida) {
        this.IdRegistroMedida = IdRegistroMedida;
    }

    public int getIdSeguridadMedidor() {
        return IdSeguridadMedidor;
    }

    public void setIdSeguridadMedidor(int IdSeguridadMedidor) {
        this.IdSeguridadMedidor = IdSeguridadMedidor;
    }

    public int getIdSituacionAgua() {
        return IdSituacionAgua;
    }

    public void setIdSituacionAgua(int IdSituacion) {
        this.IdSituacionAgua = IdSituacion;
    }

    public int getIdSituacionPredio() {
        return IdSituacionPredio;
    }

    public void setIdSituacionPredio(int IdSituacionPredio) {
        this.IdSituacionPredio = IdSituacionPredio;
    }

    public int getIdTipoAlmacenamiento() {
        return IdTipoAlmacenamiento;
    }

    public void setIdTipoAlmacenamiento(int IdTipoAlmacenamiento) {
        this.IdTipoAlmacenamiento = IdTipoAlmacenamiento;
    }

    public int getIdTipoPredio() {
        return IdTipoPredio;
    }

    public void setIdTipoPredio(int IdTipoPredio) {
        this.IdTipoPredio = IdTipoPredio;
    }

    public int getIdTipoPropiedad() {
        return IdTipoPropiedad;
    }

    public void setIdTipoPropiedad(int IdTipoPropiedad) {
        this.IdTipoPropiedad = IdTipoPropiedad;
    }

    public int getIdTipoPropiedadEntrevistado() {
        return IdTipoPropiedadEntrevistado;
    }

    public void setIdTipoPropiedadEntrevistado(int IdTipoPropiedadInquilino) {
        this.IdTipoPropiedadEntrevistado = IdTipoPropiedadInquilino;
    }

    public int getIdTipoServicio() {
        return IdTipoServicio;
    }

    public void setIdTipoServicio(int IdTipoServicio) {
        this.IdTipoServicio = IdTipoServicio;
    }

    public int getIdUbiCajaConexAgua() {
        return IdUbiCajaConexAgua;
    }

    public void setIdUbiCajaConexAgua(int IdUbiCajaConexAgua) {
        this.IdUbiCajaConexAgua = IdUbiCajaConexAgua;
    }

    public int getIdUbiCajaConexDesague() {
        return IdUbiCajaConexDesague;
    }

    public void setIdUbiCajaConexDesague(int IdUbiCajaConexDesague) {
        this.IdUbiCajaConexDesague = IdUbiCajaConexDesague;
    }

    public int getIdUsoPredio() {
        return IdUsoPredio;
    }

    public void setIdUsoPredio(int IdUsoPredio) {
        this.IdUsoPredio = IdUsoPredio;
    }

    public int getIdVereda() {
        return IdVereda;
    }

    public void setIdVereda(int IdVereda) {
        this.IdVereda = IdVereda;
    }

    public double getLectura() {
        return Lectura;
    }

    public void setLectura(double Lectura) {
        this.Lectura = Lectura;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public String getManzana() {
        return Manzana;
    }

    public void setManzana(String Manzana) {
        this.Manzana = Manzana;
    }

    public String getMarcaMedidor() {
        return MarcaMedidor;
    }

    public void setMarcaMedidor(String MarcaMedidor) {
        this.MarcaMedidor = MarcaMedidor;
    }
    public String getNombreCompletoEntrevistado() {
        return NombreCompletoEntrevistado;
    }

    public void setNombreCompletoEntrevistado(String NombreCompletoEntrevistado) {
        this.NombreCompletoEntrevistado = NombreCompletoEntrevistado;
    }

    public String getNombreConyugue() {
        return NombreConyugue;
    }

    public void setNombreConyugue(String NombreConyugue) {
        this.NombreConyugue = NombreConyugue;
    }

    public String getNombreHabilitacion() {
        return NombreHabilitacion;
    }

    public void setNombreHabilitacion(String NombreHabilitacion) {
        this.NombreHabilitacion = NombreHabilitacion;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String NombrePropietario) {
        this.NombrePropietario = NombrePropietario;
    }

    public String getNombreVia() {
        return NombreVia;
    }

    public void setNombreVia(String NombreVia) {
        this.NombreVia = NombreVia;
    }

    public String getNumLote() {
        return NumLote;
    }

    public void setNumLote(String NumLote) {
        this.NumLote = NumLote;
    }

    public String getNumManzana() {
        return NumManzana;
    }

    public void setNumManzana(String NumManzana) {
        this.NumManzana = NumManzana;
    }

    public String getNumMunicipal() {
        return NumMunicipal;
    }

    public void setNumMunicipal(String NumMunicipal) {
        this.NumMunicipal = NumMunicipal;
    }

    public int getNumPiso() {
        return NumPiso;
    }

    public void setNumPiso(int NumPiso) {
        this.NumPiso = NumPiso;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getNumeroFicha() {
        return NumeroFicha;
    }

    public void setNumeroFicha(String NumeroFicha) {
        this.NumeroFicha = NumeroFicha;
    }

    public String getNumeroMedidor() {
        return NumeroMedidor;
    }

    public void setNumeroMedidor(String NumeroMedidor) {
        this.NumeroMedidor = NumeroMedidor;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String Piso) {
        this.Piso = Piso;
    }

    public String getRutaLectura() {
        return RutaLectura;
    }

    public void setRutaLectura(String RutaLectura) {
        this.RutaLectura = RutaLectura;
    }

    public String getRutaReparto() {
        return RutaReparto;
    }

    public void setRutaReparto(String RutaReparto) {
        this.RutaReparto = RutaReparto;
    }

    public String getSecuencia() {
        return Secuencia;
    }

    public void setSecuencia(String Secuencia) {
        this.Secuencia = Secuencia;
    }

 

    public boolean isSiNoFugaAgua() {
        return SiNoFugaAgua;
    }

    public void setSiNoFugaAgua(boolean SiNoFuga) {
        this.SiNoFugaAgua = SiNoFuga;
    }

    public boolean isSiNoIlegibleLectura() {
        return SiNoIlegibleLectura;
    }

    public void setSiNoIlegibleLectura(boolean SiNoIlegibleLectura) {
        this.SiNoIlegibleLectura = SiNoIlegibleLectura;
    }

    public boolean isSiNoIlegibleNumMedidor() {
        return SiNoIlegibleNumMedidor;
    }

    public void setSiNoIlegibleNumMedidor(boolean SiNoIlegibleNumMedidor) {
        this.SiNoIlegibleNumMedidor = SiNoIlegibleNumMedidor;
    }

    public boolean isSiNoMedidor() {
        return SiNoMedidor;
    }

    public void setSiNoMedidor(boolean SiNoMedidor) {
        this.SiNoMedidor = SiNoMedidor;
    }

    public boolean isSiNoPredioHabilitado() {
        return SiNoPredioHabilitado;
    }

    public void setSiNoPredioHabilitado(boolean SiNoPredioHabilitado) {
        this.SiNoPredioHabilitado = SiNoPredioHabilitado;
    }

    public String getTipoHabilitacion() {
        return TipoHabilitacion;
    }

    public void setTipoHabilitacion(String TipoHabilitacion) {
        this.TipoHabilitacion = TipoHabilitacion;
    }

    public String getTipoVia() {
        return TipoVia;
    }

    public void setTipoVia(String TipoVia) {
        this.TipoVia = TipoVia;
    }

    /**
     * @return the SiNoTapaConexionAgua
     */
    public boolean isSiNoTapaConexionAgua() {
        return SiNoTapaConexionAgua;
    }

    /**
     * @param SiNoTapaConexionAgua the SiNoTapaConexionAgua to set
     */
    public void setSiNoTapaConexionAgua(boolean SiNoTapaConexionAgua) {
        this.SiNoTapaConexionAgua = SiNoTapaConexionAgua;
    }

    /**
     * @return the SiNoFugaDesague
     */
    public boolean isSiNoFugaDesague() {
        return SiNoFugaDesague;
    }

    /**
     * @param SiNoFugaDesague the SiNoFugaDesague to set
     */
    public void setSiNoFugaDesague(boolean SiNoFugaDesague) {
        this.SiNoFugaDesague = SiNoFugaDesague;
    }

    /**
     * @return the TipoFugaAgua
     */
    public int getTipoFugaAgua() {
        return TipoFugaAgua;
    }

    /**
     * @param TipoFugaAgua the TipoFugaAgua to set
     */
    public void setTipoFugaAgua(int TipoFugaAgua) {
        this.TipoFugaAgua = TipoFugaAgua;
    }

    /**
     * @return the Seccion
     */
    public String getSeccion() {
        return Seccion;
    }

    /**
     * @param Seccion the Seccion to set
     */
    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    /**
     * @return the IdTipoDocumento
     */
    public int getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    /**
     * @param IdTipoDocumento the IdTipoDocumento to set
     */
    public void setIdTipoDocumento(int IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
    }

    /**
     * @return the NumeroDocumento
     */
    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    /**
     * @param NumeroDocumento the NumeroDocumento to set
     */
    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the PorcentajeEstatal
     */
    public double getPorcentajeEstatal() {
        return PorcentajeEstatal;
    }

    /**
     * @param PorcentajeEstatal the PorcentajeEstatal to set
     */
    public void setPorcentajeEstatal(double PorcentajeEstatal) {
        this.PorcentajeEstatal = PorcentajeEstatal;
    }

    /**
     * @return the PorcentajeComercial
     */
    public double getPorcentajeComercial() {
        return PorcentajeComercial;
    }

    /**
     * @param PorcentajeComercial the PorcentajeComercial to set
     */
    public void setPorcentajeComercial(double PorcentajeComercial) {
        this.PorcentajeComercial = PorcentajeComercial;
    }

    /**
     * @return the PorcentajeDomestico
     */
    public double getPorcentajeDomestico() {
        return PorcentajeDomestico;
    }

    /**
     * @param PorcentajeDomestico the PorcentajeDomestico to set
     */
    public void setPorcentajeDomestico(double PorcentajeDomestico) {
        this.PorcentajeDomestico = PorcentajeDomestico;
    }

    /**
     * @return the PorcentajeSocial
     */
    public double getPorcentajeSocial() {
        return PorcentajeSocial;
    }

    /**
     * @param PorcentajeSocial the PorcentajeSocial to set
     */
    public void setPorcentajeSocial(double PorcentajeSocial) {
        this.PorcentajeSocial = PorcentajeSocial;
    }

    /**
     * @return the IdSituacionConexion
     */
    public int getIdSituacionConexion() {
        return IdSituacionConexion;
    }

    /**
     * @param IdSituacionConexion the IdSituacionConexion to set
     */
    public void setIdSituacionConexion(int IdSituacionConexion) {
        this.IdSituacionConexion = IdSituacionConexion;
    }

    /**
     * @return the IdEstadoMedidor
     */
    public int getIdEstadoMedidor() {
        return IdEstadoMedidor;
    }

    /**
     * @param IdEstadoMedidor the IdEstadoMedidor to set
     */
    public void setIdEstadoMedidor(int IdEstadoMedidor) {
        this.IdEstadoMedidor = IdEstadoMedidor;
    }

    /**
     * @return the UbicacionConexionAgua
     */
    public double getUbicacionConexionAgua() {
        return UbicacionConexionAgua;
    }

    /**
     * @param UbicacionConexionAgua the UbicacionConexionAgua to set
     */
    public void setUbicacionConexionAgua(double UbicacionConexionAgua) {
        this.UbicacionConexionAgua = UbicacionConexionAgua;
    }

    /**
     * @return the UbicacionConexionDesague
     */
    public double getUbicacionConexionDesague() {
        return UbicacionConexionDesague;
    }

    /**
     * @param UbicacionConexionDesague the UbicacionConexionDesague to set
     */
    public void setUbicacionConexionDesague(double UbicacionConexionDesague) {
        this.UbicacionConexionDesague = UbicacionConexionDesague;
    }

    @Override
    public String toString() {
        return this.ApellidoPaternoPropietario;
    }

    /**
     * @return the oLstUsos
     */
    public ArrayList<CEUsos> getoLstUsos() {
        return oLstUsos;
    }

    /**
     * @param oLstUsos the oLstUsos to set
     */
    public void setoLstUsos(ArrayList<CEUsos> oLstUsos) {
        this.oLstUsos = oLstUsos;
    }

    /**
     * @return the IdTipoFotoAgua
     */
    public int getIdTipoFotoAgua() {
        return IdTipoFotoAgua;
    }

    /**
     * @param IdTipoFotoAgua the IdTipoFotoAgua to set
     */
    public void setIdTipoFotoAgua(int IdTipoFotoAgua) {
        this.IdTipoFotoAgua = IdTipoFotoAgua;
    }

}
