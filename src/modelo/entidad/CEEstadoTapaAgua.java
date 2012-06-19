package modelo.entidad;

public class CEEstadoTapaAgua
{
    private int IdEstadoTapaAgua;
    private String EstadoTapaAgua;
    private int Codigo;
    /**
     * @return the IdEstadaTapaAgua
     */
 
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

    /**
     * @return the IdEstadoTapaAgua
     */
    public int getIdEstadoTapaAgua() {
        return IdEstadoTapaAgua;
    }

    /**
     * @param IdEstadoTapaAgua the IdEstadoTapaAgua to set
     */
    public void setIdEstadoTapaAgua(int IdEstadoTapaAgua) {
        this.IdEstadoTapaAgua = IdEstadoTapaAgua;
    }

    /**
     * @return the EstadoTapaAgua
     */
    public String getEstadoTapaAgua() {
        return EstadoTapaAgua;
    }

    /**
     * @param EstadoTapaAgua the EstadoTapaAgua to set
     */
    public void setEstadoTapaAgua(String EstadoTapaAgua) {
        this.EstadoTapaAgua = EstadoTapaAgua;
    }
     @Override
    public String toString(){
       return this.EstadoTapaAgua;
    }
}
