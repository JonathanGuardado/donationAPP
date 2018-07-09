package com.test.donation_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/save","/user/login", "/user/signup","/welcome","/css/**","/js/**","/img/**").permitAll()
		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		.and().formLogin()  
        .loginPage("/user/login")
        .loginProcessingUrl("/app-login")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/donation/new")	
		.and().logout()    
		.logoutUrl("/user/logout") 
		.logoutSuccessUrl("/user/login")
		.and().exceptionHandling() 
		.accessDeniedPage("/welcome");
	}
	
	  @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}
	
}
