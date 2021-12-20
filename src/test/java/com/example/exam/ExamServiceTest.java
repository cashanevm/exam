package com.example.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class ExamServiceTest {

    ExamService examService = new ExamService();

    @Test
    void whenThenSuccess1() {
        String PARAM_1 = "21-05";

        String actualResult = examService.doThat(PARAM_1);

        String expectedResult = "Result: 21";
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void whenThenSuccess2() {
        String PARAM_1 = "invalid_date";

        String actualResult = examService.doThat(PARAM_1);

        String expectedResult = "Result: 0";
        assertEquals(actualResult, expectedResult);
    }
}
