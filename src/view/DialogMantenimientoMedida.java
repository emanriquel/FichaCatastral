package view;

import java.util.ArrayList;
import javax.swing.JComboBox;
import modelo.datos.CDCondicionConexionAgua;
import modelo.datos.CDCondicionConexionDesague;
import modelo.datos.CDDiametroConexionAgua;
import modelo.datos.CDDiametroConexionDesague;
import modelo.datos.CDDiametroMedidor;
import modelo.datos.CDEstadoCajaAgua;
import modelo.datos.CDEstadoCajaDesague;
import modelo.datos.CDEstadoMedidor;
import modelo.datos.CDEstadoTapaDesague;
import modelo.datos.CDLlavesPaso;
import modelo.datos.CDMaterialCajaAgua;
import modelo.datos.CDMaterialCajaDesague;
import modelo.datos.CDMaterialTapaDesague;
import modelo.datos.CDMedioAbastecimiento;
import modelo.datos.CDPavimentacion;
import modelo.datos.CDPosicionMedidor;
import modelo.datos.CDPozoArtesanal;
import modelo.datos.CDSeguridadMedidor;
import modelo.datos.CDSituacionAgua;
import modelo.datos.CDSituacionConexion;
import modelo.datos.CDSituacionPredio;
import modelo.datos.CDTipoDocumento;
import modelo.datos.CDTipoPredio;
import modelo.datos.CDTipoPropiedad;
import modelo.datos.CDTipoPropiedadInquilino;
import modelo.datos.CDTipoServicio;
import modelo.datos.CDUbiCajaConexAgua;
import modelo.datos.CDUbiCajaConexDesague;
import modelo.datos.CDUsoPredio;
import modelo.datos.CDVereda;
import util.ArrayListComboBoxModel;

public class DialogMantenimientoMedida extends javax.swing.JDialog {

