package com.example.speakingclock.service.impl;

import com.example.speakingclock.util.TimeInWordsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpeakingCurrentTimeServiceImplTest {
    @Autowired
    private SpeakingCurrentTimeServiceImpl impl;

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Test
    public void testGetCurrentTimingInWords(){
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        String expected = timeInWordsUtil.getTimeInWords(hour, minute);

        String actual = impl.getCurrentTimingInWords();
        assertThat(actual).isEqualTo(expected);
    }
}
