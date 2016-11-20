package com.pablo.springCRUD1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Pablo on 16.11.2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    private final DataSource dataSource;

    @Autowired
    public WebSecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    @Bean
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        AuthenticationProvider authenticationProvider;
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//            manager.
//        return
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        String userNameQuery = "SELECT User_Name, Password, enabled FROM accounts WHERE User_Name=?";
        String authenticationQuery = "SELECT User_Name, User_Role FROM accounts WHERE User_Name=?";

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userNameQuery)
                .authoritiesByUsernameQuery(authenticationQuery);
//             .withUser("Pablo").password("god").roles("USER").and()
//                .withUser("Pablo").password("esc").roles("USER", "ADMIN");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/client")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout");
    }
}
