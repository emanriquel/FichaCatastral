package modelo.entidad;

public class CETipoServicio {
    private int IdTipoServicio;
    private String TipoServicio;
    private int Codigo;
    /**
     * @return the IdTipoServicio
     */
    public int getIdTipoServicio() {
        return IdTipoServicio;
    }

    /**
     * @param IdTipoServicio the IdTipoServicio to set
     */
    public void setIdTipoServicio(int IdTipoServicio) {
        this.IdTipoServicio = IdTipoServicio;
    }

    /**
     * @return the TipoServicio
     */
    public String getTipoServicio() {
        return TipoServicio;
    }

    /**
     * @param TipoServicio the TipoServicio to set
     */
    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
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
       return this.TipoServicio;
    }
}
