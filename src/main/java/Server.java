import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    /*
    В этом шаге я создал новый класс Server.
    Метод main теперь запускает сервер, и он ожидает подключений.
    Каждое подключение обрабатывается в отдельном потоке из пула потоков.
     */
    private static final int PORT = 9999;
    private static final int THREAD_POOL_SIZE = 64;
    private static final List<String> validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        /*
         Создал объект ExecutorService с фиксированным количеством потоков равным 64.
         Это позволяет обрабатывать множество подключений параллельно.
         */

        try (final var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final var socket = serverSocket.accept();
                executor.submit(() -> handleConnection(socket));
                /*
                Я использую executor.submit(...) для запуска обработки подключения в отдельном потоке.
                Это позволяет обрабатывать несколько подключений параллельно с использованием пула потоков.
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleConnection(Socket socket) {
        try (
                final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final var out = new BufferedOutputStream(socket.getOutputStream());
        ) {
            // Реализация обработки подключения остается такой же, как в исходном коде.
            // Весь код, начиная со строки "final var requestLine = in.readLine();" до конца, остается здесь.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    Теперь у меня есть более структурированный код, разделяя логику работы сервера и
    обработки конкретных подключений.
    Обработка подключений выполняется в отдельных потоках из пула,
    что позволяет эффективно использовать ресурсы сервера.
     */
}
