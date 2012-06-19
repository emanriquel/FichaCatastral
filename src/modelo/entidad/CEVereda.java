package modelo.entidad;


public class CEVereda
{
    private int IdVereda;
    private String Vereda;
    private int Codigo;
    /**
     * @return the IdVereda
     */
    public int getIdVereda() {
        return IdVereda;
    }

    /**
     * @param IdVereda the IdVereda to set
     */
    public void setIdVereda(int IdVereda) {
        this.IdVereda = IdVereda;
    }

    /**
     * @return the Vereda
     */
    public String getVereda() {
        return Vereda;
    }

    /**
     * @param Vereda the Vereda to set
     */
    public void setVereda(String Vereda) {
        this.Vereda = Vereda;
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
       return this.Vereda;
    }
}
