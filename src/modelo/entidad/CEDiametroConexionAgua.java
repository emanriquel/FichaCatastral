package modelo.entidad;

public class CEDiametroConexionAgua {
    private int IdDiametroConexionAgua;
    private String DiametroConexionAgua;
    private int Codigo;

    /**
     * @return the IdDiametroConexionAgua
     */
    public int getIdDiametroConexionAgua() {
        return IdDiametroConexionAgua;
    }

    /**
     * @param IdDiametroConexionAgua the IdDiametroConexionAgua to set
     */
    public void setIdDiametroConexionAgua(int IdDiametroConexionAgua) {
        this.IdDiametroConexionAgua = IdDiametroConexionAgua;
    }

    /**
     * @return the DiametroConexionAgua
     */
    public String getDiametroConexionAgua() {
        return DiametroConexionAgua;
    }

    /**
     * @param DiametroConexionAgua the DiametroConexionAgua to set
     */
    public void setDiametroConexionAgua(String DiametroConexionAgua) {
        this.DiametroConexionAgua = DiametroConexionAgua;
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
       return this.DiametroConexionAgua;
    }

}
