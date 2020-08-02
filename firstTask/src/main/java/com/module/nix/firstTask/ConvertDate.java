package com.module.nix.firstTask;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ConvertDate {

    public static List<String> convertAnyDate(List<String> list) throws ParseException {


        DateTimeFormatter patterns = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("MM-dd-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))
                .toFormatter(Locale.ENGLISH);

        return list
                .stream()
                .map(s -> LocalDate.parse(s, patterns).toString())
                .map(s -> s.replaceAll("-", ""))
                .collect(Collectors.toList());
    }

}
