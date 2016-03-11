import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Mike on 11.03.2016.
 */
public class Main {
    private static int SERVER_PORT;

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("Utility usage: java -jar server.jar <TCP PORT>");
            return;
        }
        try {
            SERVER_PORT = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("\"TCP PORT\" argument must be number");
            return;
        }
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        while(true) {
            Socket clientSocket = serverSocket.accept();
            clientSocket.getOutputStream().write(new String("fdfdf").getBytes());
            clientSocket.close();
        }
    }
}
