package com.example.roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class RomanConversionTest {

    private static final String EQUALS = "=";

    @ParameterizedTest
    @ValueSource(strings = {"1=I", "3=III", "4=IV", "5=V", "9=IX"})
    public void testIntegerToRoman_ConversionOfSingleDigit(String testGroup) {
        String[] mappedKeyValue = testGroup.split(EQUALS);
        String result = null;
        assertEquals(mappedKeyValue[1], result);
    }

}
