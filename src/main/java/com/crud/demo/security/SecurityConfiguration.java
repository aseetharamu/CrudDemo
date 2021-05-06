package com.crud.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
 * @EnableWebSecurity public class SecurityConfiguration extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { // Set your configuration on the auth object
 * auth.inMemoryAuthentication().withUser("user").password("pwd").roles("USER").
 * and().withUser("root") .password("root").roles("ADMIN"); }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Bean public PasswordEncoder getPasswordEncoder() { return
 * NoOpPasswordEncoder.getInstance();
 * 
 * }
 * 
 * //what autorization for delete and post
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests() // // //
 * //.antMatchers("/**").hasRole("USER").and().formLogin()
 * .antMatchers("/listNames").hasRole("ADMIN")
 * .antMatchers("lsitEmpById/{id}").hasAnyRole("USER", "ADMIN")
 * .antMatchers("/employee/listAll").permitAll().and().formLogin();
 * 
 * } }
 */
  
  @EnableWebSecurity public class SecurityConfiguration extends
  WebSecurityConfigurerAdapter {
  
  @Override protected void configure(HttpSecurity http) throws Exception {
  http.authorizeRequests() .anyRequest().authenticated() .and() .oauth2Login();
  } }
 
 