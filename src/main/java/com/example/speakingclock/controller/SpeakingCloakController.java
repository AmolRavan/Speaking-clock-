package com.example.speakingclock.controller;

import com.example.speakingclock.service.SpeakingClockService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("speaking-clock")
@Api(value="users", description="Endpoint for user management")
public class SpeakingCloakController {

    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("{timeInNumber}")
    public ResponseEntity<String> getConvertedTimingInWords(@PathVariable String timeInNumber){
        return new ResponseEntity<>(speakingClockService.getConvertedTimingInWords(timeInNumber), HttpStatus.OK);
    }
}
