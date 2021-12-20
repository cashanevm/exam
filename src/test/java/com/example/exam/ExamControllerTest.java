package com.example.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExamControllerTest {
    @InjectMocks
    ExamController mainController;

    @Mock
    ExamService mainService;

    private MockMvc mockMvc;

    private static final String HELLO_PATH = "/";
    private static final String METHOD_PATH = "/12/12";


    @BeforeEach
    void setAll() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void whenHelloThenSuccess() throws Exception {
        mockMvc.perform(get(HELLO_PATH))
                .andExpect(status().isOk());
    }

    @Test
    void wheTakeResultThenSuccess() throws Exception {
        when(mainService.doThat(any())).thenReturn("mock_result");
        mockMvc.perform(get(METHOD_PATH))
                .andExpect(status().isOk());
    }
}
