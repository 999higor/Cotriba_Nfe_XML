/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfe_xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author higor
 */
public class FormMenu extends javax.swing.JFrame 
{

    /**
     * Creates new form FormMenu
     */
    public FormMenu() 
    {
        initComponents();
        //xmlPathFinal.hide();
        //xmlPathInit.hide();
       
        
    }
    
    private void manipularXML(String input, String output)
    {
        
        System.out.println(input);
        System.out.println(output);
        try 
        {
            ///leitura do xml
            DocumentBuilderFactory dbc = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbc.newDocumentBuilder();
            Document doc = db.parse(input);           
            Element raiz = doc.getDocumentElement();
            NodeList nfe = raiz.getChildNodes();
            
            //System.out.println(xmlPathInit.getText());
            
            
            ///grava xml
            DocumentBuilderFactory dbcGrava = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbGrava = dbcGrava.newDocumentBuilder();
            Document docXML = dbGrava.newDocument();
            
            for (int i = 0; i < nfe.getLength(); i++) 
            {
                if(nfe.item(i).getNodeName().equals("NFe")) ///entra no Nfe
                {
                    NodeList nfeChild = nfe.item(i).getChildNodes();
                    
                    for (int j = 0; j <nfeChild.getLength() ; j++) 
                    {
                        if(nfeChild.item(j).getNodeName().equals("infNFe")) ///entra no infNfe
                        {                           
                            ///leitura
                            Element element = (Element) nfeChild.item(j);     
                            String id = element.getAttribute("Id");
                            //System.out.println("id :"+id);
                            NodeList infNFeChild = nfeChild.item(j).getChildNodes();
                            
                            ///gravacao root principal e attr id
                            Element infNfeGrava = docXML.createElement("infNfe");
                            docXML.appendChild(infNfeGrava);
                            Attr idGrava = docXML.createAttribute("Id");
                            idGrava.setValue(id);                                        
                            infNfeGrava.setAttributeNode(idGrava);                              
                            
                            for (int k = 0; k < infNFeChild.getLength(); k++) 
                            {
                                
                                if(infNFeChild.item(k).getNodeName().equals("ide")) ///entra no ide
                                {
                                    NodeList ide = infNFeChild.item(k).getChildNodes();
                                    
                                    ///grava ide
                                    Element ideGrava = docXML.createElement("ide");
                                    infNfeGrava.appendChild(ideGrava);
                                    
                                    for (int l = 0; l <ide.getLength() ; l++) 
                                    {
                                        //System.out.println(ide.item(l).getNodeName()+": "+ide.item(l).getTextContent());
                                        
                                        Element ideChildGrava = docXML.createElement(ide.item(l).getNodeName());
                                        
                                        switch(ide.item(l).getNodeName())
                                        {
                                            case "cUF":
                                                if(cUF.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                            
                                            case "cNF":
                                                if(cNF.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "natOp":
                                                if(natOp.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                            
                                            case "mod":
                                                if(mod.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "serie":
                                                if(serie.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "nNF":
                                                if(nNF.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "dhEmi":
                                                if(dhEmi.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "dhSaiEnt":
                                                if(dhSaiEnt.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpNF":
                                                if(tpNF.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "idDest":
                                                if(idDest.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "cMunFG":
                                                if(cMunFG.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpImp":
                                                if(tpImp.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpEmis":
                                                if(tpEmis.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "cDV":
                                                if(cDV.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpAmb":
                                                if(tpAmb.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "finNFe":
                                                if(finNFe.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "indFinal":
                                                if(indFinal.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "indPres":
                                                if(indPres.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "procEmi":
                                                if(procEmi.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "verProc":
                                                if(verProc.isSelected())
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                        }
                                        /*
                                        ///gravacao child ide
                                        Element ideChildGrava = docXML.createElement(ide.item(l).getNodeName());
                                        ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                        ideGrava.appendChild(ideChildGrava);
                                        */
                                    }
                                }else if(infNFeChild.item(k).getNodeName().equals("det")) ///entra no det
                                {
                                    //leitura
                                    //System.out.println("\n");
                                    Element elementDet = (Element) infNFeChild.item(k);     
                                    String idDet = elementDet.getAttribute("nItem");
                                    //System.out.println("nItem :"+idDet);

                                    NodeList prod = infNFeChild.item(k).getChildNodes();
                                    
                                    //gravacao de det
                                    Element detGrava = docXML.createElement("det");
                                    infNfeGrava.appendChild(detGrava);
                                    Attr nItemGrava = docXML.createAttribute("nItem");
                                    nItemGrava.setValue(idDet);                                        
                                    detGrava.setAttributeNode(nItemGrava);
                                    
                                    
                                    for (int h = 0; h < prod.getLength(); h++) 
                                    {
                                        if(prod.item(h).getNodeName().equals("prod")) ///entra em prod
                                        {                                           
                                            NodeList prodChild = prod.item(h).getChildNodes();
                                            
                                            ///grava prod
                                            Element prodGrava = docXML.createElement("prod");
                                            detGrava.appendChild(prodGrava);
                                            
                                            for (int g = 0; g <prodChild.getLength() ; g++) 
                                            {                
                                                Element prodChildGrava = docXML.createElement(prodChild.item(g).getNodeName());
                                                                                            
                                                //grava prod child
                                                //switch de true ou false dos dados
                                                switch(prodChild.item(g).getNodeName())
                                                {
                                                    case "cProd":
                                                        if(cProd.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "cEAN":
                                                        if(cEAN.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "xProd":
                                                        if(xProd.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "NCM":
                                                        if(NCM.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "CEST":
                                                        if(CEST.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "CFOP":
                                                        if(CFOP.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "uCom":
                                                        if(uCom.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                    
                                                    case "qCom":
                                                        if(qCom.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vUnCom":
                                                        if(vUnCom.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vProd":
                                                        if(vProd.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "cEANTrib":
                                                        if(cEANTrib.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "uTrib":
                                                        if(uTrib.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "qTrib":
                                                        if(qTrib.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vUnTrib":
                                                        if(vUnTrib.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "indTot":
                                                        if(indTot.isSelected())
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                        
                                                }
                                                /*///grava child de prod
                                                Element prodChildGrava = docXML.createElement(prodChild.item(g).getNodeName());
                                                prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                prodGrava.appendChild(prodChildGrava);
                                                //System.out.println(prodChild.item(g).getNodeName()+": "+prodChild.item(g).getTextContent());
                                                */
                                            }
                                        }                                            
                                    }                                                                          
                                }                                                                                 
                            }
                        }                        
                    }
                }
            }
            
            //salvarXML();
            ///grava o arquivo final
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            
            DOMSource docFonte =  new DOMSource(docXML);
            StreamResult docFinal = new StreamResult(new File(output));
            
            t.transform(docFonte, docFinal);

        } catch (ParserConfigurationException | SAXException | IOException ex) 
        {
            Logger.getLogger(Nfe_XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Nfe_XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Nfe_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cNF = new javax.swing.JCheckBox();
        natOp = new javax.swing.JCheckBox();
        mod = new javax.swing.JCheckBox();
        serie = new javax.swing.JCheckBox();
        nNF = new javax.swing.JCheckBox();
        dhEmi = new javax.swing.JCheckBox();
        idDest = new javax.swing.JCheckBox();
        dhSaiEnt = new javax.swing.JCheckBox();
        tpNF = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        indFinal = new javax.swing.JCheckBox();
        indPres = new javax.swing.JCheckBox();
        cMunFG = new javax.swing.JCheckBox();
        tpImp = new javax.swing.JCheckBox();
        tpEmis = new javax.swing.JCheckBox();
        cDV = new javax.swing.JCheckBox();
        tpAmb = new javax.swing.JCheckBox();
        finNFe = new javax.swing.JCheckBox();
        procEmi = new javax.swing.JCheckBox();
        verProc = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cProd = new javax.swing.JCheckBox();
        cEAN = new javax.swing.JCheckBox();
        xProd = new javax.swing.JCheckBox();
        NCM = new javax.swing.JCheckBox();
        CEST = new javax.swing.JCheckBox();
        CFOP = new javax.swing.JCheckBox();
        qCom = new javax.swing.JCheckBox();
        vUnCom = new javax.swing.JCheckBox();
        vProd = new javax.swing.JCheckBox();
        cEANTrib = new javax.swing.JCheckBox();
        uTrib = new javax.swing.JCheckBox();
        qTrib = new javax.swing.JCheckBox();
        uCom = new javax.swing.JCheckBox();
        vUnTrib = new javax.swing.JCheckBox();
        indTot = new javax.swing.JCheckBox();
        btnEnviar = new javax.swing.JButton();
        cUF = new javax.swing.JCheckBox();
        selectXML = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelEntrada = new javax.swing.JTextField();
        labelSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Extração de dados XML");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cNF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cNF.setSelected(true);
        cNF.setText("cNF");

        natOp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        natOp.setSelected(true);
        natOp.setText("natOp");

        mod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mod.setSelected(true);
        mod.setText("mod");

        serie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serie.setSelected(true);
        serie.setText("serie");

        nNF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nNF.setSelected(true);
        nNF.setText("nNF");

        dhEmi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dhEmi.setSelected(true);
        dhEmi.setText("dhEmi");

        idDest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idDest.setSelected(true);
        idDest.setText("idDest");

        dhSaiEnt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dhSaiEnt.setSelected(true);
        dhSaiEnt.setText("dhSaiEnt");

        tpNF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tpNF.setSelected(true);
        tpNF.setText("tpNF");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dados de Identificação");

        indFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        indFinal.setSelected(true);
        indFinal.setText("indFinal");

        indPres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        indPres.setSelected(true);
        indPres.setText("indPres");

        cMunFG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cMunFG.setSelected(true);
        cMunFG.setText("cMunFG");

        tpImp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tpImp.setSelected(true);
        tpImp.setText("tpImp");

        tpEmis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tpEmis.setSelected(true);
        tpEmis.setText("tpEmis");

        cDV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cDV.setSelected(true);
        cDV.setText("cDV");

        tpAmb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tpAmb.setSelected(true);
        tpAmb.setText("tpAmb");

        finNFe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        finNFe.setSelected(true);
        finNFe.setText("finNFe");

        procEmi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        procEmi.setSelected(true);
        procEmi.setText("procEmi");

        verProc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        verProc.setSelected(true);
        verProc.setText("verProc");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Dados do Produto");

        cProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cProd.setSelected(true);
        cProd.setText("cProd");

        cEAN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cEAN.setSelected(true);
        cEAN.setText("cEAN");

        xProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        xProd.setSelected(true);
        xProd.setText("xProd");

        NCM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NCM.setSelected(true);
        NCM.setText("NCM");

        CEST.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CEST.setSelected(true);
        CEST.setText("CEST");

        CFOP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CFOP.setSelected(true);
        CFOP.setText("CFOP");

        qCom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qCom.setSelected(true);
        qCom.setText("qCom");

        vUnCom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vUnCom.setSelected(true);
        vUnCom.setText("vUnCom");

        vProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vProd.setSelected(true);
        vProd.setText("vProd");

        cEANTrib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cEANTrib.setSelected(true);
        cEANTrib.setText("cEANTrib");

        uTrib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uTrib.setSelected(true);
        uTrib.setText("uTrib");

        qTrib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qTrib.setSelected(true);
        qTrib.setText("qTrib");

        uCom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uCom.setSelected(true);
        uCom.setText("uCom");

        vUnTrib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vUnTrib.setSelected(true);
        vUnTrib.setText("vUnTrib");

        indTot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        indTot.setSelected(true);
        indTot.setText("indTot");

        btnEnviar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEnviar.setText("Gerar Arquivos XML");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        cUF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cUF.setSelected(true);
        cUF.setText("cUF");

        selectXML.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectXML.setText("Selecionar");
        selectXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectXMLActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalvar.setText("Selecionar");
        btnSalvar.setToolTipText("");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Pasta de Entrada:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Pasta de Saída:");

        labelEntrada.setEditable(false);
        labelEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        labelSaida.setEditable(false);
        labelSaida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Selecione os dados para Exportação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cUF)
                            .addComponent(cNF)
                            .addComponent(natOp)
                            .addComponent(mod)
                            .addComponent(serie)
                            .addComponent(nNF)
                            .addComponent(dhEmi)
                            .addComponent(dhSaiEnt)
                            .addComponent(tpNF)
                            .addComponent(idDest))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cMunFG)
                            .addComponent(tpImp)
                            .addComponent(tpEmis)
                            .addComponent(cDV)
                            .addComponent(tpAmb)
                            .addComponent(finNFe)
                            .addComponent(indFinal)
                            .addComponent(indPres)
                            .addComponent(procEmi)
                            .addComponent(verProc)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cProd)
                            .addComponent(cEAN)
                            .addComponent(xProd)
                            .addComponent(NCM)
                            .addComponent(CEST)
                            .addComponent(CFOP)
                            .addComponent(uCom)
                            .addComponent(qCom))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vUnCom)
                            .addComponent(vProd)
                            .addComponent(cEANTrib)
                            .addComponent(uTrib)
                            .addComponent(qTrib)
                            .addComponent(vUnTrib)
                            .addComponent(indTot))))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSaida)
                        .addGap(11, 11, 11))
                    .addComponent(labelEntrada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectXML, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(btnEnviar)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cProd)
                                .addGap(5, 5, 5)
                                .addComponent(cEAN)
                                .addGap(5, 5, 5)
                                .addComponent(xProd)
                                .addGap(5, 5, 5)
                                .addComponent(NCM)
                                .addGap(5, 5, 5)
                                .addComponent(CEST)
                                .addGap(5, 5, 5)
                                .addComponent(CFOP)
                                .addGap(5, 5, 5)
                                .addComponent(uCom))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vUnCom)
                                .addGap(5, 5, 5)
                                .addComponent(vProd)
                                .addGap(5, 5, 5)
                                .addComponent(cEANTrib)
                                .addGap(5, 5, 5)
                                .addComponent(uTrib)
                                .addGap(5, 5, 5)
                                .addComponent(qTrib)
                                .addGap(5, 5, 5)
                                .addComponent(vUnTrib)
                                .addGap(5, 5, 5)
                                .addComponent(indTot)))
                        .addGap(5, 5, 5)
                        .addComponent(qCom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cUF)
                                .addGap(5, 5, 5)
                                .addComponent(cNF)
                                .addGap(5, 5, 5)
                                .addComponent(natOp)
                                .addGap(5, 5, 5)
                                .addComponent(mod)
                                .addGap(5, 5, 5)
                                .addComponent(serie)
                                .addGap(5, 5, 5)
                                .addComponent(nNF)
                                .addGap(5, 5, 5)
                                .addComponent(dhEmi)
                                .addGap(5, 5, 5)
                                .addComponent(dhSaiEnt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tpNF)
                                .addGap(5, 5, 5)
                                .addComponent(idDest))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(procEmi)
                                .addGap(5, 5, 5)
                                .addComponent(verProc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cMunFG)
                                .addGap(5, 5, 5)
                                .addComponent(tpImp)
                                .addGap(5, 5, 5)
                                .addComponent(tpEmis)
                                .addGap(5, 5, 5)
                                .addComponent(cDV)
                                .addGap(5, 5, 5)
                                .addComponent(tpAmb)
                                .addGap(5, 5, 5)
                                .addComponent(finNFe)
                                .addGap(5, 5, 5)
                                .addComponent(indFinal)
                                .addGap(5, 5, 5)
                                .addComponent(indPres)))))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectXML))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addComponent(btnEnviar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        File diretorio = new File(labelEntrada.getText());
        File [] arquivos = diretorio.listFiles();
        for (int i = 0; i <arquivos.length; i++) {
            manipularXML(arquivos[i].getAbsolutePath(), labelSaida.getText()+"/"+arquivos[i].getName());
            
        }
        
        JOptionPane.showMessageDialog(null, "Arquivos XML criados ! ");
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void selectXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectXMLActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int res = chooser.showOpenDialog(null);
  
        if(res == JFileChooser.APPROVE_OPTION)
        {                   
           File arq = chooser.getSelectedFile().getAbsoluteFile();
           String caminho = arq.getPath();
           //JOptionPane.showMessageDialog(null, "Caminho selecionado: " + caminho);
           labelEntrada.setText(caminho);
           //xmlPathInit.setText(caminho);
           

        } else 
        {
            JOptionPane.showMessageDialog(null, "Operação cancelada."); 
        } 
    }//GEN-LAST:event_selectXMLActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        salvarXML();
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    public void salvarXML()
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int res = chooser.showOpenDialog(null);
  
        if(res == JFileChooser.APPROVE_OPTION)
        {                   
           File arq = chooser.getSelectedFile().getAbsoluteFile();
           String caminho = arq.getPath();
           //JOptionPane.showMessageDialog(null, "Caminho selecionado: " + caminho);
           labelSaida.setText(caminho);
           //xmlPathFinal.setText(caminho);      
        } else 
        {
            JOptionPane.showMessageDialog(null, "Operação cancelada."); 
        } 
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CEST;
    private javax.swing.JCheckBox CFOP;
    private javax.swing.JCheckBox NCM;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cDV;
    private javax.swing.JCheckBox cEAN;
    private javax.swing.JCheckBox cEANTrib;
    private javax.swing.JCheckBox cMunFG;
    private javax.swing.JCheckBox cNF;
    private javax.swing.JCheckBox cProd;
    private javax.swing.JCheckBox cUF;
    private javax.swing.JCheckBox dhEmi;
    private javax.swing.JCheckBox dhSaiEnt;
    private javax.swing.JCheckBox finNFe;
    private javax.swing.JCheckBox idDest;
    private javax.swing.JCheckBox indFinal;
    private javax.swing.JCheckBox indPres;
    private javax.swing.JCheckBox indTot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField labelEntrada;
    private javax.swing.JTextField labelSaida;
    private javax.swing.JCheckBox mod;
    private javax.swing.JCheckBox nNF;
    private javax.swing.JCheckBox natOp;
    private javax.swing.JCheckBox procEmi;
    private javax.swing.JCheckBox qCom;
    private javax.swing.JCheckBox qTrib;
    private javax.swing.JButton selectXML;
    private javax.swing.JCheckBox serie;
    private javax.swing.JCheckBox tpAmb;
    private javax.swing.JCheckBox tpEmis;
    private javax.swing.JCheckBox tpImp;
    private javax.swing.JCheckBox tpNF;
    private javax.swing.JCheckBox uCom;
    private javax.swing.JCheckBox uTrib;
    private javax.swing.JCheckBox vProd;
    private javax.swing.JCheckBox vUnCom;
    private javax.swing.JCheckBox vUnTrib;
    private javax.swing.JCheckBox verProc;
    private javax.swing.JCheckBox xProd;
    // End of variables declaration//GEN-END:variables
}
