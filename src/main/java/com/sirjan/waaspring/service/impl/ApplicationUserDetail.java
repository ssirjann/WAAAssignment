package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Role;
import com.sirjan.waaspring.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUserDetail implements UserDetails {
    private final String username;
    private final String password;
    private final List<GrantedAuthority> roles;

    public ApplicationUserDetail(User user) {
        username = user.getUsername();
        password = user.getPassword();
        roles = user.getRoles().stream().map(x -> new SimpleGrantedAuthority(x.getTitle())).collect(Collectors.toList());;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
