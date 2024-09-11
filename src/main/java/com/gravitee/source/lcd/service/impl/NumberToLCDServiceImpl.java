package com.gravitee.source.lcd.service.impl;

import com.gravitee.source.lcd.service.NumberToLCDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NumberToLCDServiceImpl implements NumberToLCDService {

    private static final Logger logger = LoggerFactory.getLogger(NumberToLCDService.class);

    private static final Map<Character, String[]> LCD_MAP = new HashMap<>();

    static {
        LCD_MAP.put('0', new String[]{" _ ", "| |", "|_|"});
        LCD_MAP.put('1', new String[]{"   ", "  |", "  |"});
        LCD_MAP.put('2', new String[]{" _ ", " _|", "|_ "});
        LCD_MAP.put('3', new String[]{" _ ", " _|", " _|"});
        LCD_MAP.put('4', new String[]{"   ", "|_|", "  |"});
        LCD_MAP.put('5', new String[]{" _ ", "|_ ", " _|"});
        LCD_MAP.put('6', new String[]{" _ ", "|_ ", "|_|"});
        LCD_MAP.put('7', new String[]{" _ ", "  |", "  |"});
        LCD_MAP.put('8', new String[]{" _ ", "|_|", "|_|"});
        LCD_MAP.put('9', new String[]{" _ ", "|_|", " _|"});
    }

    @Override
    public String convertToLCD(String number) {
        logger.debug("Converting number: {} to LCD format", number);

        StringBuilder[] lines = {new StringBuilder(), new StringBuilder(), new StringBuilder()};
        for (char digit : number.toCharArray()) {
            String[] lcd = LCD_MAP.getOrDefault(digit, new String[]{"???", "???", "???"}); // Handle invalid input
            for (int i = 0; i < 3; i++) {
                lines[i].append(lcd[i]).append(" ");
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder line : lines) {
            result.append(line.toString()).append("\n");
        }

        return result.toString();
    }
}
