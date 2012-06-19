package modelo.entidad;

public class CELlavesPaso
{
    private int IdLlavesPaso;
    private String LlavesPaso;
    private int Codigo;
    /**
     * @return the IdLlavesPaso
     */
    public int getIdLlavesPaso() {
        return IdLlavesPaso;
    }

    /**
     * @param IdLlavesPaso the IdLlavesPaso to set
     */
    public void setIdLlavesPaso(int IdLlavesPaso) {
        this.IdLlavesPaso = IdLlavesPaso;
    }

    /**
     * @return the LlavesPaso
     */
    public String getLlavesPaso() {
        return LlavesPaso;
    }

    /**
     * @param LlavesPaso the LlavesPaso to set
     */
    public void setLlavesPaso(String LlavesPaso) {
        this.LlavesPaso = LlavesPaso;
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
       return this.LlavesPaso;
    }
}
