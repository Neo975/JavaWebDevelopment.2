import java.io.*;
import java.util.Properties;

/**
 * Created by Mike on 28.02.2016.
 */
public class PropertiesExample {
    public static void f() {
        Properties properties = new Properties();
        Properties props = new Properties();
        properties.setProperty("Name", "Ivan");
        properties.setProperty("Family", "Ivanov");
        properties.setProperty("Age", "44");
        try(OutputStream outputStream = new FileOutputStream("config.properties"); InputStream inputStream = new FileInputStream("config.properties")) {
            properties.store(outputStream, "comments");
            props.load(inputStream);
            System.out.println(props.getProperty("Name"));
            System.out.println(props.getProperty("Family"));
            System.out.println(props.getProperty("Age"));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
