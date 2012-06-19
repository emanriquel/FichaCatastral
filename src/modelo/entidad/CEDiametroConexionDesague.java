package modelo.entidad;

public class CEDiametroConexionDesague {
    private int IdDiametroConexionDesague;
    private String DiametroConexionDesague;
    private int Codigo;
    /**
     * @return the IdDiametroConexionDesague
     */
    public int getIdDiametroConexionDesague() {
        return IdDiametroConexionDesague;
    }

    /**
     * @param IdDiametroConexionDesague the IdDiametroConexionDesague to set
     */
    public void setIdDiametroConexionDesague(int IdDiametroConexionDesague) {
        this.IdDiametroConexionDesague = IdDiametroConexionDesague;
    }

    /**
     * @return the DiametroConexionDesague
     */
    public String getDiametroConexionDesague() {
        return DiametroConexionDesague;
    }

    /**
     * @param DiametroConexionDesague the DiametroConexionDesague to set
     */
    public void setDiametroConexionDesague(String DiametroConexionDesague) {
        this.DiametroConexionDesague = DiametroConexionDesague;
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
       return this.DiametroConexionDesague;
    }
}
