
package view;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.datos.CDMedida;
import modelo.entidad.CEMedida;
import sun.jdbc.odbc.OdbcDef;

public class FrameSistemaMenu extends javax.swing.JFrame {

    public FrameSistemaMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListadoRegistro = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TxtFiltro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BtnNuevoRegistro = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNroReg = new javax.swing.JLabel();
        RbtInscripcion = new javax.swing.JRadioButton();
        RbtUsuarip = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblListadoRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Ficha", "Nº Inscripcion", "Usuario", "Fecha Encuesta", "Dept", "Prov.", "Dist.", "Manz.", "Lote", "Cod_Via", "Tipo_Via", "Nom_Via", "Nro_Municipal", "Cod_Habilitacion", "Tip_Habilitacion", "Nom_Habilitacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblListadoRegistro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblListadoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblListadoRegistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblListadoRegistro);
        TblListadoRegistro.getColumnModel().getColumn(0).setPreferredWidth(60);
        TblListadoRegistro.getColumnModel().getColumn(1).setPreferredWidth(80);
        TblListadoRegistro.getColumnModel().getColumn(2).setPreferredWidth(250);
        TblListadoRegistro.getColumnModel().getColumn(3).setPreferredWidth(90);
        TblListadoRegistro.getColumnModel().getColumn(10).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(15).setResizable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Filtro:");

        TxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFiltroActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 11));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/v-search_more.png"))); // NOI18N
        jButton1.setText("Buscar");

        BtnNuevoRegistro.setFont(new java.awt.Font("Arial", 1, 12));
        BtnNuevoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/document_2_add.png"))); // NOI18N
        BtnNuevoRegistro.setText("Nuevo");
        BtnNuevoRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevoRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoRegistroActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/file_delete.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/edit.gif"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Módulo de Consulta de Fichas Catastrales");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel4.setText("EPS EMAPAVIGSSA");

        lblNroReg.setFont(new java.awt.Font("Arial", 1, 12));
        lblNroReg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNroReg.setOpaque(true);

        buttonGroup1.add(RbtInscripcion);
        RbtInscripcion.setText("Nº Inscripción");

        buttonGroup1.add(RbtUsuarip);
        RbtUsuarip.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnNuevoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RbtInscripcion)
                                .addGap(18, 18, 18)
                                .addComponent(RbtUsuarip)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RbtInscripcion)
                            .addComponent(RbtUsuarip)
                            .addComponent(jLabel3)
                            .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoRegistroActionPerformed
     DialogMantenimientoMedida oDialogMantenimientoMedida=new DialogMantenimientoMedida(null,true,1,null);
     oDialogMantenimientoMedida.setLocationRelativeTo(null);
     oDialogMantenimientoMedida.setVisible(true);
    }//GEN-LAST:event_BtnNuevoRegistroActionPerformed

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed
        limpiarTabla();
        if(opcion()==1)
        {
            CDMedida cDMedida=new CDMedida();
            List<CEMedida> oLstMedida=cDMedida.listarPorCodigoInscripcion(TxtFiltro.getText());
            for(CEMedida oCEMedida:oLstMedida)
            {
                Vector oVector=new Vector();
                   oVector.add(oCEMedida.getNumeroFicha());
                oVector.add(oCEMedida.getCod_Inscripcion());
                oVector.add(oCEMedida);
                oVector.add(oCEMedida.getFecha_Encuestador());
                oVector.add(oCEMedida.getCodDepartamento());
                oVector.add(oCEMedida.getCodProvincia());
                oVector.add(oCEMedida.getCodDistrito());
                oVector.add(oCEMedida.getManzana());
                oVector.add(oCEMedida.getLote());
                oVector.add(oCEMedida.getCodigoVia());
                oVector.add(oCEMedida.getTipoVia());
                oVector.add(oCEMedida.getNombreVia());
                oVector.add(oCEMedida.getCodigoHabilitacion());
                oVector.add(oCEMedida.getTipoHabilitacion());
                oVector.add(oCEMedida.getNombreHabilitacion());
                oVector.add(oCEMedida.getFecha_Encuestador());
                ((DefaultTableModel)TblListadoRegistro.getModel()).addRow(oVector);
            }
        }
        else
        {
             CDMedida cDMedida=new CDMedida();
            List<CEMedida> oLstMedida=cDMedida.listarPorCodigoInscripcion(TxtFiltro.getText());
            for(CEMedida oCEMedida:oLstMedida)
            {
                Vector oVector=new Vector();
                oVector.add(oCEMedida.getNumeroFicha());
                oVector.add(oCEMedida.getCod_Inscripcion());
                oVector.add(oCEMedida);
                oVector.add(oCEMedida.getFecha_Encuestador());
                oVector.add(oCEMedida.getCodDepartamento());
                oVector.add(oCEMedida.getCodProvincia());
                oVector.add(oCEMedida.getCodDistrito());
                oVector.add(oCEMedida.getManzana());
                oVector.add(oCEMedida.getLote());
                oVector.add(oCEMedida.getCodigoVia());
                oVector.add(oCEMedida.getTipoVia());
                oVector.add(oCEMedida.getNombreVia());
                oVector.add(oCEMedida.getCodigoHabilitacion());
                oVector.add(oCEMedida.getTipoHabilitacion());
                oVector.add(oCEMedida.getNombreHabilitacion());

                ((DefaultTableModel)TblListadoRegistro.getModel()).addRow(oVector);

            }
        }
    }//GEN-LAST:event_TxtFiltroActionPerformed

    private void TblListadoRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblListadoRegistroMouseClicked
       if(evt.getClickCount()==2)
       {
           int fila=TblListadoRegistro.getSelectedRow();
           if(fila!=-1)
           {
               CEMedida oCEMedida=(CEMedida)TblListadoRegistro.getValueAt(fila,2);
               DialogMantenimientoMedida oDialogMantenimientoMedida=new DialogMantenimientoMedida(null,true, 3,oCEMedida);
               oDialogMantenimientoMedida.setLocationRelativeTo(null);
               oDialogMantenimientoMedida.setVisible(true);
           }
       }
    }//GEN-LAST:event_TblListadoRegistroMouseClicked
   
   private void limpiarTabla(){
       DefaultTableModel oDefaultTableModel=(DefaultTableModel)TblListadoRegistro.getModel();
       for(int i=0;i<oDefaultTableModel.getRowCount();i++)
       {
           oDefaultTableModel.removeRow(0);
       }
   }

    private int opcion()
    {
        if(RbtInscripcion.isSelected())
        {
            return 1;
        }
        return 2;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNuevoRegistro;
    private javax.swing.JRadioButton RbtInscripcion;
    private javax.swing.JRadioButton RbtUsuarip;
    private javax.swing.JTable TblListadoRegistro;
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNroReg;
    // End of variables declaration//GEN-END:variables

}
