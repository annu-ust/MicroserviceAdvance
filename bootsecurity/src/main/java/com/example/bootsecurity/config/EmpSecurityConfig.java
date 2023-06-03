package com.example.bootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{
//setting up the environment by configuration of resources
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		//in memory authentication
		//the credentials will be stored in program cache
		auth.inMemoryAuthentication().withUser("bond")
		.password("james").roles("USER").and().withUser("poo")
		.password("bear").roles("ADMIN");
	}
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		//who can access which end points
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/").permitAll().and().formLogin();
	}
}
