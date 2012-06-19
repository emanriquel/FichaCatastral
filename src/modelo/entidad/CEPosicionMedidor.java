package modelo.entidad;

public class CEPosicionMedidor
{
    private int IdPosicionMedidor;
    private String PosicionMedidor;
    private int Codigo;
  
    public int getIdPosicionMedidor() {
        return IdPosicionMedidor;
    }

    public void setIdPosicionMedidor(int IdPosicionMedidor) {
        this.IdPosicionMedidor = IdPosicionMedidor;
    }

    public String getPosicionMedidor() {
        return PosicionMedidor;
    }

    public void setPosicionMedidor(String PosicionMedidor) {
        this.PosicionMedidor = PosicionMedidor;
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
       return this.PosicionMedidor;
    }
}
