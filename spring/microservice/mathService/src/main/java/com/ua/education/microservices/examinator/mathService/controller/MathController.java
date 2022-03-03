package com.ua.education.microservices.examinator.mathService.controller;

import com.ua.education.microservices.examinator.mathService.model.Question;
import com.ua.education.microservices.examinator.mathService.services.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @GetMapping("/questions")
    public List<Question> getRandomQuestion(@RequestParam int amount) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandom());
        }
        return questions;
    }
}
