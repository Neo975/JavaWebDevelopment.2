import java.io.*;
import java.net.Socket;

/**
 * Created by Mike on 11.03.2016.
 */
public class SocketThread extends Thread {
    private final Socket socket;
    private final int threadId;

    public SocketThread(Socket socket, int threadId) {
        this.socket = socket;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try {
            int readBytes;
            byte[] buffer = new byte[256];
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
/*
            while ((readBytes = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readBytes);
                outputStream.flush();
            }
*/
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                if(inputLine.equals("Bye.") || inputLine.equals("Bue.")) {
                    break;
                }
                writer.println(inputLine);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
