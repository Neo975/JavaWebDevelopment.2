import java.io.*;

/**
 * Created by Mike on 28.02.2016.
 */
public class ObjectWriter {
    public static void main(String[] args) {
        stringExample();
        descriptorExample();
        PropertiesExample.f();
    }

    public static void stringExample() {
        write("Example text. Проверочный текст", "string.bin");
        String fromFile = (String) read("string.bin");
        System.out.println(fromFile);
    }

    public static void descriptorExample() {
        write(new Descriptor("Some text", 39), "descriptor.bin");
        Descriptor fromFile = (Descriptor) read("descriptor.bin");
        System.out.println(fromFile);
    }

    public static void write(Object object, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String fileName) {
        Object returnValue = null;

        try (FileInputStream ins = new FileInputStream(fileName)) {
            BufferedInputStream bins = new BufferedInputStream(ins);
            ObjectInputStream dins = new ObjectInputStream(bins);
            returnValue = dins.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}
