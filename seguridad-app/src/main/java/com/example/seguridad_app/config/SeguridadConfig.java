package com.example.seguridad_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/publico").permitAll()  // Permite acceso libre a /publico
                        .anyRequest().authenticated()  // Protege todas las demás rutas
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/privado", true)  // Redirige a /privado tras iniciar sesión
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/publico")  // Redirige a /publico después de cerrar sesión
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario = User.withDefaultPasswordEncoder()
                .username("usuario")
                .password("contraseña")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(usuario);
    }
}
