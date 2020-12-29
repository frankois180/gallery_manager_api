package com.wolox.gallery.infrastructure.adapter;


import com.wolox.gallery.domain.exception.UnexpectedException;
import com.wolox.gallery.infrastructure.adapter.repository.jpa.UserJpaRepository;
import com.wolox.gallery.infrastructure.adapter.repository.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.wolox.gallery.domain.exception.GalleryNotificationCode.ACCESS_DENIED;

@Component
public class UserDetailsAdapter implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public UserDetailsAdapter(UserJpaRepository userJpaRepository) {

        this.userJpaRepository = userJpaRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userJpaRepository.findByUserName(username)
                .orElseThrow(() -> new UnexpectedException(ACCESS_DENIED));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRol().getName()));

        return new User(username, userEntity.getPassword(), authorities);

    }

}
