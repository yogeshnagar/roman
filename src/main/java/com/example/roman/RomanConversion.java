package com.example.roman;

import com.example.roman.exceptions.InitException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Properties;

public class RomanConversion {

    private static Properties mappings = new Properties();

    static {
        try {
            mappings.load(RomanConversion.class.getResourceAsStream("/mappings.properties"));
        } catch (IOException ioe) {
            throw new InitException();
        }
    }

    public String toRoman(Integer number) {
        
        throw new NotImplementedException();
    }

}
