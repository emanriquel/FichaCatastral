package modelo.entidad;

public class CEMedioAbastecimiento
{
    private int IdMedioAbastecimiento;
    private String MedioAbastecimiento;
    private int Codigo;
    /**
     * @return the IdMedioAbastecimiento
     */
    public int getIdMedioAbastecimiento() {
        return IdMedioAbastecimiento;
    }

    /**
     * @param IdMedioAbastecimiento the IdMedioAbastecimiento to set
     */
    public void setIdMedioAbastecimiento(int IdMedioAbastecimiento) {
        this.IdMedioAbastecimiento = IdMedioAbastecimiento;
    }

    /**
     * @return the MedioAbastecimiento
     */
    public String getMedioAbastecimiento() {
        return MedioAbastecimiento;
    }

    /**
     * @param MedioAbastecimiento the MedioAbastecimiento to set
     */
    public void setMedioAbastecimiento(String MedioAbastecimiento) {
        this.MedioAbastecimiento = MedioAbastecimiento;
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
       return this.MedioAbastecimiento;
    }
}
