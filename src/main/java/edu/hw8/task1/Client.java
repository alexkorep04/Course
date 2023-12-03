package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private  final int size;
    private final InetSocketAddress address;

    @SuppressWarnings("MagicNumber")
    public Client(int port) {
        size = 2048;
        this.address = new InetSocketAddress("localhost", port);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void send(String word) {
        try (SocketChannel channel = SocketChannel.open(address)) {
            ByteBuffer buffer = ByteBuffer.wrap(word.getBytes());
            channel.write(buffer);
            buffer.flip();
            buffer = ByteBuffer.allocate(size);
            int bytesRead = channel.read(buffer);
            if (bytesRead != 0) {
                System.out.println(new String(buffer.array()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
