package modelo.entidad;

public class CEEstadoCajaAgua {
    
    private int IdEstadoCajaAgua;
    private String EstadoCajaAgua;
    private int Codigo;
 

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
     * @return the IdEstadoCajaAgua
     */
    public int getIdEstadoCajaAgua() {
        return IdEstadoCajaAgua;
    }

    /**
     * @param IdEstadoCajaAgua the IdEstadoCajaAgua to set
     */
    public void setIdEstadoCajaAgua(int IdEstadoCajaAgua) {
        this.IdEstadoCajaAgua = IdEstadoCajaAgua;
    }

    /**
     * @return the EstadoCajaAgua
     */
    public String getEstadoCajaAgua() {
        return EstadoCajaAgua;
    }

    /**
     * @param EstadoCajaAgua the EstadoCajaAgua to set
     */
    public void setEstadoCajaAgua(String EstadoCajaAgua) {
        this.EstadoCajaAgua = EstadoCajaAgua;
    }
    @Override
    public String toString(){
       return this.EstadoCajaAgua;
    }
}
