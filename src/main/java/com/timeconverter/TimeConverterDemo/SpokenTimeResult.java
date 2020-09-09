package com.timeconverter.TimeConverterDemo;

public class SpokenTimeResult {

    private String time;
    private String spokenTime;
    private String lang;


    public SpokenTimeResult(String time, String spokenTime, String lang) {
        this.time = time;
        this.spokenTime = spokenTime;
        this.lang = lang;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpokenTime() {
        return spokenTime;
    }

    public void setSpokenTime(String spokenTime) {
        this.spokenTime = spokenTime;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
