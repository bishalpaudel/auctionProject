package org.auctionproject.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.sql.DataSource;

/**
 * Created by bishal on 3/28/17.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT userName, password, id FROM USER_CREDENTIAL WHERE userName = ?")
                .authoritiesByUsernameQuery("SELECT userName, role FROM USER_CREDENTIAL WHERE userName = ?");
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
          http
                  .csrf().csrfTokenRepository(csrfTokenRepository())
                  .and()
                  .authorizeRequests()
                    .antMatchers("/", "/login").permitAll()
                    .antMatchers("/my-profile").hasAuthority("USER")
                  .and()
                  .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/my-profile")
                  .and()
                  .logout()
                    .logoutSuccessUrl("/home")
                    .deleteCookies("JSESSIONID");
    }


    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
