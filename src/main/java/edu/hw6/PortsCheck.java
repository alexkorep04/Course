package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortsCheck {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Map<Integer, String> FAMOUS_PORTS = new HashMap<>();

    @SuppressWarnings("MagicNumber")

    public PortsCheck() {
        FAMOUS_PORTS.put(135, "EPMAP");
        FAMOUS_PORTS.put(137, "Служба имен NetBIOS");
        FAMOUS_PORTS.put(138, "Служба датаграмм NetBIOS");
        FAMOUS_PORTS.put(139, "Служба сеансов NetBIOS");
        FAMOUS_PORTS.put(843, "Adobe Flash");
        FAMOUS_PORTS.put(3306, "MySQL");
        FAMOUS_PORTS.put(3702, "Динамическое обнаружение веб-служб");
        FAMOUS_PORTS.put(5050, "DNS");
        FAMOUS_PORTS.put(5353, "Многоадресный DNS");

    }

    public boolean isPortOccupied(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            return true;
        }
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            datagramSocket.setReuseAddress(true);
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    public String getTypeOfPort(int port) {
        String answer;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            answer = "TCP";
            return answer;
        }
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            datagramSocket.setReuseAddress(true);
        } catch (IOException e) {
            answer = "UDP";
            return answer;
        }
        return null;
    }

    public void checkAllPorts() {
        LOGGER.info("Protocol  Port   Service");
        for (Map.Entry<Integer, String> entry: FAMOUS_PORTS.entrySet()) {
            if (isPortOccupied(entry.getKey())) {
                LOGGER.info(getTypeOfPort(entry.getKey()) + "       " + entry.getKey() + "     " + entry.getValue());
            }
        }
    }
}

