package com.tdl.dutic2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping ("/public")
    public String publicEndpoint() {
        return "Hello world!";
    }


    @GetMapping("/success")
    public ResponseEntity<?> success(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok("Eso tilin");
    }

}