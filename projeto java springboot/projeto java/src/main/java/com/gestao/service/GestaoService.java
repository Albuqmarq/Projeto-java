package com.gestao.service;

import com.gestao.dto.UserResponseDTO;
import com.gestao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestaoService {

    private final UserRepository userRepository;

    public List<UserResponseDTO> listarUsuarios() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getRoles().stream()
                        .map(role -> role.getName())
                        .collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
    }

    public String gerarRelatorio() {
        long totalUsuarios = userRepository.count();
        return "Relatório de Usuários - Total: " + totalUsuarios;
    }
}