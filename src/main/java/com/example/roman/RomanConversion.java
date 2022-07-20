package com.example.roman;

import com.example.roman.utils.RomanConverterUtils;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class RomanConversion {
    
    private RomanConverterUtils utils = new RomanConverterUtils();

    /**
     * Method to conver an integer to a roman number
     * @param number
     * @return
     */
    public String toRoman(Integer number) {
        utils.validate(number);
        StringBuilder romanNumber = new StringBuilder();
        AtomicInteger inputNumberToProcess = new AtomicInteger(number);
        utils.getMappings().keySet().stream().map(String::valueOf).map(Integer::parseInt).sorted(Comparator.reverseOrder()).forEach(nextKey -> {
            processNextKey(inputNumberToProcess, nextKey, romanNumber);
        });
        return romanNumber.toString();
    }

    /**
     * Recursive operation to find out the next roman numeral and add the resolved one to the result
     * @param remainingNumber
     * @param nextKey
     * @param roman
     */
    private void processNextKey(AtomicInteger remainingNumber, int nextKey, StringBuilder roman) {
        String romanLetterForKey = utils.getMappings().getProperty(String.valueOf(nextKey));
        if (remainingNumber.get() >= nextKey) {
            int remainingNumberInt = remainingNumber.get() - nextKey;
            remainingNumber.set(remainingNumberInt);
            roman.append(romanLetterForKey);
            processNextKey(remainingNumber, nextKey, roman);
        }
    }

}
