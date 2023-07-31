package com.example.speakingclock.service.impl;

import com.example.speakingclock.service.SpeakingCurrentTimeService;
import com.example.speakingclock.util.TimeInWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SpeakingCurrentTimeServiceImpl implements SpeakingCurrentTimeService {

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Override
    public String getCurrentTimingInWords() {

        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        return timeInWordsUtil.getTimeInWords(hour, minute);
    }
}
