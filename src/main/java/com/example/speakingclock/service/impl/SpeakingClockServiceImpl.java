package com.example.speakingclock.service.impl;

import com.example.speakingclock.service.SpeakingClockService;
import com.example.speakingclock.util.TimeInWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Override
    public String getConvertedTimingInWords(String timeInNumber) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = null;
        try {
            localTime = LocalTime.from(formatter.parse(timeInNumber));
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Provide valid time. Ex 08:34", "", 0);
        }
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        return timeInWordsUtil.getTimeInWords(hour, minute);
    }
}
