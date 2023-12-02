package edu.hw8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Client implements AutoCloseable {

    private static SocketChannel socket;
    private static ByteBuffer buffer;

    public Client(String host, int port) throws IOException {
        socket = SocketChannel.open(new InetSocketAddress(host, port));
        buffer = ByteBuffer.allocate(256);
    }

    public void sendToServer(String message) {
        try {
            buffer = ByteBuffer.wrap(UTF_8.encode(message).array());
            socket.write(buffer);
            buffer.clear();
            System.out.println("Ваня: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void readFromServer() {
        try {
            socket.read(buffer);
            String x=new String(buffer.array());
            String response = new String(buffer.array());

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
