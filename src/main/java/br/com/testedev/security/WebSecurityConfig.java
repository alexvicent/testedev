package br.com.testedev.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.
                        authorizeRequests()
                        .antMatchers("/webjars/**").permitAll()
                        .antMatchers("/categorias/cadastro").hasAnyRole("MASTER")
                        .anyRequest()
                        .authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and()
                        .logout()
                        .permitAll()
                        .and()
                        .rememberMe();
            }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
            builder
                    .inMemoryAuthentication()
                    .withUser("Luiz").password("$2a$10$CrR7.WAMlNCh7PQxFVSx9.RwakInCVAjqvm3CsipKc/n7XCL7DYKK").roles("MASTER")
                    .and()
                    .withUser("Ana").password("$2a$10$CrR7.WAMlNCh7PQxFVSx9.RwakInCVAjqvm3CsipKc/n7XCL7DYKK").roles("FUNCIONARIO");
        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    }

