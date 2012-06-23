/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

/**
 *
 * @author Edwar
 */
public class CEHabilitacion {
    private int IdHabilitacion;
    private int Codigo;
    private String Tipo;
    private String NombreHabilitacion;

    public CEHabilitacion() {
    }

    public CEHabilitacion(int IdHabitacion, int Codigo, String Tipo, String NombreHabitacion) {
        this.IdHabilitacion = IdHabitacion;
        this.Codigo = Codigo;
        this.Tipo = Tipo;
        this.NombreHabilitacion = NombreHabitacion;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getIdHabitacion() {
        return IdHabilitacion;
    }

    public void setIdHabilitacion(int IdHabitacion) {
        this.IdHabilitacion = IdHabitacion;
    }

    public String getNombreHabilitacion() {
        return NombreHabilitacion;
    }

    public void setNombreHabilitacion(String NombreHabitacion) {
        this.NombreHabilitacion = NombreHabitacion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
