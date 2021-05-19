package com.example.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@SpringBootApplication
public class Oauth2SecurityApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SecurityApplication.class, args);
	}
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
           return super.authenticationManagerBean();
    }
   
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
       
        UserDetails user=User.builder().username("user").password(passwordEncoder().encode("secret")).
                roles("USER").build();
        UserDetails userAdmin=User.builder().username("admin").password(passwordEncoder().encode("secret")).
                roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,userAdmin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new  BCryptPasswordEncoder();
    }

}
