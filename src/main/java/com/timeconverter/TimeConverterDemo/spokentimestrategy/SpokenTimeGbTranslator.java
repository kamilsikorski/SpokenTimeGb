package com.timeconverter.TimeConverterDemo.spokentimestrategy;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpokenTimeGbTranslator implements SpokenTimeTranslatorStrategy {


    private static final String PAST = "past";
    private static final String TO = "to";
    private static final String QUARTER = "quarter";
    private static final String MIDNIGHT = "midnight";
    private static final String NOON = "noon";
    private static final String HALF = "half";
    private static final String EMPTY_STRING = " ";

    private static Map<Integer, String> numbers = new HashMap<Integer, String>();
    private static Set<Integer> numberSet = new HashSet<>();

    static void init() {
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
    }


    static {
        init();
        numberSet.addAll(numbers.keySet());
    }


    @Override
    public String translate(String clockTime) {

        //midnight and noon check
        if (clockTime.equals("00:00") || clockTime.equals("0:00")) {
            return MIDNIGHT;
        }

        if (clockTime.equals("12:00")) {
            return NOON;
        }

        String[] timeParts = clockTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);


        //  full hours check
        if (minutes == 0) {
            return numbers.get(hour) + EMPTY_STRING + "o'clock";
        }

        //half check
        if (minutes == 30) {
            return HALF + EMPTY_STRING + PAST + EMPTY_STRING + numbers.get(hour);
        }

        // quarter check
        if (minutes == 15) {
            return QUARTER + EMPTY_STRING + PAST + EMPTY_STRING + numbers.get(hour);
        }

        if (minutes == 45) {
            return QUARTER + EMPTY_STRING + TO + EMPTY_STRING + numbers.get(hour + 1);
        }

        // near full complements
        if (((minutes % 5 == 0) || minutes % 10 == 0) && minutes < 30) {
            return minutes < 20 ? numbers.get(minutes) + EMPTY_STRING + PAST + EMPTY_STRING + numbers.get(hour) : createDecimalDescriptionForMinutes(minutes) + EMPTY_STRING + PAST + EMPTY_STRING + numbers.get(hour);
        }

        if (((minutes % 5 == 0) || minutes % 10 == 0) && minutes >= 30) {
            return createDecimalDescriptionForMinutes(60 - minutes) + EMPTY_STRING + TO + EMPTY_STRING + numbers.get(hour + 1);
        }

        // numeric value
        return numbers.get(hour) + EMPTY_STRING + createDecimalDescriptionForMinutes(minutes);
    }


    private static String createDecimalDescriptionForMinutes(int minutes) {

        if (minutes < 20) {
            return numbers.get(minutes);
        }

        String decimal = String.valueOf(minutes).substring(0, 1) + "0";
        String singleElement = String.valueOf(minutes).substring(1, 2);

        return numbers.get(Integer.parseInt(decimal)) + (!singleElement.equals("0") ? EMPTY_STRING + numbers.get(Integer.parseInt(singleElement)) : "");
    }


}

