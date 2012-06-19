/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidad;

/**
 *
 * @author Elizabeth
 */
public class CEUsoPredio {
    private int IdUsoPredio;
    private String UsoPredio;
    private int Codigo;
    /**
     * @return the IdUsoPredio
     */
    public int getIdUsoPredio() {
        return IdUsoPredio;
    }

    /**
     * @param IdUsoPredio the IdUsoPredio to set
     */
    public void setIdUsoPredio(int IdUsoPredio) {
        this.IdUsoPredio = IdUsoPredio;
    }

    /**
     * @return the UsoPredio
     */
    public String getUsoPredio() {
        return UsoPredio;
    }

    /**
     * @param UsoPredio the UsoPredio to set
     */
    public void setUsoPredio(String UsoPredio) {
        this.UsoPredio = UsoPredio;
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
       return this.UsoPredio;
    }
}
