package fr.bfr.magicpacketsender;

public class HexadecimalConverter {

    private HexadecimalConverter() {
        // Avoid instanciation of this class
    }

    public static byte returnByteValue(String value) {
        byte returnedValue;
        switch (value) {
            case "AF":
                returnedValue = (byte) 0xaf;
                break;
            case "BF":
                returnedValue = (byte) 0xbf;
                break;
            case "CF":
                returnedValue = (byte) 0xcf;
                break;
            case "DF":
                returnedValue = (byte) 0xdf;
                break;
            case "EF":
                returnedValue = (byte) 0xef;
                break;
            case "FA":
                returnedValue = (byte) 0xfa;
                break;
            case "FB":
                returnedValue = (byte) 0xfb;
                break;
            case "FC":
                returnedValue = (byte) 0xfc;
                break;
            case "FD":
                returnedValue = (byte) 0xfd;
                break;
            case "FE":
                returnedValue = (byte) 0xfe;
                break;
            case "FF":
                returnedValue = (byte) 0xff;
                break;
            default:
                returnedValue = Byte.parseByte(value, 16);
                break;

        }
        return returnedValue;
    }
}
