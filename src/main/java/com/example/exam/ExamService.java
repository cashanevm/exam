package com.example.exam;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Service
public class ExamService {
    public String doThat(String a) {
        int weekNumber;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date3 = a + "-2021";

        try {
            LocalDate date = LocalDate.parse(date3, formatter);

            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            weekNumber = date.get(weekFields.weekOfWeekBasedYear());

        } catch (DateTimeParseException e) {
            weekNumber = 0;
        }
        return "Result: " + weekNumber;
    }
}
