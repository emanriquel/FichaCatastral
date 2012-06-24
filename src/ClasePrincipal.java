
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Color;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.FrmAccesoSistema;

public class ClasePrincipal {

  
    public static void main(String[] args) {
        try
        {
            UIManager.put("ComboBox.disabledForeground", Color.BLACK);
            UIManager.put("ComboBox.disabledBackground", new Color(236, 233, 216));
            UIManager.put("CheckBox.disabledForeground", Color.BLACK);
            UIManager.put("CheckBox.disabledBackground", new Color(236, 233, 216));
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            FrmAccesoSistema oFramePrincipal = new FrmAccesoSistema();
            oFramePrincipal.setLocationRelativeTo(null);
            oFramePrincipal.setVisible(true);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
