package modelo.entidad;

public class CEUbiCajaConexAgua {
    private int IdUbiCajaConexAgua;
    private String UbiCajaConexAgua;
    private int Codigo;
    /**
     * @return the IdUbiCajaConexAgua
     */
    public int getIdUbiCajaConexAgua() {
        return IdUbiCajaConexAgua;
    }

    /**
     * @param IdUbiCajaConexAgua the IdUbiCajaConexAgua to set
     */
    public void setIdUbiCajaConexAgua(int IdUbiCajaConexAgua) {
        this.IdUbiCajaConexAgua = IdUbiCajaConexAgua;
    }

    /**
     * @return the UbiCajaConexAgua
     */
    public String getUbiCajaConexAgua() {
        return UbiCajaConexAgua;
    }

    /**
     * @param UbiCajaConexAgua the UbiCajaConexAgua to set
     */
    public void setUbiCajaConexAgua(String UbiCajaConexAgua) {
        this.UbiCajaConexAgua = UbiCajaConexAgua;
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
       return this.UbiCajaConexAgua;
    }
}
