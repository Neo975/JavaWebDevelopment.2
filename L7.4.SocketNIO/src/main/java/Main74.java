import java.io.IOException;

/**
 * Created by Mike on 14.03.2016.
 */
public class Main74 {
    public static void main(String[] args) throws IOException {
        testMultiPortEcho(args);
    }

    private static void testMultiPortEcho(String[] args) throws IOException {
        if(args.length <= 0) {
            System.err.println("Usage: java MultiPortEcho port [port1 port2 ...]");
            System.exit(1);
        }

        int[] ports = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            ports[i] = Integer.parseInt(args[i]);
        }

        new MultiPortEcho(ports);
    }
}
