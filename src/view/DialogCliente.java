package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import modelo.datos.*;
import modelo.entidad.*;
import util.ArrayListComboBoxModel;

public class DialogCliente extends javax.swing.JDialog {
    int pOperacion = 0;
    public DialogCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //cargarComboBox();
    }
    
    public DialogCliente(java.awt.Frame parent, boolean modal,CECliente oCECliente,int  Operacion) {
        super(parent, modal);
        initComponents();
        cargarComboBox();
        OcultarCampos();
        lblCodigo.setText(oCECliente.getIdCliente()+"");
        pOperacion = Operacion;
        
        if(Operacion==2){
            AbrirDialogBusqueda();
        }else{
            CargarParaNuevo();            
        }
        
    }
    
    private void OcultarCampos(){
        lblCodigo.setVisible(false);
        lblIdHabitacion.setVisible(false);
        lblIdVia.setVisible(false);
    }
    private void CargarParaNuevo(){
        
        TxtAntiguoCodigoCatastral.requestFocus();
        
        
        
    }
    private void cargarComboBox(){            
        
        CDTipoDocumento oCDTipoDocumento=new CDTipoDocumento();
        ArrayList oLstTipoDocumento=oCDTipoDocumento.listarTipoDocumento();
        construirModeloCombo(CbxTipoDocumento, oLstTipoDocumento);

        CDMedioAbastecimiento oCDMedioAbastecimiento=new CDMedioAbastecimiento();
        ArrayList oLstMedioAbastecimiento=oCDMedioAbastecimiento.listarMedioAbastecimiento();
        construirModeloCombo(CbxMedioAbastecimiento, oLstMedioAbastecimiento);

        CDCondicionConexionAgua oCDCondicionConexionAgua=new CDCondicionConexionAgua();
        ArrayList oLstCondicionConexionAgua=oCDCondicionConexionAgua.listarCondicionConexionAgua();
        construirModeloCombo(CbxCondicionConexionAgua, oLstCondicionConexionAgua);

    }
    private void construirModeloCombo(JComboBox oBox, ArrayList oLista)
    {
        ArrayListComboBoxModel model = new ArrayListComboBoxModel( oLista ) ;
        oBox.setModel(model);
        oBox.setSelectedIndex(0);
    }
    public void AbrirDialogBusqueda()
    {
        
                    CDCliente oCDCliente =new CDCliente();
                    
                    CECliente oCECliente = new CECliente();
                    if(oCECliente!=null){                                                
                        oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
                        CECliente ooCECliente = oCDCliente.DetalleCliente(oCECliente);
                        setClienteDetallado(ooCECliente);
                        BtnGuardar.setEnabled(true);
                        BtnCancelar.setEnabled(true);
                        

                    }
                    
    }
    private void setClienteDetallado(CECliente oCECliente)
    {     
         
         buscarIndexComboTipoDocumento(oCECliente.getIdTipoDocumento());
         TxtDireccion.setText(oCECliente.getDireccion());
         buscarIndexComboMedioAbastecimiento(oCECliente.getIdMedioAbastecimiento());
         System.out.print(oCECliente.getIdCondicionConexionAgua()+"");
         buscarIndexComboCondicionConexionAgua(oCECliente.getIdCondicionConexionAgua());
         lblCodigo.setText(oCECliente.getIdCliente()+"");
         TxtAntiguoCodigoCatastral.setText(oCECliente.getAntiguoCodigoCatastral());
         TxtNuevoCodigoCatastral.setText(oCECliente.getNuevoCodigoCatastral());
         TxtCodigoInscripcion.setText(oCECliente.getNumeroInscripcion());
         TxtRutaLectura.setText(oCECliente.getRutaLectura());
         TxtRutaReparto.setText(oCECliente.getRutaReparto());
         TxtSecuencia.setText(oCECliente.getSecuencia());
         TxtCategoria.setText(oCECliente.getCategoria());
         TxtNumDocumento.setText(oCECliente.getNumeroDocumento());
         TxtTelefono.setText(oCECliente.getTelefono());
         TxtApellidoPaternoPropietario.setText(oCECliente.getApellidoPaternoPropietario());
         TxtCorreoElectronico.setText(oCECliente.getCorreoElectronico());
         TxtDireccion.setText(oCECliente.getDireccion());
         
     }
    
    
    
   
   private void buscarIndexComboCondicionConexionAgua(int pId){
      int size=CbxCondicionConexionAgua.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CECondicionConexionAgua obj =(CECondicionConexionAgua)CbxCondicionConexionAgua.getItemAt(i);
            if(obj.getIdCondicionConexionAgua()== pId)
                {
                    CbxCondicionConexionAgua.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
   
    private void buscarIndexComboMedioAbastecimiento(int pId){
      int size=CbxMedioAbastecimiento.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CEMedioAbastecimiento obj =(CEMedioAbastecimiento)CbxMedioAbastecimiento.getItemAt(i);
            if(obj.getIdMedioAbastecimiento()== pId)
                {
                    CbxMedioAbastecimiento.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
   
   
    private void buscarIndexComboTipoDocumento(int pId){
      int size=CbxTipoDocumento.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CETipoDocumento obj =(CETipoDocumento)CbxTipoDocumento.getItemAt(i);
            if(obj.getIdTipoDocumento()== pId)
                {
                    CbxTipoDocumento.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
  
    private CECliente getObjetoSujeto() {
        CECliente oCECliente=new CECliente();        
        if(pOperacion == 1){oCECliente.setIdCliente(1);}
        else{
            oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
        }
        if(pOperacion != 1){
        oCECliente.setIdCliente(Integer.parseInt(lblCodigo.getText()));
        }
        
        
        oCECliente.setAntiguoCodigoCatastral(TxtAntiguoCodigoCatastral.getText());
        oCECliente.setNuevoCodigoCatastral(TxtNuevoCodigoCatastral.getText());
        oCECliente.setNumeroInscripcion(TxtCodigoInscripcion.getText());
        oCECliente.setRutaLectura(TxtRutaLectura.getText());
        oCECliente.setRutaReparto(TxtRutaReparto.getText());
        oCECliente.setSecuencia(TxtSecuencia.getText());
        oCECliente.setCategoria(TxtCategoria.getText());
        oCECliente.setDireccion(TxtDireccion.getText());
        CETipoDocumento oCETipoDocumento =(CETipoDocumento)CbxTipoDocumento.getSelectedItem();
        oCECliente.setIdTipoDocumento(oCETipoDocumento.getIdTipoDocumento());
        
        oCECliente.setNumeroDocumento(TxtNumDocumento.getText());
        oCECliente.setTelefono(TxtTelefono.getText());
        oCECliente.setApellidoPaternoPropietario(TxtApellidoPaternoPropietario.getText());
        oCECliente.setCorreoElectronico(TxtCorreoElectronico.getText());
        
        CECondicionConexionAgua oCECondicionConexionAgua =(CECondicionConexionAgua)CbxCondicionConexionAgua.getSelectedItem();
        oCECliente.setIdCondicionConexionAgua(oCECondicionConexionAgua.getIdCondicionConexionAgua());

        CEMedioAbastecimiento oCEMedioAbastecimiento =(CEMedioAbastecimiento)CbxMedioAbastecimiento.getSelectedItem();
        oCECliente.setIdMedioAbastecimiento(oCEMedioAbastecimiento.getIdMedioAbastecimiento());
        
        return oCECliente;
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TxtAntiguoCodigoCatastral = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        TxtNuevoCodigoCatastral = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TxtCodigoInscripcion = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        TxtRutaLectura = new javax.swing.JTextField();
        TxtRutaReparto = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        TxtSecuencia = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        TxtCategoria = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        TxtApellidoPaternoPropietario = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        CbxTipoDocumento = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        TxtCorreoElectronico = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        TxtNumDocumento = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        CbxMedioAbastecimiento = new javax.swing.JComboBox();
        jLabel141 = new javax.swing.JLabel();
        CbxCondicionConexionAgua = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblIdVia = new javax.swing.JLabel();
        lblIdHabitacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento Usuario");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Identificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Antiguo Código Catastral");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Nuevo Código Catastral");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel24.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Codigo Inscripción");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Ruta de Lectura");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setOpaque(true);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Ruta de Reparto");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel39.setOpaque(true);

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Secuencia");
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel40.setOpaque(true);

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel41.setForeground(new java.awt.Color(0, 0, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Categoría");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel41.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TxtAntiguoCodigoCatastral, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNuevoCodigoCatastral, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtCodigoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtAntiguoCodigoCatastral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNuevoCodigoCatastral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel5.setLayout(null);
        jPanel5.add(TxtApellidoPaternoPropietario);
        TxtApellidoPaternoPropietario.setBounds(30, 60, 830, 20);

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Apellidos y Nombres / Razon Social");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);
        jPanel5.add(jLabel42);
        jLabel42.setBounds(30, 80, 830, 20);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("Num. Documento:");
        jPanel5.add(jLabel45);
        jLabel45.setBounds(350, 30, 100, 20);
        jPanel5.add(CbxTipoDocumento);
        CbxTipoDocumento.setBounds(150, 30, 150, 20);

        jLabel46.setBackground(new java.awt.Color(204, 204, 204));
        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Correo Electrónico");
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel46.setOpaque(true);
        jPanel5.add(jLabel46);
        jLabel46.setBounds(30, 130, 330, 20);
        jPanel5.add(TxtCorreoElectronico);
        TxtCorreoElectronico.setBounds(30, 110, 330, 20);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("Telefono:");
        jPanel5.add(jLabel47);
        jLabel47.setBounds(650, 30, 52, 20);
        jPanel5.add(TxtTelefono);
        TxtTelefono.setBounds(710, 30, 150, 20);

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("Tipo de Documento:");
        jPanel5.add(jLabel52);
        jLabel52.setBounds(30, 30, 112, 20);
        jPanel5.add(TxtNumDocumento);
        TxtNumDocumento.setBounds(460, 30, 150, 20);

        jLabel70.setBackground(new java.awt.Color(204, 204, 204));
        jLabel70.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 102));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Dirección");
        jLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel70.setOpaque(true);
        jPanel5.add(jLabel70);
        jLabel70.setBounds(370, 130, 490, 20);
        jPanel5.add(TxtDireccion);
        TxtDireccion.setBounds(370, 110, 490, 20);

        jLabel67.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 102));
        jLabel67.setText("Medio de Abastecimiento:");
        jPanel5.add(jLabel67);
        jLabel67.setBounds(30, 170, 146, 20);
        jPanel5.add(CbxMedioAbastecimiento);
        CbxMedioAbastecimiento.setBounds(180, 170, 170, 20);

        jLabel141.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(0, 0, 102));
        jLabel141.setText("Cond. Conex:");
        jPanel5.add(jLabel141);
        jLabel141.setBounds(370, 170, 74, 20);
        jPanel5.add(CbxCondicionConexionAgua);
        CbxCondicionConexionAgua.setBounds(450, 170, 170, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 1", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Inmueble(Dirección de Conexión)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 2", jPanel2);

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/save.png"))); // NOI18N
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/cancel.png"))); // NOI18N
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        lblCodigo.setText("0");

        lblIdVia.setText("0");

        lblIdHabitacion.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIdVia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(764, 764, 764)
                        .addComponent(BtnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCancelar))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblIdVia)
                    .addComponent(lblIdHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if(Validar()){
        if(pOperacion==1) {                        
                    CECliente oCECliente = getObjetoSujeto();
                    CDCliente oCDCliente=new CDCliente();
                    if(oCDCliente.registrar(oCECliente)){
                        JOptionPane.showMessageDialog(null,"SE GUARDO DATOS CORRECTAMENTE");                        
                    }else{
                        JOptionPane.showMessageDialog(null,"NO SE GUARDO LOS DATOS");
                    }
                pOperacion=0;                          
        }
        if(pOperacion==2) {                        
                    CECliente oCECliente = getObjetoSujeto();
                    CDCliente oCDCliente=new CDCliente();
                    if(oCDCliente.Actualizar(oCECliente)){
                        JOptionPane.showMessageDialog(null,"SE ACTUALIZO DATOS CORRECTAMENTE");                        
                    }else{
                        JOptionPane.showMessageDialog(null,"NO SE ACTUALIZO LOS DATOS");
                    }
                pOperacion=0;                          
        }}else{
            JOptionPane.showMessageDialog(null, "Revisar que todos los Campos esten Completos");
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
      dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed
    private Boolean Validar(){
       
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JComboBox CbxCondicionConexionAgua;
    private javax.swing.JComboBox CbxMedioAbastecimiento;
    private javax.swing.JComboBox CbxTipoDocumento;
    private javax.swing.JTextField TxtAntiguoCodigoCatastral;
    private javax.swing.JTextField TxtApellidoPaternoPropietario;
    private javax.swing.JTextField TxtCategoria;
    private javax.swing.JTextField TxtCodigoInscripcion;
    private javax.swing.JTextField TxtCorreoElectronico;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtNuevoCodigoCatastral;
    private javax.swing.JTextField TxtNumDocumento;
    private javax.swing.JTextField TxtRutaLectura;
    private javax.swing.JTextField TxtRutaReparto;
    private javax.swing.JTextField TxtSecuencia;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblIdHabitacion;
    private javax.swing.JLabel lblIdVia;
    // End of variables declaration//GEN-END:variables

}
