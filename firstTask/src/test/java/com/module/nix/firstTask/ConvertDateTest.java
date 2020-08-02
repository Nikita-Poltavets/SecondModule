package com.module.nix.firstTask;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertDateTest {

    @Test
    void convertAnyDate() throws ParseException {
        String dateToConvert = "01-APR-2020";
        String convertedDate = "20200401";
        List<String> list = new ArrayList<>();
        list.add(dateToConvert);
        assertEquals(convertedDate, ConvertDate.convertAnyDate(list).get(0));
    }
}