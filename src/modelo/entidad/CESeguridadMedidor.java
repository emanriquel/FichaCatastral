package modelo.entidad;

public class CESeguridadMedidor {
    private int IdSeguridadMedidor;
    private String SeguridadMedidor;
    private int Codigo;
    public int getIdSeguridadMedidor() {
        return IdSeguridadMedidor;
    }

    public void setIdSeguridadMedidor(int IdSeguridadMedidor) {
        this.IdSeguridadMedidor = IdSeguridadMedidor;
    }

    /**
     * @return the SeguridadMedidor
     */
    public String getSeguridadMedidor() {
        return SeguridadMedidor;
    }

    /**
     * @param SeguridadMedidor the SeguridadMedidor to set
     */
    public void setSeguridadMedidor(String SeguridadMedidor) {
        this.SeguridadMedidor = SeguridadMedidor;
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
       return this.SeguridadMedidor;
    }

}
