package com.timeconverter.TimeConverterDemo.spokentimestrategy;


public class SpokenTimeContext {

    private SpokenTimeTranslatorStrategy spokenTimeTranslator;


    public SpokenTimeContext(SpokenTimeTranslatorStrategy spokenTimeTranslator) {
        this.spokenTimeTranslator = spokenTimeTranslator;
    }

    public String tranlateTimeToSpokenDescription(String clockTime) {
        return spokenTimeTranslator.translate(clockTime);
    }

}

