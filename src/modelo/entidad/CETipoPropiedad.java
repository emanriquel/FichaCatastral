package modelo.entidad;

public class CETipoPropiedad {
    private int IdTipoPropiedad;
    private String TipoPropiedad;
    private int Codigo;
    /**
     * @return the IdTipoPropiedad
     */
    public int getIdTipoPropiedad() {
        return IdTipoPropiedad;
    }

    /**
     * @param IdTipoPropiedad the IdTipoPropiedad to set
     */
    public void setIdTipoPropiedad(int IdTipoPropiedad) {
        this.IdTipoPropiedad = IdTipoPropiedad;
    }

    /**
     * @return the TipoPropiedad
     */
    public String getTipoPropiedad() {
        return TipoPropiedad;
    }

    /**
     * @param TipoPropiedad the TipoPropiedad to set
     */
    public void setTipoPropiedad(String TipoPropiedad) {
        this.TipoPropiedad = TipoPropiedad;
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
       return this.TipoPropiedad;
    }
}
