import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Mike on 04.03.2016.
 */
public class Main {
    private static final int END_OF_STREAM = -1;
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("./data/data.txt", "rw");
        FileChannel inChannel = raf.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(7);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != END_OF_STREAM) {
            System.out.println("Read bytes: " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char)buf.get());
            }
            System.out.println("\n");
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        raf.close();
    }
}
