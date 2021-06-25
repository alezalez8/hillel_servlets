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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and().formLogin(Customizer.withDefaults());
        http.authorizeRequests()
                .antMatchers("/tl/vehicles").hasRole("VIEW_VEHICLES")
                .antMatchers("/tl/vehicles/delete/*").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/tl/vehicles/save/").hasAnyRole("ADMIN", "VIEW_VEHICLES")
                .antMatchers("/tl/vehicles/save/").hasAnyRole("VIEW_VEHICLES")
                .anyRequest().authenticated().and()
                .formLogin().defaultSuccessUrl("/tl/vehicles").and()  // loginPage()
                .httpBasic(Customizer.withDefaults());  // it means we can invoke others methods from another appl.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // use only for learning and testing
    }*/




    // for users and passwords in DB, and DB is created by me
    /*@Bean
    public UserDetailsService userDetailsServiceInDB(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if (!manager.userExists("admin")) {
            manager.createUser(User.withUsername("admin").password("123").roles("ADMIN", "TICKET").build());
        }
        if (!manager.userExists("test")) {
            manager.createUser(User.withUsername("test").password("test").authorities("ROLE_TICKET").build());
        }
        return manager;
    }*/

   /* @Bean
    public UserDetailsService userDetailsServiceInMemory() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password("123").roles("ADMIN", "TICKET").build(),
                User.withUsername("test").password("test").authorities("ROLE_TICKET").build()); // the same as roles("TICKET")
    }*/

}