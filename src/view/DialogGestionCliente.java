package view;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.datos.CDCliente;
import modelo.entidad.CECliente;
import util.ArrayListTableModel;


public class DialogGestionCliente extends javax.swing.JDialog {

    private int codigo=0;
    private CECliente oCEClienteSeleccionado=null;
    public DialogGestionCliente(java.awt.Frame parent, boolean modal,int codigo,String parametro) {
        super(parent, modal);
        Container con = this.getContentPane();
	con.setBackground( new Color(204,204,204 ));

        initComponents();
        OcultarCampos();
        setupTable();
        getLista();
        habilitar(true);
        this.codigo=codigo;
        txtfiltro.setText(parametro);
        txtfiltro.requestFocus();
        if(codigo==0)
        {
            BtnAceptar.setVisible(false);
        }

    }
private void OcultarCampos(){
        lblCodigo.setVisible(false);        
    }    
    private void habilitar(Boolean habilitar){
        BtnNuevoRegistro.setEnabled(habilitar);
        BtnEliminar.setEnabled(!habilitar);
        BtnModificar.setEnabled(!habilitar);
        if(codigo!=0){
            BtnAceptar.setEnabled(!habilitar);
        }
    }
    private void setupTable() {
        TblResultados.setSize(423, 479);
        ArrayListTableModel oModelo = new ArrayListTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        oModelo.addColumn("ID");
        oModelo.addColumn("Nro Inscripcion");
        oModelo.addColumn("Cliente");

        TblResultados.setModel(oModelo);
        
        
        TableColumn colId = TblResultados.getColumnModel().getColumn(0);
//        colId.setPreferredWidth(5);
        colId.setMinWidth(0);
        colId.setMaxWidth(0);
        
        TableColumn coltipo = TblResultados.getColumnModel().getColumn(1);
//        colIdUnidad.setPreferredWidth(5);
        coltipo.setMinWidth(160);
        coltipo.setMaxWidth(160);        
        
         TableColumn coltipo1 = TblResultados.getColumnModel().getColumn(2);
//        colIdUnidad.setPreferredWidth(5);
        coltipo1.setMinWidth(350);
        coltipo1.setMaxWidth(350);
        
        //TblResultados.getTableHeader().setReorderingAllowed(false);
    }    
    private void getLista() {
        CDCliente oCDCliente = new CDCliente();
        ArrayList oLista = (ArrayList) oCDCliente.listarCliente();
        if (oLista != null) {
            fillTable(oLista);
        }
        this.lblNroReg.setText(" Se Encontraron " + TblResultados.getRowCount() + " Registros ");
    }
    private int elegirOpcion(){
       if(RbtAntiguoCodigo.isSelected())
        {
           return 2;
        }
        else{
           if(RbtNuevoCodigo.isSelected())
            {
               return 3;
            }
        else{
               if(RbtApellidos.isSelected())
                {
               return 4;
                }
               return 1;
        }
        }
    }
    private void getFiltro() {
        CDCliente oCDCliente = new CDCliente();
        //ArrayList oLista = (ArrayList) CCPais.listafiltro(txtfiltro.getText());
        ArrayList oLista;
        if(elegirOpcion()==1)
        {
        oLista = (ArrayList) oCDCliente.filtrarClientePorNumeroInscripcion(txtfiltro.getText());
        }
        else{
         if(elegirOpcion()==2)
            {
            oLista = (ArrayList) oCDCliente.filtrarClientePorNuevoCodigoCatastral(txtfiltro.getText());
            }
        else{
             if(elegirOpcion()==3)
             {
                 oLista = (ArrayList) oCDCliente.filtrarClientePorAntiguoCodigoCatastral(txtfiltro.getText());
             }
            else
             {
                oLista = (ArrayList) oCDCliente.filtrarClientePorApellidosNombres(txtfiltro.getText());
            }
            }
        }
        if (oLista != null) {
            fillTable(oLista);
        }
        this.lblNroReg.setText(" Se Encontraron " + TblResultados.getRowCount() + " Registros ");
    }
    private void fillTable(ArrayList oListaAux) {
        ArrayList oRow;
        CECliente oCECliente;
        ArrayListTableModel oModelo = (ArrayListTableModel) TblResultados.getModel();
        int size = oListaAux.size();
        limpiarTabla();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                oCECliente = new CECliente();
                oCECliente = (CECliente) oListaAux.get(i);
                oRow = new ArrayList();
                oRow.add(0, oCECliente.getIdCliente());
                oRow.add(1, oCECliente.getNumeroDocumento());
                oRow.add(2, oCECliente.getApellidoPaternoPropietario());
                oModelo.addRow(oRow);
            }
        }
    }
    private void limpiarTabla() {
        ArrayListTableModel oModelo = (ArrayListTableModel) TblResultados.getModel();
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
            
            this.lblCodigo.setText(TblResultados.getValueAt(nReg, 0).toString());
            
            TblResultados.changeSelection(nReg, 0, true, false);
            TblResultados.changeSelection(nReg, 0, false, true);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BtnNuevoRegistro = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnAceptar = new javax.swing.JButton();
        BtnBuscarUsuario = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblResultados = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblNroReg = new javax.swing.JLabel();
        BtnEliminar = new javax.swing.JButton();
        RbtAntiguoCodigo = new javax.swing.JRadioButton();
        RbtNuevoCodigo = new javax.swing.JRadioButton();
        RbtApellidos = new javax.swing.JRadioButton();
        RbtNumInscripcion = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios");

        BtnNuevoRegistro.setFont(new java.awt.Font("Arial", 1, 12));
        BtnNuevoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/Farm-Fresh_group_add.png"))); // NOI18N
        BtnNuevoRegistro.setText("Nuevo");
        BtnNuevoRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevoRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoRegistroActionPerformed(evt);
            }
        });

        BtnModificar.setFont(new java.awt.Font("Arial", 1, 12));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/group_edit.png"))); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnAceptar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/Accept-Male-User.png"))); // NOI18N
        BtnAceptar.setText("Aceptar");
        BtnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        BtnBuscarUsuario.setFont(new java.awt.Font("Arial", 1, 11));
        BtnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/v-search_more.png"))); // NOI18N
        BtnBuscarUsuario.setText("Buscar");
        BtnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarUsuarioActionPerformed(evt);
            }
        });

        lblFiltro.setFont(new java.awt.Font("Arial", 1, 14));
        lblFiltro.setForeground(new java.awt.Color(0, 0, 51));
        lblFiltro.setText("Filtro:");

        txtfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroActionPerformed(evt);
            }
        });
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });

        TblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblResultadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblResultadosMousePressed(evt);
            }
        });
        TblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TblResultadosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TblResultados);

        lblCodigo.setText("0");

        lblNroReg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNroReg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroReg.setOpaque(true);

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

        buttonGroup1.add(RbtAntiguoCodigo);
        RbtAntiguoCodigo.setText("Antiguo Codigo Catastral");

        buttonGroup1.add(RbtNuevoCodigo);
        RbtNuevoCodigo.setText("Nuevo Codigo Catastral");
        RbtNuevoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtNuevoCodigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtApellidos);
        RbtApellidos.setText("Apellidos y Nombres");

        buttonGroup1.add(RbtNumInscripcion);
        RbtNumInscripcion.setSelected(true);
        RbtNumInscripcion.setText("Nº Inscripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(RbtNumInscripcion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RbtAntiguoCodigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RbtNuevoCodigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(RbtApellidos)
                                    .addGap(32, 32, 32))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BtnBuscarUsuario))
                                .addComponent(lblFiltro))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(BtnNuevoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(BtnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RbtNumInscripcion)
                            .addComponent(RbtAntiguoCodigo)
                            .addComponent(RbtNuevoCodigo)
                            .addComponent(RbtApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBuscarUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(BtnNuevoRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAceptar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
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

    private void TblResultadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblResultadosMousePressed
        habilitar(true);
        BtnModificar.setEnabled(true);
        BtnEliminar.setEnabled(true);
        BtnAceptar.setEnabled(true);
        pos = this.TblResultados.getSelectedRow();
        this.verFila(pos);
    }//GEN-LAST:event_TblResultadosMousePressed

    private void TblResultadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblResultadosKeyTyped
        pos = this.TblResultados.getSelectedRow();
        this.verFila(pos);
    }//GEN-LAST:event_TblResultadosKeyTyped
    int pOperacionAMB=0;
    int pos;
    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
    CDCliente oCDCliente =new CDCliente();
            CECliente oCECliente = new CECliente();
            oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
            CECliente ooCECliente = oCDCliente.DetalleCliente(oCECliente);
            oCEClienteSeleccionado=ooCECliente;
            dispose();
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
    if(evt.getKeyCode()==evt.VK_DOWN)
     {
         int size =TblResultados.getRowCount();
         if(size>0)
         {
         TblResultados.requestFocus();
         TblResultados.setRowSelectionInterval(0,0);
         }
     }
    }//GEN-LAST:event_txtfiltroKeyReleased

    private void BtnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarUsuarioActionPerformed
        getFiltro();
    }//GEN-LAST:event_BtnBuscarUsuarioActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        CECliente  oCECliente = new CECliente();
        oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
        DialogCliente oDialogCliente = new DialogCliente(null, true,oCECliente,2);
        oDialogCliente.setLocationRelativeTo(null);
        oDialogCliente.setVisible(true);
    }//GEN-LAST:event_BtnModificarActionPerformed

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

    private void TblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblResultadosMouseClicked
        if(evt.getClickCount()==2)
        {
            CDCliente oCDCliente =new CDCliente();
            CECliente oCECliente = new CECliente();
            oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
            CECliente ooCECliente = oCDCliente.DetalleCliente(oCECliente);
            oCEClienteSeleccionado=ooCECliente;
            dispose();
        }
    }//GEN-LAST:event_TblResultadosMouseClicked

    private void txtfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroActionPerformed
        getFiltro();
    }//GEN-LAST:event_txtfiltroActionPerformed

    private void RbtNuevoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtNuevoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbtNuevoCodigoActionPerformed
    public CECliente getClienteSeleccionado(){
        return oCEClienteSeleccionado;
    }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnBuscarUsuario;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevoRegistro;
    private javax.swing.JRadioButton RbtAntiguoCodigo;
    private javax.swing.JRadioButton RbtApellidos;
    private javax.swing.JRadioButton RbtNuevoCodigo;
    private javax.swing.JRadioButton RbtNumInscripcion;
    private javax.swing.JTable TblResultados;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblNroReg;
    private javax.swing.JTextField txtfiltro;
    // End of variables declaration//GEN-END:variables
}
