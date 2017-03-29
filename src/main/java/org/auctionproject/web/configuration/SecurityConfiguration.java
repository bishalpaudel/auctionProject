package org.auctionproject.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * Created by bishal on 3/28/17.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
          http
                  .csrf().csrfTokenRepository(csrfTokenRepository())
                  .and()
                  .authorizeRequests()
                  .antMatchers("/login").permitAll()
                  .antMatchers("/", "/home").access("hasRole('USER')")
                  .and()
                  .formLogin().loginPage("/getlogin").defaultSuccessUrl("/home").failureUrl("/getlogin")
                  .and()
                  .logout().logoutSuccessUrl("/home");
//                  .and().csrf().csrfTokenRepository(csrfTokenRepository());


       /* http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                *//*.loginPage("/login")*//*
                .and()
                .httpBasic();*/
    }


    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
