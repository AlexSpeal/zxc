package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class OutputPorts {
    private OutputPorts() {

    }

    final static int MAX_PORT = 49151;
    private final static Map<Integer, String> SERVICES = new HashMap<>();
    private final static String FORMAT_PATTERN = "%-10s%-10s%-10s";

    @SuppressWarnings("MagicNumber")
    public static void putServices() {
        SERVICES.put(23, "Telnet");
        SERVICES.put(110, "POP3");
        SERVICES.put(143, "IMAP");
        SERVICES.put(123, "NTP");
        SERVICES.put(445, "SMB");
        SERVICES.put(80, "HTTP");
        SERVICES.put(20, "SSH");
        SERVICES.put(443, "HTTPS");
    }

    public static StringBuilder outputPorts() {
        StringBuilder result = new StringBuilder();
        result.append(FORMAT_PATTERN.formatted("Протокол", "Порт", "Сервис")).append("\n");
        for (int port = 0; port <= MAX_PORT; ++port) {
            try {
                ServerSocket connection = new ServerSocket(port);
                connection.close();
            } catch (IOException e) {
                result.append(FORMAT_PATTERN.formatted("TCP", port, SERVICES.getOrDefault(port, ""))).append("\n");
            }

            try {
                DatagramSocket connection = new DatagramSocket(port);
                connection.close();
            } catch (IOException e) {
                result.append(FORMAT_PATTERN.formatted("UDP", port, SERVICES.getOrDefault(port, ""))).append("\n");
            }
        }
        return result;
    }
}
