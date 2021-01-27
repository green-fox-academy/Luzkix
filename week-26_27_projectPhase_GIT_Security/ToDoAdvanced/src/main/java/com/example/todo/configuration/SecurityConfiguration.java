package com.example.todo.configuration;

import com.example.todo.configuration.jwt.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  JwtFilter jwtFilter;
  public SecurityConfiguration(JwtFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/admin/*").hasRole("ADMIN") //!!Not ROLE_ADMIN but just ADMIN (ROLE_ is added automatically)
        .antMatchers("/user/*").hasRole("USER")
        .antMatchers("/newTodo","/listTodos","/updateTodo").hasAnyRole("ADMIN","USER")
        .antMatchers("/registration", "/login").permitAll() //permits these endpoints to all
        .and()
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
