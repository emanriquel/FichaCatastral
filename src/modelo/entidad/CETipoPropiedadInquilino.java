package modelo.entidad;

public class CETipoPropiedadInquilino {
    private int IdTipoPropiedadInquilino;
    private String TipoPropiedadInquilino;
    private int Codigo;
    /**
     * @return the IdTipoPropiedadInquilino
     */
    public int getIdTipoPropiedadInquilino() {
        return IdTipoPropiedadInquilino;
    }

    /**
     * @param IdTipoPropiedadInquilino the IdTipoPropiedadInquilino to set
     */
    public void setIdTipoPropiedadInquilino(int IdTipoPropiedadInquilino) {
        this.IdTipoPropiedadInquilino = IdTipoPropiedadInquilino;
    }

    /**
     * @return the TipoPropiedadInquilino
     */
    public String getTipoPropiedadInquilino() {
        return TipoPropiedadInquilino;
    }

    /**
     * @param TipoPropiedadInquilino the TipoPropiedadInquilino to set
     */
    public void setTipoPropiedadInquilino(String TipoPropiedadInquilino) {
        this.TipoPropiedadInquilino = TipoPropiedadInquilino;
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
       return this.TipoPropiedadInquilino;
    }
}
