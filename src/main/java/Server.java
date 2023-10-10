import java.io.*;
import java.net.Socket;


public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void handleConnection() {
        try (
                final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final var out = new BufferedOutputStream(socket.getOutputStream());
        ) {
            // Здесь будет ваша обработка подключения
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
