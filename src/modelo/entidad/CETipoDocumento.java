package modelo.entidad;

public class CETipoDocumento {
    private int IdTipoDocumento;
    private String TipoDocumento;
    private int Codigo;
    /**
     * @return the IdTipoDocumento
     */
    public int getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    /**
     * @param IdTipoDocumento the IdTipoDocumento to set
     */
    public void setIdTipoDocumento(int IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
    }

    /**
     * @return the TipoDocumento
     */
    public String getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     * @param TipoDocumento the TipoDocumento to set
     */
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
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
       return this.TipoDocumento;
    }

}
