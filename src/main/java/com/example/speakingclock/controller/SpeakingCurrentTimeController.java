package com.example.speakingclock.controller;

import com.example.speakingclock.service.SpeakingCurrentTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("current-clock")
@Api(value="users", description="Endpoint for user management")
public class SpeakingCurrentTimeController {

    @Autowired
    private SpeakingCurrentTimeService speakingCurrentTimeService;

    @ApiOperation(value = "Gets Current Time", notes = "Gets Current Time")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful response"),
            @ApiResponse(code = 404, message = "Schema not found"),
            @ApiResponse(code = 400, message = "Missing or invalid request/request body"),
            @ApiResponse(code = 500, message = "Internal error")})
    @GetMapping
    public ResponseEntity<String> getCurrentTimingInWords(){
        return new ResponseEntity<>(speakingCurrentTimeService.getCurrentTimingInWords(), HttpStatus.OK);
    }
}
