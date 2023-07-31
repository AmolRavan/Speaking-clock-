package com.example.speakingclock.controller;

import com.example.speakingclock.util.TimeInWordsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpeakingCurrentTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TimeInWordsUtil timeInWordsUtil;

    @Test
    public void testGetCurrentTimingInWords() throws Exception {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        String expected = timeInWordsUtil.getTimeInWords(hour, minute);

        this.mockMvc.perform(get("/current-clock"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }
}
