package modelo.entidad;

public class CESituacionConexion
{
    private int IdSituacionConexion;
    private String SituacionConexion;
    private int Codigo;

    /**
     * @return the IdSituacionConexion
     */
    public int getIdSituacionConexion() {
        return IdSituacionConexion;
    }

    /**
     * @param IdSituacionConexion the IdSituacionConexion to set
     */
    public void setIdSituacionConexion(int IdSituacionConexion) {
        this.IdSituacionConexion = IdSituacionConexion;
    }

    /**
     * @return the SituacionConexion
     */
    public String getSituacionConexion() {
        return SituacionConexion;
    }

    /**
     * @param SituacionConexion the SituacionConexion to set
     */
    public void setSituacionConexion(String SituacionConexion) {
        this.SituacionConexion = SituacionConexion;
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
       return this.SituacionConexion;
    }
}
