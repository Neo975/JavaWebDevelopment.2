package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Mike on 28.02.2016.
 */
public class ReadXMLFileSAX {
    public static Object readXML(String xmlFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler saxHandler = new SaxHandler();
            saxParser.parse(xmlFile, saxHandler);

            return saxHandler.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