    private int codigo;
    public DialogMantenimientoMedida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBox();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
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
        TxtNombrePropietario1 = new javax.swing.JTextField();
        TxtApellidoPaternoPropietario2 = new javax.swing.JTextField();
        TxtApellidoMaternoPropietario2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField29 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TxtNumMunicipal = new javax.swing.JTextField();
        TxtCodigoVia = new javax.swing.JTextField();
        TxtNombreVia = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        TxtTipoVia = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        CbxTipoServicio1 = new javax.swing.JComboBox();
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
        ChkSiNoIlegible = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        ChkSiNoMedidor = new javax.swing.JCheckBox();
        TxtLecturaMedidor = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        ChckSiNoIlegible = new javax.swing.JCheckBox();
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
        CbxEstadoCajaAgua = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        TxtMaterialConexionAgua = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        ChckSiNoTapa = new javax.swing.JCheckBox();
        ChckSiNoFuga = new javax.swing.JCheckBox();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        RbtOpcionAntes = new javax.swing.JRadioButton();
        RbtOpcionDespues = new javax.swing.JRadioButton();
        RbtOpcionIndeterminado = new javax.swing.JRadioButton();
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
        ChckSiNoFugaDesague = new javax.swing.JCheckBox();
        jLabel85 = new javax.swing.JLabel();
        CbxMaterialTapaDesague = new javax.swing.JComboBox();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        CbxEstadoCajaDesague = new javax.swing.JComboBox();
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
        TxtNumeroDocumento = new javax.swing.JTextField();
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
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Ficha de Datos Catastrales");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel3.setText("EPS EMAPAVIGSSA");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ficha Numero");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Situación de Conexión:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Identificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

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

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Distrito");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel9.setText("Nuevo Código Catastral");

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sección");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Manzana");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lote");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Conex");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Codigo Inscripción");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ruta de Lectura");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);

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

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Categoría");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel9))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
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
                .addComponent(TxtCodigoInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
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
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
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
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtRutaLectura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRutaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Apellido Paterno del Propietario");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);

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

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText("Num. Documento:");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText("Correo Electrónico:");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("Telefono:");

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Apellido Paterno del Conyugue");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel25.setOpaque(true);

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

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("Tipo de Documento:");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel29.setForeground(new java.awt.Color(0, 0, 102));
        jLabel29.setText("Tipo Propiedad:");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText("Cant. Habitantes del Predio:");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText("Num. Pisos:");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("Tipo Predio:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(8, 8, 8)
                        .addComponent(CbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22)
                        .addGap(10, 10, 10)
                        .addComponent(TxtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24)
                        .addGap(8, 8, 8)
                        .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
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
                    .addComponent(CbxTipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 1", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Inmueble(Dirección de Conexión)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

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

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Block");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);

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

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("Complemento:");

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setText("Uso del Predio:");

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("Tipo Servicio:");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel48.setForeground(new java.awt.Color(0, 0, 102));
        jLabel48.setText("Medio de Abastecimiento:");

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel49.setForeground(new java.awt.Color(0, 0, 102));
        jLabel49.setText("¿Predio Habilitado?:");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setText("Situación del Predio:");

        TxtApellidoPaternoPropietario2.setEditable(false);

        TxtApellidoMaternoPropietario2.setEditable(false);

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

        jButton3.setText("...");

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Código Habilitación");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setOpaque(true);

        jButton4.setText("...");

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Num. Municipal");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Nombre de Vía");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setOpaque(true);

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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtApellidoPaternoPropietario2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtApellidoMaternoPropietario2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombrePropietario1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(CbxTipoServicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCodigoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtNumMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtApellidoPaternoPropietario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtApellidoMaternoPropietario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtNombrePropietario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
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
                    .addComponent(ChckSiNoPredioHabilitado))
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
                    .addComponent(CbxTipoServicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        TblUsos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Respo", "Tipo de Uso", "Cod. Uso", "Ptos Agua", "Num. Persona", "Complemento", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblUsos);

        BtnAgregarUso.setText("+");

        BtnEliminarUso.setText("-");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setText("% Domestico:");

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("% Comercial:");

        jLabel53.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel53.setForeground(new java.awt.Color(0, 0, 102));
        jLabel53.setText("% Estatal:");

        jLabel54.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel54.setForeground(new java.awt.Color(0, 0, 102));
        jLabel54.setText("% Social:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                        .addComponent(TxtPorcentajeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel73.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel73.setForeground(new java.awt.Color(0, 0, 102));
        jLabel73.setText("¿Tiene Medidor?");

        ChkSiNoMedidor.setSelected(true);

        jLabel74.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel74.setForeground(new java.awt.Color(0, 0, 102));
        jLabel74.setText("Lectura Medidor:");

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
                .addGap(14, 14, 14)
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
                        .addComponent(ChkSiNoIlegible, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(ChckSiNoIlegible, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGap(6, 6, 6)
                        .addComponent(CbxDiametroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel70)
                        .addGap(19, 19, 19)
                        .addComponent(CbxEstadoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxLlavesPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(33, 33, 33)
                        .addComponent(CbxSeguridadMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxPosicionMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChkSiNoMedidor))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumeroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChkSiNoIlegible)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMarcaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtLecturaMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoIlegible))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxDiametroMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxEstadoMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxLlavesPaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSeguridadMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxPosicionMedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la Conexion del Agua", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel87.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel87.setForeground(new java.awt.Color(0, 0, 102));
        jLabel87.setText("Situación:");

        jLabel88.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel88.setForeground(new java.awt.Color(0, 0, 102));
        jLabel88.setText("Ubi/Caja/Conex:");

        jLabel89.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel89.setForeground(new java.awt.Color(0, 0, 102));
        jLabel89.setText("Diametro de Conex:");

        jLabel90.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel90.setForeground(new java.awt.Color(0, 0, 102));
        jLabel90.setText("Cond. Conex:");

        jLabel91.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel91.setForeground(new java.awt.Color(0, 0, 102));
        jLabel91.setText("Mat. Caja:");

        jLabel92.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel92.setForeground(new java.awt.Color(0, 0, 102));
        jLabel92.setText("Estado Caja:");

        jLabel68.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel68.setForeground(new java.awt.Color(0, 0, 102));
        jLabel68.setText("Mat. de la Conexión:");

        jLabel79.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel79.setForeground(new java.awt.Color(0, 0, 102));
        jLabel79.setText("¿Con Tapa?");

        jLabel80.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel80.setForeground(new java.awt.Color(0, 0, 102));
        jLabel80.setText("Tipo de Fuga:");

        jLabel81.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel81.setForeground(new java.awt.Color(0, 0, 102));
        jLabel81.setText("¿Fugas?");

        buttonGroup1.add(RbtOpcionAntes);
        RbtOpcionAntes.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionAntes.setText("Antes");

        buttonGroup1.add(RbtOpcionDespues);
        RbtOpcionDespues.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionDespues.setText("Después");

        buttonGroup1.add(RbtOpcionIndeterminado);
        RbtOpcionIndeterminado.setFont(new java.awt.Font("Arial", 1, 11));
        RbtOpcionIndeterminado.setText("Indeterminado");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(CbxSituacionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(CbxUbiCajaConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxDiametroConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxCondicionConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(CbxMaterialCajaAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxEstadoCajaAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TxtMaterialConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ChckSiNoTapa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ChckSiNoFuga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(RbtOpcionAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(RbtOpcionDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(RbtOpcionIndeterminado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxSituacionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxUbiCajaConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxDiametroConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxCondicionConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxMaterialCajaAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxEstadoCajaAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMaterialConexionAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoTapa))
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoFuga)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RbtOpcionAntes)
                    .addComponent(RbtOpcionDespues)
                    .addComponent(RbtOpcionIndeterminado)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la Conexion del Desague", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel93.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel93.setForeground(new java.awt.Color(0, 0, 102));
        jLabel93.setText("Ubi/Caja/Conex:");

        jLabel95.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel95.setForeground(new java.awt.Color(0, 0, 102));
        jLabel95.setText("Diametro de Conex:");

        jLabel96.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel96.setForeground(new java.awt.Color(0, 0, 102));
        jLabel96.setText("Cond. Conex:");

        jLabel97.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel97.setForeground(new java.awt.Color(0, 0, 102));
        jLabel97.setText("Mat. Caja:");

        jLabel98.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel98.setForeground(new java.awt.Color(0, 0, 102));
        jLabel98.setText("Estado Tapa:");

        jLabel85.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel85.setForeground(new java.awt.Color(0, 0, 102));
        jLabel85.setText("¿Fugas?");

        jLabel99.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel99.setForeground(new java.awt.Color(0, 0, 102));
        jLabel99.setText("Mat. Tapa:");

        jLabel100.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel100.setForeground(new java.awt.Color(0, 0, 102));
        jLabel100.setText("Estado Caja:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxUbiCajaConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxDiametroConexionDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxCondicionConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(CbxMaterialCajaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(CbxMaterialTapaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxEstadoTapaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxEstadoCajaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ChckSiNoFugaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxUbiCajaConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxDiametroConexionDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxCondicionConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxMaterialCajaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxMaterialTapaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxEstadoTapaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxEstadoCajaDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChckSiNoFugaDesague)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Entrevistado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel55.setBackground(new java.awt.Color(204, 204, 204));
        jLabel55.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel55.setForeground(new java.awt.Color(0, 0, 102));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Apellido Paterno ");
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel55.setOpaque(true);

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
                            .addComponent(TxtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CbxTipoPropiedadEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(TxtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxTipoPropiedadEntrevistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubicación de la Conexión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel110.setBackground(new java.awt.Color(204, 204, 204));
        jLabel110.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel110.setForeground(new java.awt.Color(0, 0, 102));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Ub. Conex de Agua");
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel110.setOpaque(true);

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
        jLabel106.setText("Foto Desagüe:");

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

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340)
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(TxtFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(BtnFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(TxtFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(BtnFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(TxtUbiConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TxtUbiConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
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
                        .addComponent(DateFechaDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
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
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFotoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFotoDesague, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtUbiConexAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUbiConexDesague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaEncuestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaSupervision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCodigoDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pag 4", jPanel10);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(274, 274, 274)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFotoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoCajaActionPerformed
      jFileChooser1.showOpenDialog(null);
      TxtFotoCaja.setText(jFileChooser2.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_BtnFotoCajaActionPerformed

    private void BtnFotoDesagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoDesagueActionPerformed
        jFileChooser2.showOpenDialog(null);
        TxtFotoDesague.setText(jFileChooser2.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_BtnFotoDesagueActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
    dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarUso;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminarUso;
    private javax.swing.JButton BtnFotoCaja;
    private javax.swing.JButton BtnFotoDesague;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JComboBox CbxCondicionConexDesague;
    private javax.swing.JComboBox CbxCondicionConexionAgua;
    private javax.swing.JComboBox CbxDiametroConexionAgua;
    private javax.swing.JComboBox CbxDiametroConexionDesague;
    private javax.swing.JComboBox CbxDiametroMedidor;
    private javax.swing.JComboBox CbxEstadoCajaAgua;
    private javax.swing.JComboBox CbxEstadoCajaDesague;
    private javax.swing.JComboBox CbxEstadoMedidor;
    private javax.swing.JComboBox CbxEstadoTapaDesague;
    private javax.swing.JComboBox CbxLlavesPaso;
    private javax.swing.JComboBox CbxMaterialCajaAgua;
    private javax.swing.JComboBox CbxMaterialCajaDesague;
    private javax.swing.JComboBox CbxMaterialTapaDesague;
    private javax.swing.JComboBox CbxMedioAbastecimiento;
    private javax.swing.JComboBox CbxPavimentacion;
    private javax.swing.JComboBox CbxPosicionMedidor;
    private javax.swing.JComboBox CbxPozoArtesanal;
    private javax.swing.JComboBox CbxSeguridadMedidor;
    private javax.swing.JComboBox CbxSituacionAgua;
    private javax.swing.JComboBox CbxSituacionConexion;
    private javax.swing.JComboBox CbxSituacionPredio;
    private javax.swing.JComboBox CbxTipoDocumento;
    private javax.swing.JComboBox CbxTipoPredio;
    private javax.swing.JComboBox CbxTipoPropiedad;
    private javax.swing.JComboBox CbxTipoPropiedadEntrevistado;
    private javax.swing.JComboBox CbxTipoServicio;
    private javax.swing.JComboBox CbxTipoServicio1;
    private javax.swing.JComboBox CbxUbiCajaConexAgua;
    private javax.swing.JComboBox CbxUbiCajaConexDesague;
    private javax.swing.JComboBox CbxUsoPredio;
    private javax.swing.JComboBox CbxVereda;
    private javax.swing.JCheckBox ChckSiNoFuga;
    private javax.swing.JCheckBox ChckSiNoFugaDesague;
    private javax.swing.JCheckBox ChckSiNoIlegible;
    private javax.swing.JCheckBox ChckSiNoPredioHabilitado;
    private javax.swing.JCheckBox ChckSiNoTapa;
    private javax.swing.JCheckBox ChkSiNoIlegible;
    private javax.swing.JCheckBox ChkSiNoMedidor;
    private com.toedter.calendar.JDateChooser DateFechaDigitador;
    private com.toedter.calendar.JDateChooser DateFechaEncuestador;
    private com.toedter.calendar.JDateChooser DateFechaSupervision;
    private javax.swing.JRadioButton RbtOpcionAntes;
    private javax.swing.JRadioButton RbtOpcionDespues;
    private javax.swing.JRadioButton RbtOpcionIndeterminado;
    private javax.swing.JTable TblUsos;
    private javax.swing.JTextField TxtApellidoMaternoConyugue;
    private javax.swing.JTextField TxtApellidoMaternoEntrevistado;
    private javax.swing.JTextField TxtApellidoMaternoPropietario;
    private javax.swing.JTextField TxtApellidoMaternoPropietario2;
    private javax.swing.JTextField TxtApellidoPaternoConyugue;
    private javax.swing.JTextField TxtApellidoPaternoEntrevistado;
    private javax.swing.JTextField TxtApellidoPaternoPropietario;
    private javax.swing.JTextField TxtApellidoPaternoPropietario2;
    private javax.swing.JTextField TxtBlock;
    private javax.swing.JTextField TxtCantidadHabitantesPredio;
    private javax.swing.JTextField TxtCategoria;
    private javax.swing.JTextField TxtCodigoDigitador;
    private javax.swing.JTextField TxtCodigoEncuestador;
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
    private javax.swing.JTextField TxtMaterialConexionAgua;
    private javax.swing.JTextField TxtNombreConyugue;
    private javax.swing.JTextField TxtNombreEntrevistado;
    private javax.swing.JTextField TxtNombrePropietario;
    private javax.swing.JTextField TxtNombrePropietario1;
    private javax.swing.JTextField TxtNombreVia;
    private javax.swing.JTextField TxtNumDocumento;
    private javax.swing.JTextField TxtNumMunicipal;
    private javax.swing.JTextField TxtNumPisos;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtNumeroDocumento;
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
    private javax.swing.JTextField TxtTipoVia;
    private javax.swing.JTextField TxtUbiConexAgua;
    private javax.swing.JTextField TxtUbiConexDesague;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel85;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField29;
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
