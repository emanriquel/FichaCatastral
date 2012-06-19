package modelo.entidad;

public class CEEstadoMedidor
{
    private int IdEstadoMedidor;
    private String EstadoMedidor;
    private int Codigo;
    public int getIdEstadoMedidor() {
        return IdEstadoMedidor;
    }

    public void setIdEstadoMedidor(int IdEstadoMedidor) {
        this.IdEstadoMedidor = IdEstadoMedidor;
    }

    public String getEstadoMedidor() {
        return EstadoMedidor;
    }

    public void setEstadoMedidor(String EstadoMedidor) {
        this.EstadoMedidor = EstadoMedidor;
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
       return this.EstadoMedidor;
    }
}
