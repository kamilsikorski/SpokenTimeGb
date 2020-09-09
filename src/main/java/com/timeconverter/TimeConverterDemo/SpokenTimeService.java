package com.timeconverter.TimeConverterDemo;


import com.timeconverter.TimeConverterDemo.spokentimestrategy.SpokenTimeContext;
import com.timeconverter.TimeConverterDemo.spokentimestrategy.SpokenTimeGbTranslator;
import org.springframework.stereotype.Service;

@Service
public class SpokenTimeService {

    private SpokenTimeContext spokenTimeContext;

    public String convertTimeToSpokenTimeToSpokenDescription(String langCode, String clockTime) {

        if(langCode.equals("gb")){
            spokenTimeContext = new SpokenTimeContext(new SpokenTimeGbTranslator());
        }

        return spokenTimeContext.tranlateTimeToSpokenDescription(clockTime);
    }


}
