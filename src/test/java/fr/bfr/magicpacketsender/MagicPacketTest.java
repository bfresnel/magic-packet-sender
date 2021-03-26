package fr.bfr.magicpacketsender;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MagicPacketTest {

    @Test
    void whenSendMagicPacketWithNoMacAddress_throwsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MagicPacket.sendMagicPacket(""));
    }

    @Test
    void whenSendMagicPacketWithSpecificMacAddress_sendMagicPacket() {
        Assertions.assertDoesNotThrow(() -> MagicPacket.sendMagicPacket("AB-BC-CD-DE-AA-FF"));
    }

    void getByteDataTest() {
        byte[] hex = new byte[6];
        hex[0] = Byte.parseByte("00", 16);
        hex[1] = Byte.parseByte("0D", 16);
        hex[2] = Byte.parseByte("61", 16);
        hex[3] = Byte.parseByte("08", 16);
        hex[4] = Byte.parseByte("22", 16);
        hex[5] = Byte.parseByte("4A", 16);

        byte[] hexToTest = MagicPacket.getByteData("00-0D-61-08-22-4A");
        Assertions.assertEquals(hex[0], hexToTest[0]);
        Assertions.assertEquals(hex[1], hexToTest[1]);
        Assertions.assertEquals(hex[2], hexToTest[2]);
        Assertions.assertEquals(hex[3], hexToTest[3]);
        Assertions.assertEquals(hex[4], hexToTest[4]);
        Assertions.assertEquals(hex[5], hexToTest[5]);
        Assertions.assertArrayEquals(hex, hexToTest);
    }

    @Test
    void getByteData_DoesNotThrowError() {
        String testedAddress = "AF-FE-61-08-22-4A";
        Assertions.assertDoesNotThrow(() ->
                MagicPacket.getByteData(testedAddress));
    }

    @Test
    void getByteData_DoesNotThrowError_GreaterThan90() {
        String testedAddress = "AF-FE-61-08-95-4A";
        Assertions.assertDoesNotThrow(() ->
                MagicPacket.getByteData(testedAddress));
    }

    @Test
    void constructMagicPacketTest() {
        String testedAddress = "00-0D-61-08-22-4A";

        byte[] finalHex = new byte[102];
        finalHex[0] = (byte) 0xff;
        finalHex[1] = (byte) 0xff;
        finalHex[2] = (byte) 0xff;
        finalHex[3] = (byte) 0xff;
        finalHex[4] = (byte) 0xff;
        finalHex[5] = (byte) 0xff;

        finalHex[6] = Byte.parseByte("00", 16);
        finalHex[7] = Byte.parseByte("0D", 16);
        finalHex[8] = Byte.parseByte("61", 16);
        finalHex[9] = Byte.parseByte("08", 16);
        finalHex[10] = Byte.parseByte("22", 16);
        finalHex[11] = Byte.parseByte("4A", 16);

        byte[] dataToTest = MagicPacket.constructPacket(testedAddress);

        Assertions.assertEquals(finalHex[1], dataToTest[1]);
    }
}
