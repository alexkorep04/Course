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
    private final int size;
    private static final Map<String, String> ANSWERS = Map.of(
        "личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    );
    private final SocketChannel client;
    private final Semaphore semaphore;

    @SuppressWarnings("MagicNumber")
    public Worker(SocketChannel client, Semaphore semaphore) {
        size = 2048;
        this.client = client;
        this.semaphore = semaphore;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    @Override
    public void run() {
        try (Selector selector = Selector.open()) {
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            while (client.isOpen()) {
                if (selector.select() == 0) {
                    continue;
                }
                doWork(selector);
            }
            client.close();
            semaphore.release();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWork(Selector selector) {
        Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
        while (keyIterator.hasNext()) {
            SelectionKey key = keyIterator.next();
            keyIterator.remove();
            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(size);
                try {
                    if (client.read(buffer) > 0) {
                        buffer.flip();
                        String request = new String(buffer.array());
                        String responseMessage = ANSWERS.getOrDefault(request.trim(), "No such phrase...");
                        ByteBuffer response = ByteBuffer.wrap((responseMessage).getBytes());
                        client.write(response);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
