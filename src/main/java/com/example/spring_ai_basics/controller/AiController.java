package com.example.spring_ai_basics.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class AiController {
    private final ChatClient chatClient;

    @GetMapping("/ask")
    public ResponseEntity<Flux<String>> ask(@RequestParam String prompt) {
        var chatResponse = chatClient.prompt(prompt)
                .stream()
                .content();

        return ResponseEntity.ok(chatResponse);
    }

}
