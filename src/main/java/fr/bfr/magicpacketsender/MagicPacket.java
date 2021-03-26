package fr.bfr.magicpacketsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MagicPacket {

    public static final Logger logger = LoggerFactory.getLogger(MagicPacket.class);

    public static void sendMagicPacket(String macAddress) throws IOException {
        if (!macAddress.isEmpty()) {
            byte[] packetData = constructPacket(macAddress);
            try {
                DatagramSocket socket = new DatagramSocket(9, InetAddress.getLocalHost());
                DatagramPacket packet = new DatagramPacket(packetData, 0, 16, InetAddress.getLocalHost(), 9);
                socket.send(packet);
                logger.info("Magic packet sent !");
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new IOException(e);
            }
        } else {
            throw new IllegalArgumentException("The specified Mac address is empty !");
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
            mac[i] = Converter.returnByteFromString(currentHex);
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
