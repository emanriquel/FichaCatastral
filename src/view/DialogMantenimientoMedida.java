package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import modelo.datos.CDCondicionConexionAgua;
import modelo.datos.CDCondicionConexionDesague;
import modelo.datos.CDDiametroConexionAgua;
import modelo.datos.CDDiametroConexionDesague;
import modelo.datos.CDDiametroMedidor;
import modelo.datos.CDEstadoCajaAgua;
import modelo.datos.CDEstadoCajaDesague;
import modelo.datos.CDEstadoMedidor;
import modelo.datos.CDEstadoTapaAgua;
import modelo.datos.CDEstadoTapaDesague;
import modelo.datos.CDLlavesPaso;
import modelo.datos.CDMaterialCajaAgua;
import modelo.datos.CDMaterialCajaDesague;
import modelo.datos.CDMaterialConexionAgua;
import modelo.datos.CDMaterialConexionDesague;
import modelo.datos.CDMaterialTapaAgua;
import modelo.datos.CDMaterialTapaDesague;
import modelo.datos.CDMedida;
import modelo.datos.CDMedioAbastecimiento;
import modelo.datos.CDParametro;
import modelo.datos.CDPavimentacion;
import modelo.datos.CDPosicionMedidor;
import modelo.datos.CDPozoArtesanal;
import modelo.datos.CDSeguridadMedidor;
import modelo.datos.CDSituacionAgua;
import modelo.datos.CDSituacionConexion;
import modelo.datos.CDSituacionPredio;
import modelo.datos.CDTipoAlmacenamiento;
import modelo.datos.CDTipoDocumento;
import modelo.datos.CDTipoPredio;
import modelo.datos.CDTipoPropiedad;
import modelo.datos.CDTipoPropiedadInquilino;
import modelo.datos.CDTipoServicio;
import modelo.datos.CDUbiCajaConexAgua;
import modelo.datos.CDUbiCajaConexDesague;
import modelo.datos.CDUsoPredio;
import modelo.datos.CDVereda;
import modelo.entidad.CECliente;
import modelo.entidad.CECondicionConexionAgua;
import modelo.entidad.CECondicionConexionDesague;
import modelo.entidad.CEDiametroConexionAgua;
import modelo.entidad.CEDiametroConexionDesague;
import modelo.entidad.CEDiametroMedidor;
import modelo.entidad.CEEstadoCajaAgua;
import modelo.entidad.CEEstadoCajaDesague;
import modelo.entidad.CEEstadoMedidor;
import modelo.entidad.CEEstadoTapaAgua;
import modelo.entidad.CEEstadoTapaDesague;
import modelo.entidad.CEHabilitacion;
import modelo.entidad.CELlavesPaso;
import modelo.entidad.CEMaterialCajaAgua;
import modelo.entidad.CEMaterialCajaDesague;
import modelo.entidad.CEMaterialConexionAgua;
import modelo.entidad.CEMaterialConexionDesague;
import modelo.entidad.CEMaterialTapaAgua;
import modelo.entidad.CEMaterialTapaDesague;
import modelo.entidad.CEMedida;
import modelo.entidad.CEMedioAbastecimiento;
import modelo.entidad.CEPavimentacion;
import modelo.entidad.CEPosicionMedidor;
import modelo.entidad.CEPozoArtesanal;
import modelo.entidad.CESeguridadMedidor;
import modelo.entidad.CESituacionAgua;
import modelo.entidad.CESituacionConexion;
import modelo.entidad.CESituacionPredio;
import modelo.entidad.CETipoAlmacenamiento;
import modelo.entidad.CETipoDocumento;
import modelo.entidad.CETipoPredio;
import modelo.entidad.CETipoPropiedad;
import modelo.entidad.CETipoPropiedadInquilino;
import modelo.entidad.CETipoServicio;
import modelo.entidad.CEUbiCajaConexAgua;
import modelo.entidad.CEUbiCajaConexDesague;
import modelo.entidad.CEUsoPredio;
import modelo.entidad.CEUsos;
import modelo.entidad.CEVereda;
import modelo.entidad.CEVia;
import util.ArrayListComboBoxModel;
import util.ConvertidorFecha;

public class DialogMantenimientoMedida extends javax.swing.JDialog {

