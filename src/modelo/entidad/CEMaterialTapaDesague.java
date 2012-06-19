package modelo.entidad;


public class CEMaterialTapaDesague
{
    private int IdMaterialTapaDesague;
    private String MaterialTapaDesague;
    private int Codigo;
    /**
     * @return the IdMaterialTapaDesague
     */
    public int getIdMaterialTapaDesague() {
        return IdMaterialTapaDesague;
    }

    /**
     * @param IdMaterialTapaDesague the IdMaterialTapaDesague to set
     */
    public void setIdMaterialTapaDesague(int IdMaterialTapaDesague) {
        this.IdMaterialTapaDesague = IdMaterialTapaDesague;
    }

    /**
     * @return the MaterialTapaDesague
     */
    public String getMaterialTapaDesague() {
        return MaterialTapaDesague;
    }

    /**
     * @param MaterialTapaDesague the MaterialTapaDesague to set
     */
    public void setMaterialTapaDesague(String MaterialTapaDesague) {
        this.MaterialTapaDesague = MaterialTapaDesague;
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
       return this.MaterialTapaDesague;
    }
}
