/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

/**
 *
 * @author Edwar
 */
public class CEVia {
    private int IdVia;
    private int Codigo;
    private String Tipo;
    private String NombreVia;

    public CEVia() {
    }

    public CEVia(int IdVia, int Codigo, String Tipo, String NombreVia) {
        this.IdVia = IdVia;
        this.Codigo = Codigo;
        this.Tipo = Tipo;
        this.NombreVia = NombreVia;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getIdVia() {
        return IdVia;
    }

    public void setIdVia(int IdVia) {
        this.IdVia = IdVia;
    }

    public String getNombreVia() {
        return NombreVia;
    }

    public void setNombreVia(String NombreVia) {
        this.NombreVia = NombreVia;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
}
