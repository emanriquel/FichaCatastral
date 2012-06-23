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
        TxtCantidadHabitantesPredio.setText("0");
        TxtNumPisos.setText("0");
        TxtPiso.setText("0");
        TxtNumero.setText("0");
        TxtAntiguoCodigoCatastral.requestFocus();
        
        
        
    }
    private void cargarComboBox(){            
        CDSituacionConexion oCDSituacionConexion=new CDSituacionConexion();
        ArrayList oLstSituacionConexion=oCDSituacionConexion.listarSituacionConexion();
        construirModeloCombo(CbxSituacionConexion, oLstSituacionConexion);
        
        CDTipoDocumento oCDTipoDocumento=new CDTipoDocumento();
        ArrayList oLstTipoDocumento=oCDTipoDocumento.listarTipoDocumento();
        construirModeloCombo(CbxTipoDocumento, oLstTipoDocumento);

        CDTipoPredio oCDTipoPredio=new CDTipoPredio();
        ArrayList oLstTipoPredio=oCDTipoPredio.listarTipoPredio();
        construirModeloCombo(CbxTipoPredio, oLstTipoPredio);

        CDTipoPropiedad oCDTipoPropiedad=new CDTipoPropiedad();
        ArrayList oLstTipoPropiedad=oCDTipoPropiedad.listarTipoPropiedad();
        construirModeloCombo(CbxTipoPropiedad, oLstTipoPropiedad);


        CDUsoPredio oCDUsoPredio=new CDUsoPredio();
        ArrayList oLstUsoPredio=oCDUsoPredio.listarUsoPredio();
        construirModeloCombo(CbxUsoPredio, oLstUsoPredio);

        CDTipoServicio oCDTipoServicio=new CDTipoServicio();
        ArrayList oLstTipoServicio=oCDTipoServicio.listarTipoServicio();
        construirModeloCombo(CbxTipoServicio, oLstTipoServicio);

        CDMedioAbastecimiento oCDMedioAbastecimiento=new CDMedioAbastecimiento();
        ArrayList oLstMedioAbastecimiento=oCDMedioAbastecimiento.listarMedioAbastecimiento();
        construirModeloCombo(CbxMedioAbastecimiento, oLstMedioAbastecimiento);

        CDSituacionPredio oCDSituacionPredio=new CDSituacionPredio();
        ArrayList oLstSituacionPredio=oCDSituacionPredio.listarSituacionPredio();
        construirModeloCombo(CbxSituacionPredio, oLstSituacionPredio);

        CDTipoAlmacenamiento oCDTipoAlmacenamiento=new CDTipoAlmacenamiento();
        ArrayList oLstTipoAlmacenamiento=oCDTipoAlmacenamiento.listarTipoAlmacenamiento();
        construirModeloCombo(CbxTipoAlmacenamiento, oLstTipoAlmacenamiento);

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
         buscarIndexComboSituacionConexion(oCECliente.getIdSituacionConexion());
         buscarIndexComboTipoDocumento(oCECliente.getIdTipoDocumento());
         buscarIndexComboTipoPropiedad(oCECliente.getIdTipoPropiedad());
         buscarIndexComboTipoPredio(oCECliente.getIdTipoPredio());
         buscarIndexComboUsoPredio(oCECliente.getIdUsoPredio());
         buscarIndexComboTipoServicio(oCECliente.getIdTipoServicio());
         buscarIndexComboMedioAbastecimiento(oCECliente.getIdMedioAbastecimiento());
         buscarIndexComboSituacionPredio(oCECliente.getIdSituacionPredio());
         buscarIndexComboTipoAlmacenamiento(oCECliente.getIdTipoAlmacenamiento());
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
         TxtApellidoMaternoPropietario.setText(oCECliente.getApellidoMaternoPropietario());
         TxtNombrePropietario.setText(oCECliente.getNombrePropietario());
         TxtApellidoPaternoConyugue.setText(oCECliente.getApellidopPaternoConyugue());
         TxtApellidoMaternoConyugue.setText(oCECliente.getApellidoMaternoConyugue());
         TxtNombreConyugue.setText(oCECliente.getNombreConyugue());
         TxtCorreoElectronico.setText(oCECliente.getCorreoElectronico());
         TxtCantidadHabitantesPredio.setText(oCECliente.getCantidadHabitantesPredio()+"");
         TxtNumPisos.setText(oCECliente.getNumeroPisos()+"");
         TxtNumMunicipal.setText(oCECliente.getNumMunicipal());
         TxtNumeroManzana.setText(oCECliente.getNumeroManzana());
         TxtNumeroLote.setText(oCECliente.getNumeroLote());
         TxtBlock.setText(oCECliente.getBlock());
         TxtPiso.setText(oCECliente.getPiso()+"");
         TxtNumero.setText(oCECliente.getNumero()+"");
         TxtComplemento.setText(oCECliente.getComplemento());
         lblIdVia.setText(oCECliente.getIdVia()+"");
         lblIdHabitacion.setText(oCECliente.getIdHabilitacion()+"");
         if(oCECliente.getSiNoPredioHabilitado()==1){ ChckSiNoPredioHabilitado.setSelected(true); }else{ ChckSiNoPredioHabilitado.setSelected(false);}
         CargarVia(Integer.parseInt(lblIdVia.getText()));
         CargarHabitacion(Integer.parseInt(lblIdHabitacion.getText()));
     }
    private void CargarVia(int id){
        CEVia oCEVia = new CEVia();
        CDVia oCDVia = new CDVia();
        oCEVia.setIdVia(id);
        CEVia ooCEVia = oCDVia.DetalleVia(oCEVia);
        TxtCodigoVia.setText(ooCEVia.getCodigo()+"");
        TxtTipoVia.setText(ooCEVia.getTipo());
        TxtNombreVia.setText(ooCEVia.getNombreVia());
                    
    }
    private void CargarHabitacion(int id){
        CEHabilitacion oCEHabitacion = new CEHabilitacion();
        CDHabitacion oCDHabitacion = new CDHabitacion();
        oCEHabitacion.setIdHabilitacion(id);
        CEHabilitacion ooCEHabitacion = oCDHabitacion.DetalleVia(oCEHabitacion);
        TxtCodigoHabitacion.setText(oCEHabitacion.getCodigo()+"");
        TxtTipoHabitacion.setText(oCEHabitacion.getTipo());
        TxtNombreHabitacion.setText(oCEHabitacion.getNombreHabilitacion());
                    
    }
    
    private void buscarIndexComboTipoAlmacenamiento(int pId){
      int size=CbxTipoAlmacenamiento.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CETipoAlmacenamiento obj =(CETipoAlmacenamiento)CbxTipoAlmacenamiento.getItemAt(i);
            if(obj.getIdTipoAlmacenamiento()== pId)
                {
                    CbxTipoAlmacenamiento.setSelectedIndex(i);
                    break;
                }
          }
        }
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
    private void buscarIndexComboSituacionPredio(int pId){
      int size=CbxSituacionPredio.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CESituacionPredio obj =(CESituacionPredio)CbxSituacionPredio.getItemAt(i);
            if(obj.getIdSituacionPredio()== pId)
                {
                    CbxSituacionPredio.setSelectedIndex(i);
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
    private void buscarIndexComboTipoServicio(int pId){
      int size=CbxTipoServicio.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CETipoServicio obj =(CETipoServicio)CbxTipoServicio.getItemAt(i);
            if(obj.getIdTipoServicio()== pId)
                {
                    CbxTipoServicio.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
    private void buscarIndexComboUsoPredio(int pId){
      int size=CbxUsoPredio.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CEUsoPredio obj =(CEUsoPredio)CbxUsoPredio.getItemAt(i);
            if(obj.getIdUsoPredio()== pId)
                {
                    CbxUsoPredio.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
    private void buscarIndexComboTipoPredio(int pId){
      int size=CbxTipoPredio.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CETipoPredio obj =(CETipoPredio)CbxTipoPredio.getItemAt(i);
            if(obj.getIdTipoPredio()== pId)
                {
                    CbxTipoPredio.setSelectedIndex(i);
                    break;
                }
          }
        }
      }
    private void buscarIndexComboTipoPropiedad(int pId){
      int size=CbxTipoPropiedad.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CETipoPropiedad obj =(CETipoPropiedad)CbxTipoPropiedad.getItemAt(i);
            if(obj.getIdTipoPropiedad()== pId)
                {
                    CbxTipoPropiedad.setSelectedIndex(i);
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
    private void buscarIndexComboSituacionConexion(int pId){
      int size=CbxSituacionConexion.getItemCount();
      if(size>0)
      {
          for(int i=1;i<size;i++)
          {
            CESituacionConexion obj =(CESituacionConexion)CbxSituacionConexion.getItemAt(i);
            if(obj.getIdSituacionConexion()== pId)
                {
                    CbxSituacionConexion.setSelectedIndex(i);
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
        CESituacionConexion oCESituacionConexion =(CESituacionConexion)CbxSituacionConexion.getSelectedItem();
        oCECliente.setIdSituacionConexion(oCESituacionConexion.getIdSituacionConexion());
        
        oCECliente.setAntiguoCodigoCatastral(TxtAntiguoCodigoCatastral.getText());
        oCECliente.setNuevoCodigoCatastral(TxtNuevoCodigoCatastral.getText());
        oCECliente.setNumeroInscripcion(TxtCodigoInscripcion.getText());
        oCECliente.setRutaLectura(TxtRutaLectura.getText());
        oCECliente.setRutaReparto(TxtRutaReparto.getText());
        oCECliente.setSecuencia(TxtSecuencia.getText());
        oCECliente.setCategoria(TxtCategoria.getText());
        oCECliente.setNumMunicipal(TxtNumMunicipal.getText());
        
        CETipoDocumento oCETipoDocumento =(CETipoDocumento)CbxTipoDocumento.getSelectedItem();
        oCECliente.setIdTipoDocumento(oCETipoDocumento.getIdTipoDocumento());
        
        oCECliente.setNumeroDocumento(TxtNumDocumento.getText());
        oCECliente.setTelefono(TxtTelefono.getText());
        oCECliente.setApellidoPaternoPropietario(TxtApellidoPaternoPropietario.getText());
        oCECliente.setApellidoMaternoPropietario(TxtApellidoMaternoPropietario.getText());
        oCECliente.setNombrePropietario(TxtNombrePropietario.getText());
        oCECliente.setApellidopPaternoConyugue(TxtApellidoPaternoConyugue.getText());
        oCECliente.setApellidoMaternoConyugue(TxtApellidoMaternoConyugue.getText());
        oCECliente.setNombreConyugue(TxtNombreConyugue.getText());
        oCECliente.setCorreoElectronico(TxtCorreoElectronico.getText());
        
        CETipoPropiedad oCETipoPropiedad =(CETipoPropiedad)CbxTipoPropiedad.getSelectedItem();
        oCECliente.setIdTipoPropiedad(oCETipoPropiedad.getIdTipoPropiedad());

        CECondicionConexionAgua oCECondicionConexionAgua =(CECondicionConexionAgua)CbxCondicionConexionAgua.getSelectedItem();
        oCECliente.setIdCondicionConexionAgua(oCECondicionConexionAgua.getIdCondicionConexionAgua());

        oCECliente.setCantidadHabitantesPredio(Integer.parseInt(TxtCantidadHabitantesPredio.getText()));
        oCECliente.setNumeroPisos(Integer.parseInt(TxtNumPisos.getText()));
        
        CETipoPredio oCETipoPredio =(CETipoPredio)CbxTipoPredio.getSelectedItem();
        oCECliente.setIdTipoPredio(oCETipoPredio.getIdTipoPredio());
        
        
        oCECliente.setIdVia(Integer.parseInt(lblIdVia.getText()));
        oCECliente.setNumeroMunicipal(TxtNumMunicipal.getText());
        oCECliente.setIdHabilitacion(Integer.parseInt(lblIdHabitacion.getText()));
        
        oCECliente.setNumeroManzana(TxtNumeroManzana.getText());
        oCECliente.setNumeroLote(TxtNumeroLote.getText());
        oCECliente.setBlock(TxtBlock.getText());
        oCECliente.setPiso(Integer.parseInt(TxtPiso.getText()));
        oCECliente.setNumero(Integer.parseInt(TxtNumero.getText()));
        
        CEUsoPredio oCEUsoPredio =(CEUsoPredio)CbxUsoPredio.getSelectedItem();
        oCECliente.setIdUsoPredio(oCEUsoPredio.getIdUsoPredio());
        
        oCECliente.setComplemento(TxtComplemento.getText());
        if(ChckSiNoPredioHabilitado.isSelected()){
            oCECliente.setSiNoPredioHabilitado(1);
        }else{ oCECliente.setSiNoPredioHabilitado(0); }
        
        CETipoServicio oCETipoServicio =(CETipoServicio)CbxTipoServicio.getSelectedItem();
        oCECliente.setIdTipoServicio(oCETipoServicio.getIdTipoServicio());
        
        CEMedioAbastecimiento oCEMedioAbastecimiento =(CEMedioAbastecimiento)CbxMedioAbastecimiento.getSelectedItem();
        oCECliente.setIdMedioAbastecimiento(oCEMedioAbastecimiento.getIdMedioAbastecimiento());
        CESituacionPredio oCESituacionPredio =(CESituacionPredio)CbxSituacionPredio.getSelectedItem();
        oCECliente.setIdSituacionPredio(oCESituacionPredio.getIdSituacionPredio());
        CETipoAlmacenamiento oCETipoAlmacenamiento =(CETipoAlmacenamiento)CbxTipoAlmacenamiento.getSelectedItem();
        oCECliente.setIdTipoAlmacenamiento(oCETipoAlmacenamiento.getIdTipoAlmacenamiento());
        
        
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
        TxtApellidoMaternoPropietario = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        TxtNombrePropietario = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        CbxTipoDocumento = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        TxtCorreoElectronico = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        TxtApellidoPaternoConyugue = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        TxtApellidoMaternoConyugue = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        TxtNombreConyugue = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        TxtNumDocumento = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        CbxTipoPropiedad = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        TxtCantidadHabitantesPredio = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        TxtNumPisos = new javax.swing.JTextField();
        CbxTipoPredio = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        TxtNumeroManzana = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        TxtComplemento = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        TxtBlock = new javax.swing.JTextField();
        TxtPiso = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        TxtNumero = new javax.swing.JTextField();
        CbxUsoPredio = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        TxtNumeroLote = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        CbxTipoServicio = new javax.swing.JComboBox();
        jLabel67 = new javax.swing.JLabel();
        CbxMedioAbastecimiento = new javax.swing.JComboBox();
        CbxSituacionPredio = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        ChckSiNoPredioHabilitado = new javax.swing.JCheckBox();
        TxtNombreHabitacion = new javax.swing.JTextField();
        TxtCodigoHabitacion = new javax.swing.JTextField();
        TxtTipoHabitacion = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        TxtNumMunicipal = new javax.swing.JTextField();
        TxtCodigoVia = new javax.swing.JTextField();
        TxtNombreVia = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        TxtTipoVia = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        CbxTipoAlmacenamiento = new javax.swing.JComboBox();
        jLabel141 = new javax.swing.JLabel();
        CbxCondicionConexionAgua = new javax.swing.JComboBox();
        CbxSituacionConexion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblIdVia = new javax.swing.JLabel();
        lblIdHabitacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Apellido Paterno del Propietario");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel43.setForeground(new java.awt.Color(0, 0, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Apellido Materno del Propietario");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel43.setOpaque(true);

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel44.setForeground(new java.awt.Color(0, 0, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Nombre del Propietario");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel44.setOpaque(true);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("Num. Documento:");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setText("Correo Electrónico:");

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("Telefono:");

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel48.setForeground(new java.awt.Color(0, 0, 102));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Apellido Paterno del Conyugue");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel48.setOpaque(true);

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Apellido Materno del Conyugue");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel50.setOpaque(true);

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Nombre del Conyugue");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel51.setOpaque(true);

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("Tipo de Documento:");

        jLabel53.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel53.setForeground(new java.awt.Color(0, 0, 102));
        jLabel53.setText("Tipo Propiedad:");

        jLabel54.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel54.setForeground(new java.awt.Color(0, 0, 102));
        jLabel54.setText("Cant. Habitantes del Predio:");

        jLabel55.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel55.setForeground(new java.awt.Color(0, 0, 102));
        jLabel55.setText("Num. Pisos:");

        jLabel56.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel56.setForeground(new java.awt.Color(0, 0, 102));
        jLabel56.setText("Tipo Predio:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(8, 8, 8)
                        .addComponent(CbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel45)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel47)
                        .addGap(8, 8, 8)
                        .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtApellidoMaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtApellidoMaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNombreConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(11, 11, 11)
                        .addComponent(TxtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel53)
                        .addGap(32, 32, 32)
                        .addComponent(CbxTipoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtCantidadHabitantesPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtNumPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel56)
                        .addGap(13, 13, 13)
                        .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtApellidoPaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoMaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtApellidoPaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoMaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombreConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCantidadHabitantesPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 1", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Inmueble(Dirección de Conexión)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel49.setForeground(new java.awt.Color(0, 0, 102));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText(" Num. Mz.");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel49.setOpaque(true);

        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
        jLabel60.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel60.setForeground(new java.awt.Color(0, 0, 102));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText(" Num. Lote");
        jLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel60.setOpaque(true);

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel61.setForeground(new java.awt.Color(0, 0, 102));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Block");
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel61.setOpaque(true);

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel62.setForeground(new java.awt.Color(0, 0, 102));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Piso");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel62.setOpaque(true);

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel63.setForeground(new java.awt.Color(0, 0, 102));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Número");
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel63.setOpaque(true);

        jLabel64.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel64.setForeground(new java.awt.Color(0, 0, 102));
        jLabel64.setText("Complemento:");

        jLabel65.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel65.setForeground(new java.awt.Color(0, 0, 102));
        jLabel65.setText("Uso del Predio:");

        jLabel66.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel66.setForeground(new java.awt.Color(0, 0, 102));
        jLabel66.setText("Tipo Servicio:");

        jLabel67.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel67.setForeground(new java.awt.Color(0, 0, 102));
        jLabel67.setText("Medio de Abastecimiento:");

        jLabel68.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel68.setForeground(new java.awt.Color(0, 0, 102));
        jLabel68.setText("¿Predio Habilitado?:");

        jLabel69.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel69.setForeground(new java.awt.Color(0, 0, 102));
        jLabel69.setText("Situación del Predio:");

        TxtNombreHabitacion.setEnabled(false);

        TxtCodigoHabitacion.setEditable(false);
        TxtCodigoHabitacion.setEnabled(false);

        TxtTipoHabitacion.setEditable(false);
        TxtTipoHabitacion.setEnabled(false);

        jLabel33.setBackground(new java.awt.Color(204, 204, 204));
        jLabel33.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel33.setForeground(new java.awt.Color(0, 0, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Nombre Habilitación");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel33.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel34.setForeground(new java.awt.Color(0, 0, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Tipo Habilitación");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel34.setOpaque(true);

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel35.setForeground(new java.awt.Color(0, 0, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Código de Vía");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel35.setOpaque(true);

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Código Habilitación");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setOpaque(true);

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel70.setBackground(new java.awt.Color(204, 204, 204));
        jLabel70.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel70.setForeground(new java.awt.Color(0, 0, 102));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Num. Municipal");
        jLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel70.setOpaque(true);

        TxtCodigoVia.setEnabled(false);

        TxtNombreVia.setEnabled(false);

        jLabel71.setBackground(new java.awt.Color(204, 204, 204));
        jLabel71.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel71.setForeground(new java.awt.Color(0, 0, 102));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Nombre de Vía");
        jLabel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel71.setOpaque(true);

        TxtTipoVia.setEnabled(false);

        jLabel72.setBackground(new java.awt.Color(204, 204, 204));
        jLabel72.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel72.setForeground(new java.awt.Color(0, 0, 102));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Tipo de Vía");
        jLabel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel72.setOpaque(true);

        jLabel135.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel135.setForeground(new java.awt.Color(0, 0, 102));
        jLabel135.setText("Tipo Almacenamiento:");

        jLabel141.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(0, 0, 102));
        jLabel141.setText("Cond. Conex:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(TxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(ChckSiNoPredioHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addGap(14, 14, 14)
                                        .addComponent(CbxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel67)
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CbxCondicionConexionAgua, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CbxMedioAbastecimiento, javax.swing.GroupLayout.Alignment.TRAILING, 0, 160, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(CbxSituacionPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(20, 20, 20)
                                            .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(20, 20, 20)
                                            .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(20, 20, 20)
                                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(20, 20, 20)
                                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtCodigoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtNombreHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(TxtNumeroManzana, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(TxtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(TxtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TxtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel65)
                                .addGap(5, 5, 5)
                                .addComponent(CbxUsoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel135)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxTipoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(167, 167, 167))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TxtCodigoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TxtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TxtNombreHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtNumeroManzana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxUsoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoPredioHabilitado))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxMedioAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSituacionPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbxTipoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbxCondicionConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Situación de Conexión:");

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
                        .addComponent(BtnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxSituacionConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblIdHabitacion)
                    .addComponent(CbxSituacionConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FiltrarHabilitacion oFiltrarHabilitacion = new FiltrarHabilitacion(null, true,1,"");
        oFiltrarHabilitacion.setLocationRelativeTo(null);
        oFiltrarHabilitacion.setVisible(true);
        CEHabilitacion oCEHabitacion = oFiltrarHabilitacion.GetHabilitacion();
        lblIdHabitacion.setText(oCEHabitacion.getIdHabitacion()+"");
        TxtCodigoHabitacion.setText(oCEHabitacion.getCodigo()+"");
        TxtTipoHabitacion.setText(oCEHabitacion.getTipo());
        TxtNombreHabitacion.setText(oCEHabitacion.getNombreHabilitacion());
               
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FiltrarVia oFiltrarVia = new FiltrarVia(null, true,"");
        oFiltrarVia.setLocationRelativeTo(null);
        oFiltrarVia.setVisible(true);
        CEVia oCEVia = oFiltrarVia.GetVia();
        lblIdVia.setText(oCEVia.getIdVia()+"");
        TxtCodigoVia.setText(oCEVia.getCodigo()+"");
        TxtTipoVia.setText(oCEVia.getTipo());
        TxtNombreVia.setText(oCEVia.getNombreVia());
    }//GEN-LAST:event_jButton6ActionPerformed

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
        if("0".equals(lblIdHabitacion.getText())||"0".equals(lblIdVia.getText())){
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JComboBox CbxCondicionConexionAgua;
    private javax.swing.JComboBox CbxMedioAbastecimiento;
    private javax.swing.JComboBox CbxSituacionConexion;
    private javax.swing.JComboBox CbxSituacionPredio;
    private javax.swing.JComboBox CbxTipoAlmacenamiento;
    private javax.swing.JComboBox CbxTipoDocumento;
    private javax.swing.JComboBox CbxTipoPredio;
    private javax.swing.JComboBox CbxTipoPropiedad;
    private javax.swing.JComboBox CbxTipoServicio;
    private javax.swing.JComboBox CbxUsoPredio;
    private javax.swing.JCheckBox ChckSiNoPredioHabilitado;
    private javax.swing.JTextField TxtAntiguoCodigoCatastral;
    private javax.swing.JTextField TxtApellidoMaternoConyugue;
    private javax.swing.JTextField TxtApellidoMaternoPropietario;
    private javax.swing.JTextField TxtApellidoPaternoConyugue;
    private javax.swing.JTextField TxtApellidoPaternoPropietario;
    private javax.swing.JTextField TxtBlock;
    private javax.swing.JTextField TxtCantidadHabitantesPredio;
    private javax.swing.JTextField TxtCategoria;
    private javax.swing.JTextField TxtCodigoHabitacion;
    private javax.swing.JTextField TxtCodigoInscripcion;
    private javax.swing.JTextField TxtCodigoVia;
    private javax.swing.JTextField TxtComplemento;
    private javax.swing.JTextField TxtCorreoElectronico;
    private javax.swing.JTextField TxtNombreConyugue;
    private javax.swing.JTextField TxtNombreHabitacion;
    private javax.swing.JTextField TxtNombrePropietario;
    private javax.swing.JTextField TxtNombreVia;
    private javax.swing.JTextField TxtNuevoCodigoCatastral;
    private javax.swing.JTextField TxtNumDocumento;
    private javax.swing.JTextField TxtNumMunicipal;
    private javax.swing.JTextField TxtNumPisos;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtNumeroLote;
    private javax.swing.JTextField TxtNumeroManzana;
    private javax.swing.JTextField TxtPiso;
    private javax.swing.JTextField TxtRutaLectura;
    private javax.swing.JTextField TxtRutaReparto;
    private javax.swing.JTextField TxtSecuencia;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTipoHabitacion;
    private javax.swing.JTextField TxtTipoVia;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
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
