/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.datos.CDCliente;
import modelo.entidad.CECliente;
import util.ArrayListTableModel;

/**
 *
 * @author Edwar
 */

public class DialogGestionCliente extends javax.swing.JDialog {

    /**
     * Creates new form DialogMantenimientoCliente
     */
    public DialogGestionCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        OcultarCampos();
        setupTable();
        getLista();
        habilitar(true);
    }
private void OcultarCampos(){
        lblCodigo.setVisible(false);        
    }    
    private void habilitar(Boolean habilitar){
        BtnNuevoRegistro.setEnabled(habilitar);
        BtnEliminar.setEnabled(!habilitar);
        BtnModificar.setEnabled(!habilitar);
    }
    private void setupTable() {
        TablaDatos.setSize(423, 479);
        ArrayListTableModel oModelo = new ArrayListTableModel();
        oModelo.addColumn("ID");
        oModelo.addColumn("NroDocumento");        
        oModelo.addColumn("Cliente");
        TablaDatos.setModel(oModelo);
        
        
        TableColumn colId = TablaDatos.getColumnModel().getColumn(0);
//        colId.setPreferredWidth(5);
        colId.setMinWidth(0);
        colId.setMaxWidth(0);
        
        TableColumn coltipo = TablaDatos.getColumnModel().getColumn(1);
//        colIdUnidad.setPreferredWidth(5);
        coltipo.setMinWidth(160);
        coltipo.setMaxWidth(160);        
        
         TableColumn coltipo1 = TablaDatos.getColumnModel().getColumn(2);
//        colIdUnidad.setPreferredWidth(5);
        coltipo1.setMinWidth(350);
        coltipo1.setMaxWidth(350);
        
        //TablaDatos.getTableHeader().setReorderingAllowed(false);
    }    
    private void getLista() {
        CDCliente oCDCliente = new CDCliente();
        ArrayList oLista = (ArrayList) oCDCliente.listarCliente();
        if (oLista != null) {
            fillTable(oLista);
        }
        this.lblNroReg.setText(" Se Encontraron " + TablaDatos.getRowCount() + " Registros ");
    }
    private void getFiltro() {
        CDCliente oCDCliente = new CDCliente();
        //ArrayList oLista = (ArrayList) CCPais.listafiltro(txtfiltro.getText());
        ArrayList oLista = (ArrayList) oCDCliente.filtrarCliente(txtfiltro.getText());
        
        if (oLista != null) {
            fillTable(oLista);
        }
        this.lblNroReg.setText(" Se Encontraron " + TablaDatos.getRowCount() + " Registros ");
    }
    private void fillTable(ArrayList oListaAux) {
        ArrayList oRow;
        CECliente oCECliente;
        ArrayListTableModel oModelo = (ArrayListTableModel) TablaDatos.getModel();
        int size = oListaAux.size();
        limpiarTabla();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                oCECliente = new CECliente();
                oCECliente = (CECliente) oListaAux.get(i);
                oRow = new ArrayList();
                oRow.add(0, oCECliente.getIdCliente());
                oRow.add(1, oCECliente.getNumeroDocumento());
                oRow.add(2, oCECliente.getNombrePropietario());                
                oModelo.addRow(oRow);
            }
        }
    }
    private void limpiarTabla() {
        ArrayListTableModel oModelo = (ArrayListTableModel) TablaDatos.getModel();
        int size = oModelo.getRowCount();
        
        for (int i = 0; i < size; i++) {
            oModelo.removeRow(0);
        }
    }
    private CECliente getObjetoDatos() {
        CECliente oCECliente= new CECliente();        
        oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));                        
        return oCECliente;
    }
    private void verFila(int nReg) {
        
        if (nReg != -1) {
            
            this.lblCodigo.setText(TablaDatos.getValueAt(nReg, 0).toString());            
            
            TablaDatos.changeSelection(nReg, 0, true, false);
            TablaDatos.changeSelection(nReg, 0, false, true);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnNuevoRegistro = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblNroReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnNuevoRegistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnNuevoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/Farm-Fresh_group_add.png"))); // NOI18N
        BtnNuevoRegistro.setText("Nuevo");
        BtnNuevoRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevoRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoRegistroActionPerformed(evt);
            }
        });

        BtnModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/group_edit.png"))); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/delete_user.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/v-search_more.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblFiltro.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblFiltro.setForeground(new java.awt.Color(0, 0, 51));
        lblFiltro.setText("Filtro:");

        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });

        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDatosMousePressed(evt);
            }
        });
        TablaDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TablaDatosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatos);

        lblCodigo.setText("0");

        lblNroReg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNroReg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroReg.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(BtnNuevoRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 375, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFiltro)
                                .addGap(18, 18, 18)
                                .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCodigo)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoRegistroActionPerformed
        CECliente  oCECliente = new CECliente();
        oCECliente.setIdCliente(0);
        DialogCliente oDialogCliente = new DialogCliente(null, true,oCECliente,1);
        oDialogCliente.setLocationRelativeTo(null);
        oDialogCliente.setVisible(true);
    }//GEN-LAST:event_BtnNuevoRegistroActionPerformed

    private void TablaDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMousePressed
        habilitar(true);
        BtnModificar.setEnabled(true);
        BtnEliminar.setEnabled(true);
        pos = this.TablaDatos.getSelectedRow();
        this.verFila(pos);
    }//GEN-LAST:event_TablaDatosMousePressed

    private void TablaDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaDatosKeyTyped
        pos = this.TablaDatos.getSelectedRow();
        this.verFila(pos);
    }//GEN-LAST:event_TablaDatosKeyTyped
    int pOperacionAMB=0;
    int pos;
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este registro?", "Dialogo de Confirmación", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            CDCliente oCDCliente = new CDCliente();
            if (oCDCliente.Eliminar(3,getObjetoDatos())) {
                JOptionPane.showMessageDialog(null, "Se Elimino Registro Exitosamente");
                
                pOperacionAMB = 0;
                limpiarTabla();
                getLista();
                txtfiltro.setText("");
                txtfiltro.requestFocus();
                //LimpiarCajas();
            } else {
                
                JOptionPane.showMessageDialog(null, "No se pudo Eliminar Registro");
                //LimpiarCajas();
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        getFiltro();
    }//GEN-LAST:event_txtfiltroKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getFiltro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        CECliente  oCECliente = new CECliente();
        oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
        DialogCliente oDialogCliente = new DialogCliente(null, true,oCECliente,2);
        oDialogCliente.setLocationRelativeTo(null);
        oDialogCliente.setVisible(true);
    }//GEN-LAST:event_BtnModificarActionPerformed

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevoRegistro;
    private javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblNroReg;
    private javax.swing.JTextField txtfiltro;
    // End of variables declaration//GEN-END:variables
}
