/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

/**
 *
 * @author Edwar
 */
public class CECliente {
    private int IdCliente;
    private int IdSituacionConexion;
    private String AntiguoCodigoCatastral;
    private String NuevoCodigoCatastral;
    private String NumeroInscripcion;//5
    private String RutaLectura;
    private String RutaReparto;    
    private String Secuencia;
    private String Categoria;
    private String NumMunicipal;//10
    private String Via;
    private int IdTipoDocumento;
    private String NumeroDocumento;
    private int IdCondicionConexionAgua;
    private String Telefono;
    private String ApellidoPaternoPropietario;
    private String ApellidoMaternoPropietario;    //15
    private String NombrePropietario;
    private String ApellidopPaternoConyugue;
    private String ApellidoMaternoConyugue;
    private String NombreConyugue;
    private String CorreoElectronico;//20
    private int IdTipoPropiedad;
    private int CantidadHabitantesPredio;
    private int NumeroPisos;
    private int IdTipoPredio;
    private int IdVia;//25
    private String NumeroMunicipal;
    private int IdHabilitacion;
    private String NumeroManzana;
    private String NumeroLote;
    private String Block;
    private int Piso;
    private int Numero;
    private int IdUsoPredio;
    private String Complemento;
    private int SiNoPredioHabilitado;
    private int IdTipoServicio;
    private int IdMedioAbastecimiento;
    private int IdSituacionPredio;
    private int IdTipoAlmacenamiento;

    public CECliente() {
    }

