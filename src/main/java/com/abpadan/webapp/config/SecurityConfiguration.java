package com.abpadan.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.defaultSuccessUrl("/maintenancesessions/", true)
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}
