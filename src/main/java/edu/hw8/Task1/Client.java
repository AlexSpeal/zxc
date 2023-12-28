package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings({"MultipleStringLiterals", "RegexpSinglelineJava"})
public class Client implements AutoCloseable {
    final static int SIZE_BUFFER = 256;
    private static SocketChannel socket;
    private static ByteBuffer buffer;

    public Client(String host, int port) throws IOException {
        socket = SocketChannel.open(new InetSocketAddress(host, port));
        buffer = ByteBuffer.allocate(SIZE_BUFFER);
    }

    public void sendToServer(String message) {
        try {
            buffer.put(UTF_8.encode(message).array());
            buffer.clear();
            socket.write(buffer);
            System.out.println("Ваня: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromServer() {
        try {
            buffer.position(0);
            socket.read(buffer);
            String response = new String(buffer.array()).trim();

            System.out.println("Сервер: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }
}
