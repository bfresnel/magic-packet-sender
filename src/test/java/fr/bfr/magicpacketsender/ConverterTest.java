package fr.bfr.magicpacketsender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void whenReturnByteToString_ReturnNoError() {
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("AF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("BF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("CF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("DF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("EF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FA"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FB"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FC"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FD"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FE"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("FF"));
        Assertions.assertDoesNotThrow(() -> Converter.returnByteFromString("4F"));
    }

    @Test
    void whenReturnByteToStringWithoutArgs_ReturnIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Converter.returnByteFromString(""));
    }
}
