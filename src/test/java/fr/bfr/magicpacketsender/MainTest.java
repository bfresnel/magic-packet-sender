package fr.bfr.magicpacketsender;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void getByteDataTest(){
        byte[] hex = new byte[6];
        hex[0]= Byte.parseByte("00",16);
        hex[1]= Byte.parseByte("0D",16);
        hex[2]= Byte.parseByte("61",16);
        hex[3]= Byte.parseByte("08",16);
        hex[4]= Byte.parseByte("22",16);
        hex[5]= Byte.parseByte("4A",16);

        byte[] hexToTest = Main.getByteData("00-0D-61-08-22-4A");
        Assertions.assertEquals(hex[0],hexToTest[0]);
        Assertions.assertEquals(hex[1],hexToTest[1]);
        Assertions.assertEquals(hex[2],hexToTest[2]);
        Assertions.assertEquals(hex[3],hexToTest[3]);
        Assertions.assertEquals(hex[4],hexToTest[4]);
        Assertions.assertEquals(hex[5],hexToTest[5]);
        Assertions.assertArrayEquals(hex, hexToTest);
    }

    @Test
    public void isPacketMagic(){

    }
}
