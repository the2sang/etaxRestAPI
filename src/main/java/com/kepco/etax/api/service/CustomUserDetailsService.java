package com.kepco.etax.api.service;


import com.kepco.etax.api.exception.EtaxUserNotFoundException;
import com.kepco.etax.api.exception.UserNotFoundException;
import com.kepco.etax.api.repository.EtaxUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EtaxUserRepository etaxUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return etaxUserRepository.findById(Long.parseLong(userPk))
                .orElseThrow(EtaxUserNotFoundException::new);
    }
}

