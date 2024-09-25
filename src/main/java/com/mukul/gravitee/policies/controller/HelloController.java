package com.mukul.gravitee.policies.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);
    int count = 0;

    @GetMapping("/hello")
    public String hello() {
        logger.info("Hello API Hit");
        return "Greetings from Mukul!";
    }

    @GetMapping("/retryAfter3")
    public ResponseEntity<String> retryAfter3() {
        logger.info("Rety API Hit");

        if (count == 3) {

            logger.info("Retry count is 3");
            count++;

            return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        }

        count++;
        logger.info("Count is " + count);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>("Give "+(4-count)+" attempts", HttpStatus.BAD_REQUEST);
    }

}
