package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private final InetSocketAddress hostAddress;
    private static final int BUFFER_SIZE = 1024;

    @SuppressWarnings("MagicNumber")
    public Client() {
        this.hostAddress = new InetSocketAddress("localhost", 1337);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void send(String word) {
        try (SocketChannel channel = SocketChannel.open(hostAddress)) {
            ByteBuffer buffer = ByteBuffer.wrap(word.getBytes());
            channel.write(buffer);
            buffer.flip();
            buffer = ByteBuffer.allocate(BUFFER_SIZE);
            int bytesRead = channel.read(buffer);
            if (bytesRead != 0) {
                System.out.println(new String(buffer.array()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