    private int codigo;
    private int IdRegistroMedida;
    private boolean cargo=false;
    ArrayList<CEUsos> oLstUsosEliminados =new ArrayList<CEUsos>();
    public DialogMantenimientoMedida(java.awt.Frame parent, boolean modal,int codigo,CEMedida oCEMedida) {
        super(parent, modal);
        initComponents();

        Container con = this.getContentPane();
	con.setBackground( new Color(204,204,204 ));
        cargarComboBox();
        cargarEventoTablaGrupos(TblUsos);
        this.codigo=codigo;
        TxtDepartamento.requestFocus();
        RbtOpcionAntes.setEnabled(false);
        RbtOpcionDespues.setEnabled(false);
        RbtOpcionIndeterminado.setEnabled(false);
        TxtNumeroFicha.setText((new CDParametro()).generarNumeroFicha());
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addPropertyChangeListener(
        new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                String prop = e.getPropertyName();
                if (("focusOwner".equals(prop)) &&
                      ((e.getNewValue()) instanceof JTextField))
                      {
                         ((JTextField)(e.getNewValue())).setForeground(Color.BLUE);
                      }
                 else
                {
                   if(e.getOldValue() instanceof JTextField)
                      {
                         ((JTextField)(e.getOldValue())).setForeground(Color.BLACK);
                      }
                }
               if (("focusOwner".equals(prop)) &&
                      ((e.getNewValue()) instanceof JComboBox))
                      {
                         ((JComboBox)(e.getNewValue())).setForeground(Color.BLUE);
                      }
                 else
                {
                   if(e.getOldValue() instanceof JComboBox)
                      {
                         ((JComboBox)(e.getOldValue())).setForeground(Color.BLACK);
                      }
                }
               
            }
        }
    );
        if(codigo==3){
            setMedida((new CDMedida()).ConsultarMedida(oCEMedida.getIdRegistroMedida()));
            BtnGuardar.setVisible(false);
            BtnCancelar.setVisible(false);
        }
        else{
            if(codigo==2)
            {
                setMedida((new CDMedida()).ConsultarMedida(oCEMedida.getIdRegistroMedida()));
                this.IdRegistroMedida=oCEMedida.getIdRegistroMedida();
            }
        }
        cargo=true;
    }
     private void cargarEventoTablaGrupos(final JTable tbl)
    {
        ((DefaultTableModel)tbl.getModel()).addTableModelListener(
         new TableModelListener()
          {
            public void tableChanged(TableModelEvent tme)
              {
                  {
                    if(tme.getType()==tme.UPDATE)
                    {
                        if(tme.getColumn()==7)
                        {
                            int suma=0;
                            for(int i=0;i<TblUsos.getRowCount();i++)
                            {
                                if(TblUsos.getValueAt(i,7)!=null)
                                {
                                int cant=Integer.parseInt(TblUsos.getValueAt(i,7).toString());
                                suma=cant+suma;
                                }
                                else
                                {
                                suma=0+suma;
                                }
                            }
                            TxtCantidadHabitantesPredio.setText(suma+"");
                        }
                    }
                  }
               }
          });

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

    CDDiametroMedidor oCDDiametroMedidor=new CDDiametroMedidor();
    ArrayList oLstDiametroMedidor=oCDDiametroMedidor.listarDiametroMedidor();
    construirModeloCombo(CbxDiametroMedidor, oLstDiametroMedidor);

    CDEstadoMedidor oCDEstadoMedidor=new CDEstadoMedidor();
    ArrayList oLstEstadoMedidor=oCDEstadoMedidor.listarEstadoMedidor();
    construirModeloCombo(CbxEstadoMedidor, oLstEstadoMedidor);

    CDLlavesPaso oCDLlavesPaso=new CDLlavesPaso();
    ArrayList oLstLlavesPaso=oCDLlavesPaso.listarLlavesPaso();
    construirModeloCombo(CbxLlavesPaso, oLstLlavesPaso);

    CDSeguridadMedidor oCDSeguridadMedidor=new CDSeguridadMedidor();
    ArrayList oLstSeguridadMedidor=oCDSeguridadMedidor.listarSeguridadMedidor();
    construirModeloCombo(CbxSeguridadMedidor, oLstSeguridadMedidor);

    CDPosicionMedidor oCDPosicionMedidor=new CDPosicionMedidor();
    ArrayList oLstPosicionMedidor=oCDPosicionMedidor.listarPosicionMedidor();
    construirModeloCombo(CbxPosicionMedidor, oLstPosicionMedidor);

    CDSituacionAgua oCDSituacionAgua=new CDSituacionAgua();
    ArrayList oLstSituacionAgua=oCDSituacionAgua.listarSituacionAgua();
    construirModeloCombo(CbxSituacionAgua, oLstSituacionAgua);

    CDUbiCajaConexAgua oCDUbiCajaConexAgua=new CDUbiCajaConexAgua();
    ArrayList oLstUbiCajaConexAgua=oCDUbiCajaConexAgua.listarUbiCajaConexAgua();
    construirModeloCombo(CbxUbiCajaConexAgua, oLstUbiCajaConexAgua);

    CDDiametroConexionAgua oCDDiametroConexionAgua=new CDDiametroConexionAgua();
    ArrayList oLstDiametroConexionAgua=oCDDiametroConexionAgua.listarDiametroConexionAgua();
    construirModeloCombo(CbxDiametroConexionAgua, oLstDiametroConexionAgua);

    CDCondicionConexionAgua oCDCondicionConexionAgua=new CDCondicionConexionAgua();
    ArrayList oLstCondicionConexionAgua=oCDCondicionConexionAgua.listarCondicionConexionAgua();
    construirModeloCombo(CbxCondicionConexionAgua, oLstCondicionConexionAgua);

    CDMaterialCajaAgua oCDMaterialCajaAgua=new CDMaterialCajaAgua();
    ArrayList oLstMaterialCajaAgua=oCDMaterialCajaAgua.listarMaterialCajaAgua();
    construirModeloCombo(CbxMaterialCajaAgua, oLstMaterialCajaAgua);

    CDEstadoCajaAgua oCDEstadoCajaAgua=new CDEstadoCajaAgua();
    ArrayList oLstEstadoCajaAgua=oCDEstadoCajaAgua.listarEstadoCajaAgua();
    construirModeloCombo(CbxEstadoCajaAgua, oLstEstadoCajaAgua);

    CDUbiCajaConexDesague oCDUbiCajaConexDesague=new CDUbiCajaConexDesague();
    ArrayList oLstUbiCajaConexDesague=oCDUbiCajaConexDesague.listarUbiCajaConexDesague();
    construirModeloCombo(CbxUbiCajaConexDesague, oLstUbiCajaConexDesague);

    CDDiametroConexionDesague oCDDiametroConexionDesague=new CDDiametroConexionDesague();
    ArrayList oLstDiametroConexionDesague=oCDDiametroConexionDesague.listarDiametroConexionDesague();
    construirModeloCombo(CbxDiametroConexionDesague, oLstDiametroConexionDesague);

    CDCondicionConexionDesague oCDCondicionConexionDesague=new CDCondicionConexionDesague();
    ArrayList oLstCondicionConexionDesague=oCDCondicionConexionDesague.listarCondicionConexionDesague();
    construirModeloCombo(CbxCondicionConexDesague, oLstCondicionConexionDesague);

    CDMaterialCajaDesague oCDMaterialCajaDesague=new CDMaterialCajaDesague();
    ArrayList oLstMaterialCajaDesague=oCDMaterialCajaDesague.listarMaterialCajaDesague();
    construirModeloCombo(CbxMaterialCajaDesague, oLstMaterialCajaDesague);

    CDMaterialTapaDesague oCDMaterialTapaDesague=new CDMaterialTapaDesague();
    ArrayList oLstMaterialTapaDesague=oCDMaterialTapaDesague.listarMaterialTapaDesague();
    construirModeloCombo(CbxMaterialTapaDesague, oLstMaterialTapaDesague);

    CDEstadoTapaAgua oCDEstadoTapaAgua=new CDEstadoTapaAgua();
    ArrayList oLstEstadoTapaAgua=oCDEstadoTapaAgua.listarEstadoTapaAgua();
    construirModeloCombo(CbxEstadoTapaAgua, oLstEstadoTapaAgua);

    CDMaterialTapaAgua oCDMaterialTapaAgua=new CDMaterialTapaAgua();
    ArrayList oLstMaterialTapaAgua=oCDMaterialTapaAgua.listarMaterialTapaAgua();
    construirModeloCombo(CbxMaterialTapaAgua, oLstMaterialTapaAgua);

    CDEstadoTapaDesague oCDEstadoTapaDesague=new CDEstadoTapaDesague();
    ArrayList oLstEstadoTapaDesague=oCDEstadoTapaDesague.listarEstadoTapaDesague();
    construirModeloCombo(CbxEstadoTapaDesague, oLstEstadoTapaDesague);

    CDEstadoCajaDesague oCDEstadoCajaDesague=new CDEstadoCajaDesague();
    ArrayList oLstEstadoCajaDesague=oCDEstadoCajaDesague.listarEstadoCajaDesague();
    construirModeloCombo(CbxEstadoCajaDesague, oLstEstadoCajaDesague);

    CDPavimentacion oCDPavimentacion=new CDPavimentacion();
    ArrayList oLstPavimentacion=oCDPavimentacion.listarPavimentacion();
    construirModeloCombo(CbxPavimentacion, oLstPavimentacion);

    CDVereda oCDVereda=new CDVereda();
    ArrayList oLstVereda=oCDVereda.listarVereda();
    construirModeloCombo(CbxVereda, oLstVereda);

    CDPozoArtesanal oCDPozoArtesanal=new CDPozoArtesanal();
    ArrayList oLstPozoArtesanal=oCDPozoArtesanal.listarPozoArtesenal();
    construirModeloCombo(CbxPozoArtesanal, oLstPozoArtesanal);

    CDTipoPropiedadInquilino oCDTipoPropiedadInquilino=new CDTipoPropiedadInquilino();
    ArrayList oLstTipoPropiedadInquilino=oCDTipoPropiedadInquilino.listarTipoPropiedadInquilino();
    construirModeloCombo(CbxTipoPropiedadEntrevistado, oLstTipoPropiedadInquilino);

    CDTipoAlmacenamiento oCDTipoAlmacenamiento=new CDTipoAlmacenamiento();
    ArrayList oLstTipoAlmacenamiento=oCDTipoAlmacenamiento.listarTipoAlmacenamiento();
    construirModeloCombo(CbxTipoAlmacenamiento, oLstTipoAlmacenamiento);

    CDMaterialConexionAgua oCDMaterialConexionAgua=new CDMaterialConexionAgua();
    ArrayList oLstMaterialConexionAgua=oCDMaterialConexionAgua.listarMaterialConexionAgua();
    construirModeloCombo(CbxMaterialConexionAgua, oLstMaterialConexionAgua);

    CDMaterialConexionDesague oCDMaterialConexionDesague=new CDMaterialConexionDesague();
    ArrayList oLstMaterialConexionDesague=oCDMaterialConexionDesague.listarMaterialConexionDesague();
    construirModeloCombo(CbxMaterialConexionDesague, oLstMaterialConexionDesague);

    }
    private void construirModeloCombo(JComboBox oBox, ArrayList oLista)
    {
        ArrayListComboBoxModel model = new ArrayListComboBoxModel( oLista ) ;
        oBox.setModel(model);
        oBox.setSelectedIndex(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNumeroFicha = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        CbxSituacionConexion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TxtDepartamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtProvincia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtDistrito = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtSeccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtManzana = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtLote = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtConexion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtCodigoInscripcion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtRutaLectura = new javax.swing.JTextField();
        TxtRutaReparto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TxtSecuencia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TxtCategoria = new javax.swing.JTextField();
        BtnBuscarUsuario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        TxtApellidoPaternoPropietario = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TxtApellidoMaternoPropietario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TxtNombrePropietario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        CbxTipoDocumento = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        TxtCorreoElectronico = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        TxtApellidoPaternoConyugue = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        TxtApellidoMaternoConyugue = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TxtNombreConyugue = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        TxtNumDocumento = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CbxTipoPropiedad = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        TxtCantidadHabitantesPredio = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TxtNumPisos = new javax.swing.JTextField();
        CbxTipoPredio = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        TxtNumeroManzana = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        TxtComplemento = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        TxtBlock = new javax.swing.JTextField();
        TxtPiso = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        TxtNumero = new javax.swing.JTextField();
        CbxUsoPredio = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        TxtNumeroLote = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        CbxTipoServicio = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        CbxMedioAbastecimiento = new javax.swing.JComboBox();
        CbxSituacionPredio = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        ChckSiNoPredioHabilitado = new javax.swing.JCheckBox();
        TxtNombreHabilitacion = new javax.swing.JTextField();
        TxtCodigoHabilitacion = new javax.swing.JTextField();
        TxtTipoHabilitacion = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        BtnHabilitacion = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        BtnVia = new javax.swing.JButton();
        TxtCodigoVia = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TxtNumMunicipal = new javax.swing.JTextField();
        TxtNombreVia = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        TxtTipoVia = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        CbxTipoAlmacenamiento = new javax.swing.JComboBox();
        jLabel139 = new javax.swing.JLabel();
        LblDireccion = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        LblTipoServicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblUsos = new javax.swing.JTable();
        BtnAgregarUso = new javax.swing.JButton();
        BtnEliminarUso = new javax.swing.JButton();
        TxtPorcentajeDomestico = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        TxtPorcentajeComercial = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        TxtPorcentajeEstatal = new javax.swing.JTextField();
        TxtPorcentajeSocial = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        TxtNumeroMedidor = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        CbxDiametroMedidor = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        ChkSiNoIlegibleNumeroMedidor = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        ChkSiNoMedidor = new javax.swing.JCheckBox();
        TxtLecturaMedidor = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        ChckSiNoIlegibleLecturaMedidor = new javax.swing.JCheckBox();
        jLabel75 = new javax.swing.JLabel();
        TxtMarcaMedidor = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        CbxEstadoMedidor = new javax.swing.JComboBox();
        CbxLlavesPaso = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        CbxSeguridadMedidor = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        CbxPosicionMedidor = new javax.swing.JComboBox();
        jLabel78 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        CbxSituacionAgua = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        CbxUbiCajaConexAgua = new javax.swing.JComboBox();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        CbxDiametroConexionAgua = new javax.swing.JComboBox();
        CbxCondicionConexionAgua = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        CbxMaterialCajaAgua = new javax.swing.JComboBox();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        ChckSiNoTapaConexionAgua = new javax.swing.JCheckBox();
        ChckSiNoFugaAgua = new javax.swing.JCheckBox();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        RbtOpcionAntes = new javax.swing.JRadioButton();
        RbtOpcionDespues = new javax.swing.JRadioButton();
        RbtOpcionIndeterminado = new javax.swing.JRadioButton();
        jLabel141 = new javax.swing.JLabel();
        LblCondicionConexion = new javax.swing.JLabel();
        CbxEstadoCajaAgua = new javax.swing.JComboBox();
        CbxMaterialTapaAgua = new javax.swing.JComboBox();
        jLabel136 = new javax.swing.JLabel();
        CbxEstadoTapaAgua = new javax.swing.JComboBox();
        jLabel137 = new javax.swing.JLabel();
        LblCondicionConexionConsulta = new javax.swing.JLabel();
        CbxMaterialConexionAgua = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        CbxUbiCajaConexDesague = new javax.swing.JComboBox();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        CbxDiametroConexionDesague = new javax.swing.JComboBox();
        CbxCondicionConexDesague = new javax.swing.JComboBox();
        jLabel96 = new javax.swing.JLabel();
        CbxMaterialCajaDesague = new javax.swing.JComboBox();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        CbxEstadoTapaDesague = new javax.swing.JComboBox();
        CbxMaterialTapaDesague = new javax.swing.JComboBox();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        CbxEstadoCajaDesague = new javax.swing.JComboBox();
        jLabel142 = new javax.swing.JLabel();
        ChckSiNoTapaConexionDesague = new javax.swing.JCheckBox();
        jLabel143 = new javax.swing.JLabel();
        CbxMaterialConexionDesague = new javax.swing.JComboBox();
        jLabel144 = new javax.swing.JLabel();
        ChckSiNoFugaDesague = new javax.swing.JCheckBox();
        jLabel145 = new javax.swing.JLabel();
        RbtOpcionConCaja = new javax.swing.JRadioButton();
        RbtOpcionNoDeterminado = new javax.swing.JRadioButton();
        LblCondicionConexionDesague = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        RbtOpcionSinCaja = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        CbxPavimentacion = new javax.swing.JComboBox();
        jLabel94 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        CbxVereda = new javax.swing.JComboBox();
        CbxPozoArtesanal = new javax.swing.JComboBox();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        TxtHorasPorDia = new javax.swing.JTextField();
        TxtDiaPorSemana = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtObservaciones = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        TxtApellidoPaternoEntrevistado = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        TxtApellidoMaternoEntrevistado = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        TxtNombreEntrevistado = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        CbxTipoPropiedadEntrevistado = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        jTextField49 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jComboBox35 = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jTextField57 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jComboBox36 = new javax.swing.JComboBox();
        jLabel108 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jTextField61 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jTextField62 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jTextField63 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jComboBox37 = new javax.swing.JComboBox();
        jLabel109 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        TxtNumeroDocumentoEntrevistado = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        TxtUbiConexAgua = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        TxtUbiConexDesague = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jTextField69 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jTextField70 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jComboBox39 = new javax.swing.JComboBox();
        jLabel119 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jTextField73 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jTextField74 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jComboBox40 = new javax.swing.JComboBox();
        jLabel124 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jTextField77 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jTextField78 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jComboBox41 = new javax.swing.JComboBox();
        jLabel129 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        TxtFotoDesague = new javax.swing.JTextField();
        TxtFotoCaja = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        BtnFotoDesague = new javax.swing.JButton();
        BtnFotoCaja = new javax.swing.JButton();
        TxtCodigoEncuestador = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        TxtCodigoSupervisor = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        TxtCodigoDigitador = new javax.swing.JTextField();
        DateFechaEncuestador = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        DateFechaSupervision = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        DateFechaDigitador = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        LblCodigoFotoCaja = new javax.swing.JLabel();
        LblCodigoFotoPredio = new javax.swing.JLabel();
        jPanelImagePredio = new util.JPanelImage();
        jPanelImageCaja = new util.JPanelImage();
        RbtAgua = new javax.swing.JRadioButton();
        RbtDesague = new javax.swing.JRadioButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/logo.png"))); // NOI18N

        jLabel2.setDisplayedMnemonic('M');
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Mantenimiento de Ficha de Datos Catastrales");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel3.setText("EPS EMAPAVIGSSA");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ficha Numero");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        TxtNumeroFicha.setEditable(false);
        TxtNumeroFicha.setFont(new java.awt.Font("Tahoma", 1, 12));
        TxtNumeroFicha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        CbxSituacionConexion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxSituacionConexionItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Estado de Conexión:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Identificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtDepartamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Dept.");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Provincia");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);

        TxtProvincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Distrito");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);

        TxtDistrito.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel9.setText("Nuevo Código Catastral");

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sección");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);

        TxtSeccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Manzana");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        TxtManzana.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lote");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);

        TxtLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Conex");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);

        TxtConexion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Codigo Inscripción");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);

        TxtCodigoInscripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtCodigoInscripcion.setNextFocusableComponent(TxtRutaLectura);
        TxtCodigoInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigoInscripcionActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ruta de Lectura");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);

        TxtRutaLectura.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtRutaReparto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ruta de Reparto");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Secuencia");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);

        TxtSecuencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Categoría");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        TxtCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/user-search.gif"))); // NOI18N
        BtnBuscarUsuario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtManzana, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TxtCodigoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(BtnBuscarUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBuscarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtManzana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCodigoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtApellidoPaternoPropietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Apellido Paterno del Propietario");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);

        TxtApellidoMaternoPropietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Apellido Materno del Propietario");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Nombre del Propietario");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setOpaque(true);

        TxtNombrePropietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText("Num. Documento:");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText("Correo Electrónico:");

        TxtCorreoElectronico.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("Telefono:");

        TxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtApellidoPaternoConyugue.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Apellido Paterno del Conyugue");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel25.setOpaque(true);

        TxtApellidoMaternoConyugue.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel26.setForeground(new java.awt.Color(0, 0, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Apellido Materno del Conyugue");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(204, 204, 204));
        jLabel27.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel27.setForeground(new java.awt.Color(0, 0, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Nombre del Conyugue");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel27.setOpaque(true);

        TxtNombreConyugue.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("Tipo de Documento:");

        TxtNumDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel29.setForeground(new java.awt.Color(0, 0, 102));
        jLabel29.setText("Tipo Propiedad:");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText("Cant. Habitantes del Predio:");

        TxtCantidadHabitantesPredio.setEditable(false);
        TxtCantidadHabitantesPredio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtCantidadHabitantesPredio.setText("0");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText("Num. Pisos:");

        TxtNumPisos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNumPisos.setText("1");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("Tipo Predio:");

        jLabel138.setFont(new java.awt.Font("Arial", 3, 12));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel138.setText("Cliente:");
        jLabel138.setOpaque(true);

        LblUsuario.setFont(new java.awt.Font("Arial", 3, 12));
        LblUsuario.setForeground(new java.awt.Color(51, 102, 0));
        LblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblUsuario.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtApellidoMaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtApellidoMaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNombreConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(11, 11, 11)
                        .addComponent(TxtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel29)
                        .addGap(32, 32, 32)
                        .addComponent(CbxTipoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtCantidadHabitantesPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtNumPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel32)
                        .addGap(13, 13, 13)
                        .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(8, 8, 8)
                                .addComponent(CbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22)))
                        .addGap(10, 10, 10)
                        .addComponent(TxtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24)
                        .addGap(8, 8, 8)
                        .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtApellidoPaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoMaternoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtApellidoPaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidoMaternoConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombreConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCantidadHabitantesPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxSituacionConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSituacionConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pag 1", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Inmueble(Dirección de Conexión)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtNumeroManzana.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNumeroManzana.setNextFocusableComponent(TxtNumeroLote);

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText(" Num. Mz.");
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel40.setOpaque(true);

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel41.setForeground(new java.awt.Color(0, 0, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText(" Num. Lote");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel41.setOpaque(true);

        TxtComplemento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Block");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);

        TxtBlock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtBlock.setNextFocusableComponent(TxtPiso);

        TxtPiso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPiso.setText("2");
        TxtPiso.setNextFocusableComponent(TxtNumero);

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel43.setForeground(new java.awt.Color(0, 0, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Piso");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel43.setOpaque(true);

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel44.setForeground(new java.awt.Color(0, 0, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Número");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel44.setOpaque(true);

        TxtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("Complemento:");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setText("Uso del Predio:");

        TxtNumeroLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNumeroLote.setNextFocusableComponent(TxtBlock);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("Tipo Servicio:");

        CbxTipoServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxTipoServicioItemStateChanged(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel48.setForeground(new java.awt.Color(0, 0, 102));
        jLabel48.setText("Medio de Abastecimiento:");

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel49.setForeground(new java.awt.Color(0, 0, 102));
        jLabel49.setText("¿Predio Habilitado?:");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setText("Situación del Predio:");

        TxtNombreHabilitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombreHabilitacion.setNextFocusableComponent(TxtNumeroManzana);
        TxtNombreHabilitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreHabilitacionActionPerformed(evt);
            }
        });

        TxtCodigoHabilitacion.setEditable(false);
        TxtCodigoHabilitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtTipoHabilitacion.setEditable(false);
        TxtTipoHabilitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        BtnHabilitacion.setText("...");
        BtnHabilitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHabilitacionActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Código Habilitación");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setOpaque(true);

        BtnVia.setText("...");
        BtnVia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViaActionPerformed(evt);
            }
        });

        TxtCodigoVia.setEditable(false);
        TxtCodigoVia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Num. Municipal");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);

        TxtNumMunicipal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNumMunicipal.setNextFocusableComponent(TxtNombreHabilitacion);

        TxtNombreVia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombreVia.setNextFocusableComponent(TxtNumMunicipal);
        TxtNombreVia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreViaActionPerformed(evt);
            }
        });

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Nombre de Vía");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setOpaque(true);

        TxtTipoVia.setEditable(false);
        TxtTipoVia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Tipo de Vía");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel39.setOpaque(true);

        jLabel135.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel135.setForeground(new java.awt.Color(0, 0, 102));
        jLabel135.setText("Tipo Almacenamiento:");

        jLabel139.setFont(new java.awt.Font("Arial", 3, 12));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel139.setText("Dirección:");
        jLabel139.setOpaque(true);

        LblDireccion.setFont(new java.awt.Font("Arial", 3, 12));
        LblDireccion.setForeground(new java.awt.Color(0, 102, 0));
        LblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblDireccion.setOpaque(true);

        jLabel140.setFont(new java.awt.Font("Arial", 3, 12));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel140.setText("Tipo Servicio:");
        jLabel140.setOpaque(true);

        LblTipoServicio.setFont(new java.awt.Font("Arial", 3, 12));
        LblTipoServicio.setForeground(new java.awt.Color(0, 102, 0));
        LblTipoServicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblTipoServicio.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(ChckSiNoPredioHabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(14, 14, 14)
                                .addComponent(CbxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel48)
                                .addGap(4, 4, 4)
                                .addComponent(CbxMedioAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(CbxSituacionPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtNumeroManzana, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(TxtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(TxtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel46)
                        .addGap(5, 5, 5)
                        .addComponent(CbxUsoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxTipoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(BtnVia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCodigoHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTipoHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNombreHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel139)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel140)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(LblTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblTipoServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addComponent(jLabel140, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnVia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtCodigoHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtTipoHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtNombreHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumeroManzana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxUsoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChckSiNoPredioHabilitado)))
                    .addComponent(BtnHabilitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxMedioAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSituacionPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxTipoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TblUsos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Uso", "Nº", "Respo", "Tipo de Uso", "Cod. Uso", "Ptos Agua", "Num. Persona", "Complemento", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblUsos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblUsos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblUsos);
        TblUsos.getColumnModel().getColumn(0).setMinWidth(0);
        TblUsos.getColumnModel().getColumn(0).setPreferredWidth(0);
        TblUsos.getColumnModel().getColumn(0).setMaxWidth(0);
        TblUsos.getColumnModel().getColumn(1).setMinWidth(0);
        TblUsos.getColumnModel().getColumn(1).setPreferredWidth(0);
        TblUsos.getColumnModel().getColumn(1).setMaxWidth(0);
        TblUsos.getColumnModel().getColumn(2).setPreferredWidth(30);
        TblUsos.getColumnModel().getColumn(3).setPreferredWidth(60);
        TblUsos.getColumnModel().getColumn(4).setPreferredWidth(200);
        TblUsos.getColumnModel().getColumn(7).setPreferredWidth(80);
        TblUsos.getColumnModel().getColumn(8).setPreferredWidth(300);
        TblUsos.getColumnModel().getColumn(9).setPreferredWidth(60);

        BtnAgregarUso.setText("+");
        BtnAgregarUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarUsoActionPerformed(evt);
            }
        });

        BtnEliminarUso.setText("-");
        BtnEliminarUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarUsoActionPerformed(evt);
            }
        });

        TxtPorcentajeDomestico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPorcentajeDomestico.setText("0");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setText("% Domestico:");

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("% Comercial:");

        TxtPorcentajeComercial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPorcentajeComercial.setText("0");

        jLabel53.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel53.setForeground(new java.awt.Color(0, 0, 102));
        jLabel53.setText("% Estatal:");

        TxtPorcentajeEstatal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPorcentajeEstatal.setText("0");

        TxtPorcentajeSocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPorcentajeSocial.setText("0");

        jLabel54.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel54.setForeground(new java.awt.Color(0, 0, 102));
        jLabel54.setText("% Social:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(BtnAgregarUso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEliminarUso)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPorcentajeDomestico, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPorcentajeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPorcentajeEstatal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPorcentajeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregarUso)
                    .addComponent(BtnEliminarUso)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPorcentajeDomestico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPorcentajeComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPorcentajeEstatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPorcentajeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pag 2", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Medidor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel67.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel67.setForeground(new java.awt.Color(0, 0, 102));
        jLabel67.setText("Numero Medidor:");

        jLabel69.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel69.setForeground(new java.awt.Color(0, 0, 102));
        jLabel69.setText("Diametro del Medidor:");

        jLabel71.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel71.setForeground(new java.awt.Color(0, 0, 102));
        jLabel71.setText("¿Es ilegible?");

        ChkSiNoIlegibleNumeroMedidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkSiNoIlegibleNumeroMedidorActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel73.setForeground(new java.awt.Color(0, 0, 102));
        jLabel73.setText("¿Tiene Medidor?");

        ChkSiNoMedidor.setSelected(true);
        ChkSiNoMedidor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ChkSiNoMedidorItemStateChanged(evt);
            }
        });

        TxtLecturaMedidor.setText("0");

        jLabel74.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel74.setForeground(new java.awt.Color(0, 0, 102));
        jLabel74.setText("Lectura Medidor:");

        ChckSiNoIlegibleLecturaMedidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChckSiNoIlegibleLecturaMedidorActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel75.setForeground(new java.awt.Color(0, 0, 102));
        jLabel75.setText("¿Es ilegible?");

        jLabel76.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel76.setForeground(new java.awt.Color(0, 0, 102));
        jLabel76.setText("Marca Medidor:");

        jLabel70.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel70.setForeground(new java.awt.Color(0, 0, 102));
        jLabel70.setText("Estado del Medidor:");

        jLabel72.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel72.setForeground(new java.awt.Color(0, 0, 102));
        jLabel72.setText("Llaves de Paso:");

        jLabel77.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel77.setForeground(new java.awt.Color(0, 0, 102));
        jLabel77.setText("Seg. del Medidor:");

        jLabel78.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel78.setForeground(new java.awt.Color(0, 0, 102));
        jLabel78.setText("Posicion. del Medidor:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ChkSiNoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtNumeroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ChkSiNoIlegibleNumeroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtMarcaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtLecturaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ChckSiNoIlegibleLecturaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGap(6, 6, 6)
                        .addComponent(CbxDiametroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel70)
                        .addGap(19, 19, 19)
                        .addComponent(CbxEstadoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CbxLlavesPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(33, 33, 33)
                        .addComponent(CbxSeguridadMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxPosicionMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChkSiNoMedidor))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumeroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChkSiNoIlegibleNumeroMedidor)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMarcaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtLecturaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoIlegibleLecturaMedidor))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxDiametroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxEstadoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbxLlavesPaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSeguridadMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxPosicionMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la Conexion del Agua", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel8.setLayout(null);

        CbxSituacionAgua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxSituacionAguaItemStateChanged(evt);
            }
        });
        jPanel8.add(CbxSituacionAgua);
        CbxSituacionAgua.setBounds(70, 30, 134, 20);

        jLabel87.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel87.setForeground(new java.awt.Color(0, 0, 102));
        jLabel87.setText("Situación:");
        jPanel8.add(jLabel87);
        jLabel87.setBounds(10, 30, 60, 20);
        jPanel8.add(CbxUbiCajaConexAgua);
        CbxUbiCajaConexAgua.setBounds(310, 60, 135, 20);

        jLabel88.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel88.setForeground(new java.awt.Color(0, 0, 102));
        jLabel88.setText("Ubi/Caja/Conex:");
        jPanel8.add(jLabel88);
        jLabel88.setBounds(220, 60, 90, 20);

        jLabel89.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel89.setForeground(new java.awt.Color(0, 0, 102));
        jLabel89.setText("Diametro de Conex:");
        jPanel8.add(jLabel89);
        jLabel89.setBounds(10, 120, 120, 20);
        jPanel8.add(CbxDiametroConexionAgua);
        CbxDiametroConexionAgua.setBounds(130, 120, 162, 20);
        jPanel8.add(CbxCondicionConexionAgua);
        CbxCondicionConexionAgua.setBounds(310, 90, 110, 20);

        jLabel90.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel90.setForeground(new java.awt.Color(0, 0, 102));
        jLabel90.setText("Cond. Conex:");
        jPanel8.add(jLabel90);
        jLabel90.setBounds(230, 90, 74, 21);
        jPanel8.add(CbxMaterialCajaAgua);
        CbxMaterialCajaAgua.setBounds(520, 60, 108, 20);

        jLabel91.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel91.setForeground(new java.awt.Color(0, 0, 102));
        jLabel91.setText("Mat. Caja:");
        jPanel8.add(jLabel91);
        jLabel91.setBounds(460, 60, 55, 20);

        jLabel92.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel92.setForeground(new java.awt.Color(0, 0, 102));
        jLabel92.setText("Estado Caja:");
        jPanel8.add(jLabel92);
        jLabel92.setBounds(220, 30, 70, 20);

        jLabel68.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel68.setForeground(new java.awt.Color(0, 0, 102));
        jLabel68.setText("Mat. de la Conexión:");
        jPanel8.add(jLabel68);
        jLabel68.setBounds(430, 90, 113, 20);

        jLabel79.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel79.setForeground(new java.awt.Color(0, 0, 102));
        jLabel79.setText("¿Con Tapa?");
        jPanel8.add(jLabel79);
        jLabel79.setBounds(470, 30, 67, 20);

        ChckSiNoTapaConexionAgua.setSelected(true);
        ChckSiNoTapaConexionAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChckSiNoTapaConexionAguaActionPerformed(evt);
            }
        });
        jPanel8.add(ChckSiNoTapaConexionAgua);
        ChckSiNoTapaConexionAgua.setBounds(550, 30, 21, 21);

        ChckSiNoFugaAgua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ChckSiNoFugaAguaItemStateChanged(evt);
            }
        });
        ChckSiNoFugaAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChckSiNoFugaAguaActionPerformed(evt);
            }
        });
        jPanel8.add(ChckSiNoFugaAgua);
        ChckSiNoFugaAgua.setBounds(360, 120, 21, 20);

        jLabel80.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel80.setForeground(new java.awt.Color(0, 0, 102));
        jLabel80.setText("Tipo de Fuga:");
        jPanel8.add(jLabel80);
        jLabel80.setBounds(400, 120, 80, 20);

        jLabel81.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel81.setForeground(new java.awt.Color(0, 0, 102));
        jLabel81.setText("¿Fugas?");
        jPanel8.add(jLabel81);
        jLabel81.setBounds(310, 120, 50, 20);

        buttonGroup1.add(RbtOpcionAntes);
        RbtOpcionAntes.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionAntes.setText("Antes");
        jPanel8.add(RbtOpcionAntes);
        RbtOpcionAntes.setBounds(480, 120, 60, 20);

        buttonGroup1.add(RbtOpcionDespues);
        RbtOpcionDespues.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionDespues.setText("Después");
        jPanel8.add(RbtOpcionDespues);
        RbtOpcionDespues.setBounds(550, 120, 80, 20);

        buttonGroup1.add(RbtOpcionIndeterminado);
        RbtOpcionIndeterminado.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionIndeterminado.setText("Indeterminado");
        jPanel8.add(RbtOpcionIndeterminado);
        RbtOpcionIndeterminado.setBounds(630, 120, 120, 20);

        jLabel141.setFont(new java.awt.Font("Arial", 3, 12));
        jLabel141.setText("Cond. Conex:");
        jPanel8.add(jLabel141);
        jLabel141.setBounds(10, 90, 80, 20);

        LblCondicionConexion.setFont(new java.awt.Font("Arial", 3, 12));
        jPanel8.add(LblCondicionConexion);
        LblCondicionConexion.setBounds(883, 63, 0, 20);

        CbxEstadoCajaAgua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxEstadoCajaAguaItemStateChanged(evt);
            }
        });
        jPanel8.add(CbxEstadoCajaAgua);
        CbxEstadoCajaAgua.setBounds(300, 30, 150, 20);
        jPanel8.add(CbxMaterialTapaAgua);
        CbxMaterialTapaAgua.setBounds(70, 60, 135, 20);

        jLabel136.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel136.setForeground(new java.awt.Color(0, 0, 102));
        jLabel136.setText("Mat. Tapa:");
        jPanel8.add(jLabel136);
        jLabel136.setBounds(10, 60, 58, 20);

        CbxEstadoTapaAgua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxEstadoTapaAguaItemStateChanged(evt);
            }
        });
        jPanel8.add(CbxEstadoTapaAgua);
        CbxEstadoTapaAgua.setBounds(660, 30, 135, 20);

        jLabel137.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel137.setForeground(new java.awt.Color(0, 0, 102));
        jLabel137.setText("Estado Tapa:");
        jPanel8.add(jLabel137);
        jLabel137.setBounds(580, 30, 73, 20);

        LblCondicionConexionConsulta.setFont(new java.awt.Font("Arial", 3, 12));
        LblCondicionConexionConsulta.setForeground(new java.awt.Color(51, 102, 0));
        jPanel8.add(LblCondicionConexionConsulta);
        LblCondicionConexionConsulta.setBounds(90, 90, 120, 20);
        jPanel8.add(CbxMaterialConexionAgua);
        CbxMaterialConexionAgua.setBounds(550, 90, 162, 20);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la Conexion del Desague", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel9.setLayout(null);
        jPanel9.add(CbxUbiCajaConexDesague);
        CbxUbiCajaConexDesague.setBounds(720, 50, 150, 20);

        jLabel93.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel93.setForeground(new java.awt.Color(0, 0, 102));
        jLabel93.setText("Ubi/Caja/Conex:");
        jPanel9.add(jLabel93);
        jLabel93.setBounds(620, 50, 90, 20);

        jLabel95.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel95.setForeground(new java.awt.Color(0, 0, 102));
        jLabel95.setText("Diam. de Conex:");
        jPanel9.add(jLabel95);
        jLabel95.setBounds(290, 110, 100, 20);
        jPanel9.add(CbxDiametroConexionDesague);
        CbxDiametroConexionDesague.setBounds(390, 110, 130, 20);
        jPanel9.add(CbxCondicionConexDesague);
        CbxCondicionConexDesague.setBounds(720, 80, 150, 20);

        jLabel96.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel96.setForeground(new java.awt.Color(0, 0, 102));
        jLabel96.setText("Cond. Conex:");
        jPanel9.add(jLabel96);
        jLabel96.setBounds(390, 80, 80, 20);

        CbxMaterialCajaDesague.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxMaterialCajaDesagueItemStateChanged(evt);
            }
        });
        jPanel9.add(CbxMaterialCajaDesague);
        CbxMaterialCajaDesague.setBounds(110, 80, 140, 20);

        jLabel97.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel97.setForeground(new java.awt.Color(0, 0, 102));
        jLabel97.setText("Mat. Caja:");
        jPanel9.add(jLabel97);
        jLabel97.setBounds(20, 80, 80, 20);

        jLabel98.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel98.setForeground(new java.awt.Color(0, 0, 102));
        jLabel98.setText("Estado Tapa:");
        jPanel9.add(jLabel98);
        jLabel98.setBounds(150, 50, 80, 20);

        CbxEstadoTapaDesague.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxEstadoTapaDesagueItemStateChanged(evt);
            }
        });
        jPanel9.add(CbxEstadoTapaDesague);
        CbxEstadoTapaDesague.setBounds(230, 50, 150, 20);
        jPanel9.add(CbxMaterialTapaDesague);
        CbxMaterialTapaDesague.setBounds(450, 50, 150, 20);

        jLabel99.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel99.setForeground(new java.awt.Color(0, 0, 102));
        jLabel99.setText("Mat. Tapa:");
        jPanel9.add(jLabel99);
        jLabel99.setBounds(390, 50, 60, 20);

        jLabel100.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel100.setForeground(new java.awt.Color(0, 0, 102));
        jLabel100.setText("Estado Caja:");
        jPanel9.add(jLabel100);
        jLabel100.setBounds(630, 20, 80, 20);

        CbxEstadoCajaDesague.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxEstadoCajaDesagueItemStateChanged(evt);
            }
        });
        jPanel9.add(CbxEstadoCajaDesague);
        CbxEstadoCajaDesague.setBounds(720, 20, 150, 20);

        jLabel142.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel142.setForeground(new java.awt.Color(0, 0, 102));
        jLabel142.setText("¿Con Tapa?");
        jPanel9.add(jLabel142);
        jLabel142.setBounds(20, 50, 70, 20);

        ChckSiNoTapaConexionDesague.setSelected(true);
        ChckSiNoTapaConexionDesague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChckSiNoTapaConexionDesagueActionPerformed(evt);
            }
        });
        jPanel9.add(ChckSiNoTapaConexionDesague);
        ChckSiNoTapaConexionDesague.setBounds(100, 50, 21, 21);

        jLabel143.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel143.setForeground(new java.awt.Color(0, 0, 102));
        jLabel143.setText("Mat. Conexion:");
        jPanel9.add(jLabel143);
        jLabel143.setBounds(20, 110, 100, 20);

        CbxMaterialConexionDesague.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxMaterialConexionDesagueItemStateChanged(evt);
            }
        });
        jPanel9.add(CbxMaterialConexionDesague);
        CbxMaterialConexionDesague.setBounds(110, 110, 140, 20);

        jLabel144.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel144.setForeground(new java.awt.Color(0, 0, 102));
        jLabel144.setText("¿Fugas?");
        jPanel9.add(jLabel144);
        jLabel144.setBounds(560, 110, 50, 20);
        jPanel9.add(ChckSiNoFugaDesague);
        ChckSiNoFugaDesague.setBounds(610, 110, 30, 21);

        jLabel145.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel145.setForeground(new java.awt.Color(0, 0, 102));
        jLabel145.setText("Caracteristicas:");
        jPanel9.add(jLabel145);
        jLabel145.setBounds(20, 20, 100, 20);

        buttonGroup2.add(RbtOpcionConCaja);
        RbtOpcionConCaja.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionConCaja.setSelected(true);
        RbtOpcionConCaja.setText("Con Caja");
        jPanel9.add(RbtOpcionConCaja);
        RbtOpcionConCaja.setBounds(120, 20, 73, 20);

        buttonGroup2.add(RbtOpcionNoDeterminado);
        RbtOpcionNoDeterminado.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionNoDeterminado.setText("No Determinado");
        jPanel9.add(RbtOpcionNoDeterminado);
        RbtOpcionNoDeterminado.setBounds(360, 20, 113, 20);

        LblCondicionConexionDesague.setFont(new java.awt.Font("Arial", 1, 12));
        LblCondicionConexionDesague.setForeground(new java.awt.Color(51, 102, 0));
        jPanel9.add(LblCondicionConexionDesague);
        LblCondicionConexionDesague.setBounds(470, 80, 130, 20);

        jLabel147.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel147.setForeground(new java.awt.Color(0, 0, 102));
        jLabel147.setText("Cond. Conex:");
        jPanel9.add(jLabel147);
        jLabel147.setBounds(640, 80, 80, 20);

        buttonGroup2.add(RbtOpcionSinCaja);
        RbtOpcionSinCaja.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionSinCaja.setText("Sin Caja/Conex. Directa");
        RbtOpcionSinCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtOpcionSinCajaActionPerformed(evt);
            }
        });
        jPanel9.add(RbtOpcionSinCaja);
        RbtOpcionSinCaja.setBounds(200, 20, 151, 20);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pag 3", jPanel6);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Complementarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel94.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel94.setForeground(new java.awt.Color(0, 0, 102));
        jLabel94.setText("Pavimentación:");

        jLabel101.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel101.setForeground(new java.awt.Color(0, 0, 102));
        jLabel101.setText("Vereda:");

        jLabel102.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel102.setForeground(new java.awt.Color(0, 0, 102));
        jLabel102.setText("Pozo Artesanal:");

        jLabel103.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel103.setText("Frecuencia de Abastecimiento");

        TxtHorasPorDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtHorasPorDia.setText("0");

        TxtDiaPorSemana.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDiaPorSemana.setText("0");

        jLabel104.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel104.setForeground(new java.awt.Color(0, 0, 102));
        jLabel104.setText("Días por Semana:");

        jLabel105.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel105.setForeground(new java.awt.Color(0, 0, 102));
        jLabel105.setText("Horas por Día:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxPavimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxVereda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(CbxPozoArtesanal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtHorasPorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtDiaPorSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxPavimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxVereda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxPozoArtesanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtHorasPorDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtDiaPorSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtObservaciones.setColumns(20);
        TxtObservaciones.setRows(5);
        jScrollPane2.setViewportView(TxtObservaciones);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtApellidoPaternoEntrevistado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel55.setBackground(new java.awt.Color(204, 204, 204));
        jLabel55.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel55.setForeground(new java.awt.Color(0, 0, 102));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Apellido Paterno ");
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel55.setOpaque(true);

        TxtApellidoMaternoEntrevistado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel56.setBackground(new java.awt.Color(204, 204, 204));
        jLabel56.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel56.setForeground(new java.awt.Color(0, 0, 102));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Apellido Materno ");
        jLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel56.setOpaque(true);

        jLabel57.setBackground(new java.awt.Color(204, 204, 204));
        jLabel57.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel57.setForeground(new java.awt.Color(0, 0, 102));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Nombre ");
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel57.setOpaque(true);

        TxtNombreEntrevistado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel58.setBackground(new java.awt.Color(204, 204, 204));
        jLabel58.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel58.setForeground(new java.awt.Color(0, 0, 102));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Num. Documento");
        jLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel58.setOpaque(true);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel14.setLayout(null);
        jPanel14.add(jTextField49);
        jTextField49.setBounds(20, 20, 270, 20);

        jLabel59.setBackground(new java.awt.Color(204, 204, 204));
        jLabel59.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel59.setForeground(new java.awt.Color(0, 0, 102));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Apellido Paterno ");
        jLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel59.setOpaque(true);
        jPanel14.add(jLabel59);
        jLabel59.setBounds(20, 40, 270, 20);
        jPanel14.add(jTextField50);
        jTextField50.setBounds(300, 20, 260, 20);

        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
        jLabel60.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel60.setForeground(new java.awt.Color(0, 0, 102));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Apellido Materno ");
        jLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel60.setOpaque(true);
        jPanel14.add(jLabel60);
        jLabel60.setBounds(300, 40, 260, 20);

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel61.setForeground(new java.awt.Color(0, 0, 102));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Nombre ");
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel61.setOpaque(true);
        jPanel14.add(jLabel61);
        jLabel61.setBounds(570, 40, 290, 20);
        jPanel14.add(jTextField51);
        jTextField51.setBounds(570, 20, 290, 20);
        jPanel14.add(jTextField56);
        jTextField56.setBounds(20, 70, 130, 20);

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel62.setForeground(new java.awt.Color(0, 0, 102));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Num. Documento");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel62.setOpaque(true);
        jPanel14.add(jLabel62);
        jLabel62.setBounds(20, 90, 130, 20);
        jPanel14.add(jComboBox35);
        jComboBox35.setBounds(270, 80, 140, 20);

        jLabel107.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel107.setForeground(new java.awt.Color(0, 0, 102));
        jLabel107.setText("Tipo Propiedad:");
        jPanel14.add(jLabel107);
        jLabel107.setBounds(170, 80, 90, 20);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel15.setLayout(null);
        jPanel15.add(jTextField57);
        jTextField57.setBounds(20, 20, 270, 20);

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel63.setForeground(new java.awt.Color(0, 0, 102));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Apellido Paterno ");
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel63.setOpaque(true);
        jPanel15.add(jLabel63);
        jLabel63.setBounds(20, 40, 270, 20);
        jPanel15.add(jTextField58);
        jTextField58.setBounds(300, 20, 260, 20);

        jLabel64.setBackground(new java.awt.Color(204, 204, 204));
        jLabel64.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel64.setForeground(new java.awt.Color(0, 0, 102));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Apellido Materno ");
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel64.setOpaque(true);
        jPanel15.add(jLabel64);
        jLabel64.setBounds(300, 40, 260, 20);

        jLabel65.setBackground(new java.awt.Color(204, 204, 204));
        jLabel65.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel65.setForeground(new java.awt.Color(0, 0, 102));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Nombre ");
        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel65.setOpaque(true);
        jPanel15.add(jLabel65);
        jLabel65.setBounds(570, 40, 290, 20);
        jPanel15.add(jTextField59);
        jTextField59.setBounds(570, 20, 290, 20);
        jPanel15.add(jTextField60);
        jTextField60.setBounds(20, 70, 130, 20);

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel66.setForeground(new java.awt.Color(0, 0, 102));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Num. Documento");
        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel66.setOpaque(true);
        jPanel15.add(jLabel66);
        jLabel66.setBounds(20, 90, 130, 20);
        jPanel15.add(jComboBox36);
        jComboBox36.setBounds(270, 80, 140, 20);

        jLabel108.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel108.setForeground(new java.awt.Color(0, 0, 102));
        jLabel108.setText("Tipo Propiedad:");
        jPanel15.add(jLabel108);
        jLabel108.setBounds(170, 80, 90, 20);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel16.setLayout(null);
        jPanel16.add(jTextField61);
        jTextField61.setBounds(20, 20, 270, 20);

        jLabel82.setBackground(new java.awt.Color(204, 204, 204));
        jLabel82.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel82.setForeground(new java.awt.Color(0, 0, 102));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Apellido Paterno ");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel82.setOpaque(true);
        jPanel16.add(jLabel82);
        jLabel82.setBounds(20, 40, 270, 20);
        jPanel16.add(jTextField62);
        jTextField62.setBounds(300, 20, 260, 20);

        jLabel83.setBackground(new java.awt.Color(204, 204, 204));
        jLabel83.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel83.setForeground(new java.awt.Color(0, 0, 102));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Apellido Materno ");
        jLabel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel83.setOpaque(true);
        jPanel16.add(jLabel83);
        jLabel83.setBounds(300, 40, 260, 20);

        jLabel84.setBackground(new java.awt.Color(204, 204, 204));
        jLabel84.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel84.setForeground(new java.awt.Color(0, 0, 102));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Nombre ");
        jLabel84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel84.setOpaque(true);
        jPanel16.add(jLabel84);
        jLabel84.setBounds(570, 40, 290, 20);
        jPanel16.add(jTextField63);
        jTextField63.setBounds(570, 20, 290, 20);
        jPanel16.add(jTextField64);
        jTextField64.setBounds(20, 70, 130, 20);

        jLabel86.setBackground(new java.awt.Color(204, 204, 204));
        jLabel86.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel86.setForeground(new java.awt.Color(0, 0, 102));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Num. Documento");
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel86.setOpaque(true);
        jPanel16.add(jLabel86);
        jLabel86.setBounds(20, 90, 130, 20);
        jPanel16.add(jComboBox37);
        jComboBox37.setBounds(270, 80, 140, 20);

        jLabel109.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel109.setForeground(new java.awt.Color(0, 0, 102));
        jLabel109.setText("Tipo Propiedad:");
        jPanel16.add(jLabel109);
        jLabel109.setBounds(170, 80, 90, 20);

        jPanel15.add(jPanel16);
        jPanel16.setBounds(0, 0, 0, 0);

        jLabel112.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel112.setForeground(new java.awt.Color(0, 0, 102));
        jLabel112.setText("Tipo Propiedad:");

        TxtNumeroDocumentoEntrevistado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtApellidoMaternoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNombreEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumeroDocumentoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxTipoPropiedadEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtApellidoPaternoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtApellidoMaternoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombreEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(TxtNumeroDocumentoEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbxTipoPropiedadEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 4", jPanel10);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubicación de la Conexión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        TxtUbiConexAgua.setText("0");

        jLabel110.setBackground(new java.awt.Color(204, 204, 204));
        jLabel110.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel110.setForeground(new java.awt.Color(0, 0, 102));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Ub. Conex de Agua");
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel110.setOpaque(true);

        TxtUbiConexDesague.setText("0");

        jLabel111.setBackground(new java.awt.Color(204, 204, 204));
        jLabel111.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel111.setForeground(new java.awt.Color(0, 0, 102));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("Ub. Conex. de Desag.");
        jLabel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel111.setOpaque(true);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel18.setLayout(null);
        jPanel18.add(jTextField69);
        jTextField69.setBounds(20, 20, 270, 20);

        jLabel115.setBackground(new java.awt.Color(204, 204, 204));
        jLabel115.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel115.setForeground(new java.awt.Color(0, 0, 102));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("Apellido Paterno ");
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel115.setOpaque(true);
        jPanel18.add(jLabel115);
        jLabel115.setBounds(20, 40, 270, 20);
        jPanel18.add(jTextField70);
        jTextField70.setBounds(300, 20, 260, 20);

        jLabel116.setBackground(new java.awt.Color(204, 204, 204));
        jLabel116.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel116.setForeground(new java.awt.Color(0, 0, 102));
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("Apellido Materno ");
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel116.setOpaque(true);
        jPanel18.add(jLabel116);
        jLabel116.setBounds(300, 40, 260, 20);

        jLabel117.setBackground(new java.awt.Color(204, 204, 204));
        jLabel117.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel117.setForeground(new java.awt.Color(0, 0, 102));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Nombre ");
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel117.setOpaque(true);
        jPanel18.add(jLabel117);
        jLabel117.setBounds(570, 40, 290, 20);
        jPanel18.add(jTextField71);
        jTextField71.setBounds(570, 20, 290, 20);
        jPanel18.add(jTextField72);
        jTextField72.setBounds(20, 70, 130, 20);

        jLabel118.setBackground(new java.awt.Color(204, 204, 204));
        jLabel118.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel118.setForeground(new java.awt.Color(0, 0, 102));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Num. Documento");
        jLabel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel118.setOpaque(true);
        jPanel18.add(jLabel118);
        jLabel118.setBounds(20, 90, 130, 20);
        jPanel18.add(jComboBox39);
        jComboBox39.setBounds(270, 80, 140, 20);

        jLabel119.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel119.setForeground(new java.awt.Color(0, 0, 102));
        jLabel119.setText("Tipo Propiedad:");
        jPanel18.add(jLabel119);
        jLabel119.setBounds(170, 80, 90, 20);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel19.setLayout(null);
        jPanel19.add(jTextField73);
        jTextField73.setBounds(20, 20, 270, 20);

        jLabel120.setBackground(new java.awt.Color(204, 204, 204));
        jLabel120.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel120.setForeground(new java.awt.Color(0, 0, 102));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("Apellido Paterno ");
        jLabel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel120.setOpaque(true);
        jPanel19.add(jLabel120);
        jLabel120.setBounds(20, 40, 270, 20);
        jPanel19.add(jTextField74);
        jTextField74.setBounds(300, 20, 260, 20);

        jLabel121.setBackground(new java.awt.Color(204, 204, 204));
        jLabel121.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel121.setForeground(new java.awt.Color(0, 0, 102));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("Apellido Materno ");
        jLabel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel121.setOpaque(true);
        jPanel19.add(jLabel121);
        jLabel121.setBounds(300, 40, 260, 20);

        jLabel122.setBackground(new java.awt.Color(204, 204, 204));
        jLabel122.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel122.setForeground(new java.awt.Color(0, 0, 102));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("Nombre ");
        jLabel122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel122.setOpaque(true);
        jPanel19.add(jLabel122);
        jLabel122.setBounds(570, 40, 290, 20);
        jPanel19.add(jTextField75);
        jTextField75.setBounds(570, 20, 290, 20);
        jPanel19.add(jTextField76);
        jTextField76.setBounds(20, 70, 130, 20);

        jLabel123.setBackground(new java.awt.Color(204, 204, 204));
        jLabel123.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel123.setForeground(new java.awt.Color(0, 0, 102));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Num. Documento");
        jLabel123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel123.setOpaque(true);
        jPanel19.add(jLabel123);
        jLabel123.setBounds(20, 90, 130, 20);
        jPanel19.add(jComboBox40);
        jComboBox40.setBounds(270, 80, 140, 20);

        jLabel124.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel124.setForeground(new java.awt.Color(0, 0, 102));
        jLabel124.setText("Tipo Propiedad:");
        jPanel19.add(jLabel124);
        jLabel124.setBounds(170, 80, 90, 20);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel20.setLayout(null);
        jPanel20.add(jTextField77);
        jTextField77.setBounds(20, 20, 270, 20);

        jLabel125.setBackground(new java.awt.Color(204, 204, 204));
        jLabel125.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel125.setForeground(new java.awt.Color(0, 0, 102));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Apellido Paterno ");
        jLabel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel125.setOpaque(true);
        jPanel20.add(jLabel125);
        jLabel125.setBounds(20, 40, 270, 20);
        jPanel20.add(jTextField78);
        jTextField78.setBounds(300, 20, 260, 20);

        jLabel126.setBackground(new java.awt.Color(204, 204, 204));
        jLabel126.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel126.setForeground(new java.awt.Color(0, 0, 102));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("Apellido Materno ");
        jLabel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel126.setOpaque(true);
        jPanel20.add(jLabel126);
        jLabel126.setBounds(300, 40, 260, 20);

        jLabel127.setBackground(new java.awt.Color(204, 204, 204));
        jLabel127.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel127.setForeground(new java.awt.Color(0, 0, 102));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("Nombre ");
        jLabel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel127.setOpaque(true);
        jPanel20.add(jLabel127);
        jLabel127.setBounds(570, 40, 290, 20);
        jPanel20.add(jTextField79);
        jTextField79.setBounds(570, 20, 290, 20);
        jPanel20.add(jTextField80);
        jTextField80.setBounds(20, 70, 130, 20);

        jLabel128.setBackground(new java.awt.Color(204, 204, 204));
        jLabel128.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel128.setForeground(new java.awt.Color(0, 0, 102));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Num. Documento");
        jLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel128.setOpaque(true);
        jPanel20.add(jLabel128);
        jLabel128.setBounds(20, 90, 130, 20);
        jPanel20.add(jComboBox41);
        jComboBox41.setBounds(270, 80, 140, 20);

        jLabel129.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel129.setForeground(new java.awt.Color(0, 0, 102));
        jLabel129.setText("Tipo Propiedad:");
        jPanel20.add(jLabel129);
        jLabel129.setBounds(170, 80, 90, 20);

        jPanel19.add(jPanel20);
        jPanel20.setBounds(0, 0, 0, 0);

        jLabel106.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel106.setForeground(new java.awt.Color(0, 0, 102));
        jLabel106.setText("Foto Predio:");

        TxtFotoDesague.setEnabled(false);

        TxtFotoCaja.setEnabled(false);

        jLabel113.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel113.setForeground(new java.awt.Color(0, 0, 102));
        jLabel113.setText("Foto Caja:");

        BtnFotoDesague.setText("...");
        BtnFotoDesague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFotoDesagueActionPerformed(evt);
            }
        });

        BtnFotoCaja.setText("...");
        BtnFotoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFotoCajaActionPerformed(evt);
            }
        });

        jLabel114.setBackground(new java.awt.Color(204, 204, 204));
        jLabel114.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel114.setForeground(new java.awt.Color(0, 0, 102));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("Cod.  Encuesta.");
        jLabel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel114.setOpaque(true);

        jLabel130.setBackground(new java.awt.Color(204, 204, 204));
        jLabel130.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel130.setForeground(new java.awt.Color(0, 0, 102));
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("Fecha  Encues.");
        jLabel130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel130.setOpaque(true);

        jLabel131.setBackground(new java.awt.Color(204, 204, 204));
        jLabel131.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel131.setForeground(new java.awt.Color(0, 0, 102));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("Cod. Superv.");
        jLabel131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel131.setOpaque(true);

        jLabel132.setBackground(new java.awt.Color(204, 204, 204));
        jLabel132.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel132.setForeground(new java.awt.Color(0, 0, 102));
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("Fecha Superv.");
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel132.setOpaque(true);

        jLabel133.setBackground(new java.awt.Color(204, 204, 204));
        jLabel133.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel133.setForeground(new java.awt.Color(0, 0, 102));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("Fecha Digitac.");
        jLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel133.setOpaque(true);

        jLabel134.setBackground(new java.awt.Color(204, 204, 204));
        jLabel134.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel134.setForeground(new java.awt.Color(0, 0, 102));
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("Cod. Digitac.");
        jLabel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel134.setOpaque(true);

        DateFechaEncuestador.setDateFormatString("dd/MM/yyyy");

        DateFechaSupervision.setDateFormatString("dd/MM/yyyy");

        DateFechaDigitador.setDateFormatString("dd/MM/yyyy");

        LblCodigoFotoCaja.setText("Codigo");

        LblCodigoFotoPredio.setText("Codigo");

        jPanelImagePredio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelImagePredioLayout = new javax.swing.GroupLayout(jPanelImagePredio);
        jPanelImagePredio.setLayout(jPanelImagePredioLayout);
        jPanelImagePredioLayout.setHorizontalGroup(
            jPanelImagePredioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanelImagePredioLayout.setVerticalGroup(
            jPanelImagePredioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jPanelImageCaja.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelImageCajaLayout = new javax.swing.GroupLayout(jPanelImageCaja);
        jPanelImageCaja.setLayout(jPanelImageCajaLayout);
        jPanelImageCajaLayout.setHorizontalGroup(
            jPanelImageCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        jPanelImageCajaLayout.setVerticalGroup(
            jPanelImageCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        buttonGroup3.add(RbtAgua);
        RbtAgua.setFont(new java.awt.Font("Tahoma", 1, 11));
        RbtAgua.setSelected(true);
        RbtAgua.setText("Agua");

        buttonGroup3.add(RbtDesague);
        RbtDesague.setFont(new java.awt.Font("Tahoma", 1, 11));
        RbtDesague.setText("Desagüe");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblCodigoFotoCaja)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(TxtFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(BtnFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanelImageCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addComponent(RbtAgua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RbtDesague)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblCodigoFotoPredio)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(TxtFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelImagePredio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(TxtCodigoEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DateFechaEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(TxtCodigoSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DateFechaSupervision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(TxtCodigoDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DateFechaDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtUbiConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtUbiConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(333, 333, 333)))
                .addGap(3, 3, 3))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(LblCodigoFotoPredio))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblCodigoFotoCaja)))
                .addGap(4, 4, 4)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImageCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelImagePredio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtUbiConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RbtAgua)
                            .addComponent(RbtDesague))
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(TxtUbiConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCodigoEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaSupervision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pag 5", jPanel21);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(785, Short.MAX_VALUE)
                .addComponent(BtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, 0, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNumeroFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(TxtNumeroFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFotoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoCajaActionPerformed
      jFileChooser1.showOpenDialog(null);
      TxtFotoCaja.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
      LblCodigoFotoCaja.setText(jFileChooser1.getSelectedFile().getName());
      jPanelImageCaja.setImage(new ImageIcon(jFileChooser1.getSelectedFile().getAbsolutePath()).getImage());
    }//GEN-LAST:event_BtnFotoCajaActionPerformed

    private void BtnFotoDesagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoDesagueActionPerformed
        jFileChooser2.showOpenDialog(null);
        TxtFotoDesague.setText(jFileChooser2.getSelectedFile().getAbsolutePath());
        LblCodigoFotoPredio.setText(jFileChooser2.getSelectedFile().getName());
      jPanelImagePredio.setImage(new ImageIcon(jFileChooser2.getSelectedFile().getAbsolutePath()).getImage());
    }//GEN-LAST:event_BtnFotoDesagueActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        try
        {
            if(codigo==1)
            {
            CEMedida oCEMedida=getMedida();
            CDMedida oCDMedida=new CDMedida();
            boolean valor=oCDMedida.registrarMedida(oCEMedida);
            if(valor)
            {
                if(jFileChooser1.getSelectedFile()!=null)
                {
                copiarImagenes(jFileChooser1.getSelectedFile(),1);
                }
                if(jFileChooser2.getSelectedFile()!=null)
                {
                copiarImagenes(jFileChooser2.getSelectedFile(),2);
                }
                JOptionPane.showMessageDialog(null, "Se registro correctamente");
                dispose();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        }
            else
            {
               if(codigo==2)
               {
                CEMedida oCEMedida=getMedida();
                CDMedida oCDMedida=new CDMedida();
                oCEMedida.setIdRegistroMedida(IdRegistroMedida);
                boolean valor=oCDMedida.actualizarMedida(oCEMedida);
                if(valor)
                {
                    if(jFileChooser1.getSelectedFile()!=null)
                    {
                        copiarImagenes(jFileChooser1.getSelectedFile(),1);
                    }
                    if(jFileChooser2.getSelectedFile()!=null)
                    {
                        copiarImagenes(jFileChooser2.getSelectedFile(),1);
                    }

                   JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
                   dispose();
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro");

                }
            }
        }
    }
    catch(Exception ex)
    {
         JOptionPane.showMessageDialog(null, "No se pudo guardar el registro. Campos Incompletos");
         ex.printStackTrace();
    }

    }//GEN-LAST:event_BtnGuardarActionPerformed
    private void copiarImagenes(File in,int tipo){

       try
        {

        FileInputStream fis = new FileInputStream(in.getPath());
        FileOutputStream fos=null;
        if(tipo==1)
        {
        fos = new FileOutputStream("C:/Program Files/FichasCatastral/Imagenes/Caja/"+in.getName());
        }
        else
        {
        fos = new FileOutputStream("C:/Program Files/FichasCatastral/Imagenes/Predio/"+in.getName());
        }
        FileChannel canalFuente = fis.getChannel();
        FileChannel canalDestino = fos.getChannel();
        canalFuente.transferTo(0, canalFuente.size(), canalDestino);
        fis.close();
        fos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();


        }

    }
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
    dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed
    private int getOpcionTipoFuga()
    {
        if(RbtOpcionAntes.isSelected())
        {
            return 1;
        }
        else
        {
           if(RbtOpcionDespues.isSelected())
            {
                return 2;
            }
            else
            {
                return 3;
            }
        }
    }
    private int getOpcionTipoCaracteristica()
    {
        if(RbtOpcionConCaja.isSelected())
        {
            return 1;
        }
        else
        {
           if(RbtOpcionNoDeterminado.isSelected())
            {
                return 2;
            }
            else
                return 3;
        }
    }
    private void BtnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarUsuarioActionPerformed
    DialogGestionCliente oCliente=new DialogGestionCliente(null,true,1,TxtCodigoInscripcion.getText());
    oCliente.setLocationRelativeTo(null);
    oCliente.setVisible(true);
    CECliente oCEClienteSeleccionado=oCliente.getClienteSeleccionado();
    if(oCEClienteSeleccionado!=null)
    {

        LblUsuario.setText(oCEClienteSeleccionado.getApellidoPaternoPropietario());
        LblDireccion.setText(oCEClienteSeleccionado.getDireccion());
        TxtCodigoInscripcion.setText(oCEClienteSeleccionado.getNumeroInscripcion());
        CECondicionConexionAgua oCECondicionConexionAgua = new CECondicionConexionAgua();
        CDCondicionConexionAgua oCDCondicionConexionAgua = new CDCondicionConexionAgua();
        oCECondicionConexionAgua.setIdCondicionConexionAgua(oCEClienteSeleccionado.getIdCondicionConexionAgua());
        CECondicionConexionAgua ooCECondicionConexionAgua = oCDCondicionConexionAgua.DetalleCondicionConexionAgua(oCECondicionConexionAgua);
        LblCondicionConexionConsulta.setText(ooCECondicionConexionAgua.getCondicionConexionAgua());
         CETipoServicio oCETipoServicio = new CETipoServicio();
        CDTipoServicio oCDTipoServicio = new CDTipoServicio();
        oCETipoServicio.setIdTipoServicio(oCEClienteSeleccionado.getIdTipoServicio());
        CETipoServicio ooCETipoServicio = oCDTipoServicio.DetalleServicio(oCETipoServicio);
        LblTipoServicio.setText(ooCETipoServicio.getTipoServicio());
        CbxTipoDocumento.requestFocus();
    }
    }//GEN-LAST:event_BtnBuscarUsuarioActionPerformed

    private void TxtCodigoInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigoInscripcionActionPerformed
     DialogGestionCliente oCliente=new DialogGestionCliente(null,true,1,TxtCodigoInscripcion.getText());
    oCliente.setLocationRelativeTo(null);
    oCliente.setVisible(true);
    CECliente oCEClienteSeleccionado=oCliente.getClienteSeleccionado();
    if(oCEClienteSeleccionado!=null)
    {
        LblUsuario.setText(oCEClienteSeleccionado.getApellidoPaternoPropietario());
        TxtCodigoInscripcion.setText(oCEClienteSeleccionado.getNumeroInscripcion());
        LblDireccion.setText(oCEClienteSeleccionado.getDireccion());
        CECondicionConexionAgua oCECondicionConexionAgua = new CECondicionConexionAgua();
        CDCondicionConexionAgua oCDCondicionConexionAgua = new CDCondicionConexionAgua();
        oCECondicionConexionAgua.setIdCondicionConexionAgua(oCEClienteSeleccionado.getIdCondicionConexionAgua());
        CECondicionConexionAgua ooCECondicionConexionAgua = oCDCondicionConexionAgua.DetalleCondicionConexionAgua(oCECondicionConexionAgua);
        LblCondicionConexion.setText(ooCECondicionConexionAgua.getCondicionConexionAgua());
        CETipoServicio oCETipoServicio = new CETipoServicio();
        CDTipoServicio oCDTipoServicio = new CDTipoServicio();
        oCETipoServicio.setIdTipoServicio(oCEClienteSeleccionado.getIdTipoServicio());
        CETipoServicio ooCETipoServicio = oCDTipoServicio.DetalleServicio(oCETipoServicio);
        LblTipoServicio.setText(ooCETipoServicio.getTipoServicio());
        CbxTipoDocumento.requestFocus();
    }
    }//GEN-LAST:event_TxtCodigoInscripcionActionPerformed

    private void BtnViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViaActionPerformed
        FiltrarVia oFiltrarVia = new FiltrarVia(null, true,TxtNombreVia.getText());
        oFiltrarVia.setVisible(true);
        CEVia oCEVia = oFiltrarVia.GetVia();
        TxtCodigoVia.setText(oCEVia.getCodigo()+"");
        TxtTipoVia.setText(oCEVia.getTipo());
        TxtNombreVia.setText(oCEVia.getNombreVia());
    }//GEN-LAST:event_BtnViaActionPerformed

    private void BtnHabilitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHabilitacionActionPerformed
         FiltrarHabilitacion oFiltrarHabilitacion = new FiltrarHabilitacion(null, true,1,TxtNombreHabilitacion.getText());
        oFiltrarHabilitacion.setVisible(true);
        CEHabilitacion oCEHabitacion = oFiltrarHabilitacion.GetHabilitacion();
        TxtCodigoHabilitacion.setText(oCEHabitacion.getCodigo()+"");
        TxtTipoHabilitacion.setText(oCEHabitacion.getTipo());
        TxtNombreHabilitacion.setText(oCEHabitacion.getNombreHabilitacion());

    }//GEN-LAST:event_BtnHabilitacionActionPerformed

    private void TxtNombreViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreViaActionPerformed
        FiltrarVia oFiltrarVia = new FiltrarVia(null, true,TxtNombreVia.getText());
        oFiltrarVia.setLocationRelativeTo(null);
        oFiltrarVia.setVisible(true);
        CEVia oCEVia = oFiltrarVia.GetVia();
        TxtCodigoVia.setText(oCEVia.getCodigo()+"");
        TxtTipoVia.setText(oCEVia.getTipo());
        TxtNombreVia.setText(oCEVia.getNombreVia());
    }//GEN-LAST:event_TxtNombreViaActionPerformed

    private void TxtNombreHabilitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreHabilitacionActionPerformed
        FiltrarHabilitacion oFiltrarHabilitacion = new FiltrarHabilitacion(null, true,1,TxtNombreHabilitacion.getText());
        oFiltrarHabilitacion.setLocationRelativeTo(null);
        oFiltrarHabilitacion.setVisible(true);
        CEHabilitacion oCEHabitacion = oFiltrarHabilitacion.GetHabilitacion();
        TxtCodigoHabilitacion.setText(oCEHabitacion.getCodigo()+"");
        TxtTipoHabilitacion.setText(oCEHabitacion.getTipo());
        TxtNombreHabilitacion.setText(oCEHabitacion.getNombreHabilitacion());
    }//GEN-LAST:event_TxtNombreHabilitacionActionPerformed

    private void BtnAgregarUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarUsoActionPerformed
     Vector oVector=new Vector();
     oVector.add(0);
     ((DefaultTableModel)TblUsos.getModel()).addRow(oVector);
    }//GEN-LAST:event_BtnAgregarUsoActionPerformed

    private void ChckSiNoIlegibleLecturaMedidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChckSiNoIlegibleLecturaMedidorActionPerformed
    if(ChckSiNoIlegibleLecturaMedidor.isSelected())
    {
        TxtLecturaMedidor.setText("0");
        TxtLecturaMedidor.setEditable(false);
    }
    else
    {
        TxtLecturaMedidor.setText("0");
        TxtLecturaMedidor.setEditable(true);
    }
    }//GEN-LAST:event_ChckSiNoIlegibleLecturaMedidorActionPerformed

    private void ChckSiNoTapaConexionAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChckSiNoTapaConexionAguaActionPerformed
    if(ChckSiNoTapaConexionAgua.isSelected())
    {
       CbxMaterialTapaAgua.setEnabled(true);
       CbxEstadoTapaAgua.setEnabled(true);
    }
    else
    {
       CbxMaterialTapaAgua.setEnabled(false);
       CbxEstadoTapaAgua.setEnabled(false);
       CbxEstadoTapaAgua.setSelectedIndex(0);
       CbxMaterialTapaAgua.setSelectedIndex(0);
    }
    }//GEN-LAST:event_ChckSiNoTapaConexionAguaActionPerformed

    private void ChckSiNoFugaAguaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ChckSiNoFugaAguaItemStateChanged
   
    }//GEN-LAST:event_ChckSiNoFugaAguaItemStateChanged

    private void ChkSiNoIlegibleNumeroMedidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkSiNoIlegibleNumeroMedidorActionPerformed
    if(ChkSiNoIlegibleNumeroMedidor.isSelected())
    {
        TxtNumeroMedidor.setText("");
        TxtNumeroMedidor.setEditable(false);
    }
    else
    {
        TxtNumeroMedidor.setText("");
        TxtNumeroMedidor.setEditable(true);
    }
    }//GEN-LAST:event_ChkSiNoIlegibleNumeroMedidorActionPerformed

    private void ChckSiNoFugaAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChckSiNoFugaAguaActionPerformed
   if(ChckSiNoFugaAgua.isSelected())
    {
       RbtOpcionAntes.setEnabled(true);
       RbtOpcionDespues.setEnabled(true);
       RbtOpcionIndeterminado.setEnabled(true);
    }
    else
    {
       RbtOpcionAntes.setEnabled(false);
       RbtOpcionDespues.setEnabled(false);
       RbtOpcionIndeterminado.setEnabled(false);
    }
    }//GEN-LAST:event_ChckSiNoFugaAguaActionPerformed

    private void CbxMaterialCajaDesagueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxMaterialCajaDesagueItemStateChanged
  
    }//GEN-LAST:event_CbxMaterialCajaDesagueItemStateChanged

    private void CbxTipoServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxTipoServicioItemStateChanged
    
    }//GEN-LAST:event_CbxTipoServicioItemStateChanged

    private void ChkSiNoMedidorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ChkSiNoMedidorItemStateChanged
     if(codigo!=0)
     if(!ChkSiNoMedidor.isSelected())
     {
        TxtNumeroMedidor.setText("");
        TxtMarcaMedidor.setText("");
        TxtLecturaMedidor.setText("0");
        TxtNumeroMedidor.setEditable(false);
        TxtMarcaMedidor.setEditable(false);
        TxtLecturaMedidor.setEditable(false);

        ChkSiNoIlegibleNumeroMedidor.setSelected(false);
        ChckSiNoIlegibleLecturaMedidor.setSelected(false);
        ChkSiNoIlegibleNumeroMedidor.setEnabled(false);
        ChckSiNoIlegibleLecturaMedidor.setEnabled(false);
        CbxDiametroMedidor.setEnabled(false);
        CbxEstadoMedidor.setEnabled(false);
        CbxLlavesPaso.setEnabled(false);
        CbxSeguridadMedidor.setEnabled(false);
        CbxPosicionMedidor.setEnabled(false);
        CbxDiametroMedidor.setSelectedIndex(0);
        CbxEstadoMedidor.setSelectedIndex(0);
        CbxLlavesPaso.setSelectedIndex(0);
        CbxSeguridadMedidor.setSelectedIndex(0);
        CbxPosicionMedidor.setSelectedIndex(0);

     }
    else
    {
        TxtNumeroMedidor.setText("");
        TxtMarcaMedidor.setText("");
        TxtLecturaMedidor.setText("0");
         TxtNumeroMedidor.setEditable(true);
        TxtMarcaMedidor.setEditable(true);
        TxtLecturaMedidor.setEditable(true);
        ChkSiNoIlegibleNumeroMedidor.setSelected(false);
        ChckSiNoIlegibleLecturaMedidor.setSelected(false);
        ChkSiNoIlegibleNumeroMedidor.setEnabled(true);
        ChckSiNoIlegibleLecturaMedidor.setEnabled(true);
        CbxDiametroMedidor.setEnabled(true);
        CbxEstadoMedidor.setEnabled(true);
        CbxLlavesPaso.setEnabled(true);
        CbxSeguridadMedidor.setEnabled(true);
        CbxPosicionMedidor.setEnabled(true);
    }
    }//GEN-LAST:event_ChkSiNoMedidorItemStateChanged

    private void CbxEstadoCajaAguaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxEstadoCajaAguaItemStateChanged
    if(((CEEstadoCajaAgua)CbxEstadoCajaAgua.getSelectedItem()).getIdEstadoCajaAgua()==3)
    {
        
        CbxMaterialCajaAgua.setSelectedIndex(0);
        CbxEstadoTapaAgua.setSelectedIndex(0);
        CbxMaterialTapaAgua.setSelectedIndex(0);
        CbxDiametroConexionAgua.setSelectedIndex(0);
        CbxMaterialCajaAgua.setSelectedIndex(0);
        CbxMaterialConexionAgua.setSelectedIndex(0);
        ChckSiNoTapaConexionAgua.setSelected(false);
        ChckSiNoTapaConexionAgua.setEnabled(false);
        CbxMaterialCajaAgua.setEnabled(false);
        CbxEstadoTapaAgua.setEnabled(false);
        CbxMaterialTapaAgua.setEnabled(false);
        CbxDiametroConexionAgua.setEnabled(false);
        CbxMaterialCajaAgua.setEnabled(false);
        CbxMaterialConexionAgua.setEnabled(false);

    }
    else{
        ChckSiNoTapaConexionAgua.setSelected(true);
        ChckSiNoTapaConexionAgua.setEnabled(true);
        CbxMaterialCajaAgua.setEnabled(true);
        CbxEstadoTapaAgua.setEnabled(true);
        CbxMaterialTapaAgua.setEnabled(true);
        CbxDiametroConexionAgua.setEnabled(true);
        CbxMaterialCajaAgua.setEnabled(true);
        CbxMaterialConexionAgua.setEnabled(true);
    }
    }//GEN-LAST:event_CbxEstadoCajaAguaItemStateChanged

    private void BtnEliminarUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarUsoActionPerformed
     int fila=TblUsos.getSelectedRow();
     if(fila!=-1)
     {
        Object valor=TblUsos.getValueAt(fila,1);
        if(valor instanceof CEUsos)
        {
            ((CEUsos)valor).setCodigo(3);
             oLstUsosEliminados.add((CEUsos)valor);

        }
        ((DefaultTableModel)TblUsos.getModel()).removeRow(fila);
        int suma=0;
         for(int i=0;i<TblUsos.getRowCount();i++)
                            {
                                if(TblUsos.getValueAt(i,7)!=null)
                                {
                                int cant=Integer.parseInt(TblUsos.getValueAt(i,7).toString());
                                suma=cant+suma;
                                }
                                else
                                {
                                suma=0+suma;
                                }
                            }
                            TxtCantidadHabitantesPredio.setText(suma+"");
     }
    }//GEN-LAST:event_BtnEliminarUsoActionPerformed

    private void CbxSituacionConexionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxSituacionConexionItemStateChanged
    if(codigo!=0)    
        if (((CESituacionConexion) CbxSituacionConexion.getSelectedItem()).getIdSituacionConexion() == 2 || ((CESituacionConexion) CbxSituacionConexion.getSelectedItem()).getIdSituacionConexion() == 3)
        {
           jTabbedPane1.setEnabledAt(2,false);
           CbxTipoServicio.setSelectedIndex(0);

            ChkSiNoMedidor.setSelected(false);
            CbxTipoServicio.setSelectedIndex(0);
            CbxSituacionAgua.setSelectedIndex(0);
            CbxEstadoCajaAgua.setSelectedIndex(0);
            ChckSiNoTapaConexionAgua.setSelected(false);
            CbxUbiCajaConexAgua.setSelectedIndex(0);
            CbxMaterialCajaAgua.setSelectedIndex(0);
            CbxCondicionConexionAgua.setSelectedIndex(0);
            CbxMaterialConexionAgua.setSelectedIndex(0);
            CbxDiametroConexionAgua.setSelectedIndex(0);
            ChckSiNoFugaAgua.setSelected(false);
            ChckSiNoTapaConexionAgua.setSelected(false);
            ChckSiNoTapaConexionDesague.setSelected(false);
            RbtOpcionNoDeterminado.setSelected(true);
            CbxEstadoCajaDesague.setSelectedIndex(0);
            CbxEstadoTapaDesague.setSelectedIndex(0);
            CbxMaterialTapaDesague.setSelectedIndex(0);
            CbxUbiCajaConexDesague.setSelectedIndex(0);
            CbxMaterialCajaDesague.setSelectedIndex(0);
            CbxCondicionConexDesague.setSelectedIndex(0);
            CbxMaterialConexionDesague.setSelectedIndex(0);
            CbxDiametroConexionDesague.setSelectedIndex(0);
            ChckSiNoFugaDesague.setSelected(false);
         }
        else
        {
         ChkSiNoMedidor.setSelected(true);
         ChckSiNoFugaAgua.setSelected(true);
         ChckSiNoTapaConexionAgua.setSelected(true);
         ChckSiNoFugaDesague.setSelected(true);
         ChckSiNoTapaConexionAgua.setSelected(true);
         ChckSiNoTapaConexionDesague.setSelected(true);
         jTabbedPane1.setEnabledAt(2,true);

        }
    
    }//GEN-LAST:event_CbxSituacionConexionItemStateChanged

    private void ChckSiNoTapaConexionDesagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChckSiNoTapaConexionDesagueActionPerformed
    if(ChckSiNoTapaConexionDesague.isSelected())
    {
       CbxMaterialTapaDesague.setEnabled(true);
       CbxEstadoTapaDesague.setEnabled(true);
    }
    else
    {
       CbxMaterialTapaDesague.setEnabled(false);
       CbxEstadoTapaDesague.setEnabled(false);
       CbxMaterialTapaDesague.setSelectedIndex(0);
       CbxEstadoTapaDesague.setSelectedIndex(0);
    }

    }//GEN-LAST:event_ChckSiNoTapaConexionDesagueActionPerformed

    private void CbxMaterialConexionDesagueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxMaterialConexionDesagueItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CbxMaterialConexionDesagueItemStateChanged

    private void CbxEstadoCajaDesagueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxEstadoCajaDesagueItemStateChanged
    if(((CEEstadoCajaDesague)CbxEstadoCajaDesague.getSelectedItem()).getIdEstadoCajaDesague()==3)
    {

        CbxMaterialCajaDesague.setSelectedIndex(0);
        CbxEstadoTapaDesague.setSelectedIndex(0);
        CbxMaterialTapaDesague.setSelectedIndex(0);
        CbxDiametroConexionDesague.setSelectedIndex(0);
        CbxMaterialCajaDesague.setSelectedIndex(0);
        CbxMaterialConexionDesague.setSelectedIndex(0);
        ChckSiNoTapaConexionDesague.setSelected(false);
        ChckSiNoTapaConexionDesague.setEnabled(false);
        CbxMaterialCajaDesague.setEnabled(false);
        CbxEstadoTapaDesague.setEnabled(false);
        CbxMaterialTapaDesague.setEnabled(false);
        CbxDiametroConexionDesague.setEnabled(false);
        CbxMaterialCajaDesague.setEnabled(false);
        CbxMaterialConexionDesague.setEnabled(false);

    }
    else{
        ChckSiNoTapaConexionDesague.setSelected(true);
        ChckSiNoTapaConexionDesague.setEnabled(true);
        CbxMaterialCajaDesague.setEnabled(true);
        CbxEstadoTapaDesague.setEnabled(true);
        CbxMaterialTapaDesague.setEnabled(true);
        CbxDiametroConexionDesague.setEnabled(true);
        CbxMaterialCajaDesague.setEnabled(true);
        CbxMaterialConexionDesague.setEnabled(true);
    }
    }//GEN-LAST:event_CbxEstadoCajaDesagueItemStateChanged

    private void CbxEstadoTapaDesagueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxEstadoTapaDesagueItemStateChanged
     if(((CEEstadoTapaDesague)CbxEstadoTapaDesague.getSelectedItem()).getIdEstadoTapaDesague()==3)
    {

        CbxDiametroConexionDesague.setSelectedIndex(0);
        CbxMaterialCajaDesague.setSelectedIndex(0);
        CbxDiametroConexionDesague.setEnabled(false);
        CbxMaterialCajaDesague.setEnabled(false);

    }
    else{
         CbxDiametroConexionDesague.setEnabled(true);
         CbxMaterialCajaDesague.setEnabled(true);
    }
    }//GEN-LAST:event_CbxEstadoTapaDesagueItemStateChanged

    private void CbxEstadoTapaAguaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxEstadoTapaAguaItemStateChanged
    if(((CEEstadoTapaAgua)CbxEstadoTapaAgua.getSelectedItem()).getIdEstadoTapaAgua()==3)
    {

        CbxDiametroConexionAgua.setSelectedIndex(0);
        CbxMaterialCajaAgua.setSelectedIndex(0);
        CbxDiametroConexionAgua.setEnabled(false);
        CbxMaterialCajaAgua.setEnabled(false);

    }
    else{
         CbxDiametroConexionAgua.setEnabled(true);
         CbxMaterialCajaAgua.setEnabled(true);
    }
    }//GEN-LAST:event_CbxEstadoTapaAguaItemStateChanged

    private void CbxSituacionAguaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxSituacionAguaItemStateChanged
    if(((CESituacionAgua)CbxSituacionAgua.getSelectedItem()).getIdSituacionAgua()==5)
    {

        CbxEstadoCajaAgua.setSelectedIndex(0);
        ChckSiNoTapaConexionAgua.setSelected(false);
        CbxEstadoTapaAgua.setSelectedIndex(0);
        CbxMaterialTapaAgua.setSelectedIndex(0);
        
        CbxEstadoCajaAgua.setEnabled(false);
        ChckSiNoTapaConexionAgua.setEnabled(false);
        CbxEstadoTapaAgua.setEnabled(false);
        CbxMaterialTapaAgua.setEnabled(false);

    }
    else{
        CbxEstadoCajaAgua.setEnabled(true);
        ChckSiNoTapaConexionAgua.setEnabled(true);
        CbxEstadoTapaAgua.setEnabled(true);
        CbxMaterialTapaAgua.setEnabled(true);
    }
    }//GEN-LAST:event_CbxSituacionAguaItemStateChanged

    private void RbtOpcionSinCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtOpcionSinCajaActionPerformed
    if(RbtOpcionSinCaja.isSelected())
    {

        CbxEstadoCajaDesague.setSelectedIndex(0);
        ChckSiNoTapaConexionDesague.setSelected(false);
        CbxEstadoTapaDesague.setSelectedIndex(0);
        CbxMaterialTapaDesague.setSelectedIndex(0);
        CbxUbiCajaConexDesague.setSelectedIndex(0);
        CbxMaterialCajaDesague.setSelectedIndex(0);

        CbxEstadoCajaAgua.setEnabled(false);
        ChckSiNoTapaConexionDesague.setEnabled(false);
        CbxEstadoTapaDesague.setEnabled(false);
        CbxMaterialTapaDesague.setEnabled(false);
        CbxUbiCajaConexDesague.setEnabled(false);
        CbxMaterialCajaDesague.setEnabled(false);

    }
    else{
        CbxEstadoCajaDesague.setEnabled(true);
        ChckSiNoTapaConexionDesague.setEnabled(true);
        CbxEstadoTapaDesague.setEnabled(true);
        CbxMaterialTapaDesague.setEnabled(true);
        CbxUbiCajaConexDesague.setEnabled(true);
        CbxMaterialCajaDesague.setEnabled(true);
    }
    }//GEN-LAST:event_RbtOpcionSinCajaActionPerformed
    private void limpiarEtiquetasDeConsulta(){
        
    }
    private CEMedida getMedida(){
        CEMedida oCEMedida=new CEMedida();
        oCEMedida.setNumeroFicha(TxtNumeroFicha.getText());//1
        CESituacionConexion oSituacionConexion=(CESituacionConexion)CbxSituacionConexion.getSelectedItem();
        oCEMedida.setIdSituacionConexion(oSituacionConexion.getIdSituacionConexion());//2
        oCEMedida.setCodDepartamento(TxtDepartamento.getText());//3
        oCEMedida.setCodProvincia(TxtProvincia.getText());//4
        oCEMedida.setCodDistrito(TxtDistrito.getText());//5
        oCEMedida.setSeccion(TxtSeccion.getText());//6
        oCEMedida.setManzana(TxtManzana.getText());//7
        oCEMedida.setLote(TxtLote.getText());//8
        oCEMedida.setConexion(TxtConexion.getText());//9 OK

        oCEMedida.setCod_Inscripcion(TxtCodigoInscripcion.getText());//10
        oCEMedida.setRutaLectura(TxtRutaLectura.getText());//11
        oCEMedida.setRutaReparto(TxtRutaReparto.getText());//12
        oCEMedida.setSecuencia(TxtSecuencia.getText());//13
        oCEMedida.setCategoria(TxtCategoria.getText());//14 OK

        CETipoDocumento oCETipoDocumento=(CETipoDocumento)CbxTipoDocumento.getSelectedItem();
        oCEMedida.setIdTipoDocumento(oCETipoDocumento.getIdTipoDocumento());//15
        
        oCEMedida.setNumeroDocumento(TxtNumDocumento.getText());//16
        oCEMedida.setTelefono(TxtTelefono.getText());//17
        oCEMedida.setApellidoPaternoPropietario(TxtApellidoPaternoPropietario.getText());//18
        oCEMedida.setApellidoMaternoPropietario(TxtApellidoMaternoPropietario.getText());//19
        oCEMedida.setNombrePropietario(TxtNombrePropietario.getText());//20
        oCEMedida.setApellidoPaternoConyugue(TxtApellidoPaternoConyugue.getText());//21
        oCEMedida.setApellidoMaternoConyugue(TxtApellidoMaternoConyugue.getText());//22 OK

        oCEMedida.setNombreConyugue(TxtNombreConyugue.getText());//23
        oCEMedida.setCorreoElectronico(TxtCorreoElectronico.getText());//24
        CETipoPropiedad oCETipoPropiedad=(CETipoPropiedad)CbxTipoPropiedad.getSelectedItem();
        oCEMedida.setIdTipoPropiedad(oCETipoPropiedad.getIdTipoPropiedad());//25
        oCEMedida.setCantHabitantesPredio(Integer.parseInt(TxtCantidadHabitantesPredio.getText()));//26
        oCEMedida.setNumPiso(Integer.parseInt(TxtNumPisos.getText()));//27
        CETipoPredio oCETipoPredio=(CETipoPredio)CbxTipoPredio.getSelectedItem();
        oCEMedida.setIdTipoPredio(oCETipoPredio.getIdTipoPredio());//28 OK


        oCEMedida.setCodigoVia(TxtCodigoVia.getText());//29
        oCEMedida.setTipoVia(TxtTipoVia.getText());//30
        oCEMedida.setNombreVia(TxtNombreVia.getText());//31
        oCEMedida.setNumMunicipal(TxtNumMunicipal.getText());//32
        oCEMedida.setCodigoHabilitacion(TxtCodigoHabilitacion.getText());//33
        oCEMedida.setTipoHabilitacion(TxtTipoHabilitacion.getText());//34
        oCEMedida.setNombreHabilitacion(TxtNombreHabilitacion.getText());//35
        oCEMedida.setNumManzana(TxtNumeroManzana.getText());//36 OK


        oCEMedida.setNumLote(TxtNumeroLote.getText());//37
        oCEMedida.setBlock(TxtBlock.getText());//38
        oCEMedida.setPiso(TxtPiso.getText());//39
        oCEMedida.setNumero(TxtNumero.getText());//40
        CEUsoPredio oCEUsoPredio=(CEUsoPredio)CbxUsoPredio.getSelectedItem();
        oCEMedida.setIdUsoPredio(oCEUsoPredio.getIdUsoPredio());//41 ok


        oCEMedida.setComplemento(TxtComplemento.getText());//42
        oCEMedida.setSiNoPredioHabilitado(ChckSiNoPredioHabilitado.isSelected());//43
        CETipoServicio oCETipoServicio=(CETipoServicio)CbxTipoServicio.getSelectedItem();
        oCEMedida.setIdTipoServicio(oCETipoServicio.getIdTipoServicio());//44
        CEMedioAbastecimiento oCEMedioAbastecimiento=(CEMedioAbastecimiento)CbxMedioAbastecimiento.getSelectedItem();
        oCEMedida.setIdMedioAbastecimiento(oCEMedioAbastecimiento.getIdMedioAbastecimiento());//45
        CESituacionPredio oCESituacionPredio=(CESituacionPredio)CbxSituacionPredio.getSelectedItem();
        oCEMedida.setIdSituacionPredio(oCESituacionPredio.getIdSituacionPredio());//46
        CETipoAlmacenamiento oCETipoAlmacenamiento=(CETipoAlmacenamiento) CbxTipoAlmacenamiento.getSelectedItem();
        oCEMedida.setIdTipoAlmacenamiento(oCETipoAlmacenamiento.getIdTipoAlmacenamiento());//47

        oCEMedida.setPorcentajeDomestico(Double.parseDouble(TxtPorcentajeDomestico.getText()));//48
        oCEMedida.setPorcentajeComercial(Double.parseDouble(TxtPorcentajeComercial.getText()));//49
        oCEMedida.setPorcentajeEstatal(Double.parseDouble(TxtPorcentajeEstatal.getText()));//50
        oCEMedida.setPorcentajeSocial(Double.parseDouble(TxtPorcentajeSocial.getText()));//51

        oCEMedida.setSiNoMedidor(ChkSiNoMedidor.isSelected());//52
        oCEMedida.setNumeroMedidor(TxtNumeroMedidor.getText());//53
        oCEMedida.setSiNoIlegibleNumMedidor(ChkSiNoIlegibleNumeroMedidor.isSelected());//54
        oCEMedida.setMarcaMedidor(TxtMarcaMedidor.getText());//55
        oCEMedida.setLectura(Double.parseDouble(TxtLecturaMedidor.getText()));//56
        oCEMedida.setSiNoIlegibleLectura(ChckSiNoIlegibleLecturaMedidor.isSelected());//57


        CEDiametroMedidor oCEDiametroMedidor=(CEDiametroMedidor)CbxDiametroMedidor.getSelectedItem();
        oCEMedida.setIdDiametroMedidor(oCEDiametroMedidor.getIdDiametroMedidor());//58
        CEEstadoMedidor oCEEstadoMedidor=(CEEstadoMedidor)CbxEstadoMedidor.getSelectedItem();
        oCEMedida.setIdEstadoMedidor(oCEEstadoMedidor.getIdEstadoMedidor());//59 ok


        CELlavesPaso oCELlavesPaso=(CELlavesPaso)CbxLlavesPaso.getSelectedItem();
        oCEMedida.setIdLlavePaso(oCELlavesPaso.getIdLlavesPaso());//60
        CESeguridadMedidor oCESeguridadMedidor=(CESeguridadMedidor)CbxSeguridadMedidor.getSelectedItem();
        oCEMedida.setIdSeguridadMedidor(oCESeguridadMedidor.getIdSeguridadMedidor());//61
        CEPosicionMedidor oCEPosicionMedidor=(CEPosicionMedidor)CbxPosicionMedidor.getSelectedItem();
        oCEMedida.setIdPosicionMedidor(oCEPosicionMedidor.getIdPosicionMedidor());//62
        CESituacionAgua oCESituacionAgua=(CESituacionAgua)CbxSituacionAgua.getSelectedItem();
        oCEMedida.setIdSituacionAgua(oCESituacionAgua.getIdSituacionAgua());//63
        CEUbiCajaConexAgua oCEUbiCajaConexAgua=(CEUbiCajaConexAgua)CbxUbiCajaConexAgua.getSelectedItem();
        oCEMedida.setIdUbiCajaConexAgua(oCEUbiCajaConexAgua.getIdUbiCajaConexAgua());//64
        CEDiametroConexionAgua oCEDiametroConexionAgua=(CEDiametroConexionAgua)CbxDiametroConexionAgua.getSelectedItem();
        oCEMedida.setIdDiametroConexionAgua(oCEDiametroConexionAgua.getIdDiametroConexionAgua());//65 ok


        CECondicionConexionAgua oCECondicionConexionAgua=(CECondicionConexionAgua)CbxCondicionConexionAgua.getSelectedItem();
        oCEMedida.setIdCondicionConexionAgua(oCECondicionConexionAgua.getIdCondicionConexionAgua());//66
        CEMaterialCajaAgua oCEMaterialCajaAgua=(CEMaterialCajaAgua)CbxMaterialCajaAgua.getSelectedItem();
        oCEMedida.setIdMaterialCajaAgua(oCEMaterialCajaAgua.getIdMaterialCajaAgua());//67
        CEEstadoCajaAgua oCEEstadoCajaAgua=(CEEstadoCajaAgua)CbxEstadoCajaAgua.getSelectedItem();
        oCEMedida.setIdEstadoCajaAgua(oCEEstadoCajaAgua.getIdEstadoCajaAgua());//68
        oCEMedida.setIdMaterialConexionAgua(((CEMaterialConexionAgua)CbxMaterialConexionAgua.getSelectedItem()).getIdMaterialConexionAgua());//69
        oCEMedida.setIdMaterialConexionDesague(((CEMaterialConexionDesague)CbxMaterialConexionDesague.getSelectedItem()).getIdMaterialConexionDesague());//69
        oCEMedida.setIdTipoCaracteristicasCajaDesague(getOpcionTipoCaracteristica());//opcion
        oCEMedida.setSiNoTapaConexionAgua(ChckSiNoTapaConexionAgua.isSelected());//70

        CEMaterialTapaAgua oCEMaterialTapaAgua=(CEMaterialTapaAgua)CbxMaterialTapaAgua.getSelectedItem();
        oCEMedida.setIdMaterialTapaAgua(oCEMaterialTapaAgua.getIdMaterialTapaAgua());//68

        CEEstadoTapaAgua oCEEstadoTapaAgua=(CEEstadoTapaAgua)CbxEstadoTapaAgua.getSelectedItem();
        oCEMedida.setIdEstadoTapaAgua(oCEEstadoTapaAgua.getIdEstadoTapaAgua());//68

        oCEMedida.setSiNoFugaAgua(ChckSiNoFugaAgua.isSelected());//71
        oCEMedida.setTipoFugaAgua(getOpcionTipoFuga());//72 ok

        CEUbiCajaConexDesague oCEUbiCajaConexDesague=(CEUbiCajaConexDesague) CbxUbiCajaConexDesague.getSelectedItem();
        oCEMedida.setIdUbiCajaConexDesague(oCEUbiCajaConexDesague.getIdUbiCajaConexDesague());//74
        CEDiametroConexionDesague oCEDiametroConexionDesague=(CEDiametroConexionDesague)CbxDiametroConexionDesague.getSelectedItem();
        oCEMedida.setIdDiametroConexionDesague(oCEDiametroConexionDesague.getIdDiametroConexionDesague());//75
        CECondicionConexionDesague oCECondicionConexionDesague=(CECondicionConexionDesague)CbxCondicionConexDesague.getSelectedItem();
        oCEMedida.setIdCondicionConexionDesague(oCECondicionConexionDesague.getIdCondicionConexionDesague());//76
        CEMaterialCajaDesague oCEMaterialCajaDesague=(CEMaterialCajaDesague)CbxMaterialCajaDesague.getSelectedItem();
        oCEMedida.setIdMaterialCajaDesague(oCEMaterialCajaDesague.getIdMaterialCajaDesague());//77
        CEMaterialTapaDesague oCEMaterialTapaDesague=(CEMaterialTapaDesague)CbxMaterialTapaDesague.getSelectedItem();
        oCEMedida.setIdMaterialTapaDesague(oCEMaterialTapaDesague.getIdMaterialTapaDesague());//78   ok


        CEEstadoTapaDesague oCEEstadoTapaDesague=(CEEstadoTapaDesague)CbxEstadoTapaDesague.getSelectedItem();
        oCEMedida.setIdEstadoTapaDesague(oCEEstadoTapaDesague.getIdEstadoTapaDesague());//79
        CEEstadoCajaDesague oCEEstadoCajaDesague=(CEEstadoCajaDesague)CbxEstadoCajaDesague.getSelectedItem();
        oCEMedida.setIdEstadoCajaDesague(oCEEstadoCajaDesague.getIdEstadoCajaDesague());//80
        oCEMedida.setSiNoFugaDesague(ChckSiNoFugaDesague.isSelected());//81
        CEPavimentacion oCEPavimentacion=(CEPavimentacion)CbxPavimentacion.getSelectedItem();
        oCEMedida.setIdPavimentacion(oCEPavimentacion.getIdPavimentacion());//82
        CEVereda oCEVereda=(CEVereda)CbxVereda.getSelectedItem();
        oCEMedida.setIdVereda(oCEVereda.getIdVereda());//83 ok


        CEPozoArtesanal oCEPozoArtesanal=(CEPozoArtesanal)CbxPozoArtesanal.getSelectedItem();
        oCEMedida.setIdPozoArtesanal(oCEPozoArtesanal.getIdPozoArtesanal());//84
        oCEMedida.setFrecuenciaAbastecimientoHorasPorDia(Double.parseDouble(TxtHorasPorDia.getText()));//85
        oCEMedida.setFrecuenciaAbastecimientoDiasPorSemana(Double.parseDouble(TxtDiaPorSemana.getText()));//86 ok

        oCEMedida.setObservaciones(TxtObservaciones.getText());//87
        oCEMedida.setApellidoPaternoEntrevistado(TxtApellidoPaternoEntrevistado.getText());//88
        oCEMedida.setApellidoMaternoEntrevistado(TxtApellidoMaternoEntrevistado.getText());//89
        oCEMedida.setNombreCompletoEntrevistado(TxtNombreEntrevistado.getText());//90
        oCEMedida.setDocumentoEntrevistado(TxtNumeroDocumentoEntrevistado.getText());//91
        CETipoPropiedadInquilino oCETipoPropiedadEntrevistado=(CETipoPropiedadInquilino)CbxTipoPropiedadEntrevistado.getSelectedItem();
        oCEMedida.setIdTipoPropiedadEntrevistado(oCETipoPropiedadEntrevistado.getIdTipoPropiedadInquilino());//92 ok

        oCEMedida.setCodigoFotoCaja(LblCodigoFotoCaja.getText());//93
        oCEMedida.setCodigoFotoPredio(LblCodigoFotoPredio.getText());//94
        oCEMedida.setUbicacionConexionAgua(Double.parseDouble(TxtUbiConexAgua.getText()));//95
        oCEMedida.setUbicacionConexionDesague(Double.parseDouble(TxtUbiConexDesague.getText()));//96
        oCEMedida.setCod_Encuestador(TxtCodigoEncuestador.getText());//97
        oCEMedida.setIdTipoFotoAgua(RbtAgua.isSelected()?1:2);
        ConvertidorFecha oConvertidorFecha=new ConvertidorFecha();
        if(DateFechaEncuestador.getCalendar()!=null)
        {
        oConvertidorFecha.setFecha(DateFechaEncuestador.getCalendar());
        oConvertidorFecha.setFechaConvertida();
        oCEMedida.setFecha_Encuestador(oConvertidorFecha.getFechaConvertida()+"");//98
        }

        oCEMedida.setCod_Supervisor(TxtCodigoSupervisor.getText());//99
        if(DateFechaSupervision.getCalendar()!=null)
        {
        oConvertidorFecha.setFecha(DateFechaSupervision.getCalendar());
        oConvertidorFecha.setFechaConvertida();
        oCEMedida.setFecha_Supervisor(oConvertidorFecha.getFechaConvertida()+"");//100
        }
        oCEMedida.setCod_Digitado(TxtCodigoDigitador.getText());//101
        if(DateFechaDigitador.getCalendar()!=null)
        {
        oConvertidorFecha.setFecha(DateFechaDigitador.getCalendar());
        oConvertidorFecha.setFechaConvertida();
        oCEMedida.setFecha_Digitador(oConvertidorFecha.getFechaConvertida()+"");//102
        }
        oCEMedida.setoLstUsos(getLstUsos());
        return oCEMedida;
    }
    private void setLstUsos(ArrayList<CEUsos> oLst)
    {
        for(CEUsos oCEUsos:oLst)
        {
            Vector oVector=new Vector();
            oVector.add(oCEUsos.getCodigo());
            oVector.add(oCEUsos);
            oVector.add(oCEUsos.getNumero());
            oVector.add(oCEUsos.getRespo());
            oVector.add(oCEUsos.getTipoUso());
            oVector.add(oCEUsos.getCodUso());
            oVector.add(oCEUsos.getPtosAgua());
            oVector.add(oCEUsos.getNumPersona());
            oVector.add(oCEUsos.getComplemento());
            oVector.add(oCEUsos.getCategoria());
            ((DefaultTableModel)TblUsos.getModel()).addRow(oVector);
        }

    }
    private ArrayList<CEUsos> getLstUsos()
    {

        ArrayList<CEUsos> oLstUsos =new ArrayList<CEUsos>();
        int size=TblUsos.getRowCount();
        for(int i=0;i<size;i++)
        {
           Object valor=TblUsos.getValueAt(i,1);
           int codigoI=Integer.parseInt(TblUsos.getValueAt(i,0).toString());
            CEUsos oCEUsos=new CEUsos();
           if(valor instanceof CEUsos)
           {
           
             oCEUsos.setIdUso(oCEUsos.getIdUso());
             oCEUsos.setCodigo(codigoI);
             
           }
           else
           {
             oCEUsos.setCodigo(1);         
           }
         oCEUsos.setNumero(TblUsos.getValueAt(i, 2).toString());
         oCEUsos.setRespo(TblUsos.getValueAt(i, 3).toString());
         oCEUsos.setTipoUso(TblUsos.getValueAt(i, 4).toString());
         oCEUsos.setCodUso(TblUsos.getValueAt(i, 5).toString());
         oCEUsos.setPtosAgua(TblUsos.getValueAt(i, 6).toString());
         oCEUsos.setNumPersona(TblUsos.getValueAt(i, 7)==null?"0":TblUsos.getValueAt(i, 7).toString());
         oCEUsos.setComplemento(TblUsos.getValueAt(i, 8).toString());
         oCEUsos.setCategoria(TblUsos.getValueAt(i, 9).toString());
         oLstUsos.add(oCEUsos);
        }

        for(CEUsos oCeu:oLstUsosEliminados)
        {
            oLstUsos.add(oCeu);
        }
        return oLstUsos;
    }

    private void setMedida(CEMedida oCEMedida)
    {
        jPanelImageCaja.setImage(new ImageIcon(("C:/Program Files/FichasCatastral/Imagenes/Caja/"+oCEMedida.getCodigoFotoCaja())).getImage());
        jPanelImagePredio.setImage(new ImageIcon(("C:/Program Files/FichasCatastral/Imagenes/Predio/"+oCEMedida.getCodigoFotoPredio())).getImage());
        TxtNumeroFicha.setText(oCEMedida.getNumeroFicha()+"");
        buscarSituacionConexion(oCEMedida.getIdSituacionConexion());
        TxtDepartamento.setText(oCEMedida.getCodDepartamento());
        TxtProvincia.setText(oCEMedida.getCodProvincia());
        TxtDistrito.setText(oCEMedida.getCodDistrito());
        TxtSeccion.setText(oCEMedida.getSeccion()+"");
        TxtManzana.setText(oCEMedida.getManzana()+"");
        TxtLote.setText(oCEMedida.getLote()+"");
        TxtConexion.setText(oCEMedida.getConexion()+"");
        TxtCodigoInscripcion.setText(oCEMedida.getCod_Inscripcion()+"");
        TxtRutaLectura.setText(oCEMedida.getRutaLectura()+"");
        TxtRutaReparto.setText(oCEMedida.getRutaReparto()+"");
        TxtSecuencia.setText(oCEMedida.getSecuencia()+"");
        TxtCategoria.setText(oCEMedida.getCategoria()+"");
        buscarTipoDocumento(oCEMedida.getIdTipoDocumento());
        TxtNumDocumento.setText(oCEMedida.getNumeroDocumento()+"");
        TxtTelefono.setText(oCEMedida.getTelefono()+"");
        TxtApellidoPaternoPropietario.setText(oCEMedida.getApellidoPaternoPropietario());
        TxtApellidoMaternoPropietario.setText(oCEMedida.getApellidoMaternoPropietario());
        TxtNombrePropietario.setText(oCEMedida.getNombrePropietario());
        TxtApellidoPaternoConyugue.setText(oCEMedida.getApellidoPaternoConyugue());
        TxtApellidoMaternoConyugue.setText(oCEMedida.getApellidoMaternoConyugue());
        TxtNombreConyugue.setText(oCEMedida.getNombreConyugue());
        TxtCorreoElectronico.setText(oCEMedida.getCorreoElectronico());
        buscarTipoPropiedad(oCEMedida.getIdTipoPropiedad());
        TxtCantidadHabitantesPredio.setText(oCEMedida.getCantHabitantesPredio()+"");
        TxtNumPisos.setText(oCEMedida.getNumPiso()+"");
        buscarTipoPredio(oCEMedida.getIdTipoPredio());
        TxtCodigoVia.setText(oCEMedida.getCodigoVia()+"");
        TxtTipoVia.setText(oCEMedida.getTipoVia());
        TxtNombreVia.setText(oCEMedida.getNombreVia());
        TxtNumMunicipal.setText(oCEMedida.getNumMunicipal());
        TxtCodigoHabilitacion.setText(oCEMedida.getCodigoVia()+"");
        TxtTipoHabilitacion.setText(oCEMedida.getTipoVia());
        TxtNombreHabilitacion.setText(oCEMedida.getNombreVia());
        TxtNumeroManzana.setText(oCEMedida.getNumManzana());
        TxtNumeroLote.setText(oCEMedida.getNumLote());
        TxtBlock.setText(oCEMedida.getBlock());
        TxtPiso.setText(oCEMedida.getPiso());
        TxtNumero.setText(oCEMedida.getNumero());
        buscarUsoPredio(oCEMedida.getIdUsoPredio());
        TxtComplemento.setText(oCEMedida.getComplemento());
        ChckSiNoPredioHabilitado.setSelected(oCEMedida.isSiNoPredioHabilitado());
        buscarTipoServicio(oCEMedida.getIdTipoServicio());
        buscarMedioAbastecimiento(oCEMedida.getIdMedioAbastecimiento());
        buscarSituacionPredio(oCEMedida.getIdSituacionPredio());
        buscarTipoAlmacenamiento(oCEMedida.getIdTipoAlmacenamiento());
        TxtPorcentajeComercial.setText(oCEMedida.getPorcentajeComercial()+"");
        TxtPorcentajeDomestico.setText(oCEMedida.getPorcentajeDomestico()+"");
        TxtPorcentajeEstatal.setText(oCEMedida.getPorcentajeEstatal()+"");
        TxtPorcentajeSocial.setText(oCEMedida.getPorcentajeSocial()+"");
        ChkSiNoMedidor.setSelected(oCEMedida.isSiNoMedidor());
        TxtNumeroMedidor.setText(oCEMedida.getNumeroMedidor());
        ChkSiNoIlegibleNumeroMedidor.setSelected(oCEMedida.isSiNoIlegibleNumMedidor());
        TxtMarcaMedidor.setText(oCEMedida.getMarcaMedidor());
        TxtLecturaMedidor.setText(oCEMedida.getLectura()+"");
        ChckSiNoIlegibleLecturaMedidor.setSelected(oCEMedida.isSiNoIlegibleLectura());
        buscarMaterialTapaAgua(oCEMedida.getIdMaterialTapaAgua());
        buscarDiametroMedidor(oCEMedida.getIdDiametroMedidor());
        buscarEstadoMedidor(oCEMedida.getIdEstadoMedidor());
        buscarLlavesPaso(oCEMedida.getIdLlavePaso());
        buscarEstadoMedidor(oCEMedida.getIdEstadoMedidor());
        buscarSeguridadMedidor(oCEMedida.getIdSeguridadMedidor());
        buscarPosicionMedidor(oCEMedida.getIdPosicionMedidor());
        buscarSituacionAgua(oCEMedida.getIdSituacionAgua());
        buscarUbiCajaConexAgua(oCEMedida.getIdUbiCajaConexAgua());
        buscarDiametroConexionAgua(oCEMedida.getIdDiametroConexionAgua());
        buscarCondicionConexionAgua(oCEMedida.getIdCondicionConexionAgua());
        buscarMaterialConexionAgua(oCEMedida.getIdMaterialConexionAgua());
        buscarMaterialConexionDesague(oCEMedida.getIdMaterialConexionDesague());
        if(oCEMedida.getIdTipoCaracteristicasCajaDesague()==1)
        {
            RbtOpcionConCaja.setSelected(true);
        }
        else
        {
            if(oCEMedida.getTipoFugaAgua()==3)
            {
                RbtOpcionNoDeterminado.setSelected(true);
            }
            else
            {
                RbtOpcionSinCaja.setSelected(true);
            }
        }
        if(oCEMedida.getIdTipoFotoAgua()==1)
        {
            RbtAgua.setSelected(true);
        }
        else
        {
            RbtDesague.setSelected(true);
        }
        buscarEstadoCajaAgua(oCEMedida.getIdEstadoCajaAgua());
        buscarMaterialCajaAgua(oCEMedida.getIdMaterialCajaAgua());
        buscarEstadoTapaAgua(oCEMedida.getIdEstadoTapaAgua());
        ChckSiNoFugaAgua.setSelected(oCEMedida.isSiNoFugaAgua());
        // tipo fuga
        if(oCEMedida.getTipoFugaAgua()==1)
        {
            RbtOpcionAntes.setSelected(true);
        }
        else
        {
            if(oCEMedida.getTipoFugaAgua()==2)
            {
                RbtOpcionDespues.setSelected(true);
            }
            else
            {
                RbtOpcionIndeterminado.setSelected(true);
            }
        }
        buscarUbiCajaConexDesague(oCEMedida.getIdUbiCajaConexDesague());
        buscarDiametroConexDesague(oCEMedida.getIdDiametroConexionDesague());
        buscarCondicionConexDesague(oCEMedida.getIdCondicionConexionDesague());
        buscarMaterialCajaDesague(oCEMedida.getIdMaterialCajaDesague());
        buscarMaterialTapaDesague(oCEMedida.getIdMaterialTapaDesague());
        buscarEstadoTapaDesague(oCEMedida.getIdEstadoTapaDesague());
        buscarEstadoCajaDesague(oCEMedida.getIdEstadoCajaDesague());
        ChckSiNoFugaDesague.setSelected(oCEMedida.isSiNoFugaDesague());
        buscarPavimentacion(oCEMedida.getIdPavimentacion());
        buscarVereda(oCEMedida.getIdVereda());
        buscarPozoArtesanal(oCEMedida.getIdPozoArtesanal());
        TxtHorasPorDia.setText(oCEMedida.getFrecuenciaAbastecimientoHorasPorDia()+"");
        TxtDiaPorSemana.setText(oCEMedida.getFrecuenciaAbastecimientoDiasPorSemana()+"");
        TxtObservaciones.setText(oCEMedida.getObservaciones());
        TxtApellidoPaternoEntrevistado.setText(oCEMedida.getApellidoPaternoEntrevistado());
        TxtApellidoMaternoEntrevistado.setText(oCEMedida.getApellidoMaternoEntrevistado());
        TxtNombreEntrevistado.setText(oCEMedida.getNombreCompletoEntrevistado());
        TxtNumeroDocumentoEntrevistado.setText(oCEMedida.getDocumentoEntrevistado());
        buscarTipoPropiedadEntrevistado(oCEMedida.getIdTipoPropiedadEntrevistado());
        LblCodigoFotoCaja.setText(oCEMedida.getCodigoFotoCaja());
        LblCodigoFotoPredio.setText(oCEMedida.getCodigoFotoPredio());
        TxtUbiConexAgua.setText(oCEMedida.getUbicacionConexionAgua()+"");
        TxtUbiConexDesague.setText(oCEMedida.getUbicacionConexionDesague()+"");
        TxtCodigoEncuestador.setText(oCEMedida.getCod_Encuestador());
        TxtCodigoDigitador.setText(oCEMedida.getCod_Digitado());
        TxtCodigoSupervisor.setText(oCEMedida.getCod_Supervisor());
        if(oCEMedida.getFecha_Encuestador()!=null)
        {
        int ano=Integer.parseInt(oCEMedida.getFecha_Encuestador().substring(0,4));
        int mes=Integer.parseInt(oCEMedida.getFecha_Encuestador().substring(5,7));
        int dia=Integer.parseInt(oCEMedida.getFecha_Encuestador().substring(8,10));
        DateFechaEncuestador.setCalendar(new GregorianCalendar(ano,mes-1,dia));
        }
        if(oCEMedida.getFecha_Supervisor()!=null)
        {
        int ano1=Integer.parseInt(oCEMedida.getFecha_Supervisor().substring(0,4));
        int mes1=Integer.parseInt(oCEMedida.getFecha_Supervisor().substring(5,7));
        int dia1=Integer.parseInt(oCEMedida.getFecha_Supervisor().substring(8,10));
        DateFechaSupervision.setCalendar(new GregorianCalendar(ano1,mes1-1,dia1));
        }
        if(oCEMedida.getFecha_Digitador()!=null)
        {
        int ano2=Integer.parseInt(oCEMedida.getFecha_Digitador().substring(0,4));
        int mes2=Integer.parseInt(oCEMedida.getFecha_Digitador().substring(5,7));
        int dia2=Integer.parseInt(oCEMedida.getFecha_Digitador().substring(8,10));
        DateFechaDigitador.setCalendar(new GregorianCalendar(ano2,mes2-1,dia2));
        }
        setLstUsos(oCEMedida.getoLstUsos());
    }
    private void buscarTipoPropiedadEntrevistado(int IdSituacionConexion)
    {
        for(int i=0;i<CbxTipoPropiedadEntrevistado.getItemCount();i++)
        {
            if(IdSituacionConexion==((CETipoPropiedadInquilino)CbxTipoPropiedadEntrevistado.getItemAt(i)).getIdTipoPropiedadInquilino())
            {
                CbxTipoPropiedadEntrevistado.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarSituacionConexion(int IdSituacionConexion)
    {
        for(int i=0;i<CbxSituacionConexion.getItemCount();i++)
        {
            if(IdSituacionConexion==((CESituacionConexion)CbxSituacionConexion.getItemAt(i)).getIdSituacionConexion())
            {
                CbxSituacionConexion.setSelectedIndex(i);
                break;
            }
        }
    }
     private void buscarTipoDocumento(int IdTipoDocumento)
    {
         
        for(int i=0;i<CbxTipoDocumento.getItemCount();i++)
        {
            if(IdTipoDocumento==((CETipoDocumento)CbxTipoDocumento.getItemAt(i)).getIdTipoDocumento())
            {
                CbxTipoDocumento.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarTipoPropiedad(int IdTipoDocumento)
    {
        for(int i=0;i<CbxTipoPropiedad.getItemCount();i++)
        {
            if(IdTipoDocumento==((CETipoPropiedad)CbxTipoPropiedad.getItemAt(i)).getIdTipoPropiedad())
            {
                CbxTipoPropiedad.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarTipoPredio(int IdTipoDocumento)
    {
        for(int i=0;i<CbxTipoPredio.getItemCount();i++)
        {
            if(IdTipoDocumento==((CETipoPredio)CbxTipoPredio.getItemAt(i)).getIdTipoPredio())
            {
                CbxTipoPredio.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarUsoPredio(int IdTipoDocumento)
    {
        for(int i=0;i<CbxUsoPredio.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEUsoPredio)CbxUsoPredio.getItemAt(i)).getIdUsoPredio())
            {
                CbxUsoPredio.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarTipoServicio(int IdTipoDocumento)
    {
        for(int i=0;i<CbxTipoServicio.getItemCount();i++)
        {
            if(IdTipoDocumento==((CETipoServicio)CbxTipoServicio.getItemAt(i)).getIdTipoServicio())
            {
                CbxTipoServicio.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarMedioAbastecimiento(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMedioAbastecimiento.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMedioAbastecimiento)CbxMedioAbastecimiento.getItemAt(i)).getIdMedioAbastecimiento())
            {
                CbxMedioAbastecimiento.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarSituacionPredio(int IdTipoDocumento)
    {
        for(int i=0;i<CbxSituacionPredio.getItemCount();i++)
        {
            if(IdTipoDocumento==((CESituacionPredio)CbxSituacionPredio.getItemAt(i)).getIdSituacionPredio())
            {
                CbxSituacionPredio.setSelectedIndex(i);
                break;
            }
        }
    }
     private void buscarTipoAlmacenamiento(int IdTipoDocumento)
    {
        for(int i=0;i<CbxTipoAlmacenamiento.getItemCount();i++)
        {
            if(IdTipoDocumento==((CETipoAlmacenamiento)CbxTipoAlmacenamiento.getItemAt(i)).getIdTipoAlmacenamiento())
            {
                CbxTipoAlmacenamiento.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarDiametroMedidor(int IdTipoDocumento)
    {
        for(int i=0;i<CbxDiametroMedidor.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEDiametroMedidor)CbxDiametroMedidor.getItemAt(i)).getIdDiametroMedidor())
            {
                CbxDiametroMedidor.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarEstadoMedidor(int IdTipoDocumento)
    {
        for(int i=0;i<CbxEstadoMedidor.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEEstadoMedidor)CbxEstadoMedidor.getItemAt(i)).getIdEstadoMedidor())
            {
                CbxEstadoMedidor.setSelectedIndex(i);
                break;
            }
        }
    }
     private void buscarLlavesPaso(int IdTipoDocumento)
    {
        for(int i=0;i<CbxLlavesPaso.getItemCount();i++)
        {
            if(IdTipoDocumento==((CELlavesPaso)CbxLlavesPaso.getItemAt(i)).getIdLlavesPaso())
            {
                CbxLlavesPaso.setSelectedIndex(i);
                break;
            }
        }
    }
       private void buscarSeguridadMedidor(int IdTipoDocumento)
    {
        for(int i=0;i<CbxSeguridadMedidor.getItemCount();i++)
        {
            if(IdTipoDocumento==((CESeguridadMedidor)CbxSeguridadMedidor.getItemAt(i)).getIdSeguridadMedidor())
            {
                CbxSeguridadMedidor.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarPosicionMedidor(int IdTipoDocumento)
    {
        for(int i=0;i<CbxPosicionMedidor.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEPosicionMedidor)CbxPosicionMedidor.getItemAt(i)).getIdPosicionMedidor())
            {
                CbxPosicionMedidor.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarSituacionAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxSituacionAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CESituacionAgua)CbxSituacionAgua.getItemAt(i)).getIdSituacionAgua())
            {
                CbxSituacionAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarUbiCajaConexAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxUbiCajaConexAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEUbiCajaConexAgua)CbxUbiCajaConexAgua.getItemAt(i)).getIdUbiCajaConexAgua())
            {
                CbxUbiCajaConexAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarDiametroConexionAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxDiametroConexionAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEDiametroConexionAgua)CbxDiametroConexionAgua.getItemAt(i)).getIdDiametroConexionAgua())
            {
                CbxDiametroConexionAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarCondicionConexionAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxCondicionConexionAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CECondicionConexionAgua)CbxCondicionConexionAgua.getItemAt(i)).getIdCondicionConexionAgua())
            {
                CbxCondicionConexionAgua.setSelectedIndex(i);
                break;
            }
        }
    }
       private void buscarMaterialConexionAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialConexionAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialConexionAgua)CbxMaterialConexionAgua.getItemAt(i)).getIdMaterialConexionAgua())
            {
                CbxMaterialConexionAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarMaterialConexionDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialConexionDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialConexionDesague)CbxMaterialConexionDesague.getItemAt(i)).getIdMaterialConexionDesague())
            {
                CbxMaterialConexionDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarEstadoCajaAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxEstadoCajaAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEEstadoCajaAgua)CbxEstadoCajaAgua.getItemAt(i)).getIdEstadoCajaAgua())
            {
                CbxEstadoCajaAgua.setSelectedIndex(i);
                break;
            }
        }
    }
  private void buscarMaterialCajaAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialCajaAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialCajaAgua)CbxMaterialCajaAgua.getItemAt(i)).getIdMaterialCajaAgua())
            {
                CbxMaterialCajaAgua.setSelectedIndex(i);
                break;
            }
        }
    }
   private void buscarEstadoTapaAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxEstadoTapaAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEEstadoTapaAgua)CbxEstadoTapaAgua.getItemAt(i)).getIdEstadoTapaAgua())
            {
                CbxEstadoTapaAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarUbiCajaConexDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxUbiCajaConexDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEUbiCajaConexDesague)CbxUbiCajaConexDesague.getItemAt(i)).getIdUbiCajaConexDesague())
            {
                CbxUbiCajaConexDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarDiametroConexDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxDiametroConexionDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEDiametroConexionDesague)CbxDiametroConexionDesague.getItemAt(i)).getIdDiametroConexionDesague())
            {
                CbxDiametroConexionDesague.setSelectedIndex(i);
                break;
            }
        }
    }
      private void buscarCondicionConexDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxCondicionConexDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CECondicionConexionDesague)CbxCondicionConexDesague.getItemAt(i)).getIdCondicionConexionDesague())
            {
                CbxCondicionConexDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarMaterialCajaDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialCajaDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialCajaDesague)CbxMaterialCajaDesague.getItemAt(i)).getIdMaterialCajaDesague())
            {
                CbxMaterialCajaDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarMaterialTapaDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialTapaDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialTapaDesague)CbxMaterialTapaDesague.getItemAt(i)).getIdMaterialTapaDesague())
            {
                CbxMaterialTapaDesague.setSelectedIndex(i);
                break;
            }
        }
    }
   private void buscarMaterialTapaAgua(int IdTipoDocumento)
    {
        for(int i=0;i<CbxMaterialTapaAgua.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEMaterialTapaAgua)CbxMaterialTapaAgua.getItemAt(i)).getIdMaterialTapaAgua())
            {
                CbxMaterialTapaAgua.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarEstadoTapaDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxEstadoTapaDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEEstadoTapaDesague)CbxEstadoTapaDesague.getItemAt(i)).getIdEstadoTapaDesague())
            {
                CbxEstadoTapaDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarEstadoCajaDesague(int IdTipoDocumento)
    {
        for(int i=0;i<CbxEstadoCajaDesague.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEEstadoCajaDesague)CbxEstadoCajaDesague.getItemAt(i)).getIdEstadoCajaDesague())
            {
                CbxEstadoCajaDesague.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarPavimentacion(int IdTipoDocumento)
    {
        for(int i=0;i<CbxPavimentacion.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEPavimentacion)CbxPavimentacion.getItemAt(i)).getIdPavimentacion())
            {
                CbxPavimentacion.setSelectedIndex(i);
                break;
            }
        }
    }
    private void buscarVereda(int IdTipoDocumento)
    {
        for(int i=0;i<CbxVereda.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEVereda)CbxVereda.getItemAt(i)).getIdVereda())
            {
                CbxVereda.setSelectedIndex(i);
                break;
            }
        }
    }
        private void buscarPozoArtesanal(int IdTipoDocumento)
    {
        for(int i=0;i<CbxPozoArtesanal.getItemCount();i++)
        {
            if(IdTipoDocumento==((CEPozoArtesanal)CbxPozoArtesanal.getItemAt(i)).getIdPozoArtesanal())
            {
                CbxPozoArtesanal.setSelectedIndex(i);
                break;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarUso;
    private javax.swing.JButton BtnBuscarUsuario;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminarUso;
    private javax.swing.JButton BtnFotoCaja;
    private javax.swing.JButton BtnFotoDesague;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnHabilitacion;
    private javax.swing.JButton BtnVia;
    private javax.swing.JComboBox CbxCondicionConexDesague;
    private javax.swing.JComboBox CbxCondicionConexionAgua;
    private javax.swing.JComboBox CbxDiametroConexionAgua;
    private javax.swing.JComboBox CbxDiametroConexionDesague;
    private javax.swing.JComboBox CbxDiametroMedidor;
    private javax.swing.JComboBox CbxEstadoCajaAgua;
    private javax.swing.JComboBox CbxEstadoCajaDesague;
    private javax.swing.JComboBox CbxEstadoMedidor;
    private javax.swing.JComboBox CbxEstadoTapaAgua;
    private javax.swing.JComboBox CbxEstadoTapaDesague;
    private javax.swing.JComboBox CbxLlavesPaso;
    private javax.swing.JComboBox CbxMaterialCajaAgua;
    private javax.swing.JComboBox CbxMaterialCajaDesague;
    private javax.swing.JComboBox CbxMaterialConexionAgua;
    private javax.swing.JComboBox CbxMaterialConexionDesague;
    private javax.swing.JComboBox CbxMaterialTapaAgua;
    private javax.swing.JComboBox CbxMaterialTapaDesague;
    private javax.swing.JComboBox CbxMedioAbastecimiento;
    private javax.swing.JComboBox CbxPavimentacion;
    private javax.swing.JComboBox CbxPosicionMedidor;
    private javax.swing.JComboBox CbxPozoArtesanal;
    private javax.swing.JComboBox CbxSeguridadMedidor;
    private javax.swing.JComboBox CbxSituacionAgua;
    private javax.swing.JComboBox CbxSituacionConexion;
    private javax.swing.JComboBox CbxSituacionPredio;
    private javax.swing.JComboBox CbxTipoAlmacenamiento;
    private javax.swing.JComboBox CbxTipoDocumento;
    private javax.swing.JComboBox CbxTipoPredio;
    private javax.swing.JComboBox CbxTipoPropiedad;
    private javax.swing.JComboBox CbxTipoPropiedadEntrevistado;
    private javax.swing.JComboBox CbxTipoServicio;
    private javax.swing.JComboBox CbxUbiCajaConexAgua;
    private javax.swing.JComboBox CbxUbiCajaConexDesague;
    private javax.swing.JComboBox CbxUsoPredio;
    private javax.swing.JComboBox CbxVereda;
    private javax.swing.JCheckBox ChckSiNoFugaAgua;
    private javax.swing.JCheckBox ChckSiNoFugaDesague;
    private javax.swing.JCheckBox ChckSiNoIlegibleLecturaMedidor;
    private javax.swing.JCheckBox ChckSiNoPredioHabilitado;
    private javax.swing.JCheckBox ChckSiNoTapaConexionAgua;
    private javax.swing.JCheckBox ChckSiNoTapaConexionDesague;
    private javax.swing.JCheckBox ChkSiNoIlegibleNumeroMedidor;
    private javax.swing.JCheckBox ChkSiNoMedidor;
    private com.toedter.calendar.JDateChooser DateFechaDigitador;
    private com.toedter.calendar.JDateChooser DateFechaEncuestador;
    private com.toedter.calendar.JDateChooser DateFechaSupervision;
    private javax.swing.JLabel LblCodigoFotoCaja;
    private javax.swing.JLabel LblCodigoFotoPredio;
    private javax.swing.JLabel LblCondicionConexion;
    private javax.swing.JLabel LblCondicionConexionConsulta;
    private javax.swing.JLabel LblCondicionConexionDesague;
    private javax.swing.JLabel LblDireccion;
    private javax.swing.JLabel LblTipoServicio;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JRadioButton RbtAgua;
    private javax.swing.JRadioButton RbtDesague;
    private javax.swing.JRadioButton RbtOpcionAntes;
    private javax.swing.JRadioButton RbtOpcionConCaja;
    private javax.swing.JRadioButton RbtOpcionDespues;
    private javax.swing.JRadioButton RbtOpcionIndeterminado;
    private javax.swing.JRadioButton RbtOpcionNoDeterminado;
    private javax.swing.JRadioButton RbtOpcionSinCaja;
    private javax.swing.JTable TblUsos;
    private javax.swing.JTextField TxtApellidoMaternoConyugue;
    private javax.swing.JTextField TxtApellidoMaternoEntrevistado;
    private javax.swing.JTextField TxtApellidoMaternoPropietario;
    private javax.swing.JTextField TxtApellidoPaternoConyugue;
    private javax.swing.JTextField TxtApellidoPaternoEntrevistado;
    private javax.swing.JTextField TxtApellidoPaternoPropietario;
    private javax.swing.JTextField TxtBlock;
    private javax.swing.JTextField TxtCantidadHabitantesPredio;
    private javax.swing.JTextField TxtCategoria;
    private javax.swing.JTextField TxtCodigoDigitador;
    private javax.swing.JTextField TxtCodigoEncuestador;
    private javax.swing.JTextField TxtCodigoHabilitacion;
    private javax.swing.JTextField TxtCodigoInscripcion;
    private javax.swing.JTextField TxtCodigoSupervisor;
    private javax.swing.JTextField TxtCodigoVia;
    private javax.swing.JTextField TxtComplemento;
    private javax.swing.JTextField TxtConexion;
    private javax.swing.JTextField TxtCorreoElectronico;
    private javax.swing.JTextField TxtDepartamento;
    private javax.swing.JTextField TxtDiaPorSemana;
    private javax.swing.JTextField TxtDistrito;
    private javax.swing.JTextField TxtFotoCaja;
    private javax.swing.JTextField TxtFotoDesague;
    private javax.swing.JTextField TxtHorasPorDia;
    private javax.swing.JTextField TxtLecturaMedidor;
    private javax.swing.JTextField TxtLote;
    private javax.swing.JTextField TxtManzana;
    private javax.swing.JTextField TxtMarcaMedidor;
    private javax.swing.JTextField TxtNombreConyugue;
    private javax.swing.JTextField TxtNombreEntrevistado;
    private javax.swing.JTextField TxtNombreHabilitacion;
    private javax.swing.JTextField TxtNombrePropietario;
    private javax.swing.JTextField TxtNombreVia;
    private javax.swing.JTextField TxtNumDocumento;
    private javax.swing.JTextField TxtNumMunicipal;
    private javax.swing.JTextField TxtNumPisos;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtNumeroDocumentoEntrevistado;
    private javax.swing.JTextField TxtNumeroFicha;
    private javax.swing.JTextField TxtNumeroLote;
    private javax.swing.JTextField TxtNumeroManzana;
    private javax.swing.JTextField TxtNumeroMedidor;
    private javax.swing.JTextArea TxtObservaciones;
    private javax.swing.JTextField TxtPiso;
    private javax.swing.JTextField TxtPorcentajeComercial;
    private javax.swing.JTextField TxtPorcentajeDomestico;
    private javax.swing.JTextField TxtPorcentajeEstatal;
    private javax.swing.JTextField TxtPorcentajeSocial;
    private javax.swing.JTextField TxtProvincia;
    private javax.swing.JTextField TxtRutaLectura;
    private javax.swing.JTextField TxtRutaReparto;
    private javax.swing.JTextField TxtSeccion;
    private javax.swing.JTextField TxtSecuencia;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTipoHabilitacion;
    private javax.swing.JTextField TxtTipoVia;
    private javax.swing.JTextField TxtUbiConexAgua;
    private javax.swing.JTextField TxtUbiConexDesague;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox jComboBox35;
    private javax.swing.JComboBox jComboBox36;
    private javax.swing.JComboBox jComboBox37;
    private javax.swing.JComboBox jComboBox39;
    private javax.swing.JComboBox jComboBox40;
    private javax.swing.JComboBox jComboBox41;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private util.JPanelImage jPanelImageCaja;
    private util.JPanelImage jPanelImagePredio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField80;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
