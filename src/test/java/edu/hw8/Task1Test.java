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
        Client client1 = new Client(1337);
        Server server = new Server(1337);
        Thread thread = new Thread(server::start);
        thread.start();
        Thread.sleep(100);
        client1.send("личности");

        String expected = "Не переходи на личности там, где их нет";

        String response = outputStream.toString().replace("\u0000", "").trim();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Client and server test when no such phrase")
    public void testClientAndServerNoPhrase() throws InterruptedException {
        Client client = new Client(8080);
        Server server = new Server(8080);
        Thread thread = new Thread(server::start);
        thread.start();
        Thread.sleep(100);
        client.send("программирование");

        String expected = "No such phrase...";

        String response = outputStream.toString().replace("\u0000", "").trim();

        assertThat(expected).isEqualTo(response);
    }
}
