package modelo.entidad;

public class CEPozoArtesanal
{
    private int IdPozoArtesanal;
    private String PozoArtesanal;
    private int Codigo;

    public int getIdPozoArtesanal() {
        return IdPozoArtesanal;
    }

    public void setIdPozoArtesanal(int IdPozoArtesanal) {
        this.IdPozoArtesanal = IdPozoArtesanal;
    }

    public String getPozoArtesanal() {
        return PozoArtesanal;
    }

    public void setPozoArtesanal(String PozoArtesanal) {
        this.PozoArtesanal = PozoArtesanal;
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
       return this.PozoArtesanal;
    }
}
