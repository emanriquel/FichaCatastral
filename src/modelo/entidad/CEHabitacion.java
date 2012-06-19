/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

/**
 *
 * @author Edwar
 */
public class CEHabitacion {
    private int IdHabitacion;
    private int Codigo;
    private String Tipo;
    private String NombreHabitacion;

    public CEHabitacion() {
    }

    public CEHabitacion(int IdHabitacion, int Codigo, String Tipo, String NombreHabitacion) {
        this.IdHabitacion = IdHabitacion;
        this.Codigo = Codigo;
        this.Tipo = Tipo;
        this.NombreHabitacion = NombreHabitacion;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int IdHabitacion) {
        this.IdHabitacion = IdHabitacion;
    }

    public String getNombreHabitacion() {
        return NombreHabitacion;
    }

    public void setNombreHabitacion(String NombreHabitacion) {
        this.NombreHabitacion = NombreHabitacion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
