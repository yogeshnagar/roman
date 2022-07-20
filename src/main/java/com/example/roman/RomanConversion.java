package com.example.roman;

import com.example.roman.exceptions.InitException;
import com.example.roman.exceptions.OutOfScopeException;

import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static java.lang.String.format;

public class RomanConversion {

    private static Properties mappings = new Properties();

    private static Comparator<Integer> normal = Integer::compare;

    private static Comparator<Integer> reversed = normal.reversed();

    private static final Logger logger = Logger.getAnonymousLogger();

    static {
        try {
            mappings.load(RomanConversion.class.getResourceAsStream("/mappings.properties"));
            logger.info(format("Properties loaded %s", mappings));
        } catch (IOException ioe) {
            throw new InitException();
        }
    }

    public String toRoman(Integer number) {
        validate(number);
        StringBuilder romanNumber = new StringBuilder();
        AtomicInteger inputNumberToProcess = new AtomicInteger(number);
        mappings.keySet().stream().map(String::valueOf).map(Integer::parseInt).sorted(reversed).forEach(nextKey -> {
            processNextKey(inputNumberToProcess, nextKey, romanNumber);
        });
        return romanNumber.toString();
    }

    private static void processNextKey(AtomicInteger remainingNumber, int nextKey, StringBuilder roman) {
        String romanLetterForKey = mappings.getProperty(String.valueOf(nextKey));
        if (remainingNumber.get() >= nextKey) {
            int remainingNumberInt = remainingNumber.get() - nextKey;
            remainingNumber.set(remainingNumberInt);
            System.out.println("Adding: " + romanLetterForKey);
            roman.append(romanLetterForKey);
            processNextKey(remainingNumber, nextKey, roman);
        }
    }

    private void validate(int number) {
        if (number > 3000) {
            throw new OutOfScopeException();
        }
    }

}
