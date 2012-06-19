package modelo.entidad;

public class CEPavimentacion {
    private int IdPavimentacion;
    private String Pavimentacion;
    private int Codigo;
    /**
     * @return the IdPavimentacion
     */
    public int getIdPavimentacion() {
        return IdPavimentacion;
    }

    /**
     * @param IdPavimentacion the IdPavimentacion to set
     */
    public void setIdPavimentacion(int IdPavimentacion) {
        this.IdPavimentacion = IdPavimentacion;
    }

    /**
     * @return the Pavimentacion
     */
    public String getPavimentacion() {
        return Pavimentacion;
    }

    /**
     * @param Pavimentacion the Pavimentacion to set
     */
    public void setPavimentacion(String Pavimentacion) {
        this.Pavimentacion = Pavimentacion;
    }

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
     @Override
    public String toString(){
       return this.Pavimentacion;
    }

}
