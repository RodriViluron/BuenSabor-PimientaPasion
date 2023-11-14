package com.PimientaPasion.Sprint4.Auth;

import com.PimientaPasion.Sprint4.JWT.JwtService;
import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.entities.Usuario;
import com.PimientaPasion.Sprint4.enums.Rol;
import com.PimientaPasion.Sprint4.repositories.ClienteRepository;
import com.PimientaPasion.Sprint4.repositories.UsuarioRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository clienteRepository;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())); //springsecurity
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder() //DTO
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        //Creo el usuario
        Usuario user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.CLIENTE)
                .build();

        //Guardo el usuario
        userRepository.save(user);

        // Crear el Cliente y asociarlo al Usuario
        Cliente cliente = Cliente.builder()
                .nombre(request.getFirstname())
                .apellido(request.getLastname())
                .email(request.getEmail())
                .telefono(request.getTelefono())
                .usuario(user)  // Asociar el Usuario recién creado al Cliente
                .build();

        // Guardar el Cliente en la base de datos
        clienteRepository.save(cliente);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}