    public CECliente(int IdCliente, int IdSituacionConexion, String AntiguoCodigoCatastral, String NuevoCodigoCatastral, String NumeroInscripcion, String RutaLectura, String RutaReparto, String Secuencia, String Categoria, String NumMunicipal, int IdTipoDocumento, String NumeroDocumento, String Telefono, String ApellidoPaternoPropietario, String ApellidoMaternoPropietario, String NombrePropietario, String ApellidopPaternoConyugue, String ApellidoMaternoConyugue, String NombreConyugue, String CorreoElectronico, int IdTipoPropiedad, int CantidadHabitantesPredio, int NumeroPisos, int IdTipoPredio, int IdVia, String NumeroMunicipal, int IdHabilitacion, String NumeroManzana, String NumeroLote, String Block, int Piso, int Numero, int IdUsoPredio, String Complemento, int SiNoPredioHabilitado, int IdTipoServicio, int IdMedioAbastecimiento, int IdSituacionPredio, int IdTipoAlmacenamiento) {
        this.IdCliente = IdCliente;
        this.IdSituacionConexion = IdSituacionConexion;
        this.AntiguoCodigoCatastral = AntiguoCodigoCatastral;
        this.NuevoCodigoCatastral = NuevoCodigoCatastral;
        this.NumeroInscripcion = NumeroInscripcion;
        this.RutaLectura = RutaLectura;
        this.RutaReparto = RutaReparto;
        this.Secuencia = Secuencia;
        this.Categoria = Categoria;
        this.NumMunicipal = NumMunicipal;
        this.IdTipoDocumento = IdTipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.Telefono = Telefono;
        this.ApellidoPaternoPropietario = ApellidoPaternoPropietario;
        this.ApellidoMaternoPropietario = ApellidoMaternoPropietario;
        this.NombrePropietario = NombrePropietario;
        this.ApellidopPaternoConyugue = ApellidopPaternoConyugue;
        this.ApellidoMaternoConyugue = ApellidoMaternoConyugue;
        this.NombreConyugue = NombreConyugue;
        this.CorreoElectronico = CorreoElectronico;
        this.IdTipoPropiedad = IdTipoPropiedad;
        this.CantidadHabitantesPredio = CantidadHabitantesPredio;
        this.NumeroPisos = NumeroPisos;
        this.IdTipoPredio = IdTipoPredio;
        this.IdVia = IdVia;
        this.NumeroMunicipal = NumeroMunicipal;
        this.IdHabilitacion = IdHabilitacion;
        this.NumeroManzana = NumeroManzana;
        this.NumeroLote = NumeroLote;
        this.Block = Block;
        this.Piso = Piso;
        this.Numero = Numero;
        this.IdUsoPredio = IdUsoPredio;
        this.Complemento = Complemento;
        this.SiNoPredioHabilitado = SiNoPredioHabilitado;
        this.IdTipoServicio = IdTipoServicio;
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
        this.IdSituacionPredio = IdSituacionPredio;
        this.IdTipoAlmacenamiento = IdTipoAlmacenamiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    
    public String getAntiguoCodigoCatastral() {
        return AntiguoCodigoCatastral;
    }

    public void setAntiguoCodigoCatastral(String AntiguoCodigoCatastral) {
        this.AntiguoCodigoCatastral = AntiguoCodigoCatastral;
    }

    public String getApellidoMaternoConyugue() {
        return ApellidoMaternoConyugue;
    }

    public void setApellidoMaternoConyugue(String ApellidoMaternoConyugue) {
        this.ApellidoMaternoConyugue = ApellidoMaternoConyugue;
    }

    public String getApellidoMaternoPropietario() {
        return ApellidoMaternoPropietario;
    }

    public void setApellidoMaternoPropietario(String ApellidoMaternoPropietario) {
        this.ApellidoMaternoPropietario = ApellidoMaternoPropietario;
    }

    public String getApellidoPaternoPropietario() {
        return ApellidoPaternoPropietario;
    }

    public void setApellidoPaternoPropietario(String ApellidoPaternoPropietario) {
        this.ApellidoPaternoPropietario = ApellidoPaternoPropietario;
    }

    public String getApellidopPaternoConyugue() {
        return ApellidopPaternoConyugue;
    }

    public void setApellidopPaternoConyugue(String ApellidopPaternoConyugue) {
        this.ApellidopPaternoConyugue = ApellidopPaternoConyugue;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String Block) {
        this.Block = Block;
    }

    public int getCantidadHabitantesPredio() {
        return CantidadHabitantesPredio;
    }

    public void setCantidadHabitantesPredio(int CantidadHabitantesPredio) {
        this.CantidadHabitantesPredio = CantidadHabitantesPredio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdHabilitacion() {
        return IdHabilitacion;
    }

    public void setIdHabilitacion(int IdHabilitacion) {
        this.IdHabilitacion = IdHabilitacion;
    }

    public int getIdMedioAbastecimiento() {
        return IdMedioAbastecimiento;
    }

    public void setIdMedioAbastecimiento(int IdMedioAbastecimiento) {
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
    }

    public int getIdSituacionConexion() {
        return IdSituacionConexion;
    }

    public void setIdSituacionConexion(int IdSituacionConexion) {
        this.IdSituacionConexion = IdSituacionConexion;
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

    public int getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    public void setIdTipoDocumento(int IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
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

    public int getIdTipoServicio() {
        return IdTipoServicio;
    }

    public void setIdTipoServicio(int IdTipoServicio) {
        this.IdTipoServicio = IdTipoServicio;
    }

    public int getIdUsoPredio() {
        return IdUsoPredio;
    }

    public void setIdUsoPredio(int IdUsoPredio) {
        this.IdUsoPredio = IdUsoPredio;
    }

    public int getIdVia() {
        return IdVia;
    }

    public void setIdVia(int IdVia) {
        this.IdVia = IdVia;
    }

    public String getNombreConyugue() {
        return NombreConyugue;
    }

    public void setNombreConyugue(String NombreConyugue) {
        this.NombreConyugue = NombreConyugue;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String NombrePropietario) {
        this.NombrePropietario = NombrePropietario;
    }

    public String getNuevoCodigoCatastral() {
        return NuevoCodigoCatastral;
    }

    public void setNuevoCodigoCatastral(String NuevoCodigoCatastral) {
        this.NuevoCodigoCatastral = NuevoCodigoCatastral;
    }

    public String getNumMunicipal() {
        return NumMunicipal;
    }

    public void setNumMunicipal(String NumMunicipal) {
        this.NumMunicipal = NumMunicipal;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public String getNumeroInscripcion() {
        return NumeroInscripcion;
    }

    public void setNumeroInscripcion(String NumeroInscripcion) {
        this.NumeroInscripcion = NumeroInscripcion;
    }

    public String getNumeroLote() {
        return NumeroLote;
    }

    public void setNumeroLote(String NumeroLote) {
        this.NumeroLote = NumeroLote;
    }

    public String getNumeroManzana() {
        return NumeroManzana;
    }

    public void setNumeroManzana(String NumeroManzana) {
        this.NumeroManzana = NumeroManzana;
    }

    public String getNumeroMunicipal() {
        return NumeroMunicipal;
    }

    public void setNumeroMunicipal(String NumeroMunicipal) {
        this.NumeroMunicipal = NumeroMunicipal;
    }

    public int getNumeroPisos() {
        return NumeroPisos;
    }

    public void setNumeroPisos(int NumeroPisos) {
        this.NumeroPisos = NumeroPisos;
    }

    public int getPiso() {
        return Piso;
    }

    public void setPiso(int Piso) {
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

    public int getSiNoPredioHabilitado() {
        return SiNoPredioHabilitado;
    }

    public void setSiNoPredioHabilitado(int SiNoPredioHabilitado) {
        this.SiNoPredioHabilitado = SiNoPredioHabilitado;
    }

    /**
     * @return the Via
     */
    public String getVia() {
        return Via;
    }

    /**
     * @param Via the Via to set
     */
    public void setVia(String Via) {
        this.Via = Via;
    }

    /**
     * @return the IdCondicionConexionAgua
     */
    public int getIdCondicionConexionAgua() {
        return IdCondicionConexionAgua;
    }

    /**
     * @param IdCondicionConexionAgua the IdCondicionConexionAgua to set
     */
    public void setIdCondicionConexionAgua(int IdCondicionConexionAgua) {
        this.IdCondicionConexionAgua = IdCondicionConexionAgua;
    }
    
    
}
