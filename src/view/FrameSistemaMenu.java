
package view;

public class FrameSistemaMenu extends javax.swing.JFrame {

    public FrameSistemaMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblListadoRegistro = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BtnNuevoRegistro = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNroReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblListadoRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Ficha", "Dept", "Prov.", "Dist.", "Manz.", "Lote", "Conexion", "Fecha Encuesta", "Cod_Inspector", "Inspector", "Tipo Usuario", "Inscripcion", "Nombre", "Cod_Via", "Tipo_Via", "Nom_Via", "Nro_Municipal", "Cod_Habilitacion", "Tip_Habilitacion", "Nom_Habilitacion", "Actividad Comercial", "Situacion_Predio", "Uso Predio", "Suministro", "Nro_Medido", "Lectura", "MarcaMedidor", "Diametro", "Estado Medidor", "Conexion2", "Estado Caja", "Material Valvular", "Dispositivo", "TipValvula", "Ubicacion", "Imposibilidad", "Tip_Tapa", "Seguro Tapa", "Estado Tapa", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblListadoRegistro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(TblListadoRegistro);
        TblListadoRegistro.getColumnModel().getColumn(0).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(1).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(2).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(3).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(4).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(5).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(6).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(7).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(8).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(9).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(10).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(11).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(12).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(13).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(14).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(15).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(16).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(17).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(18).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(19).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(20).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(21).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(22).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(23).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(24).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(25).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(26).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(27).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(28).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(29).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(30).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(31).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(32).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(33).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(34).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(35).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(36).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(37).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(38).setResizable(false);
        TblListadoRegistro.getColumnModel().getColumn(39).setResizable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Filtro:");

        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/v-search_more.png"))); // NOI18N
        jButton1.setText("Buscar");

        BtnNuevoRegistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnNuevoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/document_2_add.png"))); // NOI18N
        BtnNuevoRegistro.setText("Nuevo");
        BtnNuevoRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevoRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoRegistroActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/file_delete.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/edit.gif"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Módulo de Consulta de Fichas Catastrales");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel4.setText("EPS EMAPAVIGSSA");

        lblNroReg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNroReg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNroReg.setOpaque(true);

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(lblNroReg, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE))))
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
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
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
     DialogMantenimientoMedida oDialogMantenimientoMedida=new DialogMantenimientoMedida(null,true,1);
     oDialogMantenimientoMedida.setLocationRelativeTo(null);
     oDialogMantenimientoMedida.setVisible(true);
    }//GEN-LAST:event_BtnNuevoRegistroActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNuevoRegistro;
    private javax.swing.JTable TblListadoRegistro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNroReg;
    // End of variables declaration//GEN-END:variables

}
