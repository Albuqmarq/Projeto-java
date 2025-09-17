package com.gestao.controller;

import com.gestao.dto.LoginDTO;
import com.gestao.dto.RegisterDTO;
import com.gestao.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto) {
        userService.register(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        String token = userService.login(dto);
        return ResponseEntity.ok(token);
    }
}