package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Server  {
    private static final int AMOUNT_OF_THREADS = 5;
    private final ExecutorService executorService;
    private final Semaphore semaphore;
    private final InetSocketAddress address;

    @SuppressWarnings("MagicNumber")
    public Server(int port) {
        this.address = new InetSocketAddress("localhost", port);
        executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
        semaphore = new Semaphore(2, true);
    }

    public void start() {
        try (Selector selector = Selector.open(); ServerSocketChannel socketChannel = ServerSocketChannel.open()) {
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            socketChannel.socket().bind(address);
            while (socketChannel.isOpen()) {
                selector.select();
                for (SelectionKey selectionKey : selector.selectedKeys()) {
                    if (selectionKey.isAcceptable() && semaphore.tryAcquire()) {
                        executorService
                            .execute(new Worker(((ServerSocketChannel) selectionKey.channel()).accept(), semaphore));
                    }
                }
                selector.selectedKeys().clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
