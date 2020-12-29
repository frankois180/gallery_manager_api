package com.wolox.gallery.infrastructure.config;


import com.wolox.gallery.infrastructure.adapter.UserDetailsAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsAdapter userDetailsAdapter;
    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsAdapter userDetailsAdapter,
                          BCryptPasswordEncoder passwordEncoder) {

        this.userDetailsAdapter = userDetailsAdapter;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/v1/users","/v1/photos/**", "/v1/albums", "/v1/comments", "/h2_console/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsAdapter)
                .passwordEncoder(passwordEncoder);

    }
}
