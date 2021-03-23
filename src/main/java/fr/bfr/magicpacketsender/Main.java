package fr.bfr.magicpacketsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getLocalHost();
        String addressAsString = getLocalMacAddress(address);
        logger.debug(addressAsString);
        byte[] packetData = constructPacket(addressAsString);
        try (DatagramSocket socket = new DatagramSocket(9, address)) {
            DatagramPacket packet = new DatagramPacket(packetData, 16);
            socket.send(packet);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String getLocalMacAddress(InetAddress inetAddress) throws SocketException {
        String localMacAddress = "";
        if (inetAddress != null) {
            NetworkInterface net = NetworkInterface.getByInetAddress(inetAddress);
            byte[] mac = net.getHardwareAddress();
            List<String> macByteList = new ArrayList<>();
            for (int i = 0; i < mac.length; i++) {
                macByteList.add(String.format("%02X", mac[i]));
            }
            localMacAddress = String.join("-", macByteList);
            return localMacAddress;
        } else {
            throw new NullPointerException("No InetAddress set");
        }
    }

    /**
     * Return the byte value of an specified MAC address
     *
     * @param address
     * @return byte values
     */
    public static byte[] getByteData(String address) {
        byte[] mac = new byte[6];
        int i = 0;
        String[] hex = address.split("[:-]");
        for (String currentHex : hex) {
            mac[i] = HexadecimalConverter.returnByteValue(currentHex);
            i++;
        }
        return mac;
    }

    /**
     * Method to return the constructed magic packet
     * the first 6 bytes are "FF"
     * then a 16 iteration of target computer's MAC address
     *
     * @return the packet to send
     */
    public static byte[] constructPacket(String macAddress) {
        byte[] addressByte = getByteData(macAddress);
        byte[] data = new byte[6 + 16 * addressByte.length];

        // FF part construction
        for (int i = 0; i < 6; i++) {
            data[i] = (byte) 0xff;
        }

        // Iteration of MAC Address (16 times refering to the doc)
        for (int i = 6; i < data.length; i = i + addressByte.length) {
            System.arraycopy(addressByte, 0, data, i, addressByte.length);
        }

        return data;
    }
}
