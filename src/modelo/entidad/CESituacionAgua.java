package modelo.entidad;


public class CESituacionAgua {
 private int IdSituacionAgua;
 private String SituacionAgua;
 private int Codigo;
    /**
     * @return the IdSituacionAgua
     */
    public int getIdSituacionAgua() {
        return IdSituacionAgua;
    }

    /**
     * @param IdSituacionAgua the IdSituacionAgua to set
     */
    public void setIdSituacionAgua(int IdSituacionAgua) {
        this.IdSituacionAgua = IdSituacionAgua;
    }

    /**
     * @return the SituacionAgua
     */
    public String getSituacionAgua() {
        return SituacionAgua;
    }

    /**
     * @param SituacionAgua the SituacionAgua to set
     */
    public void setSituacionAgua(String SituacionAgua) {
        this.SituacionAgua = SituacionAgua;
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
       return this.SituacionAgua;
    }
 
}
