
package nfe_xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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


public class Nfe_XML 
{
    public void abrirArq()
    {
        
    }
    
    static void lerXML(
            boolean cUF,  boolean cNF, boolean natOp, boolean mod, boolean serie, boolean nNF, boolean dhEmi,boolean dhSaiEnt,
            boolean tpNF, boolean idDest, boolean cMunFG, boolean tpImp, boolean tpEmis, boolean cDV, boolean tpAmb, boolean finNFe,
            boolean indFinal, boolean indPres, boolean procEmi, boolean verProc,
            
            boolean cProd, boolean cEAN, boolean xProd, boolean NCM, boolean CEST, 
            boolean CFOP, boolean uCom, boolean qCom, boolean vUnCom, boolean vProd, boolean cEANTrib, 
            boolean uTrib, boolean qTrib, boolean vUnTrib, boolean indTot)
    {     
        try 
        {
            ///leitura do xml
            DocumentBuilderFactory dbc = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbc.newDocumentBuilder();
            Document doc = db.parse("D:\\Users\\higor\\Documents\\GitHub\\Nfe_XML\\nota.xml");           
            Element raiz = doc.getDocumentElement();
            NodeList nfe = raiz.getChildNodes();
            
            
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
                                                if(cUF)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                            
                                            case "cNF":
                                                if(cNF)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "natOp":
                                                if(natOp)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                            
                                            case "mod":
                                                if(mod)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "serie":
                                                if(serie)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "nNF":
                                                if(nNF)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "dhEmi":
                                                if(dhEmi)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "dhSaiEnt":
                                                if(dhSaiEnt)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpNF":
                                                if(tpNF)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "idDest":
                                                if(idDest)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "cMunFG":
                                                if(cMunFG)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpImp":
                                                if(tpImp)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpEmis":
                                                if(tpEmis)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "cDV":
                                                if(cDV)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "tpAmb":
                                                if(tpAmb)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "finNFe":
                                                if(finNFe)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "indFinal":
                                                if(indFinal)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "indPres":
                                                if(indPres)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "procEmi":
                                                if(procEmi)
                                                {
                                                    ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                                    ideGrava.appendChild(ideChildGrava);
                                                }
                                                break;
                                                
                                            case "verProc":
                                                if(verProc)
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
                                                        if(cProd)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "cEAN":
                                                        if(cEAN)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "xProd":
                                                        if(xProd)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "NCM":
                                                        if(NCM)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "CEST":
                                                        if(CEST)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "CFOP":
                                                        if(CFOP)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "uCom":
                                                        if(uCom)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                    
                                                    case "qCom":
                                                        if(qCom)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vUnCom":
                                                        if(vUnCom)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vProd":
                                                        if(vProd)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "cEANTrib":
                                                        if(cEANTrib)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "uTrib":
                                                        if(uTrib)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "qTrib":
                                                        if(qTrib)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "vUnTrib":
                                                        if(vUnTrib)
                                                        {
                                                            prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                            prodGrava.appendChild(prodChildGrava);
                                                        }
                                                        break;
                                                        
                                                    case "indTot":
                                                        if(indTot)
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
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            
            DOMSource docFonte =  new DOMSource(docXML);
            StreamResult docFinal = new StreamResult(new File("D:\\Users\\higor\\Documents\\GitHub\\Nfe_XML\\teste.xml"));
            
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
    

    public static void main(String[] args) 
    {
        
        //dados de ide
        boolean cUF = true;
        boolean cNF = true;
        boolean natOp = true;
        boolean mod = true;
        boolean serie = true;
        boolean nNF = true;
        boolean dhEmi = true;
        boolean dhSaiEnt = true;
        boolean tpNF = true;
        boolean idDest = true;
        boolean cMunFG = true;
        boolean tpImp = true;
        boolean tpEmis = true;
        boolean cDV = true;
        boolean tpAmb = true;
        boolean finNFe = true;
        boolean indFinal = true;
        boolean indPres = true;
        boolean procEmi = true;
        boolean verProc = true;

                 
        //dados de prod
        boolean cProd = true;
        boolean cEAN = true;
        boolean xProd = true;
        boolean NCM = true;
        boolean CEST = true;
        boolean CFOP = true;
        boolean uCom = true;
        boolean qCom = true;
        boolean vUnCom = true;
        boolean vProd = true;
        boolean cEANTrib = true;
        boolean uTrib = true;
        boolean qTrib = true;
        boolean vUnTrib = true;
        boolean indTot = true;      
        
        
        
       FormMenu fm = new FormMenu();
       fm.setVisible(true);
        
       /* lerXML(
                cUF,cNF,natOp, mod, serie, nNF, dhEmi, dhSaiEnt, tpNF, idDest, cMunFG, tpImp, tpEmis, cDV, tpAmb, finNFe,
                indFinal, indPres, procEmi, verProc,
                
                cProd, cEAN, xProd, NCM, CEST ,CFOP, uCom, qCom, vUnCom, vProd, cEANTrib, uTrib, qTrib, vUnTrib, indTot);
        */
    }
    
}
