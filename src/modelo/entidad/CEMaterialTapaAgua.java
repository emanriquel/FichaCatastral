package modelo.entidad;


public class CEMaterialTapaAgua
{
    private int IdMaterialTapaAgua;
    private String MaterialTapaAgua;
    private int Codigo;
    /**
     * @return the IdMaterialTapaAgua
     */
    public int getIdMaterialTapaAgua() {
        return IdMaterialTapaAgua;
    }

    /**
     * @param IdMaterialTapaAgua the IdMaterialTapaAgua to set
     */
    public void setIdMaterialTapaAgua(int IdMaterialTapaAgua) {
        this.IdMaterialTapaAgua = IdMaterialTapaAgua;
    }

    /**
     * @return the MaterialTapaAgua
     */
    public String getMaterialTapaAgua() {
        return MaterialTapaAgua;
    }

    /**
     * @param MaterialTapaAgua the MaterialTapaAgua to set
     */
    public void setMaterialTapaAgua(String MaterialTapaAgua) {
        this.MaterialTapaAgua = MaterialTapaAgua;
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
       return this.MaterialTapaAgua;
    }
}
