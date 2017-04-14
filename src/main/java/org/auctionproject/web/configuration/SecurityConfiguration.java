package org.auctionproject.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
          http
                  /*TODO: ENABLE CSRF FOR FILE UPLOAD*/
                  /*.csrf().csrfTokenRepository(csrfTokenRepository())*/
                  .csrf().disable()
                  .authorizeRequests()
                    .antMatchers("/",
                            "/images/**",
                            "/login",
                            "/resource/**",
                            "/register",
                            "/products").permitAll()
                  .antMatchers("/**").authenticated()
//                  .antMatchers("/my-profile", "/products/create").hasAuthority("USER")
                  .and()
                  .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/my-profile")
                  .and()
                  .logout()
                    .logoutSuccessUrl("/home")
                    .deleteCookies("JSESSIONID");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT userName, password, id FROM User WHERE userName = ?")
                .authoritiesByUsernameQuery("SELECT u.userName, r.name " +
                        "FROM User u " +
                        "INNER JOIN UserRole ur ON u.id=ur.user_id " +
                        "INNER JOIN Role r ON r.id=ur.role_id " +
                        "WHERE userName = ?");
    }


    private CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
