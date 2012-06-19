package modelo.entidad;

public class CEMaterialCajaAgua
{
    private int IdMaterialCajaAgua;
    private String MaterialCajaAgua;
    private int Codigo;

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

    /**
     * @return the IdMaterialCajaAgua
     */
    public int getIdMaterialCajaAgua() {
        return IdMaterialCajaAgua;
    }

    /**
     * @param IdMaterialCajaAgua the IdMaterialCajaAgua to set
     */
    public void setIdMaterialCajaAgua(int IdMaterialCajaAgua) {
        this.IdMaterialCajaAgua = IdMaterialCajaAgua;
    }

    /**
     * @return the MaterialCajaAgua
     */
    public String getMaterialCajaAgua() {
        return MaterialCajaAgua;
    }

    /**
     * @param MaterialCajaAgua the MaterialCajaAgua to set
     */
    public void setMaterialCajaAgua(String MaterialCajaAgua) {
        this.MaterialCajaAgua = MaterialCajaAgua;
    }
 @Override
    public String toString(){
       return this.MaterialCajaAgua;
    }
}
