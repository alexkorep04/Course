package edu.hw8.task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Worker implements Runnable {
    private static final String CLIENT = "Клиент: ";
    private static final String SERVER = "Сервер: ";
    private static final int BUFFER_SIZE = 1024;
    private static final Map<String, String> RESPONSES = Map.of(
        "личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    );
    private final SocketChannel client;
    private final Semaphore semaphore;

    public Worker(SocketChannel client, Semaphore semaphore) {
        this.client = client;
        this.semaphore = semaphore;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            while (client.isOpen()) {
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();
                    if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                        int bytesRead = client.read(buffer);
                        if (bytesRead > 0) {
                            buffer.flip();
                            String request = new String(buffer.array(), 0, bytesRead);
                            System.out.println(CLIENT + request);
                            String responseMessage = RESPONSES.getOrDefault(request.trim(), "...");
                            ByteBuffer response = ByteBuffer.wrap((SERVER + responseMessage).getBytes());

                            while (response.hasRemaining()) {
                                client.write(response);
                            }
                            client.close();
                        }
                    }
                }
            }
            semaphore.release();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
