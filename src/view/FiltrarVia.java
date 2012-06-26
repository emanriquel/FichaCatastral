/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FiltrarSujeto.java
 *
 * Created on 08-sep-2011, 23:07:23
 */
package view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.table.TableColumn;
import modelo.datos.CDHabitacion;
import modelo.datos.CDVia;
import modelo.entidad.CEVia;
import util.ArrayListTableModel;

/**
 *
 * @author EDWAR
 */
public class FiltrarVia extends javax.swing.JDialog implements ActionListener {

    
    public FiltrarVia(java.awt.Dialog parent, boolean modal,String param) {
        super(parent, modal);
        initComponents();        
        txtFiltro.requestFocus();
        txtFiltro.setText(param);
        configurarTabla();
        getLista2();
    }
    
    private void configurarTabla() {
        ArrayListTableModel oModelo = new ArrayListTableModel();
        oModelo.addColumn("id");
        oModelo.addColumn("Codigo");
        oModelo.addColumn("Tipo");
        oModelo.addColumn("Via");
        
        
        
        jTable1.setModel(oModelo);
        int[] colEdit = {0, 1};
        oModelo.setColumnEditable(colEdit);
        
        
        TableColumn colId = jTable1.getColumnModel().getColumn(0);
        colId.setMinWidth(0);
        colId.setMaxWidth(0);
        TableColumn colIdq = jTable1.getColumnModel().getColumn(1);
        colIdq.setMinWidth(70);
        colIdq.setMaxWidth(70);
        
        TableColumn coltipo = jTable1.getColumnModel().getColumn(2);
        coltipo.setMinWidth(100);
        coltipo.setMaxWidth(100);        
        
        TableColumn coltipo1 = jTable1.getColumnModel().getColumn(3);
        coltipo1.setMinWidth(350);
        coltipo1.setMaxWidth(350);
        
        jTable1.getTableHeader().setReorderingAllowed(false);
    }
    
    
    
    
    private void limpiarTabla() {
        ArrayListTableModel oModelo = (ArrayListTableModel) jTable1.getModel();
        int size = oModelo.getRowCount();
        
        for (int i = 0; i < size; i++) {
            oModelo.removeRow(0);
        }
    }    
    private void getLista() {
        String dato = txtFiltro.getText().trim();                
            CDVia oCDVia = new CDVia();
            ArrayList oLista = (ArrayList) oCDVia.listarVia(1,dato);
            if (oLista != null) {
                fillTable(oLista);
            }        
    }
    private void getLista2() {
        String dato = txtFiltro.getText().trim();                
            CDVia oCDVia = new CDVia();
            ArrayList oLista = (ArrayList) oCDVia.listarVia(2,dato);
            if (oLista != null) {
                fillTable(oLista);
            }        
    }
    
    private void fillTable(ArrayList oListaAux) {
        ArrayList oRow;
        CEVia oCEVia;
        ArrayListTableModel oModelo = (ArrayListTableModel) jTable1.getModel();
        int size = oListaAux.size();
        limpiarTabla();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                oCEVia = new CEVia();
                oCEVia = (CEVia) oListaAux.get(i);
                oRow = new ArrayList();
                oRow.add(0, oCEVia.getIdVia());
                oRow.add(1, oCEVia.getCodigo());
                oRow.add(2, oCEVia.getTipo());
                oRow.add(3, oCEVia.getNombreVia());
                oModelo.addRow(oRow);
            }
        }
    }
    
    public CEVia GetVia() {
        int selectedRow = FilaSeleccionada;
        CEVia oCEVia = new CEVia();
        if (selectedRow != -1) {
            txtFiltro.setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
            oCEVia.setIdVia(Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString()));            
            oCEVia.setCodigo(Integer.parseInt(jTable1.getValueAt(selectedRow, 1).toString()));
            oCEVia.setTipo(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
            oCEVia.setNombreVia(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
            
            dispose();
        }
        return oCEVia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrupoBusqueda = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtra de Vía");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Via\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese Datos");

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        getLista2();
}//GEN-LAST:event_btnBuscar1ActionPerformed
    
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            getLista();
        }
        if (evt.getKeyCode() == evt.VK_DOWN) {
            int size = jTable1.getRowCount();
            if (size > 0) {
                jTable1.requestFocus();
                jTable1.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getClickCount() == 2) {
            GetVia();
        }
    }//GEN-LAST:event_formMouseClicked
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        jTable1.clearSelection();
    }//GEN-LAST:event_formWindowClosed
    int FilaSeleccionada = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            FilaSeleccionada = jTable1.getSelectedRow();
            if (FilaSeleccionada != -1) {
                GetVia();
                //dispose();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            FilaSeleccionada = jTable1.getSelectedRow();
            if (FilaSeleccionada != -1) {
                GetVia();
                //dispose();
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        if(evt.getKeyCode()==evt.VK_DOWN)
     {
         int size =jTable1.getRowCount();
         if(size>0)
         {
         jTable1.requestFocus();
         jTable1.setRowSelectionInterval(0,0);
         }
     }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed

        getLista2();
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        getLista2();
    }//GEN-LAST:event_jButton1ActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrupoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
    private static final String ACTION_CLOSE = "ACTION_CLOSE";
    
    protected JRootPane createRootPane() {
        JRootPane rootPane = new JRootPane();
        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        rootPane.registerKeyboardAction(this, ACTION_CLOSE, esc, JComponent.WHEN_IN_FOCUSED_WINDOW);
        return rootPane;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (ACTION_CLOSE.equals(e.getActionCommand())) {
            jTable1.clearSelection();
            dispose();
        }
    }
}
