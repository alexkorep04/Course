package edu.hw8;

import edu.hw8.task1.Client;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void set() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Client and server basic test")
    public void testClientAndServer() throws InterruptedException {
        Client client = new Client();
        Server server = new Server();
        Thread thread = new Thread(server::start);
        thread.start();
        Thread.sleep(100);
        client.send("личности");

        String expected = "Клиент: личности\nСервер: Не переходи на личности там, где их нет";

        String response = outputStream.toString().replace("\u0000", "").trim();

        assertThat(expected).isEqualTo(response);
    }

}
