package com.example.spring_security_lesson_1.services;

import com.example.spring_security_lesson_1.entities.User;
import com.example.spring_security_lesson_1.repositories.UserRepository;
import com.example.spring_security_lesson_1.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByUsername(username);
    return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

  }
}
