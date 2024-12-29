package com.tdl.dutic2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/public")
    @ResponseBody
    public String publicEndpoint() {
        return "Hello world!";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error() {
        return "Error tonoto";
    }

    @GetMapping("/success")
    public ResponseEntity<?> success(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok(principal.getAttributes());
    }

    @GetMapping("/logout-success")
    @ResponseBody
    public String logout() {
        return "Logged out successfully";
    }
}
