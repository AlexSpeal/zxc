package edu.hw8;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    private List<String> list = List.of("личности", "оскорбления", "глупый", "интеллект");

    @Test
    @DisplayName("Сервер и клиенты общаются")
    void test1() throws InterruptedException, IOException {

        Server server = new Server(4);
        Thread thread = new Thread(() -> {
            try {
                server.start(18080);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();

        Thread.sleep(1000);

        Client client = new Client("localhost", 18080);
        client.sendToServer(list.get(ThreadLocalRandom.current().nextInt(4)));
        client.readFromServer();
        try {
            client.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(1000);
        try {
            server.close();
            thread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
