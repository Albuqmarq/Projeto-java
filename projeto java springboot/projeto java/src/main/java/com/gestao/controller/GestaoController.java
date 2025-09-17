package com.gestao.controller;

import com.gestao.service.GestaoService;
import com.gestao.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestao")
@RequiredArgsConstructor
public class GestaoController {

    private final GestaoService gestaoService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UserResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(gestaoService.listarUsuarios());
    }

    @GetMapping("/relatorios")
    public ResponseEntity<String> gerarRelatorio() {
        return ResponseEntity.ok(gestaoService.gerarRelatorio());
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboard() {
        return ResponseEntity.ok("Dashboard - Acesso liberado para todos os perfis");
    }
}