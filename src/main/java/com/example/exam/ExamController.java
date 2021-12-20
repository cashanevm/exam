package com.example.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("21-05-2002");
    }

    @GetMapping("/{param1}/{param2}")
    public ResponseEntity<?> takeResult(@PathVariable String param1, @PathVariable String param2) {
        return ResponseEntity.ok(examService.doThat(param1 + "-" + param2));
    }
}
