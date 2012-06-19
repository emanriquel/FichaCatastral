package modelo.entidad;


public class CEDiametroMedidor {
 private int IdDiametroMedidor;
 private String DiametroMedidor;
private int Codigo;
   
    public int getIdDiametroMedidor() {
        return IdDiametroMedidor;
    }

    public void setIdDiametroMedidor(int IdDiametroMedidor) {
        this.IdDiametroMedidor = IdDiametroMedidor;
    }

    public String getDiametroMedidor() {
        return DiametroMedidor;
    }

    public void setDiametroMedidor(String DiametroMedidor) {
        this.DiametroMedidor = DiametroMedidor;
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
       return this.DiametroMedidor;
    }
}
