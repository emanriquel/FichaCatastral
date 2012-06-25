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
    private int IdCondicionConexionAgua;
    private String AntiguoCodigoCatastral;
    private String NuevoCodigoCatastral;
    private String NumeroInscripcion;//5
    private String RutaLectura;
    private String RutaReparto;    
    private String Secuencia;
    private String Categoria;
    private String Direccion;
    private int IdTipoDocumento;
    private String NumeroDocumento;
    private String Telefono;
    private String ApellidoPaternoPropietario;
    private String CorreoElectronico;
    private int IdMedioAbastecimiento;

    public CECliente() {
    }

    public CECliente(int IdCliente, int IdCondicionConexionAgua, String AntiguoCodigoCatastral, String NuevoCodigoCatastral, String NumeroInscripcion, String RutaLectura, String RutaReparto, String Secuencia, String Categoria, String Direccion, int IdTipoDocumento, String NumeroDocumento, String Telefono, String ApellidoPaternoPropietario, String CorreoElectronico, int IdMedioAbastecimiento) {
        this.IdCliente = IdCliente;
        this.IdCondicionConexionAgua = IdCondicionConexionAgua;
        this.AntiguoCodigoCatastral = AntiguoCodigoCatastral;
        this.NuevoCodigoCatastral = NuevoCodigoCatastral;
        this.NumeroInscripcion = NumeroInscripcion;
        this.RutaLectura = RutaLectura;
        this.RutaReparto = RutaReparto;
        this.Secuencia = Secuencia;
        this.Categoria = Categoria;
        this.Direccion = Direccion;
        this.IdTipoDocumento = IdTipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.Telefono = Telefono;
        this.ApellidoPaternoPropietario = ApellidoPaternoPropietario;
        this.CorreoElectronico = CorreoElectronico;
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
    }

    

    public String getAntiguoCodigoCatastral() {
        return AntiguoCodigoCatastral;
    }

    public void setAntiguoCodigoCatastral(String AntiguoCodigoCatastral) {
        this.AntiguoCodigoCatastral = AntiguoCodigoCatastral;
    }

    public String getApellidoPaternoPropietario() {
        return ApellidoPaternoPropietario;
    }

    public void setApellidoPaternoPropietario(String ApellidoPaternoPropietario) {
        this.ApellidoPaternoPropietario = ApellidoPaternoPropietario;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdMedioAbastecimiento() {
        return IdMedioAbastecimiento;
    }

    public void setIdMedioAbastecimiento(int IdMedioAbastecimiento) {
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
    }


    public int getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    public void setIdTipoDocumento(int IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
    }

    public String getNuevoCodigoCatastral() {
        return NuevoCodigoCatastral;
    }

    public void setNuevoCodigoCatastral(String NuevoCodigoCatastral) {
        this.NuevoCodigoCatastral = NuevoCodigoCatastral;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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
