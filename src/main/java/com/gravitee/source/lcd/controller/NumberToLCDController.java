package com.gravitee.source.lcd.controller;

import com.gravitee.source.lcd.service.NumberToLCDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lcd")
public class NumberToLCDController {

    private static final Logger logger = LoggerFactory.getLogger(NumberToLCDController.class);
    private final NumberToLCDService numberToLCDService;

    public NumberToLCDController(NumberToLCDService numberToLCDService) {
        this.numberToLCDService = numberToLCDService;
    }

    @GetMapping("/{number}")
    public String getLCDRepresentation(@PathVariable String number) {
        logger.info("Received request to convert number: {}", number);
        return numberToLCDService.convertToLCD(number);
    }
}