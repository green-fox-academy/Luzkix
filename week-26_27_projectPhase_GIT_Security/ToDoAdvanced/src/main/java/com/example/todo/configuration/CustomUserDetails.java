package com.example.todo.configuration;

import com.example.todo.models.TodoOwner;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
  private String login;
  private String password;
  private Collection<? extends GrantedAuthority> grantedAuthorities;

  public static CustomUserDetails fromTodoOwnerToCustomUserDetails(TodoOwner todoOwner){
    CustomUserDetails c = new CustomUserDetails();
    c.login = todoOwner.getLogin();
    c.password = todoOwner.getPassword();
    c.grantedAuthorities= Collections.singleton(new SimpleGrantedAuthority(todoOwner.getRole().getName()));
    return c;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
