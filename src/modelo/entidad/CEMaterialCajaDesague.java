package modelo.entidad;

public class CEMaterialCajaDesague
{
    
    private int IdMaterialCajaDesague;
    private String MaterialCajaDesague;
    private int Codigo;
    public int getIdMaterialCajaDesague() {
        return IdMaterialCajaDesague;
    }

    public void setIdMaterialCajaDesague(int IdMaterialCajaDesague) {
        this.IdMaterialCajaDesague = IdMaterialCajaDesague;
    }

    public String getMaterialCajaDesague() {
        return MaterialCajaDesague;
    }

    public void setMaterialCajaDesague(String MaterialCajaDesague) {
        this.MaterialCajaDesague = MaterialCajaDesague;
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
       return this.MaterialCajaDesague;
    }

}
