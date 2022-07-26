package com.example.roman;

import com.example.roman.exceptions.OutOfScopeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class RomanConversionTest {

    private static final String EQUALS = "=";

    private RomanConversion romanConversion = new RomanConversion();

    @ParameterizedTest
    @ValueSource(strings = {"1=I", "3=III", "4=IV", "5=V", "9=IX"})
    public void testIntegerToRoman_ConversionOfSingleDigit(String testGroup) {
        String[] mappedKeyValue = testGroup.split(EQUALS);
        String result = romanConversion.toRoman(Integer.parseInt(mappedKeyValue[0]));
        assertEquals(mappedKeyValue[1], result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10=X", "14=XIV", "15=XV", "19=XIX", "20=XX"})
    public void testIntegerToRoman_ConversionOfTwoDigits(String testGroup) {
        String[] mappedKeyValue = testGroup.split(EQUALS);
        String result = romanConversion.toRoman(Integer.parseInt(mappedKeyValue[0]));
        assertEquals(mappedKeyValue[1], result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100=C", "115=CXV", "117=CXVII", "800=DCCC", "819=DCCCXIX", "999=CMXCIX"})
    public void testIntegerToRoman_ConversionOfThreeDigits(String testGroup) {
        String[] mappedKeyValue = testGroup.split(EQUALS);
        String result = romanConversion.toRoman(Integer.parseInt(mappedKeyValue[0]));
        assertEquals(mappedKeyValue[1], result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000=M", "1500=MD", "1567=MDLXVII", "2000=MM", "2050=MML", "3000=MMM"})
    public void testIntegerToRoman_ConversionUptoMaximum(String testGroup) {
        String[] mappedKeyValue = testGroup.split(EQUALS);
        String result = romanConversion.toRoman(Integer.parseInt(mappedKeyValue[0]));
        assertEquals(mappedKeyValue[1], result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "INVALID", "MDLXVII", " ", "null", "!@£$£"})
    public void testIntegerToRoman_ConversionFailure_InvalidValues(String testValue) {
        boolean isNFException = false;
        try {
            romanConversion.toRoman(Integer.parseInt(testValue));
            fail("Test should throw an error in case of invalid value.");
        } catch (NumberFormatException nfe) {
            // Do Nothing
            isNFException = true;
        }
        assertTrue(isNFException);
    }

    @ParameterizedTest
    @ValueSource(ints = {3001, 5000})
    public void testIntegerToRoman_ConversionFailure_OutOfScopeValues(int testValue) {
        boolean isOOSException = false;
        try {
            romanConversion.toRoman(testValue);
            fail("Test should throw an error in case of value greater than 3000.");
        } catch (OutOfScopeException oose) {
            // Do Nothing
            isOOSException = true;
        }
        assertTrue(isOOSException);
    }

}
