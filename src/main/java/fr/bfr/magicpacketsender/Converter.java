package fr.bfr.magicpacketsender;

public class Converter {

    private Converter() {
        // Avoid instantiation of this class
    }

    public static byte returnByteFromString(String hexadecimalValue) {
        byte returnedValue;
        if (!hexadecimalValue.isEmpty()) {
            switch (hexadecimalValue) {
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
                    returnedValue = (byte) Integer.parseInt(hexadecimalValue, 16);
                    break;

            }
        } else {
            throw new IllegalArgumentException("Can't convert empty strings");
        }
        return returnedValue;
    }
}
