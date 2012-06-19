package modelo.entidad;

public class CETipoAlmacenamiento {
    private int IdTipoAlmacenamiento;
    private String TipoAlmacenamiento;
    private int Codigo;
    /**
     * @return the IdTipoAlmacenamiento
     */
    public int getIdTipoAlmacenamiento() {
        return IdTipoAlmacenamiento;
    }

    /**
     * @param IdTipoAlmacenamiento the IdTipoAlmacenamiento to set
     */
    public void setIdTipoAlmacenamiento(int IdTipoAlmacenamiento) {
        this.IdTipoAlmacenamiento = IdTipoAlmacenamiento;
    }

    /**
     * @return the TipoAlmacenamiento
     */
    public String getTipoAlmacenamiento() {
        return TipoAlmacenamiento;
    }

    /**
     * @param TipoAlmacenamiento the TipoAlmacenamiento to set
     */
    public void setTipoAlmacenamiento(String TipoAlmacenamiento) {
        this.TipoAlmacenamiento = TipoAlmacenamiento;
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
       return this.TipoAlmacenamiento;
    }

}
