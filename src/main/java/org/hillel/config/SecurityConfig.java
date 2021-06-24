package org.hillel.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and().formLogin(Customizer.withDefaults());
        http.authorizeRequests()
                .antMatchers("/tl/vehicles").permitAll()
                .anyRequest().authenticated().and().formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());  // it means we can invoke others methods from another appl.
    }
}
