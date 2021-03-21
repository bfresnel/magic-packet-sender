package fr.bfr.magicpacketsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Main {

    public final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnknownHostException, SocketException {
        byte[] data = getByteData("00-0D-61-08-22-4A");
        InetAddress address = InetAddress.getLocalHost();
        /*try (DatagramSocket socket = new DatagramSocket(9999, address)) {
            DatagramPacket packet = new DatagramPacket(data, 16);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static byte[] getByteData(String address){
        byte[] mac = new byte[6];
        int i = 0;
        String[] hex = address.split("[:-]");
        for(String currentHex : hex){
            mac[i]=Byte.parseByte(currentHex,16);
            i++;
        }
        return mac;
    }
}
