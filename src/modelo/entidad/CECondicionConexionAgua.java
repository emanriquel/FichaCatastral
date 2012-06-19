package modelo.entidad;

public class CECondicionConexionAgua {
    private int IdCondicionConexionAgua;
    private String CondicionConexionAgua;
    private int Codigo;
    public int getIdCondicionConexionAgua() {
        return IdCondicionConexionAgua;
    }

    public void setIdCondicionConexionAgua(int IdCondicionConexionAgua) {
        this.IdCondicionConexionAgua = IdCondicionConexionAgua;
    }

    public String getCondicionConexionAgua() {
        return CondicionConexionAgua;
    }

    public void setCondicionConexionAgua(String CondicionConexionAgua) {
        this.CondicionConexionAgua = CondicionConexionAgua;
    }
    @Override
    public String toString(){
       return this.CondicionConexionAgua;
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


}
