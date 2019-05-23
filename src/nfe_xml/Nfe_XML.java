
package nfe_xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    static void lerXML()
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
                            System.out.println("id :"+id);
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
                                        System.out.println(ide.item(l).getNodeName()+": "+ide.item(l).getTextContent());
                                        
                                        ///gravacao child ide
                                        Element ideChildGrava = docXML.createElement(ide.item(l).getNodeName());
                                        ideChildGrava.appendChild(docXML.createTextNode(ide.item(l).getTextContent()));
                                        ideGrava.appendChild(ideChildGrava);
                                    }
                                }else if(infNFeChild.item(k).getNodeName().equals("det")) ///entra no det
                                {
                                    //leitura
                                    System.out.println("\n");
                                    Element elementDet = (Element) infNFeChild.item(k);     
                                    String idDet = elementDet.getAttribute("nItem");
                                    System.out.println("nItem :"+idDet);

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
                                                prodChildGrava.appendChild(docXML.createTextNode(prodChild.item(g).getTextContent()));
                                                prodGrava.appendChild(prodChildGrava);
                                                System.out.println(prodChild.item(g).getNodeName()+": "+prodChild.item(g).getTextContent());
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
        lerXML();
    }
    
}
