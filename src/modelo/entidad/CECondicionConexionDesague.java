package modelo.entidad;

public class CECondicionConexionDesague {
    private int IdCondicionConexionDesague;
    private String CondicionConexionDesague;
    private int Codigo;
    public int getIdCondicionConexionDesague() {
        return IdCondicionConexionDesague;
    }

    public void setIdCondicionConexionDesague(int IdCondicionConexionDesague) {
        this.IdCondicionConexionDesague = IdCondicionConexionDesague;
    }

    public String getCondicionConexionDesague() {
        return CondicionConexionDesague;
    }

    public void setCondicionConexionDesague(String CondicionConexionDesague) {
        this.CondicionConexionDesague = CondicionConexionDesague;
    }
@Override
    public String toString(){
       return this.CondicionConexionDesague;
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
