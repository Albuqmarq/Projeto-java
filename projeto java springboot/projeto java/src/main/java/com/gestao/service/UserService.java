package com.gestao.service;

import com.gestao.dto.LoginDTO;
import com.gestao.dto.RegisterDTO;
import com.gestao.model.Role;
import com.gestao.model.User;
import com.gestao.repository.RoleRepository;
import com.gestao.repository.UserRepository;
import com.gestao.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(RegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role USER não encontrada"));
        user.getRoles().add(role);

        userRepository.save(user);
    }

    public String login(LoginDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRoles());
    }
}