import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Mike on 11.03.2016.
 */
public class MainFinal {
    private static int SERVER_PORT;
    private static final int THREADS_NUMBER = 11;

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
        System.out.println("Server started");
        for (int threadCount = 0; threadCount < THREADS_NUMBER; threadCount++) {
            Socket clientSocket = serverSocket.accept();
            new SocketThread(clientSocket, threadCount).start();
        }
    }
}
