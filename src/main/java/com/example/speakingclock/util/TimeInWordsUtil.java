package com.example.speakingclock.util;

import org.springframework.stereotype.Component;
import pl.allegro.finance.tradukisto.ValueConverters;

@Component
public class TimeInWordsUtil {

    public String getTimeInWords(int hour, int minute) {
        StringBuilder sBuilder = new StringBuilder("It's ");
        ValueConverters valueConverters = ValueConverters.ENGLISH_INTEGER;

        if (hour == 12 && minute == 0) {
            sBuilder.append("Midday");
        } else if (hour == 0 && minute == 0) {
            sBuilder.append("Midnight");
        } else {
            sBuilder.append(valueConverters.asWords(hour))
                    .append(" ")
                    .append(valueConverters.asWords(minute));
        }

        return sBuilder.toString();
    }
}
