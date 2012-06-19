package modelo.entidad;

public class CEEstadoTapaDesague
{
    private int IdEstadoTapaDesague;
    private String EstadoTapaDesague;
    private int Codigo;
    /**
     * @return the IdEstadoTapaDesague
     */
    public int getIdEstadoTapaDesague() {
        return IdEstadoTapaDesague;
    }

    /**
     * @param IdEstadoTapaDesague the IdEstadoTapaDesague to set
     */
    public void setIdEstadoTapaDesague(int IdEstadoTapaDesague) {
        this.IdEstadoTapaDesague = IdEstadoTapaDesague;
    }

    /**
     * @return the EstadoTapaDesague
     */
    public String getEstadoTapaDesague() {
        return EstadoTapaDesague;
    }

    /**
     * @param EstadoTapaDesague the EstadoTapaDesague to set
     */
    public void setEstadoTapaDesague(String EstadoTapaDesague) {
        this.EstadoTapaDesague = EstadoTapaDesague;
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
       return this.EstadoTapaDesague;
    }
}
