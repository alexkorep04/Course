package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Server  {
    private static final int AMOUNT_OF_THREADS = 5;
    private final ExecutorService executorService;
    private final Semaphore semaphore = new Semaphore(2, true);
    private final InetSocketAddress address;

    @SuppressWarnings("MagicNumber")
    public Server() {
        this.address = new InetSocketAddress("localhost", 1337);
        executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
    }


    public void start() {
        try (Selector selector = Selector.open();
             ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.configureBlocking(false);
            channel.socket().bind(address);
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (channel.isOpen()) {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    if (semaphore.tryAcquire() && key.isAcceptable()) {
                        startExecution(((ServerSocketChannel) key.channel()).accept());
                    }
                }

                selector.selectedKeys().clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startExecution(SocketChannel client) {
        executorService.execute(new Worker(client, semaphore));
    }
}
