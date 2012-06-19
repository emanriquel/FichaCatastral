/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidad;

/**
 *
 * @author Elizabeth
 */
public class CEUbiCajaConexDesague {
    private int IdUbiCajaConexDesague;
    private String UbiCajaConexDesague;
    private int Codigo;
    /**
     * @return the IdUbiCajaConexDesague
     */
    public int getIdUbiCajaConexDesague() {
        return IdUbiCajaConexDesague;
    }

    /**
     * @param IdUbiCajaConexDesague the IdUbiCajaConexDesague to set
     */
    public void setIdUbiCajaConexDesague(int IdUbiCajaConexDesague) {
        this.IdUbiCajaConexDesague = IdUbiCajaConexDesague;
    }

    /**
     * @return the UbiCajaConexDesague
     */
    public String getUbiCajaConexDesague() {
        return UbiCajaConexDesague;
    }

    /**
     * @param UbiCajaConexDesague the UbiCajaConexDesague to set
     */
    public void setUbiCajaConexDesague(String UbiCajaConexDesague) {
        this.UbiCajaConexDesague = UbiCajaConexDesague;
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
       return this.UbiCajaConexDesague;
    }

}
