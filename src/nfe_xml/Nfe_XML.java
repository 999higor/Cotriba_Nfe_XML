
package nfe_xml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
                            Element root = docXML.createElement("infNfe");
                            docXML.appendChild(root);
                            Attr idGrava = docXML.createAttribute("Id");
                            idGrava.setValue(id);                                        
                            root.setAttributeNode(idGrava);                              
                            
                            for (int k = 0; k < infNFeChild.getLength(); k++) 
                            {
                                
                                if(infNFeChild.item(k).getNodeName().equals("ide")) ///entra no ide
                                {
                                    NodeList ide = infNFeChild.item(k).getChildNodes();
                                    
                                    ///grava ide
                                    Element ideGrava = docXML.createElement("ide");
                                    root.appendChild(ideGrava);
                                    
                                    for (int l = 0; l <ide.getLength() ; l++) 
                                    {
                                        System.out.println(ide.item(l).getNodeName()+": "+ide.item(l).getTextContent());
                                        
                                        ///gravacao
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
                                    
                                    //gravacao
                                    
                                    for (int h = 0; h < prod.getLength(); h++) 
                                    {
                                        if(prod.item(h).getNodeName().equals("prod")) ///entra em prod
                                        {
                                            NodeList prodChild = prod.item(h).getChildNodes();
                                            for (int g = 0; g <prodChild.getLength() ; g++) 
                                            {
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

        } catch (ParserConfigurationException | SAXException | IOException ex) 
        {
            Logger.getLogger(Nfe_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static void main(String[] args) 
    {
        lerXML();
    }
    
}
