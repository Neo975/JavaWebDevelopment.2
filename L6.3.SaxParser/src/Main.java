import resources.DBParametersResource;
import sax.ReadXMLFileSAX;


/**
 * Created by Mike on 28.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML("./data/MySqlResource.xml");
        System.out.println(resource);
    }
}
