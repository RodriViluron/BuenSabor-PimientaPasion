package com.PimientaPasion.BuenSabor.Config;


import com.PimientaPasion.BuenSabor.JWT.JwtAuthenticationFilter;
import com.PimientaPasion.BuenSabor.enums.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest

                                //Autorizacion de acceso a la url:
                                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/**")).hasAuthority(Rol.ADMINISTRADOR.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/usuarios/**")).hasAnyAuthority("CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes/**")).hasAnyAuthority("CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/empleados/**")).hasAnyAuthority("CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/domicilios/**")).hasAnyAuthority(Rol.CLIENTE.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/facturas/**")).hasAnyAuthority(Rol.CLIENTE.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/**")).hasAnyAuthority(Rol.CLIENTE.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/ingredientes/**")).hasAnyAuthority(Rol.CLIENTE.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/**")).hasAnyAuthority(Rol.CLIENTE.name())
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/rubroProductos/**")).hasAnyAuthority(Rol.CLIENTE.name())

                                .requestMatchers(new AntPathRequestMatcher("/api/v2/demoAdmin/**")).hasAuthority("CLIENTE")
                                .requestMatchers(new AntPathRequestMatcher("/api/v2/demoUser/**")).hasAuthority("CLIENTE")




                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }
}
