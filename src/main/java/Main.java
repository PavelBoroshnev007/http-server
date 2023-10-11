import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PORT = 8090;
    private static final int THREAD_POOL_SIZE = 64;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (final var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final var socket = serverSocket.accept();
                executor.submit(() -> {
                    Server server = new Server();
                    server.handleConnection(socket);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}