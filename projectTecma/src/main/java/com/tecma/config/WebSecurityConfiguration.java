package com.tecma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tecma.services.UserDetailsServiceImpl;


@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {   
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.anonymous()
			.and()
			.authorizeRequests()			
			.antMatchers("/admin/**").authenticated()
			// .antMatchers("/users/**").authenticated()
			.antMatchers("/**").permitAll();
		
		http
			.formLogin()
			.loginPage("/login")
			.permitAll().and()
			//.and().rememberMe().key(rememberMeKey).rememberMeServices(rememberMeServices()).and()
			.logout()
			.permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}