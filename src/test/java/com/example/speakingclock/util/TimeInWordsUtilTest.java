package com.example.speakingclock.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TimeInWordsUtilTest {

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Test
    public void testGetCurrentTimingInWords(){
        String actual = timeInWordsUtil.getTimeInWords(8, 23);
        assertThat(actual).isEqualTo("It's eight twenty-three");
    }

    @Test
    public void testGetCurrentTimingInWords_ItsMidnight(){
        String actual = timeInWordsUtil.getTimeInWords(00, 00);
        assertThat(actual).isEqualTo("It's Midnight");
    }

    @Test
    public void testGetCurrentTimingInWords_ItsMidday(){
        String actual = timeInWordsUtil.getTimeInWords(12, 00);
        assertThat(actual).isEqualTo("It's Midday");
    }

}
