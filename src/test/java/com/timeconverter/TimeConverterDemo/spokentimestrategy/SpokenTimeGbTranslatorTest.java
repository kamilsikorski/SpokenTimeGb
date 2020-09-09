package com.timeconverter.TimeConverterDemo.spokentimestrategy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SpokenTimeGbTranslatorTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new String[][]
                {
                        {"1:00", "one o'clock"},
                        {"2:05", "five past two"},
                        {"3:10", "ten past three"},
                        {"4:15", "quarter past four"},
                        {"5:20", "twenty past five"},
                        {"6:25", "twenty five past six"},
                        {"6:32", "six thirty two"},
                        {"7:30", "half past seven"},
                        {"8:40", "twenty to nine"},
                        {"9:45", "quarter to ten"},
                        {"10:50", "ten to eleven"},
                        {"11:55", "five to twelve"},
                        {"00:00", "midnight"},
                        {"12:00", "noon"},
                });
    }

    private String clockTime;
    private String spokenForm;

    public SpokenTimeGbTranslatorTest(String clockTime, String spokenForm) {
        this.clockTime = clockTime;
        this.spokenForm = spokenForm;
    }

    SpokenTimeGbTranslator spokenTimeGbTranslator = new SpokenTimeGbTranslator();

    @Test
    public void checkProperSpokenForms() {
        Assertions.assertEquals(spokenForm, spokenTimeGbTranslator.translate(clockTime), "Not proper time conversion to spoken version");
    }


}