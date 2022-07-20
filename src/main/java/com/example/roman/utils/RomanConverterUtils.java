package com.example.roman.utils;

import com.example.roman.RomanConversion;
import com.example.roman.exceptions.InitException;
import com.example.roman.exceptions.OutOfScopeException;

import java.io.IOException;
import java.util.Properties;

public class RomanConverterUtils {

    private static Properties mappings = new Properties();

    /**
     * Get the mappings for the integer to roman numerals
     * @return
     */
    public Properties getMappings() {
        if (mappings.isEmpty()) {
            synchronized (mappings){
                if (mappings.isEmpty()) {
                    try {
                        mappings.load(RomanConversion.class.getResourceAsStream("/mappings.properties"));
                    } catch (IOException ioe) {
                        throw new InitException();
                    }
                }
            }
        }
        return mappings;
    }

    /**
     * Validate whether the number supplied is out of the scope of this converter
     * @param number
     */
    public void validate(int number) {
        if (number > 3000) {
            throw new OutOfScopeException();
        }
    }

}
