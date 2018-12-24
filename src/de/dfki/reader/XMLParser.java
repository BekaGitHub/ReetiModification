package de.dfki.reader;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser {

  private static Document document;
  private static final String CEREPROC_CONFIG = "configFiles/cereproc-config.xml";

  public static void createDocument(String configFilePath) {
    File xmlFile;
    if (configFilePath == null) {
      ClassLoader classLoader = XMLParser.class.getClassLoader();
      xmlFile = new File(classLoader.getResource(CEREPROC_CONFIG).getFile());
    } else {
      xmlFile = new File(configFilePath);
    }

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = null;

    try {
      dBuilder = dbFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }

    try {
      document = dBuilder.parse(xmlFile);
      document.getDocumentElement().normalize();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getVauleOf(String tagName) {

     return  document.getElementsByTagName(tagName).item(0).getTextContent();
  }

}
