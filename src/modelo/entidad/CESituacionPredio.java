package modelo.entidad;


public class CESituacionPredio {
    private int IdSituacionPredio;
    private String SituacionPredio;
    private int Codigo;
    /**
     * @return the IdSituacionPredio
     */
    public int getIdSituacionPredio() {
        return IdSituacionPredio;
    }

    /**
     * @param IdSituacionPredio the IdSituacionPredio to set
     */
    public void setIdSituacionPredio(int IdSituacionPredio) {
        this.IdSituacionPredio = IdSituacionPredio;
    }

    /**
     * @return the SituacionPredio
     */
    public String getSituacionPredio() {
        return SituacionPredio;
    }

    /**
     * @param SituacionPredio the SituacionPredio to set
     */
    public void setSituacionPredio(String SituacionPredio) {
        this.SituacionPredio = SituacionPredio;
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
       return this.SituacionPredio;
    }

}
