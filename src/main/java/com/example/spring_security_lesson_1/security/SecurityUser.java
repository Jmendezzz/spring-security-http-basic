package com.example.spring_security_lesson_1.security;

import com.example.spring_security_lesson_1.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
  private final User user;

  @Override
  public String getUsername() {
    return user.getUsername();
  }
  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override // This method is used to get the authorities of the user, which is a list of GrantedAuthority objects.
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getAuthorities()
                .stream()
                .map(SecurityAuthority::new)
                .toList();
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
