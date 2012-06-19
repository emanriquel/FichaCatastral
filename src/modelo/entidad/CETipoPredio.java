package modelo.entidad;


public class CETipoPredio {
    private int IdTipoPredio;
    private String TipoPredio;
    private int Codigo;
    /**
     * @return the IdTipoPredio
     */
    public int getIdTipoPredio() {
        return IdTipoPredio;
    }

    /**
     * @param IdTipoPredio the IdTipoPredio to set
     */
    public void setIdTipoPredio(int IdTipoPredio) {
        this.IdTipoPredio = IdTipoPredio;
    }

    /**
     * @return the TipoPredio
     */
    public String getTipoPredio() {
        return TipoPredio;
    }

    /**
     * @param TipoPredio the TipoPredio to set
     */
    public void setTipoPredio(String TipoPredio) {
        this.TipoPredio = TipoPredio;
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
       return this.TipoPredio;
    }
}
