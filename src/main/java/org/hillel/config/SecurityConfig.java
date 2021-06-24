package org.hillel.config;

import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // use only for learning and testing
    }

   /* @Bean
    public UserDetailsService userDetailsServiceInMemory() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password("123").roles("ADMIN", "TICKET").build(),
                User.withUsername("test").password("test").authorities("ROLE_TICKET").build()); // the same as roles("TICKET")
    }*/

}
