package org.auctionproject.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by bishal on 3/28/17.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("username1")
                .password("password")
                .roles("USER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/homeView.jsp")
//                .defaultSuccessUrl("/")
//                .failureUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
        http.authorizeRequests()
                .antMatchers("/**")
                    .hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/dash").failureUrl("/login")
//                    .usernameParameter("username").passwordParameter("password")
                .and()
                    .logout()
                    .logoutSuccessUrl("/");

//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll();
    }
}