package com.example.speakingclock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SpeakingCloakApplicationTests {

    @Test
    void contextLoads() {
        assertThat("11")
                .isEqualTo("11");
    }


}
