package modelo.entidad;

public class CEEstadoMaterialTapaAgua
{
    private int IdMaterialTapaAgua;
    private int codigo;
    private String MaterialTapaAgua;

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
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return MaterialTapaAgua;
    }

}
