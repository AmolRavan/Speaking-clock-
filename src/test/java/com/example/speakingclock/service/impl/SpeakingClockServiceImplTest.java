package com.example.speakingclock.service.impl;

import com.example.speakingclock.util.TimeInWordsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpeakingClockServiceImplTest {

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Autowired
    private SpeakingClockServiceImpl impl;

    @Test
    public void testGetConvertedTimingInWords_validTime() {
        String actual = impl.getConvertedTimingInWords("08:23");
        assertThat(actual).isEqualTo("It's eight twenty-three");
    }

    @Test
    public void testGetConvertedTimingInWords_InvalidTime() {

        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> {
                    impl.getConvertedTimingInWords("08:2");
                }, "Provide valid time. Ex 08:34");

        Assertions.assertEquals("Provide valid time. Ex 08:34", thrown.getMessage());
    }

    @Test
    public void testGetConvertedTimingInWords_InvalidTime2() {

        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> {
                    impl.getConvertedTimingInWords("08:222");
                }, "Provide valid time. Ex 08:34");

        Assertions.assertEquals("Provide valid time. Ex 08:34", thrown.getMessage());
    }
}
