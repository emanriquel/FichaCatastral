package modelo.entidad;

public class CEEstadoCajaDesague
{
    private int IdEstadoCajaDesague;
    private String EstadoCajaDesague;
    private int Codigo;
    /**
     * @return the IdEstadoCajaDesague
     */
    public int getIdEstadoCajaDesague() {
        return IdEstadoCajaDesague;
    }

    /**
     * @param IdEstadoCajaDesague the IdEstadoCajaDesague to set
     */
    public void setIdEstadoCajaDesague(int IdEstadoCajaDesague) {
        this.IdEstadoCajaDesague = IdEstadoCajaDesague;
    }

    /**
     * @return the EstadoCajaDesague
     */
    public String getEstadoCajaDesague() {
        return EstadoCajaDesague;
    }

    /**
     * @param EstadoCajaDesague the EstadoCajaDesague to set
     */
    public void setEstadoCajaDesague(String EstadoCajaDesague) {
        this.EstadoCajaDesague = EstadoCajaDesague;
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
       return this.EstadoCajaDesague;
    }
    

}
